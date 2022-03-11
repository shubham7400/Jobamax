package com.findajob.jobamax.recruiter.profile.account.company;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u0017\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001cH\u0016J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020%H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00128TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006&"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/account/company/CompanyInformationFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentCompanyInformationBinding;", "Lcom/findajob/jobamax/recruiter/profile/account/company/CompanyInformationInterface;", "()V", "company", "Lcom/findajob/jobamax/model/Company;", "getCompany", "()Lcom/findajob/jobamax/model/Company;", "setCompany", "(Lcom/findajob/jobamax/model/Company;)V", "companySizeAdapter", "Lcom/findajob/jobamax/recruiter/profile/account/company/adapter/CompanySizeAdapter;", "getCompanySizeAdapter", "()Lcom/findajob/jobamax/recruiter/profile/account/company/adapter/CompanySizeAdapter;", "companySizeAdapter$delegate", "Lkotlin/Lazy;", "layoutRes", "", "getLayoutRes", "()I", "viewModel", "Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;", "viewModel$delegate", "Landroidx/lifecycle/ViewModel;", "initCompanySize", "", "initFields", "onBackButtonClicked", "onCreated", "savedInstance", "Landroid/os/Bundle;", "onSubmitButtonClicked", "updateCompanyPayload", "validateFields", "", "app_debug"})
public final class CompanyInformationFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentCompanyInformationBinding> implements com.findajob.jobamax.recruiter.profile.account.company.CompanyInformationInterface {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.findajob.jobamax.model.Company company;
    private final kotlin.Lazy companySizeAdapter$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public CompanyInformationFragment() {
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
    
    private final com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySizeAdapter getCompanySizeAdapter() {
        return null;
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModel getViewModel() {
        return null;
    }
    
    private final void initFields() {
    }
    
    private final void initCompanySize() {
    }
    
    @java.lang.Override()
    public void onSubmitButtonClicked() {
    }
    
    @java.lang.Override()
    public void onBackButtonClicked() {
    }
    
    private final boolean validateFields() {
        return false;
    }
    
    private final void updateCompanyPayload() {
    }
}