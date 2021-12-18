package com.findajob.jobamax.recruiter.profile.account.personalInfo;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0018J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u001aJ3\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2#\u0010\u001e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010 \u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00180\u001fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006$"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/account/personalInfo/RecruiterPersonalInfoIntroViewModel;", "Lcom/findajob/jobamax/base/BaseAndroidViewModel;", "context", "Landroid/app/Application;", "recruiterRepo", "Lcom/findajob/jobamax/repo/RecruiterRepo;", "(Landroid/app/Application;Lcom/findajob/jobamax/repo/RecruiterRepo;)V", "company", "Lcom/findajob/jobamax/model/Company;", "getCompany", "()Lcom/findajob/jobamax/model/Company;", "setCompany", "(Lcom/findajob/jobamax/model/Company;)V", "companyParseObject", "Lcom/parse/ParseObject;", "getContext", "()Landroid/app/Application;", "recruiterLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/findajob/jobamax/model/Recruiter;", "recruiterParseObject", "getRecruiterRepo", "()Lcom/findajob/jobamax/repo/RecruiterRepo;", "getRecruiter", "", "getRecruiterObserver", "Landroidx/lifecycle/LiveData;", "submitData", "personalInfoModel", "Lcom/findajob/jobamax/recruiter/profile/account/personalInfo/RecruiterPersonalInformationModel;", "callback", "Lkotlin/Function1;", "Lcom/parse/ParseException;", "Lkotlin/ParameterName;", "name", "it", "app_debug"})
public final class RecruiterPersonalInfoIntroViewModel extends com.findajob.jobamax.base.BaseAndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.findajob.jobamax.repo.RecruiterRepo recruiterRepo = null;
    private com.parse.ParseObject recruiterParseObject;
    private com.parse.ParseObject companyParseObject;
    @org.jetbrains.annotations.NotNull()
    private com.findajob.jobamax.model.Company company;
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.model.Recruiter> recruiterLiveData = null;
    
    @javax.inject.Inject()
    public RecruiterPersonalInfoIntroViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application context, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.repo.RecruiterRepo recruiterRepo) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.repo.RecruiterRepo getRecruiterRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.model.Company getCompany() {
        return null;
    }
    
    public final void setCompany(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.Company p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.findajob.jobamax.model.Recruiter> getRecruiterObserver() {
        return null;
    }
    
    public final void getRecruiter() {
    }
    
    public final void submitData(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationModel personalInfoModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseException, kotlin.Unit> callback) {
    }
}