package com.findajob.jobamax.jobseeker.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010&\u001a\u00020\'H\u0002J\b\u0010\"\u001a\u00020(H\u0014J\u0010\u0010)\u001a\u00020\'2\u0006\u0010*\u001a\u00020+H\u0002J\u0006\u0010,\u001a\u00020\'J\b\u0010-\u001a\u00020\'H\u0002J\b\u0010.\u001a\u00020\'H\u0016J\u0012\u0010/\u001a\u00020\'2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\u0010\u00102\u001a\u00020\'2\u0006\u00103\u001a\u00020\tH\u0016J\b\u00104\u001a\u00020\'H\u0014J \u00105\u001a\u00020\'2\u0006\u00106\u001a\u0002072\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020+\u0018\u000109H\u0016J\b\u0010:\u001a\u00020\'H\u0014J\u0006\u0010;\u001a\u00020\'J\b\u0010<\u001a\u00020\'H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\t8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#\u00a8\u0006="}, d2 = {"Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeActivity;", "Lcom/findajob/jobamax/base/BaseActivityMain;", "Lcom/findajob/jobamax/databinding/ActivityJobSeekerHomeBinding;", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeInterface;", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "()V", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "currentPosition", "", "getCurrentPosition", "()I", "setCurrentPosition", "(I)V", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "layoutRes", "getLayoutRes", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "setNavController", "(Landroidx/navigation/NavController;)V", "trackToggleFlag", "", "getTrackToggleFlag", "()Z", "setTrackToggleFlag", "(Z)V", "viewModel", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureViewModel", "", "Landroidx/lifecycle/ViewModel;", "handlePurchase", "purchase", "Lcom/android/billingclient/api/Purchase;", "initBilling", "initViews", "onBackPressed", "onCreated", "instance", "Landroid/os/Bundle;", "onIconClicked", "position", "onPause", "onPurchasesUpdated", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "purchases", "", "onResume", "querySkuDetails", "setUpAppbar", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class JobSeekerHomeActivity extends com.findajob.jobamax.base.BaseActivityMain<com.findajob.jobamax.databinding.ActivityJobSeekerHomeBinding> implements com.findajob.jobamax.jobseeker.home.JobSeekerHomeInterface, com.android.billingclient.api.PurchasesUpdatedListener {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    public androidx.navigation.NavController navController;
    private com.android.billingclient.api.BillingClient billingClient;
    private boolean trackToggleFlag = true;
    private int currentPosition = -1;
    private final com.google.android.gms.location.LocationCallback locationCallback = null;
    private java.util.HashMap _$_findViewCache;
    
    public JobSeekerHomeActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.navigation.NavController getNavController() {
        return null;
    }
    
    public final void setNavController(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController p0) {
    }
    
    public final boolean getTrackToggleFlag() {
        return false;
    }
    
    public final void setTrackToggleFlag(boolean p0) {
    }
    
    public final int getCurrentPosition() {
        return 0;
    }
    
    public final void setCurrentPosition(int p0) {
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle instance) {
    }
    
    private final void initViews() {
    }
    
    private final void configureViewModel() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public void onIconClicked(int position) {
    }
    
    private final void setUpAppbar() {
    }
    
    public final void initBilling() {
    }
    
    public final void querySkuDetails() {
    }
    
    @java.lang.Override()
    public void onPurchasesUpdated(@org.jetbrains.annotations.NotNull()
    com.android.billingclient.api.BillingResult billingResult, @org.jetbrains.annotations.Nullable()
    java.util.List<com.android.billingclient.api.Purchase> purchases) {
    }
    
    private final void handlePurchase(com.android.billingclient.api.Purchase purchase) {
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModel getViewModel() {
        return null;
    }
}