package com.findajob.jobamax.dashboard.home.training.masterclass

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findajob.jobamax.dashboard.home.training.masterclass.model.MasterClassVideo
import com.findajob.jobamax.data.pojo.VideoDetails

class MasterClassViewModel(val context: Application) : AndroidViewModel(context) {

    private val _videoDetailsLD: MutableLiveData<VideoDetails> by lazy {
        MutableLiveData()
    }

    private val _videoListLD: MutableLiveData<List<MasterClassVideo>> by lazy {
        MutableLiveData()
    }
    val videoDetailsLD: LiveData<VideoDetails> by lazy {
        _videoDetailsLD
    }

    val videoListLD: LiveData<List<MasterClassVideo>> by lazy {
        _videoListLD
    }

    fun fetchVideoDetails() {
        _videoDetailsLD.value = VideoDetails.generateMockUpData()
    }

    fun fetchVideoList() {
        _videoListLD.value = MasterClassVideo.generateMockData()
    }
}