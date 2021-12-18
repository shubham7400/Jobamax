package com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Syllabus(
    val _class: String,
    val asset: Asset,
    val can_be_previewed: Boolean,
    val created: String,
    val description: String,
    val id: Int,
    val is_downloadable: Boolean,
    val is_free: Boolean,
    val is_published: Boolean,
    val sort_order: Int,
    val title: String,
    val title_cleaned: String,
    val transcript: String
):Parcelable