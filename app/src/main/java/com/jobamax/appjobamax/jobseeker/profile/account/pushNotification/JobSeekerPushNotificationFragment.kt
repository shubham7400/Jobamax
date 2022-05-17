package com.jobamax.appjobamax.jobseeker.profile.account.pushNotification

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.databinding.FragmentJobSeekerPushNotificationBinding
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class JobSeekerPushNotificationFragment : BaseFragmentMain<FragmentJobSeekerPushNotificationBinding>(), JobSeekerPushNotificationInterface {

    val viewModel: JobSeekerHomeViewModel by activityViewModels()

    override val layoutRes: Int get() = R.layout.fragment_job_seeker_push_notification

    override fun onCreated(savedInstance: Bundle?) {
        binding.handler = this
        initViews()
    }

    private fun initViews() {

        binding.newMatchesFlag.isChecked = viewModel.jobSeeker.newMatchPNFlag
        binding.messageCheck.isChecked = viewModel.jobSeeker.messagePNFlag

        binding.newMatchesFlag.setOnCheckedChangeListener { _, isChecked ->
            viewModel.updateNewsMatchesPushNotificationFlag(isChecked)
        }

        binding.messageCheck.setOnCheckedChangeListener { _, isChecked ->
            viewModel.updateMessagePushNotificationFlag(isChecked)
        }

    }


    override fun getViewModel(): ViewModel = viewModel

    override fun onBackPress() {
        requireActivity().onBackPressed()
    }


}