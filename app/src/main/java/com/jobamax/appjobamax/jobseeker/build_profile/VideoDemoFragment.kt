package com.jobamax.appjobamax.jobseeker.build_profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.VideoPlayActivity
import com.jobamax.appjobamax.databinding.FragmentVideoDemoBinding
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker


class VideoDemoFragment : Fragment() {
    lateinit var binding: FragmentVideoDemoBinding

    lateinit var jobSeeker: JobSeeker

    val viewModel: SeekerHomeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentVideoDemoBinding.inflate(inflater, container, false)
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
        if (jobSeeker.introVideoUrl.isEmpty()){
            binding.clVideo.visibility = View.GONE
        }
    }

    private fun playVideo() {
        if (jobSeeker.introVideoUrl.isNotEmpty()) {
            startActivity(
                Intent(
                    requireContext(),
                    VideoPlayActivity::class.java
                ).putExtra("video_url", jobSeeker.introVideoUrl)
            )
        } else {
            toast("Video does not exist.")
        }
    }


    private fun setClickListeners() {
        binding.llVideo.setOnClickListener {}
        binding.ivPlayBtn.setOnClickListener {
            playVideo()
        }
        binding.btnGo.setOnClickListener {
            if (jobSeeker.introVideoUrl.isEmpty()  ){
                findNavController().navigate(R.id.action_videoDemoFragment_to_pickVideoFragment, null)
            }else{
                findNavController().navigate(R.id.action_videoDemoFragment_to_addVideoFragment, null)
            }
        }
        binding.llAudio.setOnClickListener { findNavController().navigate(R.id.action_videoDemoFragment_to_audioDemoFragment, null) }
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
 }