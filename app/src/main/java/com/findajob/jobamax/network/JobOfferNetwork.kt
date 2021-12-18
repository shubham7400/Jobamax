package com.findajob.jobamax.network

import com.findajob.jobamax.model.*
import com.findajob.jobamax.util.JOOBLE_APP_KEY
import okhttp3.RequestBody
import com.findajob.jobamax.model.fcm.PushNotification
import com.findajob.jobamax.util.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


fun getAdzunaBaseUrl(countryCode : String) : String {
    // Adzuna supported countries:
    // gb, at, au, br, ca, de, fr, in, it, nl, nz, pl, ru, sg, us, za
    return "https://api.adzuna.com/v1/api/jobs/$countryCode/search/"
}

fun getRemotiveBaseUrl() : String {
    return "https://remotive.io/api/"
}

fun getJoobleBaseUrl() : String {
    return "http://jooble.org/"
}

fun getUsaJobsBaseUrl() : String {
    return "https://data.usajobs.gov/api/"
}

fun getJobsPikrBaseUrl() : String {
    return "https://api.jobspikr.com/v2/"
}

fun getPushwooshBaseUrl() : String = "https://cp.pushwoosh.com"

interface AdzunaJobOfferNetwork {

    @GET("1?")
    fun getJobOffer(
            @Query("app_id")appId : String,
            @Query("app_key")appKey : String,
            @Query("what")role: String,
            @Query("where")location: String,
            @Query("distance")distance: Int,
            @Query("results_per_page")resultsPerPage: Int,
            @Query("content-type")contentType: String
    ) : Call<JobOfferAdzuna>

    @GET("1?")
    fun getJobOffer(
            @Query("app_id")appId : String,
            @Query("app_key")appKey : String,
            @Query("what")role: String,
            @Query("where")location: String,
            @Query("distance")distance: Int,
            @Query("results_per_page")resultsPerPage: Int,
            @Query("content-type")contentType: String,
            @QueryMap options: Map<String, Int>?
    ) : Call<JobOfferAdzuna>
}

interface RemotiveJobOfferNetwork {

    @GET("remote-jobs?")
    fun getJobOffer(
            @Query("search")title: String,
    ) : Call<JobOfferRemotive>
}

interface JoobleJobOfferNetwork {

    @Headers("Content-Type: application/json")
    @POST("api/$JOOBLE_APP_KEY")
    fun getJobOffer(
            @Body request: JoobleRequest
    ): Call<JobOfferJooble>

}

interface JobsPikrJobOfferNetwork {
    @Headers(
        "Content-Type: application/json",
        "client_id: $JOBSPIKR_CLIENT_ID",
        "client_auth_key: $JOBSPIKR_CLIENT_AUTH_KEY"
    )
    @POST("data")
    fun getJobOffer(
        @Body request: JobRequestJobsPikr
    ): Call<JobOfferJobsPikr>
}

interface UsaJobsJobOfferNetwork {

    @Headers(
        "Host: data.usajobs.gov",
        "User-Agent: thomas.woodfin@jobamax.com",
        "Authorization-Key: JCtKBsYAlqL46dlpmmxehxkZ9EtsUwoEPX7Ok77QIxg="
    )
    @GET("search?")
    fun getJobOffer(
        @Query("Keyword") role: String,
        @Query("LocationName") location: String,
    ): Call<JobOfferUsaJobs>
}

interface NotificationApiService {

    /*   @POST("/json/1.3/createMessage")
       fun getPushNotificationResponse(@Body request : RequestBody) : Call<PushwooshNotificationResponse>*/


    @Headers("Authorization: key=$FCM_SERVER_KEY", "Content-Type:$FCM_CONTENT_TYPE")
    @POST("fcm/send")
    fun postNotification(@Body request: PushNotification): Call<ResponseBody>
}
