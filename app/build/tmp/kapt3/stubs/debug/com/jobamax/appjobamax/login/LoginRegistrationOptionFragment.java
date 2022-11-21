package com.jobamax.appjobamax.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.*;
import androidx.activity.result.contract.ActivityResultContracts;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentLoginRegistrationOptionBinding;
import com.jobamax.appjobamax.dialog.BasicDialog;
import com.jobamax.appjobamax.enums.LoginType;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.enums.ParseTableName;
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity;
import com.jobamax.appjobamax.jobseeker.build_profile.BuildProfileActivity;
import com.jobamax.appjobamax.model.JobSeeker;
import com.jobamax.appjobamax.model.UserTempInfo;
import com.jobamax.appjobamax.preference.*;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.pushwoosh.Pushwoosh;
import com.realtimecoding.linkedinmanager.events.LinkedInManagerResponse;
import com.realtimecoding.linkedinmanager.helper.LinkedInRequestManager;
import com.realtimecoding.linkedinmanager.models.LinkedInAccessToken;
import com.realtimecoding.linkedinmanager.models.LinkedInEmailAddress;
import com.realtimecoding.linkedinmanager.models.LinkedInUserProfile;
import java.util.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0016\u0010 \u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\u001c\u0010$\u001a\u00020\u001d2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020\u001d0&H\u0002J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u001dH\u0016J\u0012\u00101\u001a\u00020\u001d2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020\u001dH\u0016J\u0012\u00105\u001a\u00020\u001d2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020\u001dH\u0016J\u0012\u00109\u001a\u00020\u001d2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020\u001dH\u0016J\u0012\u0010=\u001a\u00020\u001d2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u00020\u001dH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006A"}, d2 = {"Lcom/jobamax/appjobamax/login/LoginRegistrationOptionFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "Lcom/realtimecoding/linkedinmanager/events/LinkedInManagerResponse;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentLoginRegistrationOptionBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentLoginRegistrationOptionBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentLoginRegistrationOptionBinding;)V", "googleLoginActivityResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "linkedInRequestManager", "Lcom/realtimecoding/linkedinmanager/helper/LinkedInRequestManager;", "getLinkedInRequestManager", "()Lcom/realtimecoding/linkedinmanager/helper/LinkedInRequestManager;", "setLinkedInRequestManager", "(Lcom/realtimecoding/linkedinmanager/helper/LinkedInRequestManager;)V", "mGoogleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "user", "Lcom/jobamax/appjobamax/model/UserTempInfo;", "getUser", "()Lcom/jobamax/appjobamax/model/UserTempInfo;", "setUser", "(Lcom/jobamax/appjobamax/model/UserTempInfo;)V", "checkAccountWithEmail", "", "configureUi", "getUserLogin", "handleSignInResult", "completedTask", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "isEmailAlreadyRegistered", "callback", "Lkotlin/Function1;", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onGetAccessTokenFailed", "onGetAccessTokenSuccess", "linkedInAccessToken", "Lcom/realtimecoding/linkedinmanager/models/LinkedInAccessToken;", "onGetCodeFailed", "onGetCodeSuccess", "code", "", "onGetEmailAddressFailed", "onGetEmailAddressSuccess", "linkedInEmailAddress", "Lcom/realtimecoding/linkedinmanager/models/LinkedInEmailAddress;", "onGetProfileDataFailed", "onGetProfileDataSuccess", "linkedInUserProfile", "Lcom/realtimecoding/linkedinmanager/models/LinkedInUserProfile;", "setClickListeners", "app_debug"})
public final class LoginRegistrationOptionFragment extends com.jobamax.appjobamax.base.BaseFragment implements com.realtimecoding.linkedinmanager.events.LinkedInManagerResponse {
    public com.jobamax.appjobamax.databinding.FragmentLoginRegistrationOptionBinding binding;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.UserTempInfo user;
    private com.google.android.gms.auth.api.signin.GoogleSignInClient mGoogleSignInClient;
    public com.realtimecoding.linkedinmanager.helper.LinkedInRequestManager linkedInRequestManager;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> googleLoginActivityResult = null;
    private java.util.HashMap _$_findViewCache;
    
    public LoginRegistrationOptionFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentLoginRegistrationOptionBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentLoginRegistrationOptionBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.UserTempInfo getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.UserTempInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.realtimecoding.linkedinmanager.helper.LinkedInRequestManager getLinkedInRequestManager() {
        return null;
    }
    
    public final void setLinkedInRequestManager(@org.jetbrains.annotations.NotNull()
    com.realtimecoding.linkedinmanager.helper.LinkedInRequestManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void configureUi() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void handleSignInResult(com.google.android.gms.tasks.Task<com.google.android.gms.auth.api.signin.GoogleSignInAccount> completedTask) {
    }
    
    private final void checkAccountWithEmail() {
    }
    
    private final void getUserLogin() {
    }
    
    private final void isEmailAlreadyRegistered(kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> callback) {
    }
    
    @java.lang.Override()
    public void onGetAccessTokenFailed() {
    }
    
    @java.lang.Override()
    public void onGetAccessTokenSuccess(@org.jetbrains.annotations.Nullable()
    com.realtimecoding.linkedinmanager.models.LinkedInAccessToken linkedInAccessToken) {
    }
    
    @java.lang.Override()
    public void onGetCodeFailed() {
    }
    
    @java.lang.Override()
    public void onGetCodeSuccess(@org.jetbrains.annotations.Nullable()
    java.lang.String code) {
    }
    
    @java.lang.Override()
    public void onGetEmailAddressFailed() {
    }
    
    @java.lang.Override()
    public void onGetEmailAddressSuccess(@org.jetbrains.annotations.Nullable()
    com.realtimecoding.linkedinmanager.models.LinkedInEmailAddress linkedInEmailAddress) {
    }
    
    @java.lang.Override()
    public void onGetProfileDataFailed() {
    }
    
    @java.lang.Override()
    public void onGetProfileDataSuccess(@org.jetbrains.annotations.Nullable()
    com.realtimecoding.linkedinmanager.models.LinkedInUserProfile linkedInUserProfile) {
    }
}