package com.jobamax.appjobamax.login

import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentTakeEmailBinding
import com.jobamax.appjobamax.dialog.BasicDialog
import com.jobamax.appjobamax.dialog.MessageDialog
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.ARG_USER
import com.jobamax.appjobamax.util.isValidEmail
import com.parse.ParseObject
import com.parse.ParseQuery


class TakeEmailFragment : BaseFragment() {
    lateinit var binding: FragmentTakeEmailBinding

    var user: UserTempInfo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTakeEmailBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        user = requireArguments().getSerializable(ARG_USER) as UserTempInfo?
        log("fdsfsdaf email ${user?.email} loginType ${user?.loginType} userType ${user?.userType}")
        user?.email?.let {
            binding.etEmailName.setText(it.substringBefore("@", ""))
            binding.etEmailDomain.setText(it.substringAfter("@", ""))
        }
    }




    private fun setClickListeners() {
        binding.btnContinue.setOnClickListener {
            val email = "${binding.etEmailName.text.trim()}${binding.etEmailAt.text.trim()}${binding.etEmailDomain.text.trim()}"
            if (email.isValidEmail()){
                user?.email = email
                user?.let { it1 ->
                    isEmailAlreadyRegistered(it1) {
                        val args = Bundle()
                        args.putSerializable(ARG_USER, user)
                        findNavController().navigate(R.id.action_takeEmailFragment_to_takePasswordFragment, args)
                    }
                }
            }else{
                MessageDialog(requireActivity(), "The email address is invalid"){}.show()
            }
        }
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.etEmailName.addTextChangedListener {
            user?.email = it.toString()
            if (it != null) {
                if ( it.isEmpty() || binding.etEmailDomain.text.isEmpty()){
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
        binding.etEmailDomain.addTextChangedListener {
            user?.email = it.toString()
            if (it != null) {
                if ( binding.etEmailName.text.isEmpty() || it.isEmpty()){
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

    private fun isEmailAlreadyRegistered(user: UserTempInfo, callback : () -> Unit) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereContains(ParseTableFields.EMAIL.value, user.email)
        progressHud.show()
        query.getFirstInBackground { result, e ->
            progressHud.dismiss()
            when{
                result != null -> {
                    BasicDialog(requireActivity(), "User is already registered with this email.", true){}.show()
                }
                else -> {
                    callback()
                }
            }
        }
    }

}