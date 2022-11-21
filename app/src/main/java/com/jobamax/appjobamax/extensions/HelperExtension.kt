package com.jobamax.appjobamax.extensions

import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.databinding.ktx.BuildConfig
import com.jobamax.appjobamax.R


fun Any.log(text: String) {
    if (BuildConfig.DEBUG) Log.d("${this::class.java.simpleName} jobamax_debug", text)
}

fun Any.log(text: String, e: Throwable) {
    if (BuildConfig.DEBUG) {
        Log.e("${this.javaClass.simpleName} jobamax_debug", text, e)
        e.printStackTrace()
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








