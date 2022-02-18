package com.findajob.jobamax

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.findajob.jobamax.data.pojo.Chat
import com.findajob.jobamax.data.pojo.Message
import com.findajob.jobamax.model.Event
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.preference.getUserObjectId
import com.findajob.jobamax.training.model.CurrentUserSettings
import com.findajob.jobamax.training.model.WorkerThread
import com.findajob.jobamax.util.*
import com.google.firebase.messaging.FirebaseMessaging
import com.parse.Parse
import com.parse.ParseInstallation
import com.parse.ParseObject
import com.parse.ParseUser
import com.parse.facebook.ParseFacebookUtils
import com.parse.google.ParseGoogleUtils
import com.pushwoosh.Pushwoosh
import com.stripe.android.PaymentConfiguration
import com.uxcam.UXCam
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins
import org.json.JSONException
import org.json.JSONObject
import timber.log.Timber
import java.util.HashMap


@HiltAndroidApp
class BaseApplication : Application(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
        subscribeToFirebaseMessagingTopics()
        initialiseParseSdk()
        setUpNotificationChannel()
      /*  configurePushWoosh()*/
        configurePayment()
        configureRxJava()
        configureUXCam()
//        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    /*private fun configurePushWoosh() {
        Pushwoosh.getInstance().registerForPushNotifications()
    }
*/

    private fun configureUXCam() {
        UXCam.startWithKey(UX_CAM_API_KEY)
    }


    private fun configureRxJava() {
        RxJavaPlugins.setErrorHandler { e ->
            if (e is UndeliverableException) {
                // Merely log undeliverable exceptions
                log("the error could not be delivered ${e.message}")
            } else {
                // Forward all others to current thread's uncaught exception handler
                Thread.currentThread().also { thread ->
                    thread.uncaughtExceptionHandler?.uncaughtException(thread, e)
                }
            }
        }
    }

    private fun setUpNotificationChannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val manager = getSystemService(NotificationManager::class.java)
            val checkJobOfferChannel = NotificationChannel(
                CHECK_JOB_OFFER_CHANNEL,
                "Check Job Offer",
                NotificationManager.IMPORTANCE_HIGH
            )
            manager?.createNotificationChannel(checkJobOfferChannel)
        }
    }

    private fun configurePayment() {
        PaymentConfiguration.init(
            applicationContext,
            STRIPE_PUBLISHABLE_KEY
        )
    }

    private fun subscribeToFirebaseMessagingTopics() {
        FirebaseMessaging.getInstance().subscribeToTopic("/topics/abc123456789")
        FirebaseMessaging.getInstance().subscribeToTopic("/topics/" + getUserId())
        getUserObjectId().let {
            FirebaseMessaging.getInstance().subscribeToTopic("/topics/$it")
            Timber.d("onCreate: /topics/$it")
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
        ParseFacebookUtils.initialize(this)
        ParseGoogleUtils.initialize(getString(R.string.default_web_client_id))

        ParseObject.registerSubclass(Message::class.java)
        ParseObject.registerSubclass(Chat::class.java)
        ParseObject.registerSubclass(Event::class.java)


    }

    private var mWorkerThread: WorkerThread? = null

    @Synchronized
    fun initWorkerThread() {
        if (mWorkerThread == null) {
            mWorkerThread = WorkerThread(applicationContext)
            mWorkerThread?.start()
            mWorkerThread?.waitForReady()
        }
    }

    @Synchronized
    fun getWorkerThread(): WorkerThread? {
        return mWorkerThread
    }

    @Synchronized
    fun deInitWorkerThread() {
        mWorkerThread?.exit()
        try {
            mWorkerThread?.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        mWorkerThread = null
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackgrounded() {
        val user = ParseUser.getCurrentUser()
        if (user != null) {
            user.put("isActive", false)
            user.save()
            sendActiveNotification()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAppForegrounded() {
        val user = ParseUser.getCurrentUser()
        if (user != null) {
            user.put("isActive", true)
            user.save()
            sendActiveNotification()
        }
    }

    fun sendActiveNotification() {
        val topic =
            "/topics/$ARG_REFRESH_ACTIVE" //topic has to match what the receiver subscribed to

        val notification = JSONObject()
        val notificationBody = JSONObject()

        try {
            notificationBody.put("title", ARG_REFRESH_ACTIVE)
            notificationBody.put(
                "message",
                ParseUser.getCurrentUser().objectId
            )   //Enter your notification message
            notification.put("to", topic)
            notification.put("data", notificationBody)
            log("try")
        } catch (e: JSONException) {
            log("onCreate: " + e.message)
        }

        sendNotification(notification)
    }

    private val requestQueue: RequestQueue by lazy { Volley.newRequestQueue(this) }

    private fun sendNotification(notification: JSONObject) {
        log("sendNotification")
        val serverKey = "key=$FCM_SERVER_KEY"
        val contentType = "application/json"
        val jsonObjectRequest = object : JsonObjectRequest(
            FCM_API,
            notification,
            Response.Listener { response -> log("onResponse: $response") },
            Response.ErrorListener { log("onErrorResponse: Didn't work" + it?.message) }) {
            override fun getHeaders(): Map<String, String> {
                val params = HashMap<String, String>()
                params["Authorization"] = serverKey
                params["Content-Type"] = contentType
                return params
            }
        }
        requestQueue.add(jsonObjectRequest)
    }

    companion object {
        val mAudioSettings: CurrentUserSettings = CurrentUserSettings()
    }
}
