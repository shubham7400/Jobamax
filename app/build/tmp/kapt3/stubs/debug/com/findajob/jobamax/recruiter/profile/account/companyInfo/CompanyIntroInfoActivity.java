package com.findajob.jobamax.recruiter.profile.account.companyInfo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0013\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u0018H\u0016J\b\u0010!\u001a\u00020\u0018H\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\u0018H\u0002J\b\u0010\'\u001a\u00020(H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006)"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/account/companyInfo/CompanyIntroInfoActivity;", "Lcom/findajob/jobamax/base/BaseActivityMain;", "Lcom/findajob/jobamax/databinding/ActivityCompanyIntroInfoBinding;", "Lcom/findajob/jobamax/recruiter/profile/account/companyInfo/CompanyIntroInfoHandler;", "()V", "company", "Lcom/findajob/jobamax/model/Company;", "getCompany", "()Lcom/findajob/jobamax/model/Company;", "setCompany", "(Lcom/findajob/jobamax/model/Company;)V", "layoutRes", "", "getLayoutRes", "()I", "personalInfoModel", "Lcom/findajob/jobamax/recruiter/profile/account/personalInfo/RecruiterPersonalInformationModel;", "viewModel", "Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureViewModel", "", "Landroidx/lifecycle/ViewModel;", "initFields", "initViews", "onBackClicked", "onCreated", "instance", "Landroid/os/Bundle;", "onSubmitClicked", "saveCompanyData", "sendEmailVerificationLink", "recruiter", "Lcom/findajob/jobamax/model/Recruiter;", "showSuccessDialog", "subscribe", "validateFields", "", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class CompanyIntroInfoActivity extends com.findajob.jobamax.base.BaseActivityMain<com.findajob.jobamax.databinding.ActivityCompanyIntroInfoBinding> implements com.findajob.jobamax.recruiter.profile.account.companyInfo.CompanyIntroInfoHandler {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.findajob.jobamax.model.Company company;
    private com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationModel personalInfoModel;
    private java.util.HashMap _$_findViewCache;
    
    public CompanyIntroInfoActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.Company getCompany() {
        return null;
    }
    
    public final void setCompany(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.Company p0) {
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
    
    private final void subscribe() {
    }
    
    private final void initFields() {
    }
    
    private final void initViews() {
    }
    
    private final void configureViewModel() {
    }
    
    private final boolean validateFields() {
        return false;
    }
    
    private final void saveCompanyData() {
    }
    
    @java.lang.Override()
    public void onBackClicked() {
    }
    
    @java.lang.Override()
    public void onSubmitClicked() {
    }
    
    private final void sendEmailVerificationLink(com.findajob.jobamax.model.Recruiter recruiter) {
    }
    
    private final void showSuccessDialog() {
    }
}