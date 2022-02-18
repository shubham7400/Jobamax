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
import com.findajob.jobamax.databinding.FragmentSeekerAddVolunteeringBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.profile.cv.model.Volunteering
import com.findajob.jobamax.util.mm_yy_disp
import com.findajob.jobamax.util.toast
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.pushwoosh.internal.platform.AndroidPlatformModule
import com.whiteelephant.monthpicker.MonthPickerDialog
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class SeekerAddVolunteeringFragment : BaseFragmentMain<FragmentSeekerAddVolunteeringBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_add_volunteering
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var autocompleteFragment: AutocompleteSupportFragment
    var volunteeringOld: Volunteering? = null

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
    }

    private fun setClickListeners() {
         binding.btnAddVolunteering.setOnClickListener {
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
                 progressHud.show()
                 viewModel.addOrUpdateVolunteering(volunteering) {
                     progressHud.dismiss()
                     if (it == null){
                         toast("Volunteering Added.")
                         requireActivity().onBackPressed()
                     }else{
                         toast("${it.message.toString()} Something went wrong")
                     }
                 }
             }
         }
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
            (activity as SeekerProfileActivity).onBackPressed()
        }
        binding.tvSelectLocation.setOnClickListener {
            autocompleteFragment.requireView().findViewById<View>(R.id.places_autocomplete_search_input).performClick()
        }
    }

    private fun validate(): Boolean {
        var isValid = false
        when{
            binding.etActivity.text.isNullOrEmpty() -> {
                toast("Please Enter activity.")
            }
            binding.etOrganisation.text.isNullOrEmpty() -> {
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
            }
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
        }

        binding.jobSeeker = viewModel.jobSeeker
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

}