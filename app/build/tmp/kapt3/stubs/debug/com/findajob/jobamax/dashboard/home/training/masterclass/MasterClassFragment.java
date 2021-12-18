package com.findajob.jobamax.dashboard.home.training.masterclass;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u0012\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\f8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/findajob/jobamax/dashboard/home/training/masterclass/MasterClassFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentMasterClassBinding;", "Lcom/findajob/jobamax/dashboard/home/training/masterclass/MasterClassInterface;", "()V", "categoryAdapter", "Lcom/findajob/jobamax/dashboard/home/training/masterclass/adapter/CategoryAdapter;", "getCategoryAdapter", "()Lcom/findajob/jobamax/dashboard/home/training/masterclass/adapter/CategoryAdapter;", "categoryAdapter$delegate", "Lkotlin/Lazy;", "layoutRes", "", "getLayoutRes", "()I", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "setNavController", "(Landroidx/navigation/NavController;)V", "fetchCategories", "", "getViewModel", "Landroidx/lifecycle/ViewModel;", "initCategories", "initViews", "onBackPress", "onCreated", "savedInstance", "Landroid/os/Bundle;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MasterClassFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentMasterClassBinding> implements com.findajob.jobamax.dashboard.home.training.masterclass.MasterClassInterface {
    private final kotlin.Lazy categoryAdapter$delegate = null;
    public androidx.navigation.NavController navController;
    private java.util.HashMap _$_findViewCache;
    
    public MasterClassFragment() {
        super();
    }
    
    private final com.findajob.jobamax.dashboard.home.training.masterclass.adapter.CategoryAdapter getCategoryAdapter() {
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
    
    private final void initCategories() {
    }
    
    @java.lang.Override()
    public void onBackPress() {
    }
}