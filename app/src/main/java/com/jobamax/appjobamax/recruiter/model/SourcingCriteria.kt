package com.jobamax.appjobamax.recruiter.model

data class SourcingCriteria (
    var skills: List<String>,
    var companyId: String,
    var companies: List<String>,
    var universities: List<String>,
    var sourcingId: String,
    var jobTitles: List<String>,
    var location: String,
    var title: String,
    var typeOfWork: List<String>,
    var experience: String,
    var latitude: Double,
    var longitude: Double,
)