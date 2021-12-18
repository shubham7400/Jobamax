package com.findajob.jobamax.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findajob.jobamax.BaseFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentKeepMePostedBinding
import com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoActivity
import com.findajob.jobamax.model.UpdateUserCallback
import com.findajob.jobamax.preference.getRole
import com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInfoIntroActivity
import com.findajob.jobamax.util.ROLE_JOB_SEEKER
import com.findajob.jobamax.util.errorToast

class KeepMePostedFragment : BaseFragmentMain<FragmentKeepMePostedBinding>(), KeepMePostedInterface {

	lateinit var viewModel: LoginViewModel


	override val layoutRes: Int
		get() = R.layout.fragment_keep_me_posted

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
		/*progressHud.show()
		viewModel.updateFlag(object : UpdateUserCallback {
			override fun onFinish(isSuccessful: Boolean) {
				progressHud.dismiss()
				if (isSuccessful) {
					navHome()
				} else requireActivity().errorToast()
			}
		})*/
	}
	
	override fun onNotNowClicked() = navHome()

	
	private fun navHome() {
		if (requireActivity().getRole() == ROLE_JOB_SEEKER)
			startActivity(Intent(requireContext(), JobSeekerPersonalIntroInfoActivity::class.java))
		else startActivity(Intent(requireContext(), RecruiterPersonalInfoIntroActivity::class.java))
		requireActivity().finishAffinity()
	}

}

interface KeepMePostedInterface {
	fun onNotifiedClicked()
	
	fun onNotNowClicked()
}