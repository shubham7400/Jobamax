package com.findajob.jobamax.jobseeker.home

import android.app.Application
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.findajob.jobamax.base.BaseAndroidViewModel
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel
 import com.findajob.jobamax.jobseeker.profile.cv.model.*

import com.findajob.jobamax.model.*
import com.findajob.jobamax.preference.getCurrentLocation
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.preference.setNewMatchPNFlag
import com.findajob.jobamax.preference.setProfilePicUrl
import com.findajob.jobamax.util.*
import com.google.gson.Gson
import com.parse.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


@HiltViewModel
class JobSeekerHomeViewModel @Inject constructor(val context: Application) : BaseAndroidViewModel(context) {

    var jobSeekerObject: ParseObject? = null
    var jobOffers: ArrayList<ParseObject> = arrayListOf()

    var jobOfferPageIndex = 0
    var isJobOfferExhausted = false



    val jobSeeker get() = if (jobSeekerObject == null) JobSeeker() else JobSeeker(jobSeekerObject!!)

    private val _jobOfferLiveData = MutableLiveData<List<ParseObject>>()
    val jobOfferLiveData: LiveData<List<ParseObject>> = _jobOfferLiveData

    var isJobSeekerUpdated = MutableLiveData<Boolean>()

    var currentIndex = 0
    var jobOfferButtonCallback: JobOfferButtonCallback = JobOfferButtonCallback.NONE

    enum class JobOfferButtonCallback {
        NONE,
        CHAT,
        REJECT,
        ACCEPT
    }


    fun getJobSeeker() {
        viewModelScope.launch {
            val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
            query.whereEqualTo(ParseTableFields.jobSeekerId.toString(), context.getUserId())
            query.findInBackground { it, e ->
                val parseObject = it?.firstOrNull()
                when {
                    e != null -> {
                        log(e.message.toString())
                    }
                    jobSeeker == null -> {
                        log("User Not Found")
                    }
                    else -> {
                        jobSeekerObject = parseObject


                        if (jobSeeker.disableAccountFlag) {
                            jobSeekerObject?.put("disableAccountFlag", false)
                            jobSeekerObject?.saveInBackground()
                        }

                        context.setNewMatchPNFlag(jobSeeker.newMatchPNFlag)
                        currentIndex = 0
                        jobOfferPageIndex = 0
                        isJobOfferExhausted = false
                        jobOffers = arrayListOf()

                        if (jobSeeker.lastTodayReachUpdatedAt < Date().toText()) {
                            jobSeekerObject?.put("lastTodayReachUpdatedAt", Date().toText())
                            jobSeekerObject?.put("todayReach", 3)
                            jobSeekerObject?.saveInBackground()
                        }

                        isJobSeekerUpdated.value = true
                    }
                }
            }
        }
    }


    private val _selectedJobOffer = MutableLiveData<ParseObject>()
    val selectedJobOffer: LiveData<ParseObject> = _selectedJobOffer








    private val _pushNotificationStateObserver = MutableLiveData<Pair<Boolean, Boolean>>()
    val pushNotificationStateObserver: LiveData<Pair<Boolean, Boolean>> =
        _pushNotificationStateObserver

    fun getPushNotificationState() {
//        jobSeekerObject.
    }

    fun updateMessagePushNotificationFlag(flag: Boolean) {
        jobSeekerObject!!.put("messagePNFlag", flag)
        jobSeekerObject!!.saveInBackground {

        }
    }


    fun updateNewsMatchesPushNotificationFlag(flag: Boolean) {
        jobSeekerObject!!.put("newMatchPNFlag", flag)
        jobSeekerObject!!.saveInBackground {

        }
    }


    fun updateFlag(flag: Boolean, key: String, callback: UpdateUserCallback) {
        jobSeekerObject?.put(key, flag)
        jobSeekerObject?.saveInBackground {
            callback.onFinish(it == null)
        }
    }

