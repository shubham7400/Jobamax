package com.jobamax.appjobamax.jobseeker.model

import java.io.Serializable

class JobSeekerJobFilter : Serializable {
    var searchString: String? = null
    var distance : Int? = null
    var location: String? = null
    var latitude: Double? = null
    var longitude: Double? = null
    var typeOfWork = emptyList<String>()
    var jobType: String? = null
    var companyName: String? = null
    var experience = emptyList<String>()
    var industry = emptyList<String>()
}