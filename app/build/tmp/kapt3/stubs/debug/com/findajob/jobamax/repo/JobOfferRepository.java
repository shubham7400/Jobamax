package com.findajob.jobamax.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u00122\u0006\u0010\u0015\u001a\u00020\nJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0016\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aJ \u0010\u001b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001d \u0014*\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c0\u001c0\u0012J \u0010\u001e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001d \u0014*\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c0\u001c0\u0012J&\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020%J\u001c\u0010&\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\'0\'0\u00122\u0006\u0010(\u001a\u00020\nJ \u0010)\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001d \u0014*\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c0\u001c0\u0012J\u0014\u0010*\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u001d0\u001d0\u0012J\u001c\u0010+\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010,0,0\u00122\u0006\u0010-\u001a\u00020\nJ\u0012\u0010.\u001a\u0004\u0018\u00010 2\u0006\u0010/\u001a\u00020\nH\u0002J\u000e\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u001dJ\u0016\u00102\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020%J\u0016\u00103\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020%J\u0016\u00104\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020%J\u0016\u00105\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020%J\u0016\u00106\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020%J\u001c\u00107\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020%2\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09J\u001c\u0010;\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020%2\f\u00108\u001a\b\u0012\u0004\u0012\u00020<09J\u001c\u0010=\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020%2\f\u00108\u001a\b\u0012\u0004\u0012\u00020>09J$\u0010?\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020%2\f\u00108\u001a\b\u0012\u0004\u0012\u00020@09J\u001c\u0010A\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020%2\f\u00108\u001a\b\u0012\u0004\u0012\u00020B09J\u0010\u0010C\u001a\u00020\u00172\u0006\u0010D\u001a\u00020\u001dH\u0002J$\u0010E\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\n0\n0\u00122\u0006\u00101\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\u001dJ\u001c\u0010G\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u00122\u0006\u0010\u0015\u001a\u00020\nJ\u0010\u0010H\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\nH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lcom/findajob/jobamax/repo/JobOfferRepository;", "", "()V", "currentUser", "Lcom/parse/ParseUser;", "getCurrentUser", "()Lcom/parse/ParseUser;", "currentUser$delegate", "Lkotlin/Lazy;", "currentUserId", "", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId$delegate", "defaultScope", "Lkotlinx/coroutines/CoroutineScope;", "ioScope", "archiveJobOffer", "Lio/reactivex/Single;", "", "kotlin.jvm.PlatformType", "jobOfferId", "archiveMessageWithThisJob", "", "get", "callback", "Lcom/findajob/jobamax/repo/GetJobOfferCallback;", "getActiveJobOffer", "", "Lcom/parse/ParseObject;", "getAll", "jobSeeker", "Lcom/findajob/jobamax/model/JobSeeker;", "currentLocation", "Lcom/parse/ParseGeoPoint;", "index", "", "Lcom/findajob/jobamax/repo/GetAllJobOfferCallback;", "getAppliedJobs", "Lcom/findajob/jobamax/jobseeker/track/JobSeekerTrackState;", "jobSeekerObjectId", "getArchivedJobOffer", "getCurrentRecruiterObject", "getJobOfferByObjectId", "Lcom/findajob/jobamax/model/JobOffer;", "objectId", "getJobSeekerByUserId", "userId", "increaseJobSwipe", "jobOffer", "loadAdzunaJobOffers", "loadJobsPikrJobOffers", "loadJoobleJobOffers", "loadRemotiveJobOffers", "loadUSAJobsJobOffers", "processAdzunaResponse", "response", "Lretrofit2/Response;", "Lcom/findajob/jobamax/model/JobOfferAdzuna;", "processJobsPikrResponse", "Lcom/findajob/jobamax/model/JobOfferJobsPikr;", "processJoobleResponse", "Lcom/findajob/jobamax/model/JobOfferJooble;", "processRemotiveResponse", "Lcom/findajob/jobamax/model/JobOfferRemotive;", "processUsaJobsResponse", "Lcom/findajob/jobamax/model/JobOfferUsaJobs;", "rejectAllJobSeekersOfAnOffer", "selectedJobOffer", "save", "recruiter", "unArchiveJobOffer", "unArchiveMessageWithThisJob", "app_debug"})
public final class JobOfferRepository {
    private final kotlinx.coroutines.CoroutineScope ioScope = null;
    private final kotlinx.coroutines.CoroutineScope defaultScope = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy currentUser$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy currentUserId$delegate = null;
    
