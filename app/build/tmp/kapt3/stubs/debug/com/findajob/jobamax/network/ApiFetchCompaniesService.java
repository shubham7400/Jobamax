package com.findajob.jobamax.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/network/ApiFetchCompaniesService;", "", "searchCompanies", "Lretrofit2/Call;", "query", "", "Companion", "app_debug"})
public abstract interface ApiFetchCompaniesService {
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.network.ApiFetchCompaniesService.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "suggest?query=")
    public abstract retrofit2.Call<java.lang.Object> searchCompanies(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "query")
    java.lang.String query);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/findajob/jobamax/network/ApiFetchCompaniesService$Companion;", "", "()V", "BASE_URL", "", "logging", "Lokhttp3/logging/HttpLoggingInterceptor;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "setRetrofit", "(Lretrofit2/Retrofit;)V", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        private static final java.lang.String BASE_URL = "https://autocomplete.clearbit.com/v1/companies/";
        @org.jetbrains.annotations.Nullable()
        private static retrofit2.Retrofit retrofit;
        private static final okhttp3.logging.HttpLoggingInterceptor logging = null;
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final retrofit2.Retrofit getRetrofit() {
            return null;
        }
        
        public final void setRetrofit(@org.jetbrains.annotations.Nullable()
        retrofit2.Retrofit p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final retrofit2.Retrofit getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}