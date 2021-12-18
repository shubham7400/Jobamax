package com.findajob.jobamax.data.dto.location


import com.google.gson.annotations.SerializedName

data class GoogleApiResponseDto(
    @SerializedName("predictions")
    val predictions: List<Prediction>,
    @SerializedName("status")
    val status: String
)