package com.jobamax.appjobamax.login

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentTakePasswordBinding
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.ARG_USER


class TakePasswordFragment : Fragment() {
    lateinit var binding: FragmentTakePasswordBinding

    var user: UserTempInfo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTakePasswordBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        user = requireArguments().getSerializable(ARG_USER) as UserTempInfo?
    }

    private fun setClickListeners() {
        binding.btnContinue.setOnClickListener {
            if (binding.etPassword.text.toString() == binding.etConfirmPassword.text.toString()){
                user?.password = binding.etPassword.text.toString()
                val args = Bundle()
                args.putSerializable(ARG_USER, user)
                findNavController().navigate( R.id.action_takePasswordFragment_to_takeNameFragment, args)
            }
        }
         binding.etPassword.addTextChangedListener {
            if (it != null) {
                if (it.isEmpty() || binding.etConfirmPassword.text.isEmpty()){
                    binding.btnContinue.isEnabled = false
                    binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_grey_box_50, null)
                    binding.btnContinue.setTextColor(resources.getColor(R.color.navi_blue, null))
                }else{
                    binding.btnContinue.isEnabled = true
                    binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
                    binding.btnContinue.setTextColor(resources.getColor(R.color.white, null))
                }
            }
        }
        binding.etConfirmPassword.addTextChangedListener {
            if (it != null) {
                if (it.isEmpty() || binding.etPassword.text.isEmpty()){
                    binding.btnContinue.isEnabled = false
                    binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_grey_box_50, null)
                    binding.btnContinue.setTextColor(resources.getColor(R.color.navi_blue, null))
                }else{
                    binding.btnContinue.isEnabled = true
                    binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
                    binding.btnContinue.setTextColor(resources.getColor(R.color.white, null))
                }
            }
        }
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.ivPasswordShowHide.setOnClickListener {
            if(binding.etPassword.transformationMethod.equals(PasswordTransformationMethod.getInstance())){
                binding.apply{
                    ivPasswordShowHide.setImageResource(R.drawable.ic_eye_open_navi_blue)
                    etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    etPassword.setSelection(etPassword.length())
                }
            }else{
                binding.apply {
                    ivPasswordShowHide.setImageResource(R.drawable.ic_eye_close_navi_blue)
                    etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                    etPassword.setSelection(etPassword.length())
                }
            }
        }
        binding.ivConfirmPasswordShowHide.setOnClickListener {
            if(binding.etConfirmPassword.transformationMethod.equals(PasswordTransformationMethod.getInstance())){
                binding.apply{
                    ivConfirmPasswordShowHide.setImageResource(R.drawable.ic_eye_open_navi_blue)
                    etConfirmPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    etConfirmPassword.setSelection(etConfirmPassword.length())
                }
            }else{
                binding.apply {
                    ivConfirmPasswordShowHide.setImageResource(R.drawable.ic_eye_close_navi_blue)
                    etConfirmPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                    etConfirmPassword.setSelection(etConfirmPassword.length())
                }
            }
        }
    }

}