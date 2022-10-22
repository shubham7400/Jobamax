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
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.jobamax.appjobamax.DatePickerDialogFragment
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentAddNewExperienceBinding
import com.jobamax.appjobamax.databinding.ItemSearchQueryCompanyBinding
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.MMM_d_yyyy
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.Experience
import com.jobamax.appjobamax.model.ExperienceGroup
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.model.SearchQueryCompany
import com.jobamax.appjobamax.network.ApiFetchCompaniesService
import com.jobamax.appjobamax.preference.getLanguage
import com.jobamax.appjobamax.repos.SearchQueryCompanyRepo
import com.jobamax.appjobamax.util.convertCustomObjectToJsonString
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.parse.ParseException
import java.lang.Exception
import kotlin.collections.ArrayList


class AddNewExperienceFragment : BaseFragment() {
    lateinit var binding: FragmentAddNewExperienceBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()

    lateinit var searchQueryCompanyRepo: SearchQueryCompanyRepo
    var selectedCompany: SearchQueryCompany? = null
    lateinit var adapter: SearchQueryCompanySuggestionAdapter
    var canFetchList = true
    var experienceOld: Experience? = null

    lateinit var jobSeeker: JobSeeker

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddNewExperienceBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         setClickListeners()
        setAdapterFunctionality()
        initializeJobSeeker()

        arguments?.getSerializable("experience")?.let {
            experienceOld = arguments?.getSerializable("experience") as Experience
        }
        experienceOld?.let {
            canFetchList = false
            binding.etJob.setText(experienceOld!!.job)
            binding.etCompanyName.setText(experienceOld!!.company)
            binding.tvStartDate.text = experienceOld!!.location
            binding.etDescription.setText(experienceOld!!.description)
            binding.tvEndDate.text = experienceOld!!.startDate
            if (experienceOld!!.startDate != "") {
                binding.tvStartDate.text = experienceOld!!.startDate
                binding.tvEndDate.text = experienceOld!!.endDate
                if (experienceOld!!.endDate.isEmpty()){
                    binding.llEndDate.visibility = View.GONE
                    binding.cbCurrentStudent.isChecked = true
                }
            }

            binding.rvCompanySuggestions.visibility = View.GONE
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

    private fun setAdapterFunctionality() {
        adapter = SearchQueryCompanySuggestionAdapter(arrayListOf())
        binding.rvCompanySuggestions.adapter = adapter
        adapter.onCompanyClick = { company ->
            selectedCompany = company
            binding.rvCompanySuggestions.visibility = View.GONE
            canFetchList = false
            binding.etCompanyName.setText(selectedCompany?.name)
        }
        searchQueryCompanyRepo = SearchQueryCompanyRepo(ApiFetchCompaniesService.getInstance(requireContext()).create(ApiFetchCompaniesService::class.java))
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.tvStartDate.setOnClickListener {
            onDateClicked(it)
        }
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
        binding.etCompanyName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.etCompanyName.text.isNullOrEmpty()){
                    binding.rvCompanySuggestions.visibility = View.GONE
                }else{
                    if (canFetchList){
                        selectedCompany = null
                        getCompanySuggestions()
                    }
                    canFetchList = true
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
        binding.btnEdit.setOnClickListener {
            addExperience { requireActivity().onBackPressed() }
        }
        binding.llMostParent.setOnClickListener {
            binding.rvCompanySuggestions.visibility = View.GONE
        }
    }



    private fun getCompanySuggestions() {
        searchQueryCompanyRepo.getCompanies(binding.etCompanyName.text.toString()){ list ->
            if (list.isEmpty()){
                binding.rvCompanySuggestions.visibility = View.GONE
            }else{
                adapter.submitList(list)
                binding.rvCompanySuggestions.visibility = View.VISIBLE
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

    private fun addExperience(callback: () -> Unit) {
        when {
            binding.etJob.text.isNullOrEmpty() -> {
                toast("Please enter job.")
                callback()
            }
            else -> {
                val experience = if (experienceOld == null) {
                    Experience()
                } else {
                    experienceOld
                }
                experience!!.job = binding.etJob.text.toString()
                experience.company = selectedCompany?.name ?: binding.etCompanyName.text.toString()
                experience.description = binding.etDescription.text.toString()
                experience.startDate = binding.tvStartDate.text.toString()
                experience.endDate = binding.tvEndDate.text.toString()
                experience.logo = selectedCompany?.logo ?: ""
                viewModel.addAndUpdateExperience(experience) {
                    if (it == null) {
                        toast("Experience Added.")
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
                    } else {
                        toast("${it.message.toString()} Something Went Wrong.")
                        requireActivity().onBackPressed()
                    }
                }
            }
        }
    }

    private fun addAndUpdateExperience(experience: Experience, callback: (it: ParseException?) -> Unit) {
        val experiences = jobSeeker.experiences
        experiences.add(experience)
        val experienceGroup = ExperienceGroup(experiences)
        viewModel.jobSeekerObject?.put(ParseTableFields.EXPERIENCES.value, gson.toJson(experienceGroup))
        viewModel.jobSeekerObject!!.saveInBackground {
            callback(it)
            try {
                (requireActivity() as BuildProfileActivity).getJobSeeker { }
            }catch (e: Exception){
                try {
                    (requireActivity() as SeekerCreateCvActivity).getJobSeeker { }
                }catch (e: Exception){
                    (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker { }
                }
            }
        }
    }

}


class SearchQueryCompanySuggestionAdapter(var list: ArrayList<SearchQueryCompany>) : RecyclerView.Adapter<SearchQueryCompanySuggestionAdapter.ViewHolder>() {
    var onCompanyClick: (SearchQueryCompany) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemSearchQueryCompanyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            this.tvCompanyName.text = item.name
            this.tvCompanyDomain.text = item.domain
            loadImageFromUrl(this.civCompanyLogo, item.logo, R.drawable.ic_company)
            this.clMostParent.setOnClickListener {
                onCompanyClick(item)
            }
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(suggestions: ArrayList<SearchQueryCompany>) {
        this.list = suggestions
    }

    class ViewHolder(val binding: ItemSearchQueryCompanyBinding) : RecyclerView.ViewHolder(binding.root)
}
