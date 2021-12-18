package com.findajob.jobamax.jobseeker.profile.cv.model

import java.util.*

class Education {

    var id: String = UUID.randomUUID().toString()
    var name: String = ""
    var program: String = ""
    var startDate: String = ""
    var endDate: String = ""
    var gpa: Double = 0.0
}

class EducationGroup(
    val list: List<Education> = listOf()
)