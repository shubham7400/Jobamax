package com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u001b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0017\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/findajob/jobamax/dashboard/home/training/online/courses/onlinecourse/OnlineCourseViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/findajob/jobamax/repo/UdemyRepo;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/findajob/jobamax/repo/UdemyRepo;Landroidx/lifecycle/SavedStateHandle;)V", "id", "", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "instructors", "", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/VisibleInstructor;", "getInstructors", "()Ljava/util/List;", "onlineCourse", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/OnlineCourse;", "getOnlineCourse", "()Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/OnlineCourse;", "reviews", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagingData;", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/review/Review;", "getReviews", "()Landroidx/lifecycle/LiveData;", "syllabus", "Lcom/findajob/jobamax/dashboard/home/training/online/courses/model/syllabus/Syllabus;", "getSyllabus", "app_debug"})
public final class OnlineCourseViewModel extends androidx.lifecycle.ViewModel {
    private final com.findajob.jobamax.repo.UdemyRepo repository = null;
    private final androidx.lifecycle.SavedStateHandle savedStateHandle = null;
    @org.jetbrains.annotations.Nullable()
    private final com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse onlineCourse = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer id = null;
    @org.jetbrains.annotations.Nullable()
    private final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.findajob.jobamax.dashboard.home.training.online.courses.model.review.Review>> reviews = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.findajob.jobamax.dashboard.home.training.online.courses.model.VisibleInstructor> instructors = null;
    @org.jetbrains.annotations.Nullable()
    private final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Syllabus>> syllabus = null;
    
    @javax.inject.Inject()
    public OnlineCourseViewModel(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.UdemyRepo repository, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse getOnlineCourse() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.findajob.jobamax.dashboard.home.training.online.courses.model.review.Review>> getReviews() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.findajob.jobamax.dashboard.home.training.online.courses.model.VisibleInstructor> getInstructors() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Syllabus>> getSyllabus() {
        return null;
    }
}