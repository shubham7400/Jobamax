package com.findajob.jobamax.recruiter.profile.account.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.*
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentRecruiterAccountBinding
import com.findajob.jobamax.dialog.ShareJobamaxDialog
import com.findajob.jobamax.dialog.WorkInProgressDialog
import com.findajob.jobamax.jobseeker.profile.account.password.JobSeekerPasswordActivity
import com.findajob.jobamax.model.UpdateUserCallback
import com.findajob.jobamax.preference.clearUserPref
import com.findajob.jobamax.preference.getLoginType
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.util.*
import com.parse.ParseUser
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recruiter_account.*


@AndroidEntryPoint
class RecruiterAccountFragment : BaseFragmentMain<FragmentRecruiterAccountBinding>(),
    RecruiterAccountInterface {

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var navController: NavController

    override val layoutRes: Int
        get() = R.layout.fragment_recruiter_account

    override fun onCreated(savedInstance: Bundle?) {
        initView()
        initFields()
    }

    private fun initView() {
        navController = findNavController()
        binding.handler = this

    }

    private fun initFields() {
//        hideMeFlag.isChecked = viewModel.recruiter.hideMeFlag
    }

    override fun toggleHideMe(flag: Boolean) {
        hideMeFlag.isEnabled = false
        viewModel.updateFlag(flag, "hideMeFlag", object : UpdateUserCallback {
            override fun onFinish(isSuccessful: Boolean) {
                if (isResumed) {
                    hideMeFlag.isEnabled = true
                    if (!isSuccessful) {
                        binding.handler = null
                        hideMeFlag.isChecked = !flag
                        binding.handler = this@RecruiterAccountFragment
                        requireActivity().errorToast()
                    }
                }
            }
        })
    }


    override fun onPasswordClicked() {
        if (requireContext().getLoginType() != EMAIL_LOGIN_TYPE)
            toast("You are not logged in using email password")
        else startActivity(Intent(requireContext(), JobSeekerPasswordActivity::class.java))
    }

    override fun onManageReadReceiptsClicked() =
        navController.navigate(R.id.action_recruiterAccountFragment_to_manageReadReceiptsFragment)

    override fun onPersonalInformationClicked() =
        navController.navigate(R.id.action_recruiterAccountFragment_to_recruiterPersonalInformationFragment)

    override fun onPushNotificationsClicked() =
        navController.navigate(R.id.action_recruiterAccountFragment_to_recruiterPushNotificationFragment)

    override fun onNewsletterClicked() =
        navController.navigate(R.id.action_recruiterAccountFragment_to_newsletterFragment)

    override fun onBackButtonClicked() = requireActivity().onBackPressed()

    override fun onCompanyInformationClicked() =
        navController.navigate(R.id.action_recruiterAccountFragment_to_companyInformationFragment)

    override fun onInvoicesClicked() {
        navController.navigate(R.id.action_recruiterAccountFragment_to_recruiterInvoicesFragment)
    }

    override fun onPaymentMethodsClicked() {
        navController.navigate(R.id.action_recruiterAccountFragment_to_recruiterPaymentMethodsFragment)
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
                progressHud.show()
                viewModel.updateFlag(true, "temporaryDisableFlag", object : UpdateUserCallback {
                    override fun onFinish(isSuccessful: Boolean) {
                        progressHud.dismiss()
                        if (isSuccessful) {
                            onLogoutClicked()
                        } else requireActivity().errorToast()
                    }
                })
            }
        }
    }

    override fun onSocialLayoutClicked() =
        navController.navigate(R.id.action_recruiterAccountFragment_to_recruiterSocialAccountFragment)

    override fun onDeleteAccountClicked() {
        navController.navigate(R.id.action_recruiterAccountFragment_to_recruiterDeleteAccountFragment)

    }
}

