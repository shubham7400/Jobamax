package com.jobamax.appjobamax.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.lifecycle.LifecycleObserver
import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustConfig
import com.google.firebase.messaging.FirebaseMessaging
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.preference.getUserObjectId
import com.jobamax.appjobamax.preference.getUserType
import com.jobamax.appjobamax.preference.isLoggedIn
import com.jobamax.appjobamax.util.UX_CAM_API_KEY
import com.parse.Parse
import com.parse.ParseInstallation
import com.parse.ParseObject
import com.parse.ParseQuery
import com.pushwoosh.Pushwoosh
import com.uxcam.UXCam
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class BaseApplication : Application(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
        subscribeToFirebaseMessagingTopics()
        initialiseParseSdk()
        Pushwoosh.getInstance().registerForPushNotifications( ) // registering pushwoosh notification
        updateAppUsageCount()
        configureUXCam()
        configureAdjustSdk()
    }

    private fun configureAdjustSdk() {
        val appToken = "sltokgaoe58g"
        val environment = AdjustConfig.ENVIRONMENT_PRODUCTION
        val config = AdjustConfig(this, appToken, environment)
        Adjust.onCreate(config)

        registerActivityLifecycleCallbacks(AdjustLifecycleCallbacks())
    }


    private fun configureUXCam() {
        UXCam.startWithKey(UX_CAM_API_KEY)
    }



    private fun updateAppUsageCount() {
        if (isLoggedIn()) {
            if (getUserType() == 2){
                if (getUserId() != ""){
                    updateAppUsage()
                }
            }
        }
    }

    /* stores the app usage count */
    private fun updateAppUsage() {
        val query = ParseQuery<ParseObject>(ParseTableName.NOTIFICATION.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, getUserId())
        query.getFirstInBackground { result, e ->
            when{
                e != null -> {
                    val notification = ParseObject(ParseTableName.NOTIFICATION.value)
                    getCurrentJobSeeker{
                        if (it != null) {
                            notification.put("jobSeeker", it)
                        }
                        notification.put("jobSeekerId", getUserId())
                        notification.put("lastUsageTime", (System.currentTimeMillis() / 1000))
                        notification.put("appUsageCount", 1)
                        notification.saveInBackground { exception ->
                            if (exception != null){ toast(exception.message.toString())}
                        }
                    }
                }
                else -> {
                    result.put("lastUsageTime", (System.currentTimeMillis() / 1000))
                    result.put("appUsageCount", result.getInt("appUsageCount").plus(1))
                    result.saveInBackground {
                        if (it != null){ toast(it.message.toString())}
                    }
                }
            }
        }
    }

    private fun getCurrentJobSeeker(call: (ParseObject?) -> Unit)  {
        var parseObject: ParseObject? = null
        val query = ParseQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo("jobSeekerId", getUserId())
        query.getFirstInBackground { result, e ->
            when{
                e != null -> {
                    call(parseObject)
                    toast(e.message.toString())
                }
                else -> {
                    parseObject = result
                    call(parseObject)
                }
            }
        }
    }




    private fun subscribeToFirebaseMessagingTopics() {
        FirebaseMessaging.getInstance().subscribeToTopic("/topics/abc123456789")
        FirebaseMessaging.getInstance().subscribeToTopic("/topics/" + getUserId())
        getUserObjectId().let {
            FirebaseMessaging.getInstance().subscribeToTopic("/topics/$it")
        }
    }

    private fun initialiseParseSdk() {
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        )

        val installation = ParseInstallation.getCurrentInstallation()
        installation.put("GCMSenderId", "916226274147")
        installation.saveInBackground()
    }


    private class AdjustLifecycleCallbacks : ActivityLifecycleCallbacks {
        override fun onActivityCreated(p0: Activity, p1: Bundle?) {}
        override fun onActivityStarted(p0: Activity) {}
        override fun onActivityStopped(p0: Activity) {}
        override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {}
        override fun onActivityDestroyed(p0: Activity) {}
        override fun onActivityResumed(activity: Activity) {
            Adjust.onResume()
        }
        override fun onActivityPaused(activity: Activity) {
            Adjust.onPause()
        }
    }
}
