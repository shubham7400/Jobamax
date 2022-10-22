package com.jobamax.appjobamax.model

import java.io.Serializable

class Location : Serializable {
    var placeId: String = ""
    var address: String = ""
    var lat: Double = 0.0
    var long: Double = 0.0
    var city: String = ""
}


