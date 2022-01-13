package com.findajob.jobamax.jobseeker.profile.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.findajob.jobamax.BaseActivity
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ActivityJobSeekerAccountBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobSeekerAccountActivity : BaseActivity() {
    lateinit var binding: ActivityJobSeekerAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobSeekerAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureUi()
    }

    private fun configureUi() {

    }
}