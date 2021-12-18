package com.findajob.jobamax.dashboard.home.training.online.courses.model.review

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ReviewResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Review>
): Parcelable