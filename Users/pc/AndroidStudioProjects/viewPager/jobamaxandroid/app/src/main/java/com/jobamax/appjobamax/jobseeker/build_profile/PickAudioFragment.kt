package com.jobamax.appjobamax.jobseeker.build_profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentPickAudioBinding


class PickAudioFragment : Fragment() {
    lateinit var binding: FragmentPickAudioBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPickAudioBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         setClickListeners()
    }

    private fun setClickListeners() {
        binding.clAudioIntro.setOnClickListener {
            findNavController().navigate(R.id.action_pickAudioFragment_to_addAudioFragment, null)
        }
    }

}