package com.findajob.jobamax.jobseeker.profile.account.personalInfo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0012\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010\"\u001a\u00020\u0016H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0016H\u0016J\b\u0010\'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/account/personalInfo/JobSeekerPersonalIntroInfoActivity;", "Lcom/findajob/jobamax/base/BaseActivityMain;", "Lcom/findajob/jobamax/databinding/ActivityJobSeekerPersonalIntroInfoBinding;", "Lcom/findajob/jobamax/jobseeker/profile/account/personalInfo/JobSeekerPersonalIntroInfoInterface;", "()V", "datePickerListener", "Landroid/app/DatePickerDialog$OnDateSetListener;", "layoutRes", "", "getLayoutRes", "()I", "personalInfoModel", "Lcom/findajob/jobamax/jobseeker/profile/account/personalInfo/JobSeekerPersonalInformationModel;", "user", "Lcom/findajob/jobamax/model/UserTempInfo;", "getUser", "()Lcom/findajob/jobamax/model/UserTempInfo;", "setUser", "(Lcom/findajob/jobamax/model/UserTempInfo;)V", "viewModel", "Lcom/findajob/jobamax/jobseeker/profile/account/personalInfo/JobSeekerPersonalIntroInfoViewModel;", "addPhoneNumber", "", "configureViewModel", "getUserLogin", "getViewModel", "Landroidx/lifecycle/ViewModel;", "initViews", "onBackClicked", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreated", "instance", "onDobClicked", "onGenderClicked", "view", "Landroid/view/View;", "onSkipped", "onSubmitClicked", "storeUserInParse", "validateFields", "", "validatePromoCode", "app_debug"})
public final class JobSeekerPersonalIntroInfoActivity extends com.findajob.jobamax.base.BaseActivityMain<com.findajob.jobamax.databinding.ActivityJobSeekerPersonalIntroInfoBinding> implements com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoInterface {
    private com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoViewModel viewModel;
    private com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel personalInfoModel;
    @org.jetbrains.annotations.Nullable()
    private com.findajob.jobamax.model.UserTempInfo user;
    private final android.app.DatePickerDialog.OnDateSetListener datePickerListener = null;
    private java.util.HashMap _$_findViewCache;
    
    public JobSeekerPersonalIntroInfoActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.findajob.jobamax.model.UserTempInfo getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.Nullable()
    com.findajob.jobamax.model.UserTempInfo p0) {
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
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void configureViewModel() {
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
    public void onDobClicked() {
    }
    
    private final boolean validateFields() {
        return false;
    }
    
    private final void validatePromoCode() {
    }
    
    private final void storeUserInParse() {
    }
    
    private final void getUserLogin(com.findajob.jobamax.model.UserTempInfo user) {
    }
    
    @java.lang.Override()
    public void onSkipped() {
    }
    
    @java.lang.Override()
    public void onBackClicked() {
    }
}