package com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.databinding.ActivityOnlineCourseBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnlineCourseActivity : BaseActivityMain<ActivityOnlineCourseBinding>() {

    override val layoutRes: Int
        get() = R.layout.activity_online_course

    override fun getViewModel(): ViewModel? {
        return null
    }

    override fun onCreated(instance: Bundle?) {
        binding.lifecycleOwner = this

    }

}