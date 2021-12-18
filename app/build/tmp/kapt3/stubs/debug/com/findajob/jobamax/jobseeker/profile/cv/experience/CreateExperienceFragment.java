package com.findajob.jobamax.jobseeker.profile.cv.experience;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010\u001a\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\u001fH\u0002J\"\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010\'\u001a\u00020\u001fH\u0016J\u0012\u0010(\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u0018\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000fH\u0016J\b\u0010/\u001a\u00020\u001fH\u0016J\b\u00100\u001a\u00020\u001fH\u0016J\b\u00101\u001a\u00020\rH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b\u00a8\u00062"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/cv/experience/CreateExperienceFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentCreateExperienceBinding;", "Lcom/findajob/jobamax/jobseeker/profile/cv/experience/CreateExperienceHandler;", "()V", "experience", "Lcom/findajob/jobamax/jobseeker/profile/cv/model/Experience;", "getExperience", "()Lcom/findajob/jobamax/jobseeker/profile/cv/model/Experience;", "setExperience", "(Lcom/findajob/jobamax/jobseeker/profile/cv/model/Experience;)V", "isUpdateObservable", "Landroidx/lifecycle/MutableLiveData;", "", "layoutRes", "", "getLayoutRes", "()I", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "setNavController", "(Landroidx/navigation/NavController;)V", "viewModel", "Lcom/findajob/jobamax/jobseeker/profile/cv/JobSeekerResumeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/jobseeker/profile/cv/JobSeekerResumeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkArguments", "", "Landroidx/lifecycle/ViewModel;", "initViews", "onActivityResult", "requestCode", "resultCode", "d", "Landroid/content/Intent;", "onBackButtonClicked", "onCreated", "savedInstance", "Landroid/os/Bundle;", "onDateClicked", "view", "Landroid/view/View;", "flag", "onLocationClicked", "onSaveButtonClicked", "validateFields", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class CreateExperienceFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentCreateExperienceBinding> implements com.findajob.jobamax.jobseeker.profile.cv.experience.CreateExperienceHandler {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public androidx.navigation.NavController navController;
    @org.jetbrains.annotations.NotNull()
    private com.findajob.jobamax.jobseeker.profile.cv.model.Experience experience;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isUpdateObservable = null;
    private java.util.HashMap _$_findViewCache;
    
    public CreateExperienceFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.profile.cv.JobSeekerResumeViewModel getViewModel() {
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
    public final com.findajob.jobamax.jobseeker.profile.cv.model.Experience getExperience() {
        return null;
    }
    
    public final void setExperience(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.cv.model.Experience p0) {
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    private final void initViews() {
    }
    
    private final void checkArguments() {
    }
    
    @java.lang.Override()
    public void onSaveButtonClicked() {
    }
    
    private final boolean validateFields() {
        return false;
    }
    
    @java.lang.Override()
    public void onDateClicked(@org.jetbrains.annotations.NotNull()
    android.view.View view, int flag) {
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
    public void onBackButtonClicked() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent d) {
    }
    
    @java.lang.Override()
    public void onLocationClicked() {
    }
}