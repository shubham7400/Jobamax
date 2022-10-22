package com.jobamax.appjobamax.model

import java.io.Serializable

class PersonalizeCriteria : Serializable{
    var location = ""
    var experience = arrayListOf<String>()
    var typeOfWork = arrayListOf<String>()
    var latitude: Double = 0.0
    var longitude: Double = 0.0
}