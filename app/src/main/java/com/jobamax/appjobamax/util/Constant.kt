 package com.jobamax.appjobamax.util

import android.Manifest
import android.widget.ImageView



const val ARG_USER = "arg_user"
const val ARG_WEB_URL = "arg_web_url"

const val REQUEST_ALL_PERMISSIONS = 101

val permissions = arrayOf( Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION)
const val JOB_SEEKER_TYPE = "1"
const val PROFILE_PIC_URL = "profile_pic_url"
const val FRENCH_LANG_CODE = "fr"


val contractMap = linkedMapOf(
    "internship" to "stage",
    "apprenticeship" to "alternance",
    "partTime" to "CDD",
    "permanent" to "CDI"
)
const val INTERNSHIP = "stage"
const val APPRENTICESHIP = "alternance"
const val PART_TIME = "CDD"
const val PERMANENT = "CDI"


val experienceMap = linkedMapOf(
    "under-one" to "< 1 an d’expérience",
    "one-two" to "1-2 ans d’expérience",
    "two-more" to "2-3 ans d’expérience"
)
 const val UNDER_ONE = "under-one"
 const val ONE_OR_WTO = "one-two"
 const val TWO_OR_THREE = "two-three"


 val companySizeList = arrayListOf(
     "1-15",
     "16-49",
     "50-249",
     "250-999",
     "1000+")

 enum class StudentStatus(val status: String){
     CURRENT("étudiant"),
     NON_CURRENT("jeune actif")
 }

 val reportReason = arrayListOf(
     "Sélectionner la raison",
     "Contenu violent ou répugnant",
     "Contenu haineux ou abusif",
     "Actes nuisibles ou dangereux",
     "Spam ou tromperie",
 )

val seekerSelectionSteps = hashMapOf(
    "Candidatures reçues" to 0,
    "Pré-qualification" to 1,
    "Prise de contact" to 2,
    "Entretien RH" to 3,
    "Entretien Manager" to 4,
    "Sélection" to 5,
    "Refus" to 6,
    "Recrutement" to 7,
)

 val seekerSelectionStepsV2 = hashMapOf(
     "selection0" to "Candidatures reçues",
     "selection1" to "dfls",
     "selection2" to "dfls",
     "selection3" to "dfls",
     "selection4" to "dfls",
     "selection5" to "dfls",
     "selection6" to "dfls",
     "selection7" to "dfls",
 )


const val GOOGLE_LOGIN_TYPE = "google"

const val JOBAMAX_DOWNLOAD_URL = "https://jobamax.page.link/"
const val ALGORITHM = "AES"
const val KEY = "CFZEGEN642DDX54A"

const val LOCATION_REFRESH_TIME = 10000
const val LOCATION_REFRESH_DISTANCE = 0

const val MSG = "Device is not connected to the internet."

// UXCam api-key
const val UX_CAM_API_KEY = "9nkbriit16rt492"










