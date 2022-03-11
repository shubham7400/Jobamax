package com.findajob.jobamax.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JR\u00104\u001a\u0002052\"\u00106\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020807j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000208`92\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002050;2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u0002050;J8\u0010>\u001a\u0002052\u0006\u0010?\u001a\u00020\u00072\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002050;2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u0002050;H\u0002J8\u0010@\u001a\u0002052\u0006\u0010?\u001a\u00020\u00072\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002050;2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u0002050;H\u0002J6\u0010A\u001a\u0002052\u0006\u0010?\u001a\u00020\u00072\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002050;2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u0002050;J\u000e\u0010B\u001a\u0002052\u0006\u0010?\u001a\u00020\u0007J\u000e\u0010C\u001a\u0002052\u0006\u0010D\u001a\u00020ER\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 \u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0 \u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u000b0 \u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0 \u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u0006F"}, d2 = {"Lcom/findajob/jobamax/login/LoginViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "context", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_detailedUser", "Landroidx/lifecycle/MutableLiveData;", "Lcom/findajob/jobamax/model/User;", "_errorMessage", "", "_existingUser", "Lcom/parse/ParseObject;", "_existingUserError", "authRepository", "Lcom/findajob/jobamax/data/remote/AuthRepository;", "getAuthRepository$app_debug", "()Lcom/findajob/jobamax/data/remote/AuthRepository;", "setAuthRepository$app_debug", "(Lcom/findajob/jobamax/data/remote/AuthRepository;)V", "checkExistingJobSeekerUseCase", "Lcom/findajob/jobamax/domain/CheckExistingJobSeekerUseCase;", "getCheckExistingJobSeekerUseCase$app_debug", "()Lcom/findajob/jobamax/domain/CheckExistingJobSeekerUseCase;", "setCheckExistingJobSeekerUseCase$app_debug", "(Lcom/findajob/jobamax/domain/CheckExistingJobSeekerUseCase;)V", "checkExistingRecruiterUseCase", "Lcom/findajob/jobamax/domain/CheckExistingRecruiterUseCase;", "getCheckExistingRecruiterUseCase$app_debug", "()Lcom/findajob/jobamax/domain/CheckExistingRecruiterUseCase;", "setCheckExistingRecruiterUseCase$app_debug", "(Lcom/findajob/jobamax/domain/CheckExistingRecruiterUseCase;)V", "detailedUser", "Landroidx/lifecycle/LiveData;", "getDetailedUser", "()Landroidx/lifecycle/LiveData;", "disposeBag", "Lio/reactivex/disposables/CompositeDisposable;", "errorMessage", "getErrorMessage", "existingUser", "getExistingUser", "existingUserError", "getExistingUserError", "jobSeekerRepo", "Lcom/findajob/jobamax/repo/JobSeekerRepo;", "recruiterRepo", "Lcom/findajob/jobamax/repo/RecruiterRepo;", "roleType", "getRoleType", "()Ljava/lang/String;", "setRoleType", "(Ljava/lang/String;)V", "changePassword", "", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onSuccess", "Lkotlin/Function1;", "onError", "", "getCurrentJobSeeker", "user", "getCurrentRecruiter", "getCurrentUser", "saveUserDetails", "updateFlag", "callback", "Lcom/findajob/jobamax/model/UpdateUserCallback;", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.AndroidViewModel {
    private final android.app.Application context = null;
    public com.findajob.jobamax.data.remote.AuthRepository authRepository;
    public com.findajob.jobamax.domain.CheckExistingRecruiterUseCase checkExistingRecruiterUseCase;
    public com.findajob.jobamax.domain.CheckExistingJobSeekerUseCase checkExistingJobSeekerUseCase;
    private final com.findajob.jobamax.repo.RecruiterRepo recruiterRepo = null;
    private final com.findajob.jobamax.repo.JobSeekerRepo jobSeekerRepo = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String roleType = "";
    private final io.reactivex.disposables.CompositeDisposable disposeBag = null;
    private final androidx.lifecycle.MutableLiveData<com.parse.ParseObject> _existingUser = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.parse.ParseObject> existingUser = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _existingUserError = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> existingUserError = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> errorMessage = null;
    private final androidx.lifecycle.MutableLiveData<com.findajob.jobamax.model.User> _detailedUser = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.findajob.jobamax.model.User> detailedUser = null;
    
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.data.remote.AuthRepository getAuthRepository$app_debug() {
        return null;
    }
    
    public final void setAuthRepository$app_debug(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.data.remote.AuthRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.domain.CheckExistingRecruiterUseCase getCheckExistingRecruiterUseCase$app_debug() {
        return null;
    }
    
    public final void setCheckExistingRecruiterUseCase$app_debug(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.domain.CheckExistingRecruiterUseCase p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.domain.CheckExistingJobSeekerUseCase getCheckExistingJobSeekerUseCase$app_debug() {
        return null;
    }
    
    public final void setCheckExistingJobSeekerUseCase$app_debug(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.domain.CheckExistingJobSeekerUseCase p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoleType() {
        return null;
    }
    
    public final void setRoleType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.parse.ParseObject> getExistingUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getExistingUserError() {
        return null;
    }
    
    /**
     * Get currently logged in user.
     *
     * @param user, [User] object
     * @param onSuccess, callback define success state by returning [ParseObject]
     * @param onError, callback define error state by returning [Throwable]
     */
    public final void getCurrentUser(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.User user, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.parse.ParseObject, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onError) {
    }
    
    private final void getCurrentRecruiter(com.findajob.jobamax.model.User user, kotlin.jvm.functions.Function1<? super com.parse.ParseObject, kotlin.Unit> onSuccess, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onError) {
    }
    
    private final void getCurrentJobSeeker(com.findajob.jobamax.model.User user, kotlin.jvm.functions.Function1<? super com.parse.ParseObject, kotlin.Unit> onSuccess, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onError) {
    }
    
    public final void updateFlag(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.UpdateUserCallback callback) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.findajob.jobamax.model.User> getDetailedUser() {
        return null;
    }
    
    public final void saveUserDetails(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.model.User user) {
    }
    
    public final void changePassword(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> params, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> onError) {
    }
}