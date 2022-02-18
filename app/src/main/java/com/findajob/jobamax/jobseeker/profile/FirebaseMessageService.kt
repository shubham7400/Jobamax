package  com.findajob.jobamax.jobseeker.profile

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat
import com.findajob.jobamax.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.pushwoosh.firebase.PushwooshFcmHelper

class FirebaseMessageService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        Log.d("TAG", "Refreshed token: $token")
        PushwooshFcmHelper.onTokenRefresh(token)


        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // FCM registration token to your app server.
        /*sendRegistrationToServer(token)*/
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.i("TAG", "onMessageReceived: djfksdkfsd ")
        val title = remoteMessage.notification?.title
        val text = remoteMessage.notification?.body
        Log.i("TAG", "onMessageReceived: sfdf $title")
        Log.i("TAG", "onMessageReceived: sfdf  $text")
        val CHANNEL_ID = "HEADS_UP_NOTIFICATION"
        val channel = NotificationChannel(CHANNEL_ID, "heads up notification", NotificationManager.IMPORTANCE_HIGH)
        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mNotificationManager.createNotificationChannel(channel)
        val notification = Notification.Builder(this, CHANNEL_ID).setContentTitle(title)
            .setContentText(text)
            .setSmallIcon(R.drawable.add_icon)
            .setAutoCancel(true)
        NotificationManagerCompat.from(this).notify(1,notification.build())
    }
}