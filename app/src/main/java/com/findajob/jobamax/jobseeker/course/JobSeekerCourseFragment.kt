package com.findajob.jobamax.jobseeker.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.BaseFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentJobSeekerCourseBinding
import com.findajob.jobamax.util.log
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobSeekerCourseFragment : BaseFragmentMain<FragmentJobSeekerCourseBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_job_seeker_course

    override fun onCreated(savedInstance: Bundle?) {
        log("Created")
    }

    override fun getViewModel(): ViewModel? {
        return null
    }

}