package com.jobamax.appjobamax.jobseeker.profile.portfolio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u0013\u001a\u00020\u001fH\u0014J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\"\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J$\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0012\u0010/\u001a\u00020\u00182\b\u00100\u001a\u0004\u0018\u00010.H\u0014J\b\u00101\u001a\u00020\u0018H\u0002J\b\u00102\u001a\u00020\u0018H\u0002J\b\u00103\u001a\u00020\u0018H\u0002J\u0010\u00104\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u00a8\u00065"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/profile/portfolio/PortfolioVideoFragment;", "Lcom/jobamax/appjobamax/base/BaseFragmentMain;", "Lcom/jobamax/appjobamax/databinding/FragmentPortfolioVideoBinding;", "()V", "REQUEST_VIDEO_CAPTURE", "", "layoutRes", "getLayoutRes", "()I", "portfolio", "Lcom/jobamax/appjobamax/data/pojo/Portfolio;", "getPortfolio", "()Lcom/jobamax/appjobamax/data/pojo/Portfolio;", "setPortfolio", "(Lcom/jobamax/appjobamax/data/pojo/Portfolio;)V", "videoUrl", "", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/home/JobSeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/home/JobSeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "deleteVideo", "dispatchTakeVideoIntent", "filetype", "videoUri", "Landroid/net/Uri;", "getPortfolioData", "Landroidx/lifecycle/ViewModel;", "isVideoDurationWithinOneMinute", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreated", "savedInstance", "saveDataToParse", "setClickListeners", "setVideoImage", "uploadVideo", "app_release"})
public final class PortfolioVideoFragment extends com.jobamax.appjobamax.base.BaseFragmentMain<com.jobamax.appjobamax.databinding.FragmentPortfolioVideoBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.data.pojo.Portfolio portfolio;
    private java.lang.String videoUrl = "";
    private final int REQUEST_VIDEO_CAPTURE = 1;
    private java.util.HashMap _$_findViewCache;
    
    public PortfolioVideoFragment() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.data.pojo.Portfolio getPortfolio() {
        return null;
    }
    
    public final void setPortfolio(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.data.pojo.Portfolio p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void getPortfolioData() {
    }
    
    private final void saveDataToParse() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final boolean isVideoDurationWithinOneMinute(android.net.Uri videoUri) {
        return false;
    }
    
    private final void uploadVideo(android.net.Uri videoUri) {
    }
    
    private final java.lang.String filetype(android.net.Uri videoUri) {
        return null;
    }
    
    private final void setVideoImage() {
    }
    
    private final void configureUi() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void deleteVideo() {
    }
    
    private final void dispatchTakeVideoIntent() {
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
}