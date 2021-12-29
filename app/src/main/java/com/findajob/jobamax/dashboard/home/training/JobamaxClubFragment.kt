package com.findajob.jobamax.dashboard.home.training

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.dashboard.home.training.masterclass.MasterClassActivity
import com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.OnlineCourseActivity
import com.findajob.jobamax.databinding.FragmentJobamaxClubBinding
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.training.ui.ManageRoomActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class JobamaxClubFragment : BaseFragmentMain<FragmentJobamaxClubBinding>(), View.OnClickListener {

    val viewModel: TrainingViewModel by activityViewModels()
    override fun getViewModel(): ViewModel {
        return viewModel
    }

    override val layoutRes: Int get() = R.layout.fragment_jobamax_club
    override fun onCreated(savedInstance: Bundle?) {
        binding.lifecycleOwner = this
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }
    private fun initViews() {
      setClickListeners()
    }

    private fun setClickListeners() {
        binding.itemMasterClass.setOnClickListener(this)
        binding.itemNetworking.setOnClickListener(this)
        binding.itemOnlineCourses.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
         when(view){
             binding.itemMasterClass -> {
                 startActivity(Intent(requireContext(), MasterClassActivity::class.java))
             }
             binding.itemNetworking -> {
                 startActivity(Intent(requireContext(), ManageRoomActivity::class.java))
             }
             binding.itemOnlineCourses -> {
                 startActivity(Intent(requireContext(), OnlineCourseActivity::class.java))
             }
         }
    }
}