package com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.review


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.OnlineCourseLoadStateFooterBinding

class ReviewsListStateLoaderAdapter(private val retry :() ->  Unit) :
        LoadStateAdapter<ReviewsListStateLoaderAdapter.LoadStateViewHolder>(

        ){

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val binding = OnlineCourseLoadStateFooterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return LoadStateViewHolder(binding)
    }

    inner class LoadStateViewHolder(private val binding: OnlineCourseLoadStateFooterBinding):
            RecyclerView.ViewHolder(binding.root){
        init {
            binding.retryBtn.setOnClickListener{
                retry.invoke()
            }
        }

        fun bind(loadState: LoadState){
            binding.apply {
                progressBar.isVisible = loadState is LoadState.Loading
                errorTextView.setText(R.string.reviews_error_loading)
                errorTextView.isVisible = loadState !is LoadState.Loading
                retryBtn.isVisible = loadState !is LoadState.Loading

            }
        }
    }

}