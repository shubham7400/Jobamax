package com.findajob.jobamax.data.pojo

import java.io.Serializable
import java.util.*

class Education : Serializable {

    var id: String = UUID.randomUUID().toString()
    var name: String = ""
    var program: String = ""
    var description: String = ""
    var startDate: String = ""
    var endDate: String = ""
    var logo: String = ""
    var gpa: Double = 0.0
}

class EducationGroup(val list: List<Education> = listOf()) : Serializable