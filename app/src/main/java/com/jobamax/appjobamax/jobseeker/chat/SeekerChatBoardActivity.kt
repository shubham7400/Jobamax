package com.jobamax.appjobamax.jobseeker.chat

import android.Manifest
import android.animation.ObjectAnimator
import android.content.Context
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.gms.common.api.Api
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseActivity
import com.jobamax.appjobamax.databinding.*
import com.jobamax.appjobamax.jobseeker.dialog.ReportDialog
import com.jobamax.appjobamax.enums.*
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity
import com.jobamax.appjobamax.jobseeker.build_profile.PROFILE_IMAGE_REQUEST_CODE
import com.jobamax.appjobamax.jobseeker.build_profile.RECORD_AUDIO
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.ChatThread
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.model.Message
import com.jobamax.appjobamax.model.Recruiter
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.singletons.MyParseLiveQueryClient
import com.jobamax.appjobamax.util.*
import com.parse.*
import com.parse.livequery.ParseLiveQueryClient
import com.parse.livequery.SubscriptionHandling
import id.zelory.compressor.Compressor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.IOException
import java.util.*

class SeekerChatBoardActivity : BaseActivity() , ImagePicker.GetImage{
    val binding: ActivitySeekerChatBoardBinding by lazy { ActivitySeekerChatBoardBinding.inflate(layoutInflater) }

    val viewModel: SeekerHomeViewModel by viewModels()

    var recruiter: Recruiter? = null
    lateinit var jobSeeker: JobSeeker

    private var recorder: MediaRecorder? = null
    private var fileName: String = ""

    lateinit var imagePicker: ImagePicker
    private var alphaAnimator: ObjectAnimator? = null

    private var parseLiveQueryClient: ParseLiveQueryClient? = null
    private var subscriptionHandling: SubscriptionHandling<ParseObject>? = null
    private var pqMessage: ParseQuery<ParseObject>? = null

