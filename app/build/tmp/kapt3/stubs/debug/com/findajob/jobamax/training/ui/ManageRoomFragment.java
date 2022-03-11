package com.findajob.jobamax.training.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u001dH\u0016J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\u0006\u0010-\u001a\u00020\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006."}, d2 = {"Lcom/findajob/jobamax/training/ui/ManageRoomFragment;", "Lcom/findajob/jobamax/BaseFragment;", "Lcom/findajob/jobamax/training/ui/ManageRoomInterface;", "()V", "binding", "Lcom/findajob/jobamax/databinding/FragmentManageRoomBinding;", "getBinding", "()Lcom/findajob/jobamax/databinding/FragmentManageRoomBinding;", "setBinding", "(Lcom/findajob/jobamax/databinding/FragmentManageRoomBinding;)V", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "setNavController", "(Landroidx/navigation/NavController;)V", "roomAdapter", "Lcom/findajob/jobamax/training/ui/ManageRoomAdapter;", "getRoomAdapter", "()Lcom/findajob/jobamax/training/ui/ManageRoomAdapter;", "setRoomAdapter", "(Lcom/findajob/jobamax/training/ui/ManageRoomAdapter;)V", "viewModel", "Lcom/findajob/jobamax/training/ui/ManageRoomViewModel;", "getViewModel", "()Lcom/findajob/jobamax/training/ui/ManageRoomViewModel;", "setViewModel", "(Lcom/findajob/jobamax/training/ui/ManageRoomViewModel;)V", "forwardToLiveRoom", "", "room", "Lcom/parse/ParseObject;", "onBackButtonClicked", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "startRoom", "subscribeObserver", "app_debug"})
public final class ManageRoomFragment extends com.findajob.jobamax.BaseFragment implements com.findajob.jobamax.training.ui.ManageRoomInterface {
    public com.findajob.jobamax.training.ui.ManageRoomViewModel viewModel;
    public com.findajob.jobamax.databinding.FragmentManageRoomBinding binding;
    public com.findajob.jobamax.training.ui.ManageRoomAdapter roomAdapter;
    public androidx.navigation.NavController navController;
    private java.util.HashMap _$_findViewCache;
    
    public ManageRoomFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.training.ui.ManageRoomViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.training.ui.ManageRoomViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.databinding.FragmentManageRoomBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.databinding.FragmentManageRoomBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.training.ui.ManageRoomAdapter getRoomAdapter() {
        return null;
    }
    
    public final void setRoomAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.training.ui.ManageRoomAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.navigation.NavController getNavController() {
        return null;
    }
    
    public final void setNavController(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void subscribeObserver() {
    }
    
    @java.lang.Override()
    public void onBackButtonClicked() {
    }
    
    @java.lang.Override()
    public void startRoom() {
    }
    
    public final void forwardToLiveRoom(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject room) {
    }
}