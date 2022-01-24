package com.findajob.jobamax.jobseeker.profile.account

 import android.app.Dialog
 import android.os.Bundle
 import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
 import android.view.Window
 import androidx.fragment.app.DialogFragment
 import androidx.recyclerview.widget.RecyclerView
 import com.findajob.jobamax.data.pojo.University
 import com.findajob.jobamax.databinding.FragmentSeekerSearchUniversityDialogBinding
  import com.findajob.jobamax.databinding.ItemSeekerSearchUniversityBinding
 import com.findajob.jobamax.enums.ParseTableName
 import com.findajob.jobamax.util.loadImageFromUrl
 import com.findajob.jobamax.util.toast
 import com.parse.ParseObject
 import com.parse.ParseQuery

class SeekerSearchUniversityDialogFragment : DialogFragment() {
    lateinit var binding: FragmentSeekerSearchUniversityDialogBinding

    lateinit var adapter: SeekerSearchUniversityAdapter
    var universities = ArrayList<University>()
    var clickedItemListener: (University) -> Unit = {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        dialog?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        dialog?.actionBar?.hide()
        binding = FragmentSeekerSearchUniversityDialogBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setAdapter()
    }

    private fun setAdapter() {
         adapter = SeekerSearchUniversityAdapter(universities)
        binding.rvUniversities.adapter = adapter
        adapter.clickListener = {
            clickedItemListener(it)
            dismiss()
        }
    }

    private fun setClickListeners() {
        binding.acbtnSearch.setOnClickListener {
            if (binding.etSearchUniversity.text.isNullOrEmpty()){
                toast("Please first enter university.")
            }else{
                getUniversities { listOfPO ->
                    universities.clear()
                    listOfPO.forEach {
                        universities.add((University(it.getString("countryCode")!!,it.getString("logo")!!,it.getString("name")!!,it.getString("country")!!)))
                    }
                    adapter.submitList(universities)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    private fun getUniversities(result: (List<ParseObject>) -> Unit) {
         val query = ParseQuery<ParseObject>(ParseTableName.University.toString())
        query.whereMatches("name",  "^.*?((?i)(${binding.etSearchUniversity.text.toString()})).*$")
        query.findInBackground { res, e ->
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                else -> {
                    result(res)
                }
            }
        }
    }



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = dialog
        if (dialog != null) {
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }
    }

    companion object {
        fun newInstance(): SeekerSearchUniversityDialogFragment = SeekerSearchUniversityDialogFragment()
    }
}

class SeekerSearchUniversityAdapter(var list: ArrayList<University>) : RecyclerView.Adapter<SeekerSearchUniversityAdapter.ViewHolder>(){
    var clickListener: (University) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerSearchUniversityBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val university = list[position]
        holder.binding.apply {
            loadImageFromUrl(this.civUniversityImg, university.logo)
            this.rvUniversityName.text = university.name
            this.tvCountryName.text = university.country
            this.clParent.setOnClickListener {
                clickListener(university)
            }
        }
    }
    override fun getItemCount(): Int  = list.size
    fun submitList(universities: ArrayList<University>) {
        list = universities
    }
    class ViewHolder(val binding: ItemSeekerSearchUniversityBinding) : RecyclerView.ViewHolder(binding.root)
}