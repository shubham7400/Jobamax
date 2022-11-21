package com.jobamax.appjobamax.model

import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

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

class VolunteeringGroup(val list: ArrayList<Volunteering> = arrayListOf()) : Serializable