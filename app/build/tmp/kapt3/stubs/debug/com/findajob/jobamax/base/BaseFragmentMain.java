package com.findajob.jobamax.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\n\u0010#\u001a\u0004\u0018\u00010$H$J$\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010+H$J\b\u0010/\u001a\u00020-H\u0016J\u001a\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u00102\u001a\u00020-H\u0002J\u000e\u00103\u001a\u00020-2\u0006\u00104\u001a\u000205J\"\u00106\u001a\u00020-2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002052\b\b\u0002\u0010:\u001a\u000205H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u0012X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8eX\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006;"}, d2 = {"Lcom/findajob/jobamax/base/BaseFragmentMain;", "V", "Landroidx/databinding/ViewDataBinding;", "Landroidx/fragment/app/Fragment;", "()V", "baseView", "Landroid/view/View;", "getBaseView", "()Landroid/view/View;", "setBaseView", "(Landroid/view/View;)V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "disposeBag", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposeBag", "()Lio/reactivex/disposables/CompositeDisposable;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "layoutRes", "", "getLayoutRes", "()I", "progressHud", "Lcom/kaopiz/kprogresshud/KProgressHUD;", "getProgressHud", "()Lcom/kaopiz/kprogresshud/KProgressHUD;", "setProgressHud", "(Lcom/kaopiz/kprogresshud/KProgressHUD;)V", "getViewModel", "Landroidx/lifecycle/ViewModel;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreated", "", "savedInstance", "onDestroyView", "onViewCreated", "view", "setupUxCam", "showLoading", "loading", "", "showMessage", "message", "", "positive", "neutral", "app_debug"})
public abstract class BaseFragmentMain<V extends androidx.databinding.ViewDataBinding> extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.disposables.CompositeDisposable disposeBag = null;
    protected android.view.View baseView;
    protected V binding;
    public com.kaopiz.kprogresshud.KProgressHUD progressHud;
    private java.util.HashMap _$_findViewCache;
    
    public BaseFragmentMain() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.google.gson.Gson getGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final io.reactivex.disposables.CompositeDisposable getDisposeBag() {
        return null;
    }
    
    @androidx.annotation.LayoutRes()
    protected abstract int getLayoutRes();
    
    @org.jetbrains.annotations.NotNull()
    protected final android.view.View getBaseView() {
        return null;
    }
    
    protected final void setBaseView(@org.jetbrains.annotations.NotNull()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final V getBinding() {
        return null;
    }
    
    protected final void setBinding(@org.jetbrains.annotations.NotNull()
    V p0) {
    }
    
    protected abstract void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance);
    
    @org.jetbrains.annotations.Nullable()
    protected abstract androidx.lifecycle.ViewModel getViewModel();
    
    @org.jetbrains.annotations.NotNull()
    public final com.kaopiz.kprogresshud.KProgressHUD getProgressHud() {
        return null;
    }
    
    public final void setProgressHud(@org.jetbrains.annotations.NotNull()
    com.kaopiz.kprogresshud.KProgressHUD p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupUxCam() {
    }
    
    private final void showMessage(java.lang.String message, boolean positive, boolean neutral) {
    }
    
    public final void showLoading(boolean loading) {
    }
}