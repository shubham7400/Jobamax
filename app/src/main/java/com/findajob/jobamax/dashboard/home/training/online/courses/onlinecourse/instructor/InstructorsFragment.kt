package com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.instructor

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.OnlineCourseViewModel
import com.findajob.jobamax.databinding.FragmentInstructorsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InstructorsFragment : BaseFragmentMain<FragmentInstructorsBinding>() {

    private lateinit var adapter: InstructorsAdapter

    private val viewModel: OnlineCourseViewModel by activityViewModels()

    override val layoutRes: Int
        get() = R.layout.fragment_instructors

    override fun onCreated(savedInstance: Bundle?) {
        binding.lifecycleOwner = this
        initViews()

        binding.viewmodel = viewModel

        adapter.collection = viewModel.instructors!!
    }

    override fun getViewModel(): ViewModel? {
        return viewModel
    }


    private fun initViews() {
        adapter = InstructorsAdapter()

        binding.apply {
            onlineCourseInstructorsData.adapter = adapter
        }

    }

}

