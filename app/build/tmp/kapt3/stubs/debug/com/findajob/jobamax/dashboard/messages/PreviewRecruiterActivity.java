package com.findajob.jobamax.dashboard.messages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \'2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\'B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\u001c\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020!H\u0002J\u0012\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006("}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/PreviewRecruiterActivity;", "Lcom/findajob/jobamax/base/BaseActivityMain;", "Lcom/findajob/jobamax/databinding/ItemRecruiterJobOffersBinding;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "jobSeekerTrackAdapter", "Lcom/findajob/jobamax/jobseeker/track/JobSeekerTrackAdapter;", "getJobSeekerTrackAdapter", "()Lcom/findajob/jobamax/jobseeker/track/JobSeekerTrackAdapter;", "setJobSeekerTrackAdapter", "(Lcom/findajob/jobamax/jobseeker/track/JobSeekerTrackAdapter;)V", "layoutRes", "", "getLayoutRes", "()I", "recruiter", "Lcom/findajob/jobamax/model/Recruiter;", "getRecruiter", "()Lcom/findajob/jobamax/model/Recruiter;", "setRecruiter", "(Lcom/findajob/jobamax/model/Recruiter;)V", "viewModel", "Lcom/findajob/jobamax/dashboard/messages/PreviewRecruiterViewModel;", "getViewModel", "()Lcom/findajob/jobamax/dashboard/messages/PreviewRecruiterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkExtras", "", "Lcom/findajob/jobamax/base/BaseViewModel;", "initViews", "onCreated", "instance", "Landroid/os/Bundle;", "Companion", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class PreviewRecruiterActivity extends com.findajob.jobamax.base.BaseActivityMain<com.findajob.jobamax.databinding.ItemRecruiterJobOffersBinding> {
    private final kotlin.Lazy viewModel$delegate = null;
    public com.findajob.jobamax.model.Recruiter recruiter;
    public android.content.Context context;
    public com.findajob.jobamax.jobseeker.track.JobSeekerTrackAdapter jobSeekerTrackAdapter;
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.dashboard.messages.PreviewRecruiterActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_RECRUITER_ID = "user_id";
    private java.util.HashMap _$_findViewCache;
    
    public PreviewRecruiterActivity() {
        super();
    }
    
    private final com.findajob.jobamax.dashboard.messages.PreviewRecruiterViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.Recruiter getRecruiter() {
        return null;
    }
    
    public final void setRecruiter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.Recruiter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.track.JobSeekerTrackAdapter getJobSeekerTrackAdapter() {
        return null;
    }
    
    public final void setJobSeekerTrackAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.track.JobSeekerTrackAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected com.findajob.jobamax.base.BaseViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle instance) {
    }
    
    private final void initViews() {
    }
    
    private final void checkExtras() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/PreviewRecruiterActivity$Companion;", "", "()V", "EXTRA_RECRUITER_ID", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}