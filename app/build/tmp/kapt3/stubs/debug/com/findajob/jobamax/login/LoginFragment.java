package com.findajob.jobamax.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002JT\u0010\u0017\u001a\u00020\u001626\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00160\u00192\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00160!H\u0002J\b\u0010#\u001a\u00020$H\u0014J\u0016\u0010%\u001a\u00020\u00162\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0\'H\u0002J\b\u0010)\u001a\u00020\u0016H\u0002J\"\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010.\u001a\u00020\u00162\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00101\u001a\u00020\u0016H\u0016J\b\u00102\u001a\u00020\u0016H\u0016J\b\u00103\u001a\u00020\u0016H\u0016J\b\u00104\u001a\u00020\u0016H\u0016J\b\u00105\u001a\u00020\u0016H\u0016J\b\u00106\u001a\u00020\u0016H\u0016J\b\u00107\u001a\u00020\u0016H\u0016J\b\u00108\u001a\u00020\u0016H\u0016J\u001a\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u000100H\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lcom/findajob/jobamax/login/LoginFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentLoginBinding;", "Lcom/findajob/jobamax/login/LoginInterface;", "()V", "googleLoginActivityResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "layoutRes", "", "getLayoutRes", "()I", "linkedInFlag", "", "mGoogleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "navController", "Landroidx/navigation/NavController;", "viewModel", "Lcom/findajob/jobamax/login/LoginViewModel;", "configureViewModel", "", "getUserDetailFromFB", "onSuccess", "Lkotlin/Function2;", "Lcom/findajob/jobamax/model/User;", "Lkotlin/ParameterName;", "name", "user", "Lcom/parse/ParseObject;", "parseObject", "onError", "Lkotlin/Function1;", "", "getViewModel", "Landroidx/lifecycle/ViewModel;", "handleSignInResult", "completedTask", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "initViews", "onActivityResult", "requestCode", "resultCode", "data", "onCreated", "savedInstance", "Landroid/os/Bundle;", "onEmailLoginClicked", "onEyeClicked", "onFacebookLoginClicked", "onForgotPasswordClicked", "onGoogleLoginClicked", "onLinkedInLoginClicked", "onRegisterClicked", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "app_debug"})
public final class LoginFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentLoginBinding> implements com.findajob.jobamax.login.LoginInterface {
    private com.findajob.jobamax.login.LoginViewModel viewModel;
    private com.google.android.gms.auth.api.signin.GoogleSignInClient mGoogleSignInClient;
    private androidx.navigation.NavController navController;
    private boolean linkedInFlag = false;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> googleLoginActivityResult = null;
    private java.util.HashMap _$_findViewCache;
    
    public LoginFragment() {
        super();
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModel getViewModel() {
        return null;
    }
    
    private final void configureViewModel() {
    }
    
    private final void initViews() {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onForgotPasswordClicked() {
    }
    
    @java.lang.Override()
    public void onEyeClicked() {
    }
    
    private final void handleSignInResult(com.google.android.gms.tasks.Task<com.google.android.gms.auth.api.signin.GoogleSignInAccount> completedTask) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    public void onFacebookLoginClicked() {
    }
    
    @java.lang.Override()
    public void onGoogleLoginClicked() {
    }
    
    @java.lang.Override()
    public void onLinkedInLoginClicked() {
    }
    
    @java.lang.Override()
    public void onEmailLoginClicked() {
    }
    
    @java.lang.Override()
    public void onRegisterClicked() {
    }
    
    /**
     * Extract facebook user information
     *
     * @param onSuccess, success callback return [User] and [ParseObject]
     * @param onError, error callback return [Throwable]
     */
    private final void getUserDetailFromFB(kotlin.jvm.functions.Function2<? super com.findajob.jobamax.model.User, ? super com.parse.ParseObject, kotlin.Unit> onSuccess, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onError) {
    }
}