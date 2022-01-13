package com.findajob.jobamax.login.newloginflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.FragmentConfirm1SeekerBinding


class Confirm1SeekerFragment : Fragment() {
    lateinit var binding: FragmentConfirm1SeekerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentConfirm1SeekerBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        binding.btnYes.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.welcomeAsSeekerFragment, null))
        binding.btnNo.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.confirm2SeekerFragment, null))
    }

}