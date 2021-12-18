package com.findajob.jobamax

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import com.findajob.jobamax.dashboard.messages.ChatActivity
import com.findajob.jobamax.preference.getNewMatchPNFlag
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.*
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.util.*

class NewMatchFirebaseMessagingService : FirebaseMessagingService() {
    private val MATCH_CHANNEL_ID = "match_channel"

    lateinit var intent: Intent

    override fun onMessageReceived(p0: RemoteMessage) {
        log("onMessageReceived() ${p0.data}")
        super.onMessageReceived(p0)

        if (p0.data["type"] == "message" && !getUserId().isNullOrEmpty()) {
            intent = Intent(this, ChatActivity::class.java)
            bundleOf(
                Pair(ChatActivity.EXTRA_RECEIVER_ID, p0.data["receiverObjectId"]),
                Pair(ChatActivity.EXTRA_RECEIVER_NAME, p0.data["receiverObjectName"])
            ).apply { intent.putExtras(this) }
        } else if (p0.data["type"] == NETWORKING_ROOM && !getUserId().isNullOrEmpty()) {
            // todo: launch networking room from here
            intent = Intent(this, MainActivity::class.java)
        } else {
            intent = Intent(this, MainActivity::class.java)
        }

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notificationID = Random().nextInt(3000)

        if (p0.data["title"] == "refresh") {
            if (p0.data["message"] == getUserId()) {
                log("Same User")
                return
            }

            log("Different User")

            val i = Intent()
            i.action = ARG_REFRESH_ROOM
            sendBroadcast(i)
            return
        }

        if (p0.data["title"] == ARG_CHAT_REQUIREMENTS) {
            if (p0.data["message"] == getUserId()) {
                log("Same User")
                return
            }

            val i = Intent()
            i.action = ARG_CHAT_REQUIREMENTS
            i.putExtra("requirements", p0.data["requirements"])
            sendBroadcast(i)
            return
        }

        if (p0.data["title"] == ARG_REFRESH_ACTIVE) {
            if (p0.data["message"] == getUserId()) {
                log("Same User")
                return
            }

            val i = Intent()
            i.action = ARG_REFRESH_ACTIVE
            sendBroadcast(i)
            return
        }

        if (!getNewMatchPNFlag())
            return


        /*
        Apps targeting SDK 26 or above (Android O) must implement notification channels and add its notifications
        to at least one of them.
      */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setupChannels(notificationManager)
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        } else {
            PendingIntent.getActivity(this, 0, intent, 0)
        }
        val notificationSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, MATCH_CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(p0.data["title"])
            .setContentText(p0.data["message"])
            .setAutoCancel(true)
            .setSound(notificationSoundUri)
            .setContentIntent(pendingIntent)

        //Set notification color to match your app color template
        notificationBuilder.color =
            ContextCompat.getColor(applicationContext, R.color.colorPrimary)
        notificationManager.notify(notificationID, notificationBuilder.build())
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private fun setupChannels(notificationManager: NotificationManager?) {
        val adminChannelName = "Matches"
        val adminChannelDescription = "Device to device notification"

        val adminChannel: NotificationChannel
        adminChannel = NotificationChannel(
            MATCH_CHANNEL_ID,
            adminChannelName,
            NotificationManager.IMPORTANCE_HIGH
        )
        adminChannel.description = adminChannelDescription
        adminChannel.enableLights(true)
        adminChannel.lightColor = Color.RED
        adminChannel.enableVibration(true)
        notificationManager?.createNotificationChannel(adminChannel)
    }
}
