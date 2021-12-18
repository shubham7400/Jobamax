package com.findajob.jobamax.data.dto.location


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("address_components")
    val addressComponents: List<AddressComponent>,
    @SerializedName("adr_address")
    val adrAddress: String,
    @SerializedName("formatted_address")
    val formattedAddress: String,
    @SerializedName("geometry")
    val geometry: Geometry,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("icon_background_color")
    val iconBackgroundColor: String,
    @SerializedName("icon_mask_base_uri")
    val iconMaskBaseUri: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("photos")
    val photos: List<Photo>,
    @SerializedName("place_id")
    val placeId: String,
    @SerializedName("reference")
    val reference: String,
    @SerializedName("types")
    val types: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("utc_offset")
    val utcOffset: Int,
    @SerializedName("vicinity")
    val vicinity: String,
    @SerializedName("website")
    val website: String
)