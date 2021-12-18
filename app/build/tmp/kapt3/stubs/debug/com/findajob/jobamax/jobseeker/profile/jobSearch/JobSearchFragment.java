package com.findajob.jobamax.jobseeker.profile.jobSearch;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u001eH\u0002J\"\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010\'\u001a\u00020\u001eH\u0016J\u0012\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020\u001eH\u0016J\b\u0010,\u001a\u00020\u001eH\u0016J\b\u0010-\u001a\u00020\u001eH\u0016J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0016J\u0006\u00101\u001a\u00020\u001eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a\u00a8\u00062"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/jobSearch/JobSearchFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentJobSearchBinding;", "Lcom/findajob/jobamax/jobseeker/profile/jobSearch/JobSearchInterface;", "()V", "jobSearchArg", "", "jobSearchState", "Lcom/findajob/jobamax/jobseeker/profile/jobSearch/JobSearchState;", "getJobSearchState", "()Lcom/findajob/jobamax/jobseeker/profile/jobSearch/JobSearchState;", "setJobSearchState", "(Lcom/findajob/jobamax/jobseeker/profile/jobSearch/JobSearchState;)V", "layoutRes", "", "getLayoutRes", "()I", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "setNavController", "(Landroidx/navigation/NavController;)V", "viewModel", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkArguments", "", "configureViewModel", "Lcom/findajob/jobamax/base/BaseViewModel;", "initViews", "onActivityResult", "requestCode", "resultCode", "d", "Landroid/content/Intent;", "onBackButtonClicked", "onCreated", "savedInstance", "Landroid/os/Bundle;", "onLocationClicked", "onResetClicked", "onSubmitButtonClicked", "onTemporaryPermanentClicked", "view", "Landroid/view/View;", "subscribeObserver", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class JobSearchFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentJobSearchBinding> implements com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchInterface {
    public androidx.navigation.NavController navController;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState jobSearchState;
    private boolean jobSearchArg = false;
    private java.util.HashMap _$_findViewCache;
    
    public JobSearchFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.navigation.NavController getNavController() {
        return null;
    }
    
    public final void setNavController(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState getJobSearchState() {
        return null;
    }
    
    public final void setJobSearchState(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState p0) {
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    private final void initViews() {
    }
    
    private final void configureViewModel() {
    }
    
    @java.lang.Override()
    public void onResetClicked() {
    }
    
    public final void subscribeObserver() {
    }
    
    @java.lang.Override()
    public void onBackButtonClicked() {
    }
    
    @java.lang.Override()
    public void onLocationClicked() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent d) {
    }
    
    @java.lang.Override()
    public void onTemporaryPermanentClicked(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onSubmitButtonClicked() {
    }
    
    private final void checkArguments() {
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected com.findajob.jobamax.base.BaseViewModel getViewModel() {
        return null;
    }
}