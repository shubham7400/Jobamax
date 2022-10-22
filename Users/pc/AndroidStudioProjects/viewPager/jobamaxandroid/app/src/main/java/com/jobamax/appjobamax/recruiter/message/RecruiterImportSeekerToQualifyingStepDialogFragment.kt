package com.jobamax.appjobamax.recruiter.message

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentRecruiterImportSeekerToQualifyingStepDialogBinding
import com.jobamax.appjobamax.databinding.ItemFolderSeekerBinding
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.recruiter.model.FolderSeeker
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter
import com.jobamax.appjobamax.recruiter.model.SeekerFolder
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.parse.FunctionCallback
import com.parse.ParseCloud
import org.json.JSONArray


class RecruiterImportSeekerToQualifyingStepDialogFragment : DialogFragment() {
    lateinit var binding: FragmentRecruiterImportSeekerToQualifyingStepDialogBinding

    val gson = Gson()

    private var jobOffer: JobTitleFilter? = null
    private var qualifyingStep: Int? = null
    private var seekerFolder: SeekerFolder? = null

    lateinit var folderSeekerAdapter: FolderSeekerAdapter

    private val folderSeekers = arrayListOf<FolderSeeker>()
    private val selectedFolderSeekers = arrayListOf<FolderSeeker>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        jobOffer = requireArguments().getSerializable("jobOffer") as JobTitleFilter
        qualifyingStep = requireArguments().getInt("qualifyingStep")
        seekerFolder = requireArguments().getSerializable("seekerFolder") as SeekerFolder
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRecruiterImportSeekerToQualifyingStepDialogBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setFolderSeekerAdapter()
        seekerFolder?.let { jobOffer?.let { getFolderSeekers() } }
    }

    private fun setFolderSeekerAdapter() {
        folderSeekerAdapter = FolderSeekerAdapter(arrayListOf(), requireContext())
        binding.rvFolderSeeker.adapter = folderSeekerAdapter
        folderSeekerAdapter.onFolderSeekerClick = { list ->
            selectedFolderSeekers.clear()
            list.forEach { selectedFolderSeekers.add(it) }
        }
    }

    private fun getFolderSeekers() {
        val request = hashMapOf(
            ParseTableFields.FOLDER_ID.value to seekerFolder!!.folderId,
            ParseTableFields.JOB_OFFER_ID.value to jobOffer!!.jobOfferId
        )
         ParseCloud.callFunctionInBackground(ParseCloudFunction.GET_FOLDER_SEEKERS_V2.value, request, FunctionCallback<Any> { result, e ->
                 when {
                     e != null -> {
                         toast(e.message.toString()+" Something Went Wrong.")
                     }
                     result != null -> {
                         folderSeekers.clear()
                         val jsonArray = JSONArray(gson.toJson(result))
                         for (i in 0 until jsonArray.length()){
                             folderSeekers.add(gson.fromJson(jsonArray.getJSONObject(i).toString(), FolderSeeker::class.java))
                         }
                         folderSeekerAdapter.submitList(folderSeekers)
                         folderSeekerAdapter.notifyDataSetChanged()
                     }
                     else -> { toast("Something Went Wrong")}
                 }
             }
         )
    }

    private fun setClickListeners() {
        binding.btnImport.setOnClickListener {
            importFolderSeekers()
        }
        binding.ivBackButton.setOnClickListener { dismiss() }
    }

    private fun importFolderSeekers() {
        val request = hashMapOf<String, Any>(
            ParseTableFields.FOLDER_ID.value to seekerFolder!!.folderId,
            ParseTableFields.JOB_OFFER_ID.value to jobOffer!!.jobOfferId,
            "jobSeekerIds" to ArrayList(selectedFolderSeekers.map { it.jobSeekerID }),
            "selection" to qualifyingStep!!,
            ParseTableFields.RECRUITER_ID.value to requireContext().getUserId()
        )
        ParseCloud.callFunctionInBackground(ParseCloudFunction.IMPORT_CANDIDATE_V2.value, request, FunctionCallback<Any> { result, e ->
                when {
                    e != null -> {
                        toast(e.message.toString() + " Something Went Wrong.")
                        dismiss()
                    }
                    result != null -> {
                        toast("Imported.")
                        dismiss()
                    }
                    else -> {
                        toast("Something Went Wrong")
                        dismiss()
                    }
                }
            })
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }


    companion object {
        fun newInstance(jobOffer: JobTitleFilter, qualifyingStep: Int, seekerFolder: SeekerFolder): RecruiterImportSeekerToQualifyingStepDialogFragment {
            val f = RecruiterImportSeekerToQualifyingStepDialogFragment()

            val args = Bundle()
            args.putSerializable("jobOffer", jobOffer)
            args.putSerializable("seekerFolder", seekerFolder)
            args.putInt("qualifyingStep", qualifyingStep)
            f.arguments = args
            return f
        }
    }

 }

class FolderSeekerAdapter(var list: ArrayList<FolderSeeker>, val requireContext: Context) : RecyclerView.Adapter<FolderSeekerAdapter.ViewHolder>(){
    var onFolderSeekerClick: (ArrayList<FolderSeeker>) -> Unit = {}
    var selectedFolderSeekerList = arrayListOf<FolderSeeker>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemFolderSeekerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val folderSeeker = list[position]
        holder.binding.apply {
            loadImageFromUrl(this.sivSeeker, folderSeeker.profilePicUrl, R.drawable.default_user_img)
            this.tvName.text = "${folderSeeker.firstName} ${folderSeeker.lastName}"
            this.tvJobTitle.text = folderSeeker.jobTitle
            this.clParent.setOnClickListener {
                onFolderSeekerClick(selectedFolderSeekerList)
                if (!selectedFolderSeekerList.contains(folderSeeker)){
                    selectedFolderSeekerList.add(folderSeeker)
                    this.clParent.setBackgroundColor(requireContext.resources.getColor(R.color.background_blue, null))
                }else{
                    selectedFolderSeekerList.remove(folderSeeker)
                    this.clParent.setBackgroundColor(requireContext.resources.getColor(R.color.transparent, null))
                }
            }
            if (selectedFolderSeekerList.contains(folderSeeker)){
                this.clParent.setBackgroundColor(requireContext.resources.getColor(R.color.background_blue, null))
            }
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(folderSeekers: ArrayList<FolderSeeker>) {
        list = folderSeekers
    }

    class ViewHolder(val binding: ItemFolderSeekerBinding) : RecyclerView.ViewHolder(binding.root)
}