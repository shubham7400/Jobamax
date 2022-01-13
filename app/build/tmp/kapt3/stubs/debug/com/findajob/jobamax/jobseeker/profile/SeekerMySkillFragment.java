package com.findajob.jobamax.jobseeker.profile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020#H\u0002J\b\u0010\u001e\u001a\u00020&H\u0014J$\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0012\u0010/\u001a\u00020#2\b\u00100\u001a\u0004\u0018\u00010.H\u0014J\b\u00101\u001a\u00020#H\u0002J\b\u0010\b\u001a\u00020#H\u0002J\b\u00102\u001a\u00020#H\u0002J\b\u00103\u001a\u00020#H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001b\u0010\u001c\u001a\u00020\u001d8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f\u00a8\u00064"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/SeekerMySkillFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentSeekerMySkillBinding;", "()V", "adapter", "Lcom/findajob/jobamax/jobseeker/profile/SeekerHardSkillAdapter;", "getAdapter", "()Lcom/findajob/jobamax/jobseeker/profile/SeekerHardSkillAdapter;", "setAdapter", "(Lcom/findajob/jobamax/jobseeker/profile/SeekerHardSkillAdapter;)V", "hardSkillSuggestions", "Ljava/util/ArrayList;", "", "getHardSkillSuggestions", "()Ljava/util/ArrayList;", "setHardSkillSuggestions", "(Ljava/util/ArrayList;)V", "layoutRes", "", "getLayoutRes", "()I", "ownedHardSkills", "Lcom/findajob/jobamax/data/pojo/HardSkill;", "getOwnedHardSkills", "setOwnedHardSkills", "ownedSoftSkills", "getOwnedSoftSkills", "setOwnedSoftSkills", "viewModel", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addHardSkill", "", "addSoftSkill", "configureUi", "Landroidx/lifecycle/ViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreated", "savedInstance", "saveSoftSkill", "setClickListeners", "viewModelObserver", "app_debug"})
public final class SeekerMySkillFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentSeekerMySkillBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> hardSkillSuggestions;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.findajob.jobamax.data.pojo.HardSkill> ownedHardSkills;
    public com.findajob.jobamax.jobseeker.profile.SeekerHardSkillAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> ownedSoftSkills;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerMySkillFragment() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getHardSkillSuggestions() {
        return null;
    }
    
    public final void setHardSkillSuggestions(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.findajob.jobamax.data.pojo.HardSkill> getOwnedHardSkills() {
        return null;
    }
    
    public final void setOwnedHardSkills(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.data.pojo.HardSkill> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.profile.SeekerHardSkillAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.SeekerHardSkillAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getOwnedSoftSkills() {
        return null;
    }
    
    public final void setOwnedSoftSkills(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    private final void configureUi() {
    }
    
    private final void setAdapter() {
    }
    
    private final void viewModelObserver() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void saveSoftSkill() {
    }
    
    private final void addHardSkill() {
    }
    
    private final void addSoftSkill() {
    }
}