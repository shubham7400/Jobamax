package com.findajob.jobamax.dashboard.home.training;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015R\'\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\'\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/findajob/jobamax/dashboard/home/training/TrainingViewModel;", "Lcom/findajob/jobamax/base/BaseAndroidViewModel;", "context", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_coursesLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/findajob/jobamax/data/pojo/Courses;", "get_coursesLiveData", "()Landroidx/lifecycle/MutableLiveData;", "_coursesLiveData$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/app/Application;", "courseLiveData", "Landroidx/lifecycle/LiveData;", "getCourseLiveData", "()Landroidx/lifecycle/LiveData;", "courseLiveData$delegate", "fetchCourses", "", "app_debug"})
public final class TrainingViewModel extends com.findajob.jobamax.base.BaseAndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    private final kotlin.Lazy _coursesLiveData$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy courseLiveData$delegate = null;
    
    @javax.inject.Inject()
    public TrainingViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.findajob.jobamax.data.pojo.Courses>> get_coursesLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.findajob.jobamax.data.pojo.Courses>> getCourseLiveData() {
        return null;
    }
    
    public final void fetchCourses() {
    }
}