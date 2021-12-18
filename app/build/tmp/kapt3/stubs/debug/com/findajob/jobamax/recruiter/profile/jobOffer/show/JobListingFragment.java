package com.findajob.jobamax.recruiter.profile.jobOffer.show;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0011\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006$"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/jobOffer/show/JobListingFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentJobListingBinding;", "Lcom/findajob/jobamax/recruiter/profile/jobOffer/show/ShowAllJobOfferController;", "()V", "jobOfferAdapter", "Lcom/findajob/jobamax/recruiter/profile/jobOffer/show/JobOfferAdapter;", "layoutRes", "", "getLayoutRes", "()I", "navController", "Landroidx/navigation/NavController;", "showArchivedJobs", "", "viewModel", "Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureViewModel", "", "Landroidx/lifecycle/ViewModel;", "initView", "loadJobOffers", "onArchivedToggleClicked", "onBackButtonClicked", "onCreateButtonClicked", "onCreated", "savedInstance", "Landroid/os/Bundle;", "prepareForAndNavigateToCreateJobOffer", "showContactDialog", "showContactMeDialog", "subscribeObserver", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class JobListingFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentJobListingBinding> implements com.findajob.jobamax.recruiter.profile.jobOffer.show.ShowAllJobOfferController {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private androidx.navigation.NavController navController;
    private boolean showArchivedJobs = false;
    private com.findajob.jobamax.recruiter.profile.jobOffer.show.JobOfferAdapter jobOfferAdapter;
    private java.util.HashMap _$_findViewCache;
    
    public JobListingFragment() {
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
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    private final void configureViewModel() {
    }
    
    private final void initView() {
    }
    
    private final void showContactDialog() {
    }
    
    private final void showContactMeDialog() {
    }
    
    private final void subscribeObserver() {
    }
    
    @java.lang.Override()
    public void onCreateButtonClicked() {
    }
    
    private final void prepareForAndNavigateToCreateJobOffer() {
    }
    
    @java.lang.Override()
    public void onBackButtonClicked() {
    }
    
    @java.lang.Override()
    public void onArchivedToggleClicked() {
    }
    
    private final void loadJobOffers() {
    }
}