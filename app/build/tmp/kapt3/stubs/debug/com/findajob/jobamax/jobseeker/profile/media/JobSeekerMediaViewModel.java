package com.findajob.jobamax.jobseeker.profile.media;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/media/JobSeekerMediaViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "context", "Landroid/app/Application;", "viewModel", "Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "(Landroid/app/Application;Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;)V", "attachmentUri", "Landroid/net/Uri;", "getAttachmentUri", "()Landroid/net/Uri;", "setAttachmentUri", "(Landroid/net/Uri;)V", "getContext", "()Landroid/app/Application;", "jobSeeker", "Lcom/findajob/jobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/findajob/jobamax/model/JobSeeker;", "jobSeekerObject", "Lcom/parse/ParseObject;", "personalPresentationUri", "getPersonalPresentationUri", "setPersonalPresentationUri", "profilePicUri", "getProfilePicUri", "setProfilePicUri", "getViewModel", "()Lcom/findajob/jobamax/jobseeker/home/JobSeekerHomeViewModel;", "saveJobSeeker", "", "callback", "Lcom/findajob/jobamax/repo/SaveParseObjectCallback;", "uploadAttachment", "uploadPersonalPresentation", "uploadProfilePicUri", "app_debug"})
public final class JobSeekerMediaViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel viewModel = null;
    private com.parse.ParseObject jobSeekerObject;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri profilePicUri;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri personalPresentationUri;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri attachmentUri;
    
    public JobSeekerMediaViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application context, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel viewModel) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getProfilePicUri() {
        return null;
    }
    
    public final void setProfilePicUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getPersonalPresentationUri() {
        return null;
    }
    
    public final void setPersonalPresentationUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getAttachmentUri() {
        return null;
    }
    
    public final void setAttachmentUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    public final void uploadProfilePicUri(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveParseObjectCallback callback) {
    }
    
    public final void uploadPersonalPresentation(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveParseObjectCallback callback) {
    }
    
    public final void uploadAttachment(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveParseObjectCallback callback) {
    }
    
    public final void saveJobSeeker(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveParseObjectCallback callback) {
    }
}