package com.jobamax.appjobamax.extensions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.ckdroid.dynamicpermissions.PermissionStatus;
import com.ckdroid.dynamicpermissions.PermissionUtils;
import com.google.gson.Gson;
import com.jobamax.appjobamax.model.Location;
import java.util.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\u000b\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\u0007\u001a\n\u0010\u0010\u001a\u00020\u000f*\u00020\u000b\u001a\n\u0010\u0010\u001a\u00020\u000f*\u00020\u0007\u001a>\u0010\u0011\u001a\u00020\n*\u00020\u00022\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u001a9\u0010\u001a\u001a\u00020\n\"\u0004\b\u0000\u0010\u001b*\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00132\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u001d\u00a2\u0006\u0002\b\u001e\u001a\n\u0010\u001f\u001a\u00020\n*\u00020\u0002\u001a\u0012\u0010\u001f\u001a\u00020\n*\u00020\u000b2\u0006\u0010 \u001a\u00020!\u001a\n\u0010\u001f\u001a\u00020\n*\u00020\u0007\u001a\n\u0010\"\u001a\u00020\u0001*\u00020\u000b\u001a\n\u0010#\u001a\u00020\n*\u00020\u000b\u001a\u0012\u0010$\u001a\u00020\n*\u00020\u00022\u0006\u0010%\u001a\u00020\u0005\u001a\u0012\u0010$\u001a\u00020\n*\u00020\u00072\u0006\u0010%\u001a\u00020\u0005\u001a\u0012\u0010&\u001a\u00020\n*\u00020\u000b2\u0006\u0010\'\u001a\u00020\u0005\u001a\u0012\u0010&\u001a\u00020\n*\u00020\u00072\u0006\u0010\'\u001a\u00020\u0005\u00a8\u0006("}, d2 = {"checkForPermissions", "", "Landroid/app/Activity;", "permissions", "", "", "(Landroid/app/Activity;[Ljava/lang/String;)Z", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;[Ljava/lang/String;)Z", "errorToast", "", "Landroid/content/Context;", "e", "", "getCurrentLatitude", "", "getCurrentLongitude", "goToActivity", "mClass", "Ljava/lang/Class;", "finishCurrentActivity", "extras", "Landroid/os/Bundle;", "withResult", "requestCode", "", "gotoActivity", "T", "it", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "hideKeyboard", "view", "Landroid/view/View;", "isNetworkConnected", "openAppSettings", "setLocale", "languageCode", "toast", "text", "app_debug"})
public final class ActivityKt {
    
    public static final <T extends java.lang.Object>void gotoActivity(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$gotoActivity, @org.jetbrains.annotations.NotNull()
    java.lang.Class<T> it, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.os.Bundle, kotlin.Unit> extras) {
    }
    
    public static final void goToActivity(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$goToActivity, @org.jetbrains.annotations.NotNull()
    java.lang.Class<?> mClass, boolean finishCurrentActivity, @org.jetbrains.annotations.Nullable()
    android.os.Bundle extras, boolean withResult, int requestCode) {
    }
    
    public static final boolean isNetworkConnected(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$isNetworkConnected) {
        return false;
    }
    
    public static final void setLocale(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$setLocale, @org.jetbrains.annotations.NotNull()
    java.lang.String languageCode) {
    }
    
    public static final void setLocale(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$setLocale, @org.jetbrains.annotations.NotNull()
    java.lang.String languageCode) {
    }
    
    public static final double getCurrentLatitude(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getCurrentLatitude) {
        return 0.0;
    }
    
    public static final double getCurrentLatitude(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$getCurrentLatitude) {
        return 0.0;
    }
    
    public static final double getCurrentLongitude(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getCurrentLongitude) {
        return 0.0;
    }
    
    public static final double getCurrentLongitude(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$getCurrentLongitude) {
        return 0.0;
    }
    
    public static final void toast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$toast, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public static final void toast(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$toast, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public static final void openAppSettings(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$openAppSettings) {
    }
    
    public static final void errorToast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$errorToast) {
    }
    
    public static final void errorToast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$errorToast, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable e) {
    }
    
    public static final boolean checkForPermissions(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$checkForPermissions, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions) {
        return false;
    }
    
    public static final boolean checkForPermissions(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$checkForPermissions, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions) {
        return false;
    }
    
    public static final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$hideKeyboard) {
    }
    
    public static final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$hideKeyboard) {
    }
    
    public static final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$hideKeyboard, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
}