package com.jobamax.appjobamax.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentTakeNameBinding
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.ARG_USER

class TakeNameFragment : Fragment() {
    lateinit var binding: FragmentTakeNameBinding

    var user: UserTempInfo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTakeNameBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        user = requireArguments().getSerializable(ARG_USER) as UserTempInfo?
    }

    private fun setClickListeners() {
        binding.btnContinue.setOnClickListener {
            user?.firstName = binding.etFirstName.text.toString()
            user?.lastName = binding.etName.text.toString()
            val args = Bundle()
            args.putSerializable(ARG_USER, user)
            findNavController().navigate( R.id.action_takeNameFragment_to_takeAgeFragment, args)
        }
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.etFirstName.addTextChangedListener {
            if (it != null) {
                if (it.isEmpty() || binding.etName.text.isEmpty()){
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
        binding.etName.addTextChangedListener {
            if (it != null) {
                if (it.isEmpty() || binding.etFirstName.text.isEmpty()){
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