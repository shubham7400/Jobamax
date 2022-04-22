package com.findajob.jobamax.login

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentKeepMePostedBinding
import com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoActivity
import com.findajob.jobamax.model.UserTempInfo
import com.findajob.jobamax.preference.getUserType
import com.findajob.jobamax.util.ARG_USER


class KeepMePostedFragment : BaseFragmentMain<FragmentKeepMePostedBinding>(), KeepMePostedInterface {

	lateinit var viewModel: LoginViewModel
	var user : UserTempInfo? = null

	override val layoutRes: Int
		get() = R.layout.fragment_keep_me_posted

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		user = arguments?.getSerializable(ARG_USER) as UserTempInfo
	}

	override fun onCreated(savedInstance: Bundle?) {
		configureViewModel()

		binding.ivBackButton.setOnClickListener {
			requireActivity().onBackPressed()
		}
	}

	private fun configureViewModel(){
		viewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)
		binding.handler = this
	}

	override fun getViewModel(): ViewModel = viewModel

	
	override fun onNotifiedClicked() {
		navHome()
	}
	
	override fun onNotNowClicked() = navHome()

	
	private fun navHome() {
		startActivity(Intent(requireContext(), JobSeekerPersonalIntroInfoActivity::class.java).also {
			it.putExtra(ARG_USER, user)
		})
	}

}

interface KeepMePostedInterface {
	fun onNotifiedClicked()
	
	fun onNotNowClicked()
}