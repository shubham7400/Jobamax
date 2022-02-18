package com.findajob.jobamax.jobseeker.home

import android.app.Application
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.findajob.jobamax.base.BaseAndroidViewModel
import com.findajob.jobamax.enums.ParseCloudFunction
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.enums.SeekerWishlistJobFilter
import com.findajob.jobamax.extensions.ioToMain
import com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel
import com.findajob.jobamax.jobseeker.profile.account.social.JobSeekerSocialAccountModel
import com.findajob.jobamax.jobseeker.profile.cv.model.*
import com.findajob.jobamax.jobseeker.profile.jobSearch.JobSearchState
import com.findajob.jobamax.jobseeker.track.JobSeekerTrackState
import com.findajob.jobamax.model.*
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.preference.setNewMatchPNFlag
import com.findajob.jobamax.preference.setProfilePicUrl
import com.findajob.jobamax.repo.GetAllJobOfferCallback
import com.findajob.jobamax.repo.JobOfferRepository
import com.findajob.jobamax.repo.JobSeekerRepo
import com.findajob.jobamax.repo.SaveParseObjectCallback
import com.findajob.jobamax.util.*
import com.google.gson.Gson
import com.parse.*
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxkotlin.addTo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


@HiltViewModel
class JobSeekerHomeViewModel @Inject constructor(val context: Application, val jobSeekerRepo: JobSeekerRepo, val jobOfferRepo: JobOfferRepository) : BaseAndroidViewModel(context) {

    var jobSeekerObject: ParseObject? = null
    var jobOffers: ArrayList<ParseObject> = arrayListOf()

    var jobOfferPageIndex = 0
    var isJobOfferExhausted = false

    var selectedLocation = ParseGeoPoint()
    var currentLocation = ParseGeoPoint()
    var isCurrentLocation = true

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

    private val _jobSeekerTrackStateLiveData = MutableLiveData<JobSeekerTrackState>()
    val jobSeekerTrackStateLiveData = _jobSeekerTrackStateLiveData

    fun getJobSeeker() {
        viewModelScope.launch {
            jobSeekerRepo.getCurrent(object : GetUserCallback {
                override fun onSuccess(parseObject: ParseObject) {
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

                    loadJobOffers()
                    loadAppliedJobs()
                    isJobSeekerUpdated.value = true
                }
                override fun onFailure(e: Exception?) {}
            })
        }
    }

    fun loadAppliedJobs() {
        jobOfferRepo.getAppliedJobs(jobSeeker.jobSeekerId).ioToMain().subscribe({
                log("Job Seeker track state has been chosen $it")
                _jobSeekerTrackStateLiveData.postValue(it)
            }, { e ->
                log("The job seeker state could not be loaded ${e.message}", e)
                _jobSeekerTrackStateLiveData.postValue(JobSeekerTrackState())
            }).addTo(disposeBag)
    }

    private val _selectedJobOffer = MutableLiveData<ParseObject>()
    val selectedJobOffer: LiveData<ParseObject> = _selectedJobOffer

