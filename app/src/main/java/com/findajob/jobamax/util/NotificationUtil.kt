package com.findajob.jobamax.util

import android.app.Notification
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.findajob.jobamax.R
import com.findajob.jobamax.recruiter.home.RecruiterHomeActivity
import org.jetbrains.anko.notificationManager


const val ACTION_YES = "action_yes"
const val ACTION_NO = "action_no"
const val CHECK_JOB_OFFER_CHANNEL = "checkJobOffer"

fun Context.showNotification(jobId: String, jobName: String) {
	
	val mBuilder: NotificationCompat.Builder = NotificationCompat.Builder(this, CHECK_JOB_OFFER_CHANNEL)
	
	val bigPictureView = RemoteViews(packageName, R.layout.notification_check_job_offer)
	
	
	bigPictureView.setTextViewText(R.id.content_title, "Checking on $jobName Job")
	
	
	val yesPendingIntent = buildPendingIntent(action = ACTION_YES, jobId = jobId, jobName = jobName)
	bigPictureView.setOnClickPendingIntent(R.id.yesButton, yesPendingIntent)
	
	val noPendingIntent = buildPendingIntent(action = ACTION_NO, jobId = jobId, jobName = jobName)
	bigPictureView.setOnClickPendingIntent(R.id.noButton, noPendingIntent)
	
	val notificationIntent = Intent(this, RecruiterHomeActivity::class.java)
	val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
	
	val status = mBuilder.setSmallIcon(R.mipmap.ic_launcher)
		.setContentIntent(pendingIntent)
		.setPriority(NotificationCompat.PRIORITY_MAX)
		.setCustomBigContentView(bigPictureView)
		.setDefaults(0)
		.setOnlyAlertOnce(true)
		.setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
		.build()
	status.flags = Notification.FLAG_ONGOING_EVENT
	status.contentIntent = pendingIntent
	notificationManager.notify(568, status)
}

private fun Context.buildPendingIntent(action: String, jobId: String, jobName: String): PendingIntent {
	val intentAction = Intent(this, ActionReceiver::class.java)
	intentAction.action = action
	intentAction.putExtra(ARG_JOB_NAME, jobName)
	intentAction.putExtra(ARG_JOB_ID, jobId)
	intentAction.action = action
	return PendingIntent.getBroadcast(this, 1, intentAction, PendingIntent.FLAG_UPDATE_CURRENT)
}


class ActionReceiver : BroadcastReceiver() {
	override fun onReceive(context: Context, intent: Intent) {
		val action = intent.action
		if (action == ACTION_NO) {
			log("ACTION_NO")
			context.notificationManager.cancel(568)
		} else if (action == ACTION_YES) {
			log("ACTION_YES")
			context.notificationManager.cancel(568)
			val resultIntent = Intent(context, RecruiterHomeActivity::class.java)
			resultIntent.putExtra(ARG_JOB_NAME, intent.getStringExtra(ARG_JOB_NAME))
			resultIntent.putExtra(ARG_JOB_ID, intent.getStringExtra(ARG_JOB_ID))
			resultIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
			context.startActivity(resultIntent)
		}
		val it = Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)
		context.sendBroadcast(it)
	}
}

class JobOfferAlarmReceiver : BroadcastReceiver() {
	override fun onReceive(context: Context, intent: Intent) {
		val job = intent.getStringExtra(ARG_JOB_NAME) ?: ""
		val id = intent.getStringExtra(ARG_JOB_ID) ?: ""
		context.showNotification(id, job)
	}
	
}
