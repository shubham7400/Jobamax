package com.findajob.jobamax.repo

import android.content.Context
import com.findajob.jobamax.model.*
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.*
import com.parse.ParseObject
import com.parse.ParseQuery
import com.parse.ParseUser
import io.reactivex.Single
import javax.inject.Inject

class RecruiterRepo @Inject constructor(val context: Context) {


    fun getCurrentRecruiter(): Single<ParseObject> = Single.create { emitter ->
        try {
            val query = ParseQuery.getQuery<ParseObject>("Recruiter")
            query.whereEqualTo("recruiterId", context.getUserId()).include("company")
                .include("jobSource")
            val recruiterPo = query.find().firstOrNull()

            if (recruiterPo != null) {
                emitter.onSuccess(recruiterPo)
            } else {
                emitter.onError(ParseQueryEmptyThrowable())
            }
        } catch (e: Exception) {
            log("could not load the current recruiter", e)
            emitter.onError(e)
        }
    }

    fun getCurrent(callback: GetUserCallback) {
        val query = ParseQuery.getQuery<ParseObject>("Recruiter")
        query.whereEqualTo("recruiterId", context.getUserId()).include("company")
            .include("jobSource")
        query.findInBackground { it, e ->
            val recruiter = it?.firstOrNull()
            if (e != null) {
                callback.onFailure(e)
            } else if (recruiter == null) {
                callback.onFailure(java.lang.Exception("User Not Found"))
            } else callback.onSuccess(recruiter)
        }
    }

    fun getExistingRecruiter(user: User) = Single.create<ParseObject> { emitter ->
        try {
            val query = ParseQuery.getQuery<ParseObject>("Recruiter")
            if (user.phoneNumber.isNotEmpty())
                query.whereEqualTo("phoneNumber", user.phoneNumber)
            if (user.email.isNotEmpty())
                query.whereEqualTo("email", user.email)

            query.whereEqualTo("loginType", user.loginType)

            val result = query.find().firstOrNull()

            if (result != null)
                emitter.onSuccess(result)
            else
                emitter.onError(ParseQueryEmptyThrowable())

        } catch (e: Exception) {

            emitter.onError(e)
        }

    }


    fun getPaymentHistory(): Single<List<ParseObject>> =
        Single.create { emitter ->
            try {
                val query =
                    ParseQuery.getQuery<ParseObject>("PaymentHistory")
                        .orderByDescending("createdAt")
                query.whereEqualTo("userId", ParseUser.getCurrentUser().objectId)
                    .include("createdAt")
                val list = query.find()
                if (list != null) emitter.onSuccess(list)
            } catch (e: Exception) {
                log("could not load the payment history", e)
                emitter.onError(e)
            }
        }

    suspend fun rejectJobSeeker(
        jobSeeker: ParseObject,
        reason: String,
        selectedJobOffer: ParseObject
    ) {
        try {
            val reasonModel = RejectReason()
            reasonModel.jobOfferId = JobOffer(selectedJobOffer).jobOfferId
            reasonModel.jobSeekerId = JobSeeker(jobSeeker).jobSeekerId
            reasonModel.reason = reason
            reasonModel.toParseObject().save()
        } catch (e: Exception) {
            log("Could not reject with reason $reason", e)
        }
    }

    suspend fun undoJob(job: ParseObject, jobSeeker: ParseObject) {
        try {
            val applicantsRelation = job.getRelation<ParseObject>(NODE_APPLICANTS)
            val matchedOfferRelation = job.getRelation<ParseObject>(NODE_MATCHED)
            val refusedRelation = job.getRelation<ParseObject>(NODE_REFUSED)
            applicantsRelation.add(jobSeeker)
            matchedOfferRelation.remove(jobSeeker)
            refusedRelation.remove(jobSeeker)
            job.save()
        } catch (e: Exception) {
            log("Could not undo the job", e)
        }
    }

    suspend fun cancelJobSeeker(jobSeeker: ParseObject) {
        try {
            val cancelledRelation = jobSeeker.getRelation<ParseObject>(NODE_CANCELLED)
            cancelledRelation.add(getCurrentRecruiter().blockingGet())
            jobSeeker.save()
        } catch (e: Exception) {
            log("Could not cancel the job seeker", e)
        }
    }

    suspend fun refuseJob(job: ParseObject, jobSeeker: ParseObject) {
        try {
            val applicantsRelation = job.getRelation<ParseObject>(NODE_APPLICANTS)
            val refusedRelation = job.getRelation<ParseObject>(NODE_REFUSED)
            applicantsRelation.remove(jobSeeker)
            refusedRelation.add(jobSeeker)
            job.save()
        } catch (e: Exception) {
            log("Could not refuse the job", e)
        }
    }


    fun updateMessagePushNotificationFlag(flag: Boolean, recruiterObject: ParseObject?) {
        if (recruiterObject != null) {
            try {
                recruiterObject.put("messagePNFlag", flag)
                recruiterObject.save()
                log("updateMessagePushNotificationFlag is successful with $flag")
            } catch (e: Exception) {
                log("Could not updateMessagePushNotificationFlag due to ${e.message}", e)
            }
        }
    }


    fun updateNewsMatchesPushNotificationFlag(flag: Boolean, recruiterObject: ParseObject?) {
        if (recruiterObject != null) {
            try {
                recruiterObject.put("newMatchPNFlag", flag)
                recruiterObject.save()
                log("updateNewsMatchesPushNotificationFlag is successful with $flag")
            } catch (e: Exception) {
                log("Could not updateNewsMatchesPushNotificationFlag due to ${e.message}", e)
            }
        }
    }
}
