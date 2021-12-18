package com.findajob.jobamax.jobseeker.track;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00052\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0014\u0010\u0018\u001a\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u001aR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\t0\t0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/findajob/jobamax/jobseeker/track/JobOfferCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/findajob/jobamax/jobseeker/track/JobOfferCardAdapter$JobOfferCardViewHolder;", "navInfo", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "diffCallBack", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/parse/ParseObject;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "getNavInfo", "()Lkotlin/jvm/functions/Function0;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitJobOffers", "jobOffers", "", "JobOfferCardViewHolder", "app_debug"})
public final class JobOfferCardAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.findajob.jobamax.jobseeker.track.JobOfferCardAdapter.JobOfferCardViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<kotlin.Unit> navInfo = null;
    private final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.parse.ParseObject> diffCallBack = null;
    private final androidx.recyclerview.widget.AsyncListDiffer<com.parse.ParseObject> differ = null;
    
    public JobOfferCardAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> navInfo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getNavInfo() {
        return null;
    }
    
    public final void submitJobOffers(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.parse.ParseObject> jobOffers) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.findajob.jobamax.jobseeker.track.JobOfferCardAdapter.JobOfferCardViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.track.JobOfferCardAdapter.JobOfferCardViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/findajob/jobamax/jobseeker/track/JobOfferCardAdapter$JobOfferCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/findajob/jobamax/databinding/ItemJobOfferCardBinding;", "(Lcom/findajob/jobamax/jobseeker/track/JobOfferCardAdapter;Lcom/findajob/jobamax/databinding/ItemJobOfferCardBinding;)V", "getBinding", "()Lcom/findajob/jobamax/databinding/ItemJobOfferCardBinding;", "bindTo", "", "parseObject", "Lcom/parse/ParseObject;", "app_debug"})
    public final class JobOfferCardViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.findajob.jobamax.databinding.ItemJobOfferCardBinding binding = null;
        
        public JobOfferCardViewHolder(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.databinding.ItemJobOfferCardBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.databinding.ItemJobOfferCardBinding getBinding() {
            return null;
        }
        
        public final void bindTo(@org.jetbrains.annotations.NotNull()
        com.parse.ParseObject parseObject) {
        }
    }
}