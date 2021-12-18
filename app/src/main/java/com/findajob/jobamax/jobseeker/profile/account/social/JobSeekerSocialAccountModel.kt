package com.findajob.jobamax.jobseeker.profile.account.social

import com.findajob.jobamax.model.JobSeeker
import com.parse.ParseObject


class JobSeekerSocialAccountModel {
    var facebook: String = ""
    var twitter: String = ""
    var instagram: String = ""
    var linkedin: String = ""
    var socialAccounts: MutableList<String> = mutableListOf()

    constructor(jobSeeker: JobSeeker) {
        if (jobSeeker.socialAccounts.isNotEmpty()) {
            facebook = jobSeeker.socialAccounts[0]
            twitter = jobSeeker.socialAccounts[1]
            instagram = jobSeeker.socialAccounts[2]
            linkedin = jobSeeker.socialAccounts[3]
        }
    }

    fun update(obj: ParseObject) {
        socialAccounts.apply {
            add(0, facebook)
            add(1, twitter)
            add(2, instagram)
            add(3, linkedin)
        }
        obj.put("socialAccounts", socialAccounts)
    }
}