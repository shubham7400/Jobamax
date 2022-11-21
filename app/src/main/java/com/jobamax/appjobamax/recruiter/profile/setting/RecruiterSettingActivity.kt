package com.jobamax.appjobamax.recruiter.profile.setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.ActivityRecruiterSettingBinding
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.model.Recruiter
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel
import com.parse.ParseObject
import com.parse.ParseQuery

class RecruiterSettingActivity : AppCompatActivity() {
    val binding: ActivityRecruiterSettingBinding by lazy { ActivityRecruiterSettingBinding.inflate(layoutInflater) }

    val viewModel: RecruiterHomeViewModel by viewModels()
    lateinit var recruiter: Recruiter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        configureUi()
    }

    private fun configureUi() {
        setClickListeners()
        setRecruiter()
    }

    private fun setClickListeners() {

    }

    private fun setRecruiter() {
        recruiter = viewModel.recruiter
        if (viewModel.recruiterObject == null) {
            getRecruiter {
                if (it) {
                    recruiter = viewModel.recruiter
                }
            }
        }
    }

    fun getRecruiter(callback : (Boolean) -> Unit) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.RECRUITER.value)
        query.whereEqualTo(ParseTableName.RECRUITER_ID.value, getUserId())
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
                    viewModel.recruiterObject = parseObject
                    viewModel.isRecruiterUpdated.value = true
                    callback(true)
                }
            }
        }
    }


}