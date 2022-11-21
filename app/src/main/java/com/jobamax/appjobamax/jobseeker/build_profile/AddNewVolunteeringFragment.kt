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
import com.google.gson.Gson
import com.jobamax.appjobamax.DatePickerDialogFragment
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentAddNewVolunteeringBinding
import com.jobamax.appjobamax.dialog.BasicDialog
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.MMM_d_yyyy
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.*
import com.jobamax.appjobamax.network.ApiFetchCompaniesService
import com.jobamax.appjobamax.preference.getLanguage
import com.jobamax.appjobamax.repos.SearchQueryCompanyRepo
import com.parse.ParseException
import java.lang.Exception


class AddNewVolunteeringFragment : BaseFragment() {
    lateinit var binding: FragmentAddNewVolunteeringBinding

    lateinit var searchQueryCompanyRepo: SearchQueryCompanyRepo
    var selectedCompany: SearchQueryCompany? = null
    lateinit var adapter: SearchQueryCompanySuggestionAdapter
    var canFetchList = true

    var volunteeringOld: Volunteering? = null

    var jobSeeker: JobSeeker? = null

    val viewModel: SeekerHomeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddNewVolunteeringBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         setClickListeners()
        setAdapterFunctionality()
        initializeJobSeeker()

        arguments?.getSerializable("volunteering")?.let {
            volunteeringOld = arguments?.getSerializable("volunteering") as Volunteering
        }
        volunteeringOld?.let {
            binding.btnEdit.text = "MODIFIER"
            canFetchList = false
            binding.etJob.setText( volunteeringOld!!.job)
            binding.etOrganisation.setText(volunteeringOld!!.company)
            binding.etDescription.setText(volunteeringOld!!.description)
            binding.tvStartDate.text = volunteeringOld!!.startDate
            if (volunteeringOld!!.startDate != "") {
                binding.tvStartDate.text = volunteeringOld!!.startDate
                binding.tvEndDate.text = volunteeringOld!!.endDate
                if (volunteeringOld!!.endDate.isEmpty()){
                    binding.llEndDate.visibility = View.GONE
                    binding.cbCurrentStudent.isChecked = true
                }
            }
            binding.rvCompanySuggestions.visibility = View.GONE
            binding.tvDescription.text = "${volunteeringOld!!.description.length}/1500"
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
            binding.etOrganisation.setText(selectedCompany?.name)
        }
        searchQueryCompanyRepo = SearchQueryCompanyRepo(
            ApiFetchCompaniesService.getInstance(requireContext()).create(
                ApiFetchCompaniesService::class.java))
    }

    private fun setClickListeners() {
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
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
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
        binding.etOrganisation.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.etOrganisation.text.isNullOrEmpty()){
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

        binding.llMostParent.setOnClickListener {
            binding.rvCompanySuggestions.visibility = View.GONE
        }

        binding.btnEdit.setOnClickListener { addVolunteering() }
    }

    private fun addVolunteering() {

        if (binding.etJob.text.isNullOrEmpty()){
            BasicDialog(requireActivity(), "Le nom de la l'emploi ne peut pas être vide"){}.show()
            return
        }

       if (volunteeringOld != null){
           if (jobSeeker!!.volunteerings.find { it.id == volunteeringOld!!.id } != null){
               jobSeeker!!.volunteerings.find { it.id == volunteeringOld!!.id }?.apply {
                   this.job = binding.etJob.text.toString()
                   this.company = binding.etOrganisation.text.toString()
                   this.startDate = binding.tvStartDate.text.toString()
                   this.endDate = if (binding.tvEndDate.text.isNullOrEmpty()) "" else binding.tvEndDate.text.toString()
                   this.description = binding.etDescription.text.toString()
                   if (binding.cbCurrentStudent.isChecked){
                       this.endDate =  ""
                   }else{
                       this.endDate =  binding.tvEndDate.text.toString()
                   }
                   this.logo = selectedCompany?.logo ?: ""
               }
               // update volunteering here
               addOrUpdateVolunteering()
           }
        }else{
           val volunteering = Volunteering()
           volunteering.apply {
               this.job = binding.etJob.text.toString()
               this.company = binding.etOrganisation.text.toString()
               this.startDate = binding.tvStartDate.text.toString()
               this.endDate = if (binding.tvEndDate.text.isNullOrEmpty()) "" else binding.tvEndDate.text.toString()
               this.description = binding.etDescription.text.toString()
               if (binding.cbCurrentStudent.isChecked){
                   this.endDate =  ""
               }else{
                   this.endDate =  binding.tvEndDate.text.toString()
               }
               this.logo = selectedCompany?.logo ?: ""
           }
           jobSeeker!!.volunteerings.add(volunteering)
           // add experience here
           addOrUpdateVolunteering()
        }
      }

    private fun addOrUpdateVolunteering() {
        val volunteeringGroup = if (jobSeeker!!.volunteerings.isEmpty()){
            VolunteeringGroup(arrayListOf())
        }else{
            VolunteeringGroup(jobSeeker!!.volunteerings)
        }
        viewModel.jobSeekerObject?.put(ParseTableFields.VOLUNTEERINGS.value, gson.toJson(volunteeringGroup))
        progressHud.show()
        viewModel.jobSeekerObject!!.saveInBackground {
            progressHud.dismiss()
            if (it == null){
                // toast("Volunteering Added.")
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


    private fun getCompanySuggestions() {
        searchQueryCompanyRepo.getCompanies(binding.etOrganisation.text.toString()){ list ->
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

}