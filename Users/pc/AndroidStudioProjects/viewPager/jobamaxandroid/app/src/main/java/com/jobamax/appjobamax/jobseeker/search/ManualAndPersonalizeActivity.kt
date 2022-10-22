package com.jobamax.appjobamax.jobseeker.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.preference.getUserId
import com.parse.ParseObject
import com.parse.ParseQuery

class ManualAndPersonalizeActivity : AppCompatActivity() {

    val viewModel: SeekerHomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_and_personalize)
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