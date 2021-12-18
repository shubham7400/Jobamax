package com.findajob.jobamax.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentValuePrivacyBinding
import com.findajob.jobamax.util.ACTION_REGISTER
import com.findajob.jobamax.util.ARG_ACTION
import com.findajob.jobamax.util.checkLocationPermission

class ValuePrivacyFragment : BaseFragmentMain<FragmentValuePrivacyBinding>(), ValuePrivacyInterface {
	

	lateinit var navController: NavController

	override val layoutRes: Int
		get() = R.layout.fragment_value_privacy

	override fun onCreated(savedInstance: Bundle?) {
		initViews()
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
		navController.navigate(R.id.locationPermissionFragment, bundleOf(ARG_ACTION to ACTION_REGISTER))
		/*if (requireActivity().checkLocationPermission())
			navController.navigate(R.id.keepMePostedFragment)
		else
			navController.navigate(R.id.locationPermissionFragment, bundleOf(ARG_ACTION to ACTION_REGISTER))*/
	}


}


interface ValuePrivacyInterface {
	
	fun onAcceptClicked()
}