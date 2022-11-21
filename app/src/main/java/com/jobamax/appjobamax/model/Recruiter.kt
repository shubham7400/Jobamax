package com.jobamax.appjobamax.model

import com.jobamax.appjobamax.enums.ParseTableFields
import com.parse.ParseObject
import java.util.*

class Recruiter {
    var recruiterId: String = UUID.randomUUID().toString()
    var userId: String = ""
    var gender: String = ""
    var firstName: String = ""
    var lastName: String = ""
    var age: String = ""
    var profilePicUrl: String = ""
    var loginType: String = ""
    var dob: String = ""
    var postCode: String = ""
    var email: String = ""
    var scheduleLink: String = ""
    var phoneNumber: String = ""
    var companyId: String = ""
    var hideMeFlag: Boolean = false
    var readReceiptFlag: Boolean = false
    var newMatchPNFlag: Boolean = false
    var messagePNFlag: Boolean = false
    var isNetworkingMuted: Boolean = false
    var isNetworkingHandRaised: Boolean = false
    var newsLetterPNFlag: Boolean = false
    var temporaryDisableFlag: Boolean = false
    var newsLetterNotification: Boolean = false
    var temporaryDisableTime: String = ""
    var socialAccounts: List<String> = listOf()
    var company: ParseObject? = null
    var roomId = 0
    var roomExpiryDate: Date? = null
    var password: String = ""
    var recruiterParseObject: ParseObject? = null

    constructor(user: User) {
        recruiterId = user.id
        userId = user.userId
        email = user.email
        phoneNumber = user.phoneNumber
        loginType = user.loginType
        firstName = user.firstName
        lastName = user.lastName
        profilePicUrl = user.profilePicUrl
        newsLetterPNFlag = true
    }

    fun toParseObject(): ParseObject {
        val recruiter = ParseObject("Recruiter")
        recruiter.put("recruiterId", recruiterId)
        recruiter.put("userId", userId)
        recruiter.put("gender", gender)
        recruiter.put("firstName", firstName)
        recruiter.put("lastName", lastName)
        recruiter.put("age", age)
        recruiter.put("profilePicUrl", profilePicUrl)
        recruiter.put("loginType", loginType)
        recruiter.put("postCode", postCode)
        recruiter.put("email", email)
        recruiter.put("scheduleLink", scheduleLink)
        recruiter.put("password", password)
        recruiter.put("phoneNumber", phoneNumber)
        recruiter.put("companyId", companyId)
        recruiter.put("hideMeFlag", hideMeFlag)
        recruiter.put("readReceiptFlag", readReceiptFlag)
        recruiter.put("newMatchPNFlag", newMatchPNFlag)
        recruiter.put("messagePNFlag", messagePNFlag)
        recruiter.put("isNetworkingMuted", isNetworkingMuted)
        recruiter.put("isNetworkingHandRaised", isNetworkingHandRaised)
        recruiter.put("newsLetterPNFlag", newsLetterPNFlag)
        recruiter.put("temporaryDisableFlag", temporaryDisableFlag)
        recruiter.put("newsLetterNotification", newsLetterNotification)
        recruiter.put("temporaryDisableTime", temporaryDisableTime)
        recruiter.put("dob", dob)
        recruiter.put("socialAccounts", socialAccounts)
        recruiter.put("roomId", roomId.toString())
        recruiter.put("roomExpiryDate", roomExpiryDate ?: Date())
        company?.let { recruiter.put(ParseTableFields.COMPANY.value, it) }

        return recruiter
    }

    constructor()

    constructor(obj: ParseObject) {
        this.recruiterId = obj["recruiterId"].toString()
        this.userId = obj["userId"].toString()
        this.gender = obj["gender"].toString()
        this.firstName = obj["firstName"].toString()
        this.lastName = obj["lastName"].toString()
        this.age = obj["age"].toString()
        this.profilePicUrl = obj["profilePicUrl"].toString()
        this.loginType = obj["loginType"].toString()
        this.postCode = obj["postCode"].toString()
        this.email = obj["email"].toString()
        this.scheduleLink = obj["scheduleLink"].toString()
        this.phoneNumber = obj["phoneNumber"].toString()
        this.companyId = obj["companyId"]?.toString() ?: ""
        this.hideMeFlag = obj["hideMeFlag"].toString().toBoolean()
        this.readReceiptFlag = obj["readReceiptFlag"].toString().toBoolean()
        this.newMatchPNFlag = obj["newMatchPNFlag"].toString().toBoolean()
        this.messagePNFlag = obj["messagePNFlag"].toString().toBoolean()
        this.isNetworkingMuted = obj["isNetworkingMuted"].toString().toBoolean()
        this.isNetworkingHandRaised = obj["isNetworkingHandRaised"].toString().toBoolean()
        this.newsLetterPNFlag = obj["newsLetterPNFlag"].toString().toBoolean()
        this.temporaryDisableFlag = obj["temporaryDisableFlag"].toString().toBoolean()
        this.newsLetterNotification = obj["newsLetterNotification"].toString().toBoolean()
        this.temporaryDisableTime = obj["temporaryDisableTime"].toString()
        this.dob = obj["dob"]?.toString() ?: ""
        this.socialAccounts = (obj["socialAccounts"] as? List<String>) ?: listOf()
        this.roomId = obj["roomId"]?.toString()?.toIntOrNull() ?: 0
        this.company = obj.getParseObject(ParseTableFields.COMPANY.value)
        this.recruiterParseObject = obj
    }

    companion object{
        const val CLASS_NAME="Recruiter"
    }
}



