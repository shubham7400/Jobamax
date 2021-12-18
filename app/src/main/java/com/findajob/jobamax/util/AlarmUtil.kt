package com.findajob.jobamax.util

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.findajob.jobamax.BuildConfig
import com.findajob.jobamax.model.JobOffer
import com.findajob.jobamax.preference.isLoggedIn
import java.util.*


fun Context.setAlarm(jobOffer: JobOffer) {
    val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager?
    val alarmIntent = Intent(this, JobOfferAlarmReceiver::class.java)
    alarmIntent.putExtra(ARG_JOB_NAME, jobOffer.name)
    alarmIntent.putExtra(ARG_JOB_ID, jobOffer.jobOfferId)
    val pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        PendingIntent.getBroadcast(
            this,
            jobOffer.jobOfferId.toIntValue(),
            alarmIntent,
            PendingIntent.FLAG_IMMUTABLE
        )
    } else {
        PendingIntent.getBroadcast(
            this,
            jobOffer.jobOfferId.toIntValue(),
            alarmIntent,
            0
        )
    }
    alarmManager?.cancel(pendingIntent)
    alarmManager?.setExact(
        AlarmManager.RTC_WAKEUP,
        Date().time + 14 * 24 * 60 * 60 * 1000,
        pendingIntent
    )
    log("Alarm set")
}

fun Context.cancelAlarm(offerId: String) {
    val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager?
    val alarmIntent = Intent(this, JobOfferAlarmReceiver::class.java)
    val pendingIntent = PendingIntent.getBroadcast(
        this,
        offerId.toIntValue(),
        alarmIntent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )
    alarmManager?.cancel(pendingIntent)
    log("Alarm cancelled")
}

private fun String.toIntValue(): Int {
    var id = 0
    this.forEach {
        id += it.toInt()
    }
    return id
}