package com.findajob.jobamax.jobseeker.profile.jobSearch

import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.util.*

class JobSearchState {

    var jobSeekerId: String = ""
    var hideMeFlag: Boolean = false
    var job: String = ""
    var location: String = ""
    var distance: Int = 100 // the default KM in progress bar
    var lat: Float = 0f
    var lng: Float = 0f

    var jobSelectedFlag: Boolean = false
    var workStudySelectedFlag: Boolean = false
    var internshipSelectedFlag: Boolean = false
    var otherSelectedFlag: Boolean = false

    var underOneWorkExSelectedFlag: Boolean = false
    var oneToTwoWorkExSelectedFlag: Boolean = false
    var twoPlusWorkExSelectedFlag: Boolean = false

    var typeOfWork: MutableList<String> = mutableListOf()

    constructor()

    constructor(jobSeeker: JobSeeker) {
        this.jobSeekerId = jobSeeker.jobSeekerId
        this.hideMeFlag = jobSeeker.hideMeFlag
        this.job = jobSeeker.job
        this.location = jobSeeker.location
        this.distance = 100 // if (jobSeeker.distance == 0) 100 else jobSeeker.distance
        this.lat = jobSeeker.lat
        this.lng = jobSeeker.lng

        this.jobSelectedFlag = jobSeeker.jobCategory.contains(CONST_JOB)
        this.workStudySelectedFlag = jobSeeker.jobCategory.contains(CONST_WORK_STUDY)
        this.internshipSelectedFlag = jobSeeker.jobCategory.contains(CONST_INTERNSHIP)
        this.otherSelectedFlag = jobSeeker.jobCategory.contains(CONST_OTHER)

        this.underOneWorkExSelectedFlag = jobSeeker.experience.contains(CONST_UNDER_ONE)
        this.oneToTwoWorkExSelectedFlag = jobSeeker.experience.contains(CONST_ONE_TO_TWO)
        this.twoPlusWorkExSelectedFlag = jobSeeker.experience.contains(CONST_TWO_PLUS)

        this.typeOfWork = jobSeeker.typeOfWork.toMutableList()
    }

    fun toJobSeeker(): JobSeeker {
        val jobSeeker = JobSeeker()
        val jobCategory = arrayListOf<String>()
        if (this.jobSelectedFlag)
            jobCategory.add(CONST_JOB)
        if (this.workStudySelectedFlag)
            jobCategory.add(CONST_WORK_STUDY)
        if (this.internshipSelectedFlag)
            jobCategory.add(CONST_INTERNSHIP)
        if (this.otherSelectedFlag)
            jobCategory.add(CONST_OTHER)

        val workEx = arrayListOf<String>()

        if (this.underOneWorkExSelectedFlag)
            workEx.add(CONST_UNDER_ONE)
        if (this.oneToTwoWorkExSelectedFlag)
            workEx.add(CONST_ONE_TO_TWO)
        if (this.twoPlusWorkExSelectedFlag)
            workEx.add(CONST_TWO_PLUS)


        jobSeeker.jobSeekerId = this.jobSeekerId
        jobSeeker.hideMeFlag = this.hideMeFlag
        jobSeeker.job = this.job
        jobSeeker.location = this.location
        jobSeeker.distance = this.distance
        jobSeeker.lat = this.lat
        jobSeeker.lng = this.lng
        jobSeeker.typeOfWork = typeOfWork
        jobSeeker.jobCategory = jobCategory
        jobSeeker.experience = workEx
        return jobSeeker
    }

}