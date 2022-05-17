package com.jobamax.appjobamax.jobseeker.profile.cv.model

import java.io.Serializable
import java.util.*

class Experience : Serializable {

    var id: String = UUID.randomUUID().toString()
    var job: String = ""
    var company: String = ""
    var startDate: String = ""
    var endDate: String = ""
    var description: String = ""
    var logo: String = ""
    var location: String = ""

}

class ExperienceGroup(val list: List<Experience> = listOf()) : Serializable

