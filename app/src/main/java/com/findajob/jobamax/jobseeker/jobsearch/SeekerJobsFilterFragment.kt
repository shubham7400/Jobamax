package com.findajob.jobamax.jobseeker.jobsearch

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerJobsFilterBinding
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.model.JobSeekerJobFilter
import com.findajob.jobamax.preference.getJobSeekerJobFilter
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.preference.setJobSeekerJobFilter
import com.findajob.jobamax.util.toast
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.google.gson.Gson
import com.parse.ParseObject
import com.parse.ParseQuery
import com.pushwoosh.internal.platform.AndroidPlatformModule
 import java.util.*
import kotlin.collections.ArrayList


class SeekerJobsFilterFragment : BaseFragmentMain<FragmentSeekerJobsFilterBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_jobs_filter
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var autocompleteFragment: AutocompleteSupportFragment
    var lat: Double? = null
    var lng: Double? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerJobsFilterBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setPreferenceValue()
        setListeners()
        setPlaceAutocompleteFragment()
        viewModelObserver()
        if (viewModel.jobSeekerObject == null){
            getCurrent()
        }else{
            binding.jobSeeker = viewModel.jobSeeker
        }
    }

    private fun viewModelObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner) {
            progressHud.dismiss()
            if (it) {
                binding.jobSeeker = viewModel.jobSeeker
            }
        }
    }

    fun getCurrent( ) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
        query.whereEqualTo(ParseTableFields.jobSeekerId.toString(), context?.getUserId())
        query.include("portfolio")
        query.include("idealJob")
        progressHud.show()
        query.findInBackground { it, e ->
            progressHud.dismiss()
            val jobSeeker = it?.firstOrNull()
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                jobSeeker == null -> {
                    toast("User Not Found.")
                }
                else -> {
                    viewModel.jobSeekerObject = jobSeeker
                    viewModel.isJobSeekerUpdated.value = true
                }
            }
        }
    }


    private fun setPreferenceValue() {
        if (requireContext().getJobSeekerJobFilter() != "") {
            val jobSeekerJobFilter = Gson().fromJson(requireContext().getJobSeekerJobFilter(), JobSeekerJobFilter::class.java)
            if (jobSeekerJobFilter.searchString != null) {
                binding.etJobKeyword.setText(jobSeekerJobFilter.searchString)
            }
            if (jobSeekerJobFilter.location != null) {
                binding.tvSelectLocation.text = jobSeekerJobFilter.location
            }
            if (jobSeekerJobFilter.distance != null) {
                binding.tvDistance.text = jobSeekerJobFilter.distance.toString()
                binding.sbDistance.progress = jobSeekerJobFilter.distance!!
            }
            if (jobSeekerJobFilter.industry != null) {
                binding.etIndustryName.setText(jobSeekerJobFilter.industry)
            }
            if (jobSeekerJobFilter.typeOfWork.isNotEmpty()) {
                if (jobSeekerJobFilter.typeOfWork.contains(resources.getString(R.string.apprenticeship))) {
                    binding.accbApprenticeship.isChecked = true
                }
                if (jobSeekerJobFilter.typeOfWork.contains(resources.getString(R.string.part_time))) {
                    binding.accbPartTime.isChecked = true
                }
                if (jobSeekerJobFilter.typeOfWork.contains(resources.getString(R.string.internship))) {
                    binding.accbInternship.isChecked = true
                }
                if (jobSeekerJobFilter.typeOfWork.contains(resources.getString(R.string.full_time))) {
                    binding.accbPermanent.isChecked = true
                }
            }
            if (jobSeekerJobFilter.experience.isNotEmpty()) {
                if (jobSeekerJobFilter.experience.contains(resources.getString(R.string.under_one))) {
                    binding.accbLessThanOne.isChecked = true
                }
                if (jobSeekerJobFilter.experience.contains(resources.getString(R.string.one_two))) {
                    binding.accbOneToTwo.isChecked = true
                }
                if (jobSeekerJobFilter.experience.contains(resources.getString(R.string.two_more))) {
                    binding.accbMoreThanTwo.isChecked = true
                }
            }
            if (jobSeekerJobFilter.lat != null) {
                lat = jobSeekerJobFilter.lat
            }
            if (jobSeekerJobFilter.searchString != null) {
                lng = jobSeekerJobFilter.lng
            }
        }
    }

    private fun setListeners() {
        binding.tvSelectLocation.setOnClickListener {
            autocompleteFragment.requireView().findViewById<View>(R.id.places_autocomplete_search_input).performClick()
        }
        binding.btnSave.setOnClickListener {
            saveFilters()
        }

        binding.sbDistance.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(view: SeekBar?, progress: Int, p2: Boolean) {
                binding.tvDistance.text = progress.toString()
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.civUser.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun saveFilters() {
        val filter = JobSeekerJobFilter()
        filter.searchString = if (binding.etJobKeyword.text.isNullOrEmpty()) null else binding.etJobKeyword.text.toString()
        filter.location = if (binding.tvSelectLocation.text.isNullOrEmpty()) null else binding.tvSelectLocation.text.toString()
        filter.lat = if (lat == null) null else lat
        filter.lng = if (lng == null) null else lng
        filter.distance = if (binding.tvDistance.text.isNullOrEmpty()) null else binding.tvDistance.text.toString().toInt()
        filter.industry = if (binding.etIndustryName.text.isNullOrEmpty()) null else binding.etIndustryName.text.toString()
        filter.typeOfWork = getTypeOfWork()
        filter.experience = getExperience()
        requireContext().setJobSeekerJobFilter(Gson().toJson(filter ))

        requireActivity().onBackPressed()
    }

    private fun getExperience(): ArrayList<String> {
        val list = ArrayList<String>()
        if (binding.accbLessThanOne.isChecked){
            list.add(resources.getString(R.string.under_one))
        }
        if (binding.accbOneToTwo.isChecked){
            list.add(resources.getString(R.string.one_two))
        }
        if (binding.accbMoreThanTwo.isChecked){
            list.add(resources.getString(R.string.two_more))
        }
        return  list
    }

    private fun getTypeOfWork(): ArrayList<String> {
        val list = ArrayList<String>()
        if (binding.accbApprenticeship.isChecked){
            list.add(resources.getString(R.string.apprenticeship))
        }
        if (binding.accbPartTime.isChecked){
            list.add(resources.getString(R.string.part_time))
        }
        if (binding.accbInternship.isChecked){
            list.add(resources.getString(R.string.internship))
        }
        if (binding.accbPermanent.isChecked){
            list.add(resources.getString(R.string.full_time) )
        }
        return  list
    }

    private fun setPlaceAutocompleteFragment() {
        if (!Places.isInitialized()) {
            Places.initialize(AndroidPlatformModule.getApplicationContext(), getString(R.string.google_maps_key), Locale.US);
        }
        autocompleteFragment = childFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment
        autocompleteFragment.setPlaceFields(listOf(Place.Field.ID, Place.Field.ADDRESS, Place.Field.LAT_LNG))
        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                binding.tvSelectLocation.text = place.address
                lat = place.latLng.latitude
                lng = place.latLng.longitude
            }
            override fun onError(status: Status) {}
        })
    }


    override fun onCreated(savedInstance: Bundle?) {

    }

}