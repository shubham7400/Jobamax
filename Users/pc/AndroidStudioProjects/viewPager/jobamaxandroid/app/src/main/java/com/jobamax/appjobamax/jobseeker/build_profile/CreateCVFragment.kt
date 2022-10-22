package com.jobamax.appjobamax.jobseeker.build_profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentCreateCVBinding


class CreateCVFragment : Fragment() {
    lateinit var binding: FragmentCreateCVBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCreateCVBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.btnImportResumeFromLinkedin.setOnClickListener { findNavController().navigate(R.id.action_createCVFragment_to_importProfileFromLinkedIn, null) }
        binding.btnCreateCv.setOnClickListener { findNavController().navigate(R.id.action_createCVFragment_to_profilePreviewFragment, null) }
    }

}