    fun submitData(personalInfoModel: JobSeekerPersonalInformationModel, callback: (it: ParseException?) -> Unit) {
        jobSeekerObject!!.put(ParseTableFields.firstName.toString(), personalInfoModel.firstName)
        jobSeekerObject!!.put(ParseTableFields.lastName.toString(), personalInfoModel.lastName)
        jobSeekerObject!!.put(ParseTableFields.gender.toString(), personalInfoModel.gender)
        jobSeekerObject!!.put(ParseTableFields.postCode.toString(), personalInfoModel.postCode)
        jobSeekerObject!!.put(ParseTableFields.dob.toString(), personalInfoModel.dob)
        jobSeekerObject!!.put(ParseTableFields.email.toString(), personalInfoModel.email)
        jobSeekerObject!!.put(ParseTableFields.phoneNumber.toString(), personalInfoModel.phoneNumber)

        jobSeekerObject!!.saveInBackground {
            callback(it)
        }
    }



    fun uploadProfilePicUri(profilePicUri: Uri, callback: SaveParseObjectCallback) {
        val inputStream: InputStream? = context.contentResolver.openInputStream(profilePicUri)
        var fileName = context.getFileName(profilePicUri)
        if (fileName.isEmpty())
            fileName = Date().yyyyMMddHHmmss()
        val parseFile = ParseFile(fileName, inputStream?.readBytes())
        parseFile.saveInBackground(SaveCallback {
            if (it == null) {
                jobSeekerObject?.put("profilePicUrl", parseFile.url)
                context.setProfilePicUrl(parseFile.url ?: "")
                jobSeekerObject?.saveInBackground { exception ->
                    callback.onFinish(exception == null)
                }
            } else callback.onFinish(false)
        })

    }

    fun savePaymentMethod(paymentMethodId: String, callback: SaveCardDetailsCallback) {
        val params = HashMap<String, Any>()
        if (!paymentMethodId.isNullOrEmpty())
            params["paymentMethodId"] = paymentMethodId
        params["userId"] = ParseUser.getCurrentUser().objectId

        ParseCloud.callFunctionInBackground(
            "updateCard",
            params,
            FunctionCallback<Any?> { response, e ->
                if (e == null) {
                    Log.d("Cloud Response", "There were no exceptions! $response")
                    callback.onSuccess(response)
                } else {
                    log("Exception: $e", e)
                    callback.onFailure(e)
                }
            })
    }

    fun getCardDetails(callback: GetCardDetailsCallback) {
        val params = HashMap<String, Any>()
        params["userId"] = jobSeekerObject!!.objectId
        ParseCloud.callFunctionInBackground("retrieveCard", params, FunctionCallback<HashMap<String, Any>?> { response, e ->
                if (e == null) {
                    callback.onSuccess(response)

                } else {
                    log("get card details failed", e)
                    callback.onFailure(e)
                }
            })
    }







    private val _deleteAccountStatus: MutableLiveData<Boolean> by lazy {
        MutableLiveData()
    }
    val deleteAccountLiveData: LiveData<Boolean> by lazy {
        _deleteAccountStatus
    }



    fun changePassword(newPassword: String, callback: (it: ParseException?) -> Unit) {
        jobSeekerObject!!.put(ParseTableFields.password.toString(), newPassword)
        jobSeekerObject!!.saveInBackground {
            callback(it)
        }
    }



    fun addNewOrUpdateEducation(education: Education, callback: (it: ParseException?) -> Unit) {
        val educations = try {
            ArrayList(Gson().fromJson(jobSeekerObject?.get("educations").toString(), EducationGroup::class.java)?.list ?: listOf())
        }catch (e: java.lang.Exception){
            log("${e.message.toString()}")
            arrayListOf()
        }
        var isEducationExist = false
        for (edu in educations.iterator()){
            if (edu.id == education.id){
                isEducationExist = true
                educations[educations.indexOf(edu)].apply {
                    name = education.name
                    program = education.program
                    gpa = education.gpa
                    startDate = education.startDate
                    endDate = education.endDate
                    logo = education.logo
                }
            }
        }
        if (!isEducationExist){
            educations.add(education)
        }
        val educationGroup = EducationGroup(educations)
        jobSeekerObject?.put(ParseTableFields.educations.toString(), Gson().toJson(educationGroup))
        jobSeekerObject!!.saveInBackground {
            callback(it)
            getJobSeeker()
        }
    }

