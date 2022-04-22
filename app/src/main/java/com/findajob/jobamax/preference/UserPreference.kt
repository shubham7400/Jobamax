package com.findajob.jobamax.preference

import android.content.Context
import com.findajob.jobamax.jobseeker.model.JobSeekerJobFilter
import com.findajob.jobamax.model.User


private const val FILE_NAME = "user_pref"

fun Context.saveLocally(user: User, role: String) {
	setUserId(user.id)
	setPhoneNumber(user.phoneNumber)
	setLoginType(user.loginType)
	setRole(role)
}

fun Context.clearUserPref() {
	setUserId("")
	setPhoneNumber("")
	setLoginType("")
	setRole("")
	setProfilePicUrl("")
	setUserObjectId("")
	setLoggedIn(false)
	setUserFullName("")
}

fun Context.getRole(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("user_role", "") ?: ""
}

fun Context.setRole(role: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("user_role", role).apply()
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


fun Context.getUserFullName(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("user_full_name", "") ?: ""
}

fun Context.setUserFullName(str: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("user_full_name", str).apply()
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

fun Context.getPhoneNumber(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("user_phone_number", "") ?: ""
}

fun Context.setPhoneNumber(phone: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("user_phone_number", phone).apply()
}


fun Context.getProfilePicUrl(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("user_profile_pic", "") ?: ""
}

fun Context.setProfilePicUrl(logoUrl: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("user_profile_pic", logoUrl).apply()
}


fun Context.getNewMatchPNFlag(): Boolean {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getBoolean("newMatchPNFlag", true)
}

fun Context.setNewMatchPNFlag(flag: Boolean) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putBoolean("newMatchPNFlag", flag).apply()
}

fun Context.getAdvertisingCheck(): Boolean {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getBoolean("advertisingCheck", true)
}

fun Context.setAdvertisingCheck(flag: Boolean) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putBoolean("advertisingCheck", flag).apply()
}


fun Context.getMarketingCheck(): Boolean {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getBoolean("marketingCheck", true)
}

fun Context.setMarketingCheck(flag: Boolean) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putBoolean("marketingCheck", flag).apply()
}


fun Context.getSocialMediaCheck(): Boolean {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getBoolean("socialMediaCheck", true)
}

fun Context.setSocialMediaCheck(flag: Boolean) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putBoolean("socialMediaCheck", flag).apply()
}

fun Context.getEmail(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("email", "") ?: ""
}

fun Context.setEmail(email: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("email", email).apply()
}

fun Context.getPassword(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("password", "") ?: ""

}

fun Context.setPassword(password: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("password", password).apply()
}

fun Context.getUserType(): Int {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getInt("userType", -1) ?: -1

}

fun Context.setUserType(userType: Int) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putInt("userType", userType).apply()
}

fun Context.setJobSeekerJobFilter(jobSeekerJobFilter: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("jobFilter", jobSeekerJobFilter).apply()
	if (jobSeekerJobFilter == ""){
		setJobSearchFilterCategories("")
	}
}

fun Context.getJobSeekerJobFilter(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("jobFilter", "") ?: ""
}

fun Context.setLanguage(languageCode: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("language", languageCode).apply()
}

fun Context.getLanguage(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("language", "en") ?: "en"
}

fun Context.setJobSearchFilterCategories(categories: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("job_search_categories", categories).apply()
}

fun Context.getJobSearchFilterCategories(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("job_search_categories", "") ?: ""
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

fun Context.setJobSearchScreenEnterTime(seconds: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("job_search_enter_time", seconds).apply()
}

fun Context.getJobSearchScreenEnterTime(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("job_search_enter_time", "") ?: ""
}

fun Context.setAppEnterTime(seconds: String) {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	val editor = sharedPreferences.edit()
	editor.putString("app_enter_time", seconds).apply()
}

fun Context.getAppEnterTime(): String {
	val sharedPreferences = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
	return sharedPreferences.getString("app_enter_time", "") ?: ""
}
