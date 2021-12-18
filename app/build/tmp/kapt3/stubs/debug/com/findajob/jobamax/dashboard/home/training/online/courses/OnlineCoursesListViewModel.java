package com.findajob.jobamax.dashboard.home.training.online.courses;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/findajob/jobamax/dashboard/home/training/online/courses/OnlineCoursesListViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/findajob/jobamax/repo/UdemyRepo;", "(Lcom/findajob/jobamax/repo/UdemyRepo;)V", "_coursesList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/CoursesResponse;", "_onClick", "", "get_onClick", "()Landroidx/lifecycle/MutableLiveData;", "_onClick$delegate", "Lkotlin/Lazy;", "currentQuery", "", "kotlin.jvm.PlatformType", "onClick", "Landroidx/lifecycle/LiveData;", "getOnClick", "()Landroidx/lifecycle/LiveData;", "onClick$delegate", "onlineCourses", "Landroidx/paging/PagingData;", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/OnlineCourse;", "getOnlineCourses", "result", "getResult", "", "id", "searchCourses", "query", "Companion", "app_debug"})
public final class OnlineCoursesListViewModel extends androidx.lifecycle.ViewModel {
    private final com.findajob.jobamax.repo.UdemyRepo repository = null;
    private final kotlin.Lazy _onClick$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy onClick$delegate = null;
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.dashboard.home.training.online.courses.model.CoursesResponse> _coursesList = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> currentQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse>> onlineCourses = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.dashboard.home.training.online.courses.OnlineCoursesListViewModel.Companion Companion = null;
    private static final java.lang.String DEFAULT_QUERY = "";
    
    @javax.inject.Inject()
    public OnlineCoursesListViewModel(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.UdemyRepo repository) {
        super();
    }
    
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> get_onClick() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getOnClick() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.findajob.jobamax.dashboard.home.training.online.courses.model.CoursesResponse> getResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse>> getOnlineCourses() {
        return null;
    }
    
    public final void searchCourses(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void onClick(int id) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/findajob/jobamax/dashboard/home/training/online/courses/OnlineCoursesListViewModel$Companion;", "", "()V", "DEFAULT_QUERY", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}