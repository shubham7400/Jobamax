package com.findajob.jobamax.dashboard.home.training.online.courses.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class OnlineCourse(
        val _class: String?,
        val headline: String?="",
        val id: Int?,
        @SerializedName("image_480x270")
        val image: String?,
        val instructor_name: String?,
        val is_paid: Boolean?,
        val is_practice_test_course: Boolean?,
        val price: String?,
        val price_detail: PriceDetail?,
        val published_title: String?,
        val title: String?,
        val url: String?,
        val visible_instructors: List<VisibleInstructor>?
):Parcelable