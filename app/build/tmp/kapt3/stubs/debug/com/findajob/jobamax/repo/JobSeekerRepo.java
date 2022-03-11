package com.findajob.jobamax.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001aJ\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0018\u0010\'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0007J\u0018\u0010+\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0007R2\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lcom/findajob/jobamax/repo/JobSeekerRepo;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_parseJobSeekerQuery", "Lcom/parse/ParseQuery;", "Lcom/parse/ParseObject;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "setContext", "currentUserId", "", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId$delegate", "Lkotlin/Lazy;", "parseCurrentUser", "Lcom/parse/ParseUser;", "getParseCurrentUser", "()Lcom/parse/ParseUser;", "parseCurrentUser$delegate", "getCurrent", "", "callback", "Lcom/findajob/jobamax/model/GetUserCallback;", "getCurrentJobSeeker", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExistingJobSeeker", "Lio/reactivex/Single;", "user", "Lcom/findajob/jobamax/model/User;", "loadJobSeekers", "", "jobSource", "Lcom/findajob/jobamax/model/JobSource;", "index", "", "updateMessagePushNotificationFlag", "flag", "", "jobSeekerObject", "updateNewsMatchesPushNotificationFlag", "app_debug"})
public final class JobSeekerRepo {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context context;
    private final com.parse.ParseQuery<com.parse.ParseObject> _parseJobSeekerQuery = null;
    private final kotlin.Lazy parseCurrentUser$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy currentUserId$delegate = null;
    
    @javax.inject.Inject()
    public JobSeekerRepo(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    public final void getCurrent(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.GetUserCallback callback) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.parse.ParseObject> loadJobSeekers(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobSource jobSource, int index) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.parse.ParseObject> getExistingJobSeeker(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.User user) {
        return null;
    }
    
    private final com.parse.ParseUser getParseCurrentUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCurrentJobSeeker(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.parse.ParseObject> continuation) {
        return null;
    }
    
    public final void getExistingJobSeeker(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.User user, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.GetUserCallback callback) {
    }
    
    public final void updateMessagePushNotificationFlag(boolean flag, @org.jetbrains.annotations.Nullable()
    com.parse.ParseObject jobSeekerObject) {
    }
    
    public final void updateNewsMatchesPushNotificationFlag(boolean flag, @org.jetbrains.annotations.Nullable()
    com.parse.ParseObject jobSeekerObject) {
    }
}