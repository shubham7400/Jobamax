package com.findajob.jobamax.util

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.findajob.jobamax.BuildConfig
import com.findajob.jobamax.R
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener


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

fun ActionBar.setUp(title: String) {
    this.title = title
    this.setHomeAsUpIndicator(R.drawable.ic_back_arrow)
    this.setDisplayShowTitleEnabled(true)
    this.setDisplayHomeAsUpEnabled(true)
}


fun View.isVisible(flag: Boolean) {
    if (flag)
        this.visibility = View.VISIBLE
    else this.visibility = View.GONE
}

fun ViewGroup.inflate(layout: Int): View {
    val inflater = LayoutInflater.from(context)
    val view = inflater.inflate(layout, this, false)
    return view
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
 * Manage location permission by using this extension function.
 *
 * @param onGranted, callback to continue
 * @param onDeniedOne, callback to show that location permission message
 * @param onPermanentlyDeniedAnyOne, callback to navigate to app settings to manually provide permission
 */
fun Context.manageLocationPermission(onGranted: () -> Unit, onDeniedOne: () -> Unit, onPermanentlyDeniedAnyOne: () -> Unit) {
    try {
        val allPermissions = mutableListOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        val listenerCallback = object : MultiplePermissionsListener {
            override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                when (p0 == null) {
                    true -> onDeniedOne.invoke()
                    else -> {
                        when {
                            p0.areAllPermissionsGranted() -> {
                                onGranted.invoke()
                            }
                            p0.isAnyPermissionPermanentlyDenied -> {
                                onPermanentlyDeniedAnyOne.invoke()
                            }
                            p0.grantedPermissionResponses.size != allPermissions.size -> {
                                onDeniedOne.invoke()
                            }
                        }
                    }
                }
            }

            override fun onPermissionRationaleShouldBeShown(
                p0: MutableList<PermissionRequest>?,
                p1: PermissionToken?
            ) {
                p1?.continuePermissionRequest()
            }
        }
        Dexter.withContext(this)
            .withPermissions(allPermissions)
            .withListener(listenerCallback)
            .check()
    } catch (e: Exception) {
        e.printStackTrace()
    }
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

fun Context.checkLocationPermission(): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val accessFineLocationPermissionFlag = ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val accessCoarseLocationPermissionFlag = ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val accessBackgroundLocationFlag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
        return accessFineLocationPermissionFlag || accessCoarseLocationPermissionFlag || accessBackgroundLocationFlag
    }
    return true
}

fun Fragment.debugToast(msg: String) {
    try {
        (requireActivity() as Activity).debugToast(msg)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Activity.debugToast(msg: String) {
    if (BuildConfig.DEBUG) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}