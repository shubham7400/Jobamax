package com.findajob.jobamax.dashboard.messages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.data.pojo.CurrentOnline
import com.findajob.jobamax.data.pojo.Message
import com.findajob.jobamax.data.pojo.NewPeople
import com.findajob.jobamax.extensions.ioToMain
import com.findajob.jobamax.repo.GetAllJobOfferCallback
import com.findajob.jobamax.repo.MessageRepository
import com.findajob.jobamax.util.log
import com.parse.ParseObject
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxkotlin.addTo
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MessagesViewModel @Inject constructor(
    private val repo: MessageRepository
) : BaseViewModel() {

    var isArchivePossible = true
    private var _archiveCurrentCount = 0
    private val _archiveLimit = 5

    fun increaseCurrentCount() = viewModelScope.launch(IO) {
        _archiveCurrentCount++

        if (_archiveCurrentCount > _archiveLimit) isArchivePossible = false
    }

    fun refillArchiveCount() = viewModelScope.launch(IO) {
        _archiveCurrentCount = 0
        isArchivePossible = true
    }


    private val _matchedUsers = MutableLiveData<List<CurrentOnline>>()
    val matchedUsers: LiveData<List<CurrentOnline>> = _matchedUsers

    private val _sourcedUsers = MutableLiveData<List<CurrentOnline>>()
    val sourcedUsers: LiveData<List<CurrentOnline>> = _sourcedUsers

    private val _newUsers = MutableLiveData<List<NewPeople>>()
    val newUsers: LiveData<List<NewPeople>> = _newUsers

    var allJobOffers = listOf<ParseObject>()
    var jobOfferFilters = listOf<ParseObject>()
    private val allJobOffersLiveData = MutableLiveData<List<ParseObject>>()

    private val _jobSeekerMessages = MutableLiveData<List<Message>>()
    private val _networkingMessages = MutableLiveData<List<Message>>()
    private val _archivedMessages = MutableLiveData<List<Message>>()
    val jobSeekerMessages: LiveData<List<Message>> = _jobSeekerMessages
    val networkingMessages: LiveData<List<Message>> = _networkingMessages
    val archivedMessages: LiveData<List<Message>> = _archivedMessages

    lateinit var currentUserId: String


    init {
        getCurrentUserId()
        getMessages(MessageType.JOB)
    }

    private fun getCurrentUserId() {
        currentUserId = repo.currentUserId
    }

    fun getMatchedUsers(roleType: String) {
        repo.getMatchedUsers(roleType)
            .ioToMain()
            .subscribe({
                _matchedUsers.value = it
            }, {
                it.printStackTrace()
            }).addTo(disposeBag)
    }

    fun getSourcedUsers(roleType: String) {
        repo.getSourcedUsers(roleType)
            .ioToMain()
            .subscribe({
                _sourcedUsers.value = it
            }, {
                it.printStackTrace()
            }).addTo(disposeBag)
    }


    fun getNewUsers(roleType: Int) {
        repo.getNewMatchedUsers(roleType)
            .ioToMain()
            .subscribe({ newPeopleList ->
                _newUsers.value = newPeopleList
            }, {
                it.printStackTrace()
            }).addTo(disposeBag)
    }

    fun loadJobOffers(recruiterId: String, callback: MessageRepository.GetOffersCallback) {
        repo.getRecruiterOffers(recruiterId, object : GetAllJobOfferCallback {
            override fun onFinish(parseObjects: List<ParseObject>) {
                allJobOffers = parseObjects
                callback.onFinish()
            }
        })
    }

    fun getFilteredOfferMessages(offer: ParseObject) {
        repo.getFilteredOfferMessages(offer)
            .ioToMain()
            .subscribe({
                _jobSeekerMessages.value = it
            }, {
                it.printStackTrace()
            }).addTo(disposeBag)
    }

    fun getFilteredOfferMatches(offer: ParseObject) {
        repo.getFilteredOfferMatches(offer)
            .ioToMain()
            .subscribe({
                _newUsers.value = it
            }, {
                it.printStackTrace()
            }).addTo(disposeBag)
    }


    fun getMessages(type: MessageType) {

        log("the message type is ${type.param}")

        repo.getMessages(type.param)
            .ioToMain()
            .subscribe({
                when (type.param) {
                    MessageType.JOB.param -> {
                        log("messages are -> $it")
                        _jobSeekerMessages.value = it
                    }
                    MessageType.NETWORKING.param -> {
                        log("networking messages are -> $it")
                        _networkingMessages.value = it
                    }
                    else -> {
                        log("archived messages are -> $it")
                        _archivedMessages.value = it
                    }
                }
            }, {
                it.printStackTrace()
            }).addTo(disposeBag)
    }


    fun deleteChat(receiverId: String) = viewModelScope.launch(IO) {
        repo.deleteChat(receiverId)
    }

    fun deleteMessage(message: Message) = viewModelScope.launch {
        repo.deleteMessage(message)
    }

    fun unmatchUser(roleType: String, receiverId: String) = viewModelScope.launch(IO) {
        repo.unmatchUser(roleType, receiverId)
    }


    fun makeMessageSeen(message: Message) = viewModelScope.launch(IO) {
        repo.makeMessageSeen(message)
    }


    fun shortListAUser(message: Message) = viewModelScope.launch(IO) {
        repo.shortListAMessage(message)
    }

    fun removeFromShortlist(message: Message) = viewModelScope.launch(IO) {
        repo.removeFromShortlist(message)
    }

    fun unarchiveConversation(message: Message) = viewModelScope.launch(IO) {
        repo.unarchiveConversation(message)
    }
}


enum class MessageType(val param: String) {
    JOB("isJob"),
    NETWORKING("isNetworking"),
    ARCHIVING("isArchived")
}