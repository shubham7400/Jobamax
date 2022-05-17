package com.jobamax.appjobamax.jobseeker.profile.account.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.*
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.databinding.FragmentJobSeekerAccountBinding
import com.jobamax.appjobamax.dialog.WorkInProgressDialog
import com.jobamax.appjobamax.enums.FirebaseDynamicLinkPath
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.enums.WebsiteUrls
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.model.UpdateUserCallback
import com.jobamax.appjobamax.preference.clearUserPref
import com.jobamax.appjobamax.preference.getLanguage
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.util.*
import com.google.firebase.dynamiclinks.ktx.androidParameters
import com.google.firebase.dynamiclinks.ktx.dynamicLink
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import com.parse.ParseObject
import com.parse.ParseQuery
import com.parse.ParseUser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobSeekerAccountFragment : BaseFragmentMain<FragmentJobSeekerAccountBinding>(), JobSeekerAccountInterface {
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var navController: NavController

    override val layoutRes: Int get() = R.layout.fragment_job_seeker_account

    override fun onCreated(savedInstance: Bundle?) {
        navController = findNavController()
        binding.handler = this
        if (viewModel.jobSeekerObject == null){
            getCurrent()
        }else{
            binding.jobSeeker = viewModel.jobSeeker
        }
        setClickListeners()
        configureUi()
    }

    private fun configureUi() {
        binding.tvCurrentLanguage.text = requireContext().getLanguage()
    }

    override fun onStart() {
        super.onStart()
        binding.sbPushNotification.isChecked = NotificationManagerCompat.from(requireContext()).areNotificationsEnabled()
    }

    private fun setClickListeners() {
        binding.sbPushNotification.setOnClickListener {
            val intent = Intent()
            intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("app_package",requireContext().packageName)
            intent.putExtra("app_uid", requireContext().applicationInfo.uid)
            intent.putExtra("android.provider.extra.APP_PACKAGE", requireContext().packageName)
            startActivity(intent)
        }

        binding.clChangeLanguage.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_jobSeekerAccountFragment_to_jobSeekerChangeLanguageFragment, null))
        binding.civUser.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_jobSeekerAccountFragment_to_nav_seeker_profile, null))

        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun getCurrent( ) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, context?.getUserId())
        query.include("portfolio")
        query.include("idealJob")
        progressHud.show()
        query.findInBackground { it, e ->
            progressHud.dismiss()
            val jobSeeker = it?.firstOrNull()
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                jobSeeker == null -> {
                    toast("User Not Found.")
                }
                else -> {
                    viewModel.jobSeekerObject = jobSeeker
                    viewModel.isJobSeekerUpdated.value = true
                    binding.jobSeeker = JobSeeker(jobSeeker)
                }
            }
        }
    }


    override fun onManageReadReceiptsClicked() = navController.navigate(R.id.action_jobSeekerAccountFragment_to_jobSeekerManageReadReceiptsFragment)

    override fun onPersonalInformationClicked() = navController.navigate(R.id.action_jobSeekerAccountFragment_to_jobSeekerPersonalInformationFragment)

    override fun onPushNotificationsClicked() = navController.navigate(R.id.action_jobSeekerAccountFragment_to_jobSeekerPushNotificationFragment)

    override fun onNewsletterClicked() = navController.navigate(R.id.action_jobSeekerAccountFragment_to_jobSeekerNewsletterFragment)







    override fun onRestorePurchaseClicked() = WorkInProgressDialog(requireActivity()).show()


    override fun onShareJobamaxClicked() {
        val builder = Uri.Builder()
        builder.scheme("https")
            .authority("www.jobamax.com")
            .appendPath(FirebaseDynamicLinkPath.JOB_SEEKER.value)
        val myUrl: String = builder.build().toString()
        val dynamicLink = Firebase.dynamicLinks.dynamicLink {
            link = Uri.parse(myUrl)
            domainUriPrefix = "https://jobamax.page.link/"
            androidParameters("com.findajob.jobamax") {
            }
        }

        val sharingIntent = Intent()
        sharingIntent.action = Intent.ACTION_SEND
        sharingIntent.type = "text/plain"
        sharingIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        sharingIntent.putExtra(Intent.EXTRA_TEXT, resources.getString(R.string.share_jobamax_info)+dynamicLink.uri)
       startActivity(Intent.createChooser(sharingIntent,resources.getString(R.string.share_jobamax_info)+dynamicLink.uri))
    }


    override fun onHelpAndSupportClicked() = startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, WebsiteUrls.SUPPORT_URL.url))

    override fun onEmailUsClicked() {
        val selectorIntent = Intent(Intent.ACTION_SENDTO)
        selectorIntent.data = Uri.parse("mailto:")

        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("support@jobamax.com"))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Regarding Jobamax App")

        emailIntent.selector = selectorIntent
        startActivity(Intent.createChooser(emailIntent, "Send email..."))
    }

    override fun onCommunityGuidelinesClicked() = startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, WebsiteUrls.COMMUNITY_GUIDELINES_URL.url))

    override fun onSafetyTipsClicked() = startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, WebsiteUrls.SAFETY_TIPS_URL.url))

    override fun onPrivacyPolicyClicked() = startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, WebsiteUrls.PRIVACY_URL.url))

    override fun onTermsOfServiceClicked() = startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, WebsiteUrls.TERMS_URL.url))

    override fun onLicensesClicked() = startActivity(Intent(requireContext(), LicenseActivity::class.java))

    override fun onPrivacyPreferencesClicked() = startActivity(Intent(requireContext(), PrivacyPreferenceActivity::class.java))

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

    override fun onDeleteAccountClicked() = navController.navigate(R.id.action_jobSeekerAccountFragment_to_seekerDeleteAccountFragment)


    override fun onPasswordClicked() = navController.navigate(R.id.action_jobSeekerAccountFragment_to_seekerChangePasswordFragment)



}