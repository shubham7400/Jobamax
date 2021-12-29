package com.findajob.jobamax.di

import android.app.Application
import android.content.Context
import com.findajob.jobamax.repo.*
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    fun provideJobOfferRepo(): JobOfferRepository {
        return JobOfferRepository()
    }

    @Provides
    fun provideJobSeekerRepo(@ApplicationContext context: Context): JobSeekerRepo {
        return JobSeekerRepo(context)
    }

    @Provides
    fun provideRecruiterRepo(@ApplicationContext context: Context): RecruiterRepo {
        return RecruiterRepo(context)
    }

    @Provides
    fun provideContext(@ApplicationContext context: Application): Context {
        return context
    }

    @Provides
    fun provideFcmRepo(@ApplicationContext context: Context): FCMRepo {
        return FCMRepo(context)
    }

    @Provides
    fun provideMessageRepository(@ApplicationContext context: Context) = MessageRepository(context)

    @Provides
    fun provideLiveRoomRepo(context: Application): LiveRoomRepo {
        return LiveRoomRepo(context)
    }

    @Provides
    fun provideJobSeekerResumeRepo(gsonConverter: Gson): JobSeekerResumeRepo {
        return JobSeekerResumeRepoImpl(gsonConverter)
    }
}