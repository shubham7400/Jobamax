package com.findajob.jobamax.jobseeker.course

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.BaseActivity
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.dashboard.home.training.masterclass.MasterClassActivity
import com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.OnlineCourseActivity
import com.findajob.jobamax.databinding.ActivityJobSeekerCourseBinding
import com.findajob.jobamax.training.ui.ManageRoomActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobSeekerCourseActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var binding: ActivityJobSeekerCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobSeekerCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.itemMasterClass.setOnClickListener(this)
        binding.itemNetworking.setOnClickListener(this)
        binding.itemOnlineCourses.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.itemMasterClass -> {
                startActivity(Intent(this, MasterClassActivity::class.java))
            }
            binding.itemNetworking -> {
                startActivity(Intent(this, ManageRoomActivity::class.java))
            }
            binding.itemOnlineCourses -> {
                startActivity(Intent(this, OnlineCourseActivity::class.java))
            }
        }
    }

}