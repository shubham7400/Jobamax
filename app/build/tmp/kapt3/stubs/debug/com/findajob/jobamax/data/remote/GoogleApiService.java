package com.findajob.jobamax.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/findajob/jobamax/data/remote/GoogleApiService;", "", "getMapTextSearchResponse", "Lretrofit2/Response;", "Lcom/findajob/jobamax/data/dto/location/GoogleApiResponseDto;", "key", "", "query", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlaceDetailsResponse", "Lcom/findajob/jobamax/data/dto/location/PlaceDetailsApiResponseDto;", "app_debug"})
public abstract interface GoogleApiService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/maps/api/place/autocomplete/json")
    public abstract java.lang.Object getMapTextSearchResponse(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "key")
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "input")
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.findajob.jobamax.data.dto.location.GoogleApiResponseDto>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/maps/api/place/details/json")
    public abstract java.lang.Object getPlaceDetailsResponse(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "key")
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "place_id")
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.findajob.jobamax.data.dto.location.PlaceDetailsApiResponseDto>> continuation);
}