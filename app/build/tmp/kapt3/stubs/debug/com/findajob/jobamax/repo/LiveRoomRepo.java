package com.findajob.jobamax.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020$J\u001c\u0010%\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\'0\'0&2\u0006\u0010(\u001a\u00020\u001aJ\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0*2\b\u0010+\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\u00072\u0006\u0010-\u001a\u00020\u0013H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010\u00072\u0006\u0010-\u001a\u00020\u0013H\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010\u00072\u0006\u00100\u001a\u00020\u0013H\u0002J\u0012\u00101\u001a\u0004\u0018\u00010\u00072\u0006\u00102\u001a\u00020\u0013H\u0002JD\u00103\u001a@\u0012<\u0012:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130* \b*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130*\u0018\u00010\u00180\u00180&J\u0014\u00104\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070&J2\u00105\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001a \b*\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010*0*0&2\u0006\u00106\u001a\u0002072\b\u0010+\u001a\u0004\u0018\u00010\u0007J2\u00108\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001a \b*\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010*0*0&2\u0006\u00106\u001a\u0002072\b\u0010+\u001a\u0004\u0018\u00010\u0007J\u0012\u00109\u001a\u0004\u0018\u00010\u00072\u0006\u0010-\u001a\u00020\u0013H\u0002J\u000e\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u0013J\u000e\u0010<\u001a\u00020\'2\u0006\u0010=\u001a\u00020\'J \u0010>\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \b*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010*0*0&J\u0016\u0010?\u001a\u00020 2\u0006\u00102\u001a\u00020\u00132\u0006\u0010@\u001a\u00020AJ\u0016\u0010B\u001a\u00020 2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010@\u001a\u00020CJ\u0016\u0010D\u001a\u00020 2\u0006\u0010=\u001a\u00020\'2\u0006\u0010E\u001a\u00020\u0013J\u001c\u0010F\u001a\u00020 2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00130\u001e2\u0006\u0010@\u001a\u00020HJ\u0014\u0010I\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070&R2\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R2\u0010\n\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006J"}, d2 = {"Lcom/findajob/jobamax/repo/LiveRoomRepo;", "", "context", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_parseJobSeekerQuery", "Lcom/parse/ParseQuery;", "Lcom/parse/ParseObject;", "kotlin.jvm.PlatformType", "_parseRecruiterQuery", "_userQuery", "getContext", "()Landroid/app/Application;", "currentUser", "getCurrentUser", "()Lcom/parse/ParseObject;", "currentUser$delegate", "Lkotlin/Lazy;", "currentUserId", "", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId$delegate", "eventListPair", "Lkotlin/Pair;", "", "Lcom/findajob/jobamax/model/Event;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "roomList", "Ljava/util/ArrayList;", "add", "", "jobSeeker", "Lcom/findajob/jobamax/model/JobSeeker;", "recruiter", "Lcom/findajob/jobamax/model/Recruiter;", "addEvent", "Lio/reactivex/Single;", "", "event", "getEventsByRoom", "", "room", "getJobSeekerById", "userId", "getRecruiterById", "getRecruiterByRecruiterId", "recruiterId", "getRoomById", "roomId", "getRooms", "getSavedRoom", "getSelectedDateEvents", "date", "Ljava/util/Date;", "getUpcomingEvents", "getUserById", "getUserIdFromEmail", "email", "isLinkedInSaved", "isRecruiter", "loadInterests", "loadRoom", "callback", "Lcom/findajob/jobamax/repo/GetRoomCallback;", "save", "Lcom/findajob/jobamax/repo/SaveRoomCallback;", "saveLinkedIn", "username", "saveSelectedInterests", "names", "Lcom/findajob/jobamax/repo/SaveInterestsCallback;", "selectRandomRoom", "app_debug"})
public final class LiveRoomRepo {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    private final kotlin.Lazy currentUserId$delegate = null;
    private final kotlin.Lazy currentUser$delegate = null;
    private com.parse.ParseQuery<com.parse.ParseObject> _userQuery;
    private com.parse.ParseQuery<com.parse.ParseObject> _parseRecruiterQuery;
    private com.parse.ParseQuery<com.parse.ParseObject> _parseJobSeekerQuery;
    private final java.util.ArrayList<com.parse.ParseObject> roomList = null;
    private final kotlinx.coroutines.CoroutineScope ioScope = null;
    private kotlin.Pair<? extends java.util.List<com.findajob.jobamax.model.Event>, ? extends com.parse.ParseObject> eventListPair;
    
