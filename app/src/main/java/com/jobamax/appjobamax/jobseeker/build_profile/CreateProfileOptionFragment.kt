package com.jobamax.appjobamax.jobseeker.build_profile

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentCreateProfileOptionBinding
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.util.changeColorOfSubString


class CreateProfileOptionFragment : Fragment() {
    lateinit var binding: FragmentCreateProfileOptionBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()
    lateinit var jobSeeker: JobSeeker


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
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
                    setName()
                }
            }
        }else{
            jobSeeker = viewModel.jobSeeker
            setName()
        }
    }

    private fun setName() {
        val msg = "Hello ${jobSeeker.firstName},"
        binding.tvUserName.text = changeColorOfSubString(msg, 5, msg.length - 1, resources.getColor(R.color.colorAccent, null))
    }


    private fun setClickListeners() {
        binding.btnPersonalise.setOnClickListener { findNavController().navigate(R.id.action_createProfileOptionFragment_to_createCVFragment, null) }
        binding.btnManual.setOnClickListener { findNavController().navigate(R.id.action_createProfileOptionFragment_to_manualFilterFragment, null) }
    }

}