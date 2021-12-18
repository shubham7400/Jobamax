package com.findajob.jobamax.jobseeker.profile.account.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.*
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentJobSeekerAccountBinding
import com.findajob.jobamax.dialog.ShareJobamaxDialog
import com.findajob.jobamax.dialog.WorkInProgressDialog
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.profile.account.password.JobSeekerPasswordActivity
import com.findajob.jobamax.model.UpdateUserCallback
import com.findajob.jobamax.preference.clearUserPref
import com.findajob.jobamax.util.ARG_WEB_URL
import com.findajob.jobamax.util.errorToast
import com.findajob.jobamax.util.showDialog
import com.parse.ParseUser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobSeekerAccountFragment : BaseFragmentMain<FragmentJobSeekerAccountBinding>(),
    JobSeekerAccountInterface {
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var navController: NavController

    override val layoutRes: Int
        get() = R.layout.fragment_job_seeker_account

    override fun onCreated(savedInstance: Bundle?) {
        navController = findNavController()
        binding.hideMeFlag.isChecked = viewModel.jobSeeker.hideMeFlag
        binding.handler = this
    }

    override fun onManageReadReceiptsClicked() = navController.navigate(R.id.action_jobSeekerAccountFragment_to_jobSeekerManageReadReceiptsFragment)

    override fun onPersonalInformationClicked() = navController.navigate(R.id.action_jobSeekerAccountFragment_to_jobSeekerPersonalInformationFragment)

    override fun onPushNotificationsClicked() = navController.navigate(R.id.action_jobSeekerAccountFragment_to_jobSeekerPushNotificationFragment)

    override fun onNewsletterClicked() = navController.navigate(R.id.action_jobSeekerAccountFragment_to_jobSeekerNewsletterFragment)

    override fun onSocialLayoutClicked() = navController.navigate(R.id.action_jobSeekerAccountFragment_to_jobSeekerSocialAccountFragment)


    override fun onBackButtonClicked() = requireActivity().onBackPressed()


    override fun onPaymentMethodsClicked() {
        navController.navigate(R.id.action_jobSeekerAccountFragment_to_jobSeekerPaymentMethodsFragment)
    }

    override fun onRestorePurchaseClicked() {
        WorkInProgressDialog(requireActivity()).show()
    }

    override fun onShareJobamaxClicked() {
        ShareJobamaxDialog(requireActivity()).show()
    }

    override fun onHelpAndSupportClicked() = startActivity(
        Intent(requireContext(), WebViewActivity::class.java).putExtra(
            ARG_WEB_URL,
            "https://www.jobamax.com/en/support"
        )
    )

    override fun onEmailUsClicked() {
        val selectorIntent = Intent(Intent.ACTION_SENDTO)
        selectorIntent.data = Uri.parse("mailto:")

        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("support@jobamax.com"))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Regarding Jobamax App")

        emailIntent.selector = selectorIntent
        startActivity(Intent.createChooser(emailIntent, "Send email..."))
    }

    override fun onCommunityGuidelinesClicked() = startActivity(
        Intent(requireContext(), WebViewActivity::class.java).putExtra(
            ARG_WEB_URL,
            "https://www.jobamax.com/en/community-guidelines"
        )
    )

    override fun onSafetyTipsClicked() = startActivity(
        Intent(requireContext(), WebViewActivity::class.java).putExtra(
            ARG_WEB_URL,
            "https://www.jobamax.com/en/safety-tips"
        )
    )

    override fun onPrivacyPolicyClicked() = startActivity(
        Intent(requireContext(), WebViewActivity::class.java).putExtra(
            ARG_WEB_URL,
            "https://www.jobamax.com/en/privacy"
        )
    )

    override fun onTermsOfServiceClicked() = startActivity(
        Intent(requireContext(), WebViewActivity::class.java).putExtra(
            ARG_WEB_URL,
            "https://www.jobamax.com/en/terms"
        )
    )

    override fun onLicensesClicked() =
        startActivity(Intent(requireContext(), LicenseActivity::class.java))

    override fun onPrivacyPreferencesClicked() =
        startActivity(Intent(requireContext(), PrivacyPreferenceActivity::class.java))

    override fun onLogoutClicked() {
        requireActivity().showDialog(message = getString(R.string.do_you_want_to_logout)) {
            if (it) {
                ParseUser.logOut()
                requireActivity().clearUserPref()
                startActivity(Intent(requireActivity(), MainActivity::class.java))
                requireActivity().finishAffinity()
            }
        }
    }

    override fun onTemporaryDisableAccountClicked() {
        requireActivity().showDialog(message = getString(R.string.do_you_want_to_disable)) {
            if (it) {
                showLoading(true)
                viewModel.updateFlag(true, "temporaryDisableFlag", object : UpdateUserCallback {
                    override fun onFinish(isSuccessful: Boolean) {
                        showLoading(false)
                        if (isSuccessful) {
                            onLogoutClicked()
                        } else requireActivity().errorToast()
                    }
                })
            }
        }
    }

    override fun onDeleteAccountClicked() {
        navController.navigate(R.id.action_jobSeekerAccountFragment_to_seekerDeleteAccountFragment2)
    }

    override fun onPasswordClicked() {
        startActivity(Intent(requireContext(), JobSeekerPasswordActivity::class.java))
    }

    override fun toggleHideMe(flag: Boolean) {
        binding.hideMeFlag.isEnabled = false
        viewModel.updateFlag(flag, "hideMeFlag", object : UpdateUserCallback {
            override fun onFinish(isSuccessful: Boolean) {
                if (isResumed) {
                    binding.hideMeFlag.isEnabled = true
                    if (!isSuccessful) {
                        binding.hideMeFlag.isChecked = !flag
                    }
                }
            }
        })
    }
}