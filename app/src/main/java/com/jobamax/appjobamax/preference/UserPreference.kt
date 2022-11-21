package com.jobamax.appjobamax.preference

import android.content.Context
import com.jobamax.appjobamax.model.User
import com.jobamax.appjobamax.util.FRENCH_LANG_CODE


private const val FILE_NAME = "user_pref"



fun Context.clearUserPref() {
	setUserId("")
	setLoginType("")
	setUserObjectId("")
	setLoggedIn(false)
	setLanguage(FRENCH_LANG_CODE)
	setUserType(-1)
	setSeenOnBoarding(false)
	setCurrentLocation("")
	setViewOrder("")
	setJobSearchType(false)
}

fun Context.isLoggedIn(): Boolean {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getBoolean("login_status", false)

}

fun Context.setLoggedIn(flag: Boolean) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putBoolean("login_status", flag).apply()
}

fun Context.getUserId(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("user_id", "") ?: ""
}

fun Context.setUserId(str: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("user_id", str).apply()
}



fun Context.getUserObjectId(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("user_object_id", "") ?: ""
}

fun Context.setUserObjectId(str: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("user_object_id", str).apply()
}


fun Context.getLoginType(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("user_login_type", "") ?: ""
}

fun Context.setLoginType(type: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("user_login_type", type).apply()
}


fun Context.getUserType(): Int {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getInt("userType", -1)

}

fun Context.setUserType(userType: Int) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putInt("userType", userType).apply()
}


fun Context.setLanguage(languageCode: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("language", languageCode).apply()
}

fun Context.getLanguage(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("language", "fr") ?: "fr"
}


fun Context.setCurrentLocation(location: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("current_location", location).apply()
}

fun Context.getCurrentLocation(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("current_location", "") ?: ""
}


fun Context.getSeenOnBoarding(): Boolean {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getBoolean("seen_onboarding", false)

}

fun Context.setSeenOnBoarding(flag: Boolean) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putBoolean("seen_onboarding", flag).apply()
}


fun Context.getJobSearchType(): Boolean {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getBoolean("job_search_type", false)

}

fun Context.setJobSearchType(flag: Boolean) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putBoolean("job_search_type", flag).apply()
}
