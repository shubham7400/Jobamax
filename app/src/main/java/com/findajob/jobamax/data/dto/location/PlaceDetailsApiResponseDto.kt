package com.findajob.jobamax.data.dto.location


import com.google.gson.annotations.SerializedName

data class PlaceDetailsApiResponseDto(
    @SerializedName("html_attributions")
    val htmlAttributions: List<Any>,
    @SerializedName("result")
    val result: Result,
    @SerializedName("status")
    val status: String
)