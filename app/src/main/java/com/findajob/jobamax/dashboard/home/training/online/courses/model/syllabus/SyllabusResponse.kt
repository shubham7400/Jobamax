package com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SyllabusResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Syllabus>
): Parcelable