package com.findajob.jobamax

import android.app.Application
import android.content.res.Configuration
import android.content.res.Resources
import androidx.lifecycle.LifecycleObserver
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.preference.*
import com.findajob.jobamax.util.*
import com.google.firebase.messaging.FirebaseMessaging
import com.parse.*
import com.pushwoosh.Pushwoosh
 import dagger.hilt.android.HiltAndroidApp
import java.util.*


@HiltAndroidApp
class BaseApplication : Application(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
        subscribeToFirebaseMessagingTopics()
        initialiseParseSdk()
        setJobSeekerJobFilter("")
        Pushwoosh.getInstance().registerForPushNotifications( ) // registering pushwoosh notification
        updateAppUsageCount()
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

    private fun updateAppUsage() {
        val query = ParseQuery<ParseObject>(ParseTableName.Notification.toString())
        query.whereEqualTo(ParseTableFields.jobSeekerId.toString(), getUserId())
        query.getFirstInBackground { result, e ->
            when{
                e != null -> {
                    val notification = ParseObject(ParseTableName.Notification.toString())
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
        val query = ParseQuery<ParseObject>(ParseTableName.JobSeeker.toString())
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
}
