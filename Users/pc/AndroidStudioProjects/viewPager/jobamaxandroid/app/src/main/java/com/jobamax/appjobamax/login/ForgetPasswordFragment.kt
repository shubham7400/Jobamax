package com.jobamax.appjobamax.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentForgetPasswordBinding
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.ARG_USER


class ForgetPasswordFragment : Fragment() {
    lateinit var binding: FragmentForgetPasswordBinding

    var user: UserTempInfo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentForgetPasswordBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        user = requireArguments().getSerializable(ARG_USER) as UserTempInfo?
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.btnContinue.setOnClickListener { toast("Clicked") }
        binding.etEmail.addTextChangedListener {
            if (it != null) {
                if (it.isEmpty()){
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
    }


}