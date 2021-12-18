package com.findajob.jobamax.recruiter.profile.jobOffer.create

import com.findajob.jobamax.model.JobOffer
import com.findajob.jobamax.util.*
import com.parse.ParseGeoPoint
import java.util.*

class JobOfferDetailsState {

    var jobOfferId: String = ""
    var recruiterId: String = ""
    var name: String = ""
    var geoLocation: ParseGeoPoint = ParseGeoPoint()
    var company: String = ""
    var companyId: String = ""
    var city: String = ""
    var industry: String = ""
    var monthlySalary: String = ""
    var skills: MutableList<String> = mutableListOf()
    var keySkills: MutableList<String> = mutableListOf()
    var description: String = ""

    var jobSelectedFlag: Boolean = false
    var workStudySelectedFlag: Boolean = false
    var internshipSelectedFlag: Boolean = false
    var otherSelectedFlag: Boolean = false

    var underOneWorkExSelectedFlag: Boolean = false
    var oneToTwoWorkExSelectedFlag: Boolean = false
    var twoPlusWorkExSelectedFlag: Boolean = false
    var distance: Int = 100
    var location: String = ""
    var documentName: String = ""
    var documentUrl: String = ""
    var companyWebsite: String = ""


    var isMonthlySalary: Boolean = true
    var isYearlySalary: Boolean = !isMonthlySalary

    var screeningQuestion: String = ""

    var isArchived = false

    /**
     * 0 -> Low
     * 1 -> Medium
     * 2 -> High
     */
    var hierarchyFlag: Int = -1

    var typeOfWork: MutableList<String> = mutableListOf()
    var benefits: List<String> = listOf()
    var isLoaded = false

    fun isJobCategorySelected(): Boolean {
        return jobSelectedFlag || workStudySelectedFlag || internshipSelectedFlag || otherSelectedFlag
    }

    fun isExperienceSelected(): Boolean {
        return underOneWorkExSelectedFlag || oneToTwoWorkExSelectedFlag || twoPlusWorkExSelectedFlag
    }

    fun toJobOffer(): JobOffer {
        val jobOffer = JobOffer()

        if (this.recruiterId.isNotEmpty())
            jobOffer.recruiterId = this.recruiterId
        if (this.jobOfferId.isNotEmpty())
            jobOffer.jobOfferId = this.jobOfferId
        else jobOffer.jobOfferId = UUID.randomUUID().toString()

        var jobCategory = arrayListOf<String>()
        if (this.jobSelectedFlag)
            jobCategory.add(CONST_JOB)
        if (this.workStudySelectedFlag)
            jobCategory.add(CONST_WORK_STUDY)
        if (this.internshipSelectedFlag)
            jobCategory.add(CONST_INTERNSHIP)
        if (this.otherSelectedFlag)
            jobCategory.add(CONST_OTHER)

        var workEx = arrayListOf<String>()

        if (this.underOneWorkExSelectedFlag)
            workEx.add(CONST_UNDER_ONE)
        if (this.oneToTwoWorkExSelectedFlag)
            workEx.add(CONST_ONE_TO_TWO)
        if (this.twoPlusWorkExSelectedFlag)
            workEx.add(CONST_TWO_PLUS)

        jobOffer.name = this.name
        jobOffer.geoLocation = this.geoLocation
        jobOffer.companyId = this.companyId
        jobOffer.companyName = this.company
        jobOffer.city = this.city
        jobOffer.industry = this.industry
        jobOffer.typeOfWork = typeOfWork
        jobOffer.monthlySalary = this.monthlySalary
        jobOffer.levelOfHierarchy =
            if (this.hierarchyFlag == 0) CONST_LOW else if (hierarchyFlag == 1) CONST_MEDIUM else CONST_HIGH
        jobOffer.skills = this.skills
        jobOffer.jobCategory = jobCategory.toList()
        jobOffer.experience = workEx.toList()
        jobOffer.description = this.description
        jobOffer.keySkills = this.keySkills
        jobOffer.distance = distance
        jobOffer.location = location
        jobOffer.documentName = documentName
        jobOffer.documentUrl = documentUrl
        jobOffer.benefits = benefits
        jobOffer.companyWebsite = companyWebsite
        jobOffer.isMonthlySalary = isMonthlySalary

        jobOffer.screeningQuestion = screeningQuestion
        jobOffer.isArchived = isArchived

        return jobOffer
    }

    constructor()

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

        this.skills = jobOffer.skills.toMutableList()
        this.description = jobOffer.description
        this.keySkills = jobOffer.keySkills.toMutableList()
        this.monthlySalary = jobOffer.monthlySalary

        this.typeOfWork = jobOffer.typeOfWork.toMutableList()
        this.hierarchyFlag =
            if (jobOffer.levelOfHierarchy == CONST_LOW) 0 else if (jobOffer.levelOfHierarchy == CONST_MEDIUM) 1 else 2
        this.distance = jobOffer.distance
        this.location = jobOffer.location
        this.documentName = jobOffer.documentName
        this.documentUrl = jobOffer.documentUrl
        this.benefits = jobOffer.benefits
        this.companyWebsite = jobOffer.companyWebsite
        this.isMonthlySalary = jobOffer.isMonthlySalary

        this.isYearlySalary = !isMonthlySalary

        this.screeningQuestion = jobOffer.screeningQuestion

        this.isArchived = jobOffer.isArchived
    }

}