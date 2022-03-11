package com.findajob.jobamax.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/network/JobsPikrJobOfferNetwork;", "", "getJobOffer", "Lretrofit2/Call;", "Lcom/findajob/jobamax/model/JobOfferJobsPikr;", "request", "Lcom/findajob/jobamax/model/JobRequestJobsPikr;", "app_debug"})
public abstract interface JobsPikrJobOfferNetwork {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "data")
    @retrofit2.http.Headers(value = {"Content-Type: application/json", "client_id: jobam_jp_49d22c96dc", "client_auth_key: OfF5QspCREVxAsQlWyHrXMlq3ZL99fiAaxDVWOp9pVA"})
    public abstract retrofit2.Call<com.findajob.jobamax.model.JobOfferJobsPikr> getJobOffer(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.findajob.jobamax.model.JobRequestJobsPikr request);
}