    fun getSelectedJobOffer() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val jobOfferPo = jobOffers[currentIndex]
            _selectedJobOffer.postValue(jobOfferPo)
        } catch (e: Exception) {
            log("Could not get the selected job offer due to ${e.message ?: "Unknown reason"}", e)
            _selectedJobOffer.postValue(
                ParseObject.createWithoutData(
                    JobOffer.CLASS_NAME,
                    UUID.randomUUID().toString()
                )
            )
        }

    }

    fun getCompanyFromJobOffer(jobOfferParseObject: ParseObject?): ParseObject? {
        if (jobOfferParseObject == null) return null
        return jobOfferParseObject.getParseObject("company")?.fetchIfNeeded()
    }


    fun loadJobOffers() {
        _jobOfferLiveData.value = null
        val location = if (isCurrentLocation) currentLocation else selectedLocation

        jobOfferRepo.getAll(jobSeeker, location, jobOfferPageIndex, object : GetAllJobOfferCallback {
                override fun onFinish(parseObjects: List<ParseObject>) {
                    val jobOffersList = parseObjects.filter {
                        val isNotArchived = !it.getBoolean("isArchived")
                        log("loadJobOffers: checking ${it.objectId} if it is archived or not ($isNotArchived)")
                        // ignoring all the job offers that has been archived
                        isNotArchived
                    }
                    log("loadJobOffers: job offers amount: ${parseObjects.size}")
                    isJobOfferExhausted = jobOffersList.isEmpty()
                    jobOfferPageIndex++
                    jobOffers.addAll(jobOffersList)
                    _jobOfferLiveData.value = jobOffers
                }
            })
    }

    /**
     * load Jobamax, Adzuna, and Remotive job offers
     */
    fun loadAllJobOffers() {

        viewModelScope.launch(Dispatchers.IO) {
            _jobOfferLiveData.postValue(null)
            val location = if (isCurrentLocation) currentLocation else selectedLocation

            jobOfferRepo.getAll(
                jobSeeker,
                location,
                jobOfferPageIndex,
                object : GetAllJobOfferCallback {
                    override fun onFinish(parseObjects: List<ParseObject>) {
                        log("Job Offers Size: ${parseObjects.size}")
                        isJobOfferExhausted = parseObjects.isEmpty()
                        jobOfferPageIndex++
                        jobOffers.addAll(parseObjects)

                        //load JobsPikr jobs api
                        jobOfferRepo.loadJobsPikrJobOffers(
                            jobSeeker,
                            object : GetAllJobOfferCallback {
                                override fun onFinish(parseObjects: List<ParseObject>) {
                                    log("JobsPikr Job Offers Size: ${parseObjects.size}")
                                    jobOffers.addAll(parseObjects)
                                    _jobOfferLiveData.postValue(jobOffers)
                                }
                            })
                    }
                })
        }
    }


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
       /* personalInfoModel.update(jobSeekerObject!!)
        val user = jobSeekerObject?.getParseObject(User.CLASS_NAME)
        user?.let { user ->
            user.put("lastName", jobSeekerObject!!.get("lastName")!!)
            user.put("firstName", jobSeekerObject!!.get("firstName")!!)
            user.put("email", jobSeekerObject!!.get("email")!!)
            user.put("username", jobSeekerObject!!.get("email")!!)
            user.saveInBackground()
        }

        jobSeekerObject?.saveInBackground {
            callback(it)
        }*/
    }

    fun updateSocialMediaLinks(
        socialMedia: JobSeekerSocialAccountModel,
        callback: (it: ParseException?) -> Unit
    ) {
        socialMedia.update(jobSeekerObject!!)
        jobSeekerObject?.saveInBackground {
            callback(it)
        }
    }

    fun updateReachCount(reachCount: Int, callback: UpdateUserCallback) {
        jobSeekerObject?.put("totalReach", jobSeeker.totalReach + reachCount)
        jobSeekerObject?.saveInBackground {
            callback.onFinish(it == null)
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
                val user = jobSeekerObject?.getParseObject("user")
                user?.put("profilePicUrl", parseFile.url)
                user?.saveInBackground()
                context.setProfilePicUrl(parseFile.url ?: "")
                jobSeekerObject?.saveInBackground {
                    callback.onFinish(it == null)
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


    private val _jobSearchStateObservable = MutableLiveData<JobSearchState>()
    val jobSearchStateObservable: LiveData<JobSearchState> = _jobSearchStateObservable

    init {
        _jobSearchStateObservable.value = JobSearchState(jobSeeker)
    }

    fun saveJobSearchState(jobSearchState: JobSearchState) = viewModelScope.launch(Dispatchers.IO) {
        _jobSearchStateObservable.postValue(jobSearchState)
    }


    fun saveJobSearch() {
        viewModelScope.launch(Dispatchers.IO) {
            val jobSeeker = jobSearchStateObservable.value?.toJobSeeker()
            if (jobSeekerObject != null && jobSeeker != null) {
                jobSeekerObject?.put("jobSeekerId", jobSeeker.jobSeekerId)
                jobSeekerObject?.put("hideMeFlag", jobSeeker.hideMeFlag)
                jobSeekerObject?.put("job", jobSeeker.job)
                jobSeekerObject?.put("location", jobSeeker.location)
                jobSeekerObject?.put("distance", jobSeeker.distance)
                jobSeekerObject?.put("lat", jobSeeker.lat)
                jobSeekerObject?.put("lng", jobSeeker.lng)
                jobSeekerObject?.put("typeOfWork", jobSeeker.typeOfWork)
                jobSeekerObject?.put("jobCategory", jobSeeker.jobCategory)
                jobSeekerObject?.put("experience", jobSeeker.experience)
            } else {
                jobSeeker?.jobSeekerId = context.getUserId()
                jobSeekerObject = jobSeeker?.toParseObject()
            }

            currentIndex = 0
            jobOfferPageIndex = 0
            isJobOfferExhausted = false
            jobOffers = arrayListOf()

            loadAllJobOffers()
        }
    }

    fun submitLocation(lat: Double, lng: Double) = viewModelScope.launch(Dispatchers.IO) {
        isCurrentLocation = false
        selectedLocation = ParseGeoPoint(lat, lng)
    }

    private val _deleteAccountStatus: MutableLiveData<Boolean> by lazy {
        MutableLiveData()
    }
    val deleteAccountLiveData: LiveData<Boolean> by lazy {
        _deleteAccountStatus
    }

    fun deleteAccount(reasons: String? = null) {
        reasons?.let {
            val reasonParseObject = DeleteAccountReason(reason = it, accountId = jobSeeker.jobSeekerId).toParseObject()
            reasonParseObject.saveInBackground()
        }
        ParseUser.logOut()
        jobSeekerObject?.deleteInBackground {
            _deleteAccountStatus.value = it == null
        }
    }

    fun changePassword(newPassword: String, callback: (it: ParseException?) -> Unit) {
        jobSeekerObject!!.put(ParseTableFields.password.toString(), newPassword)
        jobSeekerObject!!.saveInBackground {
            callback(it)
        }
    }

    fun updateJobSeeker(firstName: String, lastName: String, profession: String, description: String, callback: (it: ParseException?) -> Unit) {
        jobSeekerObject!!.put(ParseTableFields.firstName.toString(), firstName)
        jobSeekerObject!!.put(ParseTableFields.lastName.toString(), lastName)
        jobSeekerObject!!.put(ParseTableFields.profession.toString(), profession)
        jobSeekerObject!!.put(ParseTableFields.elevatorPitch.toString(), description)
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


    fun addActivitiesTags(activitiesTags: ArrayList<String>, callback: (it: ParseException?) -> Unit) {
        val activitiesTagsJsonArray = JSONArray()
        activitiesTags.forEach {
            activitiesTagsJsonArray.put(it)
        }
         jobSeekerObject?.put(ParseTableFields.activities.toString(), activitiesTagsJsonArray.toString())
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
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.Activities.toString())
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

    fun saveVolunteeringTag(tag: String) {
        val volunteeringParseObject = ParseObject(ParseTableName.Volunteering.toString())
        volunteeringParseObject.put("name", tag)
        volunteeringParseObject.saveInBackground {
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

    fun getWishList(callback: GetAllUserCallback, filteredJob : String) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.WishlistedJob.toString())
        query.whereEqualTo(ParseTableFields.jobSeekerId.toString(),context.getUserId())
        if (filteredJob == SeekerWishlistJobFilter.ARCHIVE.name){
            query.whereEqualTo("isArchived", true)
        }else{
            query.whereEqualTo("isArchived", false)
        }
        if (filteredJob == SeekerWishlistJobFilter.FAVORITE.name){
            query.whereEqualTo("isFavroite", true)
        }
        query.include("job")
        query.include("jobSeeker")
        query.findInBackground { it, e ->
            when {
                e != null -> {
                    callback.onFailure(e)
                }
                it == null -> {
                    callback.onFailure(java.lang.Exception("User Not Found"))
                }
                else -> {
                    callback.onSuccess(it)
                }
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
        val parseFile = ParseFile("portfolioAudio", bytes)
       parseFile.saveInBackground(SaveCallback {
           if (it != null){
               onFailure(it)
           }else{
               onSuccess(parseFile.url)
           }
       })
    }

    fun uploadImage(uri: Uri, onFailure: (ParseException?) -> Unit, onSuccess: (String?) -> Unit) {
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        var fileName = context.getFileName(uri)
        if (fileName.isEmpty())
            fileName = Date().yyyyMMddHHmmss()
        val parseFile = ParseFile(fileName, inputStream?.readBytes())
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

    fun getNextInterview(phase: String, jobSeekerId: String, onFailure: (ParseException) -> Unit, onSuccess: (String?) -> Unit) {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.getTrackingStatus.toString(), mapOf("name" to phase , "jobSeekerId" to jobSeekerId ), FunctionCallback<String>() { result, e ->
            when {
                e != null -> {
                    onFailure(e)
                }
                else -> {
                    onSuccess(result)
                }
            }
        })
    }

    fun getNextDeadline(phase: String, jobSeekerId: String, onFailure: (ParseException) -> Unit, onSuccess: (String?) -> Unit) {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.getTrackingStatus.toString(), mapOf("name" to phase , "jobSeekerId" to jobSeekerId ), FunctionCallback<String>() { result, e ->
            when {
                e != null -> {
                    onFailure(e)
                }
                else -> {
                    onSuccess(result)
                }
            }
        })
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

    fun addNewOrUpdateVolunteering(volunteering: Volunteering, callback: (ParseException?) -> Unit) {
        val volunteerings = ArrayList(Gson().fromJson(jobSeekerObject?.get("volunteerings").toString(), VolunteeringGroup::class.java)?.list ?: listOf())
        var isVolunteeringExist = false
        for (edu in volunteerings.iterator()){
            if (edu.id == volunteering.id){
                isVolunteeringExist = true
                volunteerings[volunteerings.indexOf(edu)].apply {
                    job = volunteering.job
                    company = volunteering.company
                    description = volunteering.description
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
}