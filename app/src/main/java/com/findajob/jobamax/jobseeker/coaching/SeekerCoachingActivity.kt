package com.findajob.jobamax.jobseeker.coaching

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ActivitySeekerCoachingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeekerCoachingActivity : AppCompatActivity() {
    lateinit var binding: ActivitySeekerCoachingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekerCoachingBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}