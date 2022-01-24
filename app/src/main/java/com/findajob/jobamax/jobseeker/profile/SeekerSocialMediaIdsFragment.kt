package com.findajob.jobamax.jobseeker.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerAboutMeBinding
import com.findajob.jobamax.databinding.FragmentSeekerSocialMediaIdsBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.util.toast


class SeekerSocialMediaIdsFragment : BaseFragmentMain<FragmentSeekerSocialMediaIdsBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_social_media_ids
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerSocialMediaIdsBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        binding.jobSeeker = viewModel.jobSeeker
        setClickListeners()
        viewModelObserver()
    }

    private fun viewModelObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner, Observer {
            if(it){
                binding.jobSeeker = viewModel.jobSeeker
            }
        })
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
         binding.btnSave.setOnClickListener {
             val instagramLink = if(binding.etInstagramLink.text.isNullOrBlank()) "" else binding.etInstagramLink.text.toString()
             val linkedInLink = if(binding.etLinkedinLink.text.isNullOrBlank()) "" else binding.etLinkedinLink.text.toString()
             val tikTokLink = if(binding.etTiktokLink.text.isNullOrBlank()) "" else binding.etTiktokLink.text.toString()
            viewModel.saveSocialMediaLinks(instagramLink, linkedInLink, tikTokLink) {
                when {
                    it != null -> {
                        toast("${it.message.toString()}")
                    }
                    else -> {
                        toast("Saved Successfully.")
                        requireActivity().onBackPressed()
                    }
                }
            }
         }
    }

    override fun onCreated(savedInstance: Bundle?) {

    }

}