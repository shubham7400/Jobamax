package com.findajob.jobamax.dashboard.home.training.masterclass;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cR!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\'\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016R\'\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0019\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/findajob/jobamax/dashboard/home/training/masterclass/MasterClassViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "context", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_videoDetailsLD", "Landroidx/lifecycle/MutableLiveData;", "Lcom/findajob/jobamax/data/pojo/VideoDetails;", "get_videoDetailsLD", "()Landroidx/lifecycle/MutableLiveData;", "_videoDetailsLD$delegate", "Lkotlin/Lazy;", "_videoListLD", "", "Lcom/findajob/jobamax/dashboard/home/training/masterclass/model/MasterClassVideo;", "get_videoListLD", "_videoListLD$delegate", "getContext", "()Landroid/app/Application;", "videoDetailsLD", "Landroidx/lifecycle/LiveData;", "getVideoDetailsLD", "()Landroidx/lifecycle/LiveData;", "videoDetailsLD$delegate", "videoListLD", "getVideoListLD", "videoListLD$delegate", "fetchVideoDetails", "", "fetchVideoList", "app_debug"})
public final class MasterClassViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    private final kotlin.Lazy _videoDetailsLD$delegate = null;
    private final kotlin.Lazy _videoListLD$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy videoDetailsLD$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy videoListLD$delegate = null;
    
    public MasterClassViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.data.pojo.VideoDetails> get_videoDetailsLD() {
        return null;
    }
    
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.findajob.jobamax.dashboard.home.training.masterclass.model.MasterClassVideo>> get_videoListLD() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.findajob.jobamax.data.pojo.VideoDetails> getVideoDetailsLD() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.findajob.jobamax.dashboard.home.training.masterclass.model.MasterClassVideo>> getVideoListLD() {
        return null;
    }
    
    public final void fetchVideoDetails() {
    }
    
    public final void fetchVideoList() {
    }
}