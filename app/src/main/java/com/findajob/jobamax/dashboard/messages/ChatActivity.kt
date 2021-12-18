package com.findajob.jobamax.dashboard.messages

import android.annotation.SuppressLint
import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.data.pojo.Chat
import com.findajob.jobamax.databinding.ActivityChatBinding
import com.findajob.jobamax.dialog.ConfirmationDialog
import com.findajob.jobamax.dialog.RequirementsDialog
import com.findajob.jobamax.extensions.generateRandomAlphaNumeric
import com.findajob.jobamax.extensions.goToActivity
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.model.fcm.NotificationData
import com.findajob.jobamax.model.fcm.PushNotification
import com.findajob.jobamax.preference.getRole
import com.findajob.jobamax.preference.getUserFullName
import com.findajob.jobamax.repo.MessageRepository
import com.findajob.jobamax.util.*
import com.esafirm.imagepicker.features.ImagePicker
import com.google.firebase.messaging.FirebaseMessaging
import com.parse.*
import com.parse.livequery.ParseLiveQueryClient
import com.parse.livequery.SubscriptionHandling
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_maps.*
import kotlinx.android.synthetic.main.dialog_basic.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.File
import java.net.URI
import java.net.URISyntaxException
import java.util.*
import javax.inject.Inject


@AndroidEntryPoint
class ChatActivity : BaseActivityMain<ActivityChatBinding>(), ChatHandler {

    @Inject
    lateinit var adapter: ChatAdapter

    private val viewModel: ChatViewModel by viewModels()

    private var receiverObjectId: String = ""
    private var receiverObjectName: String = ""
    private var receiverName: String = ""
    private var recieverImageUrl: String = ""

    private var parseQueryResult: ParseQuery<Chat>? = null

    private var parseLiveQueryClient: ParseLiveQueryClient? = null

    private var chatList = mutableListOf<Chat>()
    private var isVideoCall = false
    private var requirementsList = arrayListOf<String>()


    override val layoutRes: Int
        get() = R.layout.activity_chat

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreated(instance: Bundle?) {
        initViews()
        checkExtras()
        initObserver()
        initLiveQuery()
//        subscribeToLiveQuery()
    }

