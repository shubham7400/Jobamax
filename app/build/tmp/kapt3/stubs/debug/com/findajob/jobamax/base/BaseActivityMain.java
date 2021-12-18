package com.findajob.jobamax.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H$J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0012\u0010\'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010&H$J\b\u0010)\u001a\u00020$H\u0014J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001eH\u0004J$\u00101\u001a\u00020$2\b\b\u0002\u00102\u001a\u00020\u001e2\b\b\u0002\u00103\u001a\u00020\u001e2\b\b\u0002\u00104\u001a\u000205J\b\u00106\u001a\u00020$H\u0002J \u00107\u001a\u00020$2\u0006\u00108\u001a\u0002052\u0006\u00109\u001a\u00020\u001e2\b\b\u0002\u0010:\u001a\u00020\u001eR\u001c\u0010\u0005\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\fX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148eX\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006;"}, d2 = {"Lcom/findajob/jobamax/base/BaseActivityMain;", "V", "Landroidx/databinding/ViewDataBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "disposeBag", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposeBag", "()Lio/reactivex/disposables/CompositeDisposable;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "layoutRes", "", "getLayoutRes", "()I", "progressHud", "Lcom/kaopiz/kprogresshud/KProgressHUD;", "getProgressHud", "()Lcom/kaopiz/kprogresshud/KProgressHUD;", "setProgressHud", "(Lcom/kaopiz/kprogresshud/KProgressHUD;)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "getViewModel", "Landroidx/lifecycle/ViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreated", "instance", "onDestroy", "onOptionsItemSelected", "menuItem", "Landroid/view/MenuItem;", "openImagePicker", "activity", "Landroid/app/Activity;", "showCamera", "setToolbar", "show", "showBackButton", "title", "", "setupUxCam", "showMessage", "message", "positive", "neutral", "app_debug"})
public abstract class BaseActivityMain<V extends androidx.databinding.ViewDataBinding> extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.disposables.CompositeDisposable disposeBag = null;
    public com.kaopiz.kprogresshud.KProgressHUD progressHud;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    protected V binding;
    private java.util.HashMap _$_findViewCache;
    
    public BaseActivityMain() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final io.reactivex.disposables.CompositeDisposable getDisposeBag() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kaopiz.kprogresshud.KProgressHUD getProgressHud() {
        return null;
    }
    
    public final void setProgressHud(@org.jetbrains.annotations.NotNull()
    com.kaopiz.kprogresshud.KProgressHUD p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.google.gson.Gson getGson() {
        return null;
    }
    
    @androidx.annotation.LayoutRes()
    protected abstract int getLayoutRes();
    
    @org.jetbrains.annotations.NotNull()
    protected final V getBinding() {
        return null;
    }
    
    protected final void setBinding(@org.jetbrains.annotations.NotNull()
    V p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected abstract androidx.lifecycle.ViewModel getViewModel();
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupUxCam() {
    }
    
    protected abstract void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle instance);
    
    @java.lang.Override()
    public boolean dispatchTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent ev) {
        return false;
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem menuItem) {
        return false;
    }
    
    public final void setToolbar(boolean show, boolean showBackButton, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    protected final void openImagePicker(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, boolean showCamera) {
    }
    
    public final void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message, boolean positive, boolean neutral) {
    }
}