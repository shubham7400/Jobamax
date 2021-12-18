package com.findajob.jobamax.dashboard.home.training.online.courses.model.review

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Review(
    val _class: String,
    val content: String,
    val created: String,
    val id: Int,
    val modified: String,
    val rating: Float,
    val user: User,
    val user_modified: String
):Parcelable
