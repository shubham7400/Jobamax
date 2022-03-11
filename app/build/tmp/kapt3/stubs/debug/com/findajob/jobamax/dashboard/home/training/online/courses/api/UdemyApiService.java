package com.findajob.jobamax.dashboard.home.training.online.courses.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J/\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ/\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ/\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/findajob/jobamax/dashboard/home/training/online/courses/api/UdemyApiService;", "", "getRequest", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/CoursesResponse;", "search", "", "page", "", "pageSize", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReview", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/review/ReviewResponse;", "id", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSyllabus", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/syllabus/SyllabusResponse;", "Companion", "app_debug"})
public abstract interface UdemyApiService {
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.dashboard.home.training.online.courses.api.UdemyApiService.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "https://www.udemy.com/api-2.0/";
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "courses")
    @retrofit2.http.Headers(value = {"Authorization: Basic OVFRTjhodzRmMm5QWjlQaGNzeGM5S3lOa3duSjBDSTE5ZTl3YlUzQzpLbk5LUW96QkZiOE0wUG9aUEJKYlV0Y2oya0F2SldjS3VXNTI4MUxDZjlZNFI3M09IQ3B2SW5VM2tsTFk0M2Z2OGlPRXF6aTJaM3ZtWkZaYlVXSzE5eFhxMlJ5bFk0QnZZNlB6c3pudHExZFJTRlZTSldrd0ozd2pTdEdrdmtKNA=="})
    public abstract java.lang.Object getRequest(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "search")
    java.lang.String search, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "page_size")
    int pageSize, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.findajob.jobamax.dashboard.home.training.online.courses.model.CoursesResponse> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "courses/{course_id}/reviews")
    @retrofit2.http.Headers(value = {"Authorization: Basic OVFRTjhodzRmMm5QWjlQaGNzeGM5S3lOa3duSjBDSTE5ZTl3YlUzQzpLbk5LUW96QkZiOE0wUG9aUEJKYlV0Y2oya0F2SldjS3VXNTI4MUxDZjlZNFI3M09IQ3B2SW5VM2tsTFk0M2Z2OGlPRXF6aTJaM3ZtWkZaYlVXSzE5eFhxMlJ5bFk0QnZZNlB6c3pudHExZFJTRlZTSldrd0ozd2pTdEdrdmtKNA=="})
    public abstract java.lang.Object getReview(@retrofit2.http.Path(value = "course_id", encoded = true)
    int id, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "page_size")
    int pageSize, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.findajob.jobamax.dashboard.home.training.online.courses.model.review.ReviewResponse> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "courses/{course_id}/public-curriculum-items")
    @retrofit2.http.Headers(value = {"Authorization: Basic OVFRTjhodzRmMm5QWjlQaGNzeGM5S3lOa3duSjBDSTE5ZTl3YlUzQzpLbk5LUW96QkZiOE0wUG9aUEJKYlV0Y2oya0F2SldjS3VXNTI4MUxDZjlZNFI3M09IQ3B2SW5VM2tsTFk0M2Z2OGlPRXF6aTJaM3ZtWkZaYlVXSzE5eFhxMlJ5bFk0QnZZNlB6c3pudHExZFJTRlZTSldrd0ozd2pTdEdrdmtKNA=="})
    public abstract java.lang.Object getSyllabus(@retrofit2.http.Path(value = "course_id", encoded = true)
    int id, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "page_size")
    int pageSize, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.SyllabusResponse> continuation);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/findajob/jobamax/dashboard/home/training/online/courses/api/UdemyApiService$Companion;", "", "()V", "BASE_URL", "", "HEADER", "UDEMY_CLIENT_ID", "UDEMY_CLIENT_SECRET", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String BASE_URL = "https://www.udemy.com/api-2.0/";
        private static final java.lang.String HEADER = "Authorization: Basic OVFRTjhodzRmMm5QWjlQaGNzeGM5S3lOa3duSjBDSTE5ZTl3YlUzQzpLbk5LUW96QkZiOE0wUG9aUEJKYlV0Y2oya0F2SldjS3VXNTI4MUxDZjlZNFI3M09IQ3B2SW5VM2tsTFk0M2Z2OGlPRXF6aTJaM3ZtWkZaYlVXSzE5eFhxMlJ5bFk0QnZZNlB6c3pudHExZFJTRlZTSldrd0ozd2pTdEdrdmtKNA==";
        private static final java.lang.String UDEMY_CLIENT_SECRET = "tKnNKQozBFb8M0PoZPBJbUtcj2kAvJWcKuW5281LCf9Y4R73OHCpvInU3klLY43fv8iOEqzi2Z3vmZFZbUWK19xXq2RylY4BvY6Pzszntq1dRSFVSJWkwJ3wjStGkvkJ4";
        private static final java.lang.String UDEMY_CLIENT_ID = "9QQN8hw4f2nPZ9Phcsxc9KyNkwnJ0CI19e9wbU3C";
        
        private Companion() {
            super();
        }
    }
}