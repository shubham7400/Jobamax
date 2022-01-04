package com.findajob.jobamax.jobseeker.track

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.findajob.jobamax.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobSeekerApplyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_seeker_apply)
    }
}