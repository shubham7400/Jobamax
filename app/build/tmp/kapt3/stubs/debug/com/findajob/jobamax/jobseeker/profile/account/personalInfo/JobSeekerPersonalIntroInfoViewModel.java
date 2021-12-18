package com.findajob.jobamax.jobseeker.profile.account.personalInfo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013J3\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162#\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00110\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/account/personalInfo/JobSeekerPersonalIntroInfoViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "context", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getContext", "()Landroid/app/Application;", "jobSeeker", "Lcom/findajob/jobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/findajob/jobamax/model/JobSeeker;", "jobSeekerLiveData", "Landroidx/lifecycle/MutableLiveData;", "jobSeekerObject", "Lcom/parse/ParseObject;", "jobSeekerRepo", "Lcom/findajob/jobamax/repo/JobSeekerRepo;", "", "getJobSeekerObserver", "Landroidx/lifecycle/LiveData;", "submitData", "personalInfoModel", "Lcom/findajob/jobamax/jobseeker/profile/account/personalInfo/JobSeekerPersonalInformationModel;", "callback", "Lkotlin/Function1;", "Lcom/parse/ParseException;", "Lkotlin/ParameterName;", "name", "it", "app_debug"})
public final class JobSeekerPersonalIntroInfoViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    private final com.findajob.jobamax.repo.JobSeekerRepo jobSeekerRepo = null;
    private com.parse.ParseObject jobSeekerObject;
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.model.JobSeeker> jobSeekerLiveData = null;
    
    public JobSeekerPersonalIntroInfoViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.findajob.jobamax.model.JobSeeker> getJobSeekerObserver() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    public final void getJobSeeker() {
    }
    
    public final void submitData(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel personalInfoModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
}