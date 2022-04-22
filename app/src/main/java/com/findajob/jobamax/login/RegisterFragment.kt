package com.findajob.jobamax.login

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain

import com.findajob.jobamax.base.isNetworkConnected
import com.findajob.jobamax.data.remote.NoInternetException
import com.findajob.jobamax.databinding.FragmentRegisterBinding
import com.findajob.jobamax.enums.LoginType
import com.findajob.jobamax.model.UserTempInfo
import com.findajob.jobamax.util.isValidEmail
import com.findajob.jobamax.util.toast

class RegisterFragment : BaseFragmentMain<FragmentRegisterBinding>(), RegisterInterface {
	

	lateinit var viewModel: LoginViewModel

	override val layoutRes: Int get() = R.layout.fragment_register

	override fun onCreated(savedInstance: Bundle?) {
		viewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]
		binding.handler = this

		binding.tvLogin.setOnClickListener {
			requireActivity().onBackPressed()
		}
		binding.ivBackButton.setOnClickListener {
			requireActivity().onBackPressed()
		}

	}

	override fun getViewModel(): ViewModel = viewModel

	
	override fun onLoginClicked() {
		(requireActivity()).onBackPressed()
	}
	
	override fun onRegisterClicked() {
		val email = binding.etEmailField.text.toString().trim()
		val password = binding.etPasswordField.text.toString()
		val confirmPassword = binding.etConfirmPasswordField.text.toString()

		if (email.isEmpty()) {
			toast("Enter Email")
		} else if (!email.isValidEmail()) {
			toast("Enter Valid Email")
		} else if (password.length < 7 || password.isEmpty()) {
			toast("Password should have at least 7 characters")
		} else if(password != confirmPassword){
			toast("Password and Confirm password does not match")
		}else{
			if (requireContext().isNetworkConnected()){
					val user = UserTempInfo().also {
						it.email = email
						it.password = password
						it.loginType = LoginType.EMAIL.type
					}
				(requireActivity() as LoginActivity).isEmailAlreadyRegistered(user){}
			}else{
				toast(NoInternetException.MSG)
			}
		}
		
	}

	override fun onEyeClicked(eyeType: Int) {
		when(eyeType){
			1 -> {
				if(binding.etPasswordField.transformationMethod.equals(PasswordTransformationMethod.getInstance())){
					binding.apply{
						ivShowPasswordButton.setImageResource(R.drawable.ic_eye)
						etPasswordField.transformationMethod = HideReturnsTransformationMethod.getInstance()
						etPasswordField.setSelection(etPasswordField.length())
					}
				}else{
					binding.apply {
						ivShowPasswordButton.setImageResource(R.drawable.ic_eye_off)
						etPasswordField.transformationMethod = PasswordTransformationMethod.getInstance()
						etPasswordField.setSelection(etPasswordField.length())
					}
				}
			}
			2 -> {
				if(binding.etConfirmPasswordField.transformationMethod.equals(PasswordTransformationMethod.getInstance())){
					binding.apply{
						ivShowConfirmPasswordButton.setImageResource(R.drawable.ic_eye)
						etConfirmPasswordField.transformationMethod = HideReturnsTransformationMethod.getInstance()
						etConfirmPasswordField.setSelection(etConfirmPasswordField.length())
					}
				}else{
					binding.apply {
						ivShowConfirmPasswordButton.setImageResource(R.drawable.ic_eye_off)
						etConfirmPasswordField.transformationMethod = PasswordTransformationMethod.getInstance()
						etConfirmPasswordField.setSelection(etConfirmPasswordField.length())
					}
				}
			}
		}

	}


}

interface RegisterInterface {
	fun onLoginClicked()
	
	fun onRegisterClicked()

	fun onEyeClicked(eyeType: Int)
}