    fun saveNewEducationList(educations: ArrayList<Education>, callback: (it: ParseException?) -> Unit) {
        val educationGroup = EducationGroup(educations)
        jobSeekerObject?.put(ParseTableFields.educations.toString(), Gson().toJson(educationGroup))
        jobSeekerObject!!.saveInBackground {
            callback(it)
            getJobSeeker()
        }
    }

    fun saveHardSkills(hardSkillJsonObj: JSONObject, callback: (it: ParseException?) -> Unit) {
        jobSeekerObject?.put(ParseTableFields.hardSkills.toString(), hardSkillJsonObj.toString())
        jobSeekerObject?.saveInBackground {
           callback(it)
        }
    }

    fun saveSoftSkills(softSkillJsonArray: JSONArray, callback: (it: ParseException?) -> Unit) {
        jobSeekerObject?.put(ParseTableFields.softSkills.toString(), softSkillJsonArray.toString())
        jobSeekerObject?.saveInBackground {
            callback(it)
        }
    }

    fun addWorkSpace(ownedWorkSpaces: ArrayList<String>, callback: (it: ParseException?) -> Unit) {
        jobSeekerObject?.put( ParseTableFields.workspaces.toString(), ownedWorkSpaces)
        jobSeekerObject?.saveInBackground {
            callback(it)
        }
    }


    fun addInterestTags(interestTags: ArrayList<String>, callback: (it: ParseException?) -> Unit) {
        val interestTagsJsonArray = JSONArray()
        interestTags.forEach {
            interestTagsJsonArray.put(it)
        }
         jobSeekerObject?.put(ParseTableFields.interests.toString(), interestTagsJsonArray)
        jobSeekerObject?.saveInBackground {
            callback(it)
        }
    }

    fun addAndUpdateExperience(experience: Experience, callback: (it: ParseException?) -> Unit) {
        val experiences = ArrayList(Gson().fromJson(jobSeekerObject?.get(ParseTableFields.experiences.toString()).toString(), ExperienceGroup::class.java)?.list ?: listOf())
        var isExperienceExist = false
        for (edu in experiences.iterator()){
            if (edu.id == experience.id){
                isExperienceExist = true
                experiences[experiences.indexOf(edu)].apply {
                    this.job = experience.job
                    this.company = experience.company
                    this.description = experience.description
                    this.location = experience.location
                    this.startDate  = experience.endDate
                }
            }
        }
        if (!isExperienceExist){
            experiences.add(experience)
        }
        val experienceGroup = ExperienceGroup(experiences)
        jobSeekerObject?.put(ParseTableFields.experiences.toString(), Gson().toJson(experienceGroup))
        jobSeekerObject!!.saveInBackground {
            callback(it)
            getJobSeeker()
        }
    }

    fun saveNewExperienceList(experiences: ArrayList<Experience>, callback: (ParseException?) -> Unit) {
        val experienceGroup = ExperienceGroup(experiences)
        jobSeekerObject?.put(ParseTableFields.experiences.toString(), Gson().toJson(experienceGroup))
        jobSeekerObject!!.saveInBackground {
            callback(it)
            getJobSeeker()
        }
    }

