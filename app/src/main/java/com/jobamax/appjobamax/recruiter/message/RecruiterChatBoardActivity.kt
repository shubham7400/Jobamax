package com.jobamax.appjobamax.recruiter.message

import android.Manifest
import android.animation.ObjectAnimator
import android.content.Context
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseActivity
import com.jobamax.appjobamax.databinding.ActivityRecruiterChatBoardBinding
import com.jobamax.appjobamax.databinding.ItemMessageAudioBinding
import com.jobamax.appjobamax.databinding.ItemMessageImageBinding
import com.jobamax.appjobamax.databinding.ItemMessageTextBinding
import com.jobamax.appjobamax.enums.*
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.build_profile.PROFILE_IMAGE_REQUEST_CODE
import com.jobamax.appjobamax.jobseeker.build_profile.RECORD_AUDIO
import com.jobamax.appjobamax.jobseeker.chat.*
import com.jobamax.appjobamax.jobseeker.dialog.ReportDialog
import com.jobamax.appjobamax.model.ChatThread
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.model.Message
import com.jobamax.appjobamax.model.Recruiter
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter
import com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker
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

class RecruiterChatBoardActivity : BaseActivity() , ImagePicker.GetImage {
    val binding: ActivityRecruiterChatBoardBinding by lazy { ActivityRecruiterChatBoardBinding.inflate(layoutInflater) }

    val viewModel: RecruiterHomeViewModel by viewModels()
    lateinit var recruiter: Recruiter

    private var recorder: MediaRecorder? = null
    private var fileName: String = ""

    var countDownTimer: CountDownTimer? = null

    lateinit var imagePicker: ImagePicker

    private var recruitmentSeeker: RecruitmentSeeker? = null
    private var jobTitleFilter: JobTitleFilter? = null
    var chatThread: ChatThread? = null
    private val chatMessages = arrayListOf<Message>()
    lateinit var chatMessageAdapter: RecruiterChatMessageAdapter

    private var alphaAnimator: ObjectAnimator? = null

