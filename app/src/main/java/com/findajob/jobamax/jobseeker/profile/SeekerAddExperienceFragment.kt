package com.findajob.jobamax.jobseeker.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerAddExperienceBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel

class SeekerAddExperienceFragment : BaseFragmentMain<FragmentSeekerAddExperienceBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_add_experience
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerAddExperienceBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {

    }

    override fun onCreated(savedInstance: Bundle?) {

    }

}