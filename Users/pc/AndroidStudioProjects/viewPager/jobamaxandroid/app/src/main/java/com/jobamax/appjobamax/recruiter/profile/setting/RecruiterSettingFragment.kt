package com.jobamax.appjobamax.recruiter.profile.setting

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.dynamiclinks.ktx.androidParameters
import com.google.firebase.dynamiclinks.ktx.dynamicLink
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import com.jobamax.appjobamax.NewSplashActivity
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.WebViewActivity
import com.jobamax.appjobamax.databinding.FragmentRecruiterSettingBinding
import com.jobamax.appjobamax.dialog.BasicDialog2
import com.jobamax.appjobamax.enums.FirebaseDynamicLinkPath
import com.jobamax.appjobamax.enums.WebsiteUrls
import com.jobamax.appjobamax.model.Recruiter
import com.jobamax.appjobamax.preference.clearUserPref
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel
import com.jobamax.appjobamax.util.ARG_WEB_URL
import kotlinx.android.synthetic.main.fragment_recruiter_personal_info.*


class RecruiterSettingFragment : Fragment() {
    lateinit var binding: FragmentRecruiterSettingBinding

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    lateinit var recruiter: Recruiter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRecruiterSettingBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.sbPushNotification.isChecked = NotificationManagerCompat.from(requireContext()).areNotificationsEnabled()
    }

    private fun configureUi() {
        setClickListeners()
        setObserver()
        initializeRecruiter()
    }

    private fun initializeRecruiter() {
        recruiter = viewModel.recruiter
        if (viewModel.recruiterObject == null) {
            (requireActivity() as RecruiterSettingActivity).getRecruiter {
                if (it) {
                    recruiter = viewModel.recruiter
                    setData()
                }
            }
        }
    }

    private fun setObserver() {
        viewModel.isRecruiterUpdated.observe(viewLifecycleOwner){
            if (it){
                recruiter = viewModel.recruiter
                setData()
            }
        }
    }

    private fun setData() {

    }

    private fun setClickListeners() {
        binding.tvShareJobamax.setOnClickListener { onShareJobamaxClicked() }
        binding.tvPersonalInfo.setOnClickListener { findNavController().navigate(R.id.action_recruiterSettingFragment_to_recruiterPersonalInfoFragment, null) }
        binding.tvChangePassword.setOnClickListener { findNavController().navigate(R.id.action_recruiterSettingFragment_to_recruiterChangePasswordFragment, null) }
        binding.tvNewsletter.setOnClickListener { findNavController().navigate(R.id.action_recruiterSettingFragment_to_recruiterNewsLatterFragment, null) }
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.tvLogout.setOnClickListener { logout() }
        binding.tvFaq.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, WebsiteUrls.SUPPORT_URL.url))
        }
        binding.tvCommunityGuideline.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, WebsiteUrls.COMMUNITY_GUIDELINES_URL.url))
        }
        binding.tvPrivacyPolicy.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, WebsiteUrls.PRIVACY_URL.url))
        }
        binding.tvSafetyTips.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, WebsiteUrls.SAFETY_TIPS_URL.url))
        }
        binding.tvTermServices.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, WebsiteUrls.TERMS_URL.url))
        }
        binding.tvEmailUs.setOnClickListener {
            val selectorIntent = Intent(Intent.ACTION_SENDTO)
            selectorIntent.data = Uri.parse("mailto:")

            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("support@jobamax.com"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Regarding Jobamax App")

            emailIntent.selector = selectorIntent
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }

        binding.sbPushNotification.setOnClickListener {
            val intent = Intent()
            intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("app_package",requireContext().packageName)
            intent.putExtra("app_uid", requireContext().applicationInfo.uid)
            intent.putExtra("android.provider.extra.APP_PACKAGE", requireContext().packageName)
            startActivity(intent)
        }
    }

    fun onShareJobamaxClicked() {
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

    private fun logout() {
        BasicDialog2(requireActivity()){
            requireActivity().clearUserPref()
            startActivity(Intent(requireContext(), NewSplashActivity::class.java))
            requireActivity().finish()
        }.show()
    }

}