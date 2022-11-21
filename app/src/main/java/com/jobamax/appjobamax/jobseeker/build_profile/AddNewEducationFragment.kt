package com.jobamax.appjobamax.jobseeker.build_profile

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.jobamax.appjobamax.DatePickerDialogFragment
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentAddNewEducationBinding
import com.jobamax.appjobamax.dialog.BasicDialog
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.jobseeker.dialog.SeekerSearchUniversityAdapter
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.MMM_d_yyyy
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.Education
import com.jobamax.appjobamax.model.EducationGroup
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.model.University
import com.jobamax.appjobamax.preference.getLanguage
import com.parse.ParseObject
import com.parse.ParseQuery
import java.lang.Exception


class AddNewEducationFragment : BaseFragment() {
    lateinit var binding: FragmentAddNewEducationBinding

    private var educationOld: Education? = null
    var university: University? = null
    var canFetchList = true
    lateinit var adapter: SeekerSearchUniversityAdapter

    var jobSeeker: JobSeeker? = null

    val viewModel: SeekerHomeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddNewEducationBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        initializeJobSeeker()
        arguments?.getSerializable("education")?.let {
            educationOld = arguments?.getSerializable("education") as Education
        }
        educationOld?.let {
            binding.btnEdit.text = "MODIFIER"
            canFetchList = false
            binding.etSchool.setText(educationOld!!.name)
            binding.etProgram.setText(educationOld!!.program)
            binding.etDescription.setText( educationOld!!.description)
            binding.tvStartDate.text = educationOld!!.startDate
            if (educationOld!!.startDate != "") {
                binding.tvStartDate.text = educationOld!!.startDate
                binding.tvEndDate.text = educationOld!!.endDate
                if (educationOld!!.endDate.isEmpty()){
                    binding.llEndDate.visibility = View.GONE
                    binding.cbCurrentStudent.isChecked = true
                }
            }
            binding.rvUniversities.visibility = View.GONE
            binding.tvDescription.text = "${educationOld!!.description.length}/1500"
        }
    }

    private fun initializeJobSeeker() {
        jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null) {
            (requireActivity() as BuildProfileActivity).getJobSeeker {
                if (it) {
                    jobSeeker = viewModel.jobSeeker
                }
            }
        }
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.tvStartDate.setOnClickListener {
            onDateClicked(it)
        }
        binding.etDescription.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tvDescription.text = "${binding.etDescription.text.toString().length}/1500"
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
        binding.tvEndDate.setOnClickListener {
            onDateClicked(it)
        }
        binding.cbCurrentStudent.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                binding.llEndDate.visibility = View.INVISIBLE
            }else{
                binding.llEndDate.visibility = View.VISIBLE
            }
        }
        binding.btnEdit.setOnClickListener {
            saveEducation()
        }
        binding.llMostParent.setOnClickListener {
            binding.rvUniversities.visibility = View.GONE
        }
        binding.etSchool.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.etSchool.text.isNullOrEmpty()){
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

        setAdapterFunctionality()

    }

    private fun setAdapterFunctionality() {
        adapter = SeekerSearchUniversityAdapter(arrayListOf())
        binding.rvUniversities.adapter = adapter
        adapter.clickListener = { company ->
            university = company
            binding.rvUniversities.visibility = View.GONE
            canFetchList = false
            binding.etSchool.setText(university?.name)
        }
    }

    private fun getUniversities(result: (List<ParseObject>) -> Unit) {
        val query = ParseQuery<ParseObject>(ParseTableName.UNIVERSITY.value)
        query.whereMatches("name",  "^.*?((?i)(${binding.etSchool.text})).*$")
        query.findInBackground { res, e ->
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                else -> {
                    result(res)
                }
            }
        }
    }

    private fun saveEducation() {
        when {
            binding.etSchool.text.isNullOrEmpty() -> {
                BasicDialog(requireActivity(), "Le nom de l'école ne peut pas être empty"){}.show()
            }
            binding.etProgram.text.isNullOrEmpty() -> {
                BasicDialog(requireActivity(), "Le nom de programme ne peut pas être empty"){}.show()
            }
            else -> {
                if (jobSeeker != null){
                    if (educationOld != null){
                        if (jobSeeker!!.educations.find { it.id == educationOld!!.id } != null){
                            jobSeeker!!.educations.find { it.id == educationOld!!.id }?.apply {
                                this.name = binding.etSchool.text.toString()
                                this.program = binding.etProgram.text.toString()
                                this.description = binding.etDescription.text.toString()
                                this.startDate = binding.tvStartDate.text.toString()
                                this.logo = university?.logo ?: ""
                                if (binding.cbCurrentStudent.isChecked){
                                    this.endDate =  ""
                                }else{
                                    this.endDate =  binding.tvEndDate.text.toString()
                                }
                            }
                            // update education here
                            addOrUpdateEducation()
                        }
                    }else{
                        val education = Education()
                        education.apply {
                            this.name = binding.etSchool.text.toString()
                            this.program = binding.etProgram.text.toString()
                            this.description = binding.etDescription.text.toString()
                            this.startDate = binding.tvStartDate.text.toString()
                            this.logo = university?.logo ?: ""
                            if (binding.cbCurrentStudent.isChecked){
                                this.endDate =  ""
                            }else{
                                this.endDate =  binding.tvEndDate.text.toString()
                            }
                        }
                        jobSeeker!!.educations.add(education)
                        // add education here
                        addOrUpdateEducation()
                    }

                }else{
                    toast("Something Went Wrong.")
                }
            }
        }
    }

    private fun addOrUpdateEducation() {
        val educationGroup = if (jobSeeker!!.educations.isEmpty()){
            EducationGroup(arrayListOf())
        }else{
            EducationGroup(jobSeeker!!.educations)
        }
        viewModel.jobSeekerObject?.put(ParseTableFields.EDUCATIONS.value, gson.toJson(educationGroup))
        progressHud.show()
        viewModel.jobSeekerObject!!.saveInBackground {
            progressHud.dismiss()
            if (it == null){
                try {
                    (requireActivity() as BuildProfileActivity).getJobSeeker { }
                }catch (e: Exception){
                    try {
                        (requireActivity() as SeekerCreateCvActivity).getJobSeeker { }
                    }catch (e: Exception){
                        (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker { }
                    }
                }
                requireActivity().onBackPressed()
            }else{
                toast("${it.message.toString()} Something went wrong")
                requireActivity().onBackPressed()
            }
        }
    }


    private fun onDateClicked(view: View ) {
        val datePickerDialogFragment = DatePickerDialogFragment()
        datePickerDialogFragment.show(childFragmentManager, "datePicker")
        datePickerDialogFragment.selectedDate = { date ->
            (view as TextView).text = date.MMM_d_yyyy(requireContext().getLanguage())
        }
    }

}