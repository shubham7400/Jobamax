package com.findajob.jobamax.repo

import android.content.Context
import com.findajob.jobamax.model.fcm.PushNotification
import com.findajob.jobamax.network.NotificationApiService
import com.findajob.jobamax.util.FCM_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Inject


class FCMRepo @Inject constructor(val context: Context) {


    fun postCloudNotification(requestBody: PushNotification, callback: FCMCallback) {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


        val retrofit = Retrofit.Builder().baseUrl(FCM_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(client)
            .build()


        val service = retrofit.create(NotificationApiService::class.java)
        service.postNotification(requestBody).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                if (response.isSuccessful) {
                    callback.onResult(true, "Success !")
                } else {
                    callback.onResult(false, "Failed !")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                callback.onResult(false, t.message.toString())
            }

        })


    }

}

