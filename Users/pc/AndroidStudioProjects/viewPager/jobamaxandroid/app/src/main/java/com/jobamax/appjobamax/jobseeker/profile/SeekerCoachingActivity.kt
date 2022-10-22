package com.jobamax.appjobamax.jobseeker.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.ActivitySeekerCoachingBinding
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.preference.getUserId
import com.parse.ParseObject
import com.parse.ParseQuery

class SeekerCoachingActivity : AppCompatActivity() {
    lateinit var binding: ActivitySeekerCoachingBinding

    val viewModel: SeekerHomeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekerCoachingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureUi()
    }

    private fun configureUi() {
        setClickListeners()
        viewModelObserver()
        if (viewModel.jobSeekerObject == null){
            getCurrent()
        }
    }

    private fun viewModelObserver() {
        viewModel.isJobSeekerUpdated.observe(this) {
        }
    }


    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
             onBackPressed()
        }
        binding.btnContact.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("support@jobamax.com"))
            intent.putExtra(Intent.EXTRA_TEXT, "Write a message to one of our career coaches!")
            intent.type = "message/rfc822"
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            try {
                startActivity(intent)
            }catch (e: Exception){
                toast(e.message.toString())
            }
        }
    }



    private fun getCurrent( ) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value,  getUserId())
        query.include("portfolio")
        query.include("idealJob")
        query.findInBackground { it, e ->
            val jobSeeker = it?.firstOrNull()
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                jobSeeker == null -> {
                    toast("User Not Found.")
                }
                else -> {
                    viewModel.jobSeekerObject = jobSeeker
                    viewModel.isJobSeekerUpdated.value = true
                }
            }
        }
    }
}