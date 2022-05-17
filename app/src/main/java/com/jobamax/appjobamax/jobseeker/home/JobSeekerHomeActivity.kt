package com.jobamax.appjobamax.jobseeker.home

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseActivity
import com.jobamax.appjobamax.databinding.ActivityJobSeekerHomeBinding
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.jobseeker.profile.idealjob.IOnBackPressed
import com.jobamax.appjobamax.preference.*
import com.jobamax.appjobamax.util.toast
import com.parse.FunctionCallback
import com.parse.ParseCloud
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobSeekerHomeActivity : BaseActivity()  {
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

