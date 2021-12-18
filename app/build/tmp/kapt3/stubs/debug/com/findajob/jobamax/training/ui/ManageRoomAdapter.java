package com.findajob.jobamax.training.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0019B(\u0012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eJ\u001c\u0010\u0012\u001a\u00020\t2\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R,\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/findajob/jobamax/training/ui/ManageRoomAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/findajob/jobamax/training/ui/ManageRoomAdapter$ManageRoomViewHolder;", "onRoomClicked", "Lkotlin/Function1;", "Lcom/parse/ParseObject;", "Lkotlin/ParameterName;", "name", "room", "", "(Lkotlin/jvm/functions/Function1;)V", "getOnRoomClicked", "()Lkotlin/jvm/functions/Function1;", "rooms", "", "getItemCount", "", "notifyRoomChanged", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ManageRoomViewHolder", "app_debug"})
public final class ManageRoomAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.findajob.jobamax.training.ui.ManageRoomAdapter.ManageRoomViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.parse.ParseObject, kotlin.Unit> onRoomClicked = null;
    private java.util.List<? extends com.parse.ParseObject> rooms;
    
    public ManageRoomAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseObject, kotlin.Unit> onRoomClicked) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.parse.ParseObject, kotlin.Unit> getOnRoomClicked() {
        return null;
    }
    
    public final void notifyRoomChanged(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.parse.ParseObject> rooms) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.findajob.jobamax.training.ui.ManageRoomAdapter.ManageRoomViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.training.ui.ManageRoomAdapter.ManageRoomViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/findajob/jobamax/training/ui/ManageRoomAdapter$ManageRoomViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/findajob/jobamax/training/ui/ManageRoomAdapter;Landroid/view/View;)V", "bindTo", "", "room", "Lcom/findajob/jobamax/model/LiveRoom;", "app_debug"})
    public final class ManageRoomViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public ManageRoomViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        public final void bindTo(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.model.LiveRoom room) {
        }
    }
}