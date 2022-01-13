package com.findajob.jobamax.repo

import android.content.Context
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.model.GetUserCallback
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.model.JobSource
import com.findajob.jobamax.model.User
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.NODE_CANCELLED
import com.findajob.jobamax.util.ParseQueryEmptyThrowable
import com.findajob.jobamax.util.SOURCE_JOB_SEEKER_PAGE_SIZE
import com.findajob.jobamax.util.log
import com.parse.ParseObject
import com.parse.ParseQuery
import com.parse.ParseUser
import io.reactivex.Single
import javax.inject.Inject


class JobSeekerRepo @Inject constructor(var context: Context) {

    fun getCurrent(callback: GetUserCallback) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
        query.whereEqualTo(ParseTableFields.jobSeekerId.toString(), context.getUserId())
        query.findInBackground { it, e ->
            val jobSeeker = it?.firstOrNull()
            when {
                e != null -> {
                    callback.onFailure(e)
                }
                jobSeeker == null -> {
                    callback.onFailure(java.lang.Exception("User Not Found"))
                }
                else -> callback.onSuccess(jobSeeker)
            }
        }
    }

    fun loadJobSeekers(jobSource: JobSource, index: Int): List<ParseObject> {

        try {
            val sourceText = jobSource.source

            val baseQuery = ParseQuery.getQuery<ParseObject>(JobSeeker.CLASS_NAME)

            if (jobSource.source.isNotEmpty())
                baseQuery.whereFullText("experiences", jobSource.source)

            baseQuery.whereEqualTo("hideMeFlag", false)
            baseQuery.whereEqualTo("disableAccountFlag", false)
            val innerQuery = ParseQuery.getQuery<ParseObject>("Recruiter")
                .whereEqualTo("recruiterId", context.getUserId())
            baseQuery.whereDoesNotMatchQuery(NODE_CANCELLED, innerQuery)

            if (jobSource.educationList.isNotEmpty()) {
                baseQuery.whereMatches(
                    "educations",
                    "^.*?((?i)${jobSource.educationList.joinToString("|")}).*$"
                )
            }

            if (jobSource.experienceList.isNotEmpty()) {
                baseQuery.whereMatches(
                    "experiences",
                    "^.*?((?i)${jobSource.experienceList.joinToString("|")}).*$"
                )
                log("experience regex: " + "^.*?((?i)${jobSource.experienceList.joinToString("|")}).*$")
            }

            if (jobSource.locationList.isNotEmpty())
                baseQuery.whereMatches(
                    "location",
                    "^.*?((?i)${jobSource.locationList.joinToString("|")}).*$"
                )

            if (jobSource.keySkillList.isNotEmpty())
                baseQuery.whereMatches(
                    "skills",
                    "^.*?((?i)${jobSource.keySkillList.joinToString("|")}).*$"
                )

            val typeOfWorkQuery =
                ParseQuery.getQuery<ParseObject>(JobSeeker.CLASS_NAME).whereContains(
                    "typeOfWork",
                    sourceText
                )

            val jobCategoryQuery =
                ParseQuery.getQuery<ParseObject>(JobSeeker.CLASS_NAME).whereContains(
                    "jobCategory",
                    sourceText
                )
            val experiencesQuery = ParseQuery.getQuery<ParseObject>(JobSeeker.CLASS_NAME)
                .whereContains("experiences", sourceText)

            val educationQuery = ParseQuery.getQuery<ParseObject>(JobSeeker.CLASS_NAME)
                .whereContains("educations", sourceText)

            val locationQuery = ParseQuery.getQuery<ParseObject>(JobSeeker.CLASS_NAME)
                .whereContains("location", sourceText)

            val lastNameQuery = ParseQuery.getQuery<ParseObject>(JobSeeker.CLASS_NAME)
                .whereContains("lastName", sourceText)


            log("loadJobSeekers -> $sourceText");

            val queries = listOf(
                experiencesQuery,
                typeOfWorkQuery,
                locationQuery,
                lastNameQuery,
                educationQuery,
                jobCategoryQuery,
                baseQuery,
            )

            val query = ParseQuery.or(queries)

            query.limit = SOURCE_JOB_SEEKER_PAGE_SIZE
            query.skip = index * SOURCE_JOB_SEEKER_PAGE_SIZE

            return query.find() ?: emptyList()
        } catch (e: Exception) {
            return emptyList()
        }
    }


    fun getExistingJobSeeker(user: User) = Single.create<ParseObject> { emitter ->
        try {
            val query = ParseQuery.getQuery<ParseObject>("JobSeeker")
            if (user.phoneNumber.isNotEmpty())
                query.whereEqualTo("phoneNumber", user.phoneNumber)
            if (user.email.isNotEmpty())
                query.whereEqualTo("email", user.email)

            query.whereEqualTo("loginType", user.loginType)

            val list = query.find().firstOrNull()

            if (list != null) emitter.onSuccess(list) else emitter.onError(ParseQueryEmptyThrowable())
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }

    private val _parseJobSeekerQuery = ParseQuery.getQuery<ParseObject>(JobSeeker.CLASS_NAME)

    private val parseCurrentUser: ParseUser by lazy {
        ParseUser.getCurrentUser()
    }

    val currentUserId: String by lazy {
        parseCurrentUser.objectId
    }

    suspend fun getCurrentJobSeeker(): ParseObject? {
        return try {
            val parseJobSeekerQuery = _parseJobSeekerQuery
            parseJobSeekerQuery.whereEqualTo("userId", currentUserId)
            val foundJobSeekerList = parseJobSeekerQuery.find()
            log("Current job seekers is ${foundJobSeekerList[0].objectId}")
            foundJobSeekerList[0]
        } catch (e: Exception) {
            null
        }
    }

    fun getExistingJobSeeker(user: User, callback: GetUserCallback) {
        val query = ParseQuery.getQuery<ParseObject>("JobSeeker")
        if (user.phoneNumber.isNotEmpty())
            query.whereEqualTo("phoneNumber", user.phoneNumber)
        if (user.email.isNotEmpty())
            query.whereEqualTo("email", user.email)

        query.whereEqualTo("loginType", user.loginType)
        query.findInBackground { it, e ->
            val existingJobSeeker = it?.firstOrNull()
            when {
                e != null -> callback.onFailure(e)
                existingJobSeeker == null -> callback.onFailure(java.lang.Exception("User Not Found"))
                else -> callback.onSuccess(existingJobSeeker)
            }
        }
    }

    fun updateMessagePushNotificationFlag(flag: Boolean, jobSeekerObject: ParseObject?) {
        if (jobSeekerObject != null) {
            try {
                jobSeekerObject.put("messagePNFlag", flag)
                jobSeekerObject.save()
                log("updateMessagePushNotificationFlag is successful with $flag")
            } catch (e: Exception) {
                log("Could not updateMessagePushNotificationFlag due to ${e.message}", e)
            }
        }
    }


    fun updateNewsMatchesPushNotificationFlag(flag: Boolean, jobSeekerObject: ParseObject?) {
        if (jobSeekerObject != null) {
            try {
                jobSeekerObject.put("newMatchPNFlag", flag)
                jobSeekerObject.save()
                log("updateNewsMatchesPushNotificationFlag is successful with $flag")
            } catch (e: Exception) {
                log("Could not updateNewsMatchesPushNotificationFlag due to ${e.message}", e)
            }
        }
    }

}

