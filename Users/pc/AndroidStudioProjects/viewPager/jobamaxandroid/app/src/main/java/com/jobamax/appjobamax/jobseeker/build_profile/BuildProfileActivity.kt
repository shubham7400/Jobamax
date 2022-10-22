package com.jobamax.appjobamax.jobseeker.build_profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.jobamax.appjobamax.databinding.ActivityBuildProfileBinding
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.preference.getUserId
import com.parse.ParseObject
import com.parse.ParseQuery

class BuildProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityBuildProfileBinding
    val viewModel: SeekerHomeViewModel by viewModels()

    private fun setViewModelObservers() {
        viewModel.isJobSeekerUpdated.observe(this) {
            if (it){
                val jobSeeker = viewModel.jobSeeker
                log("fjls $jobSeeker  ${jobSeeker.email}")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuildProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getJobSeeker {}
        setViewModelObservers()
    }

    fun getJobSeeker(callback : (Boolean) -> Unit) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, getUserId())
        query.findInBackground { it, e ->
            val parseObject = it?.firstOrNull()
            when {
                e != null -> {
                    log(e.message.toString())
                    callback(false)
                }
                parseObject == null -> {
                    log("User Not Found")
                    callback(false)
                }
                else -> {
                    viewModel.jobSeekerObject = parseObject
                    viewModel.isJobSeekerUpdated.value = true
                    callback(true)
                }
            }
        }
    }

}