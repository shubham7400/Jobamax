package com.findajob.jobamax.jobseeker.calender

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ActivitySeekerCalenderBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeekerCalenderActivity : AppCompatActivity() {
    lateinit var binding: ActivitySeekerCalenderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekerCalenderBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}