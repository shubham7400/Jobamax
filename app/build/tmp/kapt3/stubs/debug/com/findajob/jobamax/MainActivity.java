package com.findajob.jobamax;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\n0\rH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0019H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006!"}, d2 = {"Lcom/findajob/jobamax/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/findajob/jobamax/databinding/ActivityMainBinding;", "getBinding", "()Lcom/findajob/jobamax/databinding/ActivityMainBinding;", "setBinding", "(Lcom/findajob/jobamax/databinding/ActivityMainBinding;)V", "configureNavigation", "", "getCurrentJobSeeker", "call", "Lkotlin/Function1;", "Lcom/parse/ParseObject;", "handleDeepLink", "it", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "setLocale", "languageCode", "", "updateAppUsage", "callback", "Lkotlin/Function0;", "updateIsEmailVerifiedInJobSeeker", "jobSeekerId", "updateIsEmailVerifiedInRecruiter", "recruiterId", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.findajob.jobamax.databinding.ActivityMainBinding binding;
    private java.util.HashMap _$_findViewCache;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.databinding.ActivityMainBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.databinding.ActivityMainBinding p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setLocale(java.lang.String languageCode) {
    }
    
    @java.lang.Override()
    protected void onNewIntent(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    private final void handleDeepLink(android.content.Intent it) {
    }
    
    private final void updateIsEmailVerifiedInRecruiter(java.lang.String recruiterId) {
    }
    
    private final void updateIsEmailVerifiedInJobSeeker(java.lang.String jobSeekerId) {
    }
    
    private final void configureNavigation() {
    }
    
    private final void updateAppUsage(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    private final void getCurrentJobSeeker(kotlin.jvm.functions.Function1<? super com.parse.ParseObject, kotlin.Unit> call) {
    }
}