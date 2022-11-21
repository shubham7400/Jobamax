package com.jobamax.appjobamax.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentTakeAgeBinding
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.ARG_USER


class TakeAgeFragment : Fragment() {
    lateinit var binding: FragmentTakeAgeBinding

    var user: UserTempInfo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTakeAgeBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        user = requireArguments().getSerializable(ARG_USER) as UserTempInfo?
    }

    private fun setClickListeners() {
        binding.btnContinue.setOnClickListener {
            user?.age = "${binding.etAge1.text}${binding.etAge2.text}" .toInt()
            val args = Bundle()
            args.putSerializable(ARG_USER, user)
            findNavController().navigate(R.id.action_takeAgeFragment_to_takeUniversityFragment, args)
        }
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.etAge1.addTextChangedListener {
            if (it != null) {
                if (it.isEmpty() || binding.etAge2.text.isEmpty()) {
                    binding.btnContinue.isEnabled = false
                    binding.btnContinue.background =
                        resources.getDrawable(R.drawable.rounded_grey_box_50, null)
                    binding.btnContinue.setTextColor(resources.getColor(R.color.navi_blue, null))
                } else {
                    try {
                        val age = (binding.etAge1.text.toString().trim()+binding.etAge2.text.toString().trim()).toInt()
                        if (age > 16){
                            binding.tvAgeError.visibility = View.GONE
                            binding.btnContinue.isEnabled = true
                            binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
                            binding.btnContinue.setTextColor(resources.getColor(R.color.white, null))
                        }else{
                            binding.tvAgeError.visibility = View.VISIBLE
                        }
                    }catch (e: Exception){}
                }
            }
            changeAgeEditTextFocus()
        }
        binding.etAge2.addTextChangedListener {
            if (it != null) {
                if (it.isEmpty() || binding.etAge1.text.isEmpty()) {
                    binding.tvAgeError.visibility = View.GONE
                    binding.btnContinue.isEnabled = false
                    binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_grey_box_50, null)
                    binding.btnContinue.setTextColor(resources.getColor(R.color.navi_blue, null))
                } else {
                    try {
                        val age = (binding.etAge1.text.toString().trim()+binding.etAge2.text.toString().trim()).toInt()
                        println("fdsfk $age")
                        if (age > 16){
                            binding.tvAgeError.visibility = View.GONE
                            binding.btnContinue.isEnabled = true
                            binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
                            binding.btnContinue.setTextColor(resources.getColor(R.color.white, null))
                        } else{
                            binding.tvAgeError.visibility = View.VISIBLE
                        }
                    }catch (e: Exception){}
                }
            }
            changeAgeEditTextFocus()
        }
        binding.clMostParent.setOnClickListener {
            binding.etAge1.clearFocus()
            binding.etAge2.clearFocus()
        }
    }

    private fun changeAgeEditTextFocus() {
        if (binding.etAge1.text.isNullOrEmpty()) {
            binding.etAge1.requestFocus()
        } else {
            if (binding.etAge2.text.isEmpty()) {
                binding.etAge2.requestFocus()
            }
        }
    }

}