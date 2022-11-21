package  com.jobamax.appjobamax.services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat
import com.adjust.sdk.Adjust
import com.jobamax.appjobamax.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.jobamax.appjobamax.NewSplashActivity

import com.jobamax.appjobamax.preference.setDeepLink
import com.pushwoosh.firebase.PushwooshFcmHelper


const val CHANNEL_ID = "HEADS_UP_NOTIFICATION"
class FirebaseMessageService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        PushwooshFcmHelper.onTokenRefresh(token)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        val pushToken = remoteMessage.data["to"] // token to track installation and uninstallation tracking
        if (pushToken != null) {
            if (pushToken.isNotEmpty()){
                Adjust.setPushToken(pushToken, applicationContext)
            }
        }else{
            val title = remoteMessage.data["header"] ?: ""
            val message = remoteMessage.data["title"] ?: ""
            val link = remoteMessage.data["l"]

            val channel = NotificationChannel(CHANNEL_ID, "heads up notification", NotificationManager.IMPORTANCE_HIGH)
            val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.createNotificationChannel(channel)

            val notification = Notification.Builder(this, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.logo_jobamax)
                .setAutoCancel(true)

            if (link != null) {
                setDeepLink(link)
                val notificationIntent = Intent(applicationContext, NewSplashActivity::class.java).also { intent ->
                    intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                }
                val intent = PendingIntent.getActivity(applicationContext, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)
                notification.setContentIntent(intent)
                NotificationManagerCompat.from(this).notify(1,notification.build())
            }else{
                NotificationManagerCompat.from(this).notify(1,notification.build())
            }

        }
    }


}