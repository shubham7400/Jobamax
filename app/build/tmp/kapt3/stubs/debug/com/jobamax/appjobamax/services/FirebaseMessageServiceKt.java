package com.jobamax.appjobamax.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationManagerCompat;
import com.adjust.sdk.Adjust;
import com.jobamax.appjobamax.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.jobamax.appjobamax.NewSplashActivity;
import com.pushwoosh.firebase.PushwooshFcmHelper;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0002"}, d2 = {"CHANNEL_ID", "", "app_debug"})
public final class FirebaseMessageServiceKt {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID = "HEADS_UP_NOTIFICATION";
}