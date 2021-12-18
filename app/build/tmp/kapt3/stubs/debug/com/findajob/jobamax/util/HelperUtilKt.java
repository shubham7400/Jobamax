package com.findajob.jobamax.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0003\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a \u0010\u0010\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014\u001a\n\u0010\u0015\u001a\u00020\u0001*\u00020\u000b\u001a\u0012\u0010\u0015\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017\u001a\n\u0010\u0015\u001a\u00020\u0001*\u00020\u0018\u001aO\u0010\u0019\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052#\b\u0002\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001d\u00a8\u0006!"}, d2 = {"showBasicDialog", "", "context", "Landroid/content/Context;", "message", "", "buttonText", "buttonClick", "Landroid/content/DialogInterface$OnDismissListener;", "checkForPermissions", "", "Landroid/app/Activity;", "errorToast", "e", "", "Lcom/findajob/jobamax/BaseFragment;", "executeAfter", "millis", "", "f", "Lkotlin/Function0;", "hideKeyboard", "view", "Landroid/view/View;", "Landroidx/fragment/app/Fragment;", "showDialog", "okButton", "cancelButton", "onClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "status", "app_debug"})
public final class HelperUtilKt {
    
    public static final void errorToast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$errorToast) {
    }
    
    public static final void errorToast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$errorToast, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable e) {
    }
    
    public static final void errorToast(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.BaseFragment $this$errorToast, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable e) {
    }
    
    public static final void executeAfter(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$executeAfter, long millis, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> f) {
    }
    
    public static final boolean checkForPermissions(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$checkForPermissions) {
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
    
    public static final void showBasicDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.String buttonText, @org.jetbrains.annotations.Nullable()
    android.content.DialogInterface.OnDismissListener buttonClick) {
    }
    
    public static final void showDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$showDialog, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.String okButton, @org.jetbrains.annotations.Nullable()
    java.lang.String cancelButton, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onClick) {
    }
}