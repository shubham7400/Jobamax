package com.findajob.jobamax.jobseeker.profile.account.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0011\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016J\b\u0010&\u001a\u00020\u0016H\u0016J\b\u0010\'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020\u0016H\u0016J\b\u0010)\u001a\u00020\u0016H\u0016J\b\u0010*\u001a\u00020\u0016H\u0016J\b\u0010+\u001a\u00020\u0016H\u0016J\b\u0010,\u001a\u00020\u0016H\u0016J\b\u0010-\u001a\u00020\u0016H\u0016J\b\u0010.\u001a\u00020\u0016H\u0016J\b\u0010/\u001a\u00020\u0016H\u0016J\b\u00100\u001a\u00020\u0016H\u0002J\u0010\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u000203H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u00064"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/account/home/JobSeekerAccountFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentJobSeekerAccountBinding;", "Lcom/findajob/jobamax/jobseeker/profile/account/home/JobSeekerAccountInterface;", "()V", "layoutRes", "", "getLayoutRes", "()I", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "setNavController", "(Landroidx/navigation/NavController;)V", "viewModel", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "getCurrent", "Landroidx/lifecycle/ViewModel;", "onBackButtonClicked", "onCommunityGuidelinesClicked", "onCreated", "savedInstance", "Landroid/os/Bundle;", "onDeleteAccountClicked", "onEmailUsClicked", "onHelpAndSupportClicked", "onLicensesClicked", "onLogoutClicked", "onManageReadReceiptsClicked", "onNewsletterClicked", "onPasswordClicked", "onPersonalInformationClicked", "onPrivacyPolicyClicked", "onPrivacyPreferencesClicked", "onPushNotificationsClicked", "onRestorePurchaseClicked", "onSafetyTipsClicked", "onShareJobamaxClicked", "onStart", "onTemporaryDisableAccountClicked", "onTermsOfServiceClicked", "setClickListeners", "toggleHideMe", "flag", "", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class JobSeekerAccountFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentJobSeekerAccountBinding> implements com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountInterface {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public androidx.navigation.NavController navController;
    private java.util.HashMap _$_findViewCache;
    
    public JobSeekerAccountFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModel getViewModel() {
        return null;
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
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    private final void configureUi() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void getCurrent() {
    }
    
    @java.lang.Override()
    public void onManageReadReceiptsClicked() {
    }
    
    @java.lang.Override()
    public void onPersonalInformationClicked() {
    }
    
    @java.lang.Override()
    public void onPushNotificationsClicked() {
    }
    
    @java.lang.Override()
    public void onNewsletterClicked() {
    }
    
    @java.lang.Override()
    public void onBackButtonClicked() {
    }
    
    @java.lang.Override()
    public void onRestorePurchaseClicked() {
    }
    
    @java.lang.Override()
    public void onShareJobamaxClicked() {
    }
    
    @java.lang.Override()
    public void onHelpAndSupportClicked() {
    }
    
    @java.lang.Override()
    public void onEmailUsClicked() {
    }
    
    @java.lang.Override()
    public void onCommunityGuidelinesClicked() {
    }
    
    @java.lang.Override()
    public void onSafetyTipsClicked() {
    }
    
    @java.lang.Override()
    public void onPrivacyPolicyClicked() {
    }
    
    @java.lang.Override()
    public void onTermsOfServiceClicked() {
    }
    
    @java.lang.Override()
    public void onLicensesClicked() {
    }
    
    @java.lang.Override()
    public void onPrivacyPreferencesClicked() {
    }
    
    @java.lang.Override()
    public void onLogoutClicked() {
    }
    
    @java.lang.Override()
    public void onTemporaryDisableAccountClicked() {
    }
    
    @java.lang.Override()
    public void onDeleteAccountClicked() {
    }
    
    @java.lang.Override()
    public void onPasswordClicked() {
    }
    
    @java.lang.Override()
    public void toggleHideMe(boolean flag) {
    }
}