package com.findajob.jobamax.jobseeker.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ActivitySeekerProfileBinding
import com.findajob.jobamax.jobseeker.profile.idealjob.IOnBackPressed
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeekerProfileActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivitySeekerProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekerProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureUi()
    }

    private fun configureUi() {
         setClickListeners()
    }

    private fun setClickListeners() {

    }

    override fun onClick(view: View?) {

    }

    override fun onBackPressed() {
        val fragment = this.supportFragmentManager.findFragmentById(R.id.nav_seeker_profile_fragment) as? NavHostFragment
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