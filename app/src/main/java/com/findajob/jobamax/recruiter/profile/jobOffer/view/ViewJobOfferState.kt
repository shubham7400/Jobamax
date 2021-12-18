package com.findajob.jobamax.recruiter.profile.jobOffer.view

import com.findajob.jobamax.model.JobOffer
import com.findajob.jobamax.util.*
import com.parse.ParseGeoPoint

class ViewJobOfferState {

    var jobOfferId: String = ""
    var recruiterId: String = ""
    var name: String = ""
    var geoLocation = ParseGeoPoint()
    var company: String = ""
    var companyId: String = ""
    var city: String = ""
    var industry: String = ""
    var monthlySalary: String = ""
    var skills: List<String> = listOf()
    var keySkills: List<String> = listOf()
    var description: String = ""

    var jobSelectedFlag: Boolean = false
    var workStudySelectedFlag: Boolean = false
    var internshipSelectedFlag: Boolean = false
    var otherSelectedFlag: Boolean = false

    var underOneWorkExSelectedFlag: Boolean = false
    var oneToTwoWorkExSelectedFlag: Boolean = false
    var twoPlusWorkExSelectedFlag: Boolean = false

    var distance: Int = 0
    var location: String = ""

    var isArchived = false

    var companySize = ""

    /**
     * 0 -> Low
     * 1 -> Medium
     * 2 -> High
     */
    var hierarchyFlag: Int = -1

    /**
     * 0 -> Full Time
     * 1 -> Part Time
     */
    var typeOfWork: MutableList<String> = mutableListOf()

    var benefits: List<String> = listOf()

    var documentName: String = ""
    var documentUrl: String = ""
    var companyWebsite = ""
    var isMonthlySalary = true
    var screeningQuestion = ""

    constructor(jobOffer: JobOffer) {
        this.jobOfferId = jobOffer.jobOfferId
        this.recruiterId = jobOffer.recruiterId
        this.jobSelectedFlag = jobOffer.jobCategory.contains(CONST_JOB)
        this.workStudySelectedFlag = jobOffer.jobCategory.contains(CONST_WORK_STUDY)
        this.internshipSelectedFlag = jobOffer.jobCategory.contains(CONST_INTERNSHIP)
        this.otherSelectedFlag = jobOffer.jobCategory.contains(CONST_OTHER)

        this.underOneWorkExSelectedFlag = jobOffer.experience.contains(CONST_UNDER_ONE)
        this.oneToTwoWorkExSelectedFlag = jobOffer.experience.contains(CONST_ONE_TO_TWO)
        this.twoPlusWorkExSelectedFlag = jobOffer.experience.contains(CONST_TWO_PLUS)

        this.name = jobOffer.name
        this.geoLocation = jobOffer.geoLocation
        this.companyId = jobOffer.companyId
        this.company = jobOffer.companyName
        this.city = jobOffer.city
        this.industry = jobOffer.industry

        this.skills = jobOffer.skills
        this.description = jobOffer.description
        this.keySkills = jobOffer.keySkills
        this.monthlySalary = jobOffer.monthlySalary

        this.typeOfWork = jobOffer.typeOfWork.toMutableList()
        this.hierarchyFlag =
            if (jobOffer.levelOfHierarchy == CONST_LOW) 0 else if (jobOffer.levelOfHierarchy == CONST_MEDIUM) 1 else 2
        this.distance = jobOffer.distance
        this.location = jobOffer.location
        this.documentName = jobOffer.documentName
        this.documentUrl = jobOffer.documentUrl
        this.benefits = jobOffer.benefits

        this.isArchived = jobOffer.isArchived

        this.companySize = jobOffer.companySize
        this.companyWebsite = jobOffer.companyWebsite
        this.isMonthlySalary = jobOffer.isMonthlySalary
        this.screeningQuestion = jobOffer.screeningQuestion

    }

}