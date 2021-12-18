package com.findajob.jobamax.di

import com.findajob.jobamax.dashboard.home.training.online.courses.api.UdemyApiService
import com.findajob.jobamax.data.remote.GoogleApiService
import com.findajob.jobamax.training.model.ConstantApp
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(UdemyApiService.BASE_URL)
            .build()

    @Provides
    @Singleton
    fun provideUdemyApi(retrofit: Retrofit): UdemyApiService =
        retrofit.create(UdemyApiService::class.java)


    @Singleton
    @Provides
    fun provideLogInterceptor(): OkHttpClient = OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Provides
    fun provideConverterFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Provides
    fun provideCallAdapterFactory(): RxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create()

    @Singleton
    @Provides
    fun provideGoogleApiService(
        okHttpClient: OkHttpClient,
    ): GoogleApiService = Retrofit.Builder()
        .baseUrl(ConstantApp.SERVER_HOST_GOOGLE)
        .addConverterFactory(GsonConverterFactory.create())
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
        .create(GoogleApiService::class.java)
}