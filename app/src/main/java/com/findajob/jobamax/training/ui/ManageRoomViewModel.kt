package com.findajob.jobamax.training.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseAndroidViewModel
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.extensions.ioToMain
import com.findajob.jobamax.model.Event
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.model.LiveRoom
import com.findajob.jobamax.model.Recruiter
import com.findajob.jobamax.model.fcm.NotificationData
import com.findajob.jobamax.model.fcm.PushNotification
import com.findajob.jobamax.preference.getRole
import com.findajob.jobamax.preference.getUserFullName
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.repo.*
import com.findajob.jobamax.training.model.Member
import com.findajob.jobamax.util.*
import com.parse.ParseObject
import com.parse.ParseQuery
import com.parse.ParseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONException
import org.json.JSONObject
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList
import kotlin.collections.set

@HiltViewModel
class ManageRoomViewModel @Inject constructor(
    val context: Application,
    val liveRoomRepo: LiveRoomRepo,
) :
    BaseAndroidViewModel(context) {
    private var roomLiveData = MutableLiveData<List<ParseObject>>()

    var selectedRoom: ParseObject? = null

    private val _selectedRoomObservable = MutableLiveData<ParseObject>()
    var selectedRoomObservable: LiveData<ParseObject> = _selectedRoomObservable

    var roomList = arrayListOf<ParseObject>()
    var interestsList = listOf<String>()

    var recruiter: ParseObject? = null
    var jobSeeker: ParseObject? = null

    private val _eventSuccessListener = MutableLiveData<Boolean>()
    val eventSuccessListener: LiveData<Boolean> = _eventSuccessListener

    fun getRoomObserver(): LiveData<List<ParseObject>> = roomLiveData

    private val _membersLiveData = MutableLiveData<List<Member>>()
    var membersLiveData: LiveData<List<Member>> = _membersLiveData

    var members: ArrayList<Member> = arrayListOf()

    private val _todayEvents = MutableLiveData<List<Event>>()
    val todayEvents: LiveData<List<Event>> = _todayEvents

    private val _upcomingEvents = MutableLiveData<List<Event>>()
    val upcomingEvents: LiveData<List<Event>> = _upcomingEvents

    fun loadRooms() {
        liveRoomRepo.getRooms().ioToMain().subscribe(
            { roomInterestPair ->
                roomList = arrayListOf()
                roomList.addAll(roomInterestPair.first)
                roomLiveData.value = roomList
                interestsList = roomInterestPair.second
            },
            { e ->
                log("could not get the rooms due to ${e.message}")
            }
        ).addTo(disposeBag)
    }

    fun loadRooms(callback: GetRoomCallback) {
        liveRoomRepo.getRooms().ioToMain()
            .subscribe(
                { roomInterestPair ->
                    roomList = arrayListOf()
                    roomList.addAll(roomInterestPair.first)
                    roomLiveData.value = roomList
                    interestsList = roomInterestPair.second
                    callback.onFinish(roomInterestPair.first, roomInterestPair.second)
                },
                { e ->
                    log("could not get the rooms due to ${e.message}")
                }
            ).addTo(disposeBag)
    }

    fun selectRandomRoom() {
        selectedRoom = roomList.random()

        // save this room for 2 weeks
        if (context.getRole() == ROLE_JOB_SEEKER) {
            val query = ParseQuery.getQuery<ParseObject>("JobSeeker")
            val calendar = Calendar.getInstance()
            // Adding 2 weeks
            calendar.add(Calendar.WEEK_OF_YEAR, 2)
            query.whereEqualTo("jobSeekerId", context.getUserId())
            jobSeeker = jobSeeker ?: query.find().first()
            jobSeeker?.put("roomId", LiveRoom(selectedRoom!!).roomId)
            jobSeeker?.put("roomExpiryDate", calendar.time)

            jobSeeker?.save()
        } else {
            val query = ParseQuery.getQuery<ParseObject>("Recruiter")
            val calendar = Calendar.getInstance()
            // Adding 2 weeks
            calendar.add(Calendar.WEEK_OF_YEAR, 2)
            query.whereEqualTo("recruiterId", context.getUserId())
            recruiter = recruiter ?: query.find().first()
            recruiter?.put("roomId", LiveRoom(selectedRoom!!).roomId)
            recruiter?.put("roomExpiryDate", calendar.time)

            recruiter?.save()
        }
    }

    fun leaveSavedRoom() {
        if (context.getRole() == ROLE_JOB_SEEKER) {
            val query = ParseQuery.getQuery<ParseObject>("JobSeeker")
            query.whereEqualTo("jobSeekerId", context.getUserId())
            jobSeeker = jobSeeker ?: query.find().first()
            jobSeeker?.put("roomId", "")
            jobSeeker?.save()
        } else {
            val query = ParseQuery.getQuery<ParseObject>("Recruiter")
            query.whereEqualTo("recruiterId", context.getUserId())
            recruiter = recruiter ?: query.find().first()
            recruiter?.put("roomId", "")
            recruiter?.save()
        }
    }

    fun loadSavedRoom(callback: GetSavedRoomCallback) {

        liveRoomRepo.getSavedRoom().ioToMain().subscribe({ savedRoom ->
            if (savedRoom != null) {
                selectedRoom = savedRoom
                callback.onFinish(true)
            } else {
                callback.onFinish(false)
            }
        }, { e ->
            log("could not load the saved room due to ${e.message}")
            callback.onFinish(false)
        }).addTo(disposeBag)
//        liveRoomRepo.loadSavedRoom(object : GetSavedRoomCallback {
//            override fun onFinish(exists: Boolean) {
//                callback.onFinish(exists)
//            }
//        })

//        if (context.getRole() == ROLE_JOB_SEEKER) {
//            val query = ParseQuery.getQuery<ParseObject>("JobSeeker")
//            val calendar = Calendar.getInstance()
//            // Adding 2 weeks
//            query.whereEqualTo("jobSeekerId", context.getUserId())
//            jobSeeker = jobSeeker ?: query.find().first()
//            val roomId = jobSeeker?.get("roomId")
//            val roomExpiryDate = jobSeeker?.getDate("roomExpiryDate")
//
//            if (roomExpiryDate != null) {
//                if (roomExpiryDate > calendar.time) {
//                    val roomQuery = ParseQuery.getQuery<ParseObject>("LiveRoom")
//                    roomQuery.whereEqualTo("roomId", roomId)
//                    val savedRoom = roomQuery.find().firstOrNull()
//                    if (savedRoom == null) {
//                        callback.onFinish(false)
//                    } else {
//                        selectedRoom = savedRoom
//                        callback.onFinish(true)
//                    }
//                }
//            }
//        }
//        callback.onFinish(false)
    }

    fun selectRandomRoomInBackground() {
        liveRoomRepo.selectRandomRoom().ioToMain().subscribe(
            { selectedRoom ->
                _selectedRoomObservable.value = selectedRoom
            },
            { t ->
                t.printStackTrace()
            }
        ).addTo(disposeBag)
    }

    fun saveRoom(name: String, category: String, callback: SaveRoomCallback) {
        val liveRoom = LiveRoom()
        val interests = listOf(category)
        liveRoom.name = name
        liveRoom.category = interests

        liveRoomRepo.save(liveRoom.toParseObject(), object : SaveRoomCallback {
            override fun onFinish(isSuccessful: Boolean) {
                if (!isSuccessful) {
                    callback.onFinish(false)
                    return
                }

                liveRoomRepo.getRooms().ioToMain().subscribe(
                    { roomInterestPair ->
                        roomList = ArrayList(roomInterestPair.first)
                        callback.onFinish(roomInterestPair.first.isNotEmpty())
                    },
                    { e ->
                        log("saveRoom -> could not get the rooms due to ${e.message}")
                    }
                ).addTo(disposeBag)

            }
        })
    }

    fun addMember() {
        if (context.getRole() == ROLE_RECRUITER) {
            addRecruiter()
        }

        if (context.getRole() == ROLE_JOB_SEEKER) {
            addJobSeeker()
        }
    }

    private fun addRecruiter() {
        val query = ParseQuery.getQuery<ParseObject>("Recruiter")
        query.whereEqualTo("recruiterId", context.getUserId()).include("company")
        recruiter = recruiter ?: query.find().first()
        recruiter?.put("isNetworkingMuted", false)
        recruiter?.put("isNetworkingHandRaised", false)
        recruiter?.save()

        val recruiterRelation = selectedRoom?.getRelation<ParseObject>(NODE_RECRUITER)
        recruiterRelation?.add(recruiter!!)
        selectedRoom?.save()
    }

    private fun addJobSeeker() {
        val query = ParseQuery.getQuery<ParseObject>("JobSeeker")
        query.whereEqualTo("jobSeekerId", context.getUserId())
        jobSeeker = jobSeeker ?: query.find().first()
        jobSeeker?.put("isNetworkingMuted", false)
        jobSeeker?.put("isNetworkingHandRaised", false)
        jobSeeker?.save()

        val jobSeekerRelation = selectedRoom?.getRelation<ParseObject>(NODE_JOB_SEEKER)
        jobSeekerRelation?.add(jobSeeker!!)
        selectedRoom?.save()
    }

    fun removeMember() {
        doAsync {
            if (context.getRole() == ROLE_RECRUITER) {
                removeRecruiter()
            }

            if (context.getRole() == ROLE_JOB_SEEKER) {
                removeJobSeeker()
            }
            sendRefreshRoomNotification(LiveRoom(selectedRoom!!).roomId)
        }
    }

    private fun removeRecruiter() {
        val query = ParseQuery.getQuery<ParseObject>("Recruiter")
        query.whereEqualTo("recruiterId", context.getUserId()).include("company")
        recruiter = recruiter ?: query.find().first()

        val recruiterRelation = selectedRoom?.getRelation<ParseObject>(NODE_RECRUITER)
        recruiterRelation?.remove(recruiter!!)
        selectedRoom?.saveInBackground()
    }

    private fun removeJobSeeker() {
        val query = ParseQuery.getQuery<ParseObject>("JobSeeker")
        query.whereEqualTo("jobSeekerId", context.getUserId())
        jobSeeker = jobSeeker ?: query.find().first()

        val jobSeekerRelation = selectedRoom?.getRelation<ParseObject>(NODE_JOB_SEEKER)
        jobSeekerRelation?.remove(jobSeeker!!)
        selectedRoom?.saveInBackground()
    }

    fun initRoom() {
        doAsync {
            addMember()
            uiThread {
                sendRefreshRoomNotification(LiveRoom(selectedRoom!!).roomId)
                loadRoom()
            }
        }
    }

    fun muteAudio(muted: Boolean) {
        if (recruiter != null) {
            recruiter!!.put("isNetworkingMuted", muted)
            recruiter!!.save()
        }
        if (jobSeeker != null) {
            jobSeeker!!.put("isNetworkingMuted", muted)
            jobSeeker!!.save()
        }
        sendRefreshRoomNotification(LiveRoom(selectedRoom!!).roomId)
        loadRoom()
    }

    fun raiseHand(handRaised: Boolean) {
        if (recruiter != null) {
            recruiter!!.put("isNetworkingHandRaised", handRaised)
            recruiter!!.save()
        }
        if (jobSeeker != null) {
            jobSeeker!!.put("isNetworkingHandRaised", handRaised)
            jobSeeker!!.save()
        }
        sendRefreshRoomNotification(LiveRoom(selectedRoom!!).roomId)
        loadRoom()
    }

    fun loadRoom() {
        viewModelScope.launch {
            val query = ParseQuery.getQuery<ParseObject>("LiveRoom")
            query.whereEqualTo("roomId", LiveRoom(selectedRoom!!).roomId)
            val jobSeekerQuery = selectedRoom!!.getRelation<ParseObject>(NODE_JOB_SEEKER)
            val jobSeekers = jobSeekerQuery.query.find().map { Member(JobSeeker(it)) }

            val recruiterQuery = selectedRoom!!.getRelation<ParseObject>(NODE_RECRUITER).query
            recruiterQuery.include("company")
            val recruiters = recruiterQuery.find().map { Member(Recruiter(it), it) }

            members = arrayListOf()
            members.addAll(jobSeekers)
            members.addAll(recruiters)

            log("loadRoom -> memebers are $members")

            _membersLiveData.value = members
        }
    }

    fun sendRefreshRoomNotification(roomId: String) {
        val topic = "/topics/$roomId" //topic has to match what the receiver subscribed to

        val notification = JSONObject()
        val notificationBody = JSONObject()

        try {
            notificationBody.put("title", "refresh")
            notificationBody.put("message", context.getUserId())   //Enter your notification message
            notificationBody.put("roomId", roomId)   //Enter your notification message
            notification.put("to", topic)
            notification.put("data", notificationBody)
            log("try")
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

    fun loadInterests(callback: GetInterestsCallback) {
        liveRoomRepo.loadInterests().ioToMain().subscribe({ list ->
            callback.onFinish(list)
        }, { e ->
            log("could not load the interests due to ${e.message}")
            callback.onFinish(listOf())
        }).addTo(disposeBag)
    }

    fun saveSelectedInterests(names: ArrayList<String>, callback: SaveInterestsCallback) {
        liveRoomRepo.saveSelectedInterests(names, callback)
    }

    fun addEvent(event: Event) {
        liveRoomRepo
            .addEvent(event)
            .ioToMain()
            .subscribe(
                { isSuccessful ->
                    _eventSuccessListener.value = isSuccessful
                },
                { t ->
                    t.printStackTrace()
                    _eventSuccessListener.value = false
                }
            )
            .addTo(disposeBag)
    }

    fun getSelectedDateEvents(date: Date) {
        liveRoomRepo.getSelectedDateEvents(date, selectedRoom)
            .ioToMain()
            .subscribe(
                { eventList ->
                    _todayEvents.value = eventList
                },
                { t ->
                    _todayEvents.value = listOf()
                    t.printStackTrace()
                }
            )
            .addTo(disposeBag)
    }

    fun getUpcomingEvents(date: Date) {
        liveRoomRepo
            .getUpcomingEvents(date, selectedRoom)
            .ioToMain()
            .subscribe(
                { eventList ->
                    _upcomingEvents.value = eventList
                }, { t ->
                    _upcomingEvents.value = listOf()
                    t.printStackTrace()
                }
            )
            .addTo(disposeBag)
    }

    fun isLinkedInSaved(): Boolean {
        return liveRoomRepo.isLinkedInSaved(context.getRole() == ROLE_RECRUITER)
    }

    fun saveLinkedIn(username: String) {
        liveRoomRepo.saveLinkedIn(context.getRole() == ROLE_RECRUITER, username)
    }

    fun sendInvite(email: String) {
        val userId = liveRoomRepo.getUserIdFromEmail(email)

        if (userId.isNullOrEmpty())
            return

        val sender = context.getUserFullName()
        val receiverId = "/topics/$userId"

        val data = NotificationData(
            title = context.getString(R.string.app_name),
            message = "$sender invited you to join ${selectedRoom?.getString("name")} !",
            type = "networking_invite",
            receiverObjectId = ParseUser.getCurrentUser().objectId,
            receiverObjectName = email
        )
        val pushData = PushNotification(data, receiverId)


        val fcmRepo = FCMRepo(context)
        fcmRepo.postCloudNotification(pushData, object : FCMCallback {
            override fun onResult(status: Boolean, message: String) {
                log("${this::class.java.simpleName} onResult: $status -> $message")
            }

        })
    }
}