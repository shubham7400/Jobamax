package com.findajob.jobamax.util

import android.Manifest


const val ROLE_JOB_SEEKER = "job_seeker"
const val ROLE_RECRUITER = "recruiter"
const val ARG_LOCATION = "arg_location"
const val ARG_LAT = "arg_lat"
const val ARG_LNG = "arg_lng"
const val ARG_CITY = "arg_city"
const val ARG_ACTION = "arg_action"
const val ARG_USER = "arg_user"
const val ACTION_LOGIN = "login_action"
const val ACTION_REGISTER = "register_action"
const val AUTOCOMPLETE_REQUEST_CODE = 1007
const val ARG_WEB_URL = "arg_web_url"

const val REQUEST_ALL_PERMISSIONS = 101

val permissions = arrayOf( Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)


const val GOOGLE_LOGIN_TYPE = "google"

const val JOBAMAX_DOWNLOAD_URL = "https://jobamax.com/en/download"







