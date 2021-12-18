package com.findajob.jobamax.location;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u0012\u0010%\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014J\b\u0010(\u001a\u00020#H\u0014J\b\u0010)\u001a\u00020#H\u0014J\b\u0010*\u001a\u00020#H\u0014J\b\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020#H\u0002J\b\u0010-\u001a\u00020#H\u0002J\b\u0010.\u001a\u00020#H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001f\u0010 \u00a8\u0006/"}, d2 = {"Lcom/findajob/jobamax/location/SelectLocationActivity;", "Lcom/findajob/jobamax/BaseActivity;", "()V", "binding", "Lcom/findajob/jobamax/databinding/ActivitySelectLocationBinding;", "getBinding", "()Lcom/findajob/jobamax/databinding/ActivitySelectLocationBinding;", "setBinding", "(Lcom/findajob/jobamax/databinding/ActivitySelectLocationBinding;)V", "currentLocation", "Lcom/findajob/jobamax/data/pojo/Location;", "getCurrentLocation", "()Lcom/findajob/jobamax/data/pojo/Location;", "setCurrentLocation", "(Lcom/findajob/jobamax/data/pojo/Location;)V", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "locationAdapter", "Lcom/findajob/jobamax/recruiter/profile/jobOffer/location/LocationAdapter;", "getLocationAdapter", "()Lcom/findajob/jobamax/recruiter/profile/jobOffer/location/LocationAdapter;", "setLocationAdapter", "(Lcom/findajob/jobamax/recruiter/profile/jobOffer/location/LocationAdapter;)V", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "getLocationCallback", "()Lcom/google/android/gms/location/LocationCallback;", "locationCallback$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/findajob/jobamax/location/LocationViewModel;", "getViewModel", "()Lcom/findajob/jobamax/location/LocationViewModel;", "viewModel$delegate", "hideLoading", "", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "pauseLocationClient", "resumeLocationRequest", "showLoading", "subscribeObserver", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class SelectLocationActivity extends com.findajob.jobamax.BaseActivity {
    @org.jetbrains.annotations.Nullable()
    private com.findajob.jobamax.databinding.ActivitySelectLocationBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.findajob.jobamax.recruiter.profile.jobOffer.location.LocationAdapter locationAdapter;
    @org.jetbrains.annotations.NotNull()
    private com.findajob.jobamax.data.pojo.Location currentLocation;
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    private final kotlin.Lazy locationCallback$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public SelectLocationActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.findajob.jobamax.databinding.ActivitySelectLocationBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.Nullable()
    com.findajob.jobamax.databinding.ActivitySelectLocationBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.location.LocationViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.recruiter.profile.jobOffer.location.LocationAdapter getLocationAdapter() {
        return null;
    }
    
    public final void setLocationAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.recruiter.profile.jobOffer.location.LocationAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.data.pojo.Location getCurrentLocation() {
        return null;
    }
    
    public final void setCurrentLocation(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.data.pojo.Location p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void subscribeObserver() {
    }
    
    private final void showLoading() {
    }
    
    private final void hideLoading() {
    }
    
    private final com.google.android.gms.location.LocationCallback getLocationCallback() {
        return null;
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void resumeLocationRequest() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    private final void pauseLocationClient() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
}