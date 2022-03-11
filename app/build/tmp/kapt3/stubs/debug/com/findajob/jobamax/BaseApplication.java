package com.findajob.jobamax;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\u0006\u0010\u0010\u001a\u00020\rJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0012\u001a\u00020\rJ\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0007J\b\u0010\u0015\u001a\u00020\rH\u0007J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0006\u0010\u0017\u001a\u00020\rJ\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001e"}, d2 = {"Lcom/findajob/jobamax/BaseApplication;", "Landroid/app/Application;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "mWorkerThread", "Lcom/findajob/jobamax/training/model/WorkerThread;", "requestQueue", "Lcom/android/volley/RequestQueue;", "getRequestQueue", "()Lcom/android/volley/RequestQueue;", "requestQueue$delegate", "Lkotlin/Lazy;", "configurePayment", "", "configureRxJava", "configureUXCam", "deInitWorkerThread", "getWorkerThread", "initWorkerThread", "initialiseParseSdk", "onAppBackgrounded", "onAppForegrounded", "onCreate", "sendActiveNotification", "sendNotification", "notification", "Lorg/json/JSONObject;", "setUpNotificationChannel", "subscribeToFirebaseMessagingTopics", "Companion", "app_debug"})
@dagger.hilt.android.HiltAndroidApp()
public final class BaseApplication extends android.app.Application implements androidx.lifecycle.LifecycleObserver {
    private com.findajob.jobamax.training.model.WorkerThread mWorkerThread;
    private final kotlin.Lazy requestQueue$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.BaseApplication.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.findajob.jobamax.training.model.CurrentUserSettings mAudioSettings = null;
    
    public BaseApplication() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final void configureUXCam() {
    }
    
    private final void configureRxJava() {
    }
    
    private final void setUpNotificationChannel() {
    }
    
    private final void configurePayment() {
    }
    
    private final void subscribeToFirebaseMessagingTopics() {
    }
    
    private final void initialiseParseSdk() {
    }
    
    @kotlin.jvm.Synchronized()
    public final synchronized void initWorkerThread() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Synchronized()
    public final synchronized com.findajob.jobamax.training.model.WorkerThread getWorkerThread() {
        return null;
    }
    
    @kotlin.jvm.Synchronized()
    public final synchronized void deInitWorkerThread() {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_STOP)
    public final void onAppBackgrounded() {
    }
    
    @androidx.lifecycle.OnLifecycleEvent(value = androidx.lifecycle.Lifecycle.Event.ON_START)
    public final void onAppForegrounded() {
    }
    
    public final void sendActiveNotification() {
    }
    
    private final com.android.volley.RequestQueue getRequestQueue() {
        return null;
    }
    
    private final void sendNotification(org.json.JSONObject notification) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/BaseApplication$Companion;", "", "()V", "mAudioSettings", "Lcom/findajob/jobamax/training/model/CurrentUserSettings;", "getMAudioSettings", "()Lcom/findajob/jobamax/training/model/CurrentUserSettings;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.training.model.CurrentUserSettings getMAudioSettings() {
            return null;
        }
    }
}