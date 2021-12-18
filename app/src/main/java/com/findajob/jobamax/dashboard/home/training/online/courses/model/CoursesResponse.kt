package com.findajob.jobamax.dashboard.home.training.online.courses.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CoursesResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<OnlineCourse>,
):Parcelable