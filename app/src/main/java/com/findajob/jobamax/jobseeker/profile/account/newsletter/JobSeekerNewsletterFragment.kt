package com.findajob.jobamax.jobseeker.profile.account.newsletter

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentJobSeekerNewsletterBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.UpdateUserCallback
import com.findajob.jobamax.util.errorToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_job_seeker_newsletter.*

@AndroidEntryPoint
class JobSeekerNewsletterFragment : BaseFragmentMain<FragmentJobSeekerNewsletterBinding>(),
    JobSeekerNewsletterInterface {

    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel {
        return viewModel
    }

    override val layoutRes: Int
        get() = R.layout.fragment_job_seeker_newsletter

    override fun onCreated(savedInstance: Bundle?) {
        setHasOptionsMenu(true)
        binding.handler = this
        newsletterCheck.isChecked = viewModel.jobSeeker.newsLetterPNFlag
    }


    override fun toggleNewsletterFlag(flag: Boolean) {
        viewModel.updateFlag(flag, "newsLetterPNFlag", object : UpdateUserCallback {
            override fun onFinish(isSuccessful: Boolean) {
                if (!isSuccessful) {
                    newsletterCheck.isChecked = !flag
                    requireActivity().errorToast()
                }
            }
        })
    }

    override fun onBackPress() {
        requireActivity().onBackPressed()
    }
}