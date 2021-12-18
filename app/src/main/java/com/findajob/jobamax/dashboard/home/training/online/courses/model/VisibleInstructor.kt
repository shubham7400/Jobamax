package com.findajob.jobamax.dashboard.home.training.online.courses.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class VisibleInstructor(
    val _class: String,
    val display_name: String?,
    @SerializedName("image_100x100")
    val image_large: String,
    @SerializedName("image_50x50")
    val image_small: String,
    val initials: String,
    val job_title: String,
    val name: String,
    val title: String,
    val url: String
):Parcelable