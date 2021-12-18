package com.findajob.jobamax.dashboard.home.training.masterclass

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.dashboard.home.training.masterclass.adapter.VideoDetailsAdapter
import com.findajob.jobamax.dashboard.home.training.masterclass.model.MasterClass
import com.findajob.jobamax.dashboard.home.training.masterclass.model.MasterClassVideo
import com.findajob.jobamax.databinding.FragmentMasterclassDetailsBinding

class MasterClassDetailsFragment : BaseFragmentMain<FragmentMasterclassDetailsBinding>(){
    lateinit var adapter: VideoDetailsAdapter
    lateinit var masterClass : MasterClass

    override val layoutRes: Int
        get() = R.layout.fragment_masterclass_details

    override fun onCreated(savedInstance: Bundle?) {
        initViews()
        initMockData()
    }

    override fun getViewModel(): ViewModel? {
        return null
    }

    private fun initMockData() {
        adapter.collection = MasterClassVideo.generateMockData()
        val a = 10;
    }

    private fun getArgs(){

    }

    private fun initViews() {
        binding.apply {
            adapter = VideoDetailsAdapter()
            rvMasterclassVideos.adapter = adapter
        }

        adapter.clickListener = {
        }

    }

}


