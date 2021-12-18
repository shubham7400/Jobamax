package com.findajob.jobamax.location

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ActivityManageLocationBinding
import com.findajob.jobamax.recruiter.profile.jobOffer.location.LocationPermissionInterface
import com.findajob.jobamax.util.*

class ManageLocationActivity : AppCompatActivity(), LocationPermissionInterface {

    lateinit var binding: ActivityManageLocationBinding
    private var cityFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage_location)
        cityFlag = intent.getBooleanExtra(ARG_CITY_FLAG, false)
        /*if (!Places.isInitialized()) {
            Places.initialize(this, PLACE_API_KEY)
        }
        Places.createClient(this)*/
        if (checkLocationPermission()) {
            binding.parentLayout.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        if (checkLocationPermission()) {
            binding.parentLayout.visibility = View.GONE
            navLocationPicker()
        } else {
            binding.parentLayout.visibility = View.VISIBLE
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        setResult(Activity.RESULT_CANCELED, intent)
        finish()
    }

    fun navLocationPicker() {
        /*val fields: List<Place.Field> = listOf(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG)
        val intent = if (cityFlag) Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields).setTypeFilter(TypeFilter.CITIES).build(this)
        else Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields).build(this)
        startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE)

        */

        val intent = Intent(this, SelectLocationActivity::class.java)
        startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AUTOCOMPLETE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {

            val intent = Intent()

            intent.putExtra(ARG_LOCATION, data.getStringExtra(ARG_LOCATION))
            intent.putExtra(ARG_LAT, data.getDoubleExtra(ARG_LAT, 0.0))
            intent.putExtra(ARG_LNG, data.getDoubleExtra(ARG_LNG, 0.0))
            intent.putExtra(ARG_CITY, data.getStringExtra(ARG_CITY))

            setResult(Activity.RESULT_OK, intent)
            finish()

            /*if (resultCode == RESULT_OK) {
                val place = Autocomplete.getPlaceFromIntent(data!!)
                log("Place: " + place.name + ", " + place.id)
                log("Lat: " + place.latLng?.latitude + ", Lng: " + place.latLng?.longitude)

                val intent = Intent()
                intent.putExtra(ARG_LOCATION, place.name)
                intent.putExtra(ARG_LAT, place.latLng?.latitude)
                intent.putExtra(ARG_LNG, place.latLng?.longitude)
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                val status: Status = Autocomplete.getStatusFromIntent(data!!)
                log(status.statusMessage ?: "Error")
                val intent = Intent()
                setResult(Activity.RESULT_CANCELED, intent)
                finish()
            } else if (resultCode == RESULT_CANCELED) {
                val intent = Intent()
                setResult(Activity.RESULT_CANCELED, intent)
                finish()
            }*/
        } else {
            errorToast()
            finish()
        }
    }

    override fun onAllowLocationClicked() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            REQUEST_PERMISSIONS_REQUEST_CODE
        )
    }

    override fun onTellMeMoreClicked() {

    }


}