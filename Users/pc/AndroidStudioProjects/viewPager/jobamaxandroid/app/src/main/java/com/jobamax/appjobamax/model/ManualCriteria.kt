package com.jobamax.appjobamax.model

import java.io.Serializable

class ManualCriteria : Serializable {
    var location = ""
    var experience = arrayListOf<String>()
    var typeOfWork = arrayListOf<String>()
    var companySize = arrayListOf<String>()
    var companyName = arrayListOf<String>()
    var jobSearchKeywords = arrayListOf<String>()
    var lat: Double = 0.0
    var long: Double = 0.0
}