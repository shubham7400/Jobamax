package com.findajob.jobamax.jobseeker.track;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\"B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u001c\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0014\u0010\u001d\u001a\u00020\u00162\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001fJ\u0014\u0010 \u001a\u00020\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001fR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\b0\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u000f0\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/findajob/jobamax/jobseeker/track/JobSeekerTrackAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/findajob/jobamax/jobseeker/track/JobSeekerTrackAdapter$JobSeekerTrackViewHolder;", "node", "", "(Ljava/lang/String;)V", "jobOfferDiffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/parse/ParseObject;", "jobOfferDiffer", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "getNode", "()Ljava/lang/String;", "reasonDiffer", "Lcom/findajob/jobamax/model/RejectReason;", "reasonsDifferCallback", "getItemCount", "", "getRejectReason", "jobOfferId", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitJobOffers", "jobOffers", "", "submitReasons", "reasons", "JobSeekerTrackViewHolder", "app_debug"})
public final class JobSeekerTrackAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.findajob.jobamax.jobseeker.track.JobSeekerTrackAdapter.JobSeekerTrackViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String node = null;
    private final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.parse.ParseObject> jobOfferDiffCallback = null;
    private final androidx.recyclerview.widget.AsyncListDiffer<com.parse.ParseObject> jobOfferDiffer = null;
    private final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.findajob.jobamax.model.RejectReason> reasonsDifferCallback = null;
    private final androidx.recyclerview.widget.AsyncListDiffer<com.findajob.jobamax.model.RejectReason> reasonDiffer = null;
    
    public JobSeekerTrackAdapter(@org.jetbrains.annotations.NotNull()
    java.lang.String node) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNode() {
        return null;
    }
    
    public final void submitJobOffers(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.parse.ParseObject> jobOffers) {
    }
    
    public final void submitReasons(@org.jetbrains.annotations.NotNull()
    java.util.List<com.findajob.jobamax.model.RejectReason> reasons) {
    }
    
    private final java.lang.String getRejectReason(java.lang.String jobOfferId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.findajob.jobamax.jobseeker.track.JobSeekerTrackAdapter.JobSeekerTrackViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.track.JobSeekerTrackAdapter.JobSeekerTrackViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/findajob/jobamax/jobseeker/track/JobSeekerTrackAdapter$JobSeekerTrackViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/findajob/jobamax/databinding/ItemJobSeekerTrackOfferBinding;", "(Lcom/findajob/jobamax/jobseeker/track/JobSeekerTrackAdapter;Lcom/findajob/jobamax/databinding/ItemJobSeekerTrackOfferBinding;)V", "getBinding", "()Lcom/findajob/jobamax/databinding/ItemJobSeekerTrackOfferBinding;", "bindTo", "", "jobOffer", "Lcom/findajob/jobamax/model/JobOffer;", "app_debug"})
    public final class JobSeekerTrackViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.findajob.jobamax.databinding.ItemJobSeekerTrackOfferBinding binding = null;
        
        public JobSeekerTrackViewHolder(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.databinding.ItemJobSeekerTrackOfferBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.databinding.ItemJobSeekerTrackOfferBinding getBinding() {
            return null;
        }
        
        public final void bindTo(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.model.JobOffer jobOffer) {
        }
    }
}