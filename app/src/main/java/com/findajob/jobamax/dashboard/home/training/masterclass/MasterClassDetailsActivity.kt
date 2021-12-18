package com.findajob.jobamax.dashboard.home.training.masterclass

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.dashboard.home.training.masterclass.adapter.VideoDetailsAdapter
import com.findajob.jobamax.databinding.ActivityMasterClassDetailsBinding
import com.findajob.jobamax.extensions.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MasterClassDetailsActivity : BaseActivityMain<ActivityMasterClassDetailsBinding>(),
    MasterClassDetailsInterface {

    val viewModel: MasterClassViewModel by viewModels()
    val adapter: VideoDetailsAdapter by lazy {
        VideoDetailsAdapter()
    }

    override val layoutRes: Int
        get() = R.layout.activity_master_class_details

    override fun getViewModel(): ViewModel {
        return viewModel
    }

    override fun onCreated(instance: Bundle?) {
        binding.handler = this
        initScreen()
    }

    private fun initScreen() {
        observeLiveData()
        fetchData()
        initVideos()
    }

    private fun fetchData() {
        fetchVideoDetails()
        fetchVideoList()
    }

    private fun observeLiveData() {
        observeVideoDetails()
        observeVideoList()
    }

    private fun observeVideoList() {
        observe(viewModel.videoListLD) { videoList ->
            videoList?.let {
                adapter.collection = it
            }
        }
    }

    private fun observeVideoDetails() {
        observe(viewModel.videoDetailsLD) {
            binding.item = it
        }
    }

    private fun fetchVideoDetails() {
        viewModel.fetchVideoDetails()
    }

    private fun fetchVideoList() {
        viewModel.fetchVideoList()
    }

    private fun initVideos() {
        binding.apply {
            rvVideos.adapter = adapter
        }
    }

    override fun onBackPress() {
        onBackPressed()
    }
}

interface MasterClassDetailsInterface {
    fun onBackPress()
}