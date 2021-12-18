package com.findajob.jobamax.location

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.findajob.jobamax.BaseActivity
import com.findajob.jobamax.R
import com.findajob.jobamax.data.pojo.Location
import com.findajob.jobamax.databinding.ActivitySelectLocationBinding
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.recruiter.profile.jobOffer.location.LocationAdapter
import com.findajob.jobamax.recruiter.profile.jobOffer.location.getAddress
import com.findajob.jobamax.recruiter.profile.jobOffer.location.getCityName
import com.findajob.jobamax.util.*
import com.google.android.gms.location.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectLocationActivity : BaseActivity() {

    var binding: ActivitySelectLocationBinding? = null

    val viewModel: LocationViewModel by viewModels()

    lateinit var locationAdapter: LocationAdapter
    var currentLocation = Location()

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        subscribeObserver()
    }

    private fun initViews() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_location)

        locationAdapter = LocationAdapter { l ->

            viewModel.queryLocationDetails(l.placeId)

            observe(viewModel.selectedLocationListener) {
                it?.let { location ->
                    val intent = Intent()

                    intent.putExtra(ARG_LOCATION, location.address)
                    intent.putExtra(ARG_LAT, location.lat)
                    intent.putExtra(ARG_LNG, location.long)
                    intent.putExtra(ARG_CITY, location.city)

                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }

        }

        binding?.apply {

            rvLocationList.layoutManager = LinearLayoutManager(this@SelectLocationActivity)
            rvLocationList.adapter = locationAdapter

            etLocationSearch.addTextChangedListener(object : TextWatcher {

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                // unused
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(p0: Editable?) {
                    val query = p0?.toString() ?: ""
                    if (query.isNotEmpty() && query.length > 3) viewModel.queryCity(query)
                }

            })

            tvCurrentLocationLabel.setOnClickListener {
                val intent = Intent()

                intent.putExtra(ARG_LOCATION, currentLocation.address)
                intent.putExtra(ARG_LAT, currentLocation.lat)
                intent.putExtra(ARG_LNG, currentLocation.long)
                intent.putExtra(ARG_CITY, currentLocation.city)

                setResult(Activity.RESULT_OK, intent)

                finish()
            }
        }
    }

    private fun subscribeObserver() {
        observe(viewModel.locationListener) { locationList ->
            log("location list in ${this::class.java.simpleName} -> $locationList")
            locationAdapter.submitLocationList(locationList)
        }

        observe(viewModel.loading) {
            it?.let { shouldBeLoading ->
                if (shouldBeLoading) showLoading()
                else hideLoading()
            }
        }

        observe(viewModel.error) {
            it?.let { errorMessage ->
                log(errorMessage)
                toast(errorMessage)
            }
        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }


    private fun showLoading() {
        binding?.rvLocationList?.visibility = View.GONE
        binding?.lvLoading?.visibility = View.VISIBLE
        binding?.lvLoading?.start()
    }

    private fun hideLoading() {
        binding?.rvLocationList?.visibility = View.VISIBLE
        binding?.lvLoading?.visibility = View.GONE
    }


    private val locationCallback: LocationCallback by lazy {
        object : LocationCallback() {

            override fun onLocationResult(locationResult: LocationResult) {

                val lastLocation = locationResult.lastLocation

                currentLocation.lat = lastLocation.latitude
                currentLocation.long = lastLocation.longitude

                currentLocation.city = lastLocation.provider

                currentLocation.address = getAddress(lastLocation.latitude, lastLocation.longitude)

                currentLocation.city = getCityName(lastLocation.latitude, lastLocation.longitude)

                binding?.tvCurrentLocationLabel?.text = currentLocation.address
            }
        }
    }

    override fun onResume() {
        super.onResume()
        resumeLocationRequest()
    }

    private fun resumeLocationRequest() {

        val request = LocationRequest()

        request.interval = 1000
        request.fastestInterval = 300

        request.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY

        val permission =
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)

        if (permission == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.requestLocationUpdates(request, locationCallback, null)
        }
    }

    override fun onPause() {
        super.onPause()
        hideLoading()
        pauseLocationClient()
    }

    private fun pauseLocationClient() {
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        hideLoading()
        binding = null
    }
}
