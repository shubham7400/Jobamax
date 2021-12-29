package com.findajob.jobamax.dashboard.messages

import android.app.Application
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.data.pojo.Chat
import com.findajob.jobamax.extensions.configureInterceptorWithEmpty
import com.findajob.jobamax.extensions.ioToMain
import com.findajob.jobamax.model.User
import com.findajob.jobamax.model.fcm.PushNotification
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.repo.FCMCallback
import com.findajob.jobamax.repo.FCMRepo
import com.findajob.jobamax.repo.MessageRepository
import com.findajob.jobamax.util.*
import com.parse.ParseObject
import com.parse.ParseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject
import timber.log.Timber
import java.util.*
import javax.inject.Inject


@HiltViewModel
class ChatViewModel @Inject constructor(
    val context: Application,
    private val repo: MessageRepository
) : BaseViewModel() {

    val selectImage = MutableLiveData<Boolean>()

    val selectFiles = MutableLiveData<Boolean>()

    val currentUsedId: String by lazy {
        repo.currentUserId
    }

    val currentUserEmail: String by lazy {
        repo.currentUserEmail
    }

    private val _currentUserObservable = MutableLiveData<ParseObject>()
    val currentUserObservable: LiveData<ParseObject> = _currentUserObservable

    fun getCurrentUser() {
        repo.getCurrentUser().ioToMain().subscribe(
            { cpo ->
                _currentUserObservable.value = cpo
            },
            { e ->
                log("getCurrentUser: could not get the current user", e)
            },
        ).addTo(disposeBag)
    }

    fun getCurrentUserInstant(): ParseObject? {
        return repo.currentUser
    }


    fun getReceiverUserInstant(receiverObjectId: String): ParseObject {
        return repo.getUserById(receiverObjectId) ?: ParseObject.createWithoutData(
            User.CLASS_NAME,
            receiverObjectId
        )
    }

    private val _receiverUserObservable = MutableLiveData<ParseObject>()
    val receiverUserObservable: LiveData<ParseObject> = _receiverUserObservable

    fun getRecieverUser(receiverObjectId: String) {
        repo.getUserByIdInBackground(receiverObjectId).ioToMain().subscribe(
            { cpo ->
                _receiverUserObservable.value = cpo
            },
            { e ->
                log("getCurrentUser: could not get the current user", e)
            },
        ).addTo(disposeBag)
    }


    val inputTemplate = MutableLiveData<String>()

    private val fcmRepo = FCMRepo(context)


    private val receiverObjId = MutableLiveData<String>()

    private val _form = CustomLiveData<ChatForm>()
    val form: MutableLiveData<ChatForm> = _form

    private val _chat = MutableLiveData<List<Chat>>()
    val chat: LiveData<List<Chat>> = _chat
    var isChatEmpty = true
    var chatSource = CHAT_IS_JOB
    var uniqueMessageId = ""

    var threadStatus = MutableLiveData<Boolean>()

    private val autoCompletePublishSubjectMessage = PublishSubject.create<String>()


    init {

        selectImage.value = false
        selectFiles.value = false

        form.value = ChatForm()

        autoCompletePublishSubjectMessage.configureInterceptorWithEmpty(0)
            .subscribe { result -> filteredMessage(result) }.addTo(disposeBag)

    }

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    fun getName(roleType: String, userId: String) {
        _name.value = "Loading..."
        repo.getName(roleType, userId)
            .ioToMain()
            .subscribe(
                {
                    _name.value = it
                }, {
                    it.printStackTrace()
                }
            )
            .addTo(disposeBag)
    }

    fun onMessageChange(text: CharSequence) {
        autoCompletePublishSubjectMessage.onNext(text.toString())
    }

    private fun filteredMessage(value: String) {
        form.value?.apply {
            message.set(value)
            messageValid = value.isNotEmpty()
            if (messageValid) {
                showTemplate = View.GONE
            } else if (_chat.value?.isEmpty()!! && isChatEmpty) {
                showTemplate = View.VISIBLE
            }
        }
    }


    private val _checkIfJobSeeker = MutableLiveData<Boolean>()
    val checkIfJobSeeker = _checkIfJobSeeker

    fun isAJobSeeker(userId: String) {
        repo.isAJobSeeker(userId)
            .ioToMain()
            .subscribe({ isJobSeeker ->
                checkIfJobSeeker.value = isJobSeeker
            }, { t ->
                log("Could not determine $t")
            })
            .addTo(disposeBag)
    }

    fun getChat(receiverObjectId: String) {
        repo.getChats(receiverObjectId)
            .ioToMain()
            .subscribe({

                // looks for every message
                // and checks if it is already seen or ot
                // if it is seen already, don't touch it,
                // to reduce call to the server
                // else, make the message seen
                // as all message that has been loaded here
                // have been seen by the receiver
                it.first.forEach { chat ->
                    if (!chat.seen) {
                        toggleSeen(chat)
                    }
                }

                _chat.value = it.first!!
                threadStatus.value = it.second!!

                if (_chat.value == null || _chat.value!!.isEmpty()) {
                    form.value!!.showTemplate = View.VISIBLE
                } else {
                    form.value!!.showTemplate = View.GONE
                }
            },
                {
                    _chat.value = listOf()
                    it.printStackTrace()
                })
            .addTo(disposeBag)
    }

    // toggles the seen ticker when the receiver sees the message
    // as it first looks for if the message is sent or received
    // if it is received it toggles the seen ticker, and
    // shows the ticker in the opposite side
    private fun toggleSeen(chat: Chat) {
        viewModelScope.launch(Dispatchers.IO) {
            if (chat.senderId.objectId != ParseUser.getCurrentUser().objectId) { // that means message i recieved
                repo.toggleSeen(chat)
            }
        }

    }

    fun setAsSource(receiverObjectId: String, jobOfferId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.setMessageAsSource(receiverObjectId, jobOfferId)
        }
    }


