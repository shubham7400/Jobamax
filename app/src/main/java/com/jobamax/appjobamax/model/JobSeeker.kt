package com.jobamax.appjobamax.model

import com.parse.ParseObject
import java.util.*

class JobSeeker {

    var jobSeekerId: String = UUID.randomUUID().toString()
    var userId: String = ""
    var userObj: ParseObject? = null
    var gender: String = ""
    var firstName: String = ""
    var lastName: String = ""
    var loginType: String = ""
    var profilePicUrl: String = ""
    var postCode: String = ""
    var dob: String = ""
    var email: String = ""
    var phoneNumber: String = ""
    var readReceiptFlag: Boolean = false
    var newMatchPNFlag: Boolean = false
    var messagePNFlag: Boolean = false
    var newsLetterPNFlag: Boolean = false
    var isNetworkingMuted: Boolean = false
    var isNetworkingHandRaised: Boolean = false
    var personalPresentationLink: String = ""
    var attachmentCVLink: String = ""

    var portfolio: ParseObject? = null
    var idealJob: ParseObject? = null


    var hideMeFlag: Boolean = false
    var job: String = ""
    var location: String = ""
    var accountType: Int = 0
    var distance: Int = 0
    var lat: Double = 0.0
    var lng: Double = 0.0
    var typeOfWork: List<String> = listOf()
    var jobCategory: List<String> = listOf()
    var experience: List<String> = listOf()
    var socialAccounts: List<String> = listOf()

    var documentUrl: String = ""
    var educations: String = ""
    var experiences: String = ""
    var skills: String = ""
    var hardSkills: String = ""
    var softSkills: String = ""
    var workspaces: List<String> = listOf()
    var volunteerings: String = ""
    var activities: String = ""
    var interests: List<String> = listOf()
    var instagramLink: String = ""
    var linkedInLink: String = ""
    var tikTokLink: String = ""
    var aboutMe: String = ""
    var profession: String = ""
    var elevatorPitch: String = ""

    var documentName: String = ""
    var videoThumbnailUrl: String = ""

    var disableAccountFlag = false
    var totalReach = 0
    var todayReach = 0
    var lastTodayReachUpdatedAt: String = ""
    var roomId = 0
    var roomExpiryDate: Date? = null
    var emailVerified = false
    var password = ""
    var gotReferralCode = ""
    var pfObject: ParseObject? = null


    fun toParseObject(): ParseObject {

        val jobSeeker = ParseObject("JobSeeker")
        jobSeeker.put("jobSeekerId", jobSeekerId)
        jobSeeker.put("userId", userId)
        userObj?.let { jobSeeker.put("user", it) }
        jobSeeker.put("gender", gender)
        jobSeeker.put("firstName", firstName)
        jobSeeker.put("lastName", lastName)
        jobSeeker.put("loginType", loginType)
        jobSeeker.put("profilePicUrl", profilePicUrl)
        jobSeeker.put("dob", dob)
        jobSeeker.put("postCode", postCode)
        jobSeeker.put("email", email)
        jobSeeker.put("phoneNumber", phoneNumber)
        jobSeeker.put("readReceiptFlag", readReceiptFlag)
        jobSeeker.put("newMatchPNFlag", newMatchPNFlag)
        jobSeeker.put("messagePNFlag", messagePNFlag)
        jobSeeker.put("newsLetterPNFlag", newsLetterPNFlag)
        jobSeeker.put("isNetworkingMuted", isNetworkingMuted)
        jobSeeker.put("isNetworkingHandRaised", isNetworkingHandRaised)
        jobSeeker.put("personalPresentationLink", personalPresentationLink)
        jobSeeker.put("attachmentCVLink", attachmentCVLink)

        portfolio?.let { jobSeeker.put("portfolio", it) }
        idealJob?.let { jobSeeker.put("idealJob", it) }

        jobSeeker.put("hideMeFlag", hideMeFlag)
        jobSeeker.put("job", job)
        jobSeeker.put("location", location)
        jobSeeker.put("accountType", accountType)
        jobSeeker.put("distance", distance)
        jobSeeker.put("lat", lat)
        jobSeeker.put("lng", lng)
        jobSeeker.put("typeOfWork", typeOfWork)
        jobSeeker.put("jobCategory", jobCategory)
        jobSeeker.put("experience", experience)
        jobSeeker.put("socialAccounts", socialAccounts)

        jobSeeker.put("documentUrl", documentUrl)
        jobSeeker.put("educations", educations)
        jobSeeker.put("experiences", experiences)
        jobSeeker.put("skills", skills)
        jobSeeker.put("hardSkills", hardSkills)
        jobSeeker.put("softSkills", softSkills)
        jobSeeker.put("workspaces", workspaces)
        jobSeeker.put("volunteerings", volunteerings)
        jobSeeker.put("activities", activities)
        jobSeeker.put("interests", interests)
        jobSeeker.put("instagramLink", instagramLink)
        jobSeeker.put("linkedInLink", linkedInLink)
        jobSeeker.put("tikTokLink", tikTokLink)
        jobSeeker.put("aboutMe", aboutMe)
        jobSeeker.put("profession", profession)
        jobSeeker.put("elevatorPitch", elevatorPitch)

        jobSeeker.put("documentName", documentName)
        jobSeeker.put("videoThumbnailUrl", videoThumbnailUrl)
        jobSeeker.put("disableAccountFlag", disableAccountFlag)
        jobSeeker.put("totalReach", totalReach)
        jobSeeker.put("todayReach", todayReach)
        jobSeeker.put("lastTodayReachUpdatedAt", lastTodayReachUpdatedAt)
        jobSeeker.put("roomId", roomId.toString())
        jobSeeker.put("roomExpiryDate", roomExpiryDate ?: Date())
        jobSeeker.put("emailVerified", emailVerified)
        jobSeeker.put("password", password)
        jobSeeker.put("gotReferralCode", gotReferralCode)
        return jobSeeker
    }

