package com.findajob.jobamax.jobseeker.wishlist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0002J\b\u0010%\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010\'\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020(H\u0014J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u00101\u001a\u00020\"2\b\u00102\u001a\u0004\u0018\u000100H\u0014J\b\u0010\b\u001a\u00020\"H\u0002J\b\u00103\u001a\u00020\"H\u0002J\u0010\u00104\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0002J\b\u00105\u001a\u00020\"H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u00066"}, d2 = {"Lcom/findajob/jobamax/jobseeker/wishlist/SeekerWishListFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentSeekerWishListBinding;", "()V", "adapter", "Lcom/findajob/jobamax/jobseeker/wishlist/SeekerWishListAdapter;", "getAdapter", "()Lcom/findajob/jobamax/jobseeker/wishlist/SeekerWishListAdapter;", "setAdapter", "(Lcom/findajob/jobamax/jobseeker/wishlist/SeekerWishListAdapter;)V", "filteredJob", "", "getFilteredJob", "()Ljava/lang/String;", "setFilteredJob", "(Ljava/lang/String;)V", "layoutRes", "", "getLayoutRes", "()I", "viewModel", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "wishlistJobs", "Ljava/util/ArrayList;", "Lcom/findajob/jobamax/model/WishlistedJob;", "getWishlistJobs", "()Ljava/util/ArrayList;", "setWishlistJobs", "(Ljava/util/ArrayList;)V", "addToArchived", "", "wishlistJob", "addToTrackingJobList", "configureUi", "deleteWishlistJob", "fetchWishlist", "Landroidx/lifecycle/ViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreated", "savedInstance", "setClickListeners", "updateFavorite", "viewModelObserver", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class SeekerWishListFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentSeekerWishListBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.findajob.jobamax.jobseeker.wishlist.SeekerWishListAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.findajob.jobamax.model.WishlistedJob> wishlistJobs;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String filteredJob;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerWishListFragment() {
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
    public final com.findajob.jobamax.jobseeker.wishlist.SeekerWishListAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.wishlist.SeekerWishListAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.findajob.jobamax.model.WishlistedJob> getWishlistJobs() {
        return null;
    }
    
    public final void setWishlistJobs(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.model.WishlistedJob> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFilteredJob() {
        return null;
    }
    
    public final void setFilteredJob(@org.jetbrains.annotations.NotNull()
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
    
    private final void setAdapter() {
    }
    
    private final void addToArchived(com.findajob.jobamax.model.WishlistedJob wishlistJob) {
    }
    
    private final void addToTrackingJobList(com.findajob.jobamax.model.WishlistedJob wishlistJob) {
    }
    
    private final void deleteWishlistJob(com.findajob.jobamax.model.WishlistedJob wishlistJob) {
    }
    
    private final void updateFavorite(com.findajob.jobamax.model.WishlistedJob wishlistJob) {
    }
    
    private final void viewModelObserver() {
    }
    
    private final void setClickListeners() {
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    private final void fetchWishlist(java.lang.String filteredJob) {
    }
}