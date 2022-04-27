package com.findajob.jobamax.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.findajob.jobamax.BuildConfig
import com.findajob.jobamax.R
import com.findajob.jobamax.data.pojo.Location
import com.findajob.jobamax.preference.getCurrentLocation
import com.google.gson.Gson


fun Any.log(text: String) {
    if (BuildConfig.DEBUG) Log.d("${this::class.java.simpleName} jobamax_debug", text)
}

fun Any.log(text: String, e: Throwable) {
    if (BuildConfig.DEBUG) {
        Log.e("${this.javaClass.simpleName} jobamax_debug", text, e)
        e.printStackTrace()
    }
}

fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(text: String) {
    requireActivity().toast(text)
}

fun convertCustomObjectToJsonString(customObject: Any) : String {
    return Gson().toJson(customObject)
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

fun ActionBar.setUp(title: String) {
    this.title = title
    this.setHomeAsUpIndicator(R.drawable.ic_back_arrow)
    this.setDisplayShowTitleEnabled(true)
    this.setDisplayHomeAsUpEnabled(true)
}

fun String.isValidEmail() =
    isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun List<String>.toPlainString(): String {
    var text = ""
    if (this.isEmpty())
        return ""
    this.forEach {
        text += "$it, "
    }

    text = text.substring(0, text.length - 2)
    return text
}




/**
 * Open respective app settings
 */
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



