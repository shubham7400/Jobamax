package com.jobamax.appjobamax.jobseeker.jobsearch;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0002J\b\u00105\u001a\u000203H\u0002J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\u00160\fH\u0002J\b\u00107\u001a\u000203H\u0002J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\u001609H\u0002J\b\u0010:\u001a\u000203H\u0002J\b\u0010.\u001a\u00020;H\u0014J\u0016\u0010<\u001a\u0002032\f\u0010=\u001a\b\u0012\u0004\u0012\u0002030>H\u0016J$\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010G\u001a\u0002032\b\u0010H\u001a\u0004\u0018\u00010FH\u0014J\u001a\u0010I\u001a\u0002032\u0006\u0010J\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0016\u0010K\u001a\u0002032\f\u0010=\u001a\b\u0012\u0004\u0012\u0002030>H\u0002J\b\u0010L\u001a\u000203H\u0002J\b\u0010M\u001a\u000203H\u0002J\b\u0010N\u001a\u000203H\u0002J\b\u0010O\u001a\u000203H\u0002J\b\u0010P\u001a\u000203H\u0002J\b\u0010Q\u001a\u000203H\u0002J\u0016\u0010R\u001a\u0002032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\b\u0010S\u001a\u000203H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001f8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u001a\u0010&\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010,\u001a\u00020-8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/\u00a8\u0006T"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/jobsearch/SeekerJobsFilterFragment;", "Lcom/jobamax/appjobamax/base/BaseFragmentMain;", "Lcom/jobamax/appjobamax/databinding/FragmentSeekerJobsFilterBinding;", "Lcom/jobamax/appjobamax/jobseeker/profile/idealjob/IOnBackPressed;", "()V", "autocompleteFragment", "Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;", "getAutocompleteFragment", "()Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;", "setAutocompleteFragment", "(Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;)V", "categories", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/data/pojo/Categories;", "isJobTitleSelected", "", "()Z", "setJobTitleSelected", "(Z)V", "jobTitleAdapter", "Lcom/jobamax/appjobamax/jobseeker/jobsearch/SeekerJobTitleAdapter;", "jobTitles", "", "lat", "", "getLat", "()Ljava/lang/Double;", "setLat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "layoutRes", "", "getLayoutRes", "()I", "listOfTypeOfWork", "lng", "getLng", "setLng", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "setNavController", "(Landroidx/navigation/NavController;)V", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/home/JobSeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/home/JobSeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "experienceListener", "getCurrent", "getExperience", "getGPSLocation", "getIndustries", "", "getJobTypes", "Landroidx/lifecycle/ViewModel;", "onBackPressed", "callback", "Lkotlin/Function0;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreated", "savedInstance", "onViewCreated", "view", "saveFilters", "setIndustryListRecyclerview", "setJobTypeRecyclerview", "setListeners", "setPlaceAutocompleteFragment", "setPreferenceValue", "typeOfWorkListeners", "updateList", "viewModelObserver", "app_debug"})
public final class SeekerJobsFilterFragment extends com.jobamax.appjobamax.base.BaseFragmentMain<com.jobamax.appjobamax.databinding.FragmentSeekerJobsFilterBinding> implements com.jobamax.appjobamax.jobseeker.profile.idealjob.IOnBackPressed {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.google.android.libraries.places.widget.AutocompleteSupportFragment autocompleteFragment;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Double lat;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Double lng;
    private com.jobamax.appjobamax.jobseeker.jobsearch.SeekerJobTitleAdapter jobTitleAdapter;
    private java.util.ArrayList<java.lang.String> jobTitles;
    private boolean isJobTitleSelected = false;
    private java.util.ArrayList<com.jobamax.appjobamax.data.pojo.Categories> categories;
    private final java.util.ArrayList<java.lang.String> listOfTypeOfWork = null;
    public androidx.navigation.NavController navController;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerJobsFilterFragment() {
        super();
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.libraries.places.widget.AutocompleteSupportFragment getAutocompleteFragment() {
        return null;
    }
    
    public final void setAutocompleteFragment(@org.jetbrains.annotations.NotNull()
    com.google.android.libraries.places.widget.AutocompleteSupportFragment p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getLat() {
        return null;
    }
    
    public final void setLat(@org.jetbrains.annotations.Nullable()
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getLng() {
        return null;
    }
    
    public final void setLng(@org.jetbrains.annotations.Nullable()
    java.lang.Double p0) {
    }
    
    public final boolean isJobTitleSelected() {
        return false;
    }
    
    public final void setJobTitleSelected(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.navigation.NavController getNavController() {
        return null;
    }
    
    public final void setNavController(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController p0) {
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
    
    private final void setIndustryListRecyclerview() {
    }
    
    private final void updateList(java.util.ArrayList<com.jobamax.appjobamax.data.pojo.Categories> categories) {
    }
    
    private final void getGPSLocation() {
    }
    
    private final void setJobTypeRecyclerview() {
    }
    
    private final void viewModelObserver() {
    }
    
    private final void getCurrent() {
    }
    
    private final void setPreferenceValue() {
    }
    
    private final void setListeners() {
    }
    
    private final void experienceListener() {
    }
    
    private final void typeOfWorkListeners() {
    }
    
    private final void getJobTypes() {
    }
    
    private final void saveFilters(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    private final java.util.List<java.lang.String> getIndustries() {
        return null;
    }
    
    private final java.util.ArrayList<java.lang.String> getExperience() {
        return null;
    }
    
    private final void setPlaceAutocompleteFragment() {
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onBackPressed(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
}