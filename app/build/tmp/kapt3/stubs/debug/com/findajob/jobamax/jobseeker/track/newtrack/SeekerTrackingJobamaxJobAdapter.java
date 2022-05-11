package com.findajob.jobamax.jobseeker.track.newtrack;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J&\u0010 \u001a\u00020\u00192\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\"\u001a\u00020\u0011R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006$"}, d2 = {"Lcom/findajob/jobamax/jobseeker/track/newtrack/SeekerTrackingJobamaxJobAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/findajob/jobamax/jobseeker/track/newtrack/SeekerTrackingJobamaxJobAdapter$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/findajob/jobamax/model/TrackingJob;", "Lkotlin/collections/ArrayList;", "requireContext", "Landroid/content/Context;", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "getRequireContext", "()Landroid/content/Context;", "selectedFilter", "Lcom/findajob/jobamax/enums/SeekerTrackingJobFilter;", "getSelectedFilter", "()Lcom/findajob/jobamax/enums/SeekerTrackingJobFilter;", "setSelectedFilter", "(Lcom/findajob/jobamax/enums/SeekerTrackingJobFilter;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "trackingJobList", "appliedFilter", "ViewHolder", "app_debug"})
public final class SeekerTrackingJobamaxJobAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.findajob.jobamax.jobseeker.track.newtrack.SeekerTrackingJobamaxJobAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.findajob.jobamax.model.TrackingJob> list;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context requireContext = null;
    @org.jetbrains.annotations.NotNull()
    private com.findajob.jobamax.enums.SeekerTrackingJobFilter selectedFilter = com.findajob.jobamax.enums.SeekerTrackingJobFilter.ALL;
    
    public SeekerTrackingJobamaxJobAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.model.TrackingJob> list, @org.jetbrains.annotations.NotNull()
    android.content.Context requireContext) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.findajob.jobamax.model.TrackingJob> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.model.TrackingJob> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getRequireContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.enums.SeekerTrackingJobFilter getSelectedFilter() {
        return null;
    }
    
    public final void setSelectedFilter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.enums.SeekerTrackingJobFilter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.findajob.jobamax.jobseeker.track.newtrack.SeekerTrackingJobamaxJobAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.track.newtrack.SeekerTrackingJobamaxJobAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.model.TrackingJob> trackingJobList, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.enums.SeekerTrackingJobFilter appliedFilter) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/jobseeker/track/newtrack/SeekerTrackingJobamaxJobAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/findajob/jobamax/databinding/ItemSeekerTrackBinding;", "(Lcom/findajob/jobamax/databinding/ItemSeekerTrackBinding;)V", "getBinding", "()Lcom/findajob/jobamax/databinding/ItemSeekerTrackBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.findajob.jobamax.databinding.ItemSeekerTrackBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.databinding.ItemSeekerTrackBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.databinding.ItemSeekerTrackBinding getBinding() {
            return null;
        }
    }
}