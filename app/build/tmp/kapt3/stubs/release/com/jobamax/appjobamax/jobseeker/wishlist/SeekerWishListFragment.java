package com.jobamax.appjobamax.jobseeker.wishlist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0002J\b\u0010%\u001a\u00020\"H\u0002J\u001a\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001c2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0002J\b\u0010)\u001a\u00020\"H\u0002J\b\u0010*\u001a\u00020\"H\u0002J\b\u0010\u0016\u001a\u00020+H\u0014J$\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0012\u00103\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u000102H\u0014J\b\u0010\b\u001a\u00020\"H\u0002J\b\u00105\u001a\u00020\"H\u0002J\u0010\u00106\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0002J\b\u00107\u001a\u00020\"H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u00068"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/wishlist/SeekerWishListFragment;", "Lcom/jobamax/appjobamax/base/BaseFragmentMain;", "Lcom/jobamax/appjobamax/databinding/FragmentSeekerWishListBinding;", "()V", "adapter", "Lcom/jobamax/appjobamax/jobseeker/wishlist/SeekerWishListAdapter;", "getAdapter", "()Lcom/jobamax/appjobamax/jobseeker/wishlist/SeekerWishListAdapter;", "setAdapter", "(Lcom/jobamax/appjobamax/jobseeker/wishlist/SeekerWishListAdapter;)V", "layoutRes", "", "getLayoutRes", "()I", "selectedFilter", "Lcom/jobamax/appjobamax/enums/SeekerWishlistJobFilter;", "getSelectedFilter", "()Lcom/jobamax/appjobamax/enums/SeekerWishlistJobFilter;", "setSelectedFilter", "(Lcom/jobamax/appjobamax/enums/SeekerWishlistJobFilter;)V", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/home/JobSeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/home/JobSeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "wishlistJobs", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/WishlistedJob;", "getWishlistJobs", "()Ljava/util/ArrayList;", "setWishlistJobs", "(Ljava/util/ArrayList;)V", "addToArchived", "", "wishlistJob", "addToTrackingJobList", "configureUi", "displayPopupWindow", "view", "Landroid/view/View;", "fetchWishlist", "getCurrent", "Landroidx/lifecycle/ViewModel;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreated", "savedInstance", "setClickListeners", "updateFavorite", "viewModelObserver", "app_release"})
@dagger.hilt.android.AndroidEntryPoint()
public final class SeekerWishListFragment extends com.jobamax.appjobamax.base.BaseFragmentMain<com.jobamax.appjobamax.databinding.FragmentSeekerWishListBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.jobseeker.wishlist.SeekerWishListAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.WishlistedJob> wishlistJobs;
    @org.jetbrains.annotations.NotNull()
    private com.jobamax.appjobamax.enums.SeekerWishlistJobFilter selectedFilter = com.jobamax.appjobamax.enums.SeekerWishlistJobFilter.ALL;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerWishListFragment() {
        super();
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.wishlist.SeekerWishListAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.wishlist.SeekerWishListAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.WishlistedJob> getWishlistJobs() {
        return null;
    }
    
    public final void setWishlistJobs(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.WishlistedJob> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.enums.SeekerWishlistJobFilter getSelectedFilter() {
        return null;
    }
    
    public final void setSelectedFilter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.enums.SeekerWishlistJobFilter p0) {
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
    
    private final void displayPopupWindow(com.jobamax.appjobamax.model.WishlistedJob wishlistJob, android.view.View view) {
    }
    
    private final void addToArchived(com.jobamax.appjobamax.model.WishlistedJob wishlistJob) {
    }
    
    private final void addToTrackingJobList(com.jobamax.appjobamax.model.WishlistedJob wishlistJob) {
    }
    
    private final void updateFavorite(com.jobamax.appjobamax.model.WishlistedJob wishlistJob) {
    }
    
    private final void viewModelObserver() {
    }
    
    private final void setClickListeners() {
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    private final void getCurrent() {
    }
    
    private final void fetchWishlist() {
    }
}