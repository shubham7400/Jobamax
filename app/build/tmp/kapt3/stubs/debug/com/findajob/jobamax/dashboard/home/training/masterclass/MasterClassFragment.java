package com.findajob.jobamax.dashboard.home.training.masterclass;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010)\u001a\u00020*H\u0002J\n\u0010&\u001a\u0004\u0018\u00010+H\u0014J\b\u0010,\u001a\u00020*H\u0002J\b\u0010-\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020*H\u0002J\b\u0010/\u001a\u00020*H\u0016J\u0012\u00100\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u000102H\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\f8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020%8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010\'\u00a8\u00063"}, d2 = {"Lcom/findajob/jobamax/dashboard/home/training/masterclass/MasterClassFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentMasterClassBinding;", "Lcom/findajob/jobamax/dashboard/home/training/masterclass/MasterClassInterface;", "()V", "comingSoonListAdapter", "Lcom/findajob/jobamax/dashboard/home/training/masterclass/adapter/ComingSoonListAdapter;", "getComingSoonListAdapter", "()Lcom/findajob/jobamax/dashboard/home/training/masterclass/adapter/ComingSoonListAdapter;", "comingSoonListAdapter$delegate", "Lkotlin/Lazy;", "layoutRes", "", "getLayoutRes", "()I", "myListAdapter", "Lcom/findajob/jobamax/dashboard/home/training/masterclass/adapter/MyListAdapter;", "getMyListAdapter", "()Lcom/findajob/jobamax/dashboard/home/training/masterclass/adapter/MyListAdapter;", "myListAdapter$delegate", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "setNavController", "(Landroidx/navigation/NavController;)V", "newListAdapter", "Lcom/findajob/jobamax/dashboard/home/training/masterclass/adapter/NewListAdapter;", "getNewListAdapter", "()Lcom/findajob/jobamax/dashboard/home/training/masterclass/adapter/NewListAdapter;", "newListAdapter$delegate", "trendingListAdapter", "Lcom/findajob/jobamax/dashboard/home/training/masterclass/adapter/TrendingListAdapter;", "getTrendingListAdapter", "()Lcom/findajob/jobamax/dashboard/home/training/masterclass/adapter/TrendingListAdapter;", "trendingListAdapter$delegate", "viewModel", "Lcom/findajob/jobamax/dashboard/home/training/masterclass/MasterClassViewModel;", "getViewModel", "()Lcom/findajob/jobamax/dashboard/home/training/masterclass/MasterClassViewModel;", "viewModel$delegate", "fetchCategories", "", "Landroidx/lifecycle/ViewModel;", "initCategories", "initObservers", "initViews", "onBackPress", "onCreated", "savedInstance", "Landroid/os/Bundle;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MasterClassFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentMasterClassBinding> implements com.findajob.jobamax.dashboard.home.training.masterclass.MasterClassInterface {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy trendingListAdapter$delegate = null;
    private final kotlin.Lazy comingSoonListAdapter$delegate = null;
    private final kotlin.Lazy myListAdapter$delegate = null;
    private final kotlin.Lazy newListAdapter$delegate = null;
    public androidx.navigation.NavController navController;
    private java.util.HashMap _$_findViewCache;
    
    public MasterClassFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.dashboard.home.training.masterclass.MasterClassViewModel getViewModel() {
        return null;
    }
    
    private final com.findajob.jobamax.dashboard.home.training.masterclass.adapter.TrendingListAdapter getTrendingListAdapter() {
        return null;
    }
    
    private final com.findajob.jobamax.dashboard.home.training.masterclass.adapter.ComingSoonListAdapter getComingSoonListAdapter() {
        return null;
    }
    
    private final com.findajob.jobamax.dashboard.home.training.masterclass.adapter.MyListAdapter getMyListAdapter() {
        return null;
    }
    
    private final com.findajob.jobamax.dashboard.home.training.masterclass.adapter.NewListAdapter getNewListAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.navigation.NavController getNavController() {
        return null;
    }
    
    public final void setNavController(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController p0) {
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModel getViewModel() {
        return null;
    }
    
    private final void fetchCategories() {
    }
    
    private final void initViews() {
    }
    
    private final void initObservers() {
    }
    
    private final void initCategories() {
    }
    
    @java.lang.Override()
    public void onBackPress() {
    }
}