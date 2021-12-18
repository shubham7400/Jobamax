package com.findajob.jobamax.jobseeker.profile.cv.adapter;

import java.lang.System;

@android.annotation.SuppressLint(value = {"SetTextI18n"})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001!BK\u0012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\t2\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u001c\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J\u001e\u0010\u001d\u001a\u00020\t2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001fj\b\u0012\u0004\u0012\u00020\u0005` R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00050\u00050\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R,\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012\u00a8\u0006\""}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/cv/adapter/ExperienceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/findajob/jobamax/jobseeker/profile/cv/adapter/ExperienceAdapter$ExperienceViewHolder;", "onEditClicked", "Lkotlin/Function1;", "Lcom/findajob/jobamax/jobseeker/profile/cv/model/Experience;", "Lkotlin/ParameterName;", "name", "experience", "", "onDeleteClicked", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "diffUtil", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "getOnDeleteClicked", "()Lkotlin/jvm/functions/Function1;", "getOnEditClicked", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitExperienceList", "experienceList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ExperienceViewHolder", "app_debug"})
public final class ExperienceAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.findajob.jobamax.jobseeker.profile.cv.adapter.ExperienceAdapter.ExperienceViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.findajob.jobamax.jobseeker.profile.cv.model.Experience, kotlin.Unit> onEditClicked = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.findajob.jobamax.jobseeker.profile.cv.model.Experience, kotlin.Unit> onDeleteClicked = null;
    private final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.findajob.jobamax.jobseeker.profile.cv.model.Experience> diffUtil = null;
    private final androidx.recyclerview.widget.AsyncListDiffer<com.findajob.jobamax.jobseeker.profile.cv.model.Experience> differ = null;
    
    public ExperienceAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.findajob.jobamax.jobseeker.profile.cv.model.Experience, kotlin.Unit> onEditClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.findajob.jobamax.jobseeker.profile.cv.model.Experience, kotlin.Unit> onDeleteClicked) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.findajob.jobamax.jobseeker.profile.cv.model.Experience, kotlin.Unit> getOnEditClicked() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.findajob.jobamax.jobseeker.profile.cv.model.Experience, kotlin.Unit> getOnDeleteClicked() {
        return null;
    }
    
    public final void submitExperienceList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.jobseeker.profile.cv.model.Experience> experienceList) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.findajob.jobamax.jobseeker.profile.cv.adapter.ExperienceAdapter.ExperienceViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.cv.adapter.ExperienceAdapter.ExperienceViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/cv/adapter/ExperienceAdapter$ExperienceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/findajob/jobamax/jobseeker/profile/cv/adapter/ExperienceAdapter;Landroid/view/View;)V", "bindTo", "", "experience", "Lcom/findajob/jobamax/jobseeker/profile/cv/model/Experience;", "app_debug"})
    public final class ExperienceViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public ExperienceViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        public final void bindTo(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.jobseeker.profile.cv.model.Experience experience) {
        }
    }
}