package com.findajob.jobamax.jobseeker.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerAddExperienceBinding
import com.findajob.jobamax.databinding.FragmentSeekerExperienceListBinding
import com.findajob.jobamax.databinding.FragmentSeekerProfileBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel

class SeekerExperienceListFragment : BaseFragmentMain<FragmentSeekerExperienceListBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_experience_list
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
         binding = FragmentSeekerExperienceListBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         setClickListeners()
    }

    private fun setClickListeners() {
         binding.btnAddExperience.setOnClickListener {
             binding.btnAddExperience.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerExperienceListFragment_to_seekerAddExperienceFragment, null))
         }
    }

    override fun onCreated(savedInstance: Bundle?) {

    }

}