    constructor(user: User) {
        jobSeekerId = user.id
        userId = user.userId
        userObj = ParseObject.createWithoutData("_User", userId)
        email = user.email
        phoneNumber = user.phoneNumber
        loginType = user.loginType
        firstName = user.firstName
        lastName = user.lastName
        profilePicUrl = user.profilePicUrl
        newsLetterPNFlag = true
    }

    constructor(obj: ParseObject) {
        this.jobSeekerId = obj["jobSeekerId"].toString()
        this.userId = obj["userId"].toString()
        this.gender = obj["gender"].toString()
        this.emailVerified = obj["emailVerified"].toString().toBoolean()
        this.userObj = obj.getParseObject("_User")
        this.firstName = obj["firstName"]?.toString() ?: ""
        this.lastName = obj["lastName"]?.toString() ?: ""
        this.loginType = obj["loginType"].toString()
        this.profilePicUrl = obj["profilePicUrl"].toString()
        this.dob = obj["dob"].toString()
        this.postCode = obj["postCode"].toString()
        this.email = obj["email"].toString()
        this.phoneNumber = obj["phoneNumber"].toString()
        this.readReceiptFlag = obj["readReceiptFlag"].toString().toBoolean()
        this.newMatchPNFlag = obj["newMatchPNFlag"].toString().toBoolean()
        this.messagePNFlag = obj["messagePNFlag"].toString().toBoolean()
        this.isNetworkingMuted = obj["isNetworkingMuted"].toString().toBoolean()
        this.isNetworkingHandRaised = obj["isNetworkingHandRaised"].toString().toBoolean()
        this.newsLetterPNFlag = obj["newsLetterPNFlag"].toString().toBoolean()
        this.personalPresentationLink = obj["personalPresentationLink"].toString()
        this.attachmentCVLink = obj["attachmentCVLink"].toString()

        this.portfolio = obj.getParseObject("portfolio")
        this.idealJob = obj.getParseObject("idealJob")

        this.hideMeFlag = obj["hideMeFlag"]?.toString().toBoolean()
        this.job = obj["job"]?.toString() ?: ""
        this.location = obj["location"]?.toString() ?: ""
        this.distance = obj["distance"]?.toString()?.toIntOrNull() ?: 50
        this.accountType = obj["accountType"]?.toString()?.toIntOrNull() ?: -1
        this.lat = obj["lat"].toString().toDoubleOrNull() ?: 0.0
        this.lng = obj["lng"].toString().toDoubleOrNull() ?: 0.0
        this.typeOfWork = (obj["typeOfWork"] as? List<String>) ?: listOf()
        this.jobCategory = (obj["jobCategory"] as? List<String>) ?: listOf()
        this.experience = (obj["experience"] as? List<String>) ?: listOf()
        this.socialAccounts = (obj["socialAccounts"] as? List<String>) ?: listOf()
        this.documentUrl = obj["documentUrl"]?.toString() ?: ""
        this.educations = obj["educations"]?.toString() ?: ""
        this.experiences = obj["experiences"]?.toString() ?: ""
        this.skills = obj["skills"]?.toString() ?: ""
        this.hardSkills = obj["hardSkills"]?.toString() ?: ""
        this.softSkills = obj["softSkills"]?.toString() ?: ""
        this.workspaces = (obj["workspaces"] as? List<String>) ?: listOf()
        this.volunteerings = obj["volunteerings"]?.toString() ?: ""
        this.activities = obj["activities"]?.toString() ?: ""
        this.interests =  (obj["interests"] as? List<String>) ?: listOf()
        this.instagramLink = obj["instagramLink"]?.toString() ?: ""
        this.linkedInLink = obj["linkedInLink"]?.toString() ?: ""
        this.tikTokLink = obj["tikTokLink"]?.toString() ?: ""
        this.aboutMe = obj["aboutMe"]?.toString() ?: ""
        this.profession = obj["profession"]?.toString() ?: ""
        this.elevatorPitch = obj["elevatorPitch"]?.toString() ?: ""

        this.documentName = obj["documentName"]?.toString() ?: ""
        this.videoThumbnailUrl = obj["videoThumbnailUrl"]?.toString() ?: ""
        this.disableAccountFlag = obj["disableAccountFlag"]?.toString().toBoolean()
        this.totalReach = obj["totalReach"]?.toString()?.toIntOrNull() ?: 0
        this.todayReach = obj["todayReach"]?.toString()?.toIntOrNull() ?: 0
        this.lastTodayReachUpdatedAt = obj["lastTodayReachUpdatedAt"]?.toString() ?: ""
        this.roomId = obj["roomId"]?.toString()?.toIntOrNull() ?: 0
        this.pfObject = obj
    }

    constructor()

    companion object {
        const val CLASS_NAME = "JobSeeker"
    }
}