package com.findajob.jobamax.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentVerificationCodeBinding
import com.findajob.jobamax.util.log
import kotlinx.android.synthetic.main.fragment_verification_code.*

class VerificationCodeFragment : BaseFragmentMain<FragmentVerificationCodeBinding>(), VerificationCodeInterface {
	

	lateinit var viewModel: LoginViewModel

	override val layoutRes: Int
		get() = R.layout.fragment_verification_code

	override fun onCreated(savedInstance: Bundle?) {
		configureViewModel()
		binding.handler = this
	}

	private fun configureViewModel(){
		viewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)
	}

	override fun getViewModel(): ViewModel = viewModel


	
	override fun onBackButtonClicked() {

		requireActivity().onBackPressed()
	}
	
	override fun onSendClicked() {

		
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
	}
	
	override fun onResendClicked() {
		//TODO: add 1 minute timer for resend
		//TODO: disable the resend button until then
		//TODO: implement resend functionality
	}


}

interface VerificationCodeInterface {
	fun onBackButtonClicked()
	
	fun onSendClicked()
	
	fun onResendClicked()
}