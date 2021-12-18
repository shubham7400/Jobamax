package com.findajob.jobamax.jobseeker.track;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019J\u0006\u0010#\u001a\u00020!J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0%J\u0016\u0010&\u001a\u00020!2\u0006\u0010\'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010)\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019J\u0006\u0010*\u001a\u00020!J\u000e\u0010+\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006,"}, d2 = {"Lcom/findajob/jobamax/jobseeker/track/JobSeekerApplyViewModel;", "Lcom/findajob/jobamax/base/BaseAndroidViewModel;", "context", "Landroid/app/Application;", "jobOfferRepo", "Lcom/findajob/jobamax/repo/JobOfferRepository;", "fcmRepo", "Lcom/findajob/jobamax/repo/FCMRepo;", "messageRepository", "Lcom/findajob/jobamax/repo/MessageRepository;", "(Landroid/app/Application;Lcom/findajob/jobamax/repo/JobOfferRepository;Lcom/findajob/jobamax/repo/FCMRepo;Lcom/findajob/jobamax/repo/MessageRepository;)V", "getContext", "()Landroid/app/Application;", "externalJobUrlLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getFcmRepo", "()Lcom/findajob/jobamax/repo/FCMRepo;", "getJobOfferRepo", "()Lcom/findajob/jobamax/repo/JobOfferRepository;", "jobSeeker", "Lcom/findajob/jobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/findajob/jobamax/model/JobSeeker;", "jobSeekerObject", "Lcom/parse/ParseObject;", "getJobSeekerObject", "()Lcom/parse/ParseObject;", "setJobSeekerObject", "(Lcom/parse/ParseObject;)V", "getMessageRepository", "()Lcom/findajob/jobamax/repo/MessageRepository;", "acceptJob", "", "jobOffer", "decrementReach", "getExternalJobObserver", "Landroidx/lifecycle/LiveData;", "matchUser", "roleType", "receiverObjectId", "rejectJob", "setJobUrlEmpty", "undoJob", "app_debug"})
public final class JobSeekerApplyViewModel extends com.findajob.jobamax.base.BaseAndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.repo.JobOfferRepository jobOfferRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.repo.FCMRepo fcmRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.repo.MessageRepository messageRepository = null;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject jobSeekerObject;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> externalJobUrlLiveData = null;
    
    @javax.inject.Inject()
    public JobSeekerApplyViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application context, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.JobOfferRepository jobOfferRepo, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.FCMRepo fcmRepo, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.MessageRepository messageRepository) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.repo.JobOfferRepository getJobOfferRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.repo.FCMRepo getFcmRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.repo.MessageRepository getMessageRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getJobSeekerObject() {
        return null;
    }
    
    public final void setJobSeekerObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getExternalJobObserver() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    public final void acceptJob(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobOffer) {
    }
    
    public final void setJobUrlEmpty() {
    }
    
    public final void matchUser(@org.jetbrains.annotations.NotNull()
    java.lang.String roleType, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverObjectId) {
    }
    
    public final void decrementReach() {
    }
    
    public final void rejectJob(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobOffer) {
    }
    
    public final void undoJob(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobOffer) {
    }
}