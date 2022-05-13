package com.findajob.jobamax.jobseeker.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ActivityJobSeekerHomeBinding
import com.findajob.jobamax.enums.ParseCloudFunction
import com.findajob.jobamax.jobseeker.profile.idealjob.IOnBackPressed
import com.findajob.jobamax.preference.*
import com.findajob.jobamax.util.toast
import com.parse.FunctionCallback
import com.parse.ParseCloud
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobSeekerHomeActivity : AppCompatActivity()  {
    lateinit var binding: ActivityJobSeekerHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobSeekerHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAppEnterTime((System.currentTimeMillis() / 1000).toString())
    }

    override fun onBackPressed() {
        val fragment = this.supportFragmentManager.findFragmentById(R.id.nav_seeker_home_container) as? NavHostFragment
        val currentFragment = fragment?.childFragmentManager?.fragments?.get(0) as? IOnBackPressed
        if (currentFragment != null) {
            currentFragment.onBackPressed {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        saveSpentTimeOnJobSearch()
    }

    private fun saveSpentTimeOnJobSearch() {
        if (getAppEnterTime() != ""){
            val request = HashMap<String, Any>().also {
                it["jobSeekerId"] = getUserId()
                it["enterTime"] = getAppEnterTime().toLong()
                it["leaveTime"] = System.currentTimeMillis() / 1000
                it["type"] = 2
            }
            ParseCloud.callFunctionInBackground(ParseCloudFunction.SAVE_SPENT_TIME.value, request, FunctionCallback<Any> { result, e ->
                if (e != null) {
                    try {
                        toast(e.message.toString())
                    }catch (e: Exception){}
                }
                setAppEnterTime("")
            })
        }
        setAppEnterTime("")
    }

}

