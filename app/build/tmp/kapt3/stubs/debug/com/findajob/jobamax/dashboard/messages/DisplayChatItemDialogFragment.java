package com.findajob.jobamax.dashboard.messages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0003J\b\u0010\u0016\u001a\u00020\u0014H\u0002J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\u0014H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/DisplayChatItemDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lcom/findajob/jobamax/databinding/FragmentDisplayChatItemDialogBinding;", "getBinding", "()Lcom/findajob/jobamax/databinding/FragmentDisplayChatItemDialogBinding;", "setBinding", "(Lcom/findajob/jobamax/databinding/FragmentDisplayChatItemDialogBinding;)V", "currentWindow", "", "playWhenReady", "", "playbackPosition", "", "playbackStateListener", "Lcom/google/android/exoplayer2/Player$EventListener;", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "configureUi", "", "hideSystemUi", "initializePlayer", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onStart", "onStop", "releasePlayer", "Companion", "app_debug"})
public final class DisplayChatItemDialogFragment extends androidx.fragment.app.DialogFragment {
    public com.findajob.jobamax.databinding.FragmentDisplayChatItemDialogBinding binding;
    private final com.google.android.exoplayer2.Player.EventListener playbackStateListener = null;
    private com.google.android.exoplayer2.SimpleExoPlayer player;
    private boolean playWhenReady = true;
    private int currentWindow = 0;
    private long playbackPosition = 0L;
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.dashboard.messages.DisplayChatItemDialogFragment.Companion Companion = null;
    private static int viewType = -1;
    @org.jetbrains.annotations.Nullable()
    private static com.findajob.jobamax.dashboard.messages.Mes message;
    private java.util.HashMap _$_findViewCache;
    
    public DisplayChatItemDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.databinding.FragmentDisplayChatItemDialogBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.databinding.FragmentDisplayChatItemDialogBinding p0) {
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
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    private final void initializePlayer() {
    }
    
    private final void releasePlayer() {
    }
    
    @android.annotation.SuppressLint(value = {"InlinedApi"})
    private final void hideSystemUi() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/DisplayChatItemDialogFragment$Companion;", "", "()V", "message", "Lcom/findajob/jobamax/dashboard/messages/Mes;", "getMessage", "()Lcom/findajob/jobamax/dashboard/messages/Mes;", "setMessage", "(Lcom/findajob/jobamax/dashboard/messages/Mes;)V", "viewType", "", "getViewType", "()I", "setViewType", "(I)V", "newInstance", "Lcom/findajob/jobamax/dashboard/messages/DisplayChatItemDialogFragment;", "type", "mes", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final int getViewType() {
            return 0;
        }
        
        public final void setViewType(int p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.findajob.jobamax.dashboard.messages.Mes getMessage() {
            return null;
        }
        
        public final void setMessage(@org.jetbrains.annotations.Nullable()
        com.findajob.jobamax.dashboard.messages.Mes p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.dashboard.messages.DisplayChatItemDialogFragment newInstance(int type, @org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.dashboard.messages.Mes mes) {
            return null;
        }
    }
}