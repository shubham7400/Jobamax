package com.jobamax.appjobamax.jobseeker.build_profile

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentAddAudioBinding
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.util.convertAudioToByteArray
import com.jobamax.appjobamax.util.convertMillisToMinuteAndSecond
import com.parse.ParseFile
import com.parse.SaveCallback
import java.io.IOException
import java.lang.Exception


const val RECORD_AUDIO = 5
class AddAudioFragment : Fragment() {
    lateinit var binding: FragmentAddAudioBinding

    lateinit var jobSeeker: JobSeeker

    val viewModel: SeekerHomeViewModel by activityViewModels()

    private var audioUrl = ""
    private var mStartRecording = true
    private var fileName: String = ""
    private var recorder: MediaRecorder? = null
    var countDownTimer: CountDownTimer? = null

    var player: MediaPlayer? = null
    private var mStartPlaying = true
    var mUpdateSeekbar: Runnable? = null
    private val mSeekbarUpdateHandler: Handler = Handler()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddAudioBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun configureUi() {
        setClickListeners()
        initializeJobSeeker()
        setObserver()
        fileName = "${requireActivity().filesDir!!.absolutePath}/userAudio.3gp"
        initializePlayer()
    }

    private fun setObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner){
            if (it){
                jobSeeker = viewModel.jobSeeker
                audioUrl = jobSeeker.introAudioUrl
                player = null
                if (audioUrl.isEmpty()){
                    binding.tvRetakeBtn.text = resources.getString(R.string.record)
                }
            }
        }
    }

    private fun initializeJobSeeker() {
        jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null) {
            (requireActivity() as BuildProfileActivity).getJobSeeker {
                if (it) {
                    jobSeeker = viewModel.jobSeeker
                    if (audioUrl.isEmpty()){
                        binding.tvRetakeBtn.text = resources.getString(R.string.record)
                    }
                }
            }
        }
        audioUrl = jobSeeker.introAudioUrl
        if (audioUrl.isEmpty()){
            binding.tvRetakeBtn.text = resources.getString(R.string.record)
        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun setClickListeners() {
        binding.tvRetakeBtn.setOnClickListener {
            onRecord(mStartRecording)
        }
        binding.tvPlayBtn.setOnClickListener {
            onPlay(mStartPlaying)
        }
        binding.ivAudioPlayBtn.setOnClickListener {
            onPlay(mStartPlaying)
        }
        binding.ivRemoveAudio.setOnClickListener {
            player?.let {
                it.stop()
                it.release()
            }
            audioUrl = ""
            player = null
            saveIntroAudio()
        }
        binding.btnSave.setOnClickListener {
            saveIntroAudio()
        }
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun onRecord(start: Boolean) {
        if (ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),  arrayOf(Manifest.permission.RECORD_AUDIO) ,  RECORD_AUDIO)
        } else {
            if (start) { startRecording() } else { stopRecording() }
        }
    }
    private fun onPlay(start: Boolean) = if (start) {
        if (player != null){
            initializePlayer()
            player!!.start()
        }else{
            initializePlayer()
            player!!.start()
        }
    } else { stopPlaying() }


    private fun startRecording() {
        stopPlaying()
        player = null
        binding.tvRetakeBtn.text = resources.getString(R.string.stop)
        binding.tvAudioTime.visibility = View.VISIBLE
        mStartRecording = false
        recorder = MediaRecorder(requireContext()).apply {
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
        recorder?.let {
            it.start()
            setTimer()
            try {
                countDownTimer?.start()
            }catch (e: Exception){}
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun stopRecording() {
        binding.tvAudioTime.visibility = View.GONE
        binding.pbAudioRecording.progress = 0
        try {
            countDownTimer?.cancel()
        }catch (e: Exception){}
        recorder?.apply {
            stop()
            release()
            binding.tvRetakeBtn.text = resources.getString(R.string.retake)
            mStartRecording = true
        }
        recorder = null
        uploadAudio()
    }

    private fun initializePlayer() {
        if (player != null){
            mStartPlaying = false
            binding.ivAudioPlayBtn.setImageResource(R.drawable.pause)
        }else{
            player = MediaPlayer().apply {
                try {
                    setDataSource(audioUrl)
                    prepare()
                    mStartPlaying = false
                    binding.ivAudioPlayBtn.setImageResource(R.drawable.pause)
                } catch (e: IOException) {
                    log(  "prepare() failed")
                }
            }
        }

        binding.tvAudioDuration.text = player?.duration?.toLong()?.let { convertMillisToMinuteAndSecond(it) }



        mUpdateSeekbar  = object : Runnable {
            override fun run() {
                binding.sbAudio.progress = player?.currentPosition ?: 0
                binding.tvAudioDurationProgress.text = convertMillisToMinuteAndSecond((binding.sbAudio.progress).toLong())
                mSeekbarUpdateHandler.postDelayed(this, 0)
            }
        }

        binding.sbAudio.max = player!!.duration
        mSeekbarUpdateHandler.postDelayed(mUpdateSeekbar!!, 0)

        player?.setOnCompletionListener {
            binding.sbAudio.progress = 0
            binding.tvAudioDurationProgress.text = "0:0"
            binding.ivAudioPlayBtn.setImageResource(R.drawable.play)
            mStartPlaying = true
        }
    }

    private fun stopPlaying() {
        try {
            player?.pause()
            mStartPlaying = true
            binding.ivAudioPlayBtn.setImageResource(R.drawable.play)
            mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar!!)
        }catch (e: Exception){}
    }


    private fun setTimer(millisInFuture: Int = 32000) {
        if (millisInFuture == 32000){
            binding.pbAudioRecording.max = 30
        }else{
            binding.pbAudioRecording.max = (millisInFuture / 1000)
        }
        binding.pbAudioRecording.progress = 0
        var i = 0
        countDownTimer = object : CountDownTimer(millisInFuture.toLong(), 1000){
            override fun onTick(p0: Long) {
                if (i < 31){
                    binding.pbAudioRecording.progress = i++
                    binding.tvAudioTime.text =  "$i sec"
                    binding.tvAudioTime.visibility = View.VISIBLE
                }
            }
            @RequiresApi(Build.VERSION_CODES.M)
            override fun onFinish() {
                if (!mStartRecording){
                    stopRecording()
                }
            }
        }
    }

    private fun uploadAudio() {
        val parseFile = ParseFile("portfolioAudio.m4a", convertAudioToByteArray(fileName))
        parseFile.saveInBackground(SaveCallback {
            if (it != null){
                toast(it.message.toString())
            }else{
                audioUrl = parseFile.url
                player = null
            }
        })
    }

    private fun saveIntroAudio() {
        viewModel.jobSeekerObject?.put("introAudioUrl", audioUrl)
        viewModel.jobSeekerObject?.saveInBackground {
            if (it != null){
                toast(it.message.toString())
            }else{
                try {
                    (requireActivity() as BuildProfileActivity).getJobSeeker { }
                }catch (e: Exception){
                    try {
                        (requireActivity() as SeekerCreateCvActivity).getJobSeeker { }
                    }catch (e: Exception){
                        (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker { }
                    }
                }
                findNavController().navigate(R.id.action_addAudioFragment_to_audioDemoFragment, null)
            }
        }
    }

}