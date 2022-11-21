package com.jobamax.appjobamax.login

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentTakeWorkExperienceBinding
import com.jobamax.appjobamax.enums.LoginType
import com.jobamax.appjobamax.extensions.getCurrentLatitude
import com.jobamax.appjobamax.extensions.getCurrentLongitude
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.build_profile.BuildProfileActivity
import com.jobamax.appjobamax.model.*
import com.jobamax.appjobamax.preference.*
import com.jobamax.appjobamax.util.*
import com.parse.ParseGeoPoint
import com.pushwoosh.Pushwoosh
import com.pushwoosh.internal.platform.AndroidPlatformModule
import java.util.*
import kotlin.collections.ArrayList


class TakeWorkExperienceFragment : BaseFragment() {
    lateinit var binding: FragmentTakeWorkExperienceBinding

    var user: UserTempInfo? = null

    lateinit var autocompleteFragment: AutocompleteSupportFragment
    var lat: Double? = null
    var lng: Double? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTakeWorkExperienceBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListener()
        startListeningUserLocation()
        setPlaceAutocompleteFragment()
        user = requireArguments().getSerializable(ARG_USER) as UserTempInfo?
        binding.btnContinue.isEnabled = false
    }

    private fun setClickListener() {
        binding.btnContinue.setOnClickListener {
            log("fdsfsdaf email ${user?.email} loginType ${user?.loginType} userType ${user?.userType} password ${user?.password} address ${user?.jobLocation?.address} city ${user?.jobLocation?.city} lat ${user?.jobLocation?.lat} long ${user?.jobLocation?.long} firstName ${user?.firstName} lastName ${user?.lastName} universityName ${user?.university?.name} universityImgUrl ${user?.university?.logo}")
            storeUserInParse{
                startActivity(Intent(requireContext(), BuildProfileActivity::class.java))
                requireActivity().finish()
            }
        }
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.cbApprenticeship.setOnCheckedChangeListener { _, _ -> setContinueBtnState() }
        binding.cbInternship.setOnCheckedChangeListener { _, _ -> setContinueBtnState() }
        binding.cbPermanent.setOnCheckedChangeListener { _, _ -> setContinueBtnState() }
        binding.cbPartTime.setOnCheckedChangeListener { _, _ -> setContinueBtnState() }
        binding.tvSelectLocation.setOnClickListener {
            autocompleteFragment.requireView().findViewById<View>(R.id.places_autocomplete_search_input).performClick()
        }

        binding.tvSelectLocation.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                setContinueBtnState()
            }
            override fun afterTextChanged(p0: Editable?) {
                setContinueBtnState()
            }
        })
    }

    private fun setContinueBtnState() {
        if (binding.tvSelectLocation.text.isNullOrEmpty() || !binding.cbApprenticeship.isChecked && !binding.cbInternship.isChecked && !binding.cbPermanent.isChecked && !binding.cbPartTime.isChecked) {
            binding.btnContinue.isEnabled = false
            binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_grey_box_50, null)
            binding.btnContinue.setTextColor(resources.getColor(R.color.navi_blue, null))
        } else {
            binding.btnContinue.isEnabled = true
            binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
            binding.btnContinue.setTextColor(resources.getColor(R.color.white, null))
        }
    }

    private fun setPlaceAutocompleteFragment() {
        if (!Places.isInitialized()) {
            Places.initialize(AndroidPlatformModule.getApplicationContext(), getString(R.string.google_maps_key), Locale.US)
        }
        autocompleteFragment = childFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment
        autocompleteFragment.setPlaceFields(listOf(Place.Field.ID, Place.Field.ADDRESS, Place.Field.LAT_LNG))
        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                user?.jobLocation = JobLocation().also {
                    it.lat = place.latLng.latitude
                    it.long = place.latLng.longitude
                    it.address = place.address
                    val geocoder = Geocoder(requireContext(), Locale.getDefault())
                    try {
                        val addresses: List<Address> = place.latLng?.let { it1 -> place.latLng?.let { it2 -> geocoder.getFromLocation( it1.latitude, it2.longitude, 1) } } as List<Address>
                        it.city = addresses[0].locality
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                binding.tvSelectLocation.text = place.address
            }
            override fun onError(status: Status) {}
        })
    }

    private fun storeUserInParse( callback : () -> Unit) {
        val jobSeeker = JobSeeker()
        val id = UUID.randomUUID().toString().uppercase()
        jobSeeker.jobSeekerId = id
        jobSeeker.emailVerified = user?.loginType != LoginType.EMAIL.type
        jobSeeker.email = user!!.email
        jobSeeker.university = gson.toJson(user?.university)
        jobSeeker.profilePicUrl = user?.profilePicUrl ?: ""
        jobSeeker.userId = user?.userId ?: ""
        jobSeeker.loginType = user!!.loginType
        jobSeeker.firstName = user!!.firstName
        jobSeeker.lastName = user!!.lastName
        if (user!!.promoCode != null) {
            jobSeeker.promoCode = user!!.promoCode.toString()
        }
        jobSeeker.age = user!!.age.toString()
        user!!.age?.let { jobSeeker.ageInt = it }
        jobSeeker.jobLocation = gson.toJson(user?.jobLocation)
        jobSeeker.interestedIn = getInterest()
        if (user!!.password != ""){
            jobSeeker.password = AESCrypt.encrypt(user!!.password)
        }
        val typeOfWork = arrayListOf<String>()
        if (binding.cbPartTime.isChecked) {
            typeOfWork.add(PART_TIME)
        }
        if (binding.cbPermanent.isChecked) {
            typeOfWork.add(PERMANENT)
        }
        if (binding.cbApprenticeship.isChecked) {
            typeOfWork.add(APPRENTICESHIP)
        }
        if (binding.cbInternship.isChecked) {
            typeOfWork.add(INTERNSHIP)
        }
        jobSeeker.geoLocation = ParseGeoPoint().also {
            it.latitude = lat ?: 0.0
            it.longitude = lng ?: 0.0
        }
        jobSeeker.seenUpdatePopup = false
        jobSeeker.interestedIn = typeOfWork
        jobSeeker.city = user?.jobLocation?.city ?: ""
        jobSeeker.accountType = user!!.userType!!
        user?.jobLocation?.lat?.let { jobSeeker.lat = it }
        user?.jobLocation?.long?.let { jobSeeker.lng = it }
        jobSeeker.location = getAddressByLatLng(getCurrentLatitude(), getCurrentLongitude(), requireContext())
        val parseObject = jobSeeker.toParseObject()
        progressHud.show()
        parseObject.saveInBackground { e ->
            progressHud.dismiss()
            if (e != null) {
                toast(e.message.toString())
            } else {
                requireContext().setUserId(jobSeeker.jobSeekerId)
                requireContext().setLoginType(jobSeeker.loginType)
                requireContext().setUserType(jobSeeker.accountType)
                requireContext().setLoggedIn(true)
                Pushwoosh.getInstance().setUserId(jobSeeker.jobSeekerId)
                callback()
            }
        }
    }

    private fun getInterest(): ArrayList<String> {
        val interestList = ArrayList<String>()
        if (binding.cbInternship.isChecked){
            interestList.add(INTERNSHIP)
        }
        if (binding.cbPartTime.isChecked){
            interestList.add(PART_TIME)
        }
        if (binding.cbPermanent.isChecked){
            interestList.add(PERMANENT)
        }
        if (binding.cbApprenticeship.isChecked){
            interestList.add(APPRENTICESHIP)
        }
        return interestList
    }

    private fun startListeningUserLocation() {
        val mLocationManager = requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_REFRESH_TIME.toLong(), LOCATION_REFRESH_DISTANCE.toFloat(), locationListener)
    }

    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: android.location.Location) {
            location.let {
                val loc = Location()
                loc.lat = it.latitude
                loc.long = it.longitude
                try {
                    requireContext().setCurrentLocation(gson.toJson(loc))
                }catch (e: Exception){}
            }
        }

        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
    }

}