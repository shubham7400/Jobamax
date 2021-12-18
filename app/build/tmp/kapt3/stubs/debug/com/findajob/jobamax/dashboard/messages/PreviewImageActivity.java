package com.findajob.jobamax.dashboard.messages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0013\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0012\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014R\u0014\u0010\u0004\u001a\u00020\u00058TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/PreviewImageActivity;", "Lcom/findajob/jobamax/base/BaseActivityMain;", "Lcom/findajob/jobamax/databinding/ActivityPreviewImageBinding;", "()V", "layoutRes", "", "getLayoutRes", "()I", "mediaDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "mediaItem", "Lcom/google/android/exoplayer2/MediaItem;", "simpleExoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "videoPlayer", "videoView", "Lcom/google/android/exoplayer2/ui/PlayerView;", "viewModel", "Lcom/findajob/jobamax/dashboard/messages/PreviewImageViewModel;", "getViewModel", "()Lcom/findajob/jobamax/dashboard/messages/PreviewImageViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkExtras", "", "Lcom/findajob/jobamax/base/BaseViewModel;", "initObserver", "initViews", "onCreated", "instance", "Landroid/os/Bundle;", "Companion", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class PreviewImageActivity extends com.findajob.jobamax.base.BaseActivityMain<com.findajob.jobamax.databinding.ActivityPreviewImageBinding> {
    private com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer;
    private com.google.android.exoplayer2.upstream.DataSource.Factory mediaDataSourceFactory;
    private com.google.android.exoplayer2.ui.PlayerView videoView;
    private com.google.android.exoplayer2.SimpleExoPlayer videoPlayer;
    private com.google.android.exoplayer2.MediaItem mediaItem;
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.dashboard.messages.PreviewImageActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_FILE_URL = "file_url";
    private java.util.HashMap _$_findViewCache;
    
    public PreviewImageActivity() {
        super();
    }
    
    private final com.findajob.jobamax.dashboard.messages.PreviewImageViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected com.findajob.jobamax.base.BaseViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle instance) {
    }
    
    private final void initViews() {
    }
    
    private final void initObserver() {
    }
    
    private final void checkExtras() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/PreviewImageActivity$Companion;", "", "()V", "EXTRA_FILE_URL", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}