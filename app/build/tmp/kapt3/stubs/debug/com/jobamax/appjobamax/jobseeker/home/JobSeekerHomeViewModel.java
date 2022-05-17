package com.jobamax.appjobamax.jobseeker.home;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0091\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J3\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2#\u0010I\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010K\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020F0JJC\u0010O\u001a\u00020F2\u0016\u0010P\u001a\u0012\u0012\u0004\u0012\u00020Q02j\b\u0012\u0004\u0012\u00020Q`32#\u0010I\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010K\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020F0JJ&\u0010R\u001a\u00020F2\b\u0010S\u001a\u0004\u0018\u00010\u000e2\u0014\u0010I\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010K\u0012\u0004\u0012\u00020F0JJ3\u0010T\u001a\u00020F2\u0006\u0010U\u001a\u00020V2#\u0010I\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010K\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020F0JJ3\u0010W\u001a\u00020F2\u0006\u0010X\u001a\u00020Y2#\u0010I\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010K\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020F0JJC\u0010Z\u001a\u00020F2\u0016\u0010[\u001a\u0012\u0012\u0004\u0012\u00020Q02j\b\u0012\u0004\u0012\u00020Q`32#\u0010I\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010K\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020F0JJ3\u0010\\\u001a\u00020F2\u0006\u0010]\u001a\u00020Q2#\u0010I\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010K\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020F0JJ\u000e\u0010^\u001a\u00020F2\u0006\u0010I\u001a\u00020_J\u000e\u0010`\u001a\u00020F2\u0006\u0010I\u001a\u00020aJ\u000e\u0010b\u001a\u00020F2\u0006\u0010I\u001a\u00020aJ\u000e\u0010c\u001a\u00020F2\u0006\u0010I\u001a\u00020aJ\u0006\u0010:\u001a\u00020FJ\u0006\u0010d\u001a\u00020FJ\u000e\u0010e\u001a\u00020F2\u0006\u0010I\u001a\u00020aJ\u000e\u0010f\u001a\u00020F2\u0006\u0010g\u001a\u00020QJ\u000e\u0010h\u001a\u00020F2\u0006\u0010g\u001a\u00020QJ3\u0010i\u001a\u00020F2\u0006\u0010j\u001a\u00020k2#\u0010I\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010K\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020F0JJC\u0010l\u001a\u00020F2\u0016\u0010m\u001a\u0012\u0012\u0004\u0012\u00020V02j\b\u0012\u0004\u0012\u00020V`32#\u0010I\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010K\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020F0JJ4\u0010n\u001a\u00020F2\u0016\u0010o\u001a\u0012\u0012\u0004\u0012\u00020H02j\b\u0012\u0004\u0012\u00020H`32\u0014\u0010I\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010K\u0012\u0004\u0012\u00020F0JJ4\u0010p\u001a\u00020F2\u0016\u0010q\u001a\u0012\u0012\u0004\u0012\u00020Y02j\b\u0012\u0004\u0012\u00020Y`32\u0014\u0010I\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010K\u0012\u0004\u0012\u00020F0JJ\u0016\u0010r\u001a\u00020F2\u0006\u0010s\u001a\u00020Q2\u0006\u0010I\u001a\u00020tJ4\u0010u\u001a\u00020F2\u0006\u0010v\u001a\u00020Q2\u0006\u0010w\u001a\u00020Q2\u0006\u0010x\u001a\u00020Q2\u0014\u0010I\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010K\u0012\u0004\u0012\u00020F0JJ\u000e\u0010y\u001a\u00020F2\u0006\u0010g\u001a\u00020QJ3\u0010z\u001a\u00020F2\u0006\u0010{\u001a\u00020|2#\u0010I\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010K\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020F0JJ3\u0010}\u001a\u00020F2\u0006\u0010~\u001a\u00020\u007f2#\u0010I\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010K\u00a2\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020F0JJ\"\u0010\u0080\u0001\u001a\u00020F2\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020Q2\u0007\u0010I\u001a\u00030\u0083\u0001J\u0010\u0010\u0084\u0001\u001a\u00020F2\u0007\u0010\u0081\u0001\u001a\u00020\u0007J\u0010\u0010\u0085\u0001\u001a\u00020F2\u0007\u0010\u0081\u0001\u001a\u00020\u0007J&\u0010\u0086\u0001\u001a\u00020F2\u0007\u0010\u0087\u0001\u001a\u00020\u000e2\u0014\u0010I\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010K\u0012\u0004\u0012\u00020F0JJ\u001a\u0010\u0088\u0001\u001a\u00020F2\b\u0010\u0089\u0001\u001a\u00030\u008a\u00012\u0007\u0010I\u001a\u00030\u008b\u0001JA\u0010\u008c\u0001\u001a\u00020F2\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u00012\u0015\u0010\u008f\u0001\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010K\u0012\u0004\u0012\u00020F0J2\u0015\u0010\u0090\u0001\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010Q\u0012\u0004\u0012\u00020F0JR!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00100\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001d\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u001a\u0010.\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010\u0019R*\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u000e02j\b\u0012\u0004\u0012\u00020\u000e`3X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0011\u00108\u001a\u0002098F\u00a2\u0006\u0006\u001a\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R#\u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00100\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010\u001dR\u0017\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010\u001d\u00a8\u0006\u0092\u0001"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/home/JobSeekerHomeViewModel;", "Lcom/jobamax/appjobamax/base/BaseAndroidViewModel;", "context", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_deleteAccountStatus", "Landroidx/lifecycle/MutableLiveData;", "", "get_deleteAccountStatus", "()Landroidx/lifecycle/MutableLiveData;", "_deleteAccountStatus$delegate", "Lkotlin/Lazy;", "_jobOfferLiveData", "", "Lcom/parse/ParseObject;", "_pushNotificationStateObserver", "Lkotlin/Pair;", "_selectedJobOffer", "getContext", "()Landroid/app/Application;", "currentIndex", "", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "deleteAccountLiveData", "Landroidx/lifecycle/LiveData;", "getDeleteAccountLiveData", "()Landroidx/lifecycle/LiveData;", "deleteAccountLiveData$delegate", "isJobOfferExhausted", "()Z", "setJobOfferExhausted", "(Z)V", "isJobSeekerUpdated", "setJobSeekerUpdated", "(Landroidx/lifecycle/MutableLiveData;)V", "jobOfferButtonCallback", "Lcom/jobamax/appjobamax/jobseeker/home/JobSeekerHomeViewModel$JobOfferButtonCallback;", "getJobOfferButtonCallback", "()Lcom/jobamax/appjobamax/jobseeker/home/JobSeekerHomeViewModel$JobOfferButtonCallback;", "setJobOfferButtonCallback", "(Lcom/jobamax/appjobamax/jobseeker/home/JobSeekerHomeViewModel$JobOfferButtonCallback;)V", "jobOfferLiveData", "getJobOfferLiveData", "jobOfferPageIndex", "getJobOfferPageIndex", "setJobOfferPageIndex", "jobOffers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getJobOffers", "()Ljava/util/ArrayList;", "setJobOffers", "(Ljava/util/ArrayList;)V", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/jobamax/appjobamax/model/JobSeeker;", "jobSeekerObject", "getJobSeekerObject", "()Lcom/parse/ParseObject;", "setJobSeekerObject", "(Lcom/parse/ParseObject;)V", "pushNotificationStateObserver", "getPushNotificationStateObserver", "selectedJobOffer", "getSelectedJobOffer", "addAndUpdateExperience", "", "experience", "Lcom/jobamax/appjobamax/jobseeker/profile/cv/model/Experience;", "callback", "Lkotlin/Function1;", "Lcom/parse/ParseException;", "Lkotlin/ParameterName;", "name", "it", "addInterestTags", "interestTags", "", "addJobToTack", "trackingJob", "addNewOrUpdateEducation", "education", "Lcom/jobamax/appjobamax/data/pojo/Education;", "addOrUpdateVolunteering", "volunteering", "Lcom/jobamax/appjobamax/jobseeker/profile/cv/model/Volunteering;", "addWorkSpace", "ownedWorkSpaces", "changePassword", "newPassword", "getCardDetails", "Lcom/jobamax/appjobamax/model/GetCardDetailsCallback;", "getExistingActivitiesTags", "Lcom/jobamax/appjobamax/model/GetAllUserCallback;", "getExistingHardSkillTags", "getExistingSoftSkillTags", "getPushNotificationState", "loadTrackingJob", "saveActivitiesTag", "tag", "saveHardSkillTag", "saveHardSkills", "hardSkillJsonObj", "Lorg/json/JSONObject;", "saveNewEducationList", "educations", "saveNewExperienceList", "experiences", "saveNewVolunteeringList", "volunteerings", "savePaymentMethod", "paymentMethodId", "Lcom/jobamax/appjobamax/model/SaveCardDetailsCallback;", "saveSocialMediaLinks", "instagramLink", "linkedInLink", "tikTokLink", "saveSoftSkillTag", "saveSoftSkills", "softSkillJsonArray", "Lorg/json/JSONArray;", "submitData", "personalInfoModel", "Lcom/jobamax/appjobamax/jobseeker/profile/account/personalInfo/JobSeekerPersonalInformationModel;", "updateFlag", "flag", "key", "Lcom/jobamax/appjobamax/model/UpdateUserCallback;", "updateMessagePushNotificationFlag", "updateNewsMatchesPushNotificationFlag", "updateWishlistJob", "parseObject", "uploadProfilePicUri", "profilePicUri", "Landroid/net/Uri;", "Lcom/jobamax/appjobamax/jobseeker/home/SaveParseObjectCallback;", "uploadUserAudio", "bytes", "", "onFailure", "onSuccess", "JobOfferButtonCallback", "app_debug"})
public final class JobSeekerHomeViewModel extends com.jobamax.appjobamax.base.BaseAndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject jobSeekerObject;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.parse.ParseObject> jobOffers;
    private int jobOfferPageIndex = 0;
    private boolean isJobOfferExhausted = false;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.parse.ParseObject>> _jobOfferLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> jobOfferLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isJobSeekerUpdated;
    private int currentIndex = 0;
    @org.jetbrains.annotations.NotNull()
    private com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel.JobOfferButtonCallback jobOfferButtonCallback = com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel.JobOfferButtonCallback.NONE;
    private final androidx.lifecycle.MutableLiveData<com.parse.ParseObject> _selectedJobOffer = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.parse.ParseObject> selectedJobOffer = null;
    private final androidx.lifecycle.MutableLiveData<kotlin.Pair<java.lang.Boolean, java.lang.Boolean>> _pushNotificationStateObserver = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<kotlin.Pair<java.lang.Boolean, java.lang.Boolean>> pushNotificationStateObserver = null;
    private final kotlin.Lazy _deleteAccountStatus$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy deleteAccountLiveData$delegate = null;
    
    @javax.inject.Inject()
    public JobSeekerHomeViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
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
    public final com.jobamax.appjobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.parse.ParseObject>> getJobOfferLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isJobSeekerUpdated() {
        return null;
    }
    
    public final void setJobSeekerUpdated(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    public final int getCurrentIndex() {
        return 0;
    }
    
    public final void setCurrentIndex(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel.JobOfferButtonCallback getJobOfferButtonCallback() {
        return null;
    }
    
    public final void setJobOfferButtonCallback(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel.JobOfferButtonCallback p0) {
    }
    
    public final void getJobSeeker() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.parse.ParseObject> getSelectedJobOffer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<kotlin.Pair<java.lang.Boolean, java.lang.Boolean>> getPushNotificationStateObserver() {
        return null;
    }
    
    public final void getPushNotificationState() {
    }
    
    public final void updateMessagePushNotificationFlag(boolean flag) {
    }
    
    public final void updateNewsMatchesPushNotificationFlag(boolean flag) {
    }
    
    public final void updateFlag(boolean flag, @org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.UpdateUserCallback callback) {
    }
    
    public final void submitData(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel personalInfoModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void uploadProfilePicUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri profilePicUri, @org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.home.SaveParseObjectCallback callback) {
    }
    
    public final void savePaymentMethod(@org.jetbrains.annotations.NotNull()
    java.lang.String paymentMethodId, @org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.SaveCardDetailsCallback callback) {
    }
    
    public final void getCardDetails(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.GetCardDetailsCallback callback) {
    }
    
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> get_deleteAccountStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getDeleteAccountLiveData() {
        return null;
    }
    
    public final void changePassword(@org.jetbrains.annotations.NotNull()
    java.lang.String newPassword, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void addNewOrUpdateEducation(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.data.pojo.Education education, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void saveNewEducationList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.data.pojo.Education> educations, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void saveHardSkills(@org.jetbrains.annotations.NotNull()
    org.json.JSONObject hardSkillJsonObj, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void saveSoftSkills(@org.jetbrains.annotations.NotNull()
    org.json.JSONArray softSkillJsonArray, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void addWorkSpace(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> ownedWorkSpaces, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void addInterestTags(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> interestTags, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void addAndUpdateExperience(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.profile.cv.model.Experience experience, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void saveNewExperienceList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.jobseeker.profile.cv.model.Experience> experiences, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void getExistingHardSkillTags(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.GetAllUserCallback callback) {
    }
    
    public final void saveHardSkillTag(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    public final void getExistingSoftSkillTags(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.GetAllUserCallback callback) {
    }
    
    public final void saveSoftSkillTag(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    public final void getExistingActivitiesTags(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.GetAllUserCallback callback) {
    }
    
    public final void saveActivitiesTag(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    public final void saveSocialMediaLinks(@org.jetbrains.annotations.NotNull()
    java.lang.String instagramLink, @org.jetbrains.annotations.NotNull()
    java.lang.String linkedInLink, @org.jetbrains.annotations.NotNull()
    java.lang.String tikTokLink, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void updateWishlistJob(@org.jetbrains.annotations.NotNull()
    com.parse.ParseObject parseObject, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void addJobToTack(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject trackingJob, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void uploadUserAudio(@org.jetbrains.annotations.Nullable()
    byte[] bytes, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> onFailure, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSuccess) {
    }
    
    public final void loadTrackingJob(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.GetAllUserCallback callback) {
    }
    
    public final void addOrUpdateVolunteering(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.profile.cv.model.Volunteering volunteering, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    public final void saveNewVolunteeringList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.jobseeker.profile.cv.model.Volunteering> volunteerings, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/home/JobSeekerHomeViewModel$JobOfferButtonCallback;", "", "(Ljava/lang/String;I)V", "NONE", "CHAT", "REJECT", "ACCEPT", "app_debug"})
    public static enum JobOfferButtonCallback {
        /*public static final*/ NONE /* = new NONE() */,
        /*public static final*/ CHAT /* = new CHAT() */,
        /*public static final*/ REJECT /* = new REJECT() */,
        /*public static final*/ ACCEPT /* = new ACCEPT() */;
        
        JobOfferButtonCallback() {
        }
    }
}