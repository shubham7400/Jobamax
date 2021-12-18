package com.findajob.jobamax.jobseeker.track;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0002J\u0012\u0010%\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014J\u0016\u0010(\u001a\u00020!2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006,"}, d2 = {"Lcom/findajob/jobamax/jobseeker/track/JobOfferCardInfoFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentJobOfferCardInfoBinding;", "()V", "jobSeekerHomeViewModel", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "getJobSeekerHomeViewModel", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "jobSeekerHomeViewModel$delegate", "Lkotlin/Lazy;", "layoutRes", "", "getLayoutRes", "()I", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "setNavController", "(Landroidx/navigation/NavController;)V", "parseObject", "Lcom/parse/ParseObject;", "getParseObject", "()Lcom/parse/ParseObject;", "setParseObject", "(Lcom/parse/ParseObject;)V", "viewModel", "Lcom/findajob/jobamax/jobseeker/track/JobSeekerApplyViewModel;", "getViewModel", "()Lcom/findajob/jobamax/jobseeker/track/JobSeekerApplyViewModel;", "viewModel$delegate", "Landroidx/lifecycle/ViewModel;", "initViews", "", "loadCompanyData", "company", "Lcom/findajob/jobamax/model/Company;", "onCreated", "savedInstance", "Landroid/os/Bundle;", "refreshChips", "keySkills", "", "", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class JobOfferCardInfoFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentJobOfferCardInfoBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy jobSeekerHomeViewModel$delegate = null;
    public androidx.navigation.NavController navController;
    public com.parse.ParseObject parseObject;
    private java.util.HashMap _$_findViewCache;
    
    public JobOfferCardInfoFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.track.JobSeekerApplyViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel getJobSeekerHomeViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.navigation.NavController getNavController() {
        return null;
    }
    
    public final void setNavController(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseObject getParseObject() {
        return null;
    }
    
    public final void setParseObject(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject p0) {
    }
    
    private final void initViews() {
    }
    
    private final void loadCompanyData(com.findajob.jobamax.model.Company company) {
    }
    
    private final void refreshChips(java.util.List<java.lang.String> keySkills) {
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
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
}