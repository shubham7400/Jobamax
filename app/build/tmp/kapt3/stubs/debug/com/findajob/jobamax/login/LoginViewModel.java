package com.findajob.jobamax.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JR\u0010\u001e\u001a\u00020\u001f2\"\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\"0!j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\"`#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001f0%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020\u001f0%J\u000e\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0019\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006*"}, d2 = {"Lcom/findajob/jobamax/login/LoginViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "context", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_detailedUser", "Landroidx/lifecycle/MutableLiveData;", "Lcom/findajob/jobamax/model/User;", "_errorMessage", "", "_existingUser", "Lcom/parse/ParseObject;", "_existingUserError", "detailedUser", "Landroidx/lifecycle/LiveData;", "getDetailedUser", "()Landroidx/lifecycle/LiveData;", "disposeBag", "Lio/reactivex/disposables/CompositeDisposable;", "errorMessage", "getErrorMessage", "existingUser", "getExistingUser", "existingUserError", "getExistingUserError", "roleType", "getRoleType", "()Ljava/lang/String;", "setRoleType", "(Ljava/lang/String;)V", "changePassword", "", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onSuccess", "Lkotlin/Function1;", "onError", "", "saveUserDetails", "user", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.AndroidViewModel {
    private final android.app.Application context = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String roleType = "";
    private final io.reactivex.disposables.CompositeDisposable disposeBag = null;
    private final androidx.lifecycle.MutableLiveData<com.parse.ParseObject> _existingUser = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.parse.ParseObject> existingUser = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _existingUserError = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> existingUserError = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> errorMessage = null;
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.model.User> _detailedUser = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.findajob.jobamax.model.User> detailedUser = null;
    
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoleType() {
        return null;
    }
    
    public final void setRoleType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.parse.ParseObject> getExistingUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getExistingUserError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.findajob.jobamax.model.User> getDetailedUser() {
        return null;
    }
    
    public final void saveUserDetails(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.User user) {
    }
    
    public final void changePassword(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> params, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onError) {
    }
}