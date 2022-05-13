package com.findajob.jobamax.jobseeker.profile.volunteering

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.findajob.jobamax.DatePickerDialogFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerAddVolunteeringBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.profile.cv.model.Volunteering
import com.findajob.jobamax.jobseeker.profile.experience.SearchQueryCompanySuggestionAdapter
import com.findajob.jobamax.jobseeker.profile.idealjob.IOnBackPressed
import com.findajob.jobamax.model.SearchQueryCompany
import com.findajob.jobamax.network.ApiFetchCompaniesService
import com.findajob.jobamax.preference.getLanguage
import com.findajob.jobamax.repos.SearchQueryCompanyRepo
import com.findajob.jobamax.util.MMM_d_yyyy
import com.findajob.jobamax.util.toast
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.pushwoosh.internal.platform.AndroidPlatformModule
 import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class SeekerAddVolunteeringFragment : BaseFragmentMain<FragmentSeekerAddVolunteeringBinding>(), IOnBackPressed {

    override val layoutRes: Int get() = R.layout.fragment_seeker_add_volunteering
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var autocompleteFragment: AutocompleteSupportFragment
    var volunteeringOld: Volunteering? = null

    lateinit var searchQueryCompanyRepo: SearchQueryCompanyRepo
    var selectedCompany: SearchQueryCompany? = null
    lateinit var adapter: SearchQueryCompanySuggestionAdapter
    var canFetchList = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerAddVolunteeringBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setPlaceAutocompleteFragment()
        if (binding.cbCurrentStudent.isChecked){
            binding.clEndDate.visibility = View.GONE
        }else{
            binding.clEndDate.visibility = View.VISIBLE
        }
        setAdapterFunctionality()
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
        searchQueryCompanyRepo = SearchQueryCompanyRepo(ApiFetchCompaniesService.getInstance(requireContext()).create(ApiFetchCompaniesService::class.java))
    }

    private fun setClickListeners() {
        binding.ivUserProfile.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerAddVolunteeringFragment_to_seekerProfileFragment, null))

        binding.tvStartDate.setOnClickListener {
            onDateClicked(binding.tvStartDate)
        }
        binding.tvEndDate.setOnClickListener {
            onDateClicked(binding.tvEndDate)
        }
        binding.cbCurrentStudent.setOnClickListener {
            if (binding.cbCurrentStudent.isChecked){
                binding.clEndDate.visibility = View.GONE
            }else{
                binding.clEndDate.visibility = View.VISIBLE
            }
        }
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.tvSelectLocation.setOnClickListener {
            autocompleteFragment.requireView().findViewById<View>(R.id.places_autocomplete_search_input).performClick()
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

        binding.clMostParent.setOnClickListener {
            binding.rvCompanySuggestions.visibility = View.GONE
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

    private fun validate(): Boolean {
        var isValid = false
        when{
            binding.etActivity.text.isNullOrEmpty() -> {
                toast("Please Enter activity.")
            }
            /*binding.etOrganisation.text.isNullOrEmpty() -> {
                toast("Please Enter Organization.")
            }
            binding.tvSelectLocation.text.isNullOrEmpty() -> {
                toast("Please Enter location.")
            }
            binding.tvStartDate.text.isNullOrEmpty() -> {
                toast("Please Enter activity.")
            }
            binding.etDescription.text.isNullOrEmpty() -> {
                toast("Please Enter activity.")
            }*/
            else -> {
                isValid = true
            }
        }
        return isValid
    }


    override fun onCreated(savedInstance: Bundle?) {
        arguments?.getSerializable("volunteering")?.let {
            volunteeringOld = arguments?.getSerializable("volunteering") as Volunteering
        }
        volunteeringOld?.let {
            canFetchList = false
            binding.etActivity.setText( volunteeringOld!!.job)
            binding.etOrganisation.setText(volunteeringOld!!.company)
            binding.etDescription.setText(volunteeringOld!!.description)
            binding.tvSelectLocation.text = volunteeringOld!!.location
            binding.tvStartDate.text = volunteeringOld!!.startDate
            if (volunteeringOld!!.endDate == ""){
                val calendar = Calendar.getInstance(TimeZone.getDefault());
                binding.tvEndDate.text = "${calendar.get(Calendar.DAY_OF_MONTH)}/ ${calendar.get(Calendar.MONTH) + 1}/ ${calendar.get(Calendar.YEAR)}"
            }else{
                binding.tvEndDate.text = volunteeringOld!!.endDate
            }
            binding.rvCompanySuggestions.visibility = View.GONE
        }

        binding.jobSeeker = viewModel.jobSeeker
    }

    private fun onDateClicked(view: View ) {
        val datePickerDialogFragment = DatePickerDialogFragment()
        datePickerDialogFragment.show(childFragmentManager, "datePicker")
        datePickerDialogFragment.selectedDate = { date ->
            (view as TextView).text = date.MMM_d_yyyy(requireContext().getLanguage())
        }
    }
    private fun setPlaceAutocompleteFragment() {
        if (!Places.isInitialized()) {
            Places.initialize(AndroidPlatformModule.getApplicationContext(), getString(R.string.google_maps_key), Locale.US);
        }
        autocompleteFragment = childFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment
        autocompleteFragment.setPlaceFields(listOf(Place.Field.ID, Place.Field.ADDRESS))
        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                binding.tvSelectLocation.text = place.address
            }
            override fun onError(status: Status) {}
        })
    }

    override fun onBackPressed(callback: () -> Unit) {
        if(validate()){
            val volunteering = if (volunteeringOld != null){
                volunteeringOld
            }else{
                Volunteering()
            }
            volunteering!!.job = binding.etActivity.text.toString()
            volunteering.company = binding.etOrganisation.text.toString()
            volunteering.location = binding.tvSelectLocation.text.toString()
            volunteering.startDate = binding.tvStartDate.text.toString()
            volunteering.endDate = if (binding.tvEndDate.text.isNullOrEmpty()) "" else binding.tvEndDate.text.toString()
            volunteering.description = binding.etDescription.text.toString()
            if (binding.cbCurrentStudent.isChecked){
                volunteering.endDate =  ""
            }else{
                volunteering.endDate =  binding.tvEndDate.text.toString()
            }
            volunteering.logo = selectedCompany?.logo ?: ""
            progressHud.show()
            viewModel.addOrUpdateVolunteering(volunteering) {
                progressHud.dismiss()
                if (it == null){
                    toast("Volunteering Added.")
                    callback()
                }else{
                    toast("${it.message.toString()} Something went wrong")
                    callback()
                }
            }
        }else{
            callback()
        }
    }

}