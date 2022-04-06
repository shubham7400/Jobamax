package com.findajob.jobamax.base

import android.content.Context
import android.graphics.Paint
import android.net.ConnectivityManager
import android.widget.TextView
import timber.log.Timber




fun Context.isNetworkConnected(): Boolean {
    return try {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm!!.activeNetworkInfo != null && cm.activeNetworkInfo?.isConnected == true
    } catch (e: Exception) {
        false
    }
}

