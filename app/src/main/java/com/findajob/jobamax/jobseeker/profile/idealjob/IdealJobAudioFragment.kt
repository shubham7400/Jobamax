package com.findajob.jobamax.jobseeker.profile.idealjob

import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.data.pojo.IdealJob
import com.findajob.jobamax.databinding.FragmentIdealJobAudioBinding
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.parse.ParseObject
import com.parse.ParseQuery
import java.io.ByteArrayOutputStream
import java.io.FileInputStream
import java.io.IOException
import java.lang.Exception


class IdealJobAudioFragment : BaseFragmentMain<FragmentIdealJobAudioBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_ideal_job_audio
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var idealJob: IdealJob? = null
    private var audioUrl = ""
    private var player: MediaPlayer? = null
    private var mStartRecording = true
    private var mStartPlaying = true
    private var fileName: String = ""
    private var recorder: MediaRecorder? = null
    var countDownTimer: CountDownTimer? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentIdealJobAudioBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
    }

    private fun getIdealJobData() {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.IdealJob.toString())
        query.whereEqualTo(ParseTableFields.jobSeeker.toString(), viewModel.jobSeeker.pfObject)
        query.include("jobSeeker")
        query.getFirstInBackground { result, e ->
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                result != null -> {
                    idealJob = IdealJob(result)
                    audioUrl = idealJob!!.audioUrl
                    setAudioButton()
                }
            }
        }
    }

    private fun setAudioButton() {
        if (audioUrl != "") {
            binding.btnPlay.visibility = View.VISIBLE
            binding.btnRetake.visibility = View.VISIBLE
            binding.btnRecord.visibility = View.GONE
        } else {
            binding.btnPlay.visibility = View.GONE
            binding.btnRetake.visibility = View.GONE
            binding.btnRecord.visibility = View.VISIBLE
        }
    }

    private fun setClickListeners() {
        binding.btnPlay.setOnClickListener {
            onPlay(mStartPlaying)
        }
        binding.btnRetake.setOnClickListener {
            onRecord(mStartRecording)
        }
        binding.btnRecord.setOnClickListener {
            onRecord(mStartRecording)
            mStartRecording = !mStartRecording
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

        player?.setOnCompletionListener {
            stopPlaying()
        }

    }


    private fun saveDataToParse() {
        if (idealJob == null){
            val portfolioParseObject = ParseObject(ParseTableName.IdealJob.toString())
            viewModel.jobSeeker.pfObject?.let { it1 ->
                portfolioParseObject.put("jobSeeker", it1)
            }
            portfolioParseObject.put("audioUrl", audioUrl)
            progressHud.show()
            portfolioParseObject.saveInBackground {
                progressHud.dismiss()
                if(it != null){
                    toast("${it.message.toString()}")
                }
            }
        }else{
            val portfolioParseObject = idealJob!!.pfObject
            portfolioParseObject?.let {
                viewModel.jobSeeker.pfObject?.let { it1 -> it.put("jobSeeker", it1) }
                it.put("audioUrl", audioUrl)
            }
            progressHud.show()
            portfolioParseObject?.saveInBackground {
                progressHud.dismiss()
                if(it != null){
                    toast("${it.message.toString()}")
                }
            }
        }
    }

    private fun onRecord(start: Boolean) = if (start) { startRecording() } else { stopRecording() }
    private fun onPlay(start: Boolean) = if (start) { startPlaying() } else { stopPlaying() }
    private fun startPlaying() {
        binding.btnPlay.text = "Playing"
        player = MediaPlayer().apply {
            try {
                setDataSource(audioUrl)
                prepare()
                start()
            } catch (e: IOException) {
                log(  "prepare() failed")
            }
        }
        mStartPlaying = false
        setTimer(player!!.duration)
        countDownTimer?.start()
    }

    private fun stopPlaying() {
        countDownTimer?.cancel()
        mStartPlaying = true
        binding.btnPlay.text = "Play"
        player?.release()
        player = null
    }
    private fun startRecording() {
        binding.btnRetake.text = "Recording"
        mStartRecording = false
        setTimer()
        try {
            countDownTimer?.start()
        }catch (e: Exception){}
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
            start()
        }
    }

    private fun stopRecording() {
        binding.btnRetake.text = "Retake"
        mStartRecording = true
        try {
            countDownTimer?.cancel()
        }catch (e: Exception){}
        recorder?.apply {
            stop()
            release()
        }
        recorder = null
        uploadAudio()
    }

    private fun uploadAudio() {
        progressHud.show()
        viewModel.uploadUserAudio(convert(fileName), {
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
            }
        })
    }

    @Throws(IOException::class)
    fun convert(path: String): ByteArray? {
        val fis = FileInputStream(path)
        val bos = ByteArrayOutputStream()
        val b = ByteArray(1024)
        var readNum: Int
        while (fis.read(b).also { readNum = it } != -1) {
            bos.write(b, 0, readNum)
        }
        return bos.toByteArray()
    }

    override fun onStop() {
        super.onStop()
        recorder?.release()
        recorder = null
        player?.release()
        player = null
    }

    override fun onCreated(savedInstance: Bundle?) {
        fileName = "${requireActivity().filesDir!!.absolutePath}/userAudio.3gp"
        getIdealJobData()
        binding.jobSeeker = viewModel.jobSeeker
    }

}