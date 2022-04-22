package com.findajob.jobamax.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0010\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\u001c\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001dJ\u0016\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\"\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014J\u0012\u0010(\u001a\u00020\u00152\b\u0010)\u001a\u0004\u0018\u00010*H\u0014R\u0014\u0010\u0004\u001a\u00020\u00058TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006+"}, d2 = {"Lcom/findajob/jobamax/login/LoginActivity;", "Lcom/findajob/jobamax/base/BaseActivityMain;", "Lcom/findajob/jobamax/databinding/ActivityLoginBinding;", "()V", "layoutRes", "", "getLayoutRes", "()I", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "setNavController", "(Landroidx/navigation/NavController;)V", "viewModel", "Lcom/findajob/jobamax/login/LoginViewModel;", "getViewModel", "()Lcom/findajob/jobamax/login/LoginViewModel;", "setViewModel", "(Lcom/findajob/jobamax/login/LoginViewModel;)V", "configureViewModel", "", "getUserLogin", "user", "Lcom/findajob/jobamax/model/UserTempInfo;", "Landroidx/lifecycle/ViewModel;", "initViews", "isEmailAlreadyRegistered", "callback", "Lkotlin/Function0;", "loginRecruiter", "email", "", "password", "loginSeeker", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreated", "instance", "Landroid/os/Bundle;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class LoginActivity extends com.findajob.jobamax.base.BaseActivityMain<com.findajob.jobamax.databinding.ActivityLoginBinding> {
    public com.findajob.jobamax.login.LoginViewModel viewModel;
    public androidx.navigation.NavController navController;
    private java.util.HashMap _$_findViewCache;
    
    public LoginActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.login.LoginViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.login.LoginViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.navigation.NavController getNavController() {
        return null;
    }
    
    public final void setNavController(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController p0) {
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle instance) {
    }
    
    private final void initViews() {
    }
    
    private final void configureViewModel() {
    }
    
    public final void isEmailAlreadyRegistered(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.UserTempInfo user, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    public final void loginSeeker(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.UserTempInfo user) {
    }
    
    public final void getUserLogin(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.UserTempInfo user) {
    }
    
    public final void loginRecruiter(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
}