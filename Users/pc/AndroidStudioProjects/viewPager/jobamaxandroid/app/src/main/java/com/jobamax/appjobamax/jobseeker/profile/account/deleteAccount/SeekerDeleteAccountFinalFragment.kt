package com.jobamax.appjobamax.jobseeker.profile.account.deleteAccount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jobamax.appjobamax.base.BaseFragment
 import com.jobamax.appjobamax.databinding.FragmentSeekerDeleteAccountFinalBinding
import com.jobamax.appjobamax.dialog.DeleteAccountDialog
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.parse.FunctionCallback
import com.parse.ParseCloud

class SeekerDeleteAccountFinalFragment : BaseFragment(), SeekerDeleteAccountFinalInterface {
    lateinit var binding: FragmentSeekerDeleteAccountFinalBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerDeleteAccountFinalBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        binding.handler = this
        observeLiveData()
    }



    private fun observeLiveData() {
        observeDeleteStatus()
    }

    private fun observeDeleteStatus() {
       /* viewModel.deleteAccountLiveData.observe(this) {
            if (it == true) {
                requireActivity().clearUserPref()
                startActivity(Intent(requireActivity(), MainActivity::class.java))
                requireActivity().finishAffinity()
            } else {
                requireActivity().errorToast()
            }
        }*/
    }

    override fun onDeleteAccount() {
        val deleteAccountDialog = DeleteAccountDialog(requireActivity()) {
            progressHud.show()
            ParseCloud.callFunctionInBackground(ParseCloudFunction.DELETE_USER.value, hashMapOf( "jobSeekerId" to requireActivity().getUserId()), FunctionCallback<Any?> { response, e ->
                    progressHud.dismiss()
                    if (e == null) {
                       /* requireActivity().clearUserPref()
                        startActivity(Intent(requireActivity(), MainActivity::class.java))
                        requireActivity().finishAffinity()*/
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