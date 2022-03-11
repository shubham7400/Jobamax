package com.findajob.jobamax.jobseeker.profile.cv;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010$\u001a\u00020%H\u0002J\b\u0010!\u001a\u00020&H\u0014J\b\u0010\'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0002J\b\u0010)\u001a\u00020%H\u0002J\b\u0010*\u001a\u00020%H\u0016J\b\u0010+\u001a\u00020%H\u0016J\b\u0010,\u001a\u00020%H\u0016J\b\u0010-\u001a\u00020%H\u0016J\b\u0010.\u001a\u00020%H\u0016J\u0012\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\u0010\u00102\u001a\u00020%2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020%2\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020%H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00168TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u0014\u001a\u0004\b!\u0010\"\u00a8\u00069"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/cv/JobSeekerResumeFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentJobSeekerResumeBinding;", "Lcom/findajob/jobamax/jobseeker/profile/cv/JobSeekerResumeHandler;", "()V", "educationAdapter", "Lcom/findajob/jobamax/jobseeker/profile/cv/adapter/EducationAdapter;", "experienceAdapter", "Lcom/findajob/jobamax/jobseeker/profile/cv/adapter/ExperienceAdapter;", "gsonConverter", "Lcom/google/gson/Gson;", "getGsonConverter", "()Lcom/google/gson/Gson;", "setGsonConverter", "(Lcom/google/gson/Gson;)V", "homeViewModel", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "getHomeViewModel", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "homeViewModel$delegate", "Lkotlin/Lazy;", "layoutRes", "", "getLayoutRes", "()I", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "setNavController", "(Landroidx/navigation/NavController;)V", "viewModel", "Lcom/findajob/jobamax/jobseeker/profile/cv/JobSeekerResumeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/jobseeker/profile/cv/JobSeekerResumeViewModel;", "viewModel$delegate", "configureViewModel", "", "Landroidx/lifecycle/ViewModel;", "initViews", "loadActivityChips", "loadSkillChips", "onAddActivityClicked", "onAddEducationClicked", "onAddExperienceClicked", "onAddSkillsClicked", "onBackButtonClicked", "onCreated", "savedInstance", "Landroid/os/Bundle;", "showDeleteEducationDialog", "education", "Lcom/findajob/jobamax/jobseeker/profile/cv/model/Education;", "showDeleteExperienceDialog", "experience", "Lcom/findajob/jobamax/jobseeker/profile/cv/model/Experience;", "subscribeObserver", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class JobSeekerResumeFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentJobSeekerResumeBinding> implements com.findajob.jobamax.jobseeker.profile.cv.JobSeekerResumeHandler {
    public androidx.navigation.NavController navController;
    @javax.inject.Inject()
    public com.google.gson.Gson gsonConverter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy homeViewModel$delegate = null;
    private com.findajob.jobamax.jobseeker.profile.cv.adapter.EducationAdapter educationAdapter;
    private com.findajob.jobamax.jobseeker.profile.cv.adapter.ExperienceAdapter experienceAdapter;
    private java.util.HashMap _$_findViewCache;
    
    public JobSeekerResumeFragment() {
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
    public final com.google.gson.Gson getGsonConverter() {
        return null;
    }
    
    public final void setGsonConverter(@org.jetbrains.annotations.NotNull()
    com.google.gson.Gson p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.profile.cv.JobSeekerResumeViewModel getViewModel() {
        return null;
    }
    
    private final com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel getHomeViewModel() {
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
    
    private final void initViews() {
    }
    
    private final void subscribeObserver() {
    }
    
    @java.lang.Override()
    public void onAddEducationClicked() {
    }
    
    @java.lang.Override()
    public void onAddExperienceClicked() {
    }
    
    @java.lang.Override()
    public void onAddSkillsClicked() {
    }
    
    private final void loadSkillChips() {
    }
    
    @java.lang.Override()
    public void onAddActivityClicked() {
    }
    
    private final void loadActivityChips() {
    }
    
    @java.lang.Override()
    public void onBackButtonClicked() {
    }
    
    private final void showDeleteEducationDialog(com.findajob.jobamax.jobseeker.profile.cv.model.Education education) {
    }
    
    private final void showDeleteExperienceDialog(com.findajob.jobamax.jobseeker.profile.cv.model.Experience experience) {
    }
}