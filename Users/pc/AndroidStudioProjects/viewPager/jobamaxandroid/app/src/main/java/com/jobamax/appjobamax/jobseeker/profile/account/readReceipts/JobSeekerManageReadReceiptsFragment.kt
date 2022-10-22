package com.jobamax.appjobamax.jobseeker.profile.account.readReceipts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jobamax.appjobamax.base.BaseFragment
 import com.jobamax.appjobamax.databinding.FragmentJobSeekerManageReadReceiptsBinding
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_job_seeker_manage_read_receipts.*

@AndroidEntryPoint
class JobSeekerManageReadReceiptsFragment : BaseFragment(), JobSeekerManageReadReceiptsInterface {
    lateinit var binding: FragmentJobSeekerManageReadReceiptsBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentJobSeekerManageReadReceiptsBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setHasOptionsMenu(true)
        binding.handler = this
        manageReadReceiptsCheck.isChecked = viewModel.jobSeeker.readReceiptFlag
    }



    override fun toggleManageReadReceipts(flag: Boolean) {
     /*   viewModel.updateFlag(flag, "readReceiptFlag", object : UpdateUserCallback {
            override fun onFinish(isSuccessful: Boolean) {
                if (!isSuccessful) {
                    manageReadReceiptsCheck.isChecked = !flag
                    requireActivity().errorToast()
                }
            }
        })*/
    }

    override fun onBackPress() {
        requireActivity().onBackPressed()
    }

}