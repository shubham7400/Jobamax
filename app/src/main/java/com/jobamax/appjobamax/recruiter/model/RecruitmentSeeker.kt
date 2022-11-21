package com.jobamax.appjobamax.recruiter.model

import java.io.Serializable


data class RecruitmentSeeker (
    val profileURL: String,
    val softSkills: String,
    val lastName: String,
    val images: List<String>,
    val city: String,
    val university: String,
    var rating: Long,
    val educations: String,
    val portfolioLinks: List<String>,
    val experiences: String,
    val matchedPercentage: Long,
    val firstName: String,
    val elevatorPitch: String,
    val portfolioDocLinks: List<String>,
    val jobOfferId: String,
    val volunteerings: String,
    val workspaces: List<String>,
    val interests: List<String>,
    val jobSeekerId: String,
    val hardSkills: String,
    val interestedIn: List<String>
) : Serializable