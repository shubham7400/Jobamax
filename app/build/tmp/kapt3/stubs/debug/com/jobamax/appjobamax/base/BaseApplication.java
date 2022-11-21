package com.jobamax.appjobamax.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.LifecycleObserver;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.google.firebase.messaging.FirebaseMessaging;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.pushwoosh.Pushwoosh;
import com.uxcam.UXCam;
import dagger.hilt.android.HiltAndroidApp;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\u0007\u001a\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00050\tH\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/jobamax/appjobamax/base/BaseApplication;", "Landroid/app/Application;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "configureAdjustSdk", "", "configureUXCam", "getCurrentJobSeeker", "call", "Lkotlin/Function1;", "Lcom/parse/ParseObject;", "initialiseParseSdk", "onCreate", "subscribeToFirebaseMessagingTopics", "updateAppUsage", "updateAppUsageCount", "AdjustLifecycleCallbacks", "app_debug"})
@dagger.hilt.android.HiltAndroidApp()
public final class BaseApplication extends android.app.Application implements androidx.lifecycle.LifecycleObserver {
    
    public BaseApplication() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final void configureAdjustSdk() {
    }
    
    private final void configureUXCam() {
    }
    
    private final void updateAppUsageCount() {
    }
    
    private final void updateAppUsage() {
    }
    
    private final void getCurrentJobSeeker(kotlin.jvm.functions.Function1<? super com.parse.ParseObject, kotlin.Unit> call) {
    }
    
    private final void subscribeToFirebaseMessagingTopics() {
    }
    
    private final void initialiseParseSdk() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/jobamax/appjobamax/base/BaseApplication$AdjustLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "onActivityCreated", "", "p0", "Landroid/app/Activity;", "p1", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "activity", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "app_debug"})
    static final class AdjustLifecycleCallbacks implements android.app.Application.ActivityLifecycleCallbacks {
        
        public AdjustLifecycleCallbacks() {
            super();
        }
        
        @java.lang.Override()
        public void onActivityCreated(@org.jetbrains.annotations.NotNull()
        android.app.Activity p0, @org.jetbrains.annotations.Nullable()
        android.os.Bundle p1) {
        }
        
        @java.lang.Override()
        public void onActivityStarted(@org.jetbrains.annotations.NotNull()
        android.app.Activity p0) {
        }
        
        @java.lang.Override()
        public void onActivityStopped(@org.jetbrains.annotations.NotNull()
        android.app.Activity p0) {
        }
        
        @java.lang.Override()
        public void onActivitySaveInstanceState(@org.jetbrains.annotations.NotNull()
        android.app.Activity p0, @org.jetbrains.annotations.NotNull()
        android.os.Bundle p1) {
        }
        
        @java.lang.Override()
        public void onActivityDestroyed(@org.jetbrains.annotations.NotNull()
        android.app.Activity p0) {
        }
        
        @java.lang.Override()
        public void onActivityResumed(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity) {
        }
        
        @java.lang.Override()
        public void onActivityPaused(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity) {
        }
    }
}