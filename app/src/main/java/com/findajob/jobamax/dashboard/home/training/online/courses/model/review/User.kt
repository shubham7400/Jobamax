package com.findajob.jobamax.dashboard.home.training.online.courses.model.review

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class User(
    val _class: String,
    val display_name: String,
    val name: String,
    val title: String
):Parcelable