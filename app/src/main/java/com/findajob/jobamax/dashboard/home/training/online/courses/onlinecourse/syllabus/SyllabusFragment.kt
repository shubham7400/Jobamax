package com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.syllabus

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.paging.LoadState
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.OnlineCourseViewModel
import com.findajob.jobamax.databinding.FragmentSyllabusBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SyllabusFragment : BaseFragmentMain<FragmentSyllabusBinding>() {

    lateinit var adapter: SyllabusAdapter

    private val viewModel: OnlineCourseViewModel by activityViewModels()

    override val layoutRes: Int
        get() = R.layout.fragment_syllabus

    override fun onCreated(savedInstance: Bundle?) {
        initViews()
        binding.viewmodel = viewModel

        viewModel.syllabus!!.observe(viewLifecycleOwner) {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }

    }

    override fun getViewModel(): ViewModel? {
        return viewModel
    }

    private fun initViews() {

        adapter = SyllabusAdapter()

        binding.apply {
            onlineCourseSyllabusData.setHasFixedSize(false)
            onlineCourseSyllabusData.itemAnimator = null


            onlineCourseSyllabusData.adapter = adapter
                .withLoadStateHeaderAndFooter(
                    header = SyllabusListStateLoaderAdapter { adapter.retry() },
                    footer = SyllabusListStateLoaderAdapter { adapter.retry() }
                )



            retryButton.setOnClickListener {
                adapter.retry()
            }


            adapter.addLoadStateListener { loadState ->
                binding.apply {
                    progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                    onlineCourseSyllabusData.isVisible =
                        loadState.source.refresh is LoadState.NotLoading
                    retryButton.isVisible = loadState.source.refresh is LoadState.Error
                    errorTextView.isVisible = loadState.source.refresh is LoadState.Error

                    if (loadState.source.refresh is LoadState.NotLoading &&
                        loadState.append.endOfPaginationReached &&
                        adapter.itemCount < 1
                    ) {
                        onlineCourseSyllabusData.isVisible = false
                        noResultTextView.isVisible = true
                    } else {
                        noResultTextView.isVisible = false
                    }
                }
            }


        }

    }

}
