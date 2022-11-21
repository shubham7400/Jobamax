package com.jobamax.appjobamax.jobseeker.build_profile

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentPickAudioBinding
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.util.convertAudioToByteArray
import com.jobamax.appjobamax.util.convertMillisToMinuteAndSecond
import com.parse.ParseFile
import com.parse.SaveCallback
import java.io.IOException
import java.lang.Exception


class PickAudioFragment : BaseFragment() {
    lateinit var binding: FragmentPickAudioBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()

    private var audioUrl = ""
    private var mStartRecording = true
    private var fileName: String = ""
    private var recorder: MediaRecorder? = null
    var countDownTimer: CountDownTimer? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPickAudioBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         setClickListeners()
        fileName = "${requireActivity().filesDir!!.absolutePath}/userAudio.3gp"
    }

    private fun setClickListeners() {
        binding.clAudioIntro.setOnClickListener {
            findNavController().navigate(R.id.action_pickAudioFragment_to_addAudioFragment, null)
        }
        binding.clAudioIntro.setOnClickListener {
            onRecord(mStartRecording)
        }
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
    }

    private fun onRecord(start: Boolean) {
        if (ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),  arrayOf(Manifest.permission.RECORD_AUDIO) ,  RECORD_AUDIO)
        } else {
            if (start) { startRecording() } else { stopRecording() }
        }
    }

    private fun startRecording() {
        binding.tvAudioTime.visibility = View.VISIBLE
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
            mStartRecording = true
        }
        recorder = null
        uploadAudio()
    }

    private fun uploadAudio() {
        val parseFile = ParseFile("portfolioAudio.m4a", convertAudioToByteArray(fileName))
        parseFile.saveInBackground(SaveCallback {
            if (it != null){
                toast(it.message.toString())
            }else{
                audioUrl = parseFile.url
                saveIntroAudio()
            }
        })
    }

    private fun setTimer(millisInFuture: Int = 32000) {
        var i = 0
        countDownTimer = object : CountDownTimer(millisInFuture.toLong(), 1000){
            override fun onTick(p0: Long) {
                binding.tvAudioTime.text =  convertMillisToMinuteAndSecond( (i * 1000).toLong())
                i++
            }
            @RequiresApi(Build.VERSION_CODES.M)
            override fun onFinish() {
                if (!mStartRecording){
                    stopRecording()
                }
            }
        }
    }

    private fun saveIntroAudio() {
        viewModel.jobSeekerObject?.put(ParseTableFields.INTRO_AUDIO_URL.value, audioUrl)
        progressHud.show()
        viewModel.jobSeekerObject?.saveInBackground {
            progressHud.dismiss()
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
                findNavController().navigate(R.id.action_pickAudioFragment_to_addAudioFragment, null)
            }
        }
    }


}