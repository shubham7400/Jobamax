package com.findajob.jobamax.jobseeker.home;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u00d6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u008a\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0012\u0010[\u001a\u00020\\2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010^J\u000e\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020aJ\u0012\u0010b\u001a\u0004\u0018\u00010\u00122\b\u0010c\u001a\u0004\u0018\u00010\u0012J\u0006\u0010I\u001a\u00020\\J\u0006\u0010d\u001a\u00020\\J\u0006\u0010W\u001a\u00020eJ\u0006\u0010f\u001a\u00020\\J\u0006\u0010g\u001a\u00020\\J\u0006\u0010h\u001a\u00020\\J\u0006\u0010i\u001a\u00020\\J\u000e\u0010j\u001a\u00020e2\u0006\u0010k\u001a\u00020\u0014J\u0016\u0010l\u001a\u00020\\2\u0006\u0010m\u001a\u00020^2\u0006\u0010`\u001a\u00020nJ3\u0010o\u001a\u00020\\2\u0006\u0010p\u001a\u00020q2#\u0010`\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010s\u00a2\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(v\u0012\u0004\u0012\u00020\\0rJ\u0016\u0010w\u001a\u00020e2\u0006\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020yJ\u001e\u0010{\u001a\u00020\\2\u0006\u0010|\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020^2\u0006\u0010`\u001a\u00020~J\u000e\u0010\u007f\u001a\u00020e2\u0006\u0010|\u001a\u00020\u000bJ\u000f\u0010\u0080\u0001\u001a\u00020e2\u0006\u0010|\u001a\u00020\u000bJ\u0018\u0010\u0081\u0001\u001a\u00020\\2\u0007\u0010\u0082\u0001\u001a\u00020\u001d2\u0006\u0010`\u001a\u00020~J6\u0010\u0083\u0001\u001a\u00020\\2\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012#\u0010`\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010s\u00a2\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(v\u0012\u0004\u0012\u00020\\0rJ\u001a\u0010\u0086\u0001\u001a\u00020\\2\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0007\u0010`\u001a\u00030\u0089\u0001R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00180\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R!\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0)8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010\u000f\u001a\u0004\b*\u0010+R\u001a\u0010-\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b&\u0010/R\u001a\u00100\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010.\"\u0004\b1\u0010/R\u001a\u00102\u001a\u000203X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001d\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110)\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010+R\u001a\u0010:\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R \u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120@X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00140)\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010+R\u0011\u0010G\u001a\u00020H8F\u00a2\u0006\u0006\u001a\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00160\n\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010\rR#\u0010T\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00180)\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010+R\u0017\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00120)\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010+R\u001a\u0010X\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010%\"\u0004\bZ\u0010\'\u00a8\u0006\u008b\u0001"}, d2 = {"Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "Lcom/findajob/jobamax/base/BaseAndroidViewModel;", "context", "Landroid/app/Application;", "jobSeekerRepo", "Lcom/findajob/jobamax/repo/JobSeekerRepo;", "jobOfferRepo", "Lcom/findajob/jobamax/repo/JobOfferRepository;", "(Landroid/app/Application;Lcom/findajob/jobamax/repo/JobSeekerRepo;Lcom/findajob/jobamax/repo/JobOfferRepository;)V", "_deleteAccountStatus", "Landroidx/lifecycle/MutableLiveData;", "", "get_deleteAccountStatus", "()Landroidx/lifecycle/MutableLiveData;", "_deleteAccountStatus$delegate", "Lkotlin/Lazy;", "_jobOfferLiveData", "", "Lcom/parse/ParseObject;", "_jobSearchStateObservable", "Lcom/findajob/jobamax/jobseeker/profile/jobSearch/JobSearchState;", "_jobSeekerTrackStateLiveData", "Lcom/findajob/jobamax/jobseeker/track/JobSeekerTrackState;", "_pushNotificationStateObserver", "Lkotlin/Pair;", "_selectedJobOffer", "getContext", "()Landroid/app/Application;", "currentIndex", "", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "currentLocation", "Lcom/parse/ParseGeoPoint;", "getCurrentLocation", "()Lcom/parse/ParseGeoPoint;", "setCurrentLocation", "(Lcom/parse/ParseGeoPoint;)V", "deleteAccountLiveData", "Landroidx/lifecycle/LiveData;", "getDeleteAccountLiveData", "()Landroidx/lifecycle/LiveData;", "deleteAccountLiveData$delegate", "isCurrentLocation", "()Z", "(Z)V", "isJobOfferExhausted", "setJobOfferExhausted", "jobOfferButtonCallback", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel$JobOfferButtonCallback;", "getJobOfferButtonCallback", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel$JobOfferButtonCallback;", "setJobOfferButtonCallback", "(Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel$JobOfferButtonCallback;)V", "jobOfferLiveData", "getJobOfferLiveData", "jobOfferPageIndex", "getJobOfferPageIndex", "setJobOfferPageIndex", "getJobOfferRepo", "()Lcom/findajob/jobamax/repo/JobOfferRepository;", "jobOffers", "Ljava/util/ArrayList;", "getJobOffers", "()Ljava/util/ArrayList;", "setJobOffers", "(Ljava/util/ArrayList;)V", "jobSearchStateObservable", "getJobSearchStateObservable", "jobSeeker", "Lcom/findajob/jobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/findajob/jobamax/model/JobSeeker;", "jobSeekerObject", "getJobSeekerObject", "()Lcom/parse/ParseObject;", "setJobSeekerObject", "(Lcom/parse/ParseObject;)V", "getJobSeekerRepo", "()Lcom/findajob/jobamax/repo/JobSeekerRepo;", "jobSeekerTrackStateLiveData", "getJobSeekerTrackStateLiveData", "pushNotificationStateObserver", "getPushNotificationStateObserver", "selectedJobOffer", "getSelectedJobOffer", "selectedLocation", "getSelectedLocation", "setSelectedLocation", "deleteAccount", "", "reasons", "", "getCardDetails", "callback", "Lcom/findajob/jobamax/model/GetCardDetailsCallback;", "getCompanyFromJobOffer", "jobOfferParseObject", "getPushNotificationState", "Lkotlinx/coroutines/Job;", "loadAllJobOffers", "loadAppliedJobs", "loadJobOffers", "saveJobSearch", "saveJobSearchState", "jobSearchState", "savePaymentMethod", "paymentMethodId", "Lcom/findajob/jobamax/model/SaveCardDetailsCallback;", "submitData", "personalInfoModel", "Lcom/findajob/jobamax/jobseeker/profile/account/personalInfo/JobSeekerPersonalInformationModel;", "Lkotlin/Function1;", "Lcom/parse/ParseException;", "Lkotlin/ParameterName;", "name", "it", "submitLocation", "lat", "", "lng", "updateFlag", "flag", "key", "Lcom/findajob/jobamax/model/UpdateUserCallback;", "updateMessagePushNotificationFlag", "updateNewsMatchesPushNotificationFlag", "updateReachCount", "reachCount", "updateSocialMediaLinks", "socialMedia", "Lcom/findajob/jobamax/jobseeker/profile/account/social/JobSeekerSocialAccountModel;", "uploadProfilePicUri", "profilePicUri", "Landroid/net/Uri;", "Lcom/findajob/jobamax/repo/SaveParseObjectCallback;", "JobOfferButtonCallback", "app_debug"})
public final class JobSeekerHomeViewModel extends com.findajob.jobamax.base.BaseAndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.repo.JobSeekerRepo jobSeekerRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.repo.JobOfferRepository jobOfferRepo = null;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject jobSeekerObject;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.parse.ParseObject> jobOffers;
    private int jobOfferPageIndex = 0;
    private boolean isJobOfferExhausted = false;
    @org.jetbrains.annotations.NotNull()
    private com.parse.ParseGeoPoint selectedLocation;
    @org.jetbrains.annotations.NotNull()
    private com.parse.ParseGeoPoint currentLocation;
    private boolean isCurrentLocation = true;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.parse.ParseObject>> _jobOfferLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> jobOfferLiveData = null;
    private int currentIndex = 0;
    @org.jetbrains.annotations.NotNull()
    private com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel.JobOfferButtonCallback jobOfferButtonCallback = com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel.JobOfferButtonCallback.NONE;
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.jobseeker.track.JobSeekerTrackState> _jobSeekerTrackStateLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.jobseeker.track.JobSeekerTrackState> jobSeekerTrackStateLiveData = null;
    private final androidx.lifecycle.MutableLiveData<com.parse.ParseObject> _selectedJobOffer = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.parse.ParseObject> selectedJobOffer = null;
    private final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Boolean, java.lang.Boolean>> _pushNotificationStateObserver = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<kotlin.Pair<java.lang.Boolean, java.lang.Boolean>> pushNotificationStateObserver = null;
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState> _jobSearchStateObservable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState> jobSearchStateObservable = null;
    private final kotlin.Lazy _deleteAccountStatus$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy deleteAccountLiveData$delegate = null;
    
    @javax.inject.Inject()
    public JobSeekerHomeViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application context, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.JobSeekerRepo jobSeekerRepo, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.JobOfferRepository jobOfferRepo) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.repo.JobSeekerRepo getJobSeekerRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.repo.JobOfferRepository getJobOfferRepo() {
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
    public final java.util.ArrayList<com.parse.ParseObject> getJobOffers() {
        return null;
    }
    
    public final void setJobOffers(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.parse.ParseObject> p0) {
    }
    
    public final int getJobOfferPageIndex() {
        return 0;
    }
    
    public final void setJobOfferPageIndex(int p0) {
    }
    
    public final boolean isJobOfferExhausted() {
        return false;
    }
    
    public final void setJobOfferExhausted(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseGeoPoint getSelectedLocation() {
        return null;
    }
    
    public final void setSelectedLocation(@org.jetbrains.annotations.NotNull()
    com.parse.ParseGeoPoint p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.parse.ParseGeoPoint getCurrentLocation() {
        return null;
    }
    
    public final void setCurrentLocation(@org.jetbrains.annotations.NotNull()
    com.parse.ParseGeoPoint p0) {
    }
    
    public final boolean isCurrentLocation() {
        return false;
    }
    
    public final void setCurrentLocation(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> getJobOfferLiveData() {
        return null;
    }
    
    public final int getCurrentIndex() {
        return 0;
    }
    
    public final void setCurrentIndex(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel.JobOfferButtonCallback getJobOfferButtonCallback() {
        return null;
    }
    
    public final void setJobOfferButtonCallback(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel.JobOfferButtonCallback p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.jobseeker.track.JobSeekerTrackState> getJobSeekerTrackStateLiveData() {
        return null;
    }
    
    public final void getJobSeeker() {
    }
    
    public final void loadAppliedJobs() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.parse.ParseObject> getSelectedJobOffer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getSelectedJobOffer() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getCompanyFromJobOffer(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject jobOfferParseObject) {
        return null;
    }
    
    public final void loadJobOffers() {
    }
    
    /**
     * load Jobamax, Adzuna, and Remotive job offers
     */
    public final void loadAllJobOffers() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kotlin.Pair<java.lang.Boolean, java.lang.Boolean>> getPushNotificationStateObserver() {
        return null;
    }
    
    public final void getPushNotificationState() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateMessagePushNotificationFlag(boolean flag) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateNewsMatchesPushNotificationFlag(boolean flag) {
        return null;
    }
    
    public final void updateFlag(boolean flag, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.UpdateUserCallback callback) {
    }
    
    public final void submitData(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel personalInfoModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void updateSocialMediaLinks(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.account.social.JobSeekerSocialAccountModel socialMedia, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void updateReachCount(int reachCount, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.UpdateUserCallback callback) {
    }
    
    public final void uploadProfilePicUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri profilePicUri, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveParseObjectCallback callback) {
    }
    
    public final void savePaymentMethod(@org.jetbrains.annotations.NotNull()
    java.lang.String paymentMethodId, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.SaveCardDetailsCallback callback) {
    }
    
    public final void getCardDetails(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.GetCardDetailsCallback callback) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState> getJobSearchStateObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job saveJobSearchState(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState jobSearchState) {
        return null;
    }
    
    public final void saveJobSearch() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job submitLocation(double lat, double lng) {
        return null;
    }
    
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> get_deleteAccountStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getDeleteAccountLiveData() {
        return null;
    }
    
    public final void deleteAccount(@org.jetbrains.annotations.Nullable()
    java.lang.String reasons) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel$JobOfferButtonCallback;", "", "(Ljava/lang/String;I)V", "NONE", "CHAT", "REJECT", "ACCEPT", "app_debug"})
    public static enum JobOfferButtonCallback {
        /*public static final*/ NONE /* = new NONE() */,
        /*public static final*/ CHAT /* = new CHAT() */,
        /*public static final*/ REJECT /* = new REJECT() */,
        /*public static final*/ ACCEPT /* = new ACCEPT() */;
        
        JobOfferButtonCallback() {
        }
    }
}