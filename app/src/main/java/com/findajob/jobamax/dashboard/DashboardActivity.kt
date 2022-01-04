package com.findajob.jobamax.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.findajob.jobamax.R
import com.findajob.jobamax.dashboard.messages.MessagesFragment
import com.findajob.jobamax.dashboard.profile.ProfileFragment
import com.findajob.jobamax.dashboard.search.SearchFragment
import com.findajob.jobamax.databinding.ActivityDashboardBinding
import com.findajob.jobamax.jobseeker.course.JobSeekerCourseActivity
import com.findajob.jobamax.util.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class DashboardActivity : AppCompatActivity() {

    lateinit var vpa: ViewPagerAdapter
    lateinit var vm: DashboardViewModel
    lateinit var binding: ActivityDashboardBinding
//    lateinit var handler: DashboardHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        vm = ViewModelProvider(this).get(DashboardViewModel::class.java)

        setupViewPager()
        initObservers()
        initView()
    }

    private fun initObservers() {

//        binding.handler = this
//        binding.lifecycleOwner = this
        binding.vm = vm
        binding.viewPagerAdapter = vpa
    }

    private fun initView() {
        binding.dashboardBnv.addOnTabSelectedListener(
            TabLayout.ViewPagerOnTabSelectedListener(
                binding.dashboardVp
            )
        )
        binding.dashboardVp.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.dashboardBnv))
    }

    private fun setupViewPager() {
        vpa = ViewPagerAdapter(supportFragmentManager)

       /* vpa.addFragment(JobSeekerCourseActivity(), JobSeekerCourseActivity::class.java.simpleName)
        binding.dashboardBnv.addTab(binding.dashboardBnv.newTab().setIcon(R.drawable.ic_home))*/

        vpa.addFragment(SearchFragment(), SearchFragment::class.java.simpleName)
        binding.dashboardBnv.addTab(binding.dashboardBnv.newTab().setIcon(R.drawable.ic_search))

        vpa.addFragment(MessagesFragment(), MessagesFragment::class.java.simpleName)
        binding.dashboardBnv.addTab(binding.dashboardBnv.newTab().setIcon(R.drawable.ic_messages))

        vpa.addFragment(ProfileFragment(), ProfileFragment::class.java.simpleName)
        binding.dashboardBnv.addTab(binding.dashboardBnv.newTab().setIcon(R.drawable.ic_profile))

        binding.dashboardVp.offscreenPageLimit = 2

    }

}