package com.jobamax.appjobamax.jobseeker.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseActivity
import com.jobamax.appjobamax.databinding.ActivitySeekerCreateCvBinding
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.preference.getUserId
import com.parse.ParseObject
import com.parse.ParseQuery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeekerCreateCvActivity : BaseActivity() {
    val binding: ActivitySeekerCreateCvBinding by lazy { ActivitySeekerCreateCvBinding.inflate(layoutInflater) }

    val viewModel: SeekerHomeViewModel by viewModels()

    var modifyCvScreenPositionY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        configureUi()
    }

    private fun configureUi() {
        if (viewModel.jobSeekerObject == null){
            progressHud.show()
            getJobSeeker { progressHud.dismiss() }
        }
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