    private var parseLiveQueryClient: ParseLiveQueryClient? = null
    private var subscriptionHandling: SubscriptionHandling<ParseObject>? = null
    private var pqMessage: ParseQuery<ParseObject>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val bundle = intent.extras
        bundle?.let {
            recruitmentSeeker = it.getSerializable("recruitment_seeker") as RecruitmentSeeker
            jobTitleFilter = it.getSerializable("job_title_filter") as JobTitleFilter
            recruitmentSeeker?.let {
                configureUi()
            }
        }
    }

    private fun configureUi() {
        initializeUi()
        setClickListeners()
        setChatMessageAdapter()
        initializeRecruiter()
        fileName = "${filesDir!!.absolutePath}/userAudio.3gp"
        changeDrawableColor(binding.clAudioAction, R.color.gray)
        animation()
    }

    private fun setChatMessageAdapter() {
        chatMessageAdapter = RecruiterChatMessageAdapter(arrayListOf(), this, chatThread)
        binding.rvChatMessage.adapter = chatMessageAdapter
    }

    private fun initializeUi() {
        recruitmentSeeker?.let {
            binding.tvSeekerName.text = "${recruitmentSeeker!!.firstName} ${recruitmentSeeker!!.lastName}"
            loadImageFromUrl(binding.civUser, recruitmentSeeker!!.profileURL, R.drawable.default_user_img  )
        }
    }

    private fun initializeRecruiter() {
        recruiter = viewModel.recruiter
        if (viewModel.recruiterObject == null) {
            getRecruiter {
                if (it) {
                    setData()
                }
            }
        }else{
            setData()
        }
    }

    fun getRecruiter(callback : (Boolean) -> Unit) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.RECRUITER.value)
        query.whereEqualTo(ParseTableName.RECRUITER_ID.value, getUserId())
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
                    viewModel.recruiterObject = parseObject
                    viewModel.isRecruiterUpdated.value = true
                    callback(true)
                }
            }
        }
    }

    private fun setData() {
        recruiter = viewModel.recruiter
        val recruiterPQ = ParseQuery<ParseObject>(ParseTableName.RECRUITER.value)
        recruiterPQ.whereEqualTo(ParseTableFields.RECRUITER_ID.value, getUserId())
        val chatThreadPQ = ParseQuery<ParseObject>(ParseTableName.CHAT_THREAD.value)
        chatThreadPQ.whereMatchesQuery(ParseTableFields.RECRUITER.value, recruiterPQ)
        chatThreadPQ.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, recruitmentSeeker!!.jobSeekerId)
        chatThreadPQ.include(ParseTableFields.RECRUITER.value)
        chatThreadPQ.include(ParseTableFields.RECRUITER.value+"."+ ParseTableFields.COMPANY.value)
        chatThreadPQ.include(ParseTableFields.JOB_SEEKER.value)
        progressHud.show()
        chatThreadPQ.getFirstInBackground { result, e ->
            progressHud.dismiss()
            if (e != null) {
                log("${e.message.toString()} Something went wrong")
            }
            if (result == null) {
                // create a new thread
                val jobSeekerPQ = ParseQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
                jobSeekerPQ.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value , recruitmentSeeker!!.jobSeekerId)
                progressHud.show()
                jobSeekerPQ.getFirstInBackground { result2, e2 ->
                    progressHud.dismiss()
                    if (e2 != null) {
                        log("${e2.message.toString()} Something went wrong")
                    }
                    if (result2 != null) {
                        val newChatThread = ChatThread().also {
                            it.threadId = UUID.randomUUID().toString()
                            it.archivedBy = listOf()
                            it.deleteHistory = listOf()
                            it.deletedBy = listOf()
                            if (jobTitleFilter != null) {
                                it.jobTitle = jobTitleFilter!!.jobTitle
                            }else{
                                it.jobTitle = ""
                            }
                            it.latestText = ""
                            it.jobOfferId = jobTitleFilter!!.jobOfferId
                            it.jobSeekerId = recruitmentSeeker!!.jobSeekerId
                            it.recruiterParseObject = recruiter.recruiterParseObject
                            it.jobSeekerParseObject = result2
                        }
                        val chatThreadParseObject = newChatThread.toParseObject()
                        progressHud.show()
                        chatThreadParseObject.saveInBackground { e3 ->
                            progressHud.dismiss()
                            if (e3 != null) {
                                log("${e3.message.toString()} Something went wrong")
                            }else{
                                newChatThread.chatThreadParseObject = chatThreadParseObject
                                chatThread = newChatThread
                                startChat()
                            }
                        }
                    }
                }
            }else{
                chatThread = ChatThread(result)
                startChat()
            }
        }
    }

    private fun startChat() {
        getChatMessages()
        if(subscriptionHandling == null){
            setParseLiveQuery()
        }
        if (chatMessageAdapter.chatThread == null) {
            chatMessageAdapter.chatThread = chatThread
        }
        viewModel.recruiterObject?.put(ParseTableFields.CURRENT_THREAD_ID.value, chatThread!!.threadId)
        viewModel.recruiterObject?.saveInBackground {
            if (it != null) {
                toast(it.message.toString()+" Something Went Wrong.")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // unsubscribe live query of message table
        parseLiveQueryClient?.unsubscribe(pqMessage, subscriptionHandling)

        viewModel.recruiterObject?.put(ParseTableFields.CURRENT_THREAD_ID.value, "")
        viewModel.recruiterObject?.saveInBackground {
            if (it != null) {
                toast(it.message.toString()+" Something Went Wrong.")
            }
        }
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
                        chatMessages.last { message -> message.senderId != getUserId() }.apply {
                            val seenByList = if (this.seenBy.isNotEmpty()){
                                this.seenBy as ArrayList
                            }else{
                                arrayListOf()
                            }
                            if (!seenBy.contains(getUserId())){
                                seenByList.add(getUserId())
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


    private fun setClickListeners() {
        animation()
        binding.ivBackButton.setOnClickListener {onBackPressed() }
        binding.llSentBtn.setOnClickListener {
            if (binding.etMessageText.text.isNullOrEmpty()) {
                //toast("Please type something in message.")
            } else {
                sendTextMessage()
            }
        }
        binding.civUser.setOnClickListener {
            RecruiterRecruitmentSeekerProfileDialogFragment.getInstance(recruitmentSeeker!!).show(supportFragmentManager, "RecruiterRecruitmentSeekerProfile")
        }
        binding.ivReport.setOnClickListener { ReportDialog(this){ submitReport(it) }.show() }
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
                countDownTimer?.cancel()
                countDownTimer = null
            }
            binding.clAudioAction.visibility = View.GONE
        }
        binding.ivSendAudio.setOnClickListener {
            stopRecording()
        }
    }

    private fun submitReport(reason: String) {
        chatThread?.jobSeekerId.let {
            val request = hashMapOf<String, Any>(
                "reportedTo" to chatThread!!.jobSeekerId,
                "reportedBy" to getUserId(),
                "type" to ReportType.RECRUITER_TO_JOB_SEEKER.value,
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
            binding.tvRecordingTitle.text = "0:0"
            setTimer()
            countDownTimer?.start()
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
            countDownTimer?.cancel()
            countDownTimer = null
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
                it.senderId = getUserId()
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

    private fun setupImagePicker(imageCode: Int, imagePickerType: Int) {
        imagePicker = ImagePicker(this, imageCode, imagePickerType)
        imagePicker.show( supportFragmentManager, imagePicker.tag)
    }

    override fun setImageUri(imageUri: Uri?, imageCode: Int) {
        imageUri?.let { uri ->
            lifecycleScope.launch(Dispatchers.IO){
                when (imageCode) {
                    PROFILE_IMAGE_REQUEST_CODE -> {
                        uploadImageToParse(uri, this@RecruiterChatBoardActivity,
                            { exception ->
                                toast(exception)
                            },
                            { url ->
                                setMessageImage(url)
                            })
                    }
                    else -> {}
                }
            }
        }
    }

    private fun setMessageImage(imageUrl: String) {
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
            log("fldsfjl ${ct.threadId}")
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
            ParseTableFields.RECIEVER_ID.value to recruitmentSeeker!!.jobSeekerId ,
            ParseTableFields.TYPE.value to 2
        )
        ParseCloud.callFunctionInBackground(ParseCloudFunction.SEND_MSG_NOTIFICATION.value, request, FunctionCallback<Any> { result, e ->
            when{
                e != null -> toast(e.message.toString()+" Something Went Wrong.")
                result == null -> toast("Something Went Wrong.")
                else -> {}
            }
        })
    }


    private fun animation() {
        alphaAnimator = ObjectAnimator.ofFloat(binding.tvRecordingTitle,  "alpha", 1f, 0.5f)
        alphaAnimator?.repeatCount = ObjectAnimator.INFINITE
        alphaAnimator?.duration = 2000
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
            log("dlsfdlk")
            message.toParseObject().saveInBackground {
                if (it != null) {
                    toast("${it.message.toString()}  Something went wrong")
                } else {
                    binding.etMessageText.text.clear()
                    sendMessageNotification()
                    ct.chatThreadParseObject?.apply {
                        this.put(ParseTableFields.JS_Filter.value, 1)
                        this.put(ParseTableFields.LATEST_TEXT.value, message.text)
                        this.saveInBackground { exception ->
                            exception?.let { toast(exception.message.toString()+" Something Went Wrong") }
                        }
                    }
                }
            }
        }
    }


    private fun setTimer(millisInFuture: Int = 100000) {
        var i = 0
        countDownTimer = object : CountDownTimer(millisInFuture.toLong(), 1000){
            override fun onTick(p0: Long) {
                binding.tvRecordingTitle.text =  convertMillisToMinuteAndSecond( (i * 1000).toLong())
                i++
            }
            @RequiresApi(Build.VERSION_CODES.M)
            override fun onFinish() {}
        }
    }


    private fun setParseLiveQuery() {
        pqMessage = ParseQuery<ParseObject>(ParseTableName.MESSAGE.value)
        pqMessage?.whereEqualTo(ParseTableFields.THREAD_ID.value, chatThread!!.threadId)
        parseLiveQueryClient = MyParseLiveQueryClient.parseLiveQueryClient
        subscriptionHandling = MyParseLiveQueryClient.parseLiveQueryClient.subscribe(pqMessage)
        subscriptionHandling?.let {
            subscriptionHandling!!.handleSubscribe {
                subscriptionHandling!!.handleEvent(SubscriptionHandling.Event.CREATE) { _: ParseQuery<ParseObject?>?, result: ParseObject? ->
                    result?.let {
                        println("fsjlfjlsd")
                        val newMessage = Message(it)
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
                subscriptionHandling!!.handleEvent(SubscriptionHandling.Event.DELETE) { _: ParseQuery<ParseObject?>?, result: ParseObject? ->

                }
                subscriptionHandling!!.handleEvent(SubscriptionHandling.Event.UPDATE) { _: ParseQuery<ParseObject?>?, result: ParseObject? ->
                    result?.let {
                        val updatedMessage = Message(it)
                        try {
                            chatMessages.first { message -> message.messageId == updatedMessage.messageId }.apply {
                                if (updatedMessage.senderId == getUserId()){
                                    this.seenBy = updatedMessage.seenBy
                                    val index = chatMessages.indexOf(this)
                                    lifecycleScope.launch(Dispatchers.Main){
                                        chatMessageAdapter.notifyItemChanged(index)
                                    }
                                }
                            }
                        }catch (e: Exception){}
                    }
                }
            }
        }
    }

}

class RecruiterChatMessageAdapter(
    var list: ArrayList<Message>,
    val requireContext: Context,
    var chatThread: ChatThread?
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
                        ct.jobSeekerParseObject?.let {
                            val jobSeeker = JobSeeker(it )
                            if (messageItem.seenBy.contains(jobSeeker.jobSeekerId)){
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
                        ct.jobSeekerParseObject?.let {
                            val jobSeeker = JobSeeker(it )
                            if (messageItem.seenBy.contains(jobSeeker.jobSeekerId)){
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
                        ct.jobSeekerParseObject?.let {
                            val jobSeeker = JobSeeker(it )
                            if (messageItem.seenBy.contains(jobSeeker.jobSeekerId)){
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