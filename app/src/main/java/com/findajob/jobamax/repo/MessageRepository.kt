package com.findajob.jobamax.repo

import android.content.Context
import com.findajob.jobamax.dashboard.messages.ChatForm
import com.findajob.jobamax.dashboard.messages.MessageType
import com.findajob.jobamax.data.pojo.Chat
import com.findajob.jobamax.data.pojo.CurrentOnline
import com.findajob.jobamax.data.pojo.Message
import com.findajob.jobamax.data.pojo.Message.Companion.SHORT_LISTED_BY
import com.findajob.jobamax.data.pojo.NewPeople
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.model.*
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.*
import com.parse.ParseACL
import com.parse.ParseObject
import com.parse.ParseObject.createWithoutData
import com.parse.ParseQuery
import com.parse.ParseUser
import io.reactivex.Single
import javax.inject.Inject


class MessageRepository @Inject constructor(val context: Context) {
    var jobSeeker: JobSeeker? = null
    var currentUser: ParseObject? = null

    init {
        getUser{
            jobSeeker = it
        }
    }

    private fun getUser(listen: (JobSeeker) -> Unit) {
         val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
        query.whereEqualTo(ParseTableFields.jobSeekerId.toString(), context.getUserId())
        query.getFirstInBackground { result, e ->
            if (result != null){
                currentUser = result
                listen(JobSeeker(result))
            }
        }
    }

    /*private val parseCurrentUser: ParseUser by lazy {
        ParseUser.getCurrentUser()
    }*/

    // so that the current user id is queried only once,
    // not every time, wasting resources and taking time
    val currentUserId: String by lazy {
        jobSeeker!!.jobSeekerId
    }

    val currentUserEmail: String by lazy {
        jobSeeker!!.email
    }

   /* val currentUser: ParseObject by lazy {
        getUserById(currentUserId) ?: createWithoutData(User.CLASS_NAME, currentUserId)
    }*/

    fun getCurrentUser() = Single.create<ParseObject> { emitter ->
        try {
            val currentUser = getUserById(currentUserId) ?: createWithoutData(User.CLASS_NAME, currentUserId)
            emitter.onSuccess(currentUser)
        } catch (e: Exception) {
            emitter.onError(e)
        }

    }

    private val _userQuery: ParseQuery<ParseObject> by lazy {
        ParseQuery.getQuery(User.CLASS_NAME)
    }

    private val _parseRecruiterQuery: ParseQuery<ParseObject> by lazy {
        ParseQuery.getQuery(Recruiter.CLASS_NAME)
    }

    private val _parseJobSeekerQuery = ParseQuery.getQuery<ParseObject>(JobSeeker.CLASS_NAME)


    suspend fun setMessageAsSource(receiverObjectId: String, jobOfferId: String) {
        try {
            val parseSender = ParseQuery.getQuery(Message::class.java)
                .whereEqualTo(
                    CHAT_SENDER_ID, currentUser
                )


            val receiver = getUserById(receiverObjectId)

            val parseReceiver = ParseQuery.getQuery(Message::class.java)
                .whereEqualTo(
                    CHAT_RECEIVER_ID, receiver
                )

            val messageParseQuery =
                ParseQuery.or(listOf<ParseQuery<Message>>(parseSender, parseReceiver))
                    .orderByDescending(SORTING_CREATED_AT)

            val messageList = messageParseQuery.find()

            val message = messageList[0]

            message.isSource = true

            if (jobOfferId.trim().isNotEmpty()) {
                message.put("jobId", jobOfferId)
            }

            message.save()
        } catch (e: Exception) {
            log("The message could not be set as source", e)
        }
    }


    /**
     * Gets the chat lists based on the user id
     *
     * @return a pair of list of [Chat] and a [Boolean] denoting if the chat is empty or not
     */
    fun getChats(receiverObjectId: String) = Single.create<Pair<List<Chat>, Boolean>> { emitter ->

        try {

            val receiver = getUserById(receiverObjectId)


            val parseSenderQuery = ParseQuery.getQuery(Chat::class.java)
                .whereEqualTo(
                    CHAT_SENDER_ID,
                    currentUser
                )
                .whereEqualTo(
                    CHAT_RECEIVER_ID,
                    receiver
                )


            val parseReceiverQuery = ParseQuery.getQuery(Chat::class.java)
                .whereEqualTo(
                    CHAT_RECEIVER_ID,
                    currentUser
                )
                .whereEqualTo(CHAT_SENDER_ID, receiver)

            val chatQuery = ParseQuery.or(
                listOf<ParseQuery<Chat>>(
                    parseSenderQuery,
                    parseReceiverQuery,
                )
            ).orderByDescending(SORTING_CREATED_AT)

            val chatList = chatQuery.find()

            if (chatList != null) {
                emitter.onSuccess(Pair(chatList, chatList.isNotEmpty()))
            } else {
                emitter.onError(ParseQueryEmptyThrowable())
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }

    }

    /**
     * Deletes the chats and all the messages from both user side
     *
     * @param receiverObjectId which is a [String]
     */
    suspend fun deleteChat(receiverObjectId: String) {


        val receiver = getUserById(receiverObjectId)

        val parseSender = ParseQuery.getQuery(Chat::class.java)
            .whereEqualTo(
                CHAT_SENDER_ID, currentUser
            )
            .whereEqualTo(
                CHAT_RECEIVER_ID,
                receiver
            )

        val parseReceiver = ParseQuery.getQuery(Chat::class.java)
            .whereEqualTo(
                CHAT_RECEIVER_ID, currentUser
            )
            .whereEqualTo(CHAT_SENDER_ID, receiver)


        val messageQuery = ParseQuery.or(
            listOf<ParseQuery<Chat>>(
                parseSender,
                parseReceiver
            )
        )

        val messageData = messageQuery.find()

        ParseObject.deleteAll(messageData)
    }

    suspend fun deleteMessage(message: Message) {
        message.delete()
    }

    fun getCurrentUsersProfilePicUrl(): String {
        return currentUser?.getString("profilePicUrl") ?: ""
    }


    /**
     * This function takes the user id, and returns Recruiter Parse Object
     *
     * @param userId as String
     *
     * @return Recruiter [ParseObject]
     */
    private fun getRecruiterById(userId: String): ParseObject? {
        return try {
            val parseRecruiterQuery = _parseRecruiterQuery
            parseRecruiterQuery.whereEqualTo("userId", userId)

            val foundRecruiterList = parseRecruiterQuery.find()
            foundRecruiterList[0]
        } catch (e: Exception) {
            null
        }
    }

    /**
     * This function takes the user id, and returns JobSeeker Parse Object
     *
     * @param userId as String
     *
     * @return JobSeeker [ParseObject]
     */
    private fun getJobSeekerById(userId: String): ParseObject? {
        return try {
            val parseJobSeekerQuery = _parseJobSeekerQuery
            parseJobSeekerQuery.whereEqualTo("userId", userId)
            val foundJobSeekerList = parseJobSeekerQuery.find()
            foundJobSeekerList[0]
        } catch (e: Exception) {
            null
        }
    }

    /**
     * This function takes the user id, and returns an User Parse Object
     *
     * @param userId as String
     *
     * @return _User [ParseObject]
     */
    fun getUserById(userId: String): ParseObject? = try {
        val receiverParseQuery = _userQuery

        receiverParseQuery.whereEqualTo(ParseTableFields.jobSeekerId.toString(), userId)

        val foundReceiverList = receiverParseQuery.find()

        foundReceiverList[0]
    } catch (e: Exception) {
        log("could not get the user due to ${e.message}")
        null
    }

    fun getUserByIdInBackground(userId: String) = Single.create<ParseObject> { emitter ->
        try {
            lateinit var user: ParseObject
            val receiverParseQuery = _userQuery

            receiverParseQuery.whereEqualTo("objectId", userId)

            val foundReceiverList = receiverParseQuery.find()

            if (foundReceiverList.isNotEmpty()) {
                user = foundReceiverList[0]
            }

            user = createWithoutData(User.CLASS_NAME, userId)


            emitter.onSuccess(user)
        } catch (e: Exception) {
            log("could not get the user due to ${e.message}", e)
            emitter.onError(e)
        }
    }

    private fun getRecruiterByRecruiterId(recruiterId: String): ParseObject? = try {
        val receiverParseQueryOne = ParseQuery.getQuery<ParseObject>(Recruiter.CLASS_NAME)
        receiverParseQueryOne.whereEqualTo("recruiterId", recruiterId)

        val receiverParseQueryTwo = ParseQuery.getQuery<ParseObject>(Recruiter.CLASS_NAME)
        receiverParseQueryTwo.whereEqualTo("userId", recruiterId)

        val foundReceiverList =
            ParseQuery.or(listOf(receiverParseQueryOne, receiverParseQueryTwo)).find()

        foundReceiverList[0]
    } catch (e: Exception) {
        log("could not get the user due to ${e.message}")
        null
    }


    /**
     * Creates an one-to-one relation with the key RELATION_KEY_MATCHED
     *
     * @param firstUser, a ParseObject
     * @param secondUser, a ParseObject
     */
    private fun createRelation(key: String, firstUser: ParseObject, secondUser: ParseObject) {
        try {
            val relation = firstUser.getRelation<ParseObject>(key)
            relation.add(secondUser)

            firstUser.save()
        } catch (e: Exception) {
            log("could not make the $key relation due to ${e.message}")
        }
    }

    /**
     * Matches the current user with the one specified
     *
     * @param receiverObjectId as [String] of the person the current user going to be matched
     * with
     * @param roleType as [String] of the current user, if he is a [Recruiter] or a [JobSeeker]
     */
    suspend fun matchUser(roleType: String, receiverObjectId: String) {

        val mainUser: ParseObject? = if (roleType == ROLE_RECRUITER) {
            getRecruiterById(currentUserId)
        } else {
            getJobSeekerById(currentUserId)
        }

        val secondUser: ParseObject? = getRecruiterByRecruiterId(receiverObjectId)

        if (secondUser != null && mainUser != null) {
            createRelation(RELATION_KEY_MATCHED, mainUser, secondUser)
            createRelation(RELATION_KEY_MATCHED, secondUser, mainUser)
        } else {
            log("an error has occurred, as mainUser -> $mainUser for $currentUserId, secondUser -> $secondUser for $receiverObjectId")
        }

    }

    /**
     * Removes the one-to-one relation with the key RELATION_KEY_MATCHED
     *
     * @param firstUser, a ParseObject
     * @param secondUser, a ParseObject
     */
    private fun removeMatchRelation(key: String, firstUser: ParseObject, secondUser: ParseObject) {
        val relation = firstUser.getRelation<ParseObject>(key)
        relation.remove(secondUser)

        firstUser.save()
    }

    /**
     * Removes the match of the current user with the one specified
     *
     * @param receiverObjectId as [String] of the person the current user going to cut the match
     * with
     * @param roleType as [String] of the current user, if he is a [Recruiter] or a [JobSeeker]
     */
    suspend fun unmatchUser(roleType: String, receiverObjectId: String) {
        val mainUser: ParseObject? = if (roleType == ROLE_RECRUITER) {
            getRecruiterById(currentUserId)
        } else {
            getJobSeekerById(currentUserId)
        }

        val secondUser: ParseObject? = if (roleType == ROLE_RECRUITER) {
            getJobSeekerById(receiverObjectId)
        } else {
            getRecruiterById(receiverObjectId)
        }

        if (mainUser != null && secondUser != null) {
            removeMatchRelation(RELATION_KEY_MATCHED, mainUser, secondUser)
            removeMatchRelation(RELATION_KEY_MATCHED, secondUser, mainUser)
        }
    }

    private fun getRelatedDatabaseData(key: String, parseObject: ParseObject): List<ParseObject> {
        val relation = parseObject.getRelation<ParseObject>(key)
        return relation.query.find()
    }

    fun getMatchedUsers(roleType: String) = Single.create<List<CurrentOnline>> { emitter ->

        try {
            val mainUser: ParseObject? = if (roleType == ROLE_RECRUITER) {
                getRecruiterById(currentUserId)
            } else {
                getJobSeekerById(currentUserId)
            }

            val matchedUserList = getRelatedDatabaseData(RELATION_KEY_MATCHED, mainUser!!)

            val currentOnlineList: List<CurrentOnline> = matchedUserList.map {
                var firstName = it.getString("firstName")
                var lastName = it.getString("lastName")


                if (firstName == null || firstName.trim().isEmpty()) {
                    val username = it.getString("email")
                    firstName = username
                    lastName = ""
                } else if (lastName == null) {
                    lastName = ""
                }

                CurrentOnline(
                    it.getString("userId") ?: "",
                    it.getString("profilePicUrl") ?: "",
                    firstName ?: it.getString("email") ?: "Unknown",
                    lastName.toString(),
                    RELATION_KEY_MATCHED,
                )

            }

            if (currentOnlineList.isNotEmpty()) {
                log("current online list -> $currentOnlineList")
                emitter.onSuccess(currentOnlineList)
            } else {
                emitter.onError(ParseQueryEmptyThrowable())
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }


    private suspend fun markMessageAsSource(message: Message) {
        try {
            message.isSource = findRelationSource(message.senderId, message.receiverId)
            log("Successfully set the message to be a source")
        } catch (e: Exception) {
            log("Could not set the message to be a source", e)
        }
    }

    private fun findRelationSource(firstUser: ParseObject, secondUser: ParseObject): Boolean {
//        return true
        try {
            val relation = firstUser.getRelation<ParseObject>(RELATION_KEY_SOURCED)

            return if (relation.query.find().contains(secondUser)) {
                log("There is a relation between ${firstUser.objectId} and ${secondUser.objectId}")
                true
            } else {
                val relationAgain = secondUser.getRelation<ParseObject>(RELATION_KEY_SOURCED)
                val isRelation = relationAgain.query.find().contains(firstUser)

                if (isRelation) log("There is a relation between ${secondUser.objectId} and ${firstUser.objectId}")
                else log("There was no match", ParseQueryEmptyThrowable())

                isRelation
            }
        } catch (e: Exception) {
            log("Could not find any match", e)
            return false
        }
    }


    suspend fun sourceUser(roleType: String, receiverObjectId: String) {
        val mainUser: ParseObject? = if (roleType == ROLE_RECRUITER) {
            getRecruiterById(currentUserId)
        } else {
            getJobSeekerById(currentUserId)
        }

        val secondUser: ParseObject? = if (roleType == ROLE_RECRUITER) {
            getJobSeekerById(receiverObjectId)
        } else {
            getRecruiterById(receiverObjectId)
        }

        if (mainUser != null && secondUser != null) {
            createRelation(RELATION_KEY_SOURCED, mainUser, secondUser)
            createRelation(RELATION_KEY_SOURCED, secondUser, mainUser)
        } else {
            log("could not make the relation as mainUser -> $mainUser and secondUser -> $secondUser")
        }
    }

    fun getSourcedUsers(roleType: String) = Single.create<List<CurrentOnline>> { emitter ->

        try {
            val mainUser: ParseObject? = if (roleType == ROLE_RECRUITER) {
                getRecruiterById(currentUserId)
            } else {
                getJobSeekerById(currentUserId)
            }

            val sourcedUserList = getRelatedDatabaseData(RELATION_KEY_SOURCED, mainUser!!)

            val currentOnlineList: List<CurrentOnline> = sourcedUserList.map {

                var firstName = it.getString("firstName")
                var lastName = it.getString("lastName")


                if (firstName == null || firstName.isNullOrEmpty()) {
                    val username = it.getString("username")
                    firstName = username
                    lastName = ""
                } else if (lastName == null) {
                    lastName = ""
                }

                CurrentOnline(
                    it.getString("userId") ?: "",

                    it.getString("profilePicUrl") ?: "",
                    firstName ?: it.getString("email") ?: "Unknown",
                    lastName.toString(),
                    RELATION_KEY_SOURCED,
                )
            }

            if (currentOnlineList.isNotEmpty()) {
                emitter.onSuccess(currentOnlineList)
            } else {
                emitter.onError(ParseQueryEmptyThrowable())
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }

    }

    private fun getNameProfileOfNewMatchedUsers(it: ParseObject): Triple<String?, String?, String?> {
        var firstName = it.getString("firstName")
        var lastName = it.getString("lastName")

        var photoUrl = ""

        it.getParseObject("company")?.fetchIfNeeded<ParseObject>()?.let { companyPo ->
            val company = Company(companyPo)
            firstName = company.name
            photoUrl = company.logoUrl
        }

        it.getParseObject(User.CLASS_NAME)?.let { user ->
            firstName = user.getString("firstName")
            lastName = user.getString("lastName")

            photoUrl = user.getString("profilePicUrl") ?: ""

            if (firstName == null || firstName.isNullOrEmpty()) {
                val username = user.getString("username")
                firstName = username
                lastName = ""
            } else if (lastName == null) {
                lastName = ""
            }
        }

        return Triple(firstName, lastName, photoUrl)

    }

    fun getNewMatchedUsers(roleType: String) = Single.create<List<NewPeople>> { emitter ->

        try {
            val mainUser: ParseObject? = if (roleType == ROLE_RECRUITER) {
                getRecruiterById(currentUserId)
            } else {
                getJobSeekerById(currentUserId)
            }

            val userList = arrayListOf<ParseObject>()
            val matchedUserList = getRelatedDatabaseData(RELATION_KEY_MATCHED, mainUser!!)
            val sourcedUserList = getRelatedDatabaseData(RELATION_KEY_SOURCED, mainUser!!)

            userList.addAll(matchedUserList)
            userList.addAll(sourcedUserList)

            val newPeopleList: List<NewPeople> = userList.map {

                val triple = getNameProfileOfNewMatchedUsers(it)

                val firstName = triple.first
                val lastName = triple.second

                val photoUrl = triple.third

                val user = getUserById(it.getString("userId") ?: "")

                val isActive = user?.getBoolean("isActive") ?: true

                val newPeople = NewPeople(
                    it.getString("userId") ?: "",
                    photoUrl ?: "",
                    firstName ?: it.getString("email") ?: "",
                    lastName ?: "",
                    isActive,
                )

                log("new people -> $newPeople")
                newPeople

            }

            if (newPeopleList.isNotEmpty()) {
                emitter.onSuccess(newPeopleList)
            } else {
                emitter.onError(ParseQueryEmptyThrowable())
            }
        } catch (e: Exception) {
            log("could not get the new people list -> ${e.message}")
            e.printStackTrace()
            emitter.onError(e)
        }

    }

    fun getName(roleType: String, receiverObjectId: String) =
        Single.create<String> { emitter ->

            var mainUser: ParseObject? = null
            var isReceiverRecruiter = false

            if (roleType == ROLE_RECRUITER) {
                mainUser = getJobSeekerById(receiverObjectId)

                if (mainUser == null) {
                    mainUser = getRecruiterById(receiverObjectId)
                    isReceiverRecruiter = true
                }
            } else {
                mainUser = getRecruiterById(receiverObjectId)
                isReceiverRecruiter = true

                if (mainUser == null) {
                    mainUser = getJobSeekerById(receiverObjectId)
                }
            }

            if (isReceiverRecruiter && mainUser != null) {

                val companyParseObject =
                    mainUser
                        .getParseObject(Company.CLASS_NAME)
                        ?.fetchIfNeeded<ParseObject>()

                if (companyParseObject != null) {
                    val company = Company(companyParseObject)
                    emitter.onSuccess(company.name)
                } else {
                    val recruiter = Recruiter(mainUser)

                    var lastName = recruiter.lastName

                    if (lastName.isNotEmpty()) {
                        lastName = lastName.substring(0, 1) + "."
                    }

                    emitter.onSuccess("${recruiter.firstName} $lastName")
                }


            } else if (mainUser != null) {

                val jobSeeker = JobSeeker(mainUser)

                var lastName = jobSeeker.lastName

                if (lastName.isNotEmpty()) {
                    lastName = lastName.substring(0, 1) + "."
                }

                var name = "${jobSeeker.firstName} $lastName"

                if (name.trim().isNotEmpty()) {
                    emitter.onSuccess(name)
                } else {
                    name = jobSeeker.email
                    emitter.onSuccess(name)
                }

            } else {
                emitter.onError(ParseQueryEmptyThrowable())
            }
        }


/*    fun sendMessage(chat: Chat) = Completable.create { final ->
        chat.saveInBackground { e ->
            if (e == null) {
                final.onComplete()
            } else {
                final.onError(e)
            }
        }
    }*/

/*  fun sendMessage(chat: Pair<Chat, Boolean?>) = Single.create<Boolean> { final ->

      chat.first.saveInBackground()

      if (chat.second == false) {

          val parseACL = ParseACL()
          parseACL.publicReadAccess = false
          parseACL.publicWriteAccess = false
          parseACL.setReadAccess(currentUserId, true)
          parseACL.setWriteAccess(currentUserId, true)
          parseACL.setWriteAccess(chat.first.receiverId.objectId, true)
          parseACL.setReadAccess(chat.first.receiverId.objectId, true)

          val msg = Message()
//            msg.message = createWithoutData("Chat", chat.first.toString())
          msg.message = chat.first
          msg.senderId = createWithoutData(User.CLASS_NAME, currentUserId)
          msg.receiverId = createWithoutData(User.CLASS_NAME, chat.first.receiverId.objectId)
          msg.acl = parseACL
          msg.saveInBackground()
          final.onSuccess(true)
      } else {
          val parseSender = ParseQuery.getQuery(Message::class.java)
              .whereEqualTo(
                  CHAT_SENDER_ID, createWithoutData(
                      User.CLASS_NAME,
                      currentUserId
                  )
              )

          val parseReceiver = ParseQuery.getQuery(Message::class.java)
              .whereEqualTo(
                  CHAT_RECEIVER_ID, createWithoutData(
                      User.CLASS_NAME,
                      currentUserId
                  )
              )

          ParseQuery.or(listOf<ParseQuery<Message>>(parseSender, parseReceiver))
              .orderByDescending(CREATED_AT)
              .findInBackground { data, e ->
                  if (data != null) {
                      if (data.size != 0) {
                          val result = data.filter { data ->
                              data.receiverId.objectId == chat.first.receiverId.objectId &&
                              data.senderId.objectId == currentUserId ||
                              data.senderId.objectId == chat.first.receiverId.objectId &&
                              data.receiverId.objectId == currentUserId
                          }
                          result[0].message = chat.first
                          result[0].saveInBackground()
                      }
                  }
              }
      }
  }*/

    /**
     * Toggles seen icon when the user sees the message
     */
    suspend fun toggleSeen(chat: Chat) {
        chat.seen = true
        chat.save()
    }


    fun sendMessage(chat: Triple<ChatForm, Boolean?, String?>, source: String) =
        Single.create<Boolean> { emitter ->

            val chatForm = chat.first
            val isMessageNotEmpty = chat.second
            val receiverObjectId = chat.third

            try {
                val chatToSend = Chat()

                chatToSend.apply {
                    message = chatForm.message.get().toString()

                    senderId = currentUser!!
                    receiverId = getUserById(chat.third!!)!!

                    // file = chat.first.file.get().toString()

                }

                chatToSend.save()

                if (isMessageNotEmpty == false) {

                    val parseACL = ParseACL()

                    parseACL.apply {

                        parseACL.publicReadAccess = false
                        parseACL.publicWriteAccess = false

                        parseACL.setReadAccess(currentUserId, true)
                        parseACL.setWriteAccess(currentUserId, true)

                        parseACL.setWriteAccess(chat.third, true)
                        parseACL.setReadAccess(chat.third, true)
                    }

                    val message = Message()

                    message.apply {
                        // message = createWithoutData("Chat", chat.first.toString())

                        this.message = chatToSend

                        senderId = currentUser!!
                        receiverId = getUserById(chat.third!!) ?: createWithoutData(
                            User.CLASS_NAME,
                            chat.third
                        )

//                        markMessageAsSource(message)

                        // file = chatToSend
                        acl = parseACL
                    }

                    message.put(source, true)

                    val currentSeenList = try {
                        message.seenBy as ArrayList
                    } catch (e: Exception) {
                        arrayListOf()
                    }
                    currentSeenList.add(currentUserId)
                    message.seenBy = currentSeenList

                    message.save()
                    emitter.onSuccess(true)

                } else {
                    val parseSender = ParseQuery.getQuery(Message::class.java)
                        .whereEqualTo(
                            CHAT_SENDER_ID, currentUser
                        )

                    val parseReceiver = ParseQuery.getQuery(Message::class.java)
                        .whereEqualTo(
                            CHAT_RECEIVER_ID, currentUser
                        )

                    val messageParseQuery =
                        ParseQuery.or(listOf<ParseQuery<Message>>(parseSender, parseReceiver))
                            .orderByDescending(SORTING_CREATED_AT)

                    val messageList = messageParseQuery.find().filter { message ->
                        message.receiverId.objectId == receiverObjectId &&
                                message.senderId.objectId == currentUserId ||
                                message.senderId.objectId == receiverObjectId &&
                                message.receiverId.objectId == currentUserId
                    }

                    val message = messageList[0]

                    message.message = chatToSend
                    val currentSeenList = try {
                        message.seenBy as ArrayList
                    } catch (e: Exception) {
                        arrayListOf()
                    }
                    currentSeenList.add(currentUserId)
                    message.seenBy = currentSeenList
//                    markMessageAsSource(message)

                    message.save()

                }
            } catch (e: Exception) {
                emitter.onSuccess(false)
            }
        }

    fun sendImage(chat: Triple<String/*ChatForm*/, Boolean?, String?>, source: String) =
        Single.create<Boolean> { emitter ->

            try {
                val chatToSend = Chat().apply {

                    // message = chat.first.message.get().toString()
                    senderId = getUserById(currentUserId) ?: createWithoutData(
                        User.CLASS_NAME,
                        currentUserId
                    )
                    receiverId =
                        getUserById(chat.third!!) ?: createWithoutData(User.CLASS_NAME, chat.third)

                    file = chat.first

                    /*chat.first.file.get().toString()*/
                }

                chatToSend.save()

                if (chat.second == false) {

                    val parseACL = ParseACL().apply {
                        publicReadAccess = false
                        publicWriteAccess = false

                        setReadAccess(currentUserId, true)
                        setWriteAccess(currentUserId, true)

                        setWriteAccess(chat.third, true)
                        setReadAccess(chat.third, true)
                    }

                    val message = Message().apply {

                        senderId = getUserById(currentUserId) ?: createWithoutData(
                            User.CLASS_NAME,
                            currentUserId
                        )
                        receiverId = getUserById(chat.third!!) ?: createWithoutData(
                            User.CLASS_NAME,
                            chat.third
                        )

                        file = chatToSend

                        val currentSeenList = seenBy as ArrayList
                        currentSeenList.add(currentUserId)
                        seenBy = currentSeenList


                        acl = parseACL
                    }

                    message.put(source, true)
                    message.save()

                    emitter.onSuccess(true)
                } else {

                    val user = getUserById(currentUserId)

                    val parseSender = ParseQuery.getQuery(Message::class.java)
                        .whereEqualTo(
                            CHAT_SENDER_ID, user
                        )

                    val parseReceiver = ParseQuery.getQuery(Message::class.java)
                        .whereEqualTo(
                            CHAT_RECEIVER_ID, user
                        )

                    val parseQuery =
                        ParseQuery.or(listOf<ParseQuery<Message>>(parseSender, parseReceiver))
                            .orderByDescending(SORTING_CREATED_AT)


                    val messageList = parseQuery.find().filter { message ->
                        message.receiverId.objectId == chat.third &&
                                message.senderId.objectId == currentUserId ||
                                message.senderId.objectId == chat.third &&
                                message.receiverId.objectId == currentUserId
                    }

                    val message = messageList[0]

                    message.apply {
                        file = chatToSend
                    }

                    val currentSeenList = try {
                        message.seenBy as ArrayList
                    } catch (e: Exception) {
                        arrayListOf()
                    }
                    currentSeenList.add(currentUserId)
                    message.seenBy = currentSeenList

                    message.save()

                }
            } catch (e: Exception) {
                emitter.onSuccess(false)
            }
        }


    fun getFilteredOfferMatches(offer: ParseObject) = Single.create<List<NewPeople>> { emitter ->

        try {
            val userList = arrayListOf<ParseObject>()

            val matchedOfferRelation =
                offer.getRelation<ParseObject>(RELATION_KEY_MATCHED).query.find()
            val sourcedOfferRelation =
                offer.getRelation<ParseObject>(RELATION_KEY_SOURCED).query.find()

            userList.addAll(matchedOfferRelation)
            userList.addAll(sourcedOfferRelation)

            val newPeopleList: List<NewPeople> = userList.map {

                val triple = getNameProfileOfNewMatchedUsers(it)

                val firstName = triple.first
                val lastName = triple.second

                val photoUrl = triple.third

                val user = getUserById(it.getString("userId") ?: "")

                val isActive = user?.getBoolean("isActive") ?: true

                val newPeople = NewPeople(
                    it.getString("userId") ?: "",
                    photoUrl ?: "",
                    firstName ?: it.getString("email") ?: "",
                    lastName ?: "",
                    isActive,
                )

                log("new people -> $newPeople")
                newPeople

            }

            emitter.onSuccess(newPeopleList)
        } catch (e: Exception) {
            log("could not get the new people list -> ${e.message}")
            e.printStackTrace()
            emitter.onError(e)
        }

    }

    fun getFilteredOfferMessages(offer: ParseObject) = Single.create<List<Message>> { emitter ->
        val matchedOfferRelation = offer.getRelation<ParseObject>(RELATION_KEY_MATCHED).query.find()
        val sourcedOfferRelation = offer.getRelation<ParseObject>(RELATION_KEY_SOURCED).query.find()
        val matchedJobSeekers = arrayListOf<String>()
        for (item in matchedOfferRelation) {
            item.getString("userId")?.let { matchedJobSeekers.add(it) }
        }
        for (item in sourcedOfferRelation) {
            item.getString("userId")?.let { matchedJobSeekers.add(it) }
        }

        val parseSender = ParseQuery.getQuery(Message::class.java)
            .whereEqualTo(
                CHAT_SENDER_ID, currentUser
            ).whereContainedIn(CHAT_RECEIVER_ID, matchedJobSeekers)

        val parseReceiver = ParseQuery.getQuery(Message::class.java)
            .whereEqualTo(
                CHAT_RECEIVER_ID, currentUser
            ).whereContainedIn(CHAT_SENDER_ID, matchedJobSeekers)


        val messageParseQuery =
            ParseQuery.or(listOf<ParseQuery<Message>>(parseSender, parseReceiver))
                .whereEqualTo(CHAT_IS_JOB, true)
                .include(CHAT_MESSAGE)
                .include(CHAT_RECEIVER_ID)
                .include(CHAT_SENDER_ID)
                .include(CHAT_FILE)
                .orderByDescending(SHORT_LISTED_BY)
                .orderByDescending(SORTING_UPDATED_AT)

        val messageList = messageParseQuery.find()

        if (messageList != null) {
            emitter.onSuccess(messageList)
        } else {
            emitter.onError(ParseQueryEmptyThrowable())
        }

    }

    fun getMessages(source: String, ) = Single.create<List<Message>> { emitter ->

        val parseSender = ParseQuery.getQuery(Message::class.java).whereEqualTo(CHAT_SENDER_ID, currentUser)

        val parseReceiver = ParseQuery.getQuery(Message::class.java).whereEqualTo(CHAT_RECEIVER_ID, currentUser)

        val messageParseQuery =
            ParseQuery.or(listOf<ParseQuery<Message>>(parseSender, parseReceiver))
                .whereEqualTo(source, true)
                .include(CHAT_MESSAGE)
                .include(CHAT_RECEIVER_ID)
                .include(CHAT_SENDER_ID)
                .include(CHAT_FILE)
                .orderByDescending(SHORT_LISTED_BY)
                .orderByDescending(SORTING_UPDATED_AT)

        // not including the archived message in the list
        if (source != MessageType.ARCHIVING.param) messageParseQuery.whereNotEqualTo(
            MessageType.ARCHIVING.param,
            true
        )

        val messageList = messageParseQuery.find()

        if (messageList != null) {
            emitter.onSuccess(messageList)
        } else {
            emitter.onError(ParseQueryEmptyThrowable())
        }

    }



    suspend fun makeMessageSeen(message: Message) {
        val currentSeenList = try {
            message.seenBy as ArrayList
        } catch (e: Exception) {
            arrayListOf()
        }
        currentSeenList.add(currentUserId)
        message.seenBy = currentSeenList
        message.save()
    }

    /**
     * Short list a message, by adding the current user to the short listed by
     * list of the message table
     *
     * @param message of [Message] type
     *
     */
    suspend fun shortListAMessage(message: Message) {
        val currentList = message.shortListedBy
        val newList = arrayListOf<String>()
        if (currentList.contains(currentUserId)) {
            log("no need to shortlist, as the user is already shortlisted")
        } else {
            newList.addAll(currentList)
            newList.add(currentUserId)
            message.shortListedBy = newList
            message.save()
        }
    }

    suspend fun removeFromShortlist(message: Message) {
        val currentList = message.shortListedBy
        val newList = arrayListOf<String>()
        if (currentList.contains(currentUserId)) {
            newList.addAll(currentList)
            newList.remove(currentUserId)
            message.shortListedBy = newList
            message.save()
        }
    }

    fun getExistingJobSeeker(userId: String): List<ParseObject> {
        val query = ParseQuery.getQuery<ParseObject>(JobSeeker.CLASS_NAME)
        query.whereEqualTo("userId", userId)

        return query.find()
    }

    /**
     * Determine whether the user with the user id provided
     * is a job seeker or not
     * If he is, it will emit true, or else will emit false
     *
     * @param userId id of the user that will queried in [String]
     *
     * @return [Single] of [Boolean] type
     */
    fun isAJobSeeker(userId: String) = Single.create<Boolean> { emitter ->
        val query = ParseQuery.getQuery<ParseObject>(JobSeeker.CLASS_NAME)
        query.whereEqualTo("userId", userId)

        val foundJobSeekerList = query.find()

        if (foundJobSeekerList == null || foundJobSeekerList.isEmpty()) {
            emitter.onSuccess(false)
        } else {
            if (foundJobSeekerList[0] == null) {
                emitter.onSuccess(false)
            } else {
                emitter.onSuccess(true)
            }
        }


    }

    fun getRecruiterOffers(recruiterId: String, callback: GetAllJobOfferCallback) {
        val query = ParseQuery.getQuery<ParseObject>("JobOffer")
        query.whereEqualTo("recruiterId", recruiterId)
        query.findInBackground { it, e ->
            when {
                e != null -> callback.onFinish(listOf())
                else -> callback.onFinish(it ?: listOf())
            }
        }
    }

    fun getExistingRecruiter(userId: String): List<ParseObject> {
        val query = ParseQuery.getQuery<ParseObject>(Recruiter.CLASS_NAME)
        query.whereEqualTo("userId", userId)

        return query.find()
    }

    fun getAllJobOffers(recruiterId: String, callback: GetAllJobOfferCallback) {
        val query = ParseQuery.getQuery<ParseObject>("JobOffer")
        query.whereEqualTo("recruiterId", recruiterId)
        query.findInBackground { it, e ->
            when {
                e != null -> callback.onFinish(listOf())
                else -> callback.onFinish(it ?: listOf())
            }
        }
    }

    fun saveRequirements(receiverObjectId: String, requirements: ArrayList<String>) {
        val parseSender = ParseQuery.getQuery(Message::class.java)
            .whereEqualTo(
                CHAT_SENDER_ID, currentUser
            )

        val parseReceiver = ParseQuery.getQuery(Message::class.java)
            .whereEqualTo(
                CHAT_RECEIVER_ID, currentUser
            )

        val messageParseQuery =
            ParseQuery.or(listOf<ParseQuery<Message>>(parseSender, parseReceiver))
                .orderByDescending(SORTING_CREATED_AT)

        val messageList = messageParseQuery.find().filter { message ->
            message.receiverId.objectId == receiverObjectId &&
                    message.senderId.objectId == currentUserId ||
                    message.senderId.objectId == receiverObjectId &&
                    message.receiverId.objectId == currentUserId
        }

        val message = messageList[0]

        message.requirements = requirements
        message.save()
    }

    fun getRequirements(receiverObjectId: String, callback: GetRequirementsCallback) {
        val parseSender = ParseQuery.getQuery(Message::class.java)
            .whereEqualTo(
                CHAT_SENDER_ID, currentUser
            )

        val parseReceiver = ParseQuery.getQuery(Message::class.java)
            .whereEqualTo(
                CHAT_RECEIVER_ID, currentUser
            )

        val messageParseQuery =
            ParseQuery.or(listOf<ParseQuery<Message>>(parseSender, parseReceiver))
                .orderByDescending(SORTING_CREATED_AT)

        val messageList = messageParseQuery.find().filter { message ->
            message.receiverId.objectId == receiverObjectId &&
                    message.senderId.objectId == currentUserId ||
                    message.senderId.objectId == receiverObjectId &&
                    message.receiverId.objectId == currentUserId
        }

        try {
            val message = messageList[0]
            callback.onFinish(message.requirements)
        } catch (e: Exception) {
            callback.onFinish(emptyList())
        }
    }

    suspend fun unarchiveConversation(message: Message) {
        try {
            if (message.isArchived) {
                message.isArchived = false
                message.save()
                val jobId = message.getString("jobId") ?: "0"
                if (jobId != "0") unArchiveJobOffer(jobId)
            } else {
                log("message is already unarchived")
            }
        } catch (e: Exception) {
            log("could not unarchive the message", e)
        }
    }

    private suspend fun unArchiveJobOffer(jobOfferId: String) {

        log("unarchiving $jobOfferId")

        try {
            val jobOfferQuery = ParseQuery.getQuery<ParseObject>(JobOffer.CLASS_NAME)
            jobOfferQuery.whereEqualTo("jobOfferId", jobOfferId)
            val jobOffer: ParseObject = jobOfferQuery.find()[0]

            jobOffer.put("isArchived", false)
            jobOffer.save()

        } catch (e: Exception) {
            log("Could not unarchive the job offer due to ${e.message}", e)
        }
    }

    interface GetOffersCallback {
        fun onFinish()
    }

    interface GetRequirementsCallback {
        fun onFinish(requirements: List<String>)
    }

}



