package com.findajob.jobamax.jobseeker.profile.account.social

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentJobSeekerSocialLinksBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobSeekerSocialAccountFragment : BaseFragmentMain<FragmentJobSeekerSocialLinksBinding>(),
    SocialAccountInterface {
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel {
        return viewModel
    }

    lateinit var navController: NavController
    lateinit var socialAccountModel: JobSeekerSocialAccountModel


    override val layoutRes: Int
        get() = R.layout.fragment_job_seeker_social_links

    override fun onCreated(savedInstance: Bundle?) {
        socialAccountModel = JobSeekerSocialAccountModel(viewModel.jobSeeker)
        binding.handler = this
        initFields()
    }


    private fun initFields() {
        binding.jobSeeker = socialAccountModel
    }

    override fun onBackButtonClicked() = requireActivity().onBackPressed()
    override fun onEditButtonClicked() {
        binding.apply {
            btnSave.visibility = View.VISIBLE
            btnEdit.visibility = View.GONE

            etFacebook.isEnabled = true
            etTwitter.isEnabled = true
            etInstagram.isEnabled = true
            etLinkedin.isEnabled = true
        }
    }

    override fun onSaveButtonClicked() {

        binding.apply {
            btnSave.visibility = View.GONE
            btnEdit.visibility = View.VISIBLE

            etFacebook.isEnabled = false
            etTwitter.isEnabled = false
            etInstagram.isEnabled = false
            etLinkedin.isEnabled = false
        }

        progressHud.show()
        viewModel.updateSocialMediaLinks(socialAccountModel) {
            progressHud.dismiss()
            if (it != null)
                toast(it.message ?: "Something went wrong")
            else {
                requireActivity().onBackPressed()
                toast("Social Network Links Successfully Submitted!")
            }
        }
    }

    override fun onFacebookIconClicked() =
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/${socialAccountModel.facebook}"),
                ).setPackage("com.facebook.katana")
            )
        } catch (e: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/${socialAccountModel.facebook}"),
                )
            )
        }


    override fun onTwitterIconClicked() =
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.twitter.com/${socialAccountModel.twitter}")
                ).setPackage("com.twitter.android")
            )
        } catch (e: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.twitter.com/${socialAccountModel.twitter}")
                )
            )
        }


    override fun onInstagramIconClicked() =
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/${socialAccountModel.instagram}")
                ).setPackage("com.instagram.android")
            )
        } catch (e: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/${socialAccountModel.instagram}")
                )
            )
        }


    override fun onLinkedinIconClicked() =
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/${socialAccountModel.linkedin}")
                ).setPackage("com.linkedin.android")
            )
        } catch (e: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/${socialAccountModel.linkedin}")
                )
            )
        }


}