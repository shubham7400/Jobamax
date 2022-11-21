package com.jobamax.appjobamax.preference

import android.content.Context

private const val FILE_NAME = "utility_pref"

fun Context.setThemeColor(languageCode: String) {
    val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("theme", languageCode).apply()
}

fun Context.getThemeColor(): String {
    val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    return sharedPreferences.getString("theme", "normal") ?: "normal"
}

fun Context.setViewOrder(languageCode: String) {
    val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("view_order", languageCode).apply()
}

fun Context.getViewOrder(): String {
    val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    return sharedPreferences.getString("view_order", "") ?: ""
}

fun Context.getDeepLink(): String {
    val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    return sharedPreferences.getString("deep_link", "") ?: ""
}

fun Context.setDeepLink(str: String) {
    val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("deep_link", str).apply()
}

fun Context.getSharedJobOfferId(): String {
    val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    return sharedPreferences.getString("shared_job_offer_id", "") ?: ""
}

fun Context.setSharedJobOfferId(str: String){
    val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("shared_job_offer_id", str).apply()
}

fun Context.getSharedJobSharerId(): String {
    val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    return sharedPreferences.getString("shared_job_sharer_id", "") ?: ""
}

fun Context.setSharedJobSharerId(str: String){
    val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("shared_job_sharer_id", str).apply()
}

