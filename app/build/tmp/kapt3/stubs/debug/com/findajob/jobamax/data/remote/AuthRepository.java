package com.findajob.jobamax.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nJ%\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ%\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/findajob/jobamax/data/remote/AuthRepository;", "", "checkExistingJobSeeker", "Lcom/findajob/jobamax/base/functional/Either;", "", "Lcom/parse/ParseObject;", "user", "Lcom/findajob/jobamax/model/User;", "(Lcom/findajob/jobamax/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkExistingRecruiter", "Factory", "app_debug"})
public abstract interface AuthRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object checkExistingRecruiter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.findajob.jobamax.base.functional.Either<? extends java.lang.Throwable, ? extends com.parse.ParseObject>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object checkExistingJobSeeker(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.findajob.jobamax.base.functional.Either<? extends java.lang.Throwable, ? extends com.parse.ParseObject>> continuation);
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/findajob/jobamax/data/remote/AuthRepository$Factory;", "", "()V", "getInstance", "Lcom/findajob/jobamax/base/functional/Either;", "", "Lcom/findajob/jobamax/data/remote/AuthRepository;", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Factory {
        @org.jetbrains.annotations.NotNull()
        public static final com.findajob.jobamax.data.remote.AuthRepository.Factory INSTANCE = null;
        
        private Factory() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.base.functional.Either<java.lang.Throwable, com.findajob.jobamax.data.remote.AuthRepository> getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}