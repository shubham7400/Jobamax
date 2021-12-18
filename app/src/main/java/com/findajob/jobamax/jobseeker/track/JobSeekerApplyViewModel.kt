package com.findajob.jobamax.jobseeker.track

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseAndroidViewModel
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.model.fcm.NotificationData
import com.findajob.jobamax.model.fcm.PushNotification
import com.findajob.jobamax.repo.FCMCallback
import com.findajob.jobamax.repo.FCMRepo
import com.findajob.jobamax.repo.JobOfferRepository
import com.findajob.jobamax.repo.MessageRepository
import com.findajob.jobamax.util.*
import com.parse.ParseObject
import com.parse.ParseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class JobSeekerApplyViewModel @Inject constructor(
    val context: Application,
    val jobOfferRepo: JobOfferRepository,
    val fcmRepo: FCMRepo,
    val messageRepository: MessageRepository
) :
    BaseAndroidViewModel(context) {

    var jobSeekerObject: ParseObject? = null
    private val externalJobUrlLiveData = MutableLiveData<String>()
    fun getExternalJobObserver(): LiveData<String> = externalJobUrlLiveData
    val jobSeeker
        get() = if (jobSeekerObject == null) JobSeeker() else JobSeeker(jobSeekerObject!!)


    fun acceptJob(jobOffer: ParseObject) {

        viewModelScope.launch(Dispatchers.IO) {

            try {

                val jobOfferId = jobOffer.getString("jobOfferId")

                // if not a Jobamax job offer, we open redirect url to apply
                if (jobOfferId!! == ADZUNA_JOB || jobOfferId == REMOTIVE_JOB || jobOfferId == JOOBLE_JOB || jobOfferId == USAJOBS_JOB || jobOfferId == JOBSPIKR_JOB) {
                    externalJobUrlLiveData.value = jobOffer.getString("documentUrl")
                    return@launch
                }

                val applicantsRelation = jobOffer.getRelation<ParseObject>(NODE_APPLICANTS)
                if (jobSeekerObject != null)
                    applicantsRelation.add(jobSeekerObject)
                jobOffer.save()

//                viewModel.currentIndex++

                val receiverId =
                    "/topics/" + jobOffer.getParseObject("recruiter")
                        ?.fetchIfNeeded<ParseObject>()
                        ?.getString("userId")

                log("${this::class.java.simpleName} acceptJob: $receiverId")

                val data = NotificationData(
                    title = context.getString(R.string.app_name),
                    message = "New Job Applied !",
                    type = "new_applied",
                    receiverObjectId = ParseUser.getCurrentUser().objectId,
                    receiverObjectName = ParseUser.getCurrentUser().email
                )
                val pushData = PushNotification(data, receiverId)
                fcmRepo.postCloudNotification(pushData, object : FCMCallback {
                    override fun onResult(status: Boolean, message: String) {
                        log("${this::class.java.simpleName} onResult: $status -> $message")
                    }

                })

                // show the jobs that already got swipes (the most to least)
                jobOfferRepo.increaseJobSwipe(jobOffer)
            } catch (e: Exception) {
                log("could not provide the job id", e)
            }
        }
//        viewModel.loadAppliedJobs()
    }

    fun setJobUrlEmpty() {
        externalJobUrlLiveData.value = ""
    }


    fun matchUser(roleType: String, receiverObjectId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            messageRepository.matchUser(roleType, receiverObjectId)
        }
    }

    fun decrementReach() {
        viewModelScope.launch(Dispatchers.IO) {
            if (jobSeeker.todayReach > 0)
                jobSeekerObject?.put("todayReach", jobSeeker.todayReach - 1)
            else
                jobSeekerObject?.put("totalReach", jobSeeker.totalReach - 1)
            jobSeekerObject?.save()

        }
    }

    fun rejectJob(jobOffer: ParseObject) {
        viewModelScope.launch(Dispatchers.IO) {

            val jobOfferId = jobOffer.getString("jobOfferId")

            //return if it is not a Jobamax job offer
            if (jobOfferId!! == ADZUNA_JOB || jobOfferId == REMOTIVE_JOB
                || jobOfferId == JOOBLE_JOB || jobOfferId == USAJOBS_JOB
                || jobOfferId == JOBSPIKR_JOB
            )
                return@launch

            val dropoutsRelation = jobOffer.getRelation<ParseObject>(NODE_DROPOUTS)
            if (jobSeekerObject != null)
                dropoutsRelation.add(jobSeekerObject)

            jobOffer.save()

            // show the jobs that already got swipes (the most to least)
            jobOfferRepo.increaseJobSwipe(jobOffer)
        }
    }

    fun undoJob(jobOffer: ParseObject) {
        viewModelScope.launch(Dispatchers.IO) {
            val applicantsRelation = jobOffer.getRelation<ParseObject>(NODE_APPLICANTS)
            val dropoutsRelation = jobOffer.getRelation<ParseObject>(NODE_DROPOUTS)
            val jobOfferId = jobOffer.getString("jobOfferId")
            applicantsRelation.remove(jobSeekerObject!!)
            dropoutsRelation.remove(jobSeekerObject!!)
            if (jobOfferId!! != ADZUNA_JOB && jobOfferId != REMOTIVE_JOB
                && jobOfferId != JOOBLE_JOB
                && jobOfferId != USAJOBS_JOB
                && jobOfferId != JOBSPIKR_JOB
            ) {
                // show the jobs that already got swipes (the most to least)
                jobOfferRepo.increaseJobSwipe(jobOffer)
                jobOffer.save()
            }
            withContext(Dispatchers.Main) {
//                viewModel.loadAppliedJobs()
            }
        }
    }
}
