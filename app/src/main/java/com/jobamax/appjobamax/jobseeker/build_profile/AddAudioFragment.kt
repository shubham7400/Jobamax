package com.jobamax.appjobamax.jobseeker.build_profile

import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentAddAudioBinding
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.util.convertMillisToMinuteAndSecond
import java.io.IOException
import java.lang.Exception


const val RECORD_AUDIO = 5
class AddAudioFragment : BaseFragment() {
    lateinit var binding: FragmentAddAudioBinding

    lateinit var jobSeeker: JobSeeker

    val viewModel: SeekerHomeViewModel by activityViewModels()

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
    }

    private fun setObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner){
            if (it){
                jobSeeker = viewModel.jobSeeker
                player = null
            }
        }
    }

    private fun initializeJobSeeker() {
        jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null) {
            (requireActivity() as BuildProfileActivity).getJobSeeker {
                if (it) {
                    jobSeeker = viewModel.jobSeeker
                    setData()
                }
            }
        }else{
            setData()
        }
    }

    private fun setData() {
        if (jobSeeker.introAudioUrl.isNotEmpty()){
            initializePlayer()
        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun setClickListeners() {
        binding.tvRetakeBtn.setOnClickListener {
            saveIntroAudio()
        }
        binding.ivAudioPlayBtn.setOnClickListener {
            if (jobSeeker.introAudioUrl.isNotEmpty()){
                if (player != null) {
                    onPlay(player!!.isPlaying)
                }else{
                    onPlay(mStartPlaying)
                }
            }
        }
        binding.ivRemoveAudio.setOnClickListener {
            player?.let {
                it.stop()
                it.release()
            }
            player = null
            saveIntroAudio()
        }
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }


    private fun onPlay(start: Boolean) = if (start) {
        stopPlaying()
    } else {
        if (player != null){
            initializePlayer()
            binding.ivAudioPlayBtn.setImageResource(R.drawable.ic_pause)
            player!!.start()
        }else{
            initializePlayer()
            binding.ivAudioPlayBtn.setImageResource(R.drawable.ic_pause)
            player!!.start()
        }
    }

    private fun initializePlayer() {
        if (player == null){
            player = MediaPlayer().apply {
                try {
                    setDataSource(jobSeeker.introAudioUrl)
                    prepare()
                    mStartPlaying = false
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
            binding.ivAudioPlayBtn.setImageResource(R.drawable.ic_play)
            mStartPlaying = true
        }
    }

    private fun stopPlaying() {
        try {
            player?.pause()
            mStartPlaying = true
            binding.ivAudioPlayBtn.setImageResource(R.drawable.ic_play)
            mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar!!)
        }catch (e: Exception){}
    }

    private fun saveIntroAudio() {
        viewModel.jobSeekerObject?.put("introAudioUrl", "")
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
                findNavController().navigate(R.id.action_addAudioFragment_to_pickAudioFragment, null)
            }
        }
    }

}