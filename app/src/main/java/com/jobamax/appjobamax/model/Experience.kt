package com.jobamax.appjobamax.model

import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

class Experience : Serializable {

    var id: String = UUID.randomUUID().toString()
    var job: String = ""
    var company: String = ""
    var typeOfWork: String = ""
    var startDate: String = ""
    var endDate: String = ""
    var description: String = ""
    var logo: String = ""
    var location: String = ""

}

class ExperienceGroup(val list: ArrayList<Experience> = arrayListOf()) : Serializable

