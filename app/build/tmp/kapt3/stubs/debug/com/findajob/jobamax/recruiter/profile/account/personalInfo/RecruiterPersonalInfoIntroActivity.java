package com.findajob.jobamax.recruiter.profile.account.personalInfo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u000f\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006&"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/account/personalInfo/RecruiterPersonalInfoIntroActivity;", "Lcom/findajob/jobamax/base/BaseActivityMain;", "Lcom/findajob/jobamax/databinding/ActivityRecruiterPersonalInfoIntroBinding;", "Lcom/findajob/jobamax/recruiter/profile/account/personalInfo/RecruiterPersonalInfoIntroInterface;", "()V", "datePickerListener", "Landroid/app/DatePickerDialog$OnDateSetListener;", "layoutRes", "", "getLayoutRes", "()I", "personalInfoModel", "Lcom/findajob/jobamax/recruiter/profile/account/personalInfo/RecruiterPersonalInformationModel;", "viewModel", "Lcom/findajob/jobamax/recruiter/profile/account/personalInfo/RecruiterPersonalInfoIntroViewModel;", "getViewModel", "()Lcom/findajob/jobamax/recruiter/profile/account/personalInfo/RecruiterPersonalInfoIntroViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addPhoneNumber", "", "configureViewModel", "Landroidx/lifecycle/ViewModel;", "initViews", "onBackClicked", "onCreated", "instance", "Landroid/os/Bundle;", "onDobClicked", "onGenderClicked", "view", "Landroid/view/View;", "onSkipped", "onSubmitClicked", "subscribeObserver", "validateFields", "", "validatePromoCode", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class RecruiterPersonalInfoIntroActivity extends com.findajob.jobamax.base.BaseActivityMain<com.findajob.jobamax.databinding.ActivityRecruiterPersonalInfoIntroBinding> implements com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInfoIntroInterface {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationModel personalInfoModel;
    private final android.app.DatePickerDialog.OnDateSetListener datePickerListener = null;
    private java.util.HashMap _$_findViewCache;
    
    public RecruiterPersonalInfoIntroActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInfoIntroViewModel getViewModel() {
        return null;
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
    
    private final void configureViewModel() {
    }
    
    private final void initViews() {
    }
    
    private final void subscribeObserver() {
    }
    
    @java.lang.Override()
    public void onDobClicked() {
    }
    
    @java.lang.Override()
    public void onGenderClicked(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onSubmitClicked() {
    }
    
    private final void addPhoneNumber() {
    }
    
    @java.lang.Override()
    public void onSkipped() {
    }
    
    private final boolean validateFields() {
        return false;
    }
    
    private final void validatePromoCode() {
    }
    
    @java.lang.Override()
    public void onBackClicked() {
    }
}