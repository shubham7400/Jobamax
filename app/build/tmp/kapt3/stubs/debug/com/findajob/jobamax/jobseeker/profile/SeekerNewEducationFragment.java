package com.findajob.jobamax.jobseeker.profile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u0017\u001a\u00020\u001dH\u0014J\u0016\u0010\u001e\u001a\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0 H\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010(H\u0014J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\"H\u0002J\b\u0010-\u001a\u00020\u001cH\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006."}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/SeekerNewEducationFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentSeekerNewEducationBinding;", "Lcom/findajob/jobamax/jobseeker/profile/idealjob/IOnBackPressed;", "()V", "educationOld", "Lcom/findajob/jobamax/jobseeker/profile/cv/model/Education;", "getEducationOld", "()Lcom/findajob/jobamax/jobseeker/profile/cv/model/Education;", "setEducationOld", "(Lcom/findajob/jobamax/jobseeker/profile/cv/model/Education;)V", "layoutRes", "", "getLayoutRes", "()I", "university", "Lcom/findajob/jobamax/data/pojo/University;", "getUniversity", "()Lcom/findajob/jobamax/data/pojo/University;", "setUniversity", "(Lcom/findajob/jobamax/data/pojo/University;)V", "viewModel", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "Landroidx/lifecycle/ViewModel;", "onBackPressed", "callback", "Lkotlin/Function0;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreated", "savedInstance", "onDateClicked", "view", "setClickListeners", "app_debug"})
public final class SeekerNewEducationFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentSeekerNewEducationBinding> implements com.findajob.jobamax.jobseeker.profile.idealjob.IOnBackPressed {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.findajob.jobamax.jobseeker.profile.cv.model.Education educationOld;
    @org.jetbrains.annotations.Nullable()
    private com.findajob.jobamax.data.pojo.University university;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerNewEducationFragment() {
        super();
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.findajob.jobamax.jobseeker.profile.cv.model.Education getEducationOld() {
        return null;
    }
    
    public final void setEducationOld(@org.jetbrains.annotations.Nullable()
    com.findajob.jobamax.jobseeker.profile.cv.model.Education p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.findajob.jobamax.data.pojo.University getUniversity() {
        return null;
    }
    
    public final void setUniversity(@org.jetbrains.annotations.Nullable()
    com.findajob.jobamax.data.pojo.University p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void configureUi() {
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    private final void setClickListeners() {
    }
    
    private final void onDateClicked(android.view.View view) {
    }
    
    @java.lang.Override()
    public void onBackPressed(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
}