    fun getExistingHardSkillTags(callback: GetAllUserCallback) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.HardSkill.toString())
        query.findInBackground { it, e ->
            val jobSeeker = it?.firstOrNull()
            when {
                e != null -> {
                    callback.onFailure(e)
                }
                jobSeeker == null -> {
                    callback.onFailure(java.lang.Exception("User Not Found"))
                }
                else -> {
                    callback.onSuccess(it)
                }
            }
        }
    }

    fun saveHardSkillTag(tag: String) {
        val hardSkillParseObject = ParseObject(ParseTableName.HardSkill.toString())
        hardSkillParseObject.put("name", tag)
        hardSkillParseObject.saveInBackground {
        }
    }

    fun getExistingSoftSkillTags(callback: GetAllUserCallback) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.SoftSkill.toString())
        query.findInBackground { it, e ->
            val jobSeeker = it?.firstOrNull()
            when {
                e != null -> {
                    callback.onFailure(e)
                }
                jobSeeker == null -> {
                    callback.onFailure(java.lang.Exception("User Not Found"))
                }
                else -> {
                    callback.onSuccess(it)
                }
            }
        }
    }

    fun saveSoftSkillTag(tag: String) {
        val hardSkillParseObject = ParseObject(ParseTableName.SoftSkill.toString())
        hardSkillParseObject.put("name", tag)
        hardSkillParseObject.saveInBackground {
        }
    }


    fun getExistingActivitiesTags(callback: GetAllUserCallback) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.Interests.toString())
        query.findInBackground { it, e ->
            val jobSeeker = it?.firstOrNull()
            when {
                e != null -> {
                    callback.onFailure(e)
                }
                jobSeeker == null -> {
                    callback.onFailure(java.lang.Exception("User Not Found"))
                }
                else -> {
                    callback.onSuccess(it)
                }
            }
        }
    }


    fun saveActivitiesTag(tag: String) {
        val activitiesParseObject = ParseObject(ParseTableName.Activities.toString())
        activitiesParseObject.put("name", tag)
        activitiesParseObject.saveInBackground {
        }
    }

    fun saveSocialMediaLinks(instagramLink: String, linkedInLink: String, tikTokLink: String, callback: (ParseException?) -> Unit) {
        jobSeekerObject?.let { parseObject ->
            parseObject.put("instagramLink", instagramLink)
            parseObject.put("linkedInLink", linkedInLink)
            parseObject.put("tikTokLink", tikTokLink)
            parseObject.saveInBackground {
               callback(it)
                getJobSeeker()
            }
        }
    }


    fun updateWishlistJob(parseObject: ParseObject, callback: (ParseException?) -> Unit) {
        parseObject.saveInBackground {
            callback(it)
        }
    }

    fun addJobToTack(trackingJob: ParseObject?, callback: (ParseException?) -> Unit) {
        trackingJob?.saveInBackground {
            callback(it)
        }
    }

    fun uploadUserAudio(bytes: ByteArray?, onFailure: (ParseException?) -> Unit, onSuccess: (String?) -> Unit) {
        val parseFile = ParseFile("portfolioAudio.m4a", bytes)
       parseFile.saveInBackground(SaveCallback {
           if (it != null){
               onFailure(it)
           }else{
               onSuccess(parseFile.url)
           }
       })
    }



    fun loadTrackingJob(callback: GetAllUserCallback) {
         val query = ParseQuery.getQuery<ParseObject>(ParseTableName.TrackingJob.toString())
        query.whereEqualTo(ParseTableFields.jobSeekerId.toString(),context.getUserId())
        query.include("job")
        query.include("jobSeeker")
        query.findInBackground { list, e ->
            when {
                e != null -> {
                    callback.onFailure(e)
                }
                list == null -> {
                    log("No result found")
                }
                else -> {
                    callback.onSuccess(list)
                }
            }
        }
    }

    fun addOrUpdateVolunteering(volunteering: Volunteering, callback: (it: ParseException?) -> Unit) {
        val volunteerings = ArrayList(Gson().fromJson(jobSeekerObject?.get("volunteerings").toString(), VolunteeringGroup::class.java)?.list ?: listOf())
        var isVolunteeringExist = false
        for (volunt in volunteerings.iterator()){
            if (volunt.id == volunteering.id){
                isVolunteeringExist = true
                volunteerings[volunteerings.indexOf(volunt)].apply {
                    job = volunteering.job
                    company = volunteering.company
                    location = volunteering.location
                    startDate = volunteering.startDate
                    endDate = volunteering.endDate
                }
            }
        }
        if (!isVolunteeringExist){
            volunteerings.add(volunteering)
        }
        val volunteeringGroup = VolunteeringGroup(volunteerings)
        jobSeekerObject?.put(ParseTableFields.volunteerings.toString(), Gson().toJson(volunteeringGroup))
        jobSeekerObject!!.saveInBackground {
            callback(it)
            getJobSeeker()
        }
    }

    fun saveNewVolunteeringList(volunteerings: ArrayList<Volunteering>, callback: (ParseException?) -> Unit) {
        val volunteeringGroup = VolunteeringGroup(volunteerings)
        jobSeekerObject?.put(ParseTableFields.volunteerings.toString(), Gson().toJson(volunteeringGroup))
        jobSeekerObject!!.saveInBackground {
            callback(it)
            getJobSeeker()
        }
    }

 }

interface SaveParseObjectCallback {
    fun onFinish(isSuccessful: Boolean)
}