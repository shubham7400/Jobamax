package com.findajob.jobamax.dashboard.messages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.findajob.jobamax.R
import com.findajob.jobamax.jobseeker.profile.JobSeekerProfileFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        val jobSeekerProfileFragment = JobSeekerProfileFragment()
        fragmentTransaction.add(R.id.fragment_container, jobSeekerProfileFragment, "HELLO")
        fragmentTransaction.commit()
    }
}