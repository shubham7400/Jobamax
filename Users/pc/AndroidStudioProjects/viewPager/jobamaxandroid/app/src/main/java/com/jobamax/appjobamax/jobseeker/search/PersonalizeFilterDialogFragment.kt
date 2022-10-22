package com.jobamax.appjobamax.jobseeker.search

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentPersonalizeFilterDialogBinding
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.util.APPRENTICESHIP
import com.jobamax.appjobamax.util.INTERNSHIP
import com.jobamax.appjobamax.util.PART_TIME
import com.jobamax.appjobamax.util.PERMANENT
import com.parse.ParseGeoPoint
import com.pushwoosh.internal.platform.AndroidPlatformModule
import java.util.*


class PersonalizeFilterDialogFragment : DialogFragment() {
    lateinit var binding: FragmentPersonalizeFilterDialogBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()
    lateinit var jobSeeker: JobSeeker

    lateinit var autocompleteFragment: AutocompleteSupportFragment
    var lat: Double? = null
    var lng: Double? = null
    var city = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPersonalizeFilterDialogBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        jobSeeker = viewModel.jobSeeker
        setClickListeners()
        setPlaceAutocompleteFragment()
        setData()
    }

    private fun setData() {
        binding.tvSelectLocation.text = jobSeeker.city
        city = jobSeeker.city
        lat = jobSeeker.lat
        lng = jobSeeker.lng
        if (jobSeeker.interestedIn.contains(INTERNSHIP)) {
            binding.cbInternship.isChecked = true
        }
        if (jobSeeker.interestedIn.contains(APPRENTICESHIP)) {
            binding.cbApprenticeship.isChecked = true
        }
        if (jobSeeker.interestedIn.contains(PART_TIME)) {
            binding.cbPartTime.isChecked = true
        }
        if (jobSeeker.interestedIn.contains(PERMANENT)) {
            binding.cbPermanent.isChecked = true
        }
        setContinueBtnState()
    }


    private fun setPlaceAutocompleteFragment() {
        if (!Places.isInitialized()) {
            Places.initialize(AndroidPlatformModule.getApplicationContext(), getString(R.string.google_maps_key), Locale.US)
        }
        autocompleteFragment = childFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment
        autocompleteFragment.setPlaceFields(listOf(Place.Field.ID, Place.Field.ADDRESS, Place.Field.LAT_LNG))
        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                 lat = place.latLng.latitude
                 lng = place.latLng.longitude
                val geocoder = Geocoder(requireContext(), Locale.getDefault())
                try {
                    val addresses: List<Address> = place.latLng?.let { it1 -> place.latLng?.let { it2 -> geocoder.getFromLocation( it1.latitude, it2.longitude, 1) } } as List<Address>
                    city = addresses[0].locality
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                binding.tvSelectLocation.text = place.address
            }
            override fun onError(status: Status) {}
        })
    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            this.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            this.setBackgroundDrawableResource(R.color.transparent)
            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(displayMetrics)
            val height = displayMetrics.heightPixels
            val width = displayMetrics.widthPixels
            val layoutParams1 = this.attributes
            layoutParams1.width = width - 100
            layoutParams1.height = height - 300
            this.attributes = layoutParams1
        }
    }



    private fun setClickListeners() {
        binding.cbApprenticeship.setOnCheckedChangeListener { _, _ -> setContinueBtnState() }
        binding.cbInternship.setOnCheckedChangeListener { _, _ -> setContinueBtnState() }
        binding.cbPermanent.setOnCheckedChangeListener { _, _ -> setContinueBtnState() }
        binding.cbPartTime.setOnCheckedChangeListener { _, _ -> setContinueBtnState() }
        binding.tvSelectLocation.setOnClickListener {
            autocompleteFragment.requireView().findViewById<View>(R.id.places_autocomplete_search_input).performClick()
        }

        binding.btnContinue.setOnClickListener {
            saveDataToParse()
        }
    }

    private fun saveDataToParse() {
        if (!setContinueBtnState()) {
            return
        }

        val interestedIn = arrayListOf<String>()
        if (binding.cbPartTime.isChecked) {
            interestedIn.add(PART_TIME)
        }
        if (binding.cbPermanent.isChecked) {
            interestedIn.add(PERMANENT)
        }
        if (binding.cbApprenticeship.isChecked) {
            interestedIn.add(APPRENTICESHIP)
        }
        if (binding.cbInternship.isChecked) {
            interestedIn.add(INTERNSHIP)
        }
        interestedIn.forEach { log("fldsk $it") }
        (requireActivity() as JobSeekerHomeActivity).viewModel.jobSeekerObject?.also {
            it.put(ParseTableFields.INTERESTED_IN.value, interestedIn)
            it.put(ParseTableFields.CITY.value, city)
            it.put("lat", lat!!)
            it.put("lng", lng!!)
            val gp = ParseGeoPoint().also { pgp ->
                pgp.latitude = lat ?: 0.0
                pgp.longitude = lng ?: 0.0
            }
           it.put(ParseTableFields.GEO_LOCATION.value, gp)
        }?.saveInBackground {
            if (it != null) {
                toast(it.message.toString() + " Something Went Wrong.")
            } else {
                toast("Saved Successfully.")
                (requireActivity() as JobSeekerHomeActivity).jobSeeker.also { js ->
                    js.interestedIn = interestedIn
                    js.city = city
                    js.lat = lat!!
                    js.lng = lng!!
                }

            }
            dismiss()
        }
    }

    private fun setContinueBtnState() : Boolean {
        var isValid = false
        if (!binding.cbApprenticeship.isChecked && !binding.cbInternship.isChecked && !binding.cbPermanent.isChecked && !binding.cbPartTime.isChecked || city.isEmpty()) {
            binding.btnContinue.isEnabled = false
            binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_grey_box_50, null)
            binding.btnContinue.setTextColor(resources.getColor(R.color.navi_blue, null))
            isValid = false
        } else {
            binding.btnContinue.isEnabled = true
            binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
            binding.btnContinue.setTextColor(resources.getColor(R.color.white, null))
            isValid = true
        }
        return isValid
    }

}