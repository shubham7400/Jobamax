package com.findajob.jobamax.jobseeker.profile.cv.model

import java.util.*

class Experience {

    var id: String = UUID.randomUUID().toString()
    var job: String = ""
    var company: String = ""
    var startDate: String = ""
    var endDate: String = ""
    var description: String = ""
    var location: String = ""

}

class ExperienceGroup(val list: List<Experience> = listOf())

class ActivityGroup(val list: List<String> = listOf())

class SKillGroup(val list: List<String> = listOf())