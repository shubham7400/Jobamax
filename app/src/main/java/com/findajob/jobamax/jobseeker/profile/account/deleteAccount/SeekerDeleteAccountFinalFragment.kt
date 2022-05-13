package com.findajob.jobamax.jobseeker.profile.account.deleteAccount

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.MainActivity
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerDeleteAccountFinalBinding
import com.findajob.jobamax.dialog.DeleteAccountDialog
import com.findajob.jobamax.enums.ParseCloudFunction
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.preference.clearUserPref
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.errorToast
import com.findajob.jobamax.util.log
import com.parse.FunctionCallback
import com.parse.ParseCloud

class SeekerDeleteAccountFinalFragment : BaseFragmentMain<FragmentSeekerDeleteAccountFinalBinding>(), SeekerDeleteAccountFinalInterface {

    val viewModel: JobSeekerHomeViewModel by activityViewModels()

    override val layoutRes: Int get() = R.layout.fragment_seeker_delete_account_final

    override fun onCreated(savedInstance: Bundle?) {
        binding.handler = this
        observeLiveData()
    }

    override fun getViewModel(): ViewModel {
        return viewModel
    }

    private fun observeLiveData() {
        observeDeleteStatus()
    }

    private fun observeDeleteStatus() {
        observe(viewModel.deleteAccountLiveData) {
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
        val deleteAccountDialog = DeleteAccountDialog(requireActivity()) {
            progressHud.show()
            ParseCloud.callFunctionInBackground(ParseCloudFunction.DELETE_USER.value, hashMapOf( "jobSeekerId" to requireActivity().getUserId()), FunctionCallback<Any?> { response, e ->
                    progressHud.dismiss()
                    if (e == null) {
                        requireActivity().clearUserPref()
                        startActivity(Intent(requireActivity(), MainActivity::class.java))
                        requireActivity().finishAffinity()
                    } else {
                        log("Exception: $e", e)
                    }
                })
        }
        deleteAccountDialog.show()
    }

    override fun onBackPress() {
        requireActivity().onBackPressed()
    }
}

interface SeekerDeleteAccountFinalInterface {
    fun onDeleteAccount()
    fun onBackPress()
}