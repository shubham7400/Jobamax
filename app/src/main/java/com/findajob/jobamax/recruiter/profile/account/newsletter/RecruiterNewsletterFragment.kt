package com.findajob.jobamax.recruiter.profile.account.newsletter

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentRecruiterNewsletterBinding
import com.findajob.jobamax.model.UpdateUserCallback
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.util.errorToast
import kotlinx.android.synthetic.main.fragment_recruiter_newsletter.*

class RecruiterNewsletterFragment : BaseFragmentMain<FragmentRecruiterNewsletterBinding>(),
    RecruiterNewsletterInterface {

    val viewModel: RecruiterHomeViewModel by activityViewModels()

    override val layoutRes: Int
        get() = R.layout.fragment_recruiter_newsletter

    override fun onCreated(savedInstance: Bundle?) {
        newsletterCheck.isChecked = viewModel.recruiter.newsLetterPNFlag
        binding.handler = this
    }

    override fun getViewModel(): ViewModel? {
        return viewModel
    }


    override fun toggleNewsletterFlag(flag: Boolean) {
        viewModel.updateFlag(flag, "newsLetterPNFlag", object : UpdateUserCallback {
            override fun onFinish(isSuccessful: Boolean) {
                if (isResumed) {
                    if (!isSuccessful) {
                        newsletterCheck.isChecked = !flag
                        requireActivity().errorToast()
                    }
                }
            }
        })
    }

    override fun onBackPress() {
        requireActivity().onBackPressed()
    }


}