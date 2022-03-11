package com.findajob.jobamax.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0007\u001a\u0012\u0010\u000f\u001a\u00020\u0004*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0012\u0010\u0011\u001a\u00020\u0004*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007\u001a\u001a\u0010\u0011\u001a\u00020\u0004*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015\u001a4\u0010\u0016\u001a\u00020\u0004*\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018\u001a\n\u0010\u001b\u001a\u00020\u0004*\u00020\u0002\u001a\u0012\u0010\u001c\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007\u001a\u0010\u0010\u001f\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070 \u001a\u0012\u0010!\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0007\u001a\u0012\u0010!\u001a\u00020\u0004*\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0007\u00a8\u0006\""}, d2 = {"checkLocationPermission", "", "Landroid/content/Context;", "debugToast", "", "Landroid/app/Activity;", "msg", "", "Landroidx/fragment/app/Fragment;", "inflate", "Landroid/view/View;", "Landroid/view/ViewGroup;", "layout", "", "isValidEmail", "isVisible", "flag", "log", "", "text", "e", "", "manageLocationPermission", "onGranted", "Lkotlin/Function0;", "onDeniedOne", "onPermanentlyDeniedAnyOne", "openAppSettings", "setUp", "Landroidx/appcompat/app/ActionBar;", "title", "toPlainString", "", "toast", "app_debug"})
public final class HelperExtensionKt {
    
    public static final void log(@org.jetbrains.annotations.NotNull()
    java.lang.Object $this$log, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public static final void log(@org.jetbrains.annotations.NotNull()
    java.lang.Object $this$log, @org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable e) {
    }
    
    public static final void toast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$toast, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public static final void toast(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$toast, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public static final void setUp(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.ActionBar $this$setUp, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    public static final void isVisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$isVisible, boolean flag) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.view.View inflate(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup $this$inflate, int layout) {
        return null;
    }
    
    public static final boolean isValidEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$isValidEmail) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String toPlainString(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> $this$toPlainString) {
        return null;
    }
    
    /**
     * Manage location permission by using this extension function.
     *
     * @param onGranted, callback to continue
     * @param onDeniedOne, callback to show that location permission message
     * @param onPermanentlyDeniedAnyOne, callback to navigate to app settings to manually provide permission
     */
    public static final void manageLocationPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$manageLocationPermission, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onGranted, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDeniedOne, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onPermanentlyDeniedAnyOne) {
    }
    
    /**
     * Open respective app settings
     */
    public static final void openAppSettings(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$openAppSettings) {
    }
    
    public static final boolean checkLocationPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$checkLocationPermission) {
        return false;
    }
    
    public static final void debugToast(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$debugToast, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    public static final void debugToast(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$debugToast, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
}