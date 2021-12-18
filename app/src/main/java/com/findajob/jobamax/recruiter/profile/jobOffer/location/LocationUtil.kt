package com.findajob.jobamax.recruiter.profile.jobOffer.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Build
import androidx.core.app.ActivityCompat
import java.util.*


fun Context.getAddress(lat: Double?, lng: Double?): String {
    if (lat == null || lng == null)
        return ""
    val addresses: List<Address>
    val geoCoder = Geocoder(this, Locale.getDefault())

    addresses = geoCoder.getFromLocation(
        lat,
        lng,
        1
    ) // Here 1 represent max location result to returned, by documents it recommended 1 to 5


    val address: String =
        addresses[0].getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()

    return address
}

fun Context.getCityName(lat: Double, lng: Double): String {
    val gcd = Geocoder(this, Locale.getDefault())
    val addresses = gcd.getFromLocation(lat, lng, 1)
    return if (addresses.size > 0) addresses[0].locality else ""
}

fun checkLocationPermission(context: Context): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val accessFineLocationPermissionFlag = ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val accessCoarseLocationPermissionFlag = ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val accessBackgroundLocationFlag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
        return accessFineLocationPermissionFlag || accessCoarseLocationPermissionFlag || accessBackgroundLocationFlag
    }
    return true
}