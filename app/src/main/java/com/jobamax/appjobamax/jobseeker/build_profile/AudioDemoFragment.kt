package com.jobamax.appjobamax.jobseeker.build_profile

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentAudioDemoBinding
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.util.convertMillisToMinuteAndSecond
import java.io.IOException
import java.lang.Exception


class AudioDemoFragment : Fragment() {
    lateinit var binding: FragmentAudioDemoBinding

    lateinit var jobSeeker: JobSeeker

    var player: MediaPlayer? = null
    private var mStartPlaying = true
    var mUpdateSeekbar: Runnable? = null
    private val mSeekbarUpdateHandler: Handler = Handler()

    val viewModel: SeekerHomeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAudioDemoBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        initializeJobSeeker()
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
        if (jobSeeker.introAudioUrl.isEmpty()){
            binding.clAudioPlayer.visibility = View.GONE
        }else{
            initializePlayer()
        }
    }

    private fun setClickListeners() {
        binding.llVideo.setOnClickListener { findNavController().navigate(R.id.action_audioDemoFragment_to_videoDemoFragment, null) }
        binding.ivAudioPlayBtn.setOnClickListener {
            if (player != null) {
                onPlay(player!!.isPlaying)
            }else{
                onPlay(mStartPlaying)
            }
        }
        binding.btnGo.setOnClickListener {
            if (jobSeeker.introAudioUrl.isEmpty()){
                findNavController().navigate(R.id.action_audioDemoFragment_to_pickAudioFragment, null)
            }else{
                findNavController().navigate(R.id.action_audioDemoFragment_to_addAudioFragment, null)
            }
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

}