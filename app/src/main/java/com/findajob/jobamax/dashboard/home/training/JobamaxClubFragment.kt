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
class JobamaxClubFragment : BaseFragmentMain<FragmentJobamaxClubBinding>() {

    val viewModel: TrainingViewModel by activityViewModels()
    override fun getViewModel(): ViewModel {
        return viewModel
    }

    val adapter: TrainingAdapter by lazy {
        TrainingAdapter()
    }


    override val layoutRes: Int
        get() = R.layout.fragment_jobamax_club

    override fun onCreated(savedInstance: Bundle?) {
        binding.lifecycleOwner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeLiveData()
        fetchCourses()
    }

    private fun initViews() {
        initCourseRV()
    }


    private fun observeLiveData() {
        observerCourses()
    }

    private fun observerCourses() {
        observe(viewModel.courseLiveData) { data ->
            data?.let {
                adapter.collection = it
            }
        }
    }

    private fun fetchCourses() {
        viewModel.fetchCourses()
    }

    private fun initCourseRV() {
        binding.apply {
            homeRvData.adapter = adapter
        }
        adapter.clickListener = { course ->
            when (course.id) {
                0 -> {
                    startActivity(Intent(requireContext(), MasterClassActivity::class.java))
                }
                1 -> {
//                    findNavController().navigate(R.id.action_trainingFragment_to_onlineCoursesListFragment)
                    startActivity(Intent(requireContext(), OnlineCourseActivity::class.java))
                }
                2 -> {
                    startActivity(Intent(requireContext(), ManageRoomActivity::class.java))
                }
                else -> {
                    val bundle = bundleOf("courseId" to course.id)
                    findNavController().navigate(R.id.trainingFragment_to_coursesFragment, bundle)
                }
            }
        }
    }
}