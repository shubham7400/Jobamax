package com.findajob.jobamax.recruiter.home

import android.app.Application
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.findajob.jobamax.base.BaseAndroidViewModel
import com.findajob.jobamax.extensions.ioToMain
import com.findajob.jobamax.model.*
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.preference.setNewMatchPNFlag
import com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationModel
import com.findajob.jobamax.recruiter.profile.account.social.RecruiterSocialAccountModel
import com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState
import com.findajob.jobamax.repo.*
import com.findajob.jobamax.util.*
import com.parse.*
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxkotlin.addTo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream
import java.util.*
import javax.inject.Inject

@HiltViewModel
class RecruiterHomeViewModel @Inject constructor(
    var jobSeekerRepo: JobSeekerRepo,
    var jobOfferRepo: JobOfferRepository,
    var recruiterRepo: RecruiterRepo,
    var context: Application,
) :
    BaseAndroidViewModel(context) {


    private val _errorText = MutableLiveData<String>()
    val errorText: LiveData<String> = _errorText

    var allJobOffers = listOf<ParseObject>()
    var jobSeekers = arrayListOf<ParseObject>()
    var applicants = arrayListOf<ParseObject>()
    var paymentHistoryList = arrayListOf<ParseObject>()

    var recruitIndex = 0
    var sourceIndex = 0

    var sourcePageIndex = 0
    var isSourceExhausted = false

    var recruitPageIndex = 0
    var isRecruitExhausted = false
    var matchDailyLimit = 0
    var matchCount = 0
    var sourceDailyLimit = 0
    var sourceCount = 0

    var recruiterParseObject: ParseObject? = null
    var companyParseObject: ParseObject? = null

    val recruiter: Recruiter
        get() = if (recruiterParseObject == null) Recruiter() else Recruiter(recruiterParseObject!!)

    val company: Company
        get() = if (companyParseObject == null) Company() else Company(companyParseObject!!)

    private val allJobOffersLiveData = MutableLiveData<List<ParseObject>>()
    private val applicantsLiveData = MutableLiveData<List<ParseObject>>()
    private val companyLiveData = MutableLiveData<Company>()
    private val _jobSeekerLiveData = MutableLiveData<List<ParseObject>>()
    val jobSeekerLiveData: LiveData<List<ParseObject>> = _jobSeekerLiveData
    private var paymentHistoryLiveData = MutableLiveData<List<ParseObject>>()

    fun getCompanyObserver(): LiveData<Company> = companyLiveData
    fun getAllJobOffersObserver(): LiveData<List<ParseObject>> = allJobOffersLiveData
    fun getApplicantsObserver(): LiveData<List<ParseObject>> = applicantsLiveData
    fun getPaymentHistoryObserver(): LiveData<List<ParseObject>> = paymentHistoryLiveData

    var jobOfferDetailsState = JobOfferDetailsState()
    var currentJobOffer: ParseObject? = null
    var selectedJobOffer: ParseObject? = null

    private val messageRepo = MessageRepository()

    private val _selectedJobOfferObservable = MutableLiveData<JobOffer>()
    val selectedJobOfferObservable: LiveData<JobOffer> = _selectedJobOfferObservable

    var selectedJobOfferObjectId = ""

    fun getJobOfferById(jobId: String) {
        jobOfferRepo.getJobOfferByObjectId(jobId)
            .ioToMain()
            .subscribe(
                { jobOffer ->
                    _selectedJobOfferObservable.value = jobOffer
                },
                {
                    log("Could not find the job offer for $jobId", it)
                },
            )
            .addTo(disposeBag)
    }

    fun getRecruiter() {
        recruiterRepo.getCurrent(object : GetUserCallback {
            override fun onSuccess(parseObject: ParseObject) {
                recruiterParseObject = parseObject
                companyParseObject = (parseObject["company"] as? ParseObject?)

                // TODO: get actual limit from DB
                matchDailyLimit = 999
                sourceDailyLimit = 999

                if (recruiter.temporaryDisableFlag) {
                    recruiterParseObject?.put("temporaryDisableFlag", false)
                    recruiterParseObject?.saveInBackground()
                }

                context.setNewMatchPNFlag(recruiter.newMatchPNFlag)
                if (companyParseObject == null) {
                    log("companyParseObject was null")
                    val c = Company()

                    log("companyParseObject id: " + c.companyId)
                    c.recruiterId = recruiter.recruiterId
                    companyParseObject = c.toParseObject()
                    companyParseObject?.saveInBackground {
                        recruiterParseObject?.put("company", companyParseObject!!)
                        recruiterParseObject?.saveInBackground()
                        log("saved companyParseObject id: " + company.companyId)
                    }
                }

                _jobSourceObservable.postValue(JobSource().toParseObject())

                companyLiveData.value = Company(companyParseObject!!)
                sourceIndex = 0
                sourcePageIndex = 0
                jobSeekers = arrayListOf()
                isSourceExhausted = false
                loadJobOffers()
                loadJobSeekers()
            }

            override fun onFailure(e: Exception?) {
            }
        })
    }

    private val _archiveJobOfferSuccess = MutableLiveData<Pair<String, Boolean>>()
    val archiveJobOfferSuccess: LiveData<Pair<String, Boolean>> = _archiveJobOfferSuccess
    fun archiveJobOffer(jobId: String) {
        jobOfferRepo.archiveJobOffer(jobId).ioToMain()
            .subscribe({
                it?.let { isSuccessful ->
                    _archiveJobOfferSuccess.postValue(
                        Pair(
                            jobId,
                            isSuccessful
                        )
                    )
                }
            },
                { e ->
                    _archiveJobOfferSuccess.postValue(Pair(jobId, false))
                    log("could not delete $jobId job offer", e)
                })
            .addTo(disposeBag)
    }

    private val _unarchiveJobOfferSuccess = MutableLiveData<Pair<String, Boolean>>()
    val unarchiveJobOfferSuccess: LiveData<Pair<String, Boolean>> = _unarchiveJobOfferSuccess
    fun unarchiveJobOffer(jobId: String) {
        jobOfferRepo.unArchiveJobOffer(jobId)
            .ioToMain()
            .subscribe({
                it?.let { isSuccessful ->
                    _unarchiveJobOfferSuccess.postValue(
                        Pair(
                            jobId,
                            isSuccessful
                        )
                    )
                }
            }, { e ->
                _unarchiveJobOfferSuccess.postValue(
                    Pair(
                        jobId,
                        false,
                    )
                )
                log("could not unarchive $jobId job offer", e)
            })
            .addTo(disposeBag)
    }

    fun recruit(jobSeeker: ParseObject) {
        val applicantsRelation = selectedJobOffer?.getRelation<ParseObject>(NODE_APPLICANTS)
        val matchedRelation = selectedJobOffer?.getRelation<ParseObject>(NODE_MATCHED)
        val recruiterMatchedRelation = recruiterParseObject?.getRelation<ParseObject>(NODE_MATCHED)
        val jobSeekerMatchedRelation = jobSeeker.getRelation<ParseObject>(NODE_MATCHED)
        applicantsRelation?.remove(jobSeeker)
        matchedRelation?.add(jobSeeker)
        recruiterMatchedRelation?.add(jobSeeker)
        jobSeekerMatchedRelation.add(recruiterParseObject)
        selectedJobOffer?.saveInBackground {

            log(it?.message ?: "Successful")
            if (it == null) {
                sendMatchNotification(jobSeeker["jobSeekerId"].toString())
                // TODO: save daily match count in DB
                matchCount++
            }
        }
        recruiterParseObject?.saveInBackground {
            if (it == null)
                log(it?.message ?: "Successful")

        }
        jobSeeker.saveInBackground {
            if (it == null)
                log(it?.message ?: "Successful")

        }
    }

    fun cancel(jobSeeker: ParseObject) = viewModelScope.launch(Dispatchers.IO) {
        recruiterRepo.cancelJobSeeker(jobSeeker)
    }

    fun undoCancel(jobSeeker: ParseObject) {
        val cancelledRelation = jobSeeker.getRelation<ParseObject>(NODE_CANCELLED)
        cancelledRelation.remove(recruiterParseObject)
        jobSeeker.saveInBackground {
            log(it?.message ?: "Successful")
        }
    }

    fun refuse(jobSeeker: ParseObject) {
        viewModelScope.launch(Dispatchers.IO) {
            if (selectedJobOffer != null) recruiterRepo.refuseJob(selectedJobOffer!!, jobSeeker)
        }
    }


    fun undoJob(jobSeeker: ParseObject) {
        viewModelScope.launch(Dispatchers.IO) {
            if (selectedJobOffer != null) recruiterRepo.undoJob(selectedJobOffer!!, jobSeeker)
        }
    }


    private val _allJObOffersObservable = MutableLiveData<List<ParseObject>>()
    val allJobOffersObservable: LiveData<List<ParseObject>> = _allJObOffersObservable
    fun loadJobOffers() =
        jobOfferRepo.getAll()
            .ioToMain()
            .subscribe({ parseObjects ->
                allJobOffers = parseObjects
                isRecruitExhausted = allJobOffers.isEmpty()
                allJobOffersLiveData.value = allJobOffers
                _allJObOffersObservable.value = parseObjects
            }, {
                _allJObOffersObservable.value = emptyList()
                log("could not load the job offers", it)
            })
            .addTo(disposeBag)


    private val _filteredJobOffers = MutableLiveData<List<ParseObject>>()
    val filteredJobOffers: LiveData<List<ParseObject>> = _filteredJobOffers


    private val _activeJObOffersObservable = MutableLiveData<List<ParseObject>>()
    val activeJobOffersObservable: LiveData<List<ParseObject>> = _activeJObOffersObservable
    fun loadActiveJobOffers() =
        jobOfferRepo.getActiveJobOffer()
            .ioToMain()
            .subscribe({ parseObjects ->
                _activeJObOffersObservable.postValue(parseObjects)
                _filteredJobOffers.postValue(parseObjects)
            }, { e ->
                _activeJObOffersObservable.postValue(emptyList())
                log("could not load active job offers", e)
            })
            .addTo(disposeBag)

    private val _archivedJObOffersObservable = MutableLiveData<List<ParseObject>>()
    val archivedJobOffersObservable: LiveData<List<ParseObject>> = _archivedJObOffersObservable
    fun loadArchivedJobOffers() =
        jobOfferRepo.getArchivedJobOffer()
            .ioToMain()
            .subscribe({ parseObjects ->
                _activeJObOffersObservable.postValue(parseObjects)
                _filteredJobOffers.postValue(parseObjects)
            }, { e ->
                _activeJObOffersObservable.postValue(emptyList())
                log("could not load active job offers", e)
            })
            .addTo(disposeBag)


    fun loadApplicants() {
        viewModelScope.launch(Dispatchers.IO) {
            val applicantsRelation = selectedJobOffer?.getRelation<ParseObject>(NODE_APPLICANTS)
            val query = applicantsRelation?.query

            query?.skip = recruitPageIndex * RECRUIT_JOB_SEEKER_PAGE_SIZE
            query?.limit = RECRUIT_JOB_SEEKER_PAGE_SIZE

            query?.whereEqualTo("hideMeFlag", false)
            query?.whereEqualTo("disableAccountFlag", false)

            query?.findInBackground { objects, _ ->
                isRecruitExhausted = objects.size < RECRUIT_JOB_SEEKER_PAGE_SIZE
                recruitPageIndex++
                applicants.addAll(objects)
                applicantsLiveData.postValue(applicants)
            }
        }
    }

    fun addRejectReason(jobSeeker: ParseObject, reason: String) {
        if (selectedJobOffer != null) {
            viewModelScope.launch(Dispatchers.IO) {
                recruiterRepo.rejectJobSeeker(jobSeeker, reason, selectedJobOffer!!)
            }
        }
    }

    fun loadJobSeekers() {
        viewModelScope.launch(Dispatchers.IO) {

            val parseObjects =
                jobSeekerRepo.loadJobSeekers(
                    JobSource(jobSourceObservable.value ?: JobSource().toParseObject()),
                    sourcePageIndex
                )

            isSourceExhausted = parseObjects.size < SOURCE_JOB_SEEKER_PAGE_SIZE
            sourcePageIndex++
            jobSeekers.addAll(parseObjects)

            _jobSeekerLiveData.postValue(jobSeekers)
        }
    }

    fun saveJobSource(jobSource: JobSource) = viewModelScope.launch(Dispatchers.IO) {
        try {
            jobSource.udpate(jobSourceObservable.value!!)
            sourcePageIndex = 0
            sourceIndex = 0
            jobSeekers = arrayListOf()
            isSourceExhausted = false
            loadJobSeekers()
        } catch (e: Exception) {
            log("could not save the job source due to ${e.message ?: "Unknown"}", e)
        }
    }

    fun saveJobOffer(fileUri: Uri?, callback: SaveJobOfferCallback) {
        viewModelScope.launch(Dispatchers.IO) {
            if (fileUri != null) {
                val inputStream: InputStream? = context.contentResolver.openInputStream(fileUri)
                val fileName = context.getFileName(fileUri)
                val parseFile = ParseFile(fileName, inputStream?.readBytes())
                parseFile.saveInBackground(SaveCallback {
                    jobOfferDetailsState.documentUrl = parseFile.url ?: ""
                    saveJobOfferData(callback)
                })
            } else saveJobOfferData(callback)
        }
    }


    fun updateFlag(flag: Boolean, key: String, callback: UpdateUserCallback) {
        recruiterParseObject?.put(key, flag)
        recruiterParseObject?.saveInBackground {
            callback.onFinish(it == null)
        }
    }


    fun updateMessagePushNotificationFlag(flag: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        recruiterRepo.updateMessagePushNotificationFlag(flag, recruiterParseObject)
    }


    fun updateNewsMatchesPushNotificationFlag(flag: Boolean) =
        viewModelScope.launch(Dispatchers.IO) {
            recruiterRepo.updateNewsMatchesPushNotificationFlag(flag, recruiterParseObject)
        }

    fun submitData(
        personalInfoModel: RecruiterPersonalInformationModel,
        callback: (it: ParseException?) -> Unit
    ) {
        personalInfoModel.update(recruiterParseObject!!)
        companyParseObject?.put("name", personalInfoModel.companyName)
        companyParseObject?.saveInBackground {
            recruiterParseObject?.put("company", companyParseObject!!)
            recruiterParseObject?.saveInBackground {
                callback(it)
            }
        }
    }

    fun saveCompany(company: Company, callback: SaveParseObjectCallback) {
        viewModelScope.launch(Dispatchers.IO) {
            companyParseObject = company.toParseObject()
            company.update(companyParseObject!!)
            companyParseObject?.put("recruiterId", context.getUserId())
            companyParseObject?.put("recruiter", recruiterParseObject!!)
            companyParseObject?.saveInBackground {
                callback.onFinish(it == null)
                recruiterParseObject?.put("company", companyParseObject!!)
                recruiterParseObject?.saveInBackground()
            }
        }
    }

    fun updateCompany(company: Company, callback: SaveParseObjectCallback) {
        viewModelScope.launch(Dispatchers.IO) {
            companyParseObject?.let {
                company.update(it)
                it.saveInBackground {
                    callback.onFinish(it == null)
                }
            }
        }
    }

    private val _companyDataSaveListener = MutableLiveData<Boolean>()
    val companyDataSaveListener: LiveData<Boolean> = _companyDataSaveListener

    fun saveCompanyData(company: Company) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val recruiterPo = recruiterRepo.getCurrentRecruiter().blockingGet()
            companyParseObject = company.toParseObject()
            companyParseObject?.put("recruiterId", context.getUserId())
            companyParseObject?.put("recruiter", recruiterPo)
            companyParseObject?.save()
            recruiterParseObject?.put("company", companyParseObject!!)
            recruiterParseObject?.save()
            _companyDataSaveListener.postValue(true)
        } catch (e: Exception) {
            _companyDataSaveListener.postValue(false)
        }
    }

    fun updateSocialMediaLinks(
        socialMedia: RecruiterSocialAccountModel,
        callback: (it: ParseException?) -> Unit
    ) {
        socialMedia.update(recruiterParseObject!!)
        recruiterParseObject?.saveInBackground {
            callback(it)
        }
    }

    private fun saveJobOfferData(callback: SaveJobOfferCallback) {
        val jobOffer = jobOfferDetailsState.toJobOffer()
        if (currentJobOffer != null) {
            jobOffer.update(currentJobOffer!!)
        } else {
            jobOffer.recruiterId = context.getUserId()
            currentJobOffer = jobOffer.toParseObject()
        }
        currentJobOffer?.put("recruiter", recruiterParseObject!!)
        currentJobOffer?.put("company", companyParseObject!!)
        jobOfferRepo.save(currentJobOffer!!, recruiterParseObject!!).ioToMain()
            .subscribe(
                {
                    it?.let {
                        context.setAlarm(jobOffer)
                        loadJobOffers()
                    }
                    callback.onFinish(true)
                },
                {
                    callback.onFinish(false)
                    log("could not save job offer", it)
                })
            .addTo(disposeBag)
    }

    private fun sendMatchNotification(jobSeekerId: String) {
        val topic = "/topics/$jobSeekerId" //topic has to match what the receiver subscribed to

        val notification = JSONObject()
        val notificationBody = JSONObject()

        try {
            notificationBody.put("title", "New Match")
            notificationBody.put("message", "Check it out")   //Enter your notification message
            notification.put("to", topic)
            notification.put("data", notificationBody)
        } catch (e: JSONException) {
            log("onCreate: " + e.message)
        }

        sendNotification(notification)
    }

    private val requestQueue: RequestQueue by lazy { Volley.newRequestQueue(context) }

    private fun sendNotification(notification: JSONObject) {
        log("sendNotification")
        val serverKey = "key=$FIREBASE_SERVER_KEY"
        val contentType = "application/json"
        val jsonObjectRequest = object : JsonObjectRequest(
            FCM_API,
            notification,
            Response.Listener { response -> log("onResponse: $response") },
            Response.ErrorListener { log("onErrorResponse: Didn't work" + it?.message) }) {
            override fun getHeaders(): Map<String, String> {
                val params = HashMap<String, String>()
                params["Authorization"] = serverKey
                params["Content-Type"] = contentType
                return params
            }
        }
        requestQueue.add(jsonObjectRequest)
    }


    fun uploadLogo(logoUri: Uri, callback: SaveParseObjectCallback) {
        val inputStream: InputStream? = context.contentResolver.openInputStream(logoUri)
        var fileName = context.getFileName(logoUri)
        if (fileName.isEmpty())
            fileName = Date().yyyyMMddHHmmss()
        val parseFile = ParseFile(fileName, inputStream?.readBytes())
        parseFile.saveInBackground(SaveCallback {
            if (it == null) {
                companyParseObject?.put("logoUrl", parseFile.url)
                companyParseObject?.saveInBackground {
                    callback.onFinish(it == null)
                }
                if (companyParseObject == null) {
                    log("companyParseObject is null")
                } else log("companyParseObject is not null")
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
                    log("cloud response -> There were no exceptions! $response")
                    callback.onSuccess(response)
                } else {
                    log("cloud response -> savePaymentMethod -> Exception: ${e.message}", e)
                    callback.onFailure(e)
                }
            })
    }

    fun getCardDetails(callback: GetCardDetailsCallback) {
        viewModelScope.launch(Dispatchers.IO) {
            val params = HashMap<String, Any>()
            params["userId"] = ParseUser.getCurrentUser().objectId
            ParseCloud.callFunctionInBackground(
                "retrieveCard",
                params,
                FunctionCallback<HashMap<String, Any>?> { response, e ->
                    if (e == null) {
                        callback.onSuccess(response)

                    } else {
                        log("Cloud Response -> Exception: $e")
                        callback.onFailure(e)
                    }
                },
            )
        }
    }

    fun loadPaymentHistory() {
        recruiterRepo.getPaymentHistory().ioToMain()
            .subscribe(
                { paymentHistory ->
                    paymentHistoryList = arrayListOf()
                    paymentHistoryList.addAll(paymentHistory)
                    paymentHistoryLiveData.value = paymentHistoryList
                },
                {
                    log("could not load the payment history in ${this::class.java.simpleName}", it)
                },
            )
            .addTo(disposeBag)
    }

    fun sourceUser(roleType: String, receiverObjectId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            messageRepo.sourceUser(roleType, receiverObjectId)
        }
    }

    private val _jobSourceObservable = MutableLiveData<ParseObject>()
    val jobSourceObservable: LiveData<ParseObject> = _jobSourceObservable

    fun modifyJobSource(jobSource: ParseObject) = viewModelScope.launch(Dispatchers.IO) {
        _jobSourceObservable.postValue(jobSource)
    }

    val currentUserId: String by lazy {
        jobOfferRepo.currentUserId
    }

    val currentUser: ParseObject by lazy {
        jobOfferRepo.currentUser
    }

    private val _currentRecruiterObservable = MutableLiveData<Recruiter>()
    val currentRecruiterObservable: LiveData<Recruiter> = _currentRecruiterObservable

    fun getCurrentRecruiter() {
        recruiterRepo.getCurrentRecruiter().ioToMain()
            .subscribe({ recruiterPo ->
                try {
                    val recruiter = Recruiter(recruiterPo)
                    _currentRecruiterObservable.value = recruiter
                } catch (e: Exception) {
                    _errorText.value = e.localizedMessage ?: "Unknown error"
                }
            }, { e ->
                _errorText.value = e.localizedMessage ?: "Unknown error"
            })
            .addTo(disposeBag)
    }

    private val _deleteAccountStatus: MutableLiveData<Boolean> by lazy {
        MutableLiveData()
    }
    val deleteAccountLiveData: LiveData<Boolean> by lazy {
        _deleteAccountStatus
    }

    fun deleteAccount(reasons: String? = null) {
        reasons?.let {
            val reasonParseObject =
                DeleteAccountReason(reason = it, accountId = currentUserId).toParseObject()
            reasonParseObject.saveInBackground()
        }
        ParseUser.logOut()
        allJobOffers.forEach {
            it.deleteInBackground()
        }
        recruiterParseObject?.deleteInBackground {
            _deleteAccountStatus.value = it == null
        }
    }

}