    @javax.inject.Inject()
    public JobOfferRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseUser getCurrentUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.parse.ParseObject> getCurrentRecruiterObject() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.lang.String> save(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobOffer, @org.jetbrains.annotations.NotNull()
    com.parse.ParseObject recruiter) {
        return null;
    }
    
    public final void get(@org.jetbrains.annotations.NotNull()
    java.lang.String jobOfferId, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetJobOfferCallback callback) {
    }
    
    private final void archiveMessageWithThisJob(java.lang.String jobOfferId) {
    }
    
    private final void unArchiveMessageWithThisJob(java.lang.String jobOfferId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.findajob.jobamax.model.JobOffer> getJobOfferByObjectId(@org.jetbrains.annotations.NotNull()
    java.lang.String objectId) {
        return null;
    }
    
    private final void rejectAllJobSeekersOfAnOffer(com.parse.ParseObject selectedJobOffer) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.lang.Boolean> archiveJobOffer(@org.jetbrains.annotations.NotNull()
    java.lang.String jobOfferId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.lang.Boolean> unArchiveJobOffer(@org.jetbrains.annotations.NotNull()
    java.lang.String jobOfferId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.parse.ParseObject>> getAll() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.parse.ParseObject>> getActiveJobOffer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.parse.ParseObject>> getArchivedJobOffer() {
        return null;
    }
    
    private final com.findajob.jobamax.model.JobSeeker getJobSeekerByUserId(java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.findajob.jobamax.jobseeker.track.JobSeekerTrackState> getAppliedJobs(@org.jetbrains.annotations.NotNull()
    java.lang.String jobSeekerObjectId) {
        return null;
    }
    
    public final void getAll(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobSeeker jobSeeker, @org.jetbrains.annotations.NotNull()
    com.parse.ParseGeoPoint currentLocation, int index, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetAllJobOfferCallback callback) {
    }
    
    public final void increaseJobSwipe(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject jobOffer) {
    }
    
    public final void loadJobsPikrJobOffers(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobSeeker jobSeeker, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetAllJobOfferCallback callback) {
    }
    
    public final void processJobsPikrResponse(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetAllJobOfferCallback callback, @org.jetbrains.annotations.NotNull()
    retrofit2.Response<com.findajob.jobamax.model.JobOfferJobsPikr> response) {
    }
    
    public final void loadRemotiveJobOffers(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobSeeker jobSeeker, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetAllJobOfferCallback callback) {
    }
    
    public final void processRemotiveResponse(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobSeeker jobSeeker, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetAllJobOfferCallback callback, @org.jetbrains.annotations.NotNull()
    retrofit2.Response<com.findajob.jobamax.model.JobOfferRemotive> response) {
    }
    
    public final void loadUSAJobsJobOffers(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobSeeker jobSeeker, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetAllJobOfferCallback callback) {
    }
    
    public final void processUsaJobsResponse(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetAllJobOfferCallback callback, @org.jetbrains.annotations.NotNull()
    retrofit2.Response<com.findajob.jobamax.model.JobOfferUsaJobs> response) {
    }
    
    public final void loadJoobleJobOffers(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobSeeker jobSeeker, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetAllJobOfferCallback callback) {
    }
    
    public final void processJoobleResponse(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetAllJobOfferCallback callback, @org.jetbrains.annotations.NotNull()
    retrofit2.Response<com.findajob.jobamax.model.JobOfferJooble> response) {
    }
    
    public final void loadAdzunaJobOffers(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.JobSeeker jobSeeker, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetAllJobOfferCallback callback) {
    }
    
    public final void processAdzunaResponse(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.GetAllJobOfferCallback callback, @org.jetbrains.annotations.NotNull()
    retrofit2.Response<com.findajob.jobamax.model.JobOfferAdzuna> response) {
    }
}