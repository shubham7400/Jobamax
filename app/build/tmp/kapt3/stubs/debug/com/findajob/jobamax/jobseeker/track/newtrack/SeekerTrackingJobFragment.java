package com.findajob.jobamax.jobseeker.track.newtrack;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u0017\u001a\u00020\u001dH\u0014J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020\u001c2\b\u0010\'\u001a\u0004\u0018\u00010%H\u0014J\b\u0010\b\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006*"}, d2 = {"Lcom/findajob/jobamax/jobseeker/track/newtrack/SeekerTrackingJobFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentSeekerTrackingJobBinding;", "()V", "adapter", "Lcom/findajob/jobamax/jobseeker/track/newtrack/SeekerTrackingJobAdapter;", "getAdapter", "()Lcom/findajob/jobamax/jobseeker/track/newtrack/SeekerTrackingJobAdapter;", "setAdapter", "(Lcom/findajob/jobamax/jobseeker/track/newtrack/SeekerTrackingJobAdapter;)V", "layoutRes", "", "getLayoutRes", "()I", "trackingJobList", "Ljava/util/ArrayList;", "Lcom/findajob/jobamax/model/TrackingJob;", "getTrackingJobList", "()Ljava/util/ArrayList;", "setTrackingJobList", "(Ljava/util/ArrayList;)V", "viewModel", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "Landroidx/lifecycle/ViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreated", "savedInstance", "setClickListeners", "viewModelObserver", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class SeekerTrackingJobFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentSeekerTrackingJobBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.findajob.jobamax.model.TrackingJob> trackingJobList;
    public com.findajob.jobamax.jobseeker.track.newtrack.SeekerTrackingJobAdapter adapter;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerTrackingJobFragment() {
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
    public final java.util.ArrayList<com.findajob.jobamax.model.TrackingJob> getTrackingJobList() {
        return null;
    }
    
    public final void setTrackingJobList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.model.TrackingJob> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.track.newtrack.SeekerTrackingJobAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.track.newtrack.SeekerTrackingJobAdapter p0) {
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
    
    private final void setAdapter() {
    }
    
    private final void viewModelObserver() {
    }
    
    private final void setClickListeners() {
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
}