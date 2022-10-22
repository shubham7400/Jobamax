package com.jobamax.appjobamax.recruiter.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentRecruiterProfileBinding
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.model.Recruiter
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel
import com.jobamax.appjobamax.recruiter.dialog.DialogSeePostJobOfferInfo
import com.jobamax.appjobamax.recruiter.profile.setting.RecruiterSettingActivity
import com.jobamax.appjobamax.util.loadImageFromUrl


class RecruiterProfileFragment : Fragment() {
    lateinit var binding: FragmentRecruiterProfileBinding

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    lateinit var recruiter: Recruiter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRecruiterProfileBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setObserver()
        initializeRecruiter()
    }

    private fun initializeRecruiter() {
        recruiter = viewModel.recruiter
        if (viewModel.recruiterObject == null) {
            (requireActivity() as RecruiterHomeActivity).getRecruiter {
                if (it) {
                    recruiter = viewModel.recruiter
                    setData()
                }
            }
        }
    }

    private fun setObserver() {
        viewModel.isRecruiterUpdated.observe(viewLifecycleOwner){
            if (it){
                recruiter = viewModel.recruiter
                setData()
            }
        }
    }

    private fun setData() {
        loadImageFromUrl(binding.civUser, recruiter.profilePicUrl, R.drawable.default_user_img)
    }

    private fun setClickListeners() {
        binding.tvPostJobOffer.setOnClickListener {  }
        binding.tvSeeJobOffer.setOnClickListener {  }
        binding.tvCompany.setOnClickListener {  }
        binding.ivSetting.setOnClickListener {
            startActivity(Intent(requireContext(), RecruiterSettingActivity::class.java))
        }
        binding.tvPostJobOffer.setOnClickListener { DialogSeePostJobOfferInfo(requireActivity()).show() }
        binding.tvSeeJobOffer.setOnClickListener { DialogSeePostJobOfferInfo(requireActivity()).show() }
        binding.tvCompany.setOnClickListener { DialogSeePostJobOfferInfo(requireActivity()).show() }
    }

}