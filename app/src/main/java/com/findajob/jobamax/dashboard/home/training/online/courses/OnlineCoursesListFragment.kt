package com.findajob.jobamax.dashboard.home.training.online.courses

import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.paging.LoadState
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.OnlineCourseDetailsActivity
import com.findajob.jobamax.databinding.FragmentOnlineCoursesListBinding
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.util.ONLINE_COURSE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnlineCoursesListFragment : BaseFragmentMain<FragmentOnlineCoursesListBinding>() {

    val adapter: OnlineCoursesListAdapter by lazy {
        OnlineCoursesListAdapter()
    }

    private val viewModel: OnlineCoursesListViewModel by activityViewModels()

    override val layoutRes: Int
        get() = R.layout.fragment_online_courses_list

    override fun onCreated(savedInstance: Bundle?) {
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        initViews()
        observeLiveData()
    }

    private fun observeLiveData() {
        observeOnlineCourses()
    }


    private fun observeOnlineCourses() {
        observe(viewModel.onlineCourses) {
            if (it != null) {
                adapter.submitData(viewLifecycleOwner.lifecycle, it)
            }
        }
    }

    override fun getViewModel(): ViewModel? {
        return viewModel
    }

    private fun initViews() {

        binding.ivBack.setOnClickListener { requireActivity().onBackPressed() }
        binding.apply {
            onlineCoursesRvData.setHasFixedSize(true)
            onlineCoursesRvData.itemAnimator = null

            onlineCoursesRvData.adapter = adapter.withLoadStateHeaderAndFooter(
                header = OnlineCoursesListStateLoadAdapter { adapter.retry() },
                footer = OnlineCoursesListStateLoadAdapter { adapter.retry() }
            )

            retryButton.setOnClickListener {
                adapter.retry()
            }

            onlineCoursesSearchView.setOnQueryTextListener(
                object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        if (query != null) {
                            binding.onlineCoursesRvData.scrollToPosition(0)
                            viewModel.searchCourses(query)
                            onlineCoursesSearchView.clearFocus()
                        }


                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        if (newText != null) {
                            if (newText.length == 0) {
                                binding.onlineCoursesRvData.scrollToPosition(0)
                                viewModel.searchCourses("")
                                onlineCoursesSearchView.clearFocus()
                            }
                        }
                        return true
                    }
                })

            adapter.addLoadStateListener { loadState ->
                binding.apply {
                    progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                    onlineCoursesRvData.isVisible = loadState.source.refresh is LoadState.NotLoading
                    retryButton.isVisible = loadState.source.refresh is LoadState.Error
                    errorTextView.isVisible = loadState.source.refresh is LoadState.Error

                    if (loadState.source.refresh is LoadState.NotLoading &&
                        loadState.append.endOfPaginationReached &&
                        adapter.itemCount < 1
                    ) {
                        onlineCoursesRvData.isVisible = false
                        noResultTextView.isVisible = true
                    } else {
                        noResultTextView.isVisible = false
                    }
                }
            }

        }

        adapter.clickListener = {
            val onlineCourse = it
            val intent = Intent(requireActivity(), OnlineCourseDetailsActivity::class.java)
            intent.putExtra(ONLINE_COURSE, onlineCourse)
            requireActivity().startActivity(intent)
        }
    }


}

