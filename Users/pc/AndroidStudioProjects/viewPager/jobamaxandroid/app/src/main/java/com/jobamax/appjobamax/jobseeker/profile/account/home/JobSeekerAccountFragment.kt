package com.jobamax.appjobamax.jobseeker.profile.account.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.*
import com.jobamax.appjobamax.databinding.FragmentJobSeekerAccountBinding
import com.jobamax.appjobamax.dialog.WorkInProgressDialog
import com.jobamax.appjobamax.enums.FirebaseDynamicLinkPath
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.WebsiteUrls
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.preference.clearUserPref
import com.jobamax.appjobamax.util.*
import com.google.firebase.dynamiclinks.ktx.androidParameters
import com.google.firebase.dynamiclinks.ktx.dynamicLink
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.dialog.DialogYesNoSimple
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.profile.account.SeekerSettingActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.parse.ParseUser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobSeekerAccountFragment : BaseFragment(), JobSeekerAccountInterface {
    lateinit var binding: FragmentJobSeekerAccountBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()
    lateinit var jobSeeker: JobSeeker

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentJobSeekerAccountBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }



    private fun configureUi() {
        binding.handler = this
        if (viewModel.jobSeekerObject == null){
            try {
                (requireActivity() as SeekerSettingActivity).getJobSeeker {setData() }
            }catch (e: Exception){ }
        }else{
            binding.jobSeeker = viewModel.jobSeeker
            jobSeeker = viewModel.jobSeeker
            setData()
        }
        setClickListeners()
        setViewModelObserver()
    }

    private fun setViewModelObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner){
            if (it){
                binding.jobSeeker = viewModel.jobSeeker
                jobSeeker = viewModel.jobSeeker
                setData()
            }
        }
    }

    private fun setData() {
        binding.scHideProfile.isChecked = jobSeeker.hideAccount
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

        binding.scHideProfile.setOnClickListener {
            viewModel.jobSeekerObject?.let {
               it.put(ParseTableFields.HIDE_ACCOUNT.value, binding.scHideProfile.isChecked)
                progressHud.show()
                it.saveInBackground { exception ->
                    progressHud.dismiss()
                    if (exception != null) {
                        toast("${exception.message.toString()} Something went wrong")
                    }
                }
            }
        }

        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.tvChangePassword.setOnClickListener { findNavController().navigate(R.id.action_jobSeekerAccountFragment_to_seekerChangePasswordFragment, null) }
    }




    override fun onManageReadReceiptsClicked() = findNavController().navigate(R.id.action_jobSeekerAccountFragment_to_jobSeekerManageReadReceiptsFragment)

    override fun onPersonalInformationClicked() = findNavController().navigate(R.id.action_jobSeekerAccountFragment_to_jobSeekerPersonalInformationFragment)


    override fun onNewsletterClicked() = findNavController().navigate(R.id.action_jobSeekerAccountFragment_to_jobSeekerNewsletterFragment)







    override fun onRestorePurchaseClicked() = WorkInProgressDialog(requireActivity()).show()


    override fun onShareJobamaxClicked() {
        val builder = Uri.Builder()
        builder.scheme("https")
            .authority("www.jobamax.com")
            .appendPath(FirebaseDynamicLinkPath.JOB_SEEKER.path)
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



    override fun onLogoutClicked() {
        DialogYesNoSimple(requireActivity(), "Voulez-vous vous déconnecter?", {
            ParseUser.logOut()
            requireActivity().clearUserPref()
            startActivity(Intent(requireContext(), NewSplashActivity::class.java))
            requireActivity().finish()
        }, {}).show()
    }


    override fun onDeleteAccountClicked() = findNavController().navigate(R.id.action_jobSeekerAccountFragment_to_seekerDeleteAccountFragment)
    override fun onPasswordClicked() {}


}