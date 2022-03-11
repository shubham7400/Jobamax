package com.findajob.jobamax.recruiter.profile.jobOffer.create;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u0017\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\"\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010\'\u001a\u00020\u001cH\u0016J\b\u0010(\u001a\u00020\u001cH\u0016J\u0012\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\b\u0010,\u001a\u00020\u001cH\u0016J\b\u0010-\u001a\u00020\u001cH\u0016J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u001cH\u0016J\b\u00102\u001a\u00020\u001cH\u0016J\b\u00103\u001a\u00020\u001cH\u0002J\u0010\u00104\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u00105\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0010\u00106\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\b\u00107\u001a\u000208H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u00a8\u00069"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/jobOffer/create/JobOfferDetailsFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentJobOfferDetailsBinding;", "Lcom/findajob/jobamax/recruiter/profile/jobOffer/create/JobOfferDetailsHandler;", "()V", "benefitsAdapter", "Lcom/findajob/jobamax/recruiter/profile/jobOffer/create/SelectBenefitsAdapter;", "fileUri", "Landroid/net/Uri;", "jobOffer", "Lcom/findajob/jobamax/model/JobOffer;", "getJobOffer", "()Lcom/findajob/jobamax/model/JobOffer;", "setJobOffer", "(Lcom/findajob/jobamax/model/JobOffer;)V", "layoutRes", "", "getLayoutRes", "()I", "navController", "Landroidx/navigation/NavController;", "viewModel", "Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/recruiter/home/RecruiterHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "archiveJobOffer", "", "job", "configureViewModel", "Landroidx/lifecycle/ViewModel;", "initField", "initViews", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAddKeySkillsClicked", "onBackButtonClicked", "onCreated", "savedInstance", "Landroid/os/Bundle;", "onHideJobClicked", "onKeySkillsClicked", "onLevelOfHierarchyClicked", "view", "Landroid/view/View;", "onLocationClicked", "onSubmitButtonClicked", "refreshKeySkillChips", "showArchiveDialog", "showUnArchiveDialog", "unarchiveJobOffer", "validateFields", "", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class JobOfferDetailsFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentJobOfferDetailsBinding> implements com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsHandler {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.findajob.jobamax.recruiter.profile.jobOffer.create.SelectBenefitsAdapter benefitsAdapter;
    private androidx.navigation.NavController navController;
    private android.net.Uri fileUri;
    @org.jetbrains.annotations.NotNull()
    private com.findajob.jobamax.model.JobOffer jobOffer;
    private java.util.HashMap _$_findViewCache;
    
    public JobOfferDetailsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.JobOffer getJobOffer() {
        return null;
    }
    
    public final void setJobOffer(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobOffer p0) {
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    @java.lang.Override()
    public void onHideJobClicked() {
    }
    
    private final void showArchiveDialog(com.findajob.jobamax.model.JobOffer job) {
    }
    
    private final void showUnArchiveDialog(com.findajob.jobamax.model.JobOffer job) {
    }
    
    private final void archiveJobOffer(com.findajob.jobamax.model.JobOffer job) {
    }
    
    private final void unarchiveJobOffer(com.findajob.jobamax.model.JobOffer job) {
    }
    
    private final void initField() {
    }
    
    private final void initViews() {
    }
    
    private final void configureViewModel() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onBackButtonClicked() {
    }
    
    @java.lang.Override()
    public void onLocationClicked() {
    }
    
    @java.lang.Override()
    public void onLevelOfHierarchyClicked(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onSubmitButtonClicked() {
    }
    
    @java.lang.Override()
    public void onAddKeySkillsClicked() {
    }
    
    @java.lang.Override()
    public void onKeySkillsClicked() {
    }
    
    private final void refreshKeySkillChips() {
    }
    
    private final boolean validateFields() {
        return false;
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
}