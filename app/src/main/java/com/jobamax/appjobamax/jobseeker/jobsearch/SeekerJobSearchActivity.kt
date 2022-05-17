package com.jobamax.appjobamax.jobseeker.jobsearch

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.jobamax.appjobamax.BaseActivity
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.ActivitySeekerJobSearchBinding
import com.jobamax.appjobamax.jobseeker.profile.idealjob.IOnBackPressed
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeekerJobSearchActivity : BaseActivity() {
    lateinit var binding: ActivitySeekerJobSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekerJobSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        val fragment = this.supportFragmentManager.findFragmentById(R.id.nav_seeker_job_search_fragment) as? NavHostFragment
        val currentFragment = fragment?.childFragmentManager?.fragments?.get(0) as? IOnBackPressed
        if (currentFragment != null) {
            currentFragment.onBackPressed {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }


}
