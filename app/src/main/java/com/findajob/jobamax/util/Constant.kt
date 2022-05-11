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
const val JOB_SEEKER_TYPE = "1"
const val PROFILE_PIC_URL = "profile_pic_url"
const val FRENCH_LANG_CODE = "fr"
const val ENGLISH_LANG_CODE = "en"
val trackingEventMap = hashMapOf(
    "Online interview" to "Entretien en ligne",
    "Assesment" to "Évaluation",
    "Phone call" to "Appel téléphonique",
    "Interview" to "Entretien",
    "Hired" to "Embauché",
    "Refused" to "Refusé",
    "Added to wishlist" to "Ajouté à la liste de souhaits"
)


const val GOOGLE_LOGIN_TYPE = "google"

const val JOBAMAX_DOWNLOAD_URL = "https://jobamax.com/en/download"