    lateinit var chatMessageAdapter: SeekerChatMessageAdapter
    var chatThread: ChatThread? = null
    private val chatMessages = arrayListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configureUi()
    }

    private fun configureUi() {
        initializeUi()
        setClickListeners()
        setChatMessageAdapter()
        getChatMessages()
        chatThread?.let{
            setParseLiveQuery()
            setJobSeeker()
            updateFilter()
        }
        fileName = "${filesDir!!.absolutePath}/userAudio.3gp"
        changeDrawableColor(binding.clAudioAction, R.color.gray)
        animation()
    }

    private fun updateFilter() {
        if (chatThread!!.jsFilter == SeekerChatListFilter.UNOPENED.value){
            chatThread!!.chatThreadParseObject?.put(ParseTableFields.JS_Filter.value, 2)
            chatThread!!.chatThreadParseObject?.saveInBackground {
                if (it != null) {
                    toast(it.message.toString()+" Something Went Wrong.")
                }
            }
        }
    }

    private fun setJobSeeker() {
        jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null) {
            try {
                getJobSeeker {
                    if (it) {
                        jobSeeker = viewModel.jobSeeker
                        setData()
                    }
                }
            }catch (e: Exception){ }
        }else{
            setData()
        }
    }

    fun getJobSeeker(callback : (Boolean) -> Unit) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, getUserId())
        query.findInBackground { it, e ->
            val parseObject = it?.firstOrNull()
            when {
                e != null -> {
                    log(e.message.toString())
                    callback(false)
                }
                parseObject == null -> {
                    log("User Not Found")
                    callback(false)
                }
                else -> {
                    log("flsajkl ${parseObject.get("jobSeekerId")}")
                    viewModel.jobSeekerObject = parseObject
                    viewModel.isJobSeekerUpdated.value = true
                    callback(true)
                }
            }
        }
    }

    private fun setData() {
        viewModel.jobSeekerObject?.put(ParseTableFields.CURRENT_THREAD_ID.value, chatThread!!.threadId)
        viewModel.jobSeekerObject?.saveInBackground { e ->
            if (e != null) {
                toast(e.message.toString()+" Something Went Wrong.")
            }
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.jobSeekerObject?.put(ParseTableFields.CURRENT_THREAD_ID.value, "")
        viewModel.jobSeekerObject?.saveInBackground {
            if (it != null) {
                toast(it.message.toString()+" Something Went Wrong.")
            }
        }
    }


    private fun initializeUi() {
        val bundle = intent.extras
        chatThread = bundle?.getSerializable("chat_thread") as ChatThread
        val recruiterPO = bundle.getParcelable<ParseObject>(ParseTableName.RECRUITER.value)
        chatThread?.recruiterParseObject = recruiterPO
        val chatThreadPO = bundle.getParcelable<ParseObject>(ParseTableName.CHAT_THREAD.value)
        chatThread?.chatThreadParseObject = chatThreadPO
        recruiter = recruiterPO?.let { Recruiter(it) }

        recruiter?.let {  rec ->
            if (rec.scheduleLink.isNotEmpty()){
                binding.ivCalender.visibility = View.VISIBLE
            }else{
                binding.ivCalender.visibility = View.INVISIBLE
            }
            binding.tvRecruiterName.text = "${rec.firstName} ${rec.lastName}"
            loadImageFromUrl(binding.civUser, rec.profilePicUrl, R.drawable.default_user_img)
            binding.ivCalender.setOnClickListener {
                if (rec.scheduleLink.isNotEmpty()){
                    try { openLink(rec.scheduleLink) }catch (e: Exception){toast("${e.message.toString()} Something went wrong")}
                 }
            }
        }
    }

    private fun setParseLiveQuery() {
        pqMessage = ParseQuery<ParseObject>(ParseTableName.MESSAGE.value)
        pqMessage?.whereEqualTo(ParseTableFields.THREAD_ID.value, chatThread!!.threadId)
        parseLiveQueryClient = MyParseLiveQueryClient.parseLiveQueryClient
        subscriptionHandling = parseLiveQueryClient?.subscribe(pqMessage)
        subscriptionHandling?.handleSubscribe {
            subscriptionHandling?.handleEvent(SubscriptionHandling.Event.CREATE) { _: ParseQuery<ParseObject?>?, result: ParseObject? ->
                result?.let {
                    val newMessage = Message(it)
                    println("fksdkfjs ${newMessage.messageId}")
                    chatMessages.add(newMessage)
                    lifecycleScope.launch(Dispatchers.Main){
                        chatMessageAdapter.notifyItemInserted(chatMessages.size - 1)
                        binding.rvChatMessage.smoothScrollToPosition(chatMessages.size - 1)
                    }
                    val seenByList = if (newMessage.seenBy.isNotEmpty()){
                        newMessage.seenBy as ArrayList
                    }else{
                        arrayListOf()
                    }
                    if (!seenByList.contains( getUserId()) && newMessage.senderId !=  getUserId()){
                        seenByList.add( getUserId())
                        newMessage.messageParseObject?.let { po ->
                            po.put(ParseTableFields.SEEN_BY.value, seenByList)
                            po.saveInBackground()
                        }
                    }
                }
            }
            subscriptionHandling?.handleEvent(SubscriptionHandling.Event.DELETE) { _: ParseQuery<ParseObject?>?, result: ParseObject? ->

            }
            subscriptionHandling?.handleEvent(SubscriptionHandling.Event.UPDATE) { _: ParseQuery<ParseObject?>?, result: ParseObject? ->
                result?.let {
                    val updatedMessage = Message(it)
                    chatMessages.first { message -> message.messageId == updatedMessage.messageId }.apply {
                        if (updatedMessage.senderId == getUserId()){
                            this.seenBy = updatedMessage.seenBy
                            val index = chatMessages.indexOf(this)
                            lifecycleScope.launch(Dispatchers.Main){
                                chatMessageAdapter.notifyItemChanged(index)
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        parseLiveQueryClient?.unsubscribe(pqMessage, subscriptionHandling)
    }

    private fun getChatMessages() {
        val messagePQ = ParseQuery<ParseObject>(ParseTableName.MESSAGE.value)
        chatThread?.let {
            messagePQ.whereEqualTo(ParseTableFields.THREAD_ID.value, it.threadId)
            messagePQ.orderByAscending(ParseTableFields.CREATED_AT.value)
            messagePQ.findInBackground { result, e ->
                if (e != null) {
                    toast(e.message.toString() + " Something went wrong")
                } else {
                    chatMessages.clear()
                    result.forEach { po -> chatMessages.add(Message(po)) }
                    chatMessageAdapter.submitList(chatMessages)
                    chatMessageAdapter.notifyDataSetChanged()
                    try {
                        binding.rvChatMessage.smoothScrollToPosition(chatMessages.size - 1)
                        chatMessages.last { message -> message.senderId !=  getUserId() }.apply {
                            val seenByList = if (this.seenBy.isNotEmpty()){
                                this.seenBy as ArrayList
                            }else{
                                arrayListOf()
                            }
                            if (!seenBy.contains( getUserId())){
                                seenByList.add( getUserId())
                                this.messageParseObject?.let { po ->
                                    po.put(ParseTableFields.SEEN_BY.value, seenByList)
                                    po.saveInBackground()
                                }
                            }
                        }
                    }catch (e: Exception){}
                }
            }
        }
    }

    private fun setChatMessageAdapter() {
        chatMessageAdapter = SeekerChatMessageAdapter(arrayListOf(), this, chatThread)
        binding.rvChatMessage.adapter = chatMessageAdapter
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {  onBackPressed() }
        binding.ivReport.setOnClickListener { ReportDialog(this){ submitReport(it) }.show() }
        binding.llSentBtn.setOnClickListener {
            if (binding.etMessageText.text.isNullOrEmpty()) {
                toast("Please type something in message.")
            } else {
                sendTextMessage()
            }
        }
        binding.ivCamere.setOnClickListener {
            setupImagePicker(PROFILE_IMAGE_REQUEST_CODE, IMAGE_PICKER_TYPE_CAMERA)
        }
        binding.ivGallery.setOnClickListener {
            setupImagePicker(PROFILE_IMAGE_REQUEST_CODE, IMAGE_PICKER_TYPE_GALLERY)
        }
        binding.ivMessageAudio.setOnClickListener {
            onRecord()
        }
        binding.ivDeleteAudio.setOnClickListener {
            recorder?.let {
                it.stop()
                it.release()
                recorder = null
            }
            binding.clAudioAction.visibility = View.GONE
        }
        binding.ivSendAudio.setOnClickListener {
            stopRecording()
        }
        binding.civUser.setOnClickListener {
            recruiter?.company?.getString(ParseTableFields.COMPANY_ID.value)?.let { companyId ->
                ParseCloud.callFunctionInBackground(ParseTableName.CHECK_HAS_SHOW_CASE_V1.value, hashMapOf(ParseTableFields.COMPANY_ID.value to companyId), FunctionCallback<Any>{ result, e ->
                    when{
                        e != null -> toast(e.message.toString()+ " Something Went Wrong.")
                        result == null -> {toast("Something Went Wrong.")}
                        else -> {
                            try {
                                if (gson.toJson(result).toBoolean()){
                                    val url = showcaseBase+companyId
                                    openLink(url)
                                }
                            }catch (e: Exception){}
                        }
                    }
                })
            }
        }
    }

    private fun submitReport(reason: String) {
        recruiter?.recruiterId?.let {
            val request = hashMapOf<String, Any>(
                "reportedTo" to it,
                "reportedBy" to getUserId(),
                "type" to ReportType.JOB_SEEKER_TO_RECRUITER.value,
                "reportedFrom" to ReportedFrom.CHAT.value,
                "reason" to reason,
            )
            ParseCloud.callFunctionInBackground(ParseCloudFunction.REPORT_ACTION.value, request, FunctionCallback<Any> { result, e ->
                if (e != null) {
                    toast(e.message.toString()+" Something went wrong")
                }else{
                    toast("reported.")
                }
            })
        }
    }

    private fun animation() {
        alphaAnimator = ObjectAnimator.ofFloat(binding.tvRecordingTitle,  "alpha", 1f, 0.5f)
        alphaAnimator?.repeatCount = ObjectAnimator.INFINITE
        alphaAnimator?.duration = 2000
    }



    private fun onRecord() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,  arrayOf(Manifest.permission.RECORD_AUDIO) ,  RECORD_AUDIO)
        } else {
            startRecording()
        }
    }

    private fun startRecording() {
        if (recorder == null){
            recorder = MediaRecorder().apply {
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                setOutputFile(fileName)
                setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                try {
                    prepare()
                } catch (e: IOException) {
                    log(  "prepare() failed")
                }
            }
        }
        recorder?.let {
            it.start()
            alphaAnimator?.start()
            binding.clAudioAction.visibility = View.VISIBLE
        }
    }


    private fun stopRecording() {
        recorder?.let {
            it.stop()
            it.release()
            alphaAnimator?.end()
            recorder = null
            uploadAudio()
        }
        binding.clAudioAction.visibility = View.GONE
    }

    private fun uploadAudio() {
        val parseFile = ParseFile("portfolioAudio.m4a", convertAudioToByteArray(fileName))
        parseFile.saveInBackground(SaveCallback {
            if (it != null){
                toast(it.message.toString())
            }else{
                parseFile.url?.let { url ->
                    sendAudioMessage(url)
                }
            }
        })
    }

    private fun sendAudioMessage(audioUrl: String) {
        chatThread?.let { ct ->
            val message = Message().also {
                it.senderId =  getUserId()
                it.seenBy = listOf()
                it.mediaCaption = ""
                it.messageId = UUID.randomUUID().toString()
                it.threadId = ct.threadId
                it.mediaUrl = audioUrl
                it.text = ""
                it.type = 3
            }
            message.toParseObject().saveInBackground {
                if (it != null) {
                    toast("${it.message.toString()}  Something went wrong")
                } else {
                    binding.etMessageText.text.clear()
                    sendMessageNotification()
                }
            }
        }
    }

    private fun sendTextMessage() {
        chatThread?.let { ct ->
            val message = Message().also {
                it.senderId =  getUserId()
                it.seenBy = listOf()
                it.mediaCaption = ""
                it.messageId = UUID.randomUUID().toString()
                it.threadId = ct.threadId
                it.mediaUrl = ""
                it.text = binding.etMessageText.text.toString()
                it.type = 0
            }
            message.toParseObject().saveInBackground {
                if (it != null) {
                    toast("${it.message.toString()}  Something went wrong")
                } else {
                    binding.etMessageText.text.clear()
                    sendMessageNotification()
                }
            }
        }
    }

    private fun sendMessageNotification(){
        val request = hashMapOf(
            ParseTableFields.THREAD_ID.value to chatThread!!.threadId,
            ParseTableFields.RECIEVER_ID.value to recruiter!!.recruiterId ,
            ParseTableFields.TYPE.value to 1
        )
        ParseCloud.callFunctionInBackground(ParseCloudFunction.SEND_MSG_NOTIFICATION.value, request, FunctionCallback<Any> { result, e ->
            when{
                e != null -> toast(e.message.toString()+" Something Went Wrong.")
                result == null -> toast("Something Went Wrong.")
                else -> {}
            }
        })
    }

    private fun setupImagePicker(imageCode: Int, imagePickerType: Int) {
        imagePicker = ImagePicker(this, imageCode, imagePickerType)
        imagePicker.show( supportFragmentManager, imagePicker.tag)
    }

    override fun setImageUri(imageUri: Uri?, imageCode: Int) {
        imageUri?.let { uri ->
            lifecycleScope.launch(Dispatchers.IO){
                when (imageCode) {
                    PROFILE_IMAGE_REQUEST_CODE -> {
                        uploadImageToParse(uri, this@SeekerChatBoardActivity,
                            { exception ->
                                toast(exception)
                            },
                            { url ->
                                sendMessageImage(url)
                            })
                    }
                    else -> {}
                }
            }
        }
    }

    private fun sendMessageImage(imageUrl: String) {
        chatThread?.let { ct ->
            val message = Message().also {
                it.senderId =  getUserId()
                it.seenBy = listOf()
                it.mediaCaption = ""
                it.messageId = UUID.randomUUID().toString()
                it.threadId = ct.threadId
                it.mediaUrl = imageUrl
                it.text = ""
                it.type = 1
            }
            message.toParseObject().saveInBackground {
                if (it != null) {
                    toast("${it.message.toString()}  Something went wrong")
                } else {
                    binding.etMessageText.text.clear()
                    sendMessageNotification()
                }
            }
        }
    }


}




const val TYPE_TEXT = 0
const val TYPE_IMAGE = 1
const val TYPE_VIDEO = 2
const val TYPE_AUDIO = 3
const val TYPE_THUMB = 4

class SeekerChatMessageAdapter(
    var list: ArrayList<Message>,
    val requireContext: Context,
    private val chatThread: ChatThread?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_TEXT -> {
                TextViewHolder(
                    ItemMessageTextBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            TYPE_IMAGE -> {
                ImageViewHolder(
                    ItemMessageImageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            TYPE_AUDIO -> {
                AudioViewHolder(
                    ItemMessageAudioBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            TYPE_VIDEO -> {
                TextViewHolder(
                    ItemMessageTextBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            TYPE_THUMB -> {
                TextViewHolder(
                    ItemMessageTextBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                TextViewHolder(
                    ItemMessageTextBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val messageItem = list[position]

        when (list[position].type) {
            TYPE_TEXT -> {
                (holder as TextViewHolder).binding.apply {
                    if (messageItem.senderId == requireContext.getUserId()) {
                        this.tvMessageText.background = requireContext.resources.getDrawable(R.drawable.rounded_white_box, null)
                        this.llMessageText.gravity = Gravity.END
                    } else {
                        this.tvMessageText.background = requireContext.resources.getDrawable(R.drawable.rounded_chat_left_background, null)
                        this.llMessageText.gravity = Gravity.START
                    }
                    this.tvMessageText.text = messageItem.text
                    chatThread?.let { ct ->
                        ct.recruiterParseObject?.let {
                            val recruiter = Recruiter(it )
                            if (messageItem.seenBy.contains(recruiter.recruiterId)){
                                this.tvMessageSeenFlag.visibility = View.VISIBLE
                            }else{
                                this.tvMessageSeenFlag.visibility = View.GONE
                            }
                        }
                    }
                }
            }
            TYPE_IMAGE -> {
                (holder as ImageViewHolder).binding.apply {
                    if (messageItem.senderId == requireContext.getUserId()) {
                        this.llMessageImageBackground.background = requireContext.resources.getDrawable(R.drawable.rounded_white_box, null)
                        this.llMessageImage.gravity = Gravity.END
                    } else {
                        this.llMessageImageBackground.background = requireContext.resources.getDrawable(R.drawable.rounded_chat_left_background, null)
                        this.llMessageImage.gravity = Gravity.START
                    }
                    Glide.with(this.ivMessageImage.context)
                        .load(messageItem.mediaUrl)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .into(this.ivMessageImage)

                    chatThread?.let { ct ->
                        ct.recruiterParseObject?.let {
                            val recruiter = Recruiter(it )
                            if (messageItem.seenBy.contains(recruiter.recruiterId)){
                                this.tvMessageSeenFlag.visibility = View.VISIBLE
                            }else{
                                this.tvMessageSeenFlag.visibility = View.GONE
                            }
                        }
                    }
                }
            }
            TYPE_AUDIO -> {
                (holder as AudioViewHolder).binding.apply {
                    if (messageItem.senderId == requireContext.getUserId()) {
                        this@apply.clAudioPlayer.background = requireContext.resources.getDrawable(R.drawable.rounded_white_box, null)
                        this@apply.llMessageAudio.gravity = Gravity.END
                    } else {
                        this@apply.clAudioPlayer.background = requireContext.resources.getDrawable(R.drawable.rounded_chat_left_background, null)
                        this@apply.llMessageAudio.gravity = Gravity.START
                    }
                    val player = MediaPlayer().apply {
                        try {
                            setDataSource(messageItem.mediaUrl)
                            prepare()
                        } catch (e: IOException) {
                            log(  "prepare() failed")
                        }
                    }
                    this@apply.tvAudioDuration.text = convertMillisToMinuteAndSecond(player.duration.toLong())
                    val mSeekbarUpdateHandler: Handler = Handler()
                    var mUpdateSeekbar: Runnable? = null
                    this@apply.ivAudioPlayBtn.setOnClickListener {
                        if (player.isPlaying) {
                            player.pause()
                            this@apply.ivAudioPlayBtn.setImageResource(R.drawable.ic_play)
                        }else{
                            player.start()
                            this@apply.ivAudioPlayBtn.setImageResource(R.drawable.ic_pause)

                            if (mUpdateSeekbar == null){
                                mUpdateSeekbar  = object : Runnable {
                                    override fun run() {
                                        this@apply.sbAudio.progress = player.currentPosition
                                        this@apply.tvAudioDurationProgress.text = convertMillisToMinuteAndSecond((this@apply.sbAudio.progress).toLong())
                                        mSeekbarUpdateHandler.postDelayed(this, 50)
                                    }
                                }
                            }

                            this@apply.sbAudio.max = player.duration
                            mSeekbarUpdateHandler.postDelayed(mUpdateSeekbar!!, 0)

                            player.setOnCompletionListener {
                                mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar!!)
                                this@apply.ivAudioPlayBtn.setImageResource(R.drawable.ic_play)
                                this@apply.tvAudioDurationProgress.text = convertMillisToMinuteAndSecond((0))
                                this@apply.sbAudio.progress = 0
                            }
                        }

                    }

                    chatThread?.let { ct ->
                        ct.recruiterParseObject?.let {
                            val recruiter = Recruiter(it )
                            if (messageItem.seenBy.contains(recruiter.recruiterId)){
                                this.tvMessageSeenFlag.visibility = View.VISIBLE
                            }else{
                                this.tvMessageSeenFlag.visibility = View.GONE
                            }
                        }
                    }
                }
            }
            TYPE_VIDEO -> {
                (holder as TextViewHolder).binding.apply {

                }
            }
            TYPE_THUMB -> {
                (holder as TextViewHolder).binding.apply {

                }
            }
        }
    }

    override fun getItemCount(): Int = list.size

    class TextViewHolder(val binding: ItemMessageTextBinding) :
        RecyclerView.ViewHolder(binding.root)

    class ImageViewHolder(val binding: ItemMessageImageBinding) :
        RecyclerView.ViewHolder(binding.root)

    class AudioViewHolder(val binding: ItemMessageAudioBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun submitList(chatMessages: ArrayList<Message>) {
        list = chatMessages
    }



}