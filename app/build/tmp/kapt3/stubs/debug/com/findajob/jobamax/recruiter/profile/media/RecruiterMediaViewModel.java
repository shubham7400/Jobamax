package com.findajob.jobamax.recruiter.profile.media;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u000e\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020$R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016\u00a8\u0006\'"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/media/RecruiterMediaViewModel;", "Lcom/findajob/jobamax/base/BaseAndroidViewModel;", "context", "Landroid/app/Application;", "(Landroid/app/Application;)V", "company", "Lcom/findajob/jobamax/model/Company;", "getCompany", "()Lcom/findajob/jobamax/model/Company;", "companyParseObject", "Lcom/parse/ParseObject;", "getCompanyParseObject", "()Lcom/parse/ParseObject;", "setCompanyParseObject", "(Lcom/parse/ParseObject;)V", "getContext", "()Landroid/app/Application;", "logoUri", "Landroid/net/Uri;", "getLogoUri", "()Landroid/net/Uri;", "setLogoUri", "(Landroid/net/Uri;)V", "recruiter", "Lcom/findajob/jobamax/model/Recruiter;", "getRecruiter", "()Lcom/findajob/jobamax/model/Recruiter;", "recruiterParseObject", "getRecruiterParseObject", "setRecruiterParseObject", "videoUri", "getVideoUri", "setVideoUri", "saveCompany", "", "callback", "Lcom/findajob/jobamax/repo/SaveParseObjectCallback;", "uploadLogo", "uploadVideoPresentation", "app_debug"})
public final class RecruiterMediaViewModel extends com.findajob.jobamax.base.BaseAndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject companyParseObject;
    @org.jetbrains.annotations.Nullable()
    private com.parse.ParseObject recruiterParseObject;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri logoUri;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri videoUri;
    
    @javax.inject.Inject()
    public RecruiterMediaViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getCompanyParseObject() {
        return null;
    }
    
    public final void setCompanyParseObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.parse.ParseObject getRecruiterParseObject() {
        return null;
    }
    
    public final void setRecruiterParseObject(@org.jetbrains.annotations.Nullable()
    com.parse.ParseObject p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.Recruiter getRecruiter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.Company getCompany() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getLogoUri() {
        return null;
    }
    
    public final void setLogoUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getVideoUri() {
        return null;
    }
    
    public final void setVideoUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    public final void uploadLogo(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveParseObjectCallback callback) {
    }
    
    public final void uploadVideoPresentation(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveParseObjectCallback callback) {
    }
    
    public final void saveCompany(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.SaveParseObjectCallback callback) {
    }
}