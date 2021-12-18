package com.findajob.jobamax.recruiter.profile.account.deleteAccount

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentRecruiterDeleteAccountBinding
import com.findajob.jobamax.recruiter.profile.account.deleteAccount.adapter.LeavingReason
import com.findajob.jobamax.recruiter.profile.account.deleteAccount.adapter.LeavingReasonAdapter
import com.findajob.jobamax.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecruiterDeleteAccountFragment : BaseFragmentMain<FragmentRecruiterDeleteAccountBinding>(),
    RecruiterDeleteAccountInterface {

    private lateinit var navController: NavController
    private val leavingAdapter: LeavingReasonAdapter by lazy {
        LeavingReasonAdapter()
    }
    override val layoutRes: Int
        get() = R.layout.fragment_recruiter_delete_account

    override fun getViewModel(): ViewModel? {
        return null
    }

    override fun onCreated(savedInstance: Bundle?) {
        navController = findNavController()
        initUi()
    }

    private fun initUi() {
        initRvLeaveReason()
        binding.handler = this
    }

    private fun initRvLeaveReason() {
        leavingAdapter.collection =
            resources.getStringArray(R.array.leaving_reason).map { LeavingReason(it, false) }

        binding.apply {
            rvReason.adapter = leavingAdapter
        }
    }

    override fun onBackPress() {
        requireActivity().onBackPressed()
    }

    override fun onContinue() {
        val reasons = leavingAdapter.fetchLeavingReason()
        val args = Bundle()
        if (reasons.isEmpty()) {
            toast(getString(R.string.please_select_reason))
            return
        }
        args.putString(LeavingReason::class.simpleName, reasons.toString())
        navController.navigate(
            R.id.action_recruiterDeleteAccountFragment_to_recruiterDeleteAccountFinalFragment,
            args
        )
    }

    override fun onSkip() {
        navController.navigate(R.id.action_recruiterDeleteAccountFragment_to_recruiterDeleteAccountFinalFragment)
    }

}