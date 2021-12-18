package com.findajob.jobamax.data.remote

import com.findajob.jobamax.data.dto.location.GoogleApiResponseDto
import com.findajob.jobamax.data.dto.location.PlaceDetailsApiResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleApiService {

    @GET("/maps/api/place/autocomplete/json")
    suspend fun getMapTextSearchResponse(
        @Query("key") key: String,
        @Query("input") query: String
    ): Response<GoogleApiResponseDto>

    @GET("/maps/api/place/details/json")
    suspend fun getPlaceDetailsResponse(
        @Query("key") key: String,
        @Query("place_id") query: String
    ): Response<PlaceDetailsApiResponseDto>
}