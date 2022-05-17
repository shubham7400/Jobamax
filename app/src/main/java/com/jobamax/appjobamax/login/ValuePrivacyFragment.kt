package com.jobamax.appjobamax.login


import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.databinding.FragmentValuePrivacyBinding
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.*

class ValuePrivacyFragment : BaseFragmentMain<FragmentValuePrivacyBinding>(), ValuePrivacyInterface {
	

	lateinit var navController: NavController
	var user : UserTempInfo? = null

	override val layoutRes: Int
		get() = R.layout.fragment_value_privacy

	override fun onCreated(savedInstance: Bundle?) {
		initViews()
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		user = arguments?.getSerializable(ARG_USER) as UserTempInfo
	}

	override fun getViewModel(): ViewModel? = null

	private fun initViews(){
		binding.handler = this
		navController = findNavController()

		binding.ivBackButton.setOnClickListener {
			requireActivity().onBackPressed()
		}
	}
	
	override fun onAcceptClicked() {
		navController.navigate(R.id.keepMePostedFragment, bundleOf(ARG_USER to user))
	}


}


interface ValuePrivacyInterface {
	
	fun onAcceptClicked()
}