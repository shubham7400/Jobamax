package com.findajob.jobamax.jobseeker.model

import java.io.Serializable

class JobSeekerJobFilter : Serializable {
    var searchString: String? = null
    var distance : Int? = null
    var location: String? = null
    var lat: Double? = null
    var lng: Double? = null
    var typeOfWork = emptyList<String>()
    var jobType: String? = null
    var companyName: String? = null
    var experience = emptyList<String>()
    var industry = emptyList<String>()
}