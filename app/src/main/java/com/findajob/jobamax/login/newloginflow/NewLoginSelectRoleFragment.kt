package com.findajob.jobamax.login.newloginflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.FragmentNewLoginSelectRoleBinding


class NewLoginSelectRoleFragment : Fragment() {
    lateinit var binding: FragmentNewLoginSelectRoleBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNewLoginSelectRoleBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         binding.btnYes.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.confirm1SeekerFragment, null))
         binding.btnNo.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.confirmRecruiterFragment, null))
    }

}