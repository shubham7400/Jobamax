package com.findajob.jobamax.location;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0015R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/findajob/jobamax/location/LocationViewModel;", "Lcom/findajob/jobamax/base/BaseViewModel;", "repo", "Lcom/findajob/jobamax/repo/LocationRepo;", "(Lcom/findajob/jobamax/repo/LocationRepo;)V", "_locationListener", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/findajob/jobamax/data/pojo/Location;", "_selectedLocationListener", "locationListener", "Landroidx/lifecycle/LiveData;", "getLocationListener", "()Landroidx/lifecycle/LiveData;", "getRepo", "()Lcom/findajob/jobamax/repo/LocationRepo;", "selectedLocationListener", "getSelectedLocationListener", "queryCity", "", "text", "", "queryLocationDetails", "placeId", "app_debug"})
public final class LocationViewModel extends com.findajob.jobamax.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.repo.LocationRepo repo = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.findajob.jobamax.data.pojo.Location>> _locationListener = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.findajob.jobamax.data.pojo.Location>> locationListener = null;
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.data.pojo.Location> _selectedLocationListener = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.findajob.jobamax.data.pojo.Location> selectedLocationListener = null;
    
    @javax.inject.Inject()
    public LocationViewModel(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.LocationRepo repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.repo.LocationRepo getRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.findajob.jobamax.data.pojo.Location>> getLocationListener() {
        return null;
    }
    
    public final void queryCity(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.findajob.jobamax.data.pojo.Location> getSelectedLocationListener() {
        return null;
    }
    
    public final void queryLocationDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String placeId) {
    }
}