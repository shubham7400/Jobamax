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
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity
import com.pushwoosh.firebase.PushwooshFcmHelper

/*this class to get pushwoosh notifications*/

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
            }else{
                val title = remoteMessage.data["header"]
                val message = remoteMessage.data["title"]
                val channel = NotificationChannel(CHANNEL_ID, "heads up notification", NotificationManager.IMPORTANCE_HIGH)
                val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                mNotificationManager.createNotificationChannel(channel)
                val notificationIntent = Intent(applicationContext, JobSeekerHomeActivity::class.java)
                val intent = PendingIntent.getActivity(applicationContext, 0, notificationIntent, 0)
                val notification = Notification.Builder(this, CHANNEL_ID)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setSmallIcon(R.drawable.logo_jobamax_blue)
                    .setAutoCancel(true)
                    .setContentIntent(intent)
                NotificationManagerCompat.from(this).notify(1,notification.build())
            }
        }
    }
}