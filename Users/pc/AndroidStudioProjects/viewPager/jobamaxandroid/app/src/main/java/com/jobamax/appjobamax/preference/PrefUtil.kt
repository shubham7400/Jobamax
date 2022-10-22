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

