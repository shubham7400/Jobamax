package com.findajob.jobamax.repo

import com.findajob.jobamax.jobseeker.profile.cv.model.*
import com.findajob.jobamax.util.log
import com.google.gson.Gson
import com.parse.ParseObject


interface JobSeekerResumeRepo {
    suspend fun saveResumeData(
        jobSeekerPo: ParseObject?, educations: ArrayList<Education>,
        experiences: ArrayList<Experience>,
        skills: ArrayList<String>,
        activities: ArrayList<String>,
        aboutMe: String,
    ): Boolean
}

class JobSeekerResumeRepoImpl(private val gsonConverter: Gson) : JobSeekerResumeRepo {
    override suspend fun saveResumeData(
        jobSeekerPo: ParseObject?,
        educations: ArrayList<Education>,
        experiences: ArrayList<Experience>,
        skills: ArrayList<String>,
        activities: ArrayList<String>,
        aboutMe: String,
    ): Boolean {
        if (jobSeekerPo == null) return false

        return try {
            jobSeekerPo.put("educations", gsonConverter.toJson(EducationGroup(educations)))
            jobSeekerPo.put("experiences", gsonConverter.toJson(ExperienceGroup(experiences)))
            jobSeekerPo.put("skills", gsonConverter.toJson(SKillGroup(skills)))
            jobSeekerPo.put("activities", gsonConverter.toJson(ActivityGroup(activities)))
            log("posting about me as -> $aboutMe")
            jobSeekerPo.put("aboutMe", aboutMe)

            jobSeekerPo.save()
            true
        } catch (e: Exception) {
            log("saveResumeData: Could not save the resume", e)
            false
        }
    }
}