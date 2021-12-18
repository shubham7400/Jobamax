package com.findajob.jobamax.recruiter.profile.account.readReceipts

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentRecruiterManageReadReceiptsBinding
import com.findajob.jobamax.model.UpdateUserCallback
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.util.errorToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recruiter_manage_read_receipts.*

@AndroidEntryPoint
class RecruiterManageReadReceiptsFragment : BaseFragmentMain<FragmentRecruiterManageReadReceiptsBinding>(), RecruiterManageReadReceiptsInterface {
	
	val viewModel: RecruiterHomeViewModel by activityViewModels()

	override val layoutRes: Int
		get() = R.layout.fragment_recruiter_manage_read_receipts

	override fun onCreated(savedInstance: Bundle?) {
		binding.handler = this
		manageReadReceiptsCheck.isChecked = viewModel.recruiter.readReceiptFlag

	}

	override fun getViewModel(): ViewModel? {
		return viewModel
	}

	override fun toggleManageReadReceipts(flag: Boolean) {
		viewModel.updateFlag(flag, "readReceiptFlag", object : UpdateUserCallback {
			override fun onFinish(isSuccessful: Boolean) {
				if (isResumed && !isSuccessful) {
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

