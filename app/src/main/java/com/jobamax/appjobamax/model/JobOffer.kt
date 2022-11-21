package com.jobamax.appjobamax.model

import java.io.Serializable


class JobOffer : Serializable {
    var jobOfferId: String = ""
    var jobTitle: String = ""
    var city: String = ""
    var location: String = ""
    var salary: String = ""
    var jobType: Int = 0
    var companyId: String = ""
    var hasShowCase: Boolean = false
    var swipeRightCount: Int = 0
    var swipeLeftCount: Int = 0
    var randomViewCount: Int = 0
    var typeOfWork: String = ""
    var postedDate: String = ""
    var companyName: String = ""
    var companyLogo: String = ""
    var jobUrl: String = ""
    var description: String = ""
    var tags: ArrayList<String> = arrayListOf()
    var matchesPercentage: Int = 0
    var matches: Matches = Matches()
    var myCriteria: MyCriteria = MyCriteria()
}
class MyCriteria : Serializable {
    var location: String = ""
    var typeOfWork: String = ""
    var companySize: String = ""
    var yearOfExperience: String = ""
    var jobSearches: String = ""
}
class Matches : Serializable {
    var educationPer: Int = 0
    var hardSkillPer: Int = 0
    var softSkillPer: Int = 0
    var experiencePer: Int = 0
    var softSkills: ArrayList<MatchTag> = arrayListOf()
    var hardSkills: ArrayList<MatchTag> = arrayListOf()
    var educations: ArrayList<MatchTag> = arrayListOf()
    var experiences: ArrayList<MatchTag> = arrayListOf()
}
class MatchTag : Serializable {
    var text: String = ""
    var matched: Boolean = false
}

