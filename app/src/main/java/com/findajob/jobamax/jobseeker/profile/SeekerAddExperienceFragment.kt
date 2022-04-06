package com.findajob.jobamax.jobseeker.profile

import android.os.Bundle
 import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
 import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerAddExperienceBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.profile.cv.model.Experience
import com.findajob.jobamax.util.mm_yy_disp
import com.findajob.jobamax.util.toast
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.pushwoosh.internal.platform.AndroidPlatformModule.getApplicationContext
import com.whiteelephant.monthpicker.MonthPickerDialog
import kotlinx.android.synthetic.main.fragment_seeker_add_experience.view.*
import java.util.*

class SeekerAddExperienceFragment : BaseFragmentMain<FragmentSeekerAddExperienceBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_add_experience
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var autocompleteFragment: AutocompleteSupportFragment
    var experienceOld: Experience? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerAddExperienceBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    override fun onCreated(savedInstance: Bundle?) {
        arguments?.getSerializable("experience")?.let {
            experienceOld = arguments?.getSerializable("experience") as Experience
        }
        experienceOld?.let {
            binding.etJob.setText(experienceOld!!.job)
            binding.etCompanyName.setText(experienceOld!!.company)
            binding.tvSelectLocation.text = experienceOld!!.location
            binding.etDescription.setText(experienceOld!!.description.toString())
            binding.tvSelectStartDate.text = experienceOld!!.startDate
            if (experienceOld!!.endDate == ""){
                val calendar = Calendar.getInstance(TimeZone.getDefault());
                binding.tvSelectEndDate.text = "${calendar.get(Calendar.DAY_OF_MONTH)}/ ${calendar.get(Calendar.MONTH) + 1}/ ${calendar.get(Calendar.YEAR)}"
            }else{
                binding.tvSelectEndDate.text = experienceOld!!.endDate
            }
        }
    }

    private fun configureUi() {
        binding.jobSeeker = viewModel.jobSeeker
        setClickListeners()
        setPlaceAutocompleteFragment()
    }

    private fun setPlaceAutocompleteFragment() {
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), getString(R.string.google_maps_key), Locale.US);
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

    private fun setClickListeners() {
        binding.ivUserProfile.setOnClickListener {
            requireActivity().finish()
        }
        binding.ivClearStartDate.setOnClickListener {
            binding.tvSelectStartDate.text = ""
        }
        binding.ivClearEndDate.setOnClickListener {
            binding.tvSelectEndDate.text = ""
        }
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.tvSelectStartDate.setOnClickListener {
            onDateClicked(it)
        }
        binding.tvSelectEndDate.setOnClickListener {
            onDateClicked(it)
        }
        binding.tvSelectLocation.setOnClickListener {
            autocompleteFragment.requireView().findViewById<View>(R.id.places_autocomplete_search_input).performClick()
        }
         binding.btnAddExperience.setOnClickListener {
             when{
                 binding.etJob.text.isNullOrEmpty() -> {
                    toast("Please enter job.")
                 }
                 binding.etCompanyName.text.isNullOrEmpty() -> {
                     toast("Please enter company name.")
                 }
                 binding.etDescription.text.isNullOrEmpty() -> {
                     toast("Please enter job description.")
                 }
                 binding.tvSelectStartDate.text.isNullOrEmpty() -> {
                     toast("Please select start date.")
                 }
                 else -> {
                     val experience = if (experienceOld == null){
                         Experience()
                     }else{
                         experienceOld
                     }
                     experience!!.job = binding.etJob.text.toString()
                     experience.company = binding.etCompanyName.text.toString()
                     experience.description = binding.etDescription.text.toString()
                     if (binding.tvSelectLocation.text.isNullOrEmpty()){
                         experience.location = ""
                     }else{
                         experience.location = binding.tvSelectLocation.text.toString()
                     }
                     experience.startDate = binding.tvSelectStartDate.text.toString()
                     if (binding.tvSelectEndDate.text.isNullOrEmpty()){
                         experience.endDate = ""
                     }else{
                         experience.endDate = binding.tvSelectEndDate.text.toString()
                     }
                     progressHud.show()
                     viewModel.addAndUpdateExperience(experience){
                         progressHud.dismiss()
                         if (it == null){
                             toast("Experience Added.")
                             requireActivity().onBackPressed()
                         }else{
                             toast("${it.message.toString()} Something Went Wrong.")
                         }
                     }
                 }
             }
         }
    }


    fun onDateClicked(view: View ) {
        val today = Calendar.getInstance()

        MonthPickerDialog.Builder(
            requireContext(),
            { selectedMonth, selectedYear ->
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.YEAR, selectedYear)
                calendar.set(Calendar.MONTH, selectedMonth)
                calendar.set(Calendar.DATE, 1)
                (view as TextView).text = calendar.time.mm_yy_disp()
            },
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
        )
            .setActivatedMonth(today.get(Calendar.MONTH))
            .setMinYear(today.get(Calendar.YEAR))
            .setActivatedYear(today.get(Calendar.YEAR))
            .setMaxYear(today.get(Calendar.YEAR))
            .setMinYear(today.get(Calendar.YEAR) - 50)
            .setTitle("Select")
            .build()
            .show()
    }

}