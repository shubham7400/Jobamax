package com.jobamax.appjobamax.jobseeker.jobsearch

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.data.pojo.Categories
import com.jobamax.appjobamax.data.pojo.CategoryGroup
import com.jobamax.appjobamax.databinding.FragmentSeekerJobsFilterBinding
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.jobseeker.model.JobSeekerJobFilter
import com.jobamax.appjobamax.jobseeker.profile.idealjob.IOnBackPressed
import com.jobamax.appjobamax.preference.getJobSeekerJobFilter
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.preference.setJobSearchFilterCategories
import com.jobamax.appjobamax.preference.setJobSeekerJobFilter
import com.jobamax.appjobamax.util.*
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.google.gson.Gson
import com.parse.FunctionCallback
import com.parse.ParseCloud
import com.parse.ParseObject
import com.parse.ParseQuery
import com.pushwoosh.internal.platform.AndroidPlatformModule
import java.util.*


class SeekerJobsFilterFragment : BaseFragmentMain<FragmentSeekerJobsFilterBinding>() , IOnBackPressed  {

    override val layoutRes: Int get() = R.layout.fragment_seeker_jobs_filter
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var autocompleteFragment: AutocompleteSupportFragment
    var lat: Double? = null
    var lng: Double? = null

    private lateinit var jobTitleAdapter: SeekerJobTitleAdapter
    private var jobTitles = arrayListOf<String>()
    var isJobTitleSelected = false

