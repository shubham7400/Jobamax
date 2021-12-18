package com.findajob.jobamax.model.fcm;

data class NotificationData(
    val title: String,
    val message: String,
    val type: String = "message",
    val receiverObjectId: String,
    val receiverObjectName: String
)