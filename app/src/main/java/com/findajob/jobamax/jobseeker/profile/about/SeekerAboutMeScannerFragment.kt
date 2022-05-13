package com.findajob.jobamax.jobseeker.profile.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.FragmentSeekerAboutMeBinding
import com.findajob.jobamax.databinding.FragmentSeekerAboutMeScannerBinding

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