package com.findajob.jobamax.training.ui;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0010J\b\u0010J\u001a\u00020HH\u0002J\u0006\u0010K\u001a\u00020HJ\b\u0010L\u001a\u00020HH\u0002J\u0012\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\u0015J\u000e\u0010N\u001a\u00020H2\u0006\u0010O\u001a\u00020PJ\u000e\u0010F\u001a\u00020H2\u0006\u0010O\u001a\u00020PJ\u0006\u0010Q\u001a\u00020HJ\u0006\u0010R\u001a\u00020\tJ\u0006\u0010S\u001a\u00020HJ\u000e\u0010T\u001a\u00020H2\u0006\u0010U\u001a\u00020VJ\u0006\u0010W\u001a\u00020HJ\u0006\u0010X\u001a\u00020HJ\u000e\u0010X\u001a\u00020H2\u0006\u0010U\u001a\u00020YJ\u000e\u0010Z\u001a\u00020H2\u0006\u0010U\u001a\u00020[J\u000e\u0010\\\u001a\u00020H2\u0006\u0010]\u001a\u00020\tJ\u000e\u0010^\u001a\u00020H2\u0006\u0010_\u001a\u00020\tJ\b\u0010`\u001a\u00020HH\u0002J\u0006\u0010a\u001a\u00020HJ\b\u0010b\u001a\u00020HH\u0002J\u000e\u0010c\u001a\u00020H2\u0006\u0010d\u001a\u00020\u0019J\u001e\u0010e\u001a\u00020H2\u0006\u0010f\u001a\u00020\u00192\u0006\u0010g\u001a\u00020\u00192\u0006\u0010U\u001a\u00020hJ&\u0010i\u001a\u00020H2\u0016\u0010j\u001a\u0012\u0012\u0004\u0012\u00020\u00190&j\b\u0012\u0004\u0012\u00020\u0019`\'2\u0006\u0010U\u001a\u00020kJ\u0006\u0010l\u001a\u00020HJ\u0006\u0010m\u001a\u00020HJ\u000e\u0010n\u001a\u00020H2\u0006\u0010o\u001a\u00020\u0019J\u0010\u0010p\u001a\u00020H2\u0006\u0010q\u001a\u00020rH\u0002J\u000e\u0010s\u001a\u00020H2\u0006\u0010t\u001a\u00020\u0019R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R*\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\f0&j\b\u0012\u0004\u0012\u00020\f`\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R&\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R \u00109\u001a\b\u0012\u0004\u0012\u00020\u000e0&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010)\"\u0004\b;\u0010+R\u001a\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010=\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010 \"\u0004\b?\u0010\"R \u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0017\"\u0004\bB\u0010/R\u001d\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0017R\u001d\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0017\u00a8\u0006u"}, d2 = {"Lcom/findajob/jobamax/training/ui/ManageRoomViewModel;", "Lcom/findajob/jobamax/base/BaseAndroidViewModel;", "context", "Landroid/app/Application;", "liveRoomRepo", "Lcom/findajob/jobamax/repo/LiveRoomRepo;", "(Landroid/app/Application;Lcom/findajob/jobamax/repo/LiveRoomRepo;)V", "_eventSuccessListener", "Landroidx/lifecycle/MutableLiveData;", "", "_membersLiveData", "", "Lcom/findajob/jobamax/training/model/Member;", "_selectedRoomObservable", "Lcom/parse/ParseObject;", "_todayEvents", "Lcom/findajob/jobamax/model/Event;", "_upcomingEvents", "getContext", "()Landroid/app/Application;", "eventSuccessListener", "Landroidx/lifecycle/LiveData;", "getEventSuccessListener", "()Landroidx/lifecycle/LiveData;", "interestsList", "", "getInterestsList", "()Ljava/util/List;", "setInterestsList", "(Ljava/util/List;)V", "jobSeeker", "getJobSeeker", "()Lcom/parse/ParseObject;", "setJobSeeker", "(Lcom/parse/ParseObject;)V", "getLiveRoomRepo", "()Lcom/findajob/jobamax/repo/LiveRoomRepo;", "members", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMembers", "()Ljava/util/ArrayList;", "setMembers", "(Ljava/util/ArrayList;)V", "membersLiveData", "getMembersLiveData", "setMembersLiveData", "(Landroidx/lifecycle/LiveData;)V", "recruiter", "getRecruiter", "setRecruiter", "requestQueue", "Lcom/android/volley/RequestQueue;", "getRequestQueue", "()Lcom/android/volley/RequestQueue;", "requestQueue$delegate", "Lkotlin/Lazy;", "roomList", "getRoomList", "setRoomList", "roomLiveData", "selectedRoom", "getSelectedRoom", "setSelectedRoom", "selectedRoomObservable", "getSelectedRoomObservable", "setSelectedRoomObservable", "todayEvents", "getTodayEvents", "upcomingEvents", "getUpcomingEvents", "addEvent", "", "event", "addJobSeeker", "addMember", "addRecruiter", "getRoomObserver", "getSelectedDateEvents", "date", "Ljava/util/Date;", "initRoom", "isLinkedInSaved", "leaveSavedRoom", "loadInterests", "callback", "Lcom/findajob/jobamax/repo/GetInterestsCallback;", "loadRoom", "loadRooms", "Lcom/findajob/jobamax/repo/GetRoomCallback;", "loadSavedRoom", "Lcom/findajob/jobamax/repo/GetSavedRoomCallback;", "muteAudio", "muted", "raiseHand", "handRaised", "removeJobSeeker", "removeMember", "removeRecruiter", "saveLinkedIn", "username", "saveRoom", "name", "category", "Lcom/findajob/jobamax/repo/SaveRoomCallback;", "saveSelectedInterests", "names", "Lcom/findajob/jobamax/repo/SaveInterestsCallback;", "selectRandomRoom", "selectRandomRoomInBackground", "sendInvite", "email", "sendNotification", "notification", "Lorg/json/JSONObject;", "sendRefreshRoomNotification", "roomId", "app_debug"})
public final class ManageRoomViewModel extends com.findajob.jobamax.base.BaseAndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.repo.LiveRoomRepo liveRoomRepo = null;
    private androidx.lifecycle.MutableLiveData<java.util.List<com.parse.ParseObject>> roomLiveData;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject selectedRoom;
    private final androidx.lifecycle.MutableLiveData<com.parse.ParseObject> _selectedRoomObservable = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.LiveData<com.parse.ParseObject> selectedRoomObservable;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.parse.ParseObject> roomList;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> interestsList;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject recruiter;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject jobSeeker;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _eventSuccessListener = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> eventSuccessListener = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.findajob.jobamax.training.model.Member>> _membersLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.LiveData<java.util.List<com.findajob.jobamax.training.model.Member>> membersLiveData;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.findajob.jobamax.training.model.Member> members;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.findajob.jobamax.model.Event>> _todayEvents = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.findajob.jobamax.model.Event>> todayEvents = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.findajob.jobamax.model.Event>> _upcomingEvents = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.findajob.jobamax.model.Event>> upcomingEvents = null;
    private final kotlin.Lazy requestQueue$delegate = null;
    
    @javax.inject.Inject()
    public ManageRoomViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application context, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.LiveRoomRepo liveRoomRepo) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.repo.LiveRoomRepo getLiveRoomRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getSelectedRoom() {
        return null;
    }
    
    public final void setSelectedRoom(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.parse.ParseObject> getSelectedRoomObservable() {
        return null;
    }
    
    public final void setSelectedRoomObservable(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<com.parse.ParseObject> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.parse.ParseObject> getRoomList() {
        return null;
    }
    
    public final void setRoomList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.parse.ParseObject> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getInterestsList() {
        return null;
    }
    
    public final void setInterestsList(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getRecruiter() {
        return null;
    }
    
    public final void setRecruiter(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getJobSeeker() {
        return null;
    }
    
    public final void setJobSeeker(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getEventSuccessListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> getRoomObserver() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.findajob.jobamax.training.model.Member>> getMembersLiveData() {
        return null;
    }
    
    public final void setMembersLiveData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.util.List<com.findajob.jobamax.training.model.Member>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.findajob.jobamax.training.model.Member> getMembers() {
        return null;
    }
    
    public final void setMembers(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.training.model.Member> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.findajob.jobamax.model.Event>> getTodayEvents() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.findajob.jobamax.model.Event>> getUpcomingEvents() {
        return null;
    }
    
    public final void loadRooms() {
    }
    
    public final void loadRooms(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetRoomCallback callback) {
    }
    
    public final void selectRandomRoom() {
    }
    
    public final void leaveSavedRoom() {
    }
    
    public final void loadSavedRoom(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetSavedRoomCallback callback) {
    }
    
    public final void selectRandomRoomInBackground() {
    }
    
    public final void saveRoom(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveRoomCallback callback) {
    }
    
    public final void addMember() {
    }
    
    private final void addRecruiter() {
    }
    
    private final void addJobSeeker() {
    }
    
    public final void removeMember() {
    }
    
    private final void removeRecruiter() {
    }
    
    private final void removeJobSeeker() {
    }
    
    public final void initRoom() {
    }
    
    public final void muteAudio(boolean muted) {
    }
    
    public final void raiseHand(boolean handRaised) {
    }
    
    public final void loadRoom() {
    }
    
    public final void sendRefreshRoomNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String roomId) {
    }
    
    private final com.android.volley.RequestQueue getRequestQueue() {
        return null;
    }
    
    private final void sendNotification(org.json.JSONObject notification) {
    }
    
    public final void loadInterests(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetInterestsCallback callback) {
    }
    
    public final void saveSelectedInterests(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> names, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveInterestsCallback callback) {
    }
    
    public final void addEvent(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.Event event) {
    }
    
    public final void getSelectedDateEvents(@org.jetbrains.annotations.NotNull()
    java.util.Date date) {
    }
    
    public final void getUpcomingEvents(@org.jetbrains.annotations.NotNull()
    java.util.Date date) {
    }
    
    public final boolean isLinkedInSaved() {
        return false;
    }
    
    public final void saveLinkedIn(@org.jetbrains.annotations.NotNull()
    java.lang.String username) {
    }
    
    public final void sendInvite(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
}