package com.findajob.jobamax.training.model

object ConstantApp {
    const val APP_BUILD_DATE = "today"
    const val BASE_VALUE_PERMISSION = 0X0001
    const val PERMISSION_REQ_ID_RECORD_AUDIO = BASE_VALUE_PERMISSION + 1
    const val PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE = BASE_VALUE_PERMISSION + 3
    const val ACTION_KEY_CROLE = "C_Role"
    const val ACTION_KEY_ROOM_NAME = "ecHANEL"

    const val SERVER_HOST_GOOGLE: String = "https://maps.googleapis.com"

    // it's for testing purpose, this should be replaced
    const val GOOGLE_PLAY_SERVICE_API = "AIzaSyA4NEv4m7rHGc22VGJz6ffdz2VIgY31avY"
//    const val GOOGLE_PLAY_SERVICE_API = "AIzaSyDZUmO0p73MG2tjUJe2LUOvnZ0blB1Wx_0"
//    const val GOOGLE_PLAY_SERVICE_API = "AIzaSyA4NEv4m7rHGc22VGJz6ffdz2VIgY31avZ"


    object PrefManager {
        const val PREF_PROPERTY_UID = "pOCXx_uid"
    }

    object AppError {
        const val NO_NETWORK_CONNECTION = 3
    }
}