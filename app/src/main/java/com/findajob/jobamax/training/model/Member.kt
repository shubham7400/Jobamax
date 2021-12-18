package com.findajob.jobamax.training.model

import com.findajob.jobamax.model.Company
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.model.Recruiter
import com.findajob.jobamax.model.User
import com.parse.ParseObject

class Member {
    var name: String = ""
    var profileUrl: String = ""
    var id: String = ""
    var muted: Boolean = false
    var handRaised: Boolean = false

    constructor()

    constructor(user: User) {
        name = user.firstName + " " + user.lastName
        profileUrl = user.profilePicUrl
        id = user.userId
    }

    constructor(jobSeeker: JobSeeker) {
        name = jobSeeker.firstName + " " + jobSeeker.lastName
        profileUrl = jobSeeker.profilePicUrl
        id = jobSeeker.userId
        muted = jobSeeker.isNetworkingMuted
        handRaised = jobSeeker.isNetworkingHandRaised
    }

    constructor(recruiter: Recruiter, parseObject: ParseObject) {
        name = recruiter.firstName + " " + recruiter.lastName
        val companyParseObject = (parseObject["company"] as? ParseObject?)
        val company = Company(companyParseObject!!)
        profileUrl = company.logoUrl
        id = recruiter.userId
        muted = recruiter.isNetworkingMuted
        handRaised = recruiter.isNetworkingHandRaised
    }
}