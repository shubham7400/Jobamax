package com.findajob.jobamax.repo

import ServiceBuilder
import android.text.Html
import com.findajob.jobamax.data.pojo.Message
import com.findajob.jobamax.jobseeker.track.JobSeekerTrackState
import com.findajob.jobamax.model.*
import com.findajob.jobamax.network.*
import com.findajob.jobamax.util.*
import com.parse.*
import io.reactivex.Single
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class JobOfferRepository @Inject constructor() {

    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val defaultScope = CoroutineScope(Dispatchers.Default)

    val currentUser: ParseUser by lazy {
        ParseUser.getCurrentUser()
    }

    val currentUserId: String by lazy {
        currentUser.objectId
    }

    fun getCurrentRecruiterObject() = Single.create<ParseObject> { emitter ->
        try {
            val recruiterQuery = ParseQuery.getQuery<ParseObject>(Recruiter.CLASS_NAME)
            recruiterQuery.whereEqualTo("userId", currentUserId)
            val foundList = recruiterQuery.find()
            if (foundList.isNullOrEmpty()) emitter.onError(ParseQueryEmptyThrowable())
            else emitter.onSuccess(foundList[0])
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }

    fun save(jobOffer: ParseObject, recruiter: ParseObject) = Single.create<String> { emitter ->
        try {

            jobOffer.put("recruiterId", currentUserId)

            jobOffer.save()

            val relation: ParseRelation<ParseObject> = recruiter.getRelation("jobOffers")
            relation.add(jobOffer)
            recruiter.save()

            emitter.onSuccess(jobOffer.objectId)
        } catch (e: Exception) {
            log("job offer could not be saved ${e.message}")
            e.printStackTrace()

            emitter.onError(e)
        }
    }

    fun get(jobOfferId: String, callback: GetJobOfferCallback) {
        val query = ParseQuery.getQuery<ParseObject>(JobOffer.CLASS_NAME)
        query.whereEqualTo("jobOfferId", jobOfferId)
        query.findInBackground { it, e ->
            val item = it?.firstOrNull()
            when {
                e != null -> callback.onFinish(null)
                else -> callback.onFinish(item)
            }
        }
    }

    private fun archiveMessageWithThisJob(jobOfferId: String) {
        ioScope.launch {
            try {
                val messageQuery = ParseQuery.getQuery(Message::class.java)

                log("archiveMessageWithThisJob: Finding job with $jobOfferId offer id")

                messageQuery.whereEqualTo("jobId", jobOfferId)

                val messagesWithThisJob = messageQuery.find()

                messagesWithThisJob.forEach { message ->
                    // checking beforehand if archived or not,
                    // as if archived no need to change the object and
                    // save it, using extra cpu and internet
                    if (!message.isArchived) {
                        message.isArchived = true
                        message.save()
                    }
                }
            } catch (e: Exception) {
                log("archiveMessageWithThisJob: could not archive the message for $jobOfferId job.")
            }
        }
    }

    private fun unArchiveMessageWithThisJob(jobOfferId: String) {
        ioScope.launch {
            try {
                val messageQuery = ParseQuery.getQuery(Message::class.java)

                messageQuery.whereEqualTo("jobId", jobOfferId)

                val messagesWithThisJob = messageQuery.find()

                messagesWithThisJob.forEach { message ->
                    if (message.isArchived) {
                        message.isArchived = false
                        message.save()
                    }
                }
            } catch (e: Exception) {
                log("could not unarchive the message for $jobOfferId job.")
            }
        }
    }


    fun getJobOfferByObjectId(objectId: String) = Single.create<JobOffer> { emitter ->
        if (objectId.isEmpty()) emitter.onError(Throwable("The object id was empty"))

        try {
            val jobOfferQuery = ParseQuery.getQuery<ParseObject>(JobOffer.CLASS_NAME)
            jobOfferQuery.whereEqualTo("objectId", objectId)
            val jobOfferPO: ParseObject = jobOfferQuery.find()[0]
            val jobOffer = JobOffer(jobOfferPO)
            emitter.onSuccess(jobOffer)
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }

    private fun rejectAllJobSeekersOfAnOffer(selectedJobOffer: ParseObject) {
        defaultScope.launch {
            try {
                val relation = selectedJobOffer.getRelation<ParseObject>(NODE_APPLICANTS)
                val applicantList = relation.query.find()

                log("rejectAllJobSeekersOfAnOffer: The size of the applications are ${applicantList.size}")

                applicantList.forEach { applicant ->

                    if (applicant != null) {
                        val reasonModel = RejectReason()
                        reasonModel.jobOfferId = JobOffer(selectedJobOffer).jobOfferId
                        reasonModel.jobSeekerId = JobSeeker(applicant).jobSeekerId
                        reasonModel.reason = "The job was deleted"
                        reasonModel.toParseObject().save()
                    } else {
                        log("Jobseeker parse object is  null and the applicant object id is ${applicant?.objectId}")
                    }
                }

            } catch (e: Exception) {
                log("Could not reject with reason deleted the job", e)
            }
        }
    }

    fun archiveJobOffer(jobOfferId: String) = Single.create<Boolean> { emitter ->

        try {
            val jobOfferQuery = ParseQuery.getQuery<ParseObject>(JobOffer.CLASS_NAME)
            jobOfferQuery.whereEqualTo("jobOfferId", jobOfferId)
            val jobOffer: ParseObject = jobOfferQuery.find()[0]
            archiveMessageWithThisJob(jobOfferId)
            rejectAllJobSeekersOfAnOffer(jobOffer)
            jobOffer.put("isArchived", true)
            jobOffer.save()
            emitter.onSuccess(true)

        } catch (e: Exception) {
            log("Could not archive the job offer due to ${e.message}")
            e.printStackTrace()
            emitter.onError(e)

        }
    }

    fun unArchiveJobOffer(jobOfferId: String) = Single.create<Boolean> { emitter ->

        log("unarchiving $jobOfferId")

        try {
            val jobOfferQuery = ParseQuery.getQuery<ParseObject>(JobOffer.CLASS_NAME)
            jobOfferQuery.whereEqualTo("jobOfferId", jobOfferId)
            val jobOffer: ParseObject = jobOfferQuery.find()[0]
            unArchiveMessageWithThisJob(jobOfferId)
            jobOffer.put("isArchived", false)
            jobOffer.save()
            emitter.onSuccess(true)

        } catch (e: Exception) {
            log("Could not unarchive the job offer due to ${e.message}")
            e.printStackTrace()
            emitter.onError(e)

        }
    }

    fun getAll() = Single.create<List<ParseObject>> { emitter ->

        log("current object id ${currentUser.objectId}, current object $currentUser and the object id $currentUserId ")

        val query = ParseQuery.getQuery<ParseObject>(JobOffer.CLASS_NAME)
        query.whereEqualTo("recruiterId", currentUserId)

        try {
            val jobOfferList = query.find()
            emitter.onSuccess(jobOfferList)
        } catch (e: Exception) {
            emitter.onError(e)
        }

    }

    fun getActiveJobOffer() = Single.create<List<ParseObject>> { emitter ->
        val query = ParseQuery.getQuery<ParseObject>(JobOffer.CLASS_NAME)
        query.whereEqualTo("recruiterId", currentUserId)
        query.whereEqualTo("isArchived", false)

        try {
            val jobOfferList = query.find()
            emitter.onSuccess(jobOfferList)
        } catch (e: Exception) {
            emitter.onError(e)
        }

    }

    fun getArchivedJobOffer() = Single.create<List<ParseObject>> { emitter ->

        val query = ParseQuery.getQuery<ParseObject>(JobOffer.CLASS_NAME)
        query.whereEqualTo("recruiterId", currentUserId)
        query.whereEqualTo("isArchived", true)

        try {
            val jobOfferList = query.find()
            emitter.onSuccess(jobOfferList)
        } catch (e: Exception) {
            emitter.onError(e)
        }

    }

    private fun getJobSeekerByUserId(userId: String): JobSeeker? {
        return try {
            val jobSeekerQuery = ParseQuery.getQuery<ParseObject>(JobSeeker.CLASS_NAME)
            jobSeekerQuery.whereEqualTo("userId", userId)
            JobSeeker(jobSeekerQuery.find().first())
        } catch (e: Exception) {
            log("The job seeker for $userId could not be found")
            null
        }
    }

    fun getAppliedJobs(jobSeekerObjectId: String) = Single.create<JobSeekerTrackState> { emitter ->
        val state = JobSeekerTrackState()

        try {

//            val jobSeeker = getJobSeekerByUserId(currentUserId)
//
//            if (jobSeeker == null) emitter.onError(ParseQueryEmptyThrowable())

            val jobSeekerId: String? = jobSeekerObjectId

            if (jobSeekerId == null) emitter.onError(ParseQueryEmptyThrowable())
            else {

                val appliedList = ParseQuery.getQuery<ParseObject>(JobOffer.CLASS_NAME)
                    .whereMatchesQuery(
                        NODE_APPLICANTS,
                        ParseQuery.getQuery<ParseObject>("JobSeeker")
                            .whereEqualTo("jobSeekerId", jobSeekerId)
                    )
                    .find()

                state.appliedList = appliedList

                val matchedList = ParseQuery.getQuery<ParseObject>(JobOffer.CLASS_NAME)
                    .whereMatchesQuery(
                        NODE_MATCHED,
                        ParseQuery.getQuery<ParseObject>("JobSeeker")
                            .whereEqualTo("jobSeekerId", jobSeekerId)
                    )
                    .find()

                state.matchedList = matchedList

                val refusedList = ParseQuery.getQuery<ParseObject>(JobOffer.CLASS_NAME)
                    .whereMatchesQuery(
                        NODE_REFUSED,
                        ParseQuery.getQuery<ParseObject>("JobSeeker")
                            .whereEqualTo("jobSeekerId", jobSeekerId)
                    )
                    .find()

                state.refusedList = refusedList

                state.refuseReasons = ParseQuery<ParseObject>("RejectReason")
                    .whereEqualTo("jobSeekerId", jobSeekerId)
                    .find()

                emitter.onSuccess(state)
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }


    fun getAll(jobSeeker: JobSeeker, currentLocation: ParseGeoPoint, index: Int, callback: GetAllJobOfferCallback) {
        // When job seeker type in keyword the name of company,
        // he will see all jobs of the companies
        var distanceQueryFlag = false
        try {
            val titleQuery = ParseQuery.getQuery<ParseObject>(JobOffer.CLASS_NAME)
            if (jobSeeker.job.isEmpty()) callback.onFinish(titleQuery.find() ?: listOf())
            val companyNameQuery = ParseQuery.getQuery<ParseObject>(JobOffer.CLASS_NAME)
            val descriptionQuery = ParseQuery.getQuery<ParseObject>(JobOffer.CLASS_NAME)
            val skillsQuery = ParseQuery.getQuery<ParseObject>(JobOffer.CLASS_NAME)
//            titleQuery.whereExists("Company").whereEqualTo("name", jobSeeker.job)
            val list = ArrayList<ParseQuery<ParseObject>>()
            list.add(titleQuery)
            if (jobSeeker.job.isNotEmpty()) {
                titleQuery.whereContains("name", jobSeeker.job)
                descriptionQuery.whereContains("description", jobSeeker.job)
                skillsQuery.whereContains("skills", jobSeeker.job)

                // When job seeker type in keyword the name of company,
                // job seeker will see all jobs of the companies
                val companyQuery = ParseQuery.getQuery<ParseObject>(Company.CLASS_NAME)
                companyQuery.whereEqualTo("name", jobSeeker.job)
                val company = companyQuery.find().firstOrNull()

                if (company != null) {
                    companyNameQuery.whereEqualTo("recruiterId", Company(company).recruiterId)
                }

                list.add(descriptionQuery)
                list.add(skillsQuery)
                list.add(companyNameQuery)
            }

            val query = ParseQuery.or(list)
            if (jobSeeker.typeOfWork.any { it.trim().isNotEmpty() })
                query.whereContainedIn("typeOfWork", jobSeeker.typeOfWork)

            // should Experience : if checking >2 ->
            // for algortihm means all jobs / if 1-2
            // means everything except >2
            // and if <1 means only this one BY default all if none is checked
            if (jobSeeker.experience.any { it.trim().isNotEmpty() }) {
                when {
                    jobSeeker.experience.contains("one-two") -> {
                        query.whereContainedIn("experience",
                            jobSeeker.experience.map {
                                it.trim()
                            }.filter {
                                it.isNotEmpty()
                            }.filter {
                                it.contains("one-two") || it.contains("under-one")
                            }
                        )
                    }
                    jobSeeker.experience.contains("under-one") -> {
                        query.whereContainedIn(
                            "experience",
                            jobSeeker.experience.map {
                                it.trim()
                            }.filter {
                                it.isNotEmpty()
                            }.filter {
                                it.contains("under-one")
                            }
                        )
                    }
                    else -> {
                        query.whereContainedIn(
                            "experience",
                            jobSeeker.experience.map {
                                it.trim()
                            }.filter {
                                it.isNotEmpty()
                            }
                        )
                    }
                }
            }

            if (jobSeeker.jobCategory.any { it.trim().isNotEmpty() })
                query.whereContainedIn(
                    "jobCategory",
                    jobSeeker.jobCategory.map { it.trim() }.filter { it.trim().isNotEmpty() })

            if (jobSeeker.distance > 0 && currentLocation.latitude > 0 && currentLocation.longitude > 0) {
                query.whereWithinKilometers("geoLocation", currentLocation, jobSeeker.distance.toDouble())
                distanceQueryFlag = true
            }

            query.include("company")
            val innerQuery = ParseQuery.getQuery<ParseObject>("JobSeeker").whereEqualTo("jobSeekerId", jobSeeker.jobSeekerId)

            query.whereDoesNotMatchQuery(NODE_APPLICANTS, innerQuery)
            query.whereDoesNotMatchQuery(NODE_DROPOUTS, innerQuery)
            query.whereDoesNotMatchQuery(NODE_MATCHED, innerQuery)
            query.whereDoesNotMatchQuery(NODE_REFUSED, innerQuery)

            query.skip = index * JOB_OFFER_PAGE_SIZE
            query.limit = JOB_OFFER_PAGE_SIZE

            // keep the jobs that has the most swipe on top
            query.orderByDescending("swipeAmount")
            val offers = query.find() ?: listOf()
            callback.onFinish(offers)
        } catch (e: Exception) {
            callback.onFinish(emptyList())
        }
    }

    fun increaseJobSwipe(jobOffer: ParseObject) {
        try {
            jobOffer.increment("swipeAmount" + 1)
            jobOffer.save()
        } catch (e: Exception) {
            log("could not increment the job offer swipe count by 1", e)
        }
    }

    fun loadJobsPikrJobOffers(jobSeeker: JobSeeker, callback: GetAllJobOfferCallback) {
        val retrofit = ServiceBuilder.buildServiceJobsPikr(JobsPikrJobOfferNetwork::class.java)
        // default to 20 job offers
        val size = 20
        val format = "json"
        // default to California state for now
        val location = "California"
        val locationQuery = QueryString(location, listOf("state", "inferred_state"))
        val jobQuery = QueryString(jobSeeker.job, listOf("job_title"))

        val jobList = MustItem(jobQuery)
        val locationList = MustItem(locationQuery)
        val bool = Bool(listOf(jobList, locationList))
        val searchQueryJson = SearchQueryJson(bool)

        val jobsPikrRequest = JobRequestJobsPikr(size, format, searchQueryJson)
        retrofit.getJobOffer(jobsPikrRequest).enqueue(
            object : Callback<JobOfferJobsPikr> {
                override fun onFailure(call: Call<JobOfferJobsPikr>, t: Throwable) {
                    callback.onFinish(listOf())
                }

                override fun onResponse(
                    call: Call<JobOfferJobsPikr>,
                    response: Response<JobOfferJobsPikr>
                ) {
                    processJobsPikrResponse(callback, response)
                }
            }
        )
    }

    fun processJobsPikrResponse(
        callback: GetAllJobOfferCallback,
        response: Response<JobOfferJobsPikr>
    ) {
        val results = response.body()?.jobData
        val jobOfferList = arrayListOf<ParseObject>()

        if (results != null) {
            for (result in results) {
                val jobOffer = JobOffer()
                jobOffer.description = result.jobDescription
                jobOffer.name = result.jobTitle
                jobOffer.companyName = result.companyName
                jobOffer.location = result.country
                jobOffer.city = result.city
                val typeOfWork = arrayListOf<String>()
                if (result.jobType.contains("Part")) {
                    typeOfWork.add(CONST_PART_TIME)
                } else {
                    typeOfWork.add(CONST_FULL_TIME)
                }
                jobOffer.typeOfWork = typeOfWork
                jobOffer.documentUrl = result.url
                jobOffer.jobOfferId = JOBSPIKR_JOB
                jobOffer.industry = result.category

                jobOfferList.add(jobOffer.toParseObject())
            }
        }
        callback.onFinish(jobOfferList)
    }

    fun loadRemotiveJobOffers(jobSeeker: JobSeeker, callback: GetAllJobOfferCallback) {
        val retrofit = Retrofit.Builder().baseUrl(getRemotiveBaseUrl())
            .addConverterFactory(GsonConverterFactory.create()).build()

        val service = retrofit.create(RemotiveJobOfferNetwork::class.java)
        val title = jobSeeker.job
        service.getJobOffer(title).enqueue(object : Callback<JobOfferRemotive> {
            override fun onFailure(call: Call<JobOfferRemotive>, t: Throwable) {
                callback.onFinish(listOf())
            }

            override fun onResponse(
                call: Call<JobOfferRemotive>,
                response: Response<JobOfferRemotive>
            ) {
                processRemotiveResponse(jobSeeker, callback, response)
            }
        })
    }

    fun processRemotiveResponse(
        jobSeeker: JobSeeker,
        callback: GetAllJobOfferCallback,
        response: Response<JobOfferRemotive>
    ) {
        val results = response.body()?.jobs
        val fullTime = jobSeeker.typeOfWork.contains(CONST_FULL_TIME)
        val partTime = jobSeeker.typeOfWork.contains(CONST_PART_TIME)
        var count = 0
        val jobOfferList = arrayListOf<ParseObject>()

        if (results != null) {
            for (result in results) {
                // limit to 10 results
                if (count >= 20)
                    break

                // filter out full time and part time jobs
                if (fullTime != partTime && ((fullTime && !result.job_type.contains("full_time")) || (partTime && !result.job_type.contains(
                        "part_time"
                    )))
                )
                    continue

                val jobOffer = JobOffer()
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    jobOffer.description =
                        Html.fromHtml(result.description, Html.FROM_HTML_MODE_LEGACY).toString()
                } else {
                    jobOffer.description = Html.fromHtml(result.description).toString()
                }

                jobOffer.name = result.title
                jobOffer.companyName = result.company_name
                jobOffer.industry = result.category
                jobOffer.monthlySalary = result.salary
                val typeOfWork = arrayListOf<String>()
                typeOfWork.add(result.job_type)
                jobOffer.typeOfWork = typeOfWork
                jobOffer.documentUrl = result.url
                jobOffer.jobOfferId = REMOTIVE_JOB

                jobOfferList.add(jobOffer.toParseObject())
                count++
            }
        }
        callback.onFinish(jobOfferList)
    }

    fun loadUSAJobsJobOffers(jobSeeker: JobSeeker, callback: GetAllJobOfferCallback) {
        val retrofit = Retrofit.Builder().baseUrl(getUsaJobsBaseUrl())
            .addConverterFactory(GsonConverterFactory.create()).build()

        val service = retrofit.create(UsaJobsJobOfferNetwork::class.java)
        val title = jobSeeker.job
        val location = jobSeeker.location
        service.getJobOffer(title, location).enqueue(object : Callback<JobOfferUsaJobs> {
            override fun onFailure(call: Call<JobOfferUsaJobs>, t: Throwable) {
                callback.onFinish(listOf())
            }

            override fun onResponse(
                call: Call<JobOfferUsaJobs>,
                response: Response<JobOfferUsaJobs>
            ) {
                processUsaJobsResponse(callback, response)
            }
        })
    }

    fun processUsaJobsResponse(
        callback: GetAllJobOfferCallback,
        response: Response<JobOfferUsaJobs>
    ) {
        val results = response.body()?.SearchResult?.SearchResultItems
        val jobOfferList = arrayListOf<ParseObject>()

        if (results != null) {
            for (result in results) {

                val jobOffer = JobOffer()
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    jobOffer.description = Html.fromHtml(
                        result.MatchedObjectDescriptor.UserArea.Details.JobSummary,
                        Html.FROM_HTML_MODE_LEGACY
                    ).toString()
                } else {
                    jobOffer.description =
                        Html.fromHtml(result.MatchedObjectDescriptor.UserArea.Details.JobSummary)
                            .toString()
                }

                jobOffer.name = result.MatchedObjectDescriptor.PositionTitle
                jobOffer.companyName = result.MatchedObjectDescriptor.OrganizationName
                jobOffer.industry = result.MatchedObjectDescriptor.JobCategory?.get(0)?.Name!!
                jobOffer.monthlySalary =
                    result.MatchedObjectDescriptor.PositionRemuneration?.get(0)?.MaximumRange!!
                val typeOfWork = arrayListOf<String>()
                typeOfWork.add(CONST_FULL_TIME)
                jobOffer.typeOfWork = typeOfWork
                jobOffer.documentUrl = result.MatchedObjectDescriptor.PositionURI
                jobOffer.jobOfferId = USAJOBS_JOB

                jobOfferList.add(jobOffer.toParseObject())
            }
        }
        callback.onFinish(jobOfferList)
    }

    fun loadJoobleJobOffers(jobSeeker: JobSeeker, callback: GetAllJobOfferCallback) {
        val retrofit = ServiceBuilder.buildService(JoobleJobOfferNetwork::class.java)
        val joobleRequest: JoobleRequest = JoobleRequest(jobSeeker.location, jobSeeker.job)
        retrofit.getJobOffer(joobleRequest).enqueue(
            object : Callback<JobOfferJooble> {
                override fun onFailure(call: Call<JobOfferJooble>, t: Throwable) {
                    callback.onFinish(listOf())
                }

                override fun onResponse(
                    call: Call<JobOfferJooble>,
                    response: Response<JobOfferJooble>
                ) {
                    processJoobleResponse(callback, response)
                }
            }
        )
    }

    fun processJoobleResponse(
        callback: GetAllJobOfferCallback,
        response: Response<JobOfferJooble>
    ) {
        val results = response.body()?.jobs
        val jobOfferList = arrayListOf<ParseObject>()

        if (results != null) {
            for (result in results) {
                val jobOffer = JobOffer()
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    jobOffer.description =
                        Html.fromHtml(result.snippet, Html.FROM_HTML_MODE_LEGACY).toString()
                } else {
                    jobOffer.description = Html.fromHtml(result.snippet).toString()
                }
                jobOffer.name = result.title
                jobOffer.companyName = result.company
                jobOffer.monthlySalary = result.salary
                jobOffer.location = result.location
                jobOffer.city = result.location
                val typeOfWork = arrayListOf<String>()
                if (result.type.contains("Part")) {
                    typeOfWork.add(CONST_PART_TIME)
                } else {
                    typeOfWork.add(CONST_FULL_TIME)
                }
                jobOffer.typeOfWork = typeOfWork
                jobOffer.documentUrl = result.link
                jobOffer.jobOfferId = JOOBLE_JOB

                jobOfferList.add(jobOffer.toParseObject())
            }
        }
        callback.onFinish(jobOfferList)
    }

    fun loadAdzunaJobOffers(jobSeeker: JobSeeker, callback: GetAllJobOfferCallback) {
        val retrofit = Retrofit.Builder().baseUrl(getAdzunaBaseUrl("us"))
            .addConverterFactory(GsonConverterFactory.create()).build()

        val appId = ADZUNA_APP_ID
        val appKey = ADZUNA_APP_KEY
        val service = retrofit.create(AdzunaJobOfferNetwork::class.java)
        // default to 20 results
        val resultsPerPage = 20
        val contentType = "application/json"
        val job = jobSeeker.job
        val fullTime = jobSeeker.typeOfWork.contains(CONST_FULL_TIME)
        val partTime = jobSeeker.typeOfWork.contains(CONST_PART_TIME)
        val location = jobSeeker.location
        val distance = jobSeeker.distance

        if (fullTime == partTime) {
            service.getJobOffer(appId, appKey, job, location, distance, resultsPerPage, contentType)
                .enqueue(object : Callback<JobOfferAdzuna> {
                    override fun onFailure(call: Call<JobOfferAdzuna>, t: Throwable) {
                        callback.onFinish(listOf())
                    }

                    override fun onResponse(
                        call: Call<JobOfferAdzuna>,
                        response: Response<JobOfferAdzuna>
                    ) {
                        processAdzunaResponse(callback, response)
                    }
                })
        } else {
            val type = if (fullTime) mapOf("full_time" to 1) else mapOf("part_time" to 1)
            service.getJobOffer(
                appId,
                appKey,
                job,
                location,
                distance,
                resultsPerPage,
                contentType,
                type
            ).enqueue(object : Callback<JobOfferAdzuna> {
                override fun onFailure(call: Call<JobOfferAdzuna>, t: Throwable) {
                    callback.onFinish(listOf())
                }

                override fun onResponse(
                    call: Call<JobOfferAdzuna>,
                    response: Response<JobOfferAdzuna>
                ) {
                    processAdzunaResponse(callback, response)
                }
            })
        }
    }

    fun processAdzunaResponse(
        callback: GetAllJobOfferCallback,
        response: Response<JobOfferAdzuna>
    ) {
        val results = response.body()?.results
        val jobOfferList = arrayListOf<ParseObject>()

        if (results != null) {
            for (result in results) {
                val jobOffer = JobOffer()
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    jobOffer.name =
                        Html.fromHtml(result.title, Html.FROM_HTML_MODE_LEGACY).toString()
                    jobOffer.description =
                        Html.fromHtml(result.description, Html.FROM_HTML_MODE_LEGACY).toString()
                } else {
                    jobOffer.name = Html.fromHtml(result.title).toString()
                    jobOffer.description = Html.fromHtml(result.description).toString()
                }
                jobOffer.companyName = result.company.display_name
                jobOffer.industry = result.category.label
                jobOffer.monthlySalary = String.format("%.0f", result.salary_max / 12)
                jobOffer.location = result.location.display_name
                jobOffer.city = result.location.display_name
                val typeOfWork = arrayListOf<String>()
                if (result.contract_time == "part_time") {
                    typeOfWork.add(CONST_PART_TIME)
                } else {
                    typeOfWork.add(CONST_FULL_TIME)
                }
                jobOffer.typeOfWork = typeOfWork
                jobOffer.documentUrl = result.redirect_url
                jobOffer.jobOfferId = ADZUNA_JOB

                jobOfferList.add(jobOffer.toParseObject())
            }
        }
        callback.onFinish(jobOfferList)
    }

}

interface SaveJobOfferCallback {
    fun onFinish(isSuccessful: Boolean)
}


interface GetAllJobOfferCallback {
    fun onFinish(parseObjects: List<ParseObject>)
}

interface GetJobOfferCallback {
    fun onFinish(jobOffer: ParseObject?)
}

interface FCMCallback {
    fun onResult(status: Boolean, message: String)
}