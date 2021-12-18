package com.findajob.jobamax.recruiter.profile.account.pushNotification

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentRecruiterPushNotificationBinding
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecruiterPushNotificationFragment :
    BaseFragmentMain<FragmentRecruiterPushNotificationBinding>(),
    RecruiterPushNotificationInterface {


    val viewModel: RecruiterHomeViewModel by activityViewModels()

    override val layoutRes: Int
        get() = R.layout.fragment_recruiter_push_notification

    override fun onCreated(savedInstance: Bundle?) {
        initViews()
    }

    private fun initViews() {
        binding.handler = this

        binding.newMatchesFlag.isChecked = viewModel.recruiter.newMatchPNFlag
        binding.messageCheck.isChecked = viewModel.recruiter.messagePNFlag

        binding.newMatchesFlag.setOnCheckedChangeListener { _, isChecked ->
            viewModel.updateNewsMatchesPushNotificationFlag(isChecked)
        }

        binding.messageCheck.setOnCheckedChangeListener { _, isChecked ->
            viewModel.updateMessagePushNotificationFlag(isChecked)
        }

    }

    override fun getViewModel(): ViewModel = viewModel

    override fun onBackPress() {
        findNavController().navigateUp()
    }


}