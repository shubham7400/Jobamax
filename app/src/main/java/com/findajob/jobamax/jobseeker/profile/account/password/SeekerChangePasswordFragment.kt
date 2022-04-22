package com.findajob.jobamax.jobseeker.profile.account.password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerChangePasswordBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.util.toast


class SeekerChangePasswordFragment : BaseFragmentMain<FragmentSeekerChangePasswordBinding>(), JobSeekerPasswordInterface {
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel {
        return viewModel
    }
    override val layoutRes: Int get() = R.layout.fragment_seeker_change_password

    override fun onCreated(savedInstance: Bundle?) {

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerChangePasswordBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        binding.handler = this
    }

    override fun onSubmitClicked() {
        if (binding.newPasswordField.text.isEmpty()) {
            binding.newPasswordField.error = getString(R.string.enter_new_password)
            return
        }

        if (binding.confirmNewPasswordField.text.isEmpty()) {
            binding.confirmNewPasswordField.error = getString(R.string.enter_new_password)
            return
        }

        val newPassword = binding.newPasswordField.text.toString()
        val confirmNewPassword = binding.confirmNewPasswordField.text.toString()

        if (newPassword != confirmNewPassword) {
            toast(getString(R.string.password_not_matching))
            return
        }

        if (newPassword.length < 7) {
            toast("Password should have at least 7 characters")
            return
        }

        changePassword(newPassword)
    }

    private fun changePassword(newPassword: String) {
        progressHud.show()
        viewModel.changePassword(newPassword) {
            progressHud.dismiss()
            if (it == null) {
                toast(getString(R.string.password_updated))
            } else toast(it.message.toString())
        }

       /* val currentUser = ParseUser.getCurrentUser()
        currentUser.setPassword(newPassword)
         progressHud.show()
        currentUser.saveInBackground {
            progressHud.dismiss()
            if (it == null) {
                toast(getString(R.string.password_updated))
            } else errorToast(it)
        }*/
    }

    override fun onBackPress() {
        requireActivity().onBackPressed()
    }


}

interface JobSeekerPasswordInterface {
    fun onSubmitClicked()
    fun onBackPress()
}