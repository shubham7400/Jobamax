package com.findajob.jobamax.dialog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001!B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u00a2\u0006\u0002\u0010\rJ\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\fH\u0002J\u0012\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00060\u0015R\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/findajob/jobamax/dialog/MessagePopUpDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "friend", "Lcom/findajob/jobamax/training/model/Member;", "handleFriendRequest", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "accepted", "", "(Landroid/app/Activity;Lcom/findajob/jobamax/training/model/Member;Lkotlin/jvm/functions/Function1;)V", "btnMessage", "Landroid/widget/Button;", "getHandleFriendRequest", "()Lkotlin/jvm/functions/Function1;", "ivProfilePic", "Landroid/widget/ImageView;", "mutualFriendImageArrayAdapter", "Lcom/findajob/jobamax/dialog/MessagePopUpDialog$MutualFriendAdapter;", "rvSocialMedias", "Landroidx/recyclerview/widget/RecyclerView;", "tvName", "Landroid/widget/TextView;", "tvSkipButton", "initViews", "loadUi", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setUpObserver", "MutualFriendAdapter", "app_debug"})
public final class MessagePopUpDialog extends android.app.Dialog {
    private final android.app.Activity activity = null;
    private final com.findajob.jobamax.training.model.Member friend = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> handleFriendRequest = null;
    private android.widget.TextView tvSkipButton;
    private android.widget.ImageView ivProfilePic;
    private android.widget.TextView tvName;
    private android.widget.Button btnMessage;
    private androidx.recyclerview.widget.RecyclerView rvSocialMedias;
    private com.findajob.jobamax.dialog.MessagePopUpDialog.MutualFriendAdapter mutualFriendImageArrayAdapter;
    
    public MessagePopUpDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.training.model.Member friend, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> handleFriendRequest) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> getHandleFriendRequest() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadUi() {
    }
    
    private final void setUpObserver() {
    }
    
    private final void initViews() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0016B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH\u0016J \u0010\u0012\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/findajob/jobamax/dialog/MessagePopUpDialog$MutualFriendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/findajob/jobamax/dialog/MessagePopUpDialog$MutualFriendAdapter$Holder;", "Lcom/findajob/jobamax/dialog/MessagePopUpDialog;", "mutualFriendProfilePics", "", "", "(Lcom/findajob/jobamax/dialog/MessagePopUpDialog;Ljava/util/List;)V", "getMutualFriendProfilePics", "()Ljava/util/List;", "setMutualFriendProfilePics", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "app_debug"})
    public final class MutualFriendAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.findajob.jobamax.dialog.MessagePopUpDialog.MutualFriendAdapter.Holder> {
        @org.jetbrains.annotations.NotNull()
        private java.util.List<java.lang.String> mutualFriendProfilePics;
        
        public MutualFriendAdapter(@org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> mutualFriendProfilePics) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getMutualFriendProfilePics() {
            return null;
        }
        
        public final void setMutualFriendProfilePics(@org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.findajob.jobamax.dialog.MessagePopUpDialog.MutualFriendAdapter.Holder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.dialog.MessagePopUpDialog.MutualFriendAdapter.Holder holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/findajob/jobamax/dialog/MessagePopUpDialog$MutualFriendAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/findajob/jobamax/dialog/MessagePopUpDialog$MutualFriendAdapter;Landroid/view/View;)V", "app_debug"})
        public final class Holder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            
            public Holder(@org.jetbrains.annotations.NotNull()
            android.view.View view) {
                super(null);
            }
        }
    }
}