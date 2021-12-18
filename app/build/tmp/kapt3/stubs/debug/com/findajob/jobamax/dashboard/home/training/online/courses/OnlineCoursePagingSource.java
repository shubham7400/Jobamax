package com.findajob.jobamax.dashboard.home.training.online.courses;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ#\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0011H\u0016\u00a2\u0006\u0002\u0010\u0012J+\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/findajob/jobamax/dashboard/home/training/online/courses/OnlineCoursePagingSource;", "Landroidx/paging/PagingSource;", "", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/OnlineCourse;", "udemyApi", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/api/UdemyApiService;", "search", "", "(Lcom/findajob/jobamax/dashboard/home/training/online/courses/api/UdemyApiService;Ljava/lang/String;)V", "_numberOfResults", "Landroidx/lifecycle/MutableLiveData;", "numberOfResult", "Landroidx/lifecycle/LiveData;", "getNumberOfResult", "()Landroidx/lifecycle/LiveData;", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "load", "Landroidx/paging/PagingSource$LoadResult;", "params", "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class OnlineCoursePagingSource extends androidx.paging.PagingSource<java.lang.Integer, com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse> {
    private final com.findajob.jobamax.dashboard.home.training.online.courses.api.UdemyApiService udemyApi = null;
    private final java.lang.String search = null;
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> _numberOfResults;
    
    public OnlineCoursePagingSource(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.dashboard.home.training.online.courses.api.UdemyApiService udemyApi, @org.jetbrains.annotations.NotNull()
    java.lang.String search) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getNumberOfResult() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object load(@org.jetbrains.annotations.NotNull()
    androidx.paging.PagingSource.LoadParams<java.lang.Integer> params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.paging.PagingSource.LoadResult<java.lang.Integer, com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Integer getRefreshKey(@org.jetbrains.annotations.NotNull()
    androidx.paging.PagingState<java.lang.Integer, com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse> state) {
        return null;
    }
}