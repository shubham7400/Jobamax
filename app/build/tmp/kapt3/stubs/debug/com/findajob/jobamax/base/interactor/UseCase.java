package com.findajob.jobamax.base.interactor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\u0006\b\u0001\u0010\u0003 \u00002\u00020\u0002:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0004J8\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00012 \b\u0002\u0010\f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0004\u0012\u00020\u00100\rH\u0086\u0002\u00a2\u0006\u0002\u0010\u0011J%\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000b\u001a\u00028\u0001H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/findajob/jobamax/base/interactor/UseCase;", "Type", "", "Params", "()V", "mainJob", "Lkotlinx/coroutines/CompletableJob;", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "Lkotlinx/coroutines/Job;", "params", "onResult", "Lkotlin/Function1;", "Lcom/findajob/jobamax/base/functional/Either;", "", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "run", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "None", "app_debug"})
public abstract class UseCase<Type extends java.lang.Object, Params extends java.lang.Object> {
    private final kotlinx.coroutines.CompletableJob mainJob = null;
    private final kotlinx.coroutines.CoroutineScope uiScope = null;
    
    public UseCase() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object run(Params params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.findajob.jobamax.base.functional.Either<? extends java.lang.Throwable, ? extends Type>> continuation);
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job invoke(Params params, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.findajob.jobamax.base.functional.Either<? extends java.lang.Throwable, ? extends Type>, kotlin.Unit> onResult) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/findajob/jobamax/base/interactor/UseCase$None;", "", "()V", "app_debug"})
    public static final class None {
        
        public None() {
            super();
        }
    }
}