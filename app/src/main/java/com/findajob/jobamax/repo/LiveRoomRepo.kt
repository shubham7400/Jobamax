package com.findajob.jobamax.repo

import android.app.Application
import com.findajob.jobamax.model.*
import com.findajob.jobamax.preference.getRole
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.ParseQueryEmptyThrowable
import com.findajob.jobamax.util.ROLE_JOB_SEEKER
import com.findajob.jobamax.util.afterDays
import com.findajob.jobamax.util.log
import com.parse.ParseObject
import com.parse.ParseQuery
import com.parse.ParseUser
import io.reactivex.Single
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class LiveRoomRepo @Inject constructor(val context: Application) {

    // so that the current user id is queried only once,
    // not every time, wasting resources and taking time
    private val currentUserId: String by lazy {
        ParseUser.getCurrentUser().objectId
    }

    private val currentUser: ParseObject by lazy {
        getUserById(currentUserId) ?: ParseObject.createWithoutData(User.CLASS_NAME, currentUserId)
    }


    private var _userQuery = ParseQuery.getQuery<ParseObject>(User.CLASS_NAME)

    private var _parseRecruiterQuery = ParseQuery.getQuery<ParseObject>(Recruiter.CLASS_NAME)

    private var _parseJobSeekerQuery = ParseQuery.getQuery<ParseObject>(JobSeeker.CLASS_NAME)


    private val roomList = arrayListOf<ParseObject>()

    private val ioScope = CoroutineScope(Dispatchers.IO)


    /**
     * This function takes the user id, and returns Recruiter Parse Object
     *
     * @param userId as String
     *
     * @return Recruiter [ParseObject]
     */
    private fun getRecruiterById(userId: String): ParseObject? {
        try {
            val parseRecruiterQuery = _parseRecruiterQuery
            parseRecruiterQuery.whereEqualTo("userId", userId)

            val foundRecruiterList = parseRecruiterQuery.find()
            return foundRecruiterList[0]
        } catch (e: Exception) {
            return null
        }
    }

    /**
     * This function takes the user id, and returns JobSeeker Parse Object
     *
     * @param userId as String
     *
     * @return JobSeeker [ParseObject]
     */
    private fun getJobSeekerById(userId: String): ParseObject? = try {
        val parseJobSeekerQuery = _parseJobSeekerQuery
        parseJobSeekerQuery.whereEqualTo("userId", userId)
        val foundJobSeekerList = parseJobSeekerQuery.find()
        foundJobSeekerList[0]
    } catch (e: Exception) {
        null
    }

    /**
     * This function takes the user id, and returns an User Parse Object
     *
     * @param userId as String
     *
     * @return _User [ParseObject]
     */
    private fun getUserById(userId: String): ParseObject? = try {
        val receiverParseQuery = _userQuery

        receiverParseQuery.whereEqualTo("userId", userId)

        val foundReceiverList = receiverParseQuery.find()

        foundReceiverList[0]
    } catch (e: Exception) {
        log("could not get the user due to ${e.message}")
        null
    }

    private fun getRecruiterByRecruiterId(recruiterId: String): ParseObject? = try {
        val receiverParseQuery = ParseQuery.getQuery<ParseObject>(Recruiter.CLASS_NAME)

        receiverParseQuery.whereEqualTo("recruiterId", recruiterId)

        val foundReceiverList = receiverParseQuery.find()

        foundReceiverList[0]
    } catch (e: Exception) {
        log("could not get the user due to ${e.message}")
        null
    }


    fun getRooms() = Single.create<Pair<
            List<ParseObject>, // rooms
            List<String> // interests
            >> { emitter ->

        val jobSeeker = getJobSeekerById(currentUserId)

        var interests = listOf<String>()

        interests = if (jobSeeker != null) {
            jobSeeker.get("interests") as List<String>
        } else {
            val recruiter = getRecruiterById(currentUserId)
            recruiter!!.get("interests") as List<String>
        }

        val liveRoomQuery = ParseQuery.getQuery<ParseObject>(LiveRoom.CLASS_NAME)

        if (interests.isNotEmpty()) {
            liveRoomQuery.whereMatches(
                "category",
                "^.*?((?i)${interests.joinToString("|")}).*$"
            )
        }

        val liveRoomList = liveRoomQuery.find()

        emitter.onSuccess(Pair(liveRoomList, interests))

    }


    private fun getRoomById(roomId: String): ParseObject? {
        try {
            val roomQuery = ParseQuery.getQuery<ParseObject>(LiveRoom.CLASS_NAME)
            roomQuery.whereEqualTo("roomId", roomId)
            return roomQuery.find().firstOrNull()
        } catch (e: Exception) {
            return null
        }
    }


    fun getSavedRoom() = Single.create<ParseObject> { emitter ->
        if (context.getRole() == ROLE_JOB_SEEKER) {
            val calendar = Calendar.getInstance()

            val jobSeeker = getJobSeekerById(currentUserId)
            val roomId = jobSeeker?.get("roomId").toString()
            val roomExpiryDate = Date().afterDays(14)

            if (roomExpiryDate != null && roomExpiryDate > calendar.time) {

                if (roomExpiryDate > calendar.time) {
                    val savedRoom = getRoomById(roomId)

                    if (savedRoom == null) {
                        emitter.onError(ParseQueryEmptyThrowable())
                    } else {
                        emitter.onSuccess(savedRoom)
                    }
                }

            }
        } else {
            val calendar = Calendar.getInstance()

            val recruiter = getRecruiterById(currentUserId)
            val roomId = recruiter?.get("roomId").toString()
            val roomExpiryDate = Date().afterDays(14)

            if (roomExpiryDate != null && roomExpiryDate > calendar.time) {

                if (roomExpiryDate > calendar.time) {
                    val savedRoom = getRoomById(roomId)

                    if (savedRoom == null) {
                        emitter.onError(ParseQueryEmptyThrowable())
                    } else {
                        emitter.onSuccess(savedRoom)
                    }
                }
            }
        }
    }

    fun loadRoom(roomId: String, callback: GetRoomCallback) {
        ioScope.launch {
            val query = ParseQuery.getQuery<ParseObject>(LiveRoom.CLASS_NAME)
            query.whereEqualTo("roomId", roomId)
            query.findInBackground { objects, _ ->
                callback.onFinish(objects ?: listOf(), listOf())
            }
        }
    }

    fun save(room: ParseObject, callback: SaveRoomCallback) {

//        ioScope.launch {
        try {
            room.save()
            callback.onFinish(true)
        } catch (e: Exception) {
            log("could not save the room due to ${e.message}")
            callback.onFinish(false)
        }
//        }

    }

    fun add(recruiter: Recruiter) {

    }

    fun add(jobSeeker: JobSeeker) {

    }

    //    fun loadInterests() {
//        val query = ParseQuery.getQuery<ParseObject>("Interests")
//
//        val interestList = query.find()
//
//        if (interestList != null && interestList.isNotEmpty()) {
//            callback.onFinish(interestList)
//        } else {
//            callback.onFinish(listOf())
//        }
//    }
//
    fun loadInterests() = Single.create<List<ParseObject>> { emitter ->
        val query = ParseQuery.getQuery<ParseObject>("Interests")

        val interestList = query.find()

        if (interestList != null && interestList.isNotEmpty()) {
            emitter.onSuccess(interestList)
        } else {
            emitter.onError(ParseQueryEmptyThrowable())
        }
    }

    fun saveSelectedInterests(names: ArrayList<String>, callback: SaveInterestsCallback) {

//        ioScope.launch {
        try {
            val jobSeeker = getJobSeekerById(currentUserId)

            if (jobSeeker != null) {
                jobSeeker.put("interests", names.toList())
                jobSeeker.save()
            } else {
                val recruiter = getRecruiterById(currentUserId)
                recruiter?.put("interests", names.toList())
                recruiter?.save()
            }

            callback.onFinish(true)
        } catch (e: Exception) {
            log("could not save the selected interests ${e.message}")
            callback.onFinish(false)
        }
//        }
    }


    fun selectRandomRoom() = Single.create<ParseObject> { emitter ->
        roomList.random().also {
            emitter.onSuccess(it)
        }
    }


    // === === === === === === === === === ===
    // === EVENT CALENDAR RELATED FUNCTION ===
    // === === === === === === === === === ===

    /**
     * Adds an event to the database
     *
     * @param event of [Event] type
     *
     * @return [Single] of [Boolean] to note,
     * if the event saving was successful or not
     */
    fun addEvent(event: Event) = Single.create<Boolean> { emitter ->
        try {
            event.save()
            emitter.onSuccess(true)
        } catch (e: Exception) {
            emitter.onSuccess(false)
        }
    }

    // will cache the result in memory for better loading time
    private var eventListPair: Pair<MutableList<Event>, ParseObject?>? = null


    private fun getEventsByRoom(room: ParseObject?): List<Event> {

//        if (eventListPair != null && eventListPair?.second == room && eventListPair?.first != null) {
//            return eventListPair?.first!!
//        }

        // it queries for all the events in the database
        val eventParseQuery = ParseQuery.getQuery(Event::class.java)

        // then descends them by their date
        eventParseQuery.orderByDescending(Event.DATE)

        // and if the passed room is not null, it will only get the
        // events that are specific to the room
        if (room != null) eventParseQuery.whereEqualTo(Event.INTEREST, room)

        val eventList = eventParseQuery.find()

        eventListPair = Pair(eventList, room)

        return eventList
    }

    /**
     * Gets the event list of the selected date
     * filtered by the room and selected date
     *
     * Takes date and room as a parameter
     *
     * @param date of [Date] type
     * @param room of [ParseObject] type
     *
     * @return [Single] of [Event] list
     */
    fun getSelectedDateEvents(date: Date, room: ParseObject?) =
        Single.create<List<Event>> { emitter ->

            val eventList = getEventsByRoom(room)


            eventList.filter { event ->
                event.date.year == date.year
                        && event.date.month == date.month
                        && event.date.day == date.day
            }


            emitter.onSuccess(eventList)

        }

    /**
     * Gets the event list from the selected date
     * point on  filtered by the room and selected date
     *
     * Takes date and room as a parameter
     *
     * @param date of [Date] type
     * @param room of [ParseObject] type
     *
     * @return [Single] of [Event] list
     */
    fun getUpcomingEvents(date: Date, room: ParseObject?) = Single.create<List<Event>> { emitter ->

        val eventList = getEventsByRoom(room)

        eventList.filter { event ->
            event.date.year >= date.year
                    && event.date.month >= date.month
                    && event.date.day > date.day
        }

        emitter.onSuccess(eventList)

    }

    fun isLinkedInSaved(isRecruiter: Boolean): Boolean {
        val user: ParseObject? = if (isRecruiter) {
            getRecruiterById(currentUserId)
        } else {
            getJobSeekerById(currentUserId)
        }

        val data = user?.get("socialAccounts")
        if (data != null) {
            val socialAccounts = mutableListOf<String>("", "", "", "")
            val d = data as List<String>

            for ((i, w) in d.withIndex()) {
                socialAccounts[i] = w
            }

            return (!socialAccounts.isNullOrEmpty() && socialAccounts[3].trim().isNotEmpty())
        }
        return false
    }

    fun saveLinkedIn(isRecruiter: Boolean, username: String) {
        val socialAccounts: MutableList<String> = mutableListOf()
        var facebook: String = ""
        var twitter: String = ""
        var instagram: String = ""
        var savedAccounts = listOf<String>()
        val user: ParseObject?

        user = if (isRecruiter) {
            getRecruiterById(currentUserId)
        } else {
            getJobSeekerById(currentUserId)
        }

        val data = user?.get("socialAccounts")
        if (data != null) {
            savedAccounts = data as List<String>
        }

        if (!savedAccounts.isNullOrEmpty()) {
            facebook = savedAccounts[0]
            twitter = savedAccounts[1]
            instagram = savedAccounts[2]
        }

        socialAccounts.apply {
            add(0, facebook)
            add(1, twitter)
            add(2, instagram)
            add(3, username)
        }

        user?.put("socialAccounts", socialAccounts)
        user?.save()
    }

    fun getUserIdFromEmail(email: String): String {
        val query = ParseUser.getQuery()
        query.whereEqualTo("username", email)
        val user = query.find().firstOrNull()
        if (user != null)
            return user.objectId

        return ""
    }
}

interface GetRoomCallback {
    fun onFinish(rooms: List<ParseObject>, interests: List<String>)
}

interface GetSavedRoomCallback {
    fun onFinish(exists: Boolean)
}

interface GetInterestsCallback {
    fun onFinish(interests: List<ParseObject>)
}

interface SaveInterestsCallback {
    fun onFinish(isSuccessful: Boolean)
}

interface SaveRoomCallback {

    fun onFinish(isSuccessful: Boolean)
}