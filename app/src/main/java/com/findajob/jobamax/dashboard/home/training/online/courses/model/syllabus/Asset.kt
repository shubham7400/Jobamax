package com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Asset(
    val _class: String,
    val asset_type: String,
    val created: String,
    val id: Int,
    val title: String
):Parcelable