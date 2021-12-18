package com.findajob.jobamax.recruiter.track;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001#B0\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0014\u0010\u0019\u001a\u00020\u000b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bJ\u001c\u0010\u001c\u001a\u00020\u000b2\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\u001c\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018H\u0016R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u000f0\u000f0\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R,\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006$"}, d2 = {"Lcom/findajob/jobamax/recruiter/track/JobSeekerRecruitCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/findajob/jobamax/recruiter/track/JobSeekerRecruitCardAdapter$JobOfferCardViewHolder;", "gson", "Lcom/google/gson/Gson;", "navVideo", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "url", "", "(Lcom/google/gson/Gson;Lkotlin/jvm/functions/Function1;)V", "diffUtil", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/parse/ParseObject;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "getNavVideo", "()Lkotlin/jvm/functions/Function1;", "getItemCount", "", "notifyJobSeekersChanged", "jobSeekers", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "JobOfferCardViewHolder", "app_debug"})
public final class JobSeekerRecruitCardAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.findajob.jobamax.recruiter.track.JobSeekerRecruitCardAdapter.JobOfferCardViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> navVideo = null;
    private final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.parse.ParseObject> diffUtil = null;
    private final androidx.recyclerview.widget.AsyncListDiffer<com.parse.ParseObject> differ = null;
    
    public JobSeekerRecruitCardAdapter(@org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> navVideo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson getGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getNavVideo() {
        return null;
    }
    
    public final void notifyJobSeekersChanged(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.parse.ParseObject> jobSeekers) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.findajob.jobamax.recruiter.track.JobSeekerRecruitCardAdapter.JobOfferCardViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.recruiter.track.JobSeekerRecruitCardAdapter.JobOfferCardViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/findajob/jobamax/recruiter/track/JobSeekerRecruitCardAdapter$JobOfferCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/findajob/jobamax/databinding/ItemJobSeekerRecruitCardBinding;", "(Lcom/findajob/jobamax/recruiter/track/JobSeekerRecruitCardAdapter;Lcom/findajob/jobamax/databinding/ItemJobSeekerRecruitCardBinding;)V", "getBinding", "()Lcom/findajob/jobamax/databinding/ItemJobSeekerRecruitCardBinding;", "bindTo", "", "jobSeeker", "Lcom/findajob/jobamax/model/JobSeeker;", "refreshChips", "chipGroup", "Lcom/google/android/material/chip/ChipGroup;", "list", "", "", "app_debug"})
    public final class JobOfferCardViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.findajob.jobamax.databinding.ItemJobSeekerRecruitCardBinding binding = null;
        
        public JobOfferCardViewHolder(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.databinding.ItemJobSeekerRecruitCardBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.databinding.ItemJobSeekerRecruitCardBinding getBinding() {
            return null;
        }
        
        public final void bindTo(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.model.JobSeeker jobSeeker) {
        }
        
        private final void refreshChips(com.google.android.material.chip.ChipGroup chipGroup, java.util.List<java.lang.String> list) {
        }
    }
}