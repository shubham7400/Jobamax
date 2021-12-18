package com.findajob.jobamax.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010J\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\n0\n0\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00160\u0010J!\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J)\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0018\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\nJ\u0018\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/findajob/jobamax/repo/RecruiterRepo;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "cancelJobSeeker", "", "jobSeeker", "Lcom/parse/ParseObject;", "(Lcom/parse/ParseObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrent", "callback", "Lcom/findajob/jobamax/model/GetUserCallback;", "getCurrentRecruiter", "Lio/reactivex/Single;", "getExistingRecruiter", "kotlin.jvm.PlatformType", "user", "Lcom/findajob/jobamax/model/User;", "getPaymentHistory", "", "refuseJob", "job", "(Lcom/parse/ParseObject;Lcom/parse/ParseObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rejectJobSeeker", "reason", "", "selectedJobOffer", "(Lcom/parse/ParseObject;Ljava/lang/String;Lcom/parse/ParseObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "undoJob", "updateMessagePushNotificationFlag", "flag", "", "recruiterObject", "updateNewsMatchesPushNotificationFlag", "app_debug"})
public final class RecruiterRepo {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @javax.inject.Inject()
    public RecruiterRepo(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.parse.ParseObject> getCurrentRecruiter() {
        return null;
    }
    
    public final void getCurrent(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.GetUserCallback callback) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.parse.ParseObject> getExistingRecruiter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.User user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.parse.ParseObject>> getPaymentHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object rejectJobSeeker(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobSeeker, @org.jetbrains.annotations.NotNull()
    java.lang.String reason, @org.jetbrains.annotations.NotNull()
    com.parse.ParseObject selectedJobOffer, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object undoJob(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject job, @org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobSeeker, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object cancelJobSeeker(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobSeeker, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object refuseJob(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject job, @org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobSeeker, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final void updateMessagePushNotificationFlag(boolean flag, @org.jetbrains.annotations.Nullable()
    com.parse.ParseObject recruiterObject) {
    }
    
    public final void updateNewsMatchesPushNotificationFlag(boolean flag, @org.jetbrains.annotations.Nullable()
    com.parse.ParseObject recruiterObject) {
    }
}