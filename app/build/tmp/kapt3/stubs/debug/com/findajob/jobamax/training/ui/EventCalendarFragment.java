package com.findajob.jobamax.training.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0016J\u0012\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u001a\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u00100\u001a\u00020\"H\u0002J\b\u00101\u001a\u00020\"H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u00062"}, d2 = {"Lcom/findajob/jobamax/training/ui/EventCalendarFragment;", "Lcom/findajob/jobamax/BaseFragment;", "Lcom/findajob/jobamax/training/ui/EventCalendarHandler;", "()V", "binding", "Lcom/findajob/jobamax/databinding/FragmentEventCalendarBinding;", "getBinding", "()Lcom/findajob/jobamax/databinding/FragmentEventCalendarBinding;", "setBinding", "(Lcom/findajob/jobamax/databinding/FragmentEventCalendarBinding;)V", "currentlySelectedDate", "Ljava/util/Date;", "getCurrentlySelectedDate", "()Ljava/util/Date;", "setCurrentlySelectedDate", "(Ljava/util/Date;)V", "todayEventAdapter", "Lcom/findajob/jobamax/training/ui/EventAdapter;", "getTodayEventAdapter", "()Lcom/findajob/jobamax/training/ui/EventAdapter;", "setTodayEventAdapter", "(Lcom/findajob/jobamax/training/ui/EventAdapter;)V", "upcomingEventAdapter", "getUpcomingEventAdapter", "setUpcomingEventAdapter", "viewModel", "Lcom/findajob/jobamax/training/ui/ManageRoomViewModel;", "getViewModel", "()Lcom/findajob/jobamax/training/ui/ManageRoomViewModel;", "setViewModel", "(Lcom/findajob/jobamax/training/ui/ManageRoomViewModel;)V", "getOrganiser", "Lcom/parse/ParseObject;", "initObservers", "", "initViews", "onBackPress", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "refreshList", "saveEvent", "app_debug"})
public final class EventCalendarFragment extends com.findajob.jobamax.BaseFragment implements com.findajob.jobamax.training.ui.EventCalendarHandler {
    public com.findajob.jobamax.databinding.FragmentEventCalendarBinding binding;
    public com.findajob.jobamax.training.ui.ManageRoomViewModel viewModel;
    public com.findajob.jobamax.training.ui.EventAdapter todayEventAdapter;
    public com.findajob.jobamax.training.ui.EventAdapter upcomingEventAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.Date currentlySelectedDate;
    private java.util.HashMap _$_findViewCache;
    
    public EventCalendarFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.databinding.FragmentEventCalendarBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.databinding.FragmentEventCalendarBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.training.ui.ManageRoomViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.training.ui.ManageRoomViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.training.ui.EventAdapter getTodayEventAdapter() {
        return null;
    }
    
    public final void setTodayEventAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.training.ui.EventAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.training.ui.EventAdapter getUpcomingEventAdapter() {
        return null;
    }
    
    public final void setUpcomingEventAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.training.ui.EventAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getCurrentlySelectedDate() {
        return null;
    }
    
    public final void setCurrentlySelectedDate(@org.jetbrains.annotations.NotNull()
    java.util.Date p0) {
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
    
    private final void initViews() {
    }
    
    private final com.parse.ParseObject getOrganiser() {
        return null;
    }
    
    private final void saveEvent() {
    }
    
    private final void refreshList() {
    }
    
    private final void initObservers() {
    }
    
    @java.lang.Override()
    public void onBackPress() {
    }
}