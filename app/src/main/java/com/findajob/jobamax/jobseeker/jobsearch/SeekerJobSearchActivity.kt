package com.findajob.jobamax.jobseeker.jobsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ActivitySeekerJobSearchBinding
import androidx.navigation.fragment.NavHostFragment
import com.findajob.jobamax.jobseeker.profile.idealjob.IOnBackPressed
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SeekerJobSearchActivity : AppCompatActivity() {
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