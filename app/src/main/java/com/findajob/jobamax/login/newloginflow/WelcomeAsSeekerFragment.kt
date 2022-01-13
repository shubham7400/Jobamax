package com.findajob.jobamax.login.newloginflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.FragmentWelcomeAsSeekerBinding
import com.findajob.jobamax.login.LoginViewModel
import com.findajob.jobamax.preference.setUserType
import com.findajob.jobamax.util.ROLE_JOB_SEEKER

class WelcomeAsSeekerFragment : Fragment() {
     lateinit var binding: FragmentWelcomeAsSeekerBinding
    lateinit var viewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentWelcomeAsSeekerBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        viewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]

        sendToLogin()
    }

    private fun sendToLogin() {
        requireContext().setUserType(2)
        viewModel.roleType = ROLE_JOB_SEEKER
        binding.btnGotIt.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.loginFragment, null))
    }

}