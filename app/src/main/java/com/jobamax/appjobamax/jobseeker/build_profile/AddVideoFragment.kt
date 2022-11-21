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
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentAddVideoBinding
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker


class AddVideoFragment : BaseFragment() {
    lateinit var binding: FragmentAddVideoBinding

    lateinit var jobSeeker: JobSeeker

    val viewModel: SeekerHomeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAddVideoBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        initializeJobSeeker()
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.ivPlayBtn.setOnClickListener {
            playVideo()
        }
        binding.ivRemoveVideo.setOnClickListener {
            viewModel.jobSeekerObject?.put(ParseTableFields.INTRO_VIDEO_URL.value, "")
            progressHud.show()
            viewModel.jobSeekerObject?.saveInBackground {
                progressHud.dismiss()
                if (it == null) {
                    try {
                        (requireActivity() as BuildProfileActivity).getJobSeeker { }
                    }catch (e: Exception){
                        try {
                            (requireActivity() as SeekerCreateCvActivity).getJobSeeker { }
                        }catch (e: java.lang.Exception){
                            try {
                                (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker { }
                            }catch (e: Exception){ }
                        }
                    }
                    findNavController().navigate(R.id.action_addVideoFragment_to_pickVideoFragment, null)
                }else{
                    toast(it.message.toString()+" Something Went Wrong.")
                }
            }
        }
        binding.tvPlayBtn.setOnClickListener {
            playVideo()
        }
        binding.tvRetakeBtn.setOnClickListener {
            findNavController().navigate(R.id.action_addVideoFragment_to_pickVideoFragment, null)
        }
        binding.btnValidate.setOnClickListener {
            findNavController().navigate(R.id.action_addVideoFragment_to_videoDemoFragment, null)
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

    private fun initializeJobSeeker() {
        jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null) {
            (requireActivity() as BuildProfileActivity).getJobSeeker {
                if (it) {
                    jobSeeker = viewModel.jobSeeker
                }
            }
        }
    }

}