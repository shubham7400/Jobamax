package com.findajob.jobamax.services

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import com.findajob.jobamax.R
import com.findajob.jobamax.preference.setCurrentLocation
import com.findajob.jobamax.util.convertCustomObjectToJsonString
import com.findajob.jobamax.util.toast
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore
import com.google.gson.Gson


class LocationService : Service(){
    private val NOTIFICATION_CHANNEL_ID = "notification_location"
    private var LOCATION_REFRESH_TIME = 10000
    private var LOCATION_REFRESH_DISTANCE = 0

    var mLocation: Location? = null

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID).setOngoing(false).setSmallIcon(R.drawable.logo_jobamax_blue)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager  = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val notificationChannel = NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_ID, NotificationManager.IMPORTANCE_LOW)
            notificationChannel.description = NOTIFICATION_CHANNEL_ID
            notificationChannel.setSound(null, null)
            notificationManager.createNotificationChannel(notificationChannel)
            startForeground(1, builder.build())
        }
    }

    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            mLocation = location
            mLocation?.let {
                val loc = com.findajob.jobamax.data.pojo.Location()
                loc.lat = it.latitude
                loc.long = it.longitude
                applicationContext.setCurrentLocation(convertCustomObjectToJsonString(loc))
            }
        }

        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        startListeningUserLocation(this, locationListener)
        return START_STICKY
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            stopForeground(true)
        }else{
            val nm = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            nm.cancel(1)
        }
        this.stopSelf()
    }

    private fun startListeningUserLocation(context: Context, myListener: LocationListener) {
        val mLocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_REFRESH_TIME.toLong(), LOCATION_REFRESH_DISTANCE.toFloat(), myListener)
    }




}