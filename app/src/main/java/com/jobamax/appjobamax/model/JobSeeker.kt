package com.jobamax.appjobamax.model

import com.google.gson.Gson
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.log
import com.parse.ParseGeoPoint
import com.parse.ParseObject
import org.json.JSONArray
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class JobSeeker {
    val gson = Gson()

    var jobSeekerId: String = UUID.randomUUID().toString()
    var userId: String = ""
    var userObj: ParseObject? = null
    var gender: String = ""
    var firstName: String = ""
    var lastName: String = ""
    var university: String = ""
    var loginType: String = ""
    var profilePicUrl: String = ""
    var introVideoUrl: String = ""
    var introAudioUrl: String = ""
    var postCode: String = ""
    var promoCode: String = ""
    var dob: String = ""
    var email: String = ""
    var phoneNumber: String = ""
    var readReceiptFlag: Boolean = false
    var hideAccount: Boolean = false
    var newMatchPNFlag: Boolean = false
    var messagePNFlag: Boolean = false
    var newsLetterPNFlag: Boolean = false
    var receiveNewsletter: Boolean = false
    var isNetworkingMuted: Boolean = false
    var isNetworkingHandRaised: Boolean = false
    var personalPresentationLink: String = ""
    var attachmentCVLink: String = ""

    var portfolio: ParseObject? = null
    var idealJob: ParseObject? = null


    var hideMeFlag: Boolean = false
    var seenOnboarding: Boolean = false
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
    var images:  ArrayList<String> = arrayListOf()
    var portfolioLinks:  List<String> = listOf()
    var portfolioDocLinks:  List<String> = listOf()

    var documentUrl: String = ""
    var manualCriteria: ManualCriteria? = null
    var educations: ArrayList<Education> = arrayListOf()
    var experiences: ArrayList<Experience> = arrayListOf()
    var volunteerings: ArrayList<Volunteering> = arrayListOf()
    var skills: String = ""
    var hardSkills: ArrayList<HardSkill> = arrayListOf()
    var softSkills: ArrayList<String> = arrayListOf()
    var companyNames: ArrayList<String> = arrayListOf()
    var jobLocation: String = ""
    var city: String = ""
    var interestedIn: List<String> = listOf()
    var age: String = ""
    var ageInt: Int = -1
    var workspaces: List<String> = listOf()
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
    var geoLocation: ParseGeoPoint? = null
    var seenUpdatePopup: Boolean = true
    var profilePercentage: Int = 0
    var seenSwipeTutorial: Boolean = false
    var pfObject: ParseObject? = null


    fun toParseObject(): ParseObject {

        val jobSeeker = ParseObject("JobSeeker")
        jobSeeker.put("jobSeekerId", jobSeekerId)
        jobSeeker.put("userId", userId)
        userObj?.let { jobSeeker.put("user", it) }
        jobSeeker.put("gender", gender)
        jobSeeker.put("firstName", firstName)
        jobSeeker.put("lastName", lastName)
        jobSeeker.put("university", university)
        jobSeeker.put("loginType", loginType)
        jobSeeker.put("profilePicUrl", profilePicUrl)
        jobSeeker.put("introVideoUrl", introVideoUrl)
        jobSeeker.put("introAudioUrl", introAudioUrl)
        jobSeeker.put("dob", dob)
        jobSeeker.put("postCode", postCode)
        jobSeeker.put("promoCode", promoCode)
        jobSeeker.put("email", email)
        jobSeeker.put("phoneNumber", phoneNumber)
        jobSeeker.put("readReceiptFlag", readReceiptFlag)
        jobSeeker.put("hideAccount", hideAccount)
        jobSeeker.put("newMatchPNFlag", newMatchPNFlag)
        jobSeeker.put("messagePNFlag", messagePNFlag)
        jobSeeker.put("newsLetterPNFlag", newsLetterPNFlag)
        jobSeeker.put("receiveNewsletter", receiveNewsletter)
        jobSeeker.put("isNetworkingMuted", isNetworkingMuted)
        jobSeeker.put("isNetworkingHandRaised", isNetworkingHandRaised)
        jobSeeker.put("personalPresentationLink", personalPresentationLink)
        jobSeeker.put("attachmentCVLink", attachmentCVLink)
        jobSeeker.put("images", images)
        jobSeeker.put("portfolioLinks", portfolioLinks)
        jobSeeker.put("portfolioDocLinks", portfolioDocLinks)

        portfolio?.let { jobSeeker.put("portfolio", it) }
        idealJob?.let { jobSeeker.put("idealJob", it) }

        jobSeeker.put("hideMeFlag", hideMeFlag)
        jobSeeker.put("seenOnboarding", seenOnboarding)
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
        manualCriteria?.let { jobSeeker.put(ParseTableFields.MANUAL_CRITERIA.value, gson.toJson(it)) }
        jobSeeker.put(ParseTableFields.EDUCATIONS.value, gson.toJson(EducationGroup(educations)) )
        jobSeeker.put(ParseTableFields.EXPERIENCES.value, gson.toJson(ExperienceGroup(experiences)) )
        jobSeeker.put(ParseTableFields.VOLUNTEERINGS.value, gson.toJson(VolunteeringGroup(volunteerings)) )
        jobSeeker.put("skills", skills)
        jobSeeker.put(ParseTableFields.HARD_SKILLS.value, getHardSkills())
        jobSeeker.put(ParseTableFields.SOFT_SKILLS.value, getSoftSkills())
        jobSeeker.put(ParseTableFields.COMPANY_NAMES.value, companyNames)
        jobSeeker.put("jobLocation", jobLocation)
        jobSeeker.put("city", city)
        jobSeeker.put("interestedIn", interestedIn)
        jobSeeker.put("age", age)
        jobSeeker.put(ParseTableFields.AGE_INT.value, ageInt)
        jobSeeker.put("workspaces", workspaces)
        jobSeeker.put("activities", activities)
        jobSeeker.put(ParseTableFields.INTERESTS.value, interests)
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
        geoLocation?.let { jobSeeker.put(ParseTableFields.GEO_LOCATION.value, it) }
        jobSeeker.put(ParseTableFields.SEEN_UPDATE_POPUP.value, seenUpdatePopup)
        jobSeeker.put(ParseTableFields.PROFILE_PERCENTAGE.value, profilePercentage)
        jobSeeker.put(ParseTableFields.SEEN_SWIPE_TUTORIAL.value, seenSwipeTutorial)
        return jobSeeker
    }

    private fun getSoftSkills(): String {
        val arr = JSONArray()
        softSkills.forEach { arr.put(it) }
        return arr.toString()
    }

    private fun getHardSkills(): String {
        val obj = JSONObject()
        hardSkills.forEach {
            obj.put(it.skillName, it.skillLevel)
        }
        return obj.toString()
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
        this.email = obj["email"]?.toString() ?: ""
        this.university = obj["university"]?.toString() ?: ""
        this.loginType = obj["loginType"].toString()
        this.profilePicUrl = obj["profilePicUrl"].toString()
        this.introVideoUrl = obj["introVideoUrl"]?.toString() ?: ""
        this.introAudioUrl = obj["introAudioUrl"]?.toString() ?: ""
        this.dob = obj["dob"].toString()
        this.postCode = obj["postCode"].toString()
        this.postCode = obj["postCode"].toString()
        this.promoCode = obj["promoCode"].toString()
        this.phoneNumber = obj["phoneNumber"].toString()
        this.readReceiptFlag = obj["readReceiptFlag"].toString().toBoolean()
        this.newMatchPNFlag = obj["newMatchPNFlag"].toString().toBoolean()
        this.messagePNFlag = obj["messagePNFlag"].toString().toBoolean()
        this.hideAccount = obj["hideAccount"].toString().toBoolean()
        this.isNetworkingMuted = obj["isNetworkingMuted"].toString().toBoolean()
        this.isNetworkingHandRaised = obj["isNetworkingHandRaised"].toString().toBoolean()
        this.newsLetterPNFlag = obj["newsLetterPNFlag"].toString().toBoolean()
        this.receiveNewsletter = obj["receiveNewsletter"].toString().toBoolean()
        this.personalPresentationLink = obj["personalPresentationLink"].toString()
        this.attachmentCVLink = obj["attachmentCVLink"].toString()

        this.portfolio = obj.getParseObject("portfolio")
        this.idealJob = obj.getParseObject("idealJob")

        this.hideMeFlag = obj["hideMeFlag"]?.toString().toBoolean()
        this.seenOnboarding = obj["seenOnboarding"]?.toString().toBoolean()
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
        this.images = (obj["images"] as? ArrayList<String>) ?: arrayListOf()
        this.portfolioLinks = (obj["portfolioLinks"] as? List<String>) ?: listOf()
        this.portfolioDocLinks = (obj["portfolioDocLinks"] as? List<String>) ?: listOf()
        this.documentUrl = obj["documentUrl"]?.toString() ?: ""
        this.manualCriteria = convertStringToManualCriteria(obj[ParseTableFields.MANUAL_CRITERIA.value])
        this.educations = convertStringToEducations(obj[ParseTableFields.EDUCATIONS.value])
        this.experiences = convertStringToExperiences(obj[ParseTableFields.EXPERIENCES.value])
        this.volunteerings = convertStringToVolunteerings(obj[ParseTableFields.VOLUNTEERINGS.value])
        this.skills = obj["skills"]?.toString() ?: ""
        this.hardSkills = convertStringToHardSkills(obj[ParseTableFields.HARD_SKILLS.value])
        this.softSkills = convertStringToSoftSkills(obj[ParseTableFields.SOFT_SKILLS.value])
        this.companyNames = (obj[ParseTableFields.COMPANY_NAMES.value] as? ArrayList<String>) ?: arrayListOf()
        this.jobLocation = obj["jobLocation"]?.toString() ?: ""
        this.city = obj["city"]?.toString() ?: ""
        this.interestedIn = (obj["interestedIn"] as? List<String>) ?: listOf()
        this.age = obj["age"]?.toString() ?: ""
        this.ageInt = obj[ParseTableFields.AGE_INT.value]?.toString()?.toInt() ?: -1
        this.workspaces = (obj["workspaces"] as? List<String>) ?: listOf()
        this.activities = obj["activities"]?.toString() ?: ""
        this.interests =  (obj[ParseTableFields.INTERESTS.value] as? List<String>) ?: listOf()
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
        this.geoLocation = obj.getParseGeoPoint(ParseTableFields.GEO_LOCATION.value)
        this.seenUpdatePopup = obj.getBoolean(ParseTableFields.SEEN_UPDATE_POPUP.value)
        this.seenSwipeTutorial = obj.getBoolean(ParseTableFields.SEEN_SWIPE_TUTORIAL.value)
        this.profilePercentage = obj.getInt(ParseTableFields.PROFILE_PERCENTAGE.value)
        this.pfObject = obj
    }



    private fun convertStringToManualCriteria(any: Any?): ManualCriteria {
        if (any == null) return ManualCriteria()
        return try {
            gson.fromJson(any.toString(), ManualCriteria::class.java)
        }catch (e: Exception){ ManualCriteria() }
    }


    private fun convertStringToSoftSkills(any: Any?): ArrayList<String> {
        if (any == null) return arrayListOf()
        val list = arrayListOf<String>()
        return try {
            val jsonArray =  JSONArray(any.toString())
            for (i in 0 until jsonArray.length()){
                list.add(jsonArray.getString(i) )
            }
            list
        }catch (e: Exception){
            arrayListOf()
        }
    }

    private fun convertStringToHardSkills(any: Any?): ArrayList<HardSkill> {
        if (any == null) return arrayListOf()
        val list = arrayListOf<HardSkill>()
        return try {
            val hardSkillJsonObj = JSONObject(any.toString())
            for (key in hardSkillJsonObj.keys().iterator())  {
                list.add(HardSkill(key, hardSkillJsonObj.getInt(key)))
            }
            list
        }catch (e: Exception){
            arrayListOf()
        }
    }

    private fun convertStringToVolunteerings(any: Any?): ArrayList<Volunteering> {
        if (any == null) return arrayListOf()
        val volunteeringGroup = gson.fromJson(any.toString(), VolunteeringGroup::class.java)
        return volunteeringGroup?.list ?: arrayListOf()
    }

    private fun convertStringToExperiences(any: Any?): ArrayList<Experience> {
        if (any == null) return arrayListOf()
        val experienceGroup = gson.fromJson(any.toString(), ExperienceGroup::class.java)
        return experienceGroup?.list ?: arrayListOf()
    }

    private fun convertStringToEducations(any: Any?) : ArrayList<Education> {
        if (any == null) return arrayListOf()
        val educationGroup = gson.fromJson(any.toString(), EducationGroup::class.java)
        return educationGroup?.list ?: arrayListOf()
    }

    constructor()

    companion object {
        const val CLASS_NAME = "JobSeeker"
    }

}