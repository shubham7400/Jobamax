package com.findajob.jobamax.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/network/NotificationApiService;", "", "postNotification", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "request", "Lcom/findajob/jobamax/model/fcm/PushNotification;", "app_debug"})
public abstract interface NotificationApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "fcm/send")
    @retrofit2.http.Headers(value = {"Authorization: key=AAAA1VNXc2M:APA91bGVQTctfKBEO-YqU5I6-OPjZJ037DFyJYgPNubKjiwywi7hOYAbAswpWROnEKkk1nAsS5WCh-T8L-u0eDU8YavfWmKLPM3UCJQ_-_WY2wO1_VR-FU5TtAuQkRvVNGYPvx0G_LT4", "Content-Type:application/json"})
    public abstract retrofit2.Call<okhttp3.ResponseBody> postNotification(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.findajob.jobamax.model.fcm.PushNotification request);
}