//    private val _selectedMessage = MutableLiveData<Message>()
//    val selectedMessage: LiveData<Message> = _selectedMessage
//
//    private val _requirements = MutableLiveData<List<String>>()
//    val requirements = _requirements
//
//    private val _checkedRequirements = MutableLiveData<List<String>>()
//    val checkedRequirements = _checkedRequirements
//
//    fun getMessage(messageObjectId: String) {
//        repo.getMessage(messageObjectId)
//            .ioToMain()
//            .subscribe(
//                {
//                    _requirements.value = it.requirements
//                    _checkedRequirements.value = it.checkedRequirements
//                    _selectedMessage.postValue(it)
//                },
//                { e ->
//                    log("Could not retrieve the message ${e.localizedMessage}")
//                },
//            )
//            .addTo(disposeBag)
//    }
//
//    fun submitCheckedRequirements(checkedRequirements: List<String>) {
//        _checkedRequirements.value = checkedRequirements
//        repo.submitCheckedList(_selectedMessage.value, _checkedRequirements.value ?: emptyList())
//    }

    fun sendMessage() {
        _form.value?.let { chatData ->
            repo.sendMessage(Triple(chatData, threadStatus.value, receiverObjId.value), chatSource)
                .ioToMain()
                .subscribe({
                    threadStatus.value = it
                }, {
                    it.printStackTrace()
                }).addTo(disposeBag)
        }
    }

    fun sendImage(url: String) {
        _form.value?.let { chatData ->
            repo.sendImage(
                Triple(url/*chatData*/, threadStatus.value, receiverObjId.value),
                chatSource
            )
                .ioToMain()
                .subscribe({
                    threadStatus.value = it
                    _form.value?.showTemplate = View.GONE
                }, {
                    it.printStackTrace()
                }).addTo(disposeBag)
        }
    }

    fun setSelectImage(value: Boolean) {
        selectImage.value = value
    }

    fun setSelectFiles(value: Boolean) {
        selectFiles.value = value
    }

    fun setInputTemplate(index: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val templateText = when (index) {
                0 -> "Hello! Nice to meet you!"
                1 -> "When are you free for a call?"
                2 -> "Good day! How are you doing?"
                else -> "Hi"
            }
            inputTemplate.postValue(templateText)
        }
    }

    fun setReceiverId(value: String) {
        receiverObjId.value = value
    }

    fun sendPushNotificationByUserId(requestData: PushNotification) {
//        viewModelScope.launch(Dispatchers.IO) {
        fcmRepo.postCloudNotification(requestData, object : FCMCallback {
            override fun onResult(status: Boolean, message: String) {
                Timber.d(" sent notification by user id, status -> $status")
            }
        })
//        }
    }

    fun saveRequirements(receiverObjectId: String, arrRequirements: ArrayList<String>) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.saveRequirements(receiverObjectId, arrRequirements)
        }
    }

    fun getRequirements(
        receiverObjectId: String,
        callback: MessageRepository.GetRequirementsCallback
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getRequirements(receiverObjectId, callback)
        }
    }

    fun sendRequirementsNotification(uniqueId: String, requirements: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val topic = "/topics/$uniqueId" //topic has to match what the receiver subscribed to

            val notification = JSONObject()
            val notificationBody = JSONObject()

            try {
                notificationBody.put("title", ARG_CHAT_REQUIREMENTS)
                notificationBody.put(
                    "message",
                    context.getUserId()
                )   //Enter your notification message
                notificationBody.put(
                    "requirements",
                    requirements
                )   //Enter your notification message
                notification.put("to", topic)
                notification.put("data", notificationBody)
                log("try")
            } catch (e: JSONException) {
                log("onCreate: " + e.message)
            }

            sendNotification(notification)
        }
    }

    private val requestQueue: RequestQueue by lazy { Volley.newRequestQueue(context) }

    private fun sendNotification(notification: JSONObject) {
//        viewModelScope.launch(Dispatchers.IO) {
        log("sendNotification")
        val serverKey = "key=$FCM_SERVER_KEY"
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
//        }
    }

    val currentUserProfilePicUrl: String by lazy {
        repo.getCurrentUsersProfilePicUrl()
    }

    fun setUniqueMessageId(currentUsedId: String, receiverId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val userList = arrayOf(currentUsedId, receiverId)
            userList.sort()
            uniqueMessageId = userList[0] + userList[1]
        }
    }

}