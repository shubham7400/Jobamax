package com.findajob.jobamax.jobseeker.track.newtrack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ActivitySeekerJobTrackingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeekerJobTrackingActivity : AppCompatActivity() {
    lateinit var binding: ActivitySeekerJobTrackingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekerJobTrackingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureUi()
    }

    private fun configureUi() {

    }
}