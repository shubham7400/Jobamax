package com.findajob.jobamax.dashboard.messages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003$%&B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0018H\u0016J\u0014\u0010!\u001a\u00020\u00072\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060#R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00060\u00060\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\'"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/ChatAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "clickListener", "Lkotlin/Function1;", "Lcom/findajob/jobamax/data/pojo/Chat;", "", "getClickListener$app_debug", "()Lkotlin/jvm/functions/Function1;", "setClickListener$app_debug", "(Lkotlin/jvm/functions/Function1;)V", "diffCallBack", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "profileImageUrl", "", "getProfileImageUrl", "()Ljava/lang/String;", "setProfileImageUrl", "(Ljava/lang/String;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "chats", "", "Companion", "ReceiverViewHolder", "SenderViewHolder", "app_debug"})
public final class ChatAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.dashboard.messages.ChatAdapter.Companion Companion = null;
    public static final int TYPE_SENDER = 1;
    public static final int TYPE_RECEIVER = 2;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.findajob.jobamax.data.pojo.Chat, kotlin.Unit> clickListener;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String profileImageUrl = "";
    private final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.findajob.jobamax.data.pojo.Chat> diffCallBack = null;
    private final androidx.recyclerview.widget.AsyncListDiffer<com.findajob.jobamax.data.pojo.Chat> differ = null;
    
    @javax.inject.Inject()
    public ChatAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.findajob.jobamax.data.pojo.Chat, kotlin.Unit> getClickListener$app_debug() {
        return null;
    }
    
    public final void setClickListener$app_debug(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.findajob.jobamax.data.pojo.Chat, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProfileImageUrl() {
        return null;
    }
    
    public final void setProfileImageUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.findajob.jobamax.data.pojo.Chat> chats) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/ChatAdapter$SenderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/findajob/jobamax/databinding/ItemChatSenderBinding;", "(Lcom/findajob/jobamax/databinding/ItemChatSenderBinding;)V", "getBinding", "()Lcom/findajob/jobamax/databinding/ItemChatSenderBinding;", "Companion", "app_debug"})
    public static final class SenderViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.findajob.jobamax.databinding.ItemChatSenderBinding binding = null;
        @org.jetbrains.annotations.NotNull()
        public static final com.findajob.jobamax.dashboard.messages.ChatAdapter.SenderViewHolder.Companion Companion = null;
        
        public SenderViewHolder(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.databinding.ItemChatSenderBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.databinding.ItemChatSenderBinding getBinding() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/ChatAdapter$SenderViewHolder$Companion;", "", "()V", "from", "Lcom/findajob/jobamax/dashboard/messages/ChatAdapter$SenderViewHolder;", "parent", "Landroid/view/ViewGroup;", "layout", "", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.findajob.jobamax.dashboard.messages.ChatAdapter.SenderViewHolder from(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent, int layout) {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/ChatAdapter$ReceiverViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/findajob/jobamax/databinding/ItemChatReceiverBinding;", "(Lcom/findajob/jobamax/databinding/ItemChatReceiverBinding;)V", "getBinding", "()Lcom/findajob/jobamax/databinding/ItemChatReceiverBinding;", "Companion", "app_debug"})
    public static final class ReceiverViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.findajob.jobamax.databinding.ItemChatReceiverBinding binding = null;
        @org.jetbrains.annotations.NotNull()
        public static final com.findajob.jobamax.dashboard.messages.ChatAdapter.ReceiverViewHolder.Companion Companion = null;
        
        public ReceiverViewHolder(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.databinding.ItemChatReceiverBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.databinding.ItemChatReceiverBinding getBinding() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/ChatAdapter$ReceiverViewHolder$Companion;", "", "()V", "from", "Lcom/findajob/jobamax/dashboard/messages/ChatAdapter$ReceiverViewHolder;", "parent", "Landroid/view/ViewGroup;", "layout", "", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.findajob.jobamax.dashboard.messages.ChatAdapter.ReceiverViewHolder from(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent, int layout) {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/ChatAdapter$Companion;", "", "()V", "TYPE_RECEIVER", "", "TYPE_SENDER", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}