    @javax.inject.Inject()
    public LiveRoomRepo(@org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    private final java.lang.String getCurrentUserId() {
        return null;
    }
    
    private final com.parse.ParseObject getCurrentUser() {
        return null;
    }
    
    /**
     * This function takes the user id, and returns Recruiter Parse Object
     *
     * @param userId as String
     *
     * @return Recruiter [ParseObject]
     */
    private final com.parse.ParseObject getRecruiterById(java.lang.String userId) {
        return null;
    }
    
    /**
     * This function takes the user id, and returns JobSeeker Parse Object
     *
     * @param userId as String
     *
     * @return JobSeeker [ParseObject]
     */
    private final com.parse.ParseObject getJobSeekerById(java.lang.String userId) {
        return null;
    }
    
    /**
     * This function takes the user id, and returns an User Parse Object
     *
     * @param userId as String
     *
     * @return _User [ParseObject]
     */
    private final com.parse.ParseObject getUserById(java.lang.String userId) {
        return null;
    }
    
    private final com.parse.ParseObject getRecruiterByRecruiterId(java.lang.String recruiterId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<kotlin.Pair<java.util.List<com.parse.ParseObject>, java.util.List<java.lang.String>>> getRooms() {
        return null;
    }
    
    private final com.parse.ParseObject getRoomById(java.lang.String roomId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.parse.ParseObject> getSavedRoom() {
        return null;
    }
    
    public final void loadRoom(@org.jetbrains.annotations.NotNull()
    java.lang.String roomId, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetRoomCallback callback) {
    }
    
    public final void save(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject room, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveRoomCallback callback) {
    }
    
    public final void add(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.Recruiter recruiter) {
    }
    
    public final void add(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobSeeker jobSeeker) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.parse.ParseObject>> loadInterests() {
        return null;
    }
    
    public final void saveSelectedInterests(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> names, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveInterestsCallback callback) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.parse.ParseObject> selectRandomRoom() {
        return null;
    }
    
    /**
     * Adds an event to the database
     *
     * @param event of [Event] type
     *
     * @return [Single] of [Boolean] to note,
     * if the event saving was successful or not
     */
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.lang.Boolean> addEvent(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.Event event) {
        return null;
    }
    
    private final java.util.List<com.findajob.jobamax.model.Event> getEventsByRoom(com.parse.ParseObject room) {
        return null;
    }
    
    /**
     * Gets the event list of the selected date
     * filtered by the room and selected date
     *
     * Takes date and room as a parameter
     *
     * @param date of [Date] type
     * @param room of [ParseObject] type
     *
     * @return [Single] of [Event] list
     */
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.findajob.jobamax.model.Event>> getSelectedDateEvents(@org.jetbrains.annotations.NotNull()
    java.util.Date date, @org.jetbrains.annotations.Nullable()
    com.parse.ParseObject room) {
        return null;
    }
    
    /**
     * Gets the event list from the selected date
     * point on  filtered by the room and selected date
     *
     * Takes date and room as a parameter
     *
     * @param date of [Date] type
     * @param room of [ParseObject] type
     *
     * @return [Single] of [Event] list
     */
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.findajob.jobamax.model.Event>> getUpcomingEvents(@org.jetbrains.annotations.NotNull()
    java.util.Date date, @org.jetbrains.annotations.Nullable()
    com.parse.ParseObject room) {
        return null;
    }
    
    public final boolean isLinkedInSaved(boolean isRecruiter) {
        return false;
    }
    
    public final void saveLinkedIn(boolean isRecruiter, @org.jetbrains.annotations.NotNull()
    java.lang.String username) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserIdFromEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        return null;
    }
}