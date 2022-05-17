package com.jobamax.appjobamax.jobseeker.profile.cv.model

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
    var logo: String = ""
}

class VolunteeringGroup(val list: List<Volunteering> = listOf()) : Serializable