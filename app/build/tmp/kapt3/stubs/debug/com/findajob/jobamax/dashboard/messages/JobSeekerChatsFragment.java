package com.findajob.jobamax.dashboard.messages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0003J\b\u0010\u001e\u001a\u00020&H\u0014J\u0010\u0010\'\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020#H\u0002J\u0012\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020#H\u0016J\b\u0010.\u001a\u00020#H\u0016J\u0010\u0010/\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u00100\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u00101\u001a\u0002022\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u00103\u001a\u0002022\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f\u00a8\u00065"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/JobSeekerChatsFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentChatsBinding;", "()V", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "currentUserId", "", "getCurrentUserId", "()Ljava/lang/String;", "setCurrentUserId", "(Ljava/lang/String;)V", "layoutRes", "", "getLayoutRes", "()I", "messagesAdapter", "Lcom/findajob/jobamax/dashboard/messages/MessagesAdapter;", "getMessagesAdapter", "()Lcom/findajob/jobamax/dashboard/messages/MessagesAdapter;", "setMessagesAdapter", "(Lcom/findajob/jobamax/dashboard/messages/MessagesAdapter;)V", "newPeopleAdapter", "Lcom/findajob/jobamax/dashboard/messages/NewPeopleAdapter;", "getNewPeopleAdapter", "()Lcom/findajob/jobamax/dashboard/messages/NewPeopleAdapter;", "setNewPeopleAdapter", "(Lcom/findajob/jobamax/dashboard/messages/NewPeopleAdapter;)V", "viewModel", "Lcom/findajob/jobamax/dashboard/messages/MessagesViewModel;", "getViewModel", "()Lcom/findajob/jobamax/dashboard/messages/MessagesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "deleteConversation", "", "message", "Lcom/findajob/jobamax/data/pojo/Message;", "Lcom/findajob/jobamax/base/BaseViewModel;", "goToChatActivity", "initObserver", "initViews", "onCreated", "savedInstance", "Landroid/os/Bundle;", "onDestroy", "onStart", "removeFromShortlist", "shortListConversation", "showDeleteDialog", "", "showShortListDialog", "Companion", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class JobSeekerChatsFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentChatsBinding> {
    private final kotlin.Lazy viewModel$delegate = null;
    @javax.inject.Inject()
    public com.findajob.jobamax.dashboard.messages.MessagesAdapter messagesAdapter;
    public com.findajob.jobamax.dashboard.messages.NewPeopleAdapter newPeopleAdapter;
    public java.lang.String currentUserId;
    private final android.content.BroadcastReceiver broadcastReceiver = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.dashboard.messages.JobSeekerChatsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public JobSeekerChatsFragment() {
        super();
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
    public final com.findajob.jobamax.dashboard.messages.MessagesAdapter getMessagesAdapter() {
        return null;
    }
    
    public final void setMessagesAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.dashboard.messages.MessagesAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.dashboard.messages.NewPeopleAdapter getNewPeopleAdapter() {
        return null;
    }
    
    public final void setNewPeopleAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.dashboard.messages.NewPeopleAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentUserId() {
        return null;
    }
    
    public final void setCurrentUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final void initViews() {
    }
    
    private final void goToChatActivity(com.findajob.jobamax.data.pojo.Message message) {
    }
    
    private final boolean showDeleteDialog(com.findajob.jobamax.data.pojo.Message message) {
        return false;
    }
    
    private final boolean showShortListDialog(com.findajob.jobamax.data.pojo.Message message) {
        return false;
    }
    
    private final void shortListConversation(com.findajob.jobamax.data.pojo.Message message) {
    }
    
    private final void removeFromShortlist(com.findajob.jobamax.data.pojo.Message message) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    private final void deleteConversation(com.findajob.jobamax.data.pojo.Message message) {
    }
    
    private final void initObserver() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/JobSeekerChatsFragment$Companion;", "", "()V", "newInstance", "Lcom/findajob/jobamax/dashboard/messages/JobSeekerChatsFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.dashboard.messages.JobSeekerChatsFragment newInstance() {
            return null;
        }
    }
}