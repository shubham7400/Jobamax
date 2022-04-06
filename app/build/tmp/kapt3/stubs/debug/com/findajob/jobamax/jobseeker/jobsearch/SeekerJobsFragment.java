package com.findajob.jobamax.jobseeker.jobsearch;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010d\u001a\u00020eH\u0002J\u0010\u0010f\u001a\u00020e2\u0006\u0010g\u001a\u00020AH\u0002J\b\u0010h\u001a\u00020eH\u0002J\b\u0010i\u001a\u00020eH\u0003J\b\u0010j\u001a\u00020eH\u0002J\b\u0010k\u001a\u00020eH\u0002J\b\u0010l\u001a\u00020eH\u0002J\b\u0010]\u001a\u00020mH\u0014J\"\u0010n\u001a\u00020e2\u0006\u0010o\u001a\u00020A2\u0006\u0010p\u001a\u00020A2\b\u0010q\u001a\u0004\u0018\u00010rH\u0016J$\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\b\u0010w\u001a\u0004\u0018\u00010x2\b\u0010y\u001a\u0004\u0018\u00010zH\u0017J\u0012\u0010{\u001a\u00020e2\b\u0010|\u001a\u0004\u0018\u00010zH\u0014J\b\u0010}\u001a\u00020eH\u0016J\b\u0010~\u001a\u00020eH\u0016J\u0010\u0010\u007f\u001a\u00020e2\u0006\u0010g\u001a\u00020AH\u0002J\t\u0010\u0080\u0001\u001a\u00020eH\u0002J\b\u0010\u0014\u001a\u00020eH\u0002J\t\u0010\u0081\u0001\u001a\u00020eH\u0002J\t\u0010\u0082\u0001\u001a\u00020eH\u0003J\t\u0010\u0083\u0001\u001a\u00020eH\u0002J\b\u0010 \u001a\u00020eH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020e2\u0007\u0010\u0085\u0001\u001a\u00020/H\u0002J\t\u0010\u0086\u0001\u001a\u00020eH\u0002J\t\u0010\u0087\u0001\u001a\u00020eH\u0002J\t\u0010\u0088\u0001\u001a\u00020eH\u0002J\t\u0010\u0089\u0001\u001a\u00020eH\u0002J\u0012\u0010\u008a\u0001\u001a\u00020e2\u0007\u0010\u008b\u0001\u001a\u00020(H\u0002J\t\u0010\u008c\u0001\u001a\u00020eH\u0002J\t\u0010\u008d\u0001\u001a\u00020eH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R\u001c\u0010\'\u001a\u0004\u0018\u00010(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u00010(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R\u001a\u00107\u001a\u000208X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R \u0010=\u001a\b\u0012\u0004\u0012\u00020(0.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u00101\"\u0004\b?\u00103R\u0014\u0010@\u001a\u00020A8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010CR \u0010D\u001a\b\u0012\u0004\u0012\u00020(0.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u00101\"\u0004\bF\u00103R\u001c\u0010G\u001a\u0004\u0018\u00010/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010*\"\u0004\bN\u0010,R\u001a\u0010O\u001a\u00020PX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001c\u0010U\u001a\u0004\u0018\u00010/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010I\"\u0004\bW\u0010KR\u001c\u0010X\u001a\u0004\u0018\u00010(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010*\"\u0004\bZ\u0010,R\u001b\u0010[\u001a\u00020\\8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b_\u0010`\u001a\u0004\b]\u0010^R \u0010a\u001a\b\u0012\u0004\u0012\u00020(0.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u00101\"\u0004\bc\u00103\u00a8\u0006\u008e\u0001"}, d2 = {"Lcom/findajob/jobamax/jobseeker/jobsearch/SeekerJobsFragment;", "Lcom/findajob/jobamax/base/BaseFragmentMain;", "Lcom/findajob/jobamax/databinding/FragmentSeekerJobsBinding;", "()V", "adapter", "Lcom/findajob/jobamax/jobseeker/jobsearch/SeekerJobCardStackAdapter;", "getAdapter", "()Lcom/findajob/jobamax/jobseeker/jobsearch/SeekerJobCardStackAdapter;", "setAdapter", "(Lcom/findajob/jobamax/jobseeker/jobsearch/SeekerJobCardStackAdapter;)V", "cardStackLayoutManager", "Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;", "getCardStackLayoutManager", "()Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;", "setCardStackLayoutManager", "(Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;)V", "cardStackListener", "Lcom/yuyakaido/android/cardstackview/CardStackListener;", "getCardStackListener", "()Lcom/yuyakaido/android/cardstackview/CardStackListener;", "setCardStackListener", "(Lcom/yuyakaido/android/cardstackview/CardStackListener;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "hardSkillAdapter", "Lcom/findajob/jobamax/jobseeker/jobsearch/SeekerJobHardSkillAdapter;", "getHardSkillAdapter", "()Lcom/findajob/jobamax/jobseeker/jobsearch/SeekerJobHardSkillAdapter;", "setHardSkillAdapter", "(Lcom/findajob/jobamax/jobseeker/jobsearch/SeekerJobHardSkillAdapter;)V", "isJobTitleSelected", "", "()Z", "setJobTitleSelected", "(Z)V", "jobOfferId", "", "getJobOfferId", "()Ljava/lang/String;", "setJobOfferId", "(Ljava/lang/String;)V", "jobOfferList", "Ljava/util/ArrayList;", "Lcom/findajob/jobamax/model/NewJobOffer;", "getJobOfferList", "()Ljava/util/ArrayList;", "setJobOfferList", "(Ljava/util/ArrayList;)V", "jobSeekerId", "getJobSeekerId", "setJobSeekerId", "jobTitleAdapter", "Lcom/findajob/jobamax/jobseeker/jobsearch/SeekerJobTitleAdapter;", "getJobTitleAdapter", "()Lcom/findajob/jobamax/jobseeker/jobsearch/SeekerJobTitleAdapter;", "setJobTitleAdapter", "(Lcom/findajob/jobamax/jobseeker/jobsearch/SeekerJobTitleAdapter;)V", "jobTitles", "getJobTitles", "setJobTitles", "layoutRes", "", "getLayoutRes", "()I", "refuseJobsId", "getRefuseJobsId", "setRefuseJobsId", "rewindJobOffer", "getRewindJobOffer", "()Lcom/findajob/jobamax/model/NewJobOffer;", "setRewindJobOffer", "(Lcom/findajob/jobamax/model/NewJobOffer;)V", "rewindJobOfferId", "getRewindJobOfferId", "setRewindJobOfferId", "runnable", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "swipedJobOffer", "getSwipedJobOffer", "setSwipedJobOffer", "topJobOfferId", "getTopJobOfferId", "setTopJobOfferId", "viewModel", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "getViewModel", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "wishlistAddedJobsId", "getWishlistAddedJobsId", "setWishlistAddedJobsId", "addJobTitle", "", "addToRefuseJob", "type", "addToWishlistJob", "configureUi", "getCurrent", "getJobOffers", "getJobTypes", "Landroidx/lifecycle/ViewModel;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreated", "savedInstance", "onPause", "onResume", "removeJobFromRefuse", "removeJobFromWishlist", "setCardStackView", "setClickListeners", "setFilterStateIcon", "setJobInfo", "job", "setJobKeyword", "setJobTypeRecyclerview", "setMatchPercentage", "shareJob", "updateJobFilter", "searchString", "updateJobs", "viewModelObserver", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class SeekerJobsFragment extends com.findajob.jobamax.base.BaseFragmentMain<com.findajob.jobamax.databinding.FragmentSeekerJobsBinding> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.findajob.jobamax.jobseeker.jobsearch.SeekerJobHardSkillAdapter hardSkillAdapter;
    public com.findajob.jobamax.jobseeker.jobsearch.SeekerJobCardStackAdapter adapter;
    public com.yuyakaido.android.cardstackview.CardStackLayoutManager cardStackLayoutManager;
    public com.yuyakaido.android.cardstackview.CardStackListener cardStackListener;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.findajob.jobamax.model.NewJobOffer> jobOfferList;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String topJobOfferId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String rewindJobOfferId;
    @org.jetbrains.annotations.Nullable()
    private com.findajob.jobamax.model.NewJobOffer swipedJobOffer;
    @org.jetbrains.annotations.Nullable()
    private com.findajob.jobamax.model.NewJobOffer rewindJobOffer;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> wishlistAddedJobsId;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> refuseJobsId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String jobSeekerId = "";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String jobOfferId = "";
    public com.findajob.jobamax.jobseeker.jobsearch.SeekerJobTitleAdapter jobTitleAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> jobTitles;
    private boolean isJobTitleSelected = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.Runnable runnable;
    @org.jetbrains.annotations.NotNull()
    private android.os.Handler handler;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerJobsFragment() {
        super();
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.jobsearch.SeekerJobHardSkillAdapter getHardSkillAdapter() {
        return null;
    }
    
    public final void setHardSkillAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.jobsearch.SeekerJobHardSkillAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.jobsearch.SeekerJobCardStackAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.jobsearch.SeekerJobCardStackAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.yuyakaido.android.cardstackview.CardStackLayoutManager getCardStackLayoutManager() {
        return null;
    }
    
    public final void setCardStackLayoutManager(@org.jetbrains.annotations.NotNull()
    com.yuyakaido.android.cardstackview.CardStackLayoutManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.yuyakaido.android.cardstackview.CardStackListener getCardStackListener() {
        return null;
    }
    
    public final void setCardStackListener(@org.jetbrains.annotations.NotNull()
    com.yuyakaido.android.cardstackview.CardStackListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.findajob.jobamax.model.NewJobOffer> getJobOfferList() {
        return null;
    }
    
    public final void setJobOfferList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.model.NewJobOffer> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTopJobOfferId() {
        return null;
    }
    
    public final void setTopJobOfferId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRewindJobOfferId() {
        return null;
    }
    
    public final void setRewindJobOfferId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.findajob.jobamax.model.NewJobOffer getSwipedJobOffer() {
        return null;
    }
    
    public final void setSwipedJobOffer(@org.jetbrains.annotations.Nullable()
    com.findajob.jobamax.model.NewJobOffer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.findajob.jobamax.model.NewJobOffer getRewindJobOffer() {
        return null;
    }
    
    public final void setRewindJobOffer(@org.jetbrains.annotations.Nullable()
    com.findajob.jobamax.model.NewJobOffer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getWishlistAddedJobsId() {
        return null;
    }
    
    public final void setWishlistAddedJobsId(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getRefuseJobsId() {
        return null;
    }
    
    public final void setRefuseJobsId(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getJobSeekerId() {
        return null;
    }
    
    public final void setJobSeekerId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getJobOfferId() {
        return null;
    }
    
    public final void setJobOfferId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.jobsearch.SeekerJobTitleAdapter getJobTitleAdapter() {
        return null;
    }
    
    public final void setJobTitleAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.jobsearch.SeekerJobTitleAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getJobTitles() {
        return null;
    }
    
    public final void setJobTitles(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    public final boolean isJobTitleSelected() {
        return false;
    }
    
    public final void setJobTitleSelected(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Runnable getRunnable() {
        return null;
    }
    
    public final void setRunnable(@org.jetbrains.annotations.NotNull()
    java.lang.Runnable p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.Handler getHandler() {
        return null;
    }
    
    public final void setHandler(@org.jetbrains.annotations.NotNull()
    android.os.Handler p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final void configureUi() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    private final void setJobKeyword() {
    }
    
    private final void setJobTypeRecyclerview() {
    }
    
    private final void setFilterStateIcon() {
    }
    
    private final void viewModelObserver() {
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstance) {
    }
    
    private final void getCurrent() {
    }
    
    private final void getJobOffers() {
    }
    
    private final void setMatchPercentage() {
    }
    
    private final void setCardStackView() {
    }
    
    private final void setJobInfo(com.findajob.jobamax.model.NewJobOffer job) {
    }
    
    private final void setHardSkillAdapter() {
    }
    
    private final void setCardStackListener() {
    }
    
    private final void removeJobFromRefuse(int type) {
    }
    
    private final void removeJobFromWishlist() {
    }
    
    private final void addToWishlistJob() {
    }
    
    private final void addToRefuseJob(int type) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final void setClickListeners() {
    }
    
    private final void updateJobs() {
    }
    
    private final void addJobTitle() {
    }
    
    private final void getJobTypes() {
    }
    
    private final void updateJobFilter(java.lang.String searchString) {
    }
    
    private final void shareJob() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
}