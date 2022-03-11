package com.findajob.jobamax.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00070\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/findajob/jobamax/repo/UdemyRepo;", "", "udemyApiService", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/api/UdemyApiService;", "(Lcom/findajob/jobamax/dashboard/home/training/online/courses/api/UdemyApiService;)V", "getReviewsList", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagingData;", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/review/Review;", "courseId", "", "getSearchResult", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/OnlineCourse;", "query", "", "getSyllabus", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/syllabus/Syllabus;", "app_debug"})
@javax.inject.Singleton()
public final class UdemyRepo {
    private final com.findajob.jobamax.dashboard.home.training.online.courses.api.UdemyApiService udemyApiService = null;
    
    @javax.inject.Inject()
    public UdemyRepo(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.dashboard.home.training.online.courses.api.UdemyApiService udemyApiService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse>> getSearchResult(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.findajob.jobamax.dashboard.home.training.online.courses.model.review.Review>> getReviewsList(int courseId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Syllabus>> getSyllabus(int courseId) {
        return null;
    }
}