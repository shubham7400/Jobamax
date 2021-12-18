package com.findajob.jobamax.model

import com.parse.ParseGeoPoint
import com.parse.ParseObject

class City {
	
    var name: String = ""
    var latLng: ParseGeoPoint = ParseGeoPoint()

    constructor()

    constructor(obj: ParseObject) {
        this.name = obj["name"].toString()
        this.latLng = (obj["latLng"] as? ParseGeoPoint) ?: ParseGeoPoint()
    }

}