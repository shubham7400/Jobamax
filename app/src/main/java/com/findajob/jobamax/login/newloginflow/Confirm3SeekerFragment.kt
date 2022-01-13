package com.findajob.jobamax.login.newloginflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.FragmentConfirm3SeekerBinding
import com.findajob.jobamax.login.LoginViewModel
import com.findajob.jobamax.preference.setUserType
import com.findajob.jobamax.util.ROLE_JOB_SEEKER


class Confirm3SeekerFragment : Fragment() {
    lateinit var binding: FragmentConfirm3SeekerBinding
    lateinit var viewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentConfirm3SeekerBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnYes.setOnClickListener {
            requireContext().setUserType(2)
            viewModel.roleType = ROLE_JOB_SEEKER
            Navigation.findNavController(view).navigate(R.id.action_confirm3SeekerFragment_to_loginFragment)
        }
        binding.btnNo.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.noReactionFragment, null))
    }

    private fun configureUi() {
        viewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]
     }

}