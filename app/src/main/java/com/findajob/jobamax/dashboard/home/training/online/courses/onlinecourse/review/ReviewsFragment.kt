package com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.review

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.paging.LoadState
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.OnlineCourseViewModel
import com.findajob.jobamax.databinding.FragmentReviewsBinding
import com.findajob.jobamax.extensions.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReviewsFragment : BaseFragmentMain<FragmentReviewsBinding>() {

    lateinit var adapter: ReviewsListAdapter

    private val viewModel: OnlineCourseViewModel by activityViewModels()


    override val layoutRes: Int
        get() = R.layout.fragment_reviews

    override fun onCreated(savedInstance: Bundle?) {
        binding.lifecycleOwner = this

        initViews()

        binding.viewmodel = viewModel
        observeLiveData()

    }

    private fun observeLiveData() {
        viewModel.reviews?.let { reviews ->
            observe(reviews) {
                if (it != null) {
                    adapter.submitData(viewLifecycleOwner.lifecycle, it)

                }
            }
        }
    }

    override fun getViewModel(): ViewModel? {
        return viewModel
    }


    private fun initViews() {

        adapter = ReviewsListAdapter()

        binding.apply {
            onlineCourseReviewData.setHasFixedSize(false)
            onlineCourseReviewData.itemAnimator = null


            onlineCourseReviewData.adapter = adapter.withLoadStateHeaderAndFooter(
                header = ReviewsListStateLoaderAdapter { adapter.retry() },
                footer = ReviewsListStateLoaderAdapter { adapter.retry() }
            )

            retryButton.setOnClickListener {
                adapter.retry()
            }


            adapter.addLoadStateListener { loadState ->
                binding.apply {
                    progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                    onlineCourseReviewData.isVisible =
                        loadState.source.refresh is LoadState.NotLoading
                    retryButton.isVisible = loadState.source.refresh is LoadState.Error
                    errorTextView.isVisible = loadState.source.refresh is LoadState.Error

                    if (loadState.source.refresh is LoadState.NotLoading &&
                        loadState.append.endOfPaginationReached &&
                        adapter.itemCount < 1
                    ) {
                        onlineCourseReviewData.isVisible = false
                        noResultTextView.isVisible = true
                    } else {
                        noResultTextView.isVisible = false
                    }
                }
            }


        }

    }


}