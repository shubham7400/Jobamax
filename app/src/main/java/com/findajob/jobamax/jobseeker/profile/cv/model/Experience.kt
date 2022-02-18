package com.findajob.jobamax.jobseeker.profile.cv.model

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

class ActivityGroup(val list: List<String> = listOf())

class SKillGroup(val list: List<String> = listOf())