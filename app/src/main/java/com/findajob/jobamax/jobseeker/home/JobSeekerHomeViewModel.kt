package com.findajob.jobamax.jobseeker.home

import android.app.Application
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.findajob.jobamax.base.BaseAndroidViewModel
import com.findajob.jobamax.extensions.ioToMain
import com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationModel
import com.findajob.jobamax.jobseeker.profile.account.social.JobSeekerSocialAccountModel
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
import com.findajob.jobamax.util.getFileName
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toText
import com.findajob.jobamax.util.yyyyMMddHHmmss
import com.parse.*
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxkotlin.addTo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStream
import java.util.*
import javax.inject.Inject

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
            }

            override fun onFailure(e: Exception?) {}
        })
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

    fun updateMessagePushNotificationFlag(flag: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        jobSeekerRepo.updateMessagePushNotificationFlag(flag, jobSeekerObject)
    }


    fun updateNewsMatchesPushNotificationFlag(flag: Boolean) =
        viewModelScope.launch(Dispatchers.IO) {
            jobSeekerRepo.updateNewsMatchesPushNotificationFlag(flag, jobSeekerObject)
        }

    fun updateFlag(flag: Boolean, key: String, callback: UpdateUserCallback) {
        jobSeekerObject?.put(key, flag)
        jobSeekerObject?.saveInBackground {
            callback.onFinish(it == null)
        }
    }

    fun submitData(
        personalInfoModel: JobSeekerPersonalInformationModel,
        callback: (it: ParseException?) -> Unit
    ) {
        personalInfoModel.update(jobSeekerObject!!)
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
        }
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
        params["userId"] = ParseUser.getCurrentUser().objectId
        ParseCloud.callFunctionInBackground(
            "retrieveCard",
            params,
            FunctionCallback<HashMap<String, Any>?> { response, e ->
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
}