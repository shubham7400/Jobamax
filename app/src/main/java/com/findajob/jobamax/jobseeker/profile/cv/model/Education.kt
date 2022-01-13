package com.findajob.jobamax.jobseeker.profile.cv.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import java.util.*

class Education : Serializable {

    var id: String = UUID.randomUUID().toString()
    var name: String = ""
    var program: String = ""
    var startDate: String = ""
    var endDate: String = ""
    var gpa: Double = 0.0
}

class EducationGroup(val list: List<Education> = listOf()) : Serializable