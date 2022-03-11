package com.findajob.jobamax.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ%\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/findajob/jobamax/data/remote/AuthRepositoryImpl;", "Lcom/findajob/jobamax/data/remote/AuthRepository;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkExistingJobSeeker", "Lcom/findajob/jobamax/base/functional/Either;", "", "Lcom/parse/ParseObject;", "user", "Lcom/findajob/jobamax/model/User;", "(Lcom/findajob/jobamax/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkExistingRecruiter", "Companion", "app_debug"})
public final class AuthRepositoryImpl implements com.findajob.jobamax.data.remote.AuthRepository {
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.data.remote.AuthRepositoryImpl.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile com.findajob.jobamax.data.remote.AuthRepository instance;
    
    private AuthRepositoryImpl(android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object checkExistingRecruiter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.findajob.jobamax.base.functional.Either<? extends java.lang.Throwable, ? extends com.parse.ParseObject>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object checkExistingJobSeeker(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.findajob.jobamax.base.functional.Either<? extends java.lang.Throwable, ? extends com.parse.ParseObject>> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/findajob/jobamax/data/remote/AuthRepositoryImpl$Companion;", "", "()V", "instance", "Lcom/findajob/jobamax/data/remote/AuthRepository;", "getInstance", "Lcom/findajob/jobamax/base/functional/Either;", "", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.base.functional.Either<java.lang.Throwable, com.findajob.jobamax.data.remote.AuthRepository> getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}