package com.findajob.jobamax.preference

import android.content.Context


private const val FILE_NAME = "settings_pref"

fun Context.isLoggedIn(): Boolean {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getBoolean("login_status", false)
	
}

fun Context.setLoggedIn(flag: Boolean) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putBoolean("login_status", flag).apply()
}


