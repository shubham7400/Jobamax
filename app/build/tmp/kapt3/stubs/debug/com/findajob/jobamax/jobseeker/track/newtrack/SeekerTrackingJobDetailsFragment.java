package com.findajob.jobamax.jobseeker.track.newtrack;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H\u0002J\b\u0010!\u001a\u00020\'H\u0014J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00100\u001a\u00020&2\b\u00101\u001a\u0004\u0018\u00010/H\u0014J\b\u0010\b\u001a\u00020&H\u0002J\b\u00102\u001a\u00020&H\u0002J\b\u00103\u001a\u00020&H\u0002J\b\u00104\u001a\u00020&H\u0002J\b\u00105\u001a\u00020&H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"\u00a8\u00066"}, d2 = {"Lcom/findajob/jobamax/jobseeker/track/newtrack/SeekerTrackingJobDetailsFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentSeekerTrackingJobDetailsBinding;", "()V", "adapter", "Lcom/findajob/jobamax/jobseeker/track/newtrack/SeekerTrackingJobDetailsAdapter;", "getAdapter", "()Lcom/findajob/jobamax/jobseeker/track/newtrack/SeekerTrackingJobDetailsAdapter;", "setAdapter", "(Lcom/findajob/jobamax/jobseeker/track/newtrack/SeekerTrackingJobDetailsAdapter;)V", "existingPhaseList", "Ljava/util/ArrayList;", "Lcom/findajob/jobamax/data/pojo/Phase;", "getExistingPhaseList", "()Ljava/util/ArrayList;", "setExistingPhaseList", "(Ljava/util/ArrayList;)V", "layoutRes", "", "getLayoutRes", "()I", "phases", "", "getPhases", "setPhases", "trackingJob", "Lcom/findajob/jobamax/model/TrackingJob;", "getTrackingJob", "()Lcom/findajob/jobamax/model/TrackingJob;", "setTrackingJob", "(Lcom/findajob/jobamax/model/TrackingJob;)V", "viewModel", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "Landroidx/lifecycle/ViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreated", "savedInstance", "setClickListeners", "setData", "updateData", "viewModelObserver", "app_debug"})
public final class SeekerTrackingJobDetailsFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentSeekerTrackingJobDetailsBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.findajob.jobamax.jobseeker.track.newtrack.SeekerTrackingJobDetailsAdapter adapter;
    @org.jetbrains.annotations.Nullable()
    private com.findajob.jobamax.model.TrackingJob trackingJob;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> phases;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.findajob.jobamax.data.pojo.Phase> existingPhaseList;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerTrackingJobDetailsFragment() {
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
    public final com.findajob.jobamax.jobseeker.track.newtrack.SeekerTrackingJobDetailsAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.track.newtrack.SeekerTrackingJobDetailsAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.findajob.jobamax.model.TrackingJob getTrackingJob() {
        return null;
    }
    
    public final void setTrackingJob(@org.jetbrains.annotations.Nullable()
    com.findajob.jobamax.model.TrackingJob p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getPhases() {
        return null;
    }
    
    public final void setPhases(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.findajob.jobamax.data.pojo.Phase> getExistingPhaseList() {
        return null;
    }
    
    public final void setExistingPhaseList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.data.pojo.Phase> p0) {
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
    
    private final void setData() {
    }
    
    private final void setAdapter() {
    }
    
    private final void viewModelObserver() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void updateData() {
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
}