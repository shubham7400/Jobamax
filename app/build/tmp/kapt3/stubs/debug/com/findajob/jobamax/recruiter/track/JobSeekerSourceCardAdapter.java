package com.findajob.jobamax.recruiter.track;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\'BS\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006\u0012!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u001c\u0010\u001d\u001a\u00020\u000b2\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u001c\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0016J\u0014\u0010$\u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120&R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00120\u00120\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R,\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017\u00a8\u0006("}, d2 = {"Lcom/findajob/jobamax/recruiter/track/JobSeekerSourceCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/findajob/jobamax/recruiter/track/JobSeekerSourceCardAdapter$JobOfferCardViewHolder;", "gson", "Lcom/google/gson/Gson;", "enableGesture", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "flag", "", "navVideo", "", "url", "(Lcom/google/gson/Gson;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "diffCallBack", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/parse/ParseObject;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "getEnableGesture", "()Lkotlin/jvm/functions/Function1;", "getGson", "()Lcom/google/gson/Gson;", "getNavVideo", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitJobSeekers", "jobSeekers", "", "JobOfferCardViewHolder", "app_debug"})
public final class JobSeekerSourceCardAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.findajob.jobamax.recruiter.track.JobSeekerSourceCardAdapter.JobOfferCardViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> enableGesture = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> navVideo = null;
    private final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.parse.ParseObject> diffCallBack = null;
    private final androidx.recyclerview.widget.AsyncListDiffer<com.parse.ParseObject> differ = null;
    
    public JobSeekerSourceCardAdapter(@org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> enableGesture, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> navVideo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson getGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> getEnableGesture() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getNavVideo() {
        return null;
    }
    
    public final void submitJobSeekers(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.parse.ParseObject> jobSeekers) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.findajob.jobamax.recruiter.track.JobSeekerSourceCardAdapter.JobOfferCardViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.recruiter.track.JobSeekerSourceCardAdapter.JobOfferCardViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/findajob/jobamax/recruiter/track/JobSeekerSourceCardAdapter$JobOfferCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/findajob/jobamax/databinding/ItemJobSeekerSourceCardBinding;", "(Lcom/findajob/jobamax/recruiter/track/JobSeekerSourceCardAdapter;Lcom/findajob/jobamax/databinding/ItemJobSeekerSourceCardBinding;)V", "getBinding", "()Lcom/findajob/jobamax/databinding/ItemJobSeekerSourceCardBinding;", "bindTo", "", "jobSeeker", "Lcom/findajob/jobamax/model/JobSeeker;", "refreshChips", "chipGroup", "Lcom/google/android/material/chip/ChipGroup;", "list", "", "", "app_debug"})
    public final class JobOfferCardViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.findajob.jobamax.databinding.ItemJobSeekerSourceCardBinding binding = null;
        
        public JobOfferCardViewHolder(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.databinding.ItemJobSeekerSourceCardBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.databinding.ItemJobSeekerSourceCardBinding getBinding() {
            return null;
        }
        
        public final void bindTo(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.model.JobSeeker jobSeeker) {
        }
        
        private final void refreshChips(com.google.android.material.chip.ChipGroup chipGroup, java.util.List<java.lang.String> list) {
        }
    }
}