package com.jobamax.appjobamax.login

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.databinding.FragmentKeepMePostedBinding
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.ARG_USER


class KeepMePostedFragment : BaseFragmentMain<FragmentKeepMePostedBinding>(), KeepMePostedInterface {

	lateinit var viewModel: LoginViewModel
	lateinit var navController: NavController
	var user : UserTempInfo? = null

	override val layoutRes: Int
		get() = R.layout.fragment_keep_me_posted

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		user = arguments?.getSerializable(ARG_USER) as UserTempInfo
	}

	override fun onCreated(savedInstance: Bundle?) {
		configureViewModel()
		initViews()

		binding.ivBackButton.setOnClickListener {
			requireActivity().onBackPressed()
		}
	}

	private fun initViews(){
		binding.handler = this
		navController = findNavController()

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
		navController.navigate(R.id.locationPermissionFragment, bundleOf(ARG_USER to user))
	}

}

interface KeepMePostedInterface {
	fun onNotifiedClicked()
	
	fun onNotNowClicked()
}