package com.jobamax.appjobamax.extensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a>\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a9\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\r0\u00042\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0010\u00a2\u0006\u0002\b\u0011\u001a\u0012\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u0012\u0010\u0012\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0014\u00a8\u0006\u0016"}, d2 = {"goToActivity", "", "Landroid/app/Activity;", "mClass", "Ljava/lang/Class;", "finishCurrentActivity", "", "extras", "Landroid/os/Bundle;", "withResult", "requestCode", "", "gotoActivity", "T", "Landroid/content/Context;", "it", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "setLocale", "languageCode", "", "Landroidx/fragment/app/Fragment;", "app_release"})
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
    
    public static final void setLocale(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$setLocale, @org.jetbrains.annotations.NotNull()
    java.lang.String languageCode) {
    }
    
    public static final void setLocale(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$setLocale, @org.jetbrains.annotations.NotNull()
    java.lang.String languageCode) {
    }
}