package com.findajob.jobamax.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001JT\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u0006H\'Jl\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u00062\u0016\b\u0001\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000fH\'\u00a8\u0006\u0010"}, d2 = {"Lcom/findajob/jobamax/network/AdzunaJobOfferNetwork;", "", "getJobOffer", "Lretrofit2/Call;", "Lcom/findajob/jobamax/model/JobOfferAdzuna;", "appId", "", "appKey", "role", "location", "distance", "", "resultsPerPage", "contentType", "options", "", "app_debug"})
public abstract interface AdzunaJobOfferNetwork {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "1?")
    public abstract retrofit2.Call<com.findajob.jobamax.model.JobOfferAdzuna> getJobOffer(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "app_id")
    java.lang.String appId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "app_key")
    java.lang.String appKey, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "what")
    java.lang.String role, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "where")
    java.lang.String location, @retrofit2.http.Query(value = "distance")
    int distance, @retrofit2.http.Query(value = "results_per_page")
    int resultsPerPage, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "content-type")
    java.lang.String contentType);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "1?")
    public abstract retrofit2.Call<com.findajob.jobamax.model.JobOfferAdzuna> getJobOffer(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "app_id")
    java.lang.String appId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "app_key")
    java.lang.String appKey, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "what")
    java.lang.String role, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "where")
    java.lang.String location, @retrofit2.http.Query(value = "distance")
    int distance, @retrofit2.http.Query(value = "results_per_page")
    int resultsPerPage, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "content-type")
    java.lang.String contentType, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.QueryMap()
    java.util.Map<java.lang.String, java.lang.Integer> options);
}