package com.findajob.jobamax.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000f\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/findajob/jobamax/repo/LocationRepo;", "", "api", "Lcom/findajob/jobamax/data/remote/GoogleApiService;", "(Lcom/findajob/jobamax/data/remote/GoogleApiService;)V", "getApi", "()Lcom/findajob/jobamax/data/remote/GoogleApiService;", "queryLocation", "Lcom/findajob/jobamax/util/Resource;", "", "Lcom/findajob/jobamax/data/pojo/Location;", "query", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryLocationDetails", "placeId", "app_debug"})
public final class LocationRepo {
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.data.remote.GoogleApiService api = null;
    
    @javax.inject.Inject()
    public LocationRepo(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.data.remote.GoogleApiService api) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.data.remote.GoogleApiService getApi() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object queryLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.findajob.jobamax.util.Resource<java.util.List<com.findajob.jobamax.data.pojo.Location>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object queryLocationDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String placeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.findajob.jobamax.util.Resource<com.findajob.jobamax.data.pojo.Location>> continuation) {
        return null;
    }
}