package com.findajob.jobamax.jobseeker.jobsearch;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J4\u0010\u0019\u001a\u00020\f2\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\fH\u0002J<\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020!2\u001a\u0010\'\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dH\u0002J\b\u0010(\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020\fH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/findajob/jobamax/jobseeker/jobsearch/SeekerJobMatchInfoDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lcom/findajob/jobamax/databinding/FragmentSeekerJobMatchInfoDialogBinding;", "getBinding", "()Lcom/findajob/jobamax/databinding/FragmentSeekerJobMatchInfoDialogBinding;", "setBinding", "(Lcom/findajob/jobamax/databinding/FragmentSeekerJobMatchInfoDialogBinding;)V", "topJobOffer", "Lcom/findajob/jobamax/model/NewJobOffer;", "configureUi", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "setChips", "list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "chipGroup", "Lcom/google/android/material/chip/ChipGroup;", "color", "", "setClickListeners", "setColor", "seekBar", "Landroid/widget/SeekBar;", "progress", "missingTags", "setData", "setPercentageChartViewColor", "Companion", "app_debug"})
public final class SeekerJobMatchInfoDialogFragment extends androidx.fragment.app.DialogFragment {
    public com.findajob.jobamax.databinding.FragmentSeekerJobMatchInfoDialogBinding binding;
    private com.findajob.jobamax.model.NewJobOffer topJobOffer;
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.jobseeker.jobsearch.SeekerJobMatchInfoDialogFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerJobMatchInfoDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.databinding.FragmentSeekerJobMatchInfoDialogBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.databinding.FragmentSeekerJobMatchInfoDialogBinding p0) {
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
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setData() {
    }
    
    private final void setColor(android.widget.SeekBar seekBar, com.google.android.material.chip.ChipGroup chipGroup, int progress, java.util.ArrayList<java.lang.String> missingTags) {
    }
    
    private final void setChips(java.util.ArrayList<java.lang.String> list, com.google.android.material.chip.ChipGroup chipGroup, int color) {
    }
    
    private final void configureUi() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void setPercentageChartViewColor() {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/jobseeker/jobsearch/SeekerJobMatchInfoDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/findajob/jobamax/jobseeker/jobsearch/SeekerJobMatchInfoDialogFragment;", "topJobOffer", "Lcom/findajob/jobamax/model/NewJobOffer;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.jobseeker.jobsearch.SeekerJobMatchInfoDialogFragment newInstance(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.model.NewJobOffer topJobOffer) {
            return null;
        }
    }
}