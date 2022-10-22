package com.jobamax.appjobamax.recruiter.message

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentRecruiterChatListBinding
import com.jobamax.appjobamax.databinding.ItemRecruiterChatListBinding
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.model.Recruiter
import com.jobamax.appjobamax.model.University
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel
import com.jobamax.appjobamax.recruiter.dialog.DialogSeekerFolder
import com.jobamax.appjobamax.recruiter.dialog.FilterJobRoleWiseDialog
import com.jobamax.appjobamax.recruiter.dialog.QualifyingStepDialog
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter
import com.jobamax.appjobamax.recruiter.model.QualifyingStep
import com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker
import com.jobamax.appjobamax.util.getShader
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.jobamax.appjobamax.util.seekerSelectionSteps
import com.parse.FunctionCallback
import com.parse.ParseCloud
import org.json.JSONArray
import org.json.JSONObject


class RecruiterChatListFragment : BaseFragment() {
    lateinit var binding: FragmentRecruiterChatListBinding

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    lateinit var recruiter: Recruiter

    lateinit var recruitmentSeekerChatListAdapter: RecruiterRecruitmentSeekerChatListAdapter

    lateinit var qualifyingStepSpinnerAdapter: QualifyingStepSpinnerAdapter
    var qualifyingStepSelectionType = 0

    var showSelectJobOfferDialog = true

    private val selectionList = arrayListOf<Int>()

    private val qualifyingSteps = QualifyingStep.getQualifyingSteps()

    var isSelectedAllForSorting = false
    private val selectedRecruitmentSeekerList = arrayListOf<RecruitmentSeeker>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecruiterChatListBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        initializeRecruiter()
        binding.tvSortBy.paint.shader = getShader(binding.tvSortBy)
        setRecruitmentSeekerChatListAdapter()
        setQualifyingStepAdapter()
        if (viewModel.selectedJobTitleFilter.value != null) {
            getRecruitmentSeekers(viewModel.selectedJobTitleFilter.value!!.jobOfferId)
        }
        if (viewModel.jobTitleFilterList.value.isNullOrEmpty()) {
            getJobTitleFilterList()
        }
        setViewModelObserver()
    }

    override fun onResume() {
        super.onResume()
        if (showSelectJobOfferDialog) {
            showSelectJobOfferDialog = false
            updateJobTitle()
        }
    }

    private fun setViewModelObserver() {
        viewModel.selectedJobTitleFilter.observe(viewLifecycleOwner) {
            if (seekerSelectionSteps[binding.spQualifyingStep.selectedItem.toString()] == 0) {
                viewModel.selectedJobTitleFilter.value?.let {
                    getRecruitmentSeekers(it.jobOfferId, 0)
                }
            } else {
                binding.spQualifyingStep.setSelection(1)
            }
        }
    }

    private fun initializeRecruiter() {
        recruiter = viewModel.recruiter
        if (viewModel.recruiterObject == null) {
            (requireActivity() as RecruiterHomeActivity).getRecruiter {
                if (it) {
                    recruiter = viewModel.recruiter
                }
            }
        }
    }

    private fun getJobTitleFilterList() {
        ParseCloud.callFunctionInBackground(
            ParseCloudFunction.GET_JOB_TITLE_FILTER_V1.value,
            hashMapOf(ParseTableFields.RECRUITER_ID.value to requireContext().getUserId()),
            FunctionCallback<Any> { result, e ->
                when {
                    e != null -> {
                        toast(e.message.toString())
                    }
                    result != null -> {
                        val list = arrayListOf<JobTitleFilter>()
                        val mainObject = JSONArray(gson.toJson(result))
                        for (i in 0 until mainObject.length()) {
                            list.add(
                                gson.fromJson(
                                    mainObject.getJSONObject(i).toString(),
                                    JobTitleFilter::class.java
                                )
                            )
                        }
                        viewModel.setJobTitleFilterList(list)
                    }
                    else -> {
                        toast("Something Went Wrong.")
                    }
                }
            })
    }


    private fun getRecruitmentSeekers(jobOfferId: String, selectionType: Int = 0) {
        ParseCloud.callFunctionInBackground(
            ParseCloudFunction.GET_RECRUITMENT_SEEKERS_V2.value,
            hashMapOf(ParseTableFields.JOB_OFFER_ID.value to jobOfferId, "selection" to selectionType),
            FunctionCallback<Any> { result, e ->
                when {
                    e != null -> {
                        toast(e.message.toString())
                    }
                    result != null -> {
                        val list = arrayListOf<RecruitmentSeeker>()
                        val mainObject = JSONArray(gson.toJson(result))
                        for (i in 0 until mainObject.length()) {
                            list.add(
                                Gson().fromJson(
                                    mainObject.getJSONObject(i).toString(),
                                    RecruitmentSeeker::class.java
                                )
                            )
                        }
                        recruitmentSeekerChatListAdapter.submitList(list)
                        recruitmentSeekerChatListAdapter.notifyDataSetChanged()
                    }
                    else -> {
                        toast("Something Went Wrong.")
                    }
                }
            })
    }

    private fun setQualifyingStepAdapter() {
        val spinnerValues = arrayListOf(
            "Vos étapes :",
            "Candidatures reçues",
            "Pré-qualification",
            "Prise de contact",
            "Entretien RH",
            "Entretien Manager",
            "Sélection",
            "Refus",
            "Recrutement"
        )
        qualifyingStepSpinnerAdapter =
            QualifyingStepSpinnerAdapter(requireActivity(), R.layout.item_textview, spinnerValues)
        qualifyingStepSpinnerAdapter.item = spinnerValues[1]
        binding.spQualifyingStep.adapter = qualifyingStepSpinnerAdapter
        binding.spQualifyingStep.setSelection(1)
        binding.spQualifyingStep.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    p3: Long
                ) {
                    qualifyingStepSelectionType = try {
                        seekerSelectionSteps[spinnerValues[position]] ?: 0
                    } catch (e: Exception) {
                        0
                    }
                    viewModel.selectedJobTitleFilter.value?.let {
                        getRecruitmentSeekers(it.jobOfferId, qualifyingStepSelectionType)
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }
        qualifyingStepSpinnerAdapter.onTitleClick = {
            binding.spQualifyingStep.onDetachedFromWindow()
        }
    }

    private fun setRecruitmentSeekerChatListAdapter() {
        recruitmentSeekerChatListAdapter =
            RecruiterRecruitmentSeekerChatListAdapter(arrayListOf(), requireContext())
        binding.rvChatList.adapter = recruitmentSeekerChatListAdapter
        recruitmentSeekerChatListAdapter.onSortClick = { rs ->
            QualifyingStepDialog(requireActivity(), qualifyingSteps) { qs ->
                recruitmentSeekerChatListAdapter.selectedRecruitmentSeekers.clear()
                updateSortList(rs, qs)
            }.show()
        }
        recruitmentSeekerChatListAdapter.onChatClick = {
            val bundle = Bundle()
            bundle.putSerializable("recruitment_seeker", it)
            viewModel.selectedJobTitleFilter.value?.let { jobTitleFilter ->
                bundle.putSerializable("job_title_filter", jobTitleFilter)
            }
            val intent = Intent(requireContext(), RecruiterChatBoardActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        recruitmentSeekerChatListAdapter.onSeekerSelectionForSort = { recruitmentSeekers ->
            selectedRecruitmentSeekerList.clear()
            recruitmentSeekers.forEach { selectedRecruitmentSeekerList.add(it) }
        }
    }

    private fun updateSortList(rs: RecruitmentSeeker?, qs: QualifyingStep) {
        val request = hashMapOf<String, Any>()
        if (rs != null) {
            request["jobSeekerIds"] = arrayListOf(rs.jobSeekerId)
        } else {
            request["jobSeekerIds"] =
                ArrayList(selectedRecruitmentSeekerList.map { it.jobSeekerId })
        }
        request[ParseTableFields.JOB_OFFER_ID.value] = viewModel.selectedJobTitleFilter.value!!.jobOfferId
        request["action"] = qs.selectionValue
        ParseCloud.callFunctionInBackground(ParseCloudFunction.HANDLE_MULTIPLE_ACTION_V1.value,
            request,
            FunctionCallback<Any> { result, e ->
                when {
                    e != null -> toast(e.message.toString() + " Something Went Wrong")
                    result != null -> {
                        toast("Sorted Successfully.")
                        qualifyingStepSelectionType = try {
                            seekerSelectionSteps[binding.spQualifyingStep.selectedItem.toString()] ?: 0
                        } catch (e: Exception) {
                            0
                        }
                        viewModel.selectedJobTitleFilter.value?.let {
                            getRecruitmentSeekers(it.jobOfferId, qualifyingStepSelectionType)
                        }
                    }
                    else -> toast("Something Went Wrong.")
                }
            }
        )
    }

    private fun setClickListeners() {
        binding.tvSortBy.setOnClickListener {
            if (viewModel.selectedJobTitleFilter.value != null) {
                if (isSelectedAllForSorting) {
                    if (selectedRecruitmentSeekerList.isEmpty()) {
                        recruitmentSeekerChatListAdapter.updateRecruitmentSeekerSelection(false)
                        binding.tvSelectSeekerHint.visibility = View.GONE
                        isSelectedAllForSorting = false
                    } else {
                        QualifyingStepDialog(requireActivity(), qualifyingSteps) { qs ->
                            recruitmentSeekerChatListAdapter.selectedRecruitmentSeekers.clear()
                            recruitmentSeekerChatListAdapter.updateRecruitmentSeekerSelection(false)
                            binding.tvSelectSeekerHint.visibility = View.GONE
                            updateSortList(null, qs)
                        }.show()
                    }
                } else {
                    recruitmentSeekerChatListAdapter.updateRecruitmentSeekerSelection(true)
                    binding.tvSelectSeekerHint.visibility = View.VISIBLE
                    isSelectedAllForSorting = true
                }
                recruitmentSeekerChatListAdapter.notifyDataSetChanged()
            } else {
                toast("Please select job offer first")
            }
        }
        binding.tvEditRole.setOnClickListener {
            updateJobTitle()
        }
        binding.ivSeekerFolder.setOnClickListener {
            if (viewModel.selectedJobTitleFilter.value == null) {
                toast("Please select job offer first")
            } else {
                DialogSeekerFolder(requireActivity(), viewModel.seekerFolders.value) { seekerFolder ->
                    val importSeekerDialogFragment =
                        RecruiterImportSeekerToQualifyingStepDialogFragment.newInstance(
                            viewModel.selectedJobTitleFilter.value!!,
                            qualifyingStepSelectionType,
                            seekerFolder
                        )
                    importSeekerDialogFragment.show(
                        childFragmentManager,
                        "RecruiterImportSeekerToQualifyingStepDialogFragment"
                    )
                }.show()
            }
        }

    }

    private fun getSelectionCount() {
        ParseCloud.callFunctionInBackground(
            ParseCloudFunction.GET_SELECTION_COUNT_V1.value,
            hashMapOf(ParseTableFields.JOB_OFFER_ID.value to viewModel.selectedJobTitleFilter.value!!.jobOfferId),
            FunctionCallback<Any> { result, e ->
                when {
                    e != null -> toast(e.message.toString() + " Something went wrong.")
                    result != null -> {
                        selectionList.clear()
                        val jsonObject = JSONObject(gson.toJson(result))
                        qualifyingSteps.forEach {
                            try {
                                val title = it.title
                                it.title = "$title (${jsonObject.getInt(it.key)})"
                            } catch (e: Exception) {
                            }
                        }
                    }
                    else -> toast("Something went wrong")
                }
            })
    }

    private fun updateJobTitle() {
        FilterJobRoleWiseDialog(requireActivity(), viewModel.jobTitleFilterList.value, viewModel.selectedJobTitleFilter.value) { selectedJobTitleFilter ->
            viewModel.setSelectedJobTitleFilter(selectedJobTitleFilter)
            getSelectionCount()
        }.show()
    }

}

class RecruiterRecruitmentSeekerChatListAdapter(
    var list: ArrayList<RecruitmentSeeker>,
    val requireContext: Context
) :
    RecyclerView.Adapter<RecruiterRecruitmentSeekerChatListAdapter.ViewHolder>() {
    var onSortClick: (RecruitmentSeeker) -> Unit = {}
    var onChatClick: (RecruitmentSeeker) -> Unit = {}
    var onSeekerSelectionForSort: (ArrayList<RecruitmentSeeker>) -> Unit = {}
    val gson = Gson()

    var isRecruitmentSeekerSelected = false

    var selectedRecruitmentSeekers = arrayListOf<RecruitmentSeeker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemRecruiterChatListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            loadImageFromUrl(this.civUser, item.profileURL, R.drawable.default_user_img)
            this.tvRecruitmentSeekerName.text = "${item.firstName} ${item.lastName}"
            try {
                val university =
                    gson.fromJson(JSONObject(item.university).toString(), University::class.java)
                if (university != null) {
                    if (university.name.isEmpty()) {
                        this.tvUniversityName.visibility = View.INVISIBLE
                    } else {
                        this.tvUniversityName.text = university.name
                    }
                } else {
                    this.tvUniversityName.visibility = View.INVISIBLE
                }
            } catch (e: Exception) {
                this.tvUniversityName.visibility = View.INVISIBLE
            }

            this.tvSortBtn.setOnClickListener { onSortClick(item) }
            this.ivChat.setOnClickListener { onChatClick(item) }
            if (isRecruitmentSeekerSelected) {
                this.tvSortBtn.visibility = View.GONE
                this.clParent.setOnClickListener {
                    if (selectedRecruitmentSeekers.contains(item)) {
                        selectedRecruitmentSeekers.remove(item)
                        this.clParent.setBackgroundColor(requireContext.resources.getColor(R.color.transparent, null))
                    } else {
                        selectedRecruitmentSeekers.add(item)
                        this.clParent.setBackgroundColor(requireContext.resources.getColor(R.color.background_blue, null))
                    }
                    onSeekerSelectionForSort(selectedRecruitmentSeekers)
                }
            } else {
                this.tvSortBtn.visibility = View.VISIBLE
                selectedRecruitmentSeekers.clear()
                this.clParent.isClickable = false
                this.clParent.setBackgroundColor(requireContext.resources.getColor(R.color.transparent, null))
                onSeekerSelectionForSort(selectedRecruitmentSeekers)
            }
        }
    }

    override fun getItemCount(): Int = list.size
    fun submitList(recruitmentSeekerList: ArrayList<RecruitmentSeeker>) {
        list = recruitmentSeekerList
    }

    fun updateRecruitmentSeekerSelection(b: Boolean) {
        isRecruitmentSeekerSelected = b
    }

    class ViewHolder(val binding: ItemRecruiterChatListBinding) :
        RecyclerView.ViewHolder(binding.root)
}

class QualifyingStepSpinnerAdapter(
    private val activity: Activity,
    id: Int,
    list: ArrayList<String>
) : ArrayAdapter<String>(activity, id, list) {
    var onTitleClick: () -> Unit = {}
    var item = ""
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view as TextView
        if (position == 0) {
            tv.paint.shader = activity.getShader(tv)
            tv.textSize = 20f
            tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_up_gradient, 0)
            tv.setOnClickListener { onTitleClick() }
        } else {
            tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
            if (item == tv.text.toString()) {
                tv.setBackgroundColor(activity.resources.getColor(R.color.greyishWhite, null))
            }
        }
        return view
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view as TextView
        if (position != 0) {
            item = tv.text.toString()
        }
        return view
    }


    override fun isEnabled(position: Int): Boolean {
        super.isEnabled(position)
        return position != 0
    }
}

