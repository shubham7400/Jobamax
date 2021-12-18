package com.findajob.jobamax.data.dto.location


import com.google.gson.annotations.SerializedName

data class Viewport(
    @SerializedName("northeast")
    val northeast: Northeast,
    @SerializedName("southwest")
    val southwest: Southwest
)