package com.jobamax.appjobamax.jobseeker.build_profile

 import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.jobamax.appjobamax.DatePickerDialogFragment
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentAddNewExperienceBinding
import com.jobamax.appjobamax.databinding.ItemSearchQueryCompanyBinding
import com.jobamax.appjobamax.dialog.BasicDialog
import com.jobamax.appjobamax.enums.ParseTableFields
 import com.jobamax.appjobamax.enums.WorkType
 import com.jobamax.appjobamax.extensions.MMM_d_yyyy
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
 import com.jobamax.appjobamax.model.*
 import com.jobamax.appjobamax.network.ApiFetchCompaniesService
import com.jobamax.appjobamax.preference.getLanguage
import com.jobamax.appjobamax.repos.SearchQueryCompanyRepo
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.parse.ParseException


class AddNewExperienceFragment : BaseFragment() {
    lateinit var binding: FragmentAddNewExperienceBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()

    lateinit var searchQueryCompanyRepo: SearchQueryCompanyRepo
    var selectedCompany: SearchQueryCompany? = null
    lateinit var adapter: SearchQueryCompanySuggestionAdapter
    var canFetchList = true
    var experienceOld: Experience? = null

    var selectedWorkType = ""

    var jobSeeker: JobSeeker? = null

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
        experienceOld?.let { exp ->
            binding.btnEdit.text = "MODIFIER"
            canFetchList = false
            binding.etJob.setText(exp.job)
            binding.etCompanyName.setText(exp.company)
            binding.tvStartDate.text = exp.location
            binding.etDescription.setText(exp.description)
            binding.tvEndDate.text = exp.startDate
            if (exp.startDate != "") {
                binding.tvStartDate.text = exp.startDate
                binding.tvEndDate.text = exp.endDate
                if (exp.endDate.isEmpty()){
                    binding.llEndDate.visibility = View.GONE
                    binding.cbCurrentStudent.isChecked = true
                }
            }
            selectedWorkType = exp.typeOfWork
            when(selectedWorkType){
                WorkType.STAGE.value -> { binding.rbStage.isChecked = true }
                WorkType.ALTERNANCE.value -> { binding.rbAlternance.isChecked = true }
                WorkType.CDD.value -> { binding.rbCdd.isChecked = true }
                WorkType.CDI.value -> { binding.rbCdi.isChecked = true }
            }
            binding.rvCompanySuggestions.visibility = View.GONE
            binding.tvDescription.text = "${exp.description.length}/1500"
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
        binding.rgWorkType.setOnCheckedChangeListener { radioGroup, checkedId ->
            when (checkedId) {
                R.id.rb_stage -> { selectedWorkType = WorkType.STAGE.value }
                R.id.rb_alternance -> { selectedWorkType = WorkType.ALTERNANCE.value }
                R.id.rb_cdd -> { selectedWorkType = WorkType.CDD.value }
                R.id.rb_cdi -> { selectedWorkType = WorkType.CDI.value }
            }
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
            addExperience()
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

    private fun addExperience() {
        when {
            binding.etJob.text.isNullOrEmpty() -> {
                BasicDialog(requireActivity(), "Le nom de l'école ne peut pas être vide"){}.show()
            }
            else -> {
                if (jobSeeker != null){
                    if (experienceOld != null){
                        if (jobSeeker!!.experiences.find { it.id == experienceOld!!.id } != null){
                            jobSeeker!!.experiences.find { it.id == experienceOld!!.id }?.apply {
                                this.typeOfWork = selectedWorkType
                                this.job = binding.etJob.text.toString()
                                this.company = selectedCompany?.name ?: binding.etCompanyName.text.toString()
                                this.description = binding.etDescription.text.toString()
                                this.startDate = binding.tvStartDate.text.toString()
                                this.endDate = binding.tvEndDate.text.toString()
                                this.logo = selectedCompany?.logo ?: ""
                            }
                            // update experience here
                            addOrUpdateExperience()
                        }
                    }else{
                        val experience = Experience()
                        experience.apply {
                            this.typeOfWork = selectedWorkType
                            this.job = binding.etJob.text.toString()
                            this.company = selectedCompany?.name ?: binding.etCompanyName.text.toString()
                            this.description = binding.etDescription.text.toString()
                            this.startDate = binding.tvStartDate.text.toString()
                            this.endDate = binding.tvEndDate.text.toString()
                            this.logo = selectedCompany?.logo ?: ""
                        }
                        jobSeeker!!.experiences.add(experience)
                        // add experience here
                        addOrUpdateExperience()
                    }
                }else{
                    toast("Something Went Wrong.")
                }
             }
        }
    }

    private fun addOrUpdateExperience() {
        val experienceGroup = if (jobSeeker!!.experiences.isEmpty()){
            ExperienceGroup(arrayListOf())
        }else{
            ExperienceGroup(jobSeeker!!.experiences)
        }
        viewModel.jobSeekerObject?.put(ParseTableFields.COMPANY_NAMES.value, ArrayList(jobSeeker!!.experiences.map { it.company.lowercase() }.filter { it.isNotEmpty() }))
        viewModel.jobSeekerObject?.put(ParseTableFields.EXPERIENCES.value, gson.toJson(experienceGroup))
        progressHud.show()
        viewModel.jobSeekerObject!!.saveInBackground {
            progressHud.dismiss()
            if (it == null) {
                //toast("Experience Added.")
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
