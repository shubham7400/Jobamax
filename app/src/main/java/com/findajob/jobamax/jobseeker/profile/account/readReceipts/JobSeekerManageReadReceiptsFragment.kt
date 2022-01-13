package com.findajob.jobamax.jobseeker.profile.account.readReceipts

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentJobSeekerManageReadReceiptsBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.UpdateUserCallback
import com.findajob.jobamax.util.errorToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_job_seeker_manage_read_receipts.*

@AndroidEntryPoint
class JobSeekerManageReadReceiptsFragment : BaseFragmentMain<FragmentJobSeekerManageReadReceiptsBinding>(), JobSeekerManageReadReceiptsInterface {

    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel {
        return viewModel
    }

    override val layoutRes: Int get() = R.layout.fragment_job_seeker_manage_read_receipts

    override fun onCreated(savedInstance: Bundle?) {
        setHasOptionsMenu(true)
        binding.handler = this
        manageReadReceiptsCheck.isChecked = viewModel.jobSeeker.readReceiptFlag
    }

    override fun toggleManageReadReceipts(flag: Boolean) {
        viewModel.updateFlag(flag, "readReceiptFlag", object : UpdateUserCallback {
            override fun onFinish(isSuccessful: Boolean) {
                if (!isSuccessful) {
                    manageReadReceiptsCheck.isChecked = !flag
                    requireActivity().errorToast()
                }
            }
        })
    }

    override fun onBackPress() {
        requireActivity().onBackPressed()
    }

}