    private var categories = arrayListOf<Categories>()
    private val listOfTypeOfWork = ArrayList<String>()
    lateinit var navController : NavController




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
        setJobTypeRecyclerview()
        setIndustryListRecyclerview()
        getGPSLocation()
    }



    private fun setIndustryListRecyclerview() {
        categories = getJobCategories(requireContext())
        binding.llIndustry.removeAllViews()
        categories.forEach { category ->
            val inflater = requireContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.item_category_chip, null)
            val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(0, 20, 0, 0);
            if (category.isSelected){
                view.findViewById<TextView>(R.id.tv_category).text = category.text
                view.findViewById<ImageView>(R.id.iv_remove).setOnClickListener {
                    category.isSelected = category.isSelected != true
                    updateList(categories)
                }
                binding.llIndustry.addView(view, layoutParams)
            }
        }

    }

    private fun updateList(categories: ArrayList<Categories>) {
        requireContext().setJobSearchFilterCategories(Gson().toJson(CategoryGroup(categories)))
        setIndustryListRecyclerview()
    }

    private fun getGPSLocation() {
         if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
             return
         }
        if (getCurrentLatitude() != 0.0 && getCurrentLongitude() != 0.0){
            binding.tvSelectLocation.text = getAddressByLatLng(getCurrentLatitude(), getCurrentLongitude(), requireContext())
        }
     }



     private fun setJobTypeRecyclerview() {
        jobTitleAdapter =  SeekerJobTitleAdapter(jobTitles)
        binding.rvJobTypes.adapter = jobTitleAdapter
        jobTitleAdapter.onJobTypeClick = {
            isJobTitleSelected = true
            binding.etJobKeyword.setText(it)
            binding.rvJobTypes.visibility = View.GONE
        }
        if (jobTitles.isEmpty()){
            binding.rvJobTypes.visibility = View.GONE
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

    private fun getCurrent( ) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, context?.getUserId())
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
            if (jobSeekerJobFilter.companyName != null) {
                binding.etCompanyName.setText(jobSeekerJobFilter.companyName)
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
            if (jobSeekerJobFilter.latitude != null) {
                lat = jobSeekerJobFilter.latitude
            }
            if (jobSeekerJobFilter.searchString != null) {
                lng = jobSeekerJobFilter.longitude
            }
        }
    }

    private fun setListeners() {
        binding.tvSelectLocation.setOnClickListener {
            autocompleteFragment.requireView().findViewById<View>(R.id.places_autocomplete_search_input).performClick()
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
        binding.civUser.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerJobsFilterFragment_to_nav_seeker_profile, null))
        binding.etJobKeyword.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.etJobKeyword.text.isNullOrEmpty()){
                    binding.rvJobTypes.visibility = View.GONE
                }else{
                    if (!isJobTitleSelected){
                        getJobTypes()
                    }
                    isJobTitleSelected = false
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
        val args = Bundle()
        args.putString(PROFILE_PIC_URL, viewModel.jobSeeker.profilePicUrl)
        binding.ivAddCategory.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerJobsFilterFragment_to_seekerJobSearchFilterCategoriesDialogFragment, args))

        typeOfWorkListeners()
        experienceListener()
    }

    private fun experienceListener() {
        binding.accbLessThanOne.setOnClickListener {
            binding.accbOneToTwo.isChecked = false
            binding.accbMoreThanTwo.isChecked = false
        }
        binding.accbOneToTwo.setOnClickListener {
            binding.accbLessThanOne.isChecked = false
            binding.accbMoreThanTwo.isChecked = false
        }
        binding.accbMoreThanTwo.setOnClickListener {
            binding.accbLessThanOne.isChecked = false
            binding.accbOneToTwo.isChecked = false
        }
    }

    private fun typeOfWorkListeners() {
        binding.accbApprenticeship.setOnClickListener {
            binding.accbPartTime.isChecked = false
            binding.accbInternship.isChecked = false
            binding.accbPermanent.isChecked = false
            listOfTypeOfWork.clear()
            if (binding.accbApprenticeship.isChecked){
                listOfTypeOfWork.add(resources.getString(R.string.apprenticeship))
            }
        }
        binding.accbPartTime.setOnClickListener {
            binding.accbApprenticeship.isChecked = false
            binding.accbInternship.isChecked = false
            binding.accbPermanent.isChecked = false
            listOfTypeOfWork.clear()
            if (binding.accbPartTime.isChecked){
                listOfTypeOfWork.add(resources.getString(R.string.part_time))
            }
        }
        binding.accbInternship.setOnClickListener {
            binding.accbApprenticeship.isChecked = false
            binding.accbPartTime.isChecked = false
            binding.accbPermanent.isChecked = false
            listOfTypeOfWork.clear()
            if (binding.accbInternship.isChecked){
                listOfTypeOfWork.add(resources.getString(R.string.internship))
            }
        }
        binding.accbPermanent.setOnClickListener {
            binding.accbApprenticeship.isChecked = false
            binding.accbInternship.isChecked = false
            binding.accbPartTime.isChecked = false
            listOfTypeOfWork.clear()
            if (binding.accbPermanent.isChecked){
                listOfTypeOfWork.add(resources.getString(R.string.full_time))
            }
        }
    }


    private fun getJobTypes() {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.GET_JOB_TITLES.value, hashMapOf<String, Any>("search" to binding.etJobKeyword.text.toString()), FunctionCallback<ArrayList<String>> { result, e ->
            when{
                e != null -> {
                    toast(e.message.toString()) }
                result == null -> {
                    binding.rvJobTypes.visibility = View.GONE
                }
                else -> {
                    binding.rvJobTypes.visibility = View.VISIBLE
                    jobTitleAdapter.submitList(result)
                    jobTitleAdapter.notifyDataSetChanged()
                }
            }
        })
    }

    private fun saveFilters(callback: () -> Unit) {
        val filter = JobSeekerJobFilter()
        filter.searchString = if (binding.etJobKeyword.text.isNullOrEmpty()) null else binding.etJobKeyword.text.toString()
        filter.location = if (binding.tvSelectLocation.text.isNullOrEmpty()) null else binding.tvSelectLocation.text.toString()
        filter.latitude = if (lat == null) getCurrentLatitude() else lat
        filter.longitude = if (lng == null) getCurrentLongitude() else lng
        filter.distance = if (binding.tvDistance.text.isNullOrEmpty()) null else binding.tvDistance.text.toString().toInt()
        filter.companyName = if (binding.etCompanyName.text.isNullOrEmpty()) null else binding.etCompanyName.text.toString()
        filter.typeOfWork = listOfTypeOfWork
        filter.experience = getExperience()
        filter.industry = getIndustries()
        requireContext().setJobSeekerJobFilter(Gson().toJson(filter ))

        callback()
    }

    private fun getIndustries(): List<String> = getJobCategories(requireContext()).filter { category -> category.isSelected }.map { it.text }

    private fun getExperience(): ArrayList<String> {
        val list = ArrayList<String>()
        if (binding.accbLessThanOne.isChecked){
            list.add(resources.getString(R.string.under_one))
        }
        if (binding.accbOneToTwo.isChecked){
            list.add(resources.getString(R.string.under_one))
            list.add(resources.getString(R.string.one_two))
        }
        if (binding.accbMoreThanTwo.isChecked){
            list.add(resources.getString(R.string.under_one))
            list.add(resources.getString(R.string.one_two))
            list.add(resources.getString(R.string.two_more))
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onBackPressed(callback: () -> Unit) {
        saveFilters{
            navController.navigate(R.id.action_seekerJobsFilterFragment_to_seekerJobsFragment);
        }
    }

}

