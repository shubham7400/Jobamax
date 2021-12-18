package com.findajob.jobamax.recruiter.profile.account.deleteAccount


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.MainActivity
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentRecruiterDeleteAccountFinalBinding
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.preference.clearUserPref
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.recruiter.profile.account.deleteAccount.adapter.LeavingReason
import com.findajob.jobamax.util.errorToast

class RecruiterDeleteAccountFinalFragment :
    BaseFragmentMain<FragmentRecruiterDeleteAccountFinalBinding>(),
    RecruiterDeleteAccountFinalInterface {

    val viewModel: RecruiterHomeViewModel by activityViewModels()

    override val layoutRes: Int
        get() = R.layout.fragment_recruiter_delete_account_final

    override fun onCreated(savedInstance: Bundle?) {
        binding.handler = this
        observeLiveData()
    }

    override fun getViewModel(): ViewModel? {
        return viewModel
    }

    private fun observeLiveData() {
        observeDeleteStatus()
    }

    private fun observeDeleteStatus() {
        observe(viewModel.deleteAccountLiveData) {
            showLoading(false)
            if (it == true) {
                requireActivity().clearUserPref()
                startActivity(Intent(requireActivity(), MainActivity::class.java))
                requireActivity().finishAffinity()
            } else {
                requireActivity().errorToast()
            }
        }
    }

    override fun onDeleteAccount() {
        val reasons = arguments?.getString(LeavingReason::class.simpleName)
        showLoading(true)
        viewModel.deleteAccount(reasons)
    }

    override fun onBackPress() {
        requireActivity().onBackPressed()
    }

}

interface RecruiterDeleteAccountFinalInterface {
    fun onDeleteAccount()
    fun onBackPress()
}