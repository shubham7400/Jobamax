package com.jobamax.appjobamax.jobseeker.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.DailogChangeUniversityBinding
import com.jobamax.appjobamax.databinding.ItemSeekerSearchUniversityBinding
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.build_profile.BuildProfileActivity
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.model.University
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.android.synthetic.main.dailog_change_university.*


class DialogChangeUniversity(var activity: Activity)  : Dialog(activity, R.style.DialogSlideAnim) {
    lateinit var binding: DailogChangeUniversityBinding

    val gson = Gson()

    var onDoneClick: (University) -> Unit = {}

    var university: University? = null
    var canFetchList = true
    lateinit var adapter: SeekerSearchUniversityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
    }

    private fun initViews() {
        setUpDialogView()
        setAdapterFunctionality()
        university = try {
            gson.fromJson((activity as BuildProfileActivity).viewModel.jobSeeker.university, University::class.java)
        }catch (e: Exception){
            try {
                gson.fromJson((activity as SeekerCreateCvActivity).viewModel.jobSeeker.university, University::class.java)
            }catch (e: Exception){
                gson.fromJson((activity as ManualAndPersonalizeActivity).viewModel.jobSeeker.university, University::class.java)
            }
        }
         if (university != null) {
            binding.etUniversity.setText(university!!.name)
            binding.cbIsCurrent.isChecked = university!!.isCurrent
        }
    }

    private fun setUpObservers() {
        binding.tvDone.setOnClickListener {
            if (university != null) {
                university!!.isCurrent = binding.cbIsCurrent.isChecked
                onDoneClick(university!!)
            }
            dismiss()
        }
        binding.tvCancel.setOnClickListener { dismiss() }

        et_university.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.etUniversity.text.isNullOrEmpty() || binding.etUniversity.text.toString().length <= 1){
                    binding.rvUniversities.visibility = View.GONE
                }else{
                    if (canFetchList){
                        university = null
                        getUniversities {
                            val universities = arrayListOf<University>()
                            for (obj in it.iterator()){
                                universities.add(University(null, obj.getString("logo") ?: "", obj.getString("name") ?: "", null))
                            }
                            adapter.submitList(universities)
                            adapter.notifyDataSetChanged()
                            if (universities.isNotEmpty()){
                                binding.rvUniversities.visibility = View.VISIBLE
                            }
                        }
                    }
                    canFetchList = true
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun getUniversities(result: (List<ParseObject>) -> Unit) {
        val query = ParseQuery<ParseObject>(ParseTableName.UNIVERSITY.value)
        query.whereMatches("name",  "^.*?((?i)(${binding.etUniversity.text})).*$")
        query.findInBackground { res, e ->
            when {
                e != null -> {
                    activity.toast(e.message.toString())
                }
                else -> {
                    result(res)
                }
            }
        }
    }

    private fun setAdapterFunctionality() {
        canFetchList = false
        adapter = SeekerSearchUniversityAdapter(arrayListOf())
        binding.rvUniversities.adapter = adapter
        adapter.clickListener = { it ->
            university = it
            binding.rvUniversities.visibility = View.GONE
            canFetchList = false
            binding.etUniversity.setText(university?.name)
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DailogChangeUniversityBinding.inflate(LayoutInflater.from(activity), null, false)
        setContentView(binding.root)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }


}


class SeekerSearchUniversityAdapter(var list: ArrayList<University>) : RecyclerView.Adapter<SeekerSearchUniversityAdapter.ViewHolder>(){
    var clickListener: (University) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemSeekerSearchUniversityBinding.inflate(LayoutInflater.from(parent.context), parent, false))
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
