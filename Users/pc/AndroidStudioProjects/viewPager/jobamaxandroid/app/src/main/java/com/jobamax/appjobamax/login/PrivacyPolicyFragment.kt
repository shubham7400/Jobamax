package com.jobamax.appjobamax.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentPrivacyPolicyBinding
import com.jobamax.appjobamax.databinding.FragmentUserRoleBinding
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.ARG_USER


class PrivacyPolicyFragment : Fragment() {
    lateinit var binding: FragmentPrivacyPolicyBinding

    var user: UserTempInfo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPrivacyPolicyBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        user = requireArguments().getSerializable(ARG_USER) as UserTempInfo?
    }

    private fun setClickListeners() {
        binding.btnAgree.setOnClickListener {
            val args = Bundle()
            args.putSerializable(ARG_USER, user)
            findNavController().navigate(R.id.action_privacyPolicyFragment_to_takeEmailFragment, args)
        }
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
    }

}