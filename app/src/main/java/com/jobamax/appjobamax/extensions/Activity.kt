package com.jobamax.appjobamax.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.ckdroid.dynamicpermissions.PermissionStatus
import com.ckdroid.dynamicpermissions.PermissionUtils
import com.google.gson.Gson
import com.jobamax.appjobamax.model.Location
import com.jobamax.appjobamax.preference.getCurrentLocation
import com.jobamax.appjobamax.util.REQUEST_ALL_PERMISSIONS
import java.util.*


// contains extension for fragment and activity

fun <T> Context.gotoActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}

fun Activity.goToActivity(mClass: Class<*>, finishCurrentActivity: Boolean, extras: Bundle? = null, withResult: Boolean = false, requestCode: Int = -1) {
    val intent = Intent(this, mClass)
    extras?.apply { intent.putExtras(this) }
    if (!withResult)
        this.startActivity(intent)
    else
        this.startActivityForResult(intent, requestCode)

    if (finishCurrentActivity)
        this.finish()

}

fun Context.isNetworkConnected(): Boolean {
    return try {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm!!.activeNetworkInfo != null && cm.activeNetworkInfo?.isConnected == true
    } catch (e: Exception) {
        false
    }
}


fun Fragment.setLocale(languageCode: String) {
    val locale = Locale(languageCode)
    Locale.setDefault(locale)
    val resources: Resources =  resources
    val config: Configuration = resources.configuration
    config.setLocale(locale)
    resources.updateConfiguration(config, resources.displayMetrics)
}

fun Activity.setLocale(languageCode: String) {
    val locale = Locale(languageCode)
    Locale.setDefault(locale)
    val resources: Resources =  resources
    val config: Configuration = resources.configuration
    config.setLocale(locale)
    resources.updateConfiguration(config, resources.displayMetrics)
}

fun Context.getCurrentLatitude(): Double {
    return if ( this.getCurrentLocation() != ""){
        val loc = Gson().fromJson(this.getCurrentLocation(), Location::class.java)
        loc.lat
    }else{
        0.0
    }
}



fun Fragment.getCurrentLatitude(): Double {
    return if ( requireActivity().getCurrentLocation() != ""){
        val loc = Gson().fromJson(requireActivity().getCurrentLocation(), Location::class.java)
        loc.lat
    }else{
        0.0
    }
}

fun Context.getCurrentLongitude(): Double {
    return if ( this.getCurrentLocation() != ""){
        val loc = Gson().fromJson(this.getCurrentLocation(), Location::class.java)
        loc.long
    }else{
        0.0
    }
}
fun Fragment.getCurrentLongitude(): Double {
    return if ( requireActivity().getCurrentLocation() != ""){
        val loc = Gson().fromJson(requireActivity().getCurrentLocation(), Location::class.java)
        loc.long
    }else{
        0.0
    }
}

fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(text: String) {
    requireActivity().toast(text)
}

fun Context.openAppSettings() {
    try {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri: Uri = Uri.fromParts("package", packageName, null)
        intent.data = uri
        startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Context.errorToast() {
    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
}

fun Context.errorToast(e: Throwable?) {
    Toast.makeText(this, e?.message ?: "Something went wrong", Toast.LENGTH_SHORT).show()
}



fun Activity.checkForPermissions(permissions: Array<String>): Boolean {
    val permissionResult = PermissionUtils.checkAndRequestPermissions(this, permissions.toMutableList(), 102)
    return when (permissionResult.finalStatus) {
        PermissionStatus.ALLOWED -> true
        else -> {
            ActivityCompat.requestPermissions(this, permissions, REQUEST_ALL_PERMISSIONS)
            false
        }
    }
}

fun Fragment.checkForPermissions(permissions: Array<String>): Boolean {
    val permissionResult = PermissionUtils.checkAndRequestPermissions(requireActivity(), permissions.toMutableList(), 102)
    return when (permissionResult.finalStatus) {
        PermissionStatus.ALLOWED -> true
        else -> {
            requestPermissions(permissions, REQUEST_ALL_PERMISSIONS)
            false
        }
    }
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}



