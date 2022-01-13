package com.findajob.jobamax.recruiter.profile.account.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\b\u0010$\u001a\u00020\u0017H\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016J\b\u0010\'\u001a\u00020\u0017H\u0016J\b\u0010(\u001a\u00020\u0017H\u0016J\b\u0010)\u001a\u00020\u0017H\u0016J\b\u0010*\u001a\u00020\u0017H\u0016J\b\u0010+\u001a\u00020\u0017H\u0016J\b\u0010,\u001a\u00020\u0017H\u0016J\b\u0010-\u001a\u00020\u0017H\u0016J\b\u0010.\u001a\u00020\u0017H\u0016J\b\u0010/\u001a\u00020\u0017H\u0016J\b\u00100\u001a\u00020\u0017H\u0016J\b\u00101\u001a\u00020\u0017H\u0016J\b\u00102\u001a\u00020\u0017H\u0016J\u0010\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u000205H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u00066"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/account/home/RecruiterAccountFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentRecruiterAccountBinding;", "Lcom/findajob/jobamax/recruiter/profile/account/home/RecruiterAccountInterface;", "()V", "layoutRes", "", "getLayoutRes", "()I", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "setNavController", "(Landroidx/navigation/NavController;)V", "viewModel", "Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "Landroidx/lifecycle/ViewModel;", "initFields", "", "initView", "onBackButtonClicked", "onCommunityGuidelinesClicked", "onCompanyInformationClicked", "onCreated", "savedInstance", "Landroid/os/Bundle;", "onDeleteAccountClicked", "onEmailUsClicked", "onHelpAndSupportClicked", "onInvoicesClicked", "onLicensesClicked", "onLogoutClicked", "onManageReadReceiptsClicked", "onNewsletterClicked", "onPasswordClicked", "onPaymentMethodsClicked", "onPersonalInformationClicked", "onPrivacyPolicyClicked", "onPrivacyPreferencesClicked", "onPushNotificationsClicked", "onRestorePurchaseClicked", "onSafetyTipsClicked", "onShareJobamaxClicked", "onSocialLayoutClicked", "onTemporaryDisableAccountClicked", "onTermsOfServiceClicked", "toggleHideMe", "flag", "", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class RecruiterAccountFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentRecruiterAccountBinding> implements com.findajob.jobamax.recruiter.profile.account.home.RecruiterAccountInterface {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public androidx.navigation.NavController navController;
    private java.util.HashMap _$_findViewCache;
    
    public RecruiterAccountFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel getViewModel() {
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
    
    private final void initView() {
    }
    
    private final void initFields() {
    }
    
    @java.lang.Override()
    public void toggleHideMe(boolean flag) {
    }
    
    @java.lang.Override()
    public void onPasswordClicked() {
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
    public void onCompanyInformationClicked() {
    }
    
    @java.lang.Override()
    public void onInvoicesClicked() {
    }
    
    @java.lang.Override()
    public void onPaymentMethodsClicked() {
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
    public void onSocialLayoutClicked() {
    }
    
    @java.lang.Override()
    public void onDeleteAccountClicked() {
    }
}