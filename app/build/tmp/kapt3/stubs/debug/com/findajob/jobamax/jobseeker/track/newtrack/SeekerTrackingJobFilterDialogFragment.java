package com.findajob.jobamax.jobseeker.track.newtrack;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010\'\u001a\u00020\u0011H\u0016J\b\u0010(\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006*"}, d2 = {"Lcom/findajob/jobamax/jobseeker/track/newtrack/SeekerTrackingJobFilterDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lcom/findajob/jobamax/databinding/FragmentSeekerTrackingJobFilterDialogBinding;", "getBinding", "()Lcom/findajob/jobamax/databinding/FragmentSeekerTrackingJobFilterDialogBinding;", "setBinding", "(Lcom/findajob/jobamax/databinding/FragmentSeekerTrackingJobFilterDialogBinding;)V", "filteredJob", "Lcom/findajob/jobamax/enums/SeekerTrackingJobFilter;", "getFilteredJob", "()Lcom/findajob/jobamax/enums/SeekerTrackingJobFilter;", "setFilteredJob", "(Lcom/findajob/jobamax/enums/SeekerTrackingJobFilter;)V", "onGoClickListener", "Lkotlin/Function1;", "", "getOnGoClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnGoClickListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedFilter", "", "getSelectedFilter", "()Ljava/lang/String;", "setSelectedFilter", "(Ljava/lang/String;)V", "configureUi", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "setClickListeners", "Companion", "app_debug"})
public final class SeekerTrackingJobFilterDialogFragment extends androidx.fragment.app.DialogFragment {
    public com.findajob.jobamax.databinding.FragmentSeekerTrackingJobFilterDialogBinding binding;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.findajob.jobamax.enums.SeekerTrackingJobFilter, kotlin.Unit> onGoClickListener;
    @org.jetbrains.annotations.NotNull()
    private com.findajob.jobamax.enums.SeekerTrackingJobFilter filteredJob = com.findajob.jobamax.enums.SeekerTrackingJobFilter.ALL;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedFilter = "";
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.jobseeker.track.newtrack.SeekerTrackingJobFilterDialogFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerTrackingJobFilterDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.databinding.FragmentSeekerTrackingJobFilterDialogBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.databinding.FragmentSeekerTrackingJobFilterDialogBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.findajob.jobamax.enums.SeekerTrackingJobFilter, kotlin.Unit> getOnGoClickListener() {
        return null;
    }
    
    public final void setOnGoClickListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.findajob.jobamax.enums.SeekerTrackingJobFilter, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.enums.SeekerTrackingJobFilter getFilteredJob() {
        return null;
    }
    
    public final void setFilteredJob(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.enums.SeekerTrackingJobFilter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSelectedFilter() {
        return null;
    }
    
    public final void setSelectedFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    private final void setSelectedFilter() {
    }
    
    private final void setClickListeners() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/jobseeker/track/newtrack/SeekerTrackingJobFilterDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/findajob/jobamax/jobseeker/track/newtrack/SeekerTrackingJobFilterDialogFragment;", "selectedFilter", "Lcom/findajob/jobamax/enums/SeekerTrackingJobFilter;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.jobseeker.track.newtrack.SeekerTrackingJobFilterDialogFragment newInstance(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.enums.SeekerTrackingJobFilter selectedFilter) {
            return null;
        }
    }
}