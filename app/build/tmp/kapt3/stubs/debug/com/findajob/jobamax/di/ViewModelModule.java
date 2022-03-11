package com.findajob.jobamax.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ViewModelComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007J\u0012\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/findajob/jobamax/di/ViewModelModule;", "", "()V", "provideContext", "Landroid/content/Context;", "context", "Landroid/app/Application;", "provideFcmRepo", "Lcom/findajob/jobamax/repo/FCMRepo;", "provideJobOfferRepo", "Lcom/findajob/jobamax/repo/JobOfferRepository;", "provideJobSeekerRepo", "Lcom/findajob/jobamax/repo/JobSeekerRepo;", "provideJobSeekerResumeRepo", "Lcom/findajob/jobamax/repo/JobSeekerResumeRepo;", "gsonConverter", "Lcom/google/gson/Gson;", "provideLiveRoomRepo", "Lcom/findajob/jobamax/repo/LiveRoomRepo;", "provideMessageRepository", "Lcom/findajob/jobamax/repo/MessageRepository;", "provideRecruiterRepo", "Lcom/findajob/jobamax/repo/RecruiterRepo;", "app_debug"})
@dagger.Module()
public final class ViewModelModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.di.ViewModelModule INSTANCE = null;
    
    private ViewModelModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.findajob.jobamax.repo.JobOfferRepository provideJobOfferRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.findajob.jobamax.repo.JobSeekerRepo provideJobSeekerRepo(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.findajob.jobamax.repo.RecruiterRepo provideRecruiterRepo(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final android.content.Context provideContext(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.app.Application context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.findajob.jobamax.repo.FCMRepo provideFcmRepo(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.findajob.jobamax.repo.MessageRepository provideMessageRepository(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.findajob.jobamax.repo.LiveRoomRepo provideLiveRoomRepo(@org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.findajob.jobamax.repo.JobSeekerResumeRepo provideJobSeekerResumeRepo(@org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gsonConverter) {
        return null;
    }
}