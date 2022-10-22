package com.jobamax.appjobamax.jobseeker.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import com.google.gson.Gson
import com.jobamax.appjobamax.NewSplashActivity
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentSeekerProfileBinding
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity
import com.jobamax.appjobamax.jobseeker.profile.account.SeekerSettingActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.model.University
import com.jobamax.appjobamax.preference.clearUserPref
import com.jobamax.appjobamax.util.loadImageFromUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeekerProfileFragment : BaseFragment() {
    lateinit var binding: FragmentSeekerProfileBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()
    lateinit var jobSeeker: JobSeeker

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerProfileBinding.inflate(inflater, container, false)
        configureUi()
        Log.i("TAG", "onCreateView: SeekerNewProfileFragment")
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setObserver()
        setJobSeeker()
        setData()
    }

    private fun setJobSeeker() {
        jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null) {
            try {
                (requireActivity() as JobSeekerHomeActivity).getJobSeeker {
                    if (it) {
                        jobSeeker = viewModel.jobSeeker
                        setData()
                    }
                }
            }catch (e: Exception){ }
        }
    }

    private fun setObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner){
            if (it){
                jobSeeker = viewModel.jobSeeker
                setData()
            }
        }
    }

    private fun setData() {
        loadImageFromUrl(binding.civUser, jobSeeker.profilePicUrl, R.drawable.default_user_img)

        if (jobSeeker.firstName.isEmpty()) {
            binding.tvUserName.visibility = View.GONE
            binding.tvUserName.text = jobSeeker.firstName+" "+jobSeeker.lastName
        }else{
            binding.tvUserName.visibility = View.VISIBLE
            binding.tvUserName.text = jobSeeker.firstName+" "+jobSeeker.lastName
        }

        if (jobSeeker.university.isEmpty()){
            binding.tvUniversityName.visibility = View.GONE
            binding.ivUniversity.visibility = View.GONE
            binding.tvUniversityName.text = jobSeeker.university
        }else{
            binding.tvUniversityName.visibility = View.VISIBLE
            binding.ivUniversity.visibility = View.VISIBLE
            val university = gson.fromJson(jobSeeker.university, University::class.java)
            if (university != null) {
                binding.tvUniversityName.text = university.name
            }
        }
    }


    private val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        (activity as JobSeekerHomeActivity).getJobSeeker {    }
    }


    private fun setClickListeners() {
        binding.btnDownloadCv.setOnClickListener {
            val intent = Intent(requireContext(), SeekerCreateCvActivity::class.java)
            resultContract.launch(intent)
         }
        binding.btnLogout.setOnClickListener {
            logout()
        }
        binding.btnCoaching.setOnClickListener {
            startActivity(Intent(requireContext(), SeekerCoachingActivity::class.java))
         }
        binding.ivSetting.setOnClickListener {
            startActivity(Intent(requireContext(), SeekerSettingActivity::class.java))
         }
    }

    private fun logout() {
        requireActivity().clearUserPref()
        startActivity(Intent(requireContext(), NewSplashActivity::class.java))
        requireActivity().finish()
    }
}