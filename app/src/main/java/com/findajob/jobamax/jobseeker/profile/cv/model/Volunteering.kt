package com.findajob.jobamax.jobseeker.profile.cv.model

import com.findajob.jobamax.enums.ParseTableName
import com.parse.ParseObject
import java.io.Serializable
import java.util.*

class Volunteering : Serializable {

    var id: String = UUID.randomUUID().toString()
    var job: String = ""
    var company: String = ""
    var location: String = ""
    var startDate: String = ""
    var endDate: String = ""
    var description: String = ""
}

class VolunteeringGroup(val list: List<Volunteering> = listOf()) : Serializable