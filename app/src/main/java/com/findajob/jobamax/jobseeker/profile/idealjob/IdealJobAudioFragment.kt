package com.findajob.jobamax.jobseeker.profile.idealjob

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.data.pojo.IdealJob
import com.findajob.jobamax.databinding.FragmentIdealJobAudioBinding
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.util.convertAudioToByteArray
import com.findajob.jobamax.util.convertMillisToMinuteAndSecond
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.parse.ParseObject
import java.io.ByteArrayOutputStream
import java.io.FileInputStream
import java.io.IOException
import java.lang.Exception

const val RECORD_AUDIO = 5
class IdealJobAudioFragment : BaseFragmentMain<FragmentIdealJobAudioBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_ideal_job_audio
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var idealJob: IdealJob? = null
    private var audioUrl = ""
    private var mStartRecording = true
    private var fileName: String = ""
    private var recorder: MediaRecorder? = null
    var countDownTimer: CountDownTimer? = null

    var player: MediaPlayer? = null
    private var mStartPlaying = true
    var mUpdateSeekbar: Runnable? = null
    private val mSeekbarUpdateHandler: Handler = Handler()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentIdealJobAudioBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
    }

    private fun getIdealJobData() {
        idealJob = viewModel.jobSeeker.idealJob?.let {
            IdealJob(it)
        }
        if (idealJob == null){
            val parseObject = ParseObject(ParseTableName.IdealJob.toString())
            idealJob = IdealJob(parseObject)
            idealJob!!.pfObject?.let { viewModel.jobSeeker.pfObject?.put("idealJob", it) }
            viewModel.jobSeeker.pfObject?.saveInBackground()
        }

        idealJob?.let {
            audioUrl = idealJob!!.audioUrl
            setAudioButton()
        }
    }

    private fun setAudioButton() {
        if (audioUrl != "") {
            binding.btnRecord.text = "Record"
         } else {
            binding.btnRecord.text = "Retake"
         }
    }

    private fun setClickListeners() {
        binding.civUser.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.btnRecord.setOnClickListener {
            onRecord(mStartRecording)
        }
        binding.ivAudioPlayBtn.setOnClickListener {
            onPlay(mStartPlaying)
        }
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
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
                }
            }
            override fun onFinish() {
                if (!mStartRecording){
                    stopRecording()
                }
            }
        }
    }


    private fun saveDataToParse() {
        idealJob?.pfObject?.put("audioUrl", audioUrl)
        idealJob?.pfObject?.saveInBackground {
            if (it != null){
                log(it.message.toString())
            }
        }
    }

    private fun onRecord(start: Boolean) {
        if (ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),  arrayOf(Manifest.permission.RECORD_AUDIO) ,  RECORD_AUDIO);
        } else {
            if (start) { startRecording() } else { stopRecording() }
        }
    }
    private fun onPlay(start: Boolean) = if (start) { startPlaying() } else { stopPlaying() }

    private fun startPlaying() {
        if (player != null){
            player!!.start()
            mStartPlaying = false
            binding.ivAudioPlayBtn.setImageResource(R.drawable.ic_pause_circle)
        }else{
            player = MediaPlayer().apply {
                try {
                    setDataSource(audioUrl)
                    prepare()
                    start()
                    mStartPlaying = false
                    binding.ivAudioPlayBtn.setImageResource(R.drawable.ic_pause_circle)
                } catch (e: IOException) {
                    log(  "prepare() failed")
                }
            }
        }

        mUpdateSeekbar  = object : Runnable {
            override fun run() {
                binding.sbAudio.progress = player!!.currentPosition
                binding.tvAudioDuration.text = convertMillisToMinuteAndSecond((player!!.duration - binding.sbAudio.progress).toLong())
                mSeekbarUpdateHandler.postDelayed(this, 0)
            }
        }

        binding.sbAudio.max = player!!.duration
        mSeekbarUpdateHandler.postDelayed(mUpdateSeekbar!!, 0)

        player?.setOnCompletionListener {
            binding.ivAudioPlayBtn.setImageResource(R.drawable.ic_play_circle_filled)
            mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar!!)
        }
    }

    private fun stopPlaying() {
        player?.pause()
        mStartPlaying = true
        binding.ivAudioPlayBtn.setImageResource(R.drawable.ic_play_circle_filled)
        mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar!!)
    }



    private fun startRecording() {
        binding.btnRecord.text = "Recording"
        mStartRecording = false
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
        recorder?.let {
            it.start()
            setTimer()
            try {
                countDownTimer?.start()
            }catch (e: Exception){}
        }

    }

    private fun stopRecording() {
        try {
            countDownTimer?.cancel()
        }catch (e: Exception){}
        recorder?.apply {
            stop()
            release()
            binding.btnRecord.text = "Record"
            mStartRecording = true
        }
        recorder = null
        uploadAudio()
    }

    private fun uploadAudio() {
        progressHud.show()
        viewModel.uploadUserAudio(convertAudioToByteArray(fileName), {
            progressHud.dismiss()
            if (it != null) {
                toast("${it.message.toString()}")
            }
        }, {
            progressHud.dismiss()
            if (it != null) {
                audioUrl = it
                setAudioButton()
                saveDataToParse()
                binding.btnRecord.text = "Retake"
                player = null
            }
        })
    }


    override fun onStop() {
        super.onStop()
        recorder?.release()
        recorder = null
    }

    override fun onCreated(savedInstance: Bundle?) {
        fileName = "${requireActivity().filesDir!!.absolutePath}/userAudio.3gp"
        getIdealJobData()
        binding.jobSeeker = viewModel.jobSeeker
    }

}