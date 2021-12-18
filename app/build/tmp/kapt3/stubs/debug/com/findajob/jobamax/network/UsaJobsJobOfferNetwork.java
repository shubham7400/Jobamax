package com.findajob.jobamax.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\'\u00a8\u0006\b"}, d2 = {"Lcom/findajob/jobamax/network/UsaJobsJobOfferNetwork;", "", "getJobOffer", "Lretrofit2/Call;", "Lcom/findajob/jobamax/model/JobOfferUsaJobs;", "role", "", "location", "app_debug"})
public abstract interface UsaJobsJobOfferNetwork {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "search?")
    @retrofit2.http.Headers(value = {"Host: data.usajobs.gov", "User-Agent: thomas.woodfin@jobamax.com", "Authorization-Key: JCtKBsYAlqL46dlpmmxehxkZ9EtsUwoEPX7Ok77QIxg="})
    public abstract retrofit2.Call<com.findajob.jobamax.model.JobOfferUsaJobs> getJobOffer(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "Keyword")
    java.lang.String role, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "LocationName")
    java.lang.String location);
}