    override fun onStart() {
        super.onStart()
        viewModel.setUniqueMessageId(viewModel.currentUsedId, receiverObjectId)

        FirebaseMessaging.getInstance()
            .subscribeToTopic("/topics/" + viewModel.uniqueMessageId)
        registerReceiver(broadcastReceiver, IntentFilter(ARG_CHAT_REQUIREMENTS))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcastReceiver)
    }

    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            var requirements = intent.getStringExtra("requirements")

            requirements = requirements?.replace("[", "")?.replace("]", "")
            val list: List<String> = requirements?.split(",")?.toList() ?: emptyList()
            requirementsList = list.toMutableList() as ArrayList<String>
            RequirementsDialog(
                this@ChatActivity,
                requirementsList,
                false
            ) { _, _ ->
                viewModel.setSelectFiles(true)
            }.show()
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun initObserver() {

        viewModel.apply {


            getChat(receiverObjectId)
            observe(chat) {
                binding.loading.visibility = View.INVISIBLE
                it?.apply {
                    chatList.addAll(this)
                    adapter.submitList(chatList)
                    binding.chatRvMessage.smoothScrollToPosition(0)
                    viewModel.isChatEmpty = false
                    binding.chatRvMessage.adapter?.notifyDataSetChanged()
                }
            }

            getName(this@ChatActivity.getRole(), receiverObjectId)
            observe(name, ::handleName)

            observe(selectImage, ::handleSelectImage)
            observe(selectFiles, ::handleSelectFiles)
            observe(inputTemplate, ::handleInputTemplate)

            isAJobSeeker(receiverObjectId)
            observe(checkIfJobSeeker, ::handleJobOfferNavigation)
        }

        viewModel.getRequirements(
            receiverObjectId,
            object : MessageRepository.GetRequirementsCallback {
                override fun onFinish(requirements: List<String>) {
                    if (!requirements.isNullOrEmpty()) {
                        requirementsList = requirements as ArrayList<String>
                    }
                }
            })


    }

    private fun handleName(name: String?) {
        binding.tvUsername.text = name.toString()
        receiverName = name.toString()
    }

    private fun handleJobOfferNavigation(isJobSeeker: Boolean?) {
        if (isJobSeeker != null && isJobSeeker == true) {
            val titleClickListener = View.OnClickListener {
                goToActivity(
                    PreviewJobSeekerActivity::class.java,
                    false,
                    bundleOf(
                        Pair(PreviewJobSeekerActivity.EXTRA_JOB_SEEKER_ID, receiverObjectId)
                    )
                )
            }
            binding.tvUsername.setOnClickListener(titleClickListener)
            binding.ivUserImage.setOnClickListener(titleClickListener)
        } else {
            val titleClickListener = View.OnClickListener {
                goToActivity(
                    PreviewRecruiterActivity::class.java,
                    false,
                    bundleOf(
                        Pair(PreviewRecruiterActivity.EXTRA_RECRUITER_ID, receiverObjectId)
                    )
                )
            }

            binding.tvUsername.setOnClickListener(titleClickListener)
            binding.ivUserImage.setOnClickListener(titleClickListener)
        }
    }

    private fun checkExtras() {
        intent.extras?.apply {
            if (containsKey(EXTRA_RECEIVER_ID)) {
                receiverObjectId = getString(EXTRA_RECEIVER_ID, "")
                viewModel.setReceiverId(getString(EXTRA_RECEIVER_ID, ""))
            } else {
                finish()
            }
            if (containsKey(EXTRA_MESSAGE_SOURCE)) {
                viewModel.chatSource = getString(EXTRA_MESSAGE_SOURCE, "")
            } else {
                viewModel.chatSource = CHAT_IS_JOB
            }
            if (containsKey(EXTRA_PROFILE_PICTURE_URL)) {
                recieverImageUrl = getString(EXTRA_PROFILE_PICTURE_URL, "")
                binding.profilePictureUrl = recieverImageUrl
            }
            if (containsKey(EXTRA_IS_SOURCE) && containsKey(EXTRA_JOB_OFFER_ID)) {
                viewModel.setAsSource(receiverObjectId, getString(EXTRA_JOB_OFFER_ID) ?: "")
                viewModel.getCurrentUser()
                viewModel.getRecieverUser(receiverObjectId)
            }
        }

        binding.tvUsername.text = receiverObjectName

    }

    private fun initViews() {

        binding.lifecycleOwner = this
        binding.handler = this
        binding.vm = viewModel

        setSupportActionBar(binding.toolbar)

        binding.apply {
            loading.visibility = View.VISIBLE
            loading.start()
            adapter = ChatAdapter()
            adapter.profileImageUrl = viewModel.currentUserProfilePicUrl
            chatRvMessage.adapter = adapter

            adapter.clickListener = {
                if (it.message == null) {
                    goToActivity(
                        PreviewImageActivity::class.java,
                        false,
                        bundleOf(
                            Pair(PreviewImageActivity.EXTRA_FILE_URL, it.file)
                        )
                    )
                }
            }
            if (viewModel.chatSource != CHAT_IS_JOB) {
                binding.ivRequirementOpenButton.visibility = View.GONE
            }
        }
    }

    private fun initLiveQuery() {

        lifecycleScope.launch(Dispatchers.IO) {
            val currentUser = viewModel.getCurrentUserInstant()
            val receiverUser = viewModel.getReceiverUserInstant(receiverObjectId)

            if (parseLiveQueryClient == null) {
                try {
                    parseLiveQueryClient = ParseLiveQueryClient.Factory
                        .getClient(URI(getString(R.string.back4app_live_query_url)))
                } catch (e: URISyntaxException) {
                    throw IllegalStateException("initLiveQuery error")
                }
                val parseSender = ParseQuery.getQuery(Chat::class.java)
                    .whereEqualTo(
                        CHAT_SENDER_ID,
                        currentUser,
//                            createWithoutData("_User", viewModel.currentUsedId)
                    )
                    .whereEqualTo(
                        CHAT_RECEIVER_ID,
                        receiverUser,
//                                createWithoutData("_User", receiverObjectId)
                    )

                val parseReceiver = ParseQuery.getQuery(Chat::class.java)
                    .whereEqualTo(
                        CHAT_RECEIVER_ID,
                        currentUser,
                    )
                    .whereEqualTo(
                        CHAT_SENDER_ID,
                        receiverUser,
//                                createWithoutData("_User", receiverObjectId)
                    )

                parseQueryResult = ParseQuery.or(listOf(parseSender, parseReceiver))

                subscribeToLiveQuery()
            }
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun subscribeToLiveQuery() {
        val subscriptionHandling = parseLiveQueryClient!!.subscribe(parseQueryResult)
        subscriptionHandling.handleEvent(
            SubscriptionHandling.Event.CREATE
        ) { _, message ->

            lifecycleScope.launch(Dispatchers.IO) {

                chatList.add(0, message)
                adapter.submitList(chatList)

                withContext(Dispatchers.Main) {
                    binding.chatRvMessage.adapter?.notifyDataSetChanged()
                    binding.chatRvMessage.smoothScrollToPosition(0)
                }

                val sender = getUserFullName()
                val receiverId = "/topics/" + message.receiverId.objectId

                if (message.senderId.objectId == viewModel.currentUsedId) {
                    val notification = if (!message.message.isNullOrEmpty()) {
                        "$sender : ${message.message}"
                    } else "$sender send an attachment"

                    val data = NotificationData(
                        title = getString(R.string.app_name),
                        message = notification,
                        receiverObjectId = viewModel.currentUsedId,
                        receiverObjectName = viewModel.currentUserEmail
                    )
                    val pushData = PushNotification(data, receiverId)
                    viewModel.sendPushNotificationByUserId(pushData)
                }


            }
        }
    }

    override fun onSendMessage() {
        viewModel.sendMessage()
        binding.chatEtMessage.text.clear()
    }

    override fun onBackPress() {
        super.onBackPressed()
    }

    private fun handleSelectImage(b: Boolean?) {
        b?.let { selectImage ->
            if (selectImage) {
                openImagePicker(this@ChatActivity, false)
                viewModel.setSelectImage(false)
            }
        }
    }

    private fun handleSelectFiles(b: Boolean?) {
        b?.let { selectFiles ->
            if (selectFiles) {
//                val mimeTypes = arrayOf("image/*", "application/pdf", "video/*")
//                var intent = Intent(Intent.ACTION_GET_CONTENT)
//                    .setType(mimeTypes.joinToString(separator= "|"))
//                    .putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
//                intent = Intent.createChooser(intent,"Choose a file/s")
//                startActivityForResult(intent, REQUEST_CODE_FILE)

                val intent = Intent()
                    .setType("application/pdf")
                    .setAction(Intent.ACTION_GET_CONTENT)
                startActivityForResult(
                    Intent.createChooser(intent, "Select a file"),
                    REQUEST_CODE_FILE
                )
            }
        }
    }

    private fun handleInputTemplate(s: String?) {
        s?.let { input ->
            binding.chatEtMessage.setText(input)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == REQUEST_CODE_FILE &&
            resultCode == Activity.RESULT_OK &&
            data!!.data != null
        ) {

            data.apply {
//                val file = File(data.data!!.path)
                val hereUrl = data.data
                val inputStream = this@ChatActivity.contentResolver.openInputStream(hereUrl!!)
                val parseFile = ParseFile(
//                    "JCI${file.extension}-${generateRandomAlphaNumeric(10)}.${file.extension}",
                    "JCIpdf-${generateRandomAlphaNumeric(10)}.pdf",
                    inputStream!!.readBytes()
                )
                parseFile.saveInBackground(SaveCallback {
//                        viewModel.form.value!!.file.set(parseFile.url)
                    viewModel.sendImage(parseFile.url)
                })
            }
        }

        if (requestCode == REQUEST_CODE_CAMERA &&
            resultCode == Activity.RESULT_OK
        ) {

            data.apply {
                val byteArrayOutputStream = ByteArrayOutputStream()
                val image: Bitmap? = data?.extras?.get("data") as Bitmap?

                image?.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
                val imageByte = byteArrayOutputStream.toByteArray()

                val parseFile = ParseFile(
                    "JCI${"PNG"}-${generateRandomAlphaNumeric(10)}.png",
                    imageByte
                )
                parseFile.saveInBackground(SaveCallback {
                    viewModel.sendImage(parseFile.url)
                })
            }
        }

        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {

            val images = ImagePicker.getImages(data)

            images.forEach { image ->
                val file = File(image.path)
                val parseFile = ParseFile(
                    "JCI${file.extension}-${generateRandomAlphaNumeric(10)}.${file.extension}",
                    file.readBytes()
                )
                parseFile.saveInBackground(SaveCallback {
//                        viewModel.form.value!!.file.set(parseFile.url)
                    viewModel.sendImage(parseFile.url)
                })
            }
            binding.chatEtMessage.text.clear()
        }

        super.onActivityResult(requestCode, resultCode, data)
    }


    private val callConfirmation: ConfirmationDialog by lazy {
        ConfirmationDialog(
            this,
            getString(R.string.purpose_of_call),
            getString(R.string.interview),
            getString(R.string.information),
            false,
        ) {

            goToActivity(
                VideoChatViewActivity::class.java,
                false,
                if (isVideoCall) {
                    bundleOf(
                        Pair(EXTRA_RECEIVER_ID, receiverObjectId),
                        Pair(EXTRA_RECEIVER_NAME, receiverName),
                        Pair(EXTRA_CALL_TYPE, IS_VIDEO_CALL)
                    )
                } else {
                    bundleOf(
                        Pair(EXTRA_RECEIVER_ID, receiverObjectId),
                        Pair(EXTRA_RECEIVER_NAME, receiverName)
                    )
                }
            )
            // for now do nothing, but it would show  a toast if selected some specific buttons
        }
    }

    private val requestRequirements: RequirementsDialog by lazy {
        RequirementsDialog(
            this,
            requirementsList,
            true
        ) { button, arrChecked ->
            if (button == RequirementsDialog.SubmitButton.POSITIVE) {
                viewModel.sendRequirementsNotification(
                    viewModel.uniqueMessageId,
                    arrChecked.toString()
                )
                viewModel.saveRequirements(receiverObjectId, arrChecked)
            }
        }
    }

    override fun onCallButtonPressed() {
        isVideoCall = false
        callConfirmation.show()
    }

    override fun onVideoCallButtonPressed() {
        isVideoCall = true
        callConfirmation.show()
    }

    override fun onRequirementsButtonPressed() {
        if (this.getRole() == ROLE_RECRUITER) {
            requestRequirements.show()
        } else {
            RequirementsDialog(
                this,
                requirementsList,
                false
            ) { button, arrChecked ->
                viewModel.setSelectFiles(true)
            }.show()
        }
    }

    override fun launchCamera() {
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        if (checkForPermissions()) {
            startActivityForResult(intent, REQUEST_CODE_CAMERA)
        }
    }

    companion object {
        const val EXTRA_RECEIVER_ID = "e_receiver_id"
        const val EXTRA_RECEIVER_NAME = "e_receiver_name"
        const val EXTRA_PROFILE_PICTURE_URL = "e_profile_picture_url"
        const val EXTRA_MESSAGE_SOURCE = "e_message_source"
        const val EXTRA_CALL_TYPE = "e_call_type"
        const val IS_VIDEO_CALL = "call_type_video"
        const val IS_AUDIO_CALL = "call_type_audio"
        const val REQUEST_CODE_FILE = 31948
        const val REQUEST_CODE_CAMERA = 31532
        const val EXTRA_MESSAGE_OBJECT_ID = "e_messge_object_id"
        const val EXTRA_JOB_OFFER_ID = "e_job_offer_id"
        const val EXTRA_IS_SOURCE = "e_is_source"
    }

}