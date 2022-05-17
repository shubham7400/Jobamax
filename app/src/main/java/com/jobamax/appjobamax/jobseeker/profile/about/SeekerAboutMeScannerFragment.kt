package com.jobamax.appjobamax.jobseeker.profile.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jobamax.appjobamax.databinding.FragmentSeekerAboutMeScannerBinding

class SeekerAboutMeScannerFragment : Fragment() {
    lateinit var binding: FragmentSeekerAboutMeScannerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerAboutMeScannerBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         binding.ivBackButton.setOnClickListener {
             requireActivity().onBackPressed()
         }
    }

}