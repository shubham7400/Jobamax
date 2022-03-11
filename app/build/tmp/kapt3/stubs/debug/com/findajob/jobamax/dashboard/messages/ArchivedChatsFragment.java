package com.findajob.jobamax.dashboard.messages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u0018\u001a\u00020\u001fH\u0014J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\u0012\u0010#\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020\u001cH\u0016J\u0010\u0010\'\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006,"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/ArchivedChatsFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentArchivedChatsBinding;", "()V", "archivedMessagesAdapter", "Lcom/findajob/jobamax/dashboard/messages/ArchivedMessageAdapter;", "getArchivedMessagesAdapter", "()Lcom/findajob/jobamax/dashboard/messages/ArchivedMessageAdapter;", "archivedMessagesAdapter$delegate", "Lkotlin/Lazy;", "currentUserId", "", "getCurrentUserId", "()Ljava/lang/String;", "setCurrentUserId", "(Ljava/lang/String;)V", "layoutRes", "", "getLayoutRes", "()I", "queryTextListener", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "viewModel", "Lcom/findajob/jobamax/dashboard/messages/MessagesViewModel;", "getViewModel", "()Lcom/findajob/jobamax/dashboard/messages/MessagesViewModel;", "viewModel$delegate", "deleteConversation", "", "message", "Lcom/findajob/jobamax/data/pojo/Message;", "Lcom/findajob/jobamax/base/BaseViewModel;", "goToChatActivity", "initObserver", "initViews", "onCreated", "savedInstance", "Landroid/os/Bundle;", "onStart", "showUnarchiveDialog", "", "unarchiveConversation", "Lkotlinx/coroutines/Job;", "Companion", "app_debug"})
public final class ArchivedChatsFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentArchivedChatsBinding> {
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy archivedMessagesAdapter$delegate = null;
    public java.lang.String currentUserId;
    private final androidx.appcompat.widget.SearchView.OnQueryTextListener queryTextListener = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.dashboard.messages.ArchivedChatsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public ArchivedChatsFragment() {
        super();
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    private final com.findajob.jobamax.dashboard.messages.MessagesViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected com.findajob.jobamax.base.BaseViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.dashboard.messages.ArchivedMessageAdapter getArchivedMessagesAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentUserId() {
        return null;
    }
    
    public final void setCurrentUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    private final void initViews() {
    }
    
    private final void goToChatActivity(com.findajob.jobamax.data.pojo.Message message) {
    }
    
    private final boolean showUnarchiveDialog(com.findajob.jobamax.data.pojo.Message message) {
        return false;
    }
    
    private final kotlinx.coroutines.Job unarchiveConversation(com.findajob.jobamax.data.pojo.Message message) {
        return null;
    }
    
    private final void deleteConversation(com.findajob.jobamax.data.pojo.Message message) {
    }
    
    private final void initObserver() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/ArchivedChatsFragment$Companion;", "", "()V", "newInstance", "Lcom/findajob/jobamax/dashboard/messages/ArchivedChatsFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.dashboard.messages.ArchivedChatsFragment newInstance() {
            return null;
        }
    }
}