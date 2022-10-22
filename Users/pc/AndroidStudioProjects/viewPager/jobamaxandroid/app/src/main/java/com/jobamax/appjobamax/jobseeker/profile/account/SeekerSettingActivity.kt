package com.jobamax.appjobamax.jobseeker.profile.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.ActivitySeekerSettingBinding
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.preference.getUserId
import com.parse.ParseObject
import com.parse.ParseQuery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeekerSettingActivity : AppCompatActivity() {
    lateinit var binding: ActivitySeekerSettingBinding

    val viewModel: SeekerHomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekerSettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
                    log("flsajkl ${parseObject.get("jobSeekerId")}")
                    viewModel.jobSeekerObject = parseObject
                    viewModel.isJobSeekerUpdated.value = true
                    callback(true)
                }
            }
        }
    }
}