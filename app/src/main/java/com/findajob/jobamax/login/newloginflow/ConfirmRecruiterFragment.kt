package com.findajob.jobamax.login.newloginflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.FragmentConfirmRecruiterBinding
import com.findajob.jobamax.login.LoginViewModel
import com.findajob.jobamax.preference.setUserType
import com.findajob.jobamax.util.ROLE_RECRUITER


class ConfirmRecruiterFragment : Fragment() {
    lateinit var binding: FragmentConfirmRecruiterBinding
    lateinit var viewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentConfirmRecruiterBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnYes.setOnClickListener {
            requireContext().setUserType(1)
            viewModel.roleType = ROLE_RECRUITER
            /*Navigation.findNavController(view).navigate(R.id.action_confirmRecruiterFragment_to_loginFragment)*/
        }
        binding.btnNo.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.confirm3SeekerFragment, null))
    }

    private fun configureUi() {
        viewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]
    }

}