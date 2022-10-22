package com.jobamax.appjobamax.jobseeker.build_profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentAudioDemoBinding
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker


class AudioDemoFragment : Fragment() {
    lateinit var binding: FragmentAudioDemoBinding

    lateinit var jobSeeker: JobSeeker

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
                }
            }
        }
    }

    private fun setClickListeners() {
        binding.llVideo.setOnClickListener { findNavController().navigate(R.id.action_audioDemoFragment_to_videoDemoFragment, null) }
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

}