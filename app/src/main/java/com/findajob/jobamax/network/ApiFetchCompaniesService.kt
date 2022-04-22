package com.findajob.jobamax.network

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiFetchCompaniesService {
     @GET("suggest?query=")
     fun searchCompanies(@Query("query") query: String): Call<Any>

    companion object {
        private const val BASE_URL = "https://autocomplete.clearbit.com/v1/companies/"

        var retrofit: Retrofit? = null
        private val logging = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        fun getInstance(context: Context) : Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(OkHttpClient.Builder().addInterceptor(logging).build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}