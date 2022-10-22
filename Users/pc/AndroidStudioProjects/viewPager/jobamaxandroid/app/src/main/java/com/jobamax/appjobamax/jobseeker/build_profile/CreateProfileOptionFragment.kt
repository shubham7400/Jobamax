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
import com.jobamax.appjobamax.databinding.FragmentCreateProfileOptionBinding
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker
import java.lang.Exception


class CreateProfileOptionFragment : Fragment() {
    lateinit var binding: FragmentCreateProfileOptionBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()
    lateinit var jobSeeker: JobSeeker


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCreateProfileOptionBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         setClickListeners()
        setJobSeeker()
    }

    private fun setJobSeeker() {
        jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null) {
            (requireActivity() as BuildProfileActivity).getJobSeeker {
                if (it) {
                    jobSeeker = viewModel.jobSeeker
                    binding.tvUserName.text = "Hello ${jobSeeker.firstName},"
                }
            }
        }else{
            jobSeeker = viewModel.jobSeeker
            binding.tvUserName.text = "Hello ${jobSeeker.firstName},"
        }
    }

    private fun setClickListeners() {
        binding.btnPersonalise.setOnClickListener { findNavController().navigate(R.id.action_createProfileOptionFragment_to_createCVFragment, null) }
        binding.btnManual.setOnClickListener { findNavController().navigate(R.id.action_createProfileOptionFragment_to_manualFilterFragment, null) }
    }

}