package com.findajob.jobamax.jobseeker.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ActivitySeekerProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeekerProfileActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivitySeekerProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekerProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureUi()
    }

    private fun configureUi() {
         setClickListeners()
    }

    private fun setClickListeners() {

    }

    override fun onClick(view: View?) {

    }


}