package com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.syllabus



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.databinding.OnlineCourseLoadStateFooterBinding

class SyllabusListStateLoaderAdapter(private val retry :() ->  Unit) :
        LoadStateAdapter<SyllabusListStateLoaderAdapter.LoadStateViewHolder>(

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
                errorTextView.isVisible = loadState is LoadState.Error
                retryBtn.isVisible = loadState is LoadState.Error

            }
        }
    }

}