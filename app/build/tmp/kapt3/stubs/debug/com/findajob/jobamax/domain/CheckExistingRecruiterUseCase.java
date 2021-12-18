package com.findajob.jobamax.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/findajob/jobamax/domain/CheckExistingRecruiterUseCase;", "Lcom/findajob/jobamax/base/interactor/UseCase;", "Lcom/parse/ParseObject;", "Lcom/findajob/jobamax/model/User;", "repo", "Lcom/findajob/jobamax/data/remote/AuthRepository;", "(Lcom/findajob/jobamax/data/remote/AuthRepository;)V", "run", "Lcom/findajob/jobamax/base/functional/Either;", "", "params", "(Lcom/findajob/jobamax/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class CheckExistingRecruiterUseCase extends com.findajob.jobamax.base.interactor.UseCase<com.parse.ParseObject, com.findajob.jobamax.model.User> {
    private final com.findajob.jobamax.data.remote.AuthRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.domain.CheckExistingRecruiterUseCase.Companion Companion = null;
    
    public CheckExistingRecruiterUseCase(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.data.remote.AuthRepository repo) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object run(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.User params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.findajob.jobamax.base.functional.Either<? extends java.lang.Throwable, ? extends com.parse.ParseObject>> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JM\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\n\u00a8\u0006\u0011"}, d2 = {"Lcom/findajob/jobamax/domain/CheckExistingRecruiterUseCase$Companion;", "", "()V", "execute", "", "useCase", "Lcom/findajob/jobamax/domain/CheckExistingRecruiterUseCase;", "params", "Lcom/findajob/jobamax/model/User;", "onSuccess", "Lkotlin/Function1;", "Lcom/parse/ParseObject;", "Lkotlin/ParameterName;", "name", "parseUser", "onError", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void execute(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.domain.CheckExistingRecruiterUseCase useCase, @org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.model.User params, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.parse.ParseObject, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onError) {
        }
    }
}