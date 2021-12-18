package com.findajob.jobamax.jobseeker.profile.account.deleteAccount
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerDeleteAccountBinding
import com.findajob.jobamax.jobseeker.profile.account.deleteAccount.adapter.LeavingReason
import com.findajob.jobamax.jobseeker.profile.account.deleteAccount.adapter.LeavingReasonAdapter
import com.findajob.jobamax.util.toast

class SeekerDeleteAccountFragment : BaseFragmentMain<FragmentSeekerDeleteAccountBinding>(), SeekerDeleteAccountInterface {

    private lateinit var navController: NavController
    private val leavingAdapter: LeavingReasonAdapter by lazy {
        LeavingReasonAdapter()
    }


    override val layoutRes: Int
        get() = R.layout.fragment_seeker_delete_account

    override fun onCreated(savedInstance: Bundle?) {
        binding.handler = this
        navController = findNavController()
        initUi()
    }

    override fun getViewModel(): ViewModel? {
        return null
    }



    private fun initUi() {
        initRvLeaveReason()
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
            R.id.action_seekerDeleteAccountFragment_to_seekerDeleteAccountFinalFragment,
            args
        )
    }

    override fun onSkip() {
        navController.navigate(R.id.action_seekerDeleteAccountFragment_to_seekerDeleteAccountFinalFragment)
    }
}