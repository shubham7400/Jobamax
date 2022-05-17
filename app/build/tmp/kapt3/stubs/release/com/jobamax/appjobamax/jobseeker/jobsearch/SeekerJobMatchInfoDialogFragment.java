package com.jobamax.appjobamax.jobseeker.jobsearch;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0003J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0017J\b\u0010 \u001a\u00020\u000bH\u0016J4\u0010!\u001a\u00020\u000b2\u001a\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010#j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J<\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020&2\u001a\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010#j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`$2\u0006\u0010\'\u001a\u00020&H\u0003J\b\u0010-\u001a\u00020\u000bH\u0003J\b\u0010.\u001a\u00020\u000bH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/jobsearch/SeekerJobMatchInfoDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentSeekerJobMatchInfoDialogBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentSeekerJobMatchInfoDialogBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentSeekerJobMatchInfoDialogBinding;)V", "onProfileClick", "Lkotlin/Function0;", "", "getOnProfileClick", "()Lkotlin/jvm/functions/Function0;", "setOnProfileClick", "(Lkotlin/jvm/functions/Function0;)V", "profilePicUrl", "", "topJobOffer", "Lcom/jobamax/appjobamax/model/NewJobOffer;", "configureUi", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "setChips", "missingTags", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "colorId", "", "type", "setClickListeners", "setColor", "seekBar", "Landroid/widget/SeekBar;", "progress", "setData", "setPercentageChartViewColor", "Companion", "app_release"})
public final class SeekerJobMatchInfoDialogFragment extends androidx.fragment.app.DialogFragment {
    public com.jobamax.appjobamax.databinding.FragmentSeekerJobMatchInfoDialogBinding binding;
    private com.jobamax.appjobamax.model.NewJobOffer topJobOffer;
    private java.lang.String profilePicUrl = "";
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onProfileClick;
    @org.jetbrains.annotations.NotNull()
    public static final com.jobamax.appjobamax.jobseeker.jobsearch.SeekerJobMatchInfoDialogFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerJobMatchInfoDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentSeekerJobMatchInfoDialogBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentSeekerJobMatchInfoDialogBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnProfileClick() {
        return null;
    }
    
    public final void setOnProfileClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
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
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    private final void setData() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    private final void setColor(android.widget.SeekBar seekBar, int progress, java.util.ArrayList<java.lang.String> missingTags, int type) {
    }
    
    private final void setChips(java.util.ArrayList<java.lang.String> missingTags, int colorId, int type) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/jobsearch/SeekerJobMatchInfoDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/jobamax/appjobamax/jobseeker/jobsearch/SeekerJobMatchInfoDialogFragment;", "topJobOffer", "Lcom/jobamax/appjobamax/model/NewJobOffer;", "profilePicUrl", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jobamax.appjobamax.jobseeker.jobsearch.SeekerJobMatchInfoDialogFragment newInstance(@org.jetbrains.annotations.NotNull()
        com.jobamax.appjobamax.model.NewJobOffer topJobOffer, @org.jetbrains.annotations.NotNull()
        java.lang.String profilePicUrl) {
            return null;
        }
    }
}