package com.jobamax.appjobamax.jobseeker.profile.account.deleteAccount

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.jobamax.appjobamax.MainActivity
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.databinding.FragmentSeekerDeleteAccountFinalBinding
import com.jobamax.appjobamax.dialog.DeleteAccountDialog
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.extensions.observe
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.preference.clearUserPref
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.util.errorToast
import com.jobamax.appjobamax.util.log
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