package com.findajob.jobamax.model.fcm;

data class PushNotification(
    val data: NotificationData,
    val to: String
)