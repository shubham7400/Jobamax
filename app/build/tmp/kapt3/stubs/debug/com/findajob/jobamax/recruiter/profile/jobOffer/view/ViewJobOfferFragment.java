package com.findajob.jobamax.recruiter.profile.jobOffer.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\fH\u0014J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u0018H\u0016J\u0012\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u0018H\u0016J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\'\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0014\u0010\u0005\u001a\u00020\u00068TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006*"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/jobOffer/view/ViewJobOfferFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentViewJobOfferBinding;", "Lcom/findajob/jobamax/recruiter/profile/jobOffer/view/ViewJobOfferInterface;", "()V", "layoutRes", "", "getLayoutRes", "()I", "navController", "Landroidx/navigation/NavController;", "recruiterHomeViewModel", "Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;", "getRecruiterHomeViewModel", "()Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;", "setRecruiterHomeViewModel", "(Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;)V", "state", "Lcom/findajob/jobamax/recruiter/profile/jobOffer/view/ViewJobOfferState;", "getState", "()Lcom/findajob/jobamax/recruiter/profile/jobOffer/view/ViewJobOfferState;", "setState", "(Lcom/findajob/jobamax/recruiter/profile/jobOffer/view/ViewJobOfferState;)V", "archiveJobOffer", "", "job", "Lcom/findajob/jobamax/model/JobOffer;", "configureViewModel", "getViewModel", "initViews", "loadUi", "jobOffer", "onBackButtonClicked", "onCreated", "savedInstance", "Landroid/os/Bundle;", "onDeleteClicked", "onSaveClicked", "showArchiveDialog", "showUnArchiveDialog", "subscribeObservers", "unarchiveJobOffer", "app_debug"})
public final class ViewJobOfferFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentViewJobOfferBinding> implements com.findajob.jobamax.recruiter.profile.jobOffer.view.ViewJobOfferInterface {
    public com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel recruiterHomeViewModel;
    private androidx.navigation.NavController navController;
    public com.findajob.jobamax.recruiter.profile.jobOffer.view.ViewJobOfferState state;
    private java.util.HashMap _$_findViewCache;
    
    public ViewJobOfferFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel getRecruiterHomeViewModel() {
        return null;
    }
    
    public final void setRecruiterHomeViewModel(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.recruiter.profile.jobOffer.view.ViewJobOfferState getState() {
        return null;
    }
    
    public final void setState(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.recruiter.profile.jobOffer.view.ViewJobOfferState p0) {
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    private final void configureViewModel() {
    }
    
    private final void initViews() {
    }
    
    private final void subscribeObservers() {
    }
    
    private final void loadUi(com.findajob.jobamax.model.JobOffer jobOffer) {
    }
    
    @java.lang.Override()
    public void onBackButtonClicked() {
    }
    
    @java.lang.Override()
    public void onDeleteClicked() {
    }
    
    private final void showArchiveDialog(com.findajob.jobamax.model.JobOffer job) {
    }
    
    private final void showUnArchiveDialog(com.findajob.jobamax.model.JobOffer job) {
    }
    
    private final void archiveJobOffer(com.findajob.jobamax.model.JobOffer job) {
    }
    
    private final void unarchiveJobOffer(com.findajob.jobamax.model.JobOffer job) {
    }
    
    @java.lang.Override()
    public void onSaveClicked() {
    }
}