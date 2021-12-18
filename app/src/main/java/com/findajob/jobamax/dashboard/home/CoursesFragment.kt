package com.findajob.jobamax.dashboard.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.findajob.jobamax.R
import com.findajob.jobamax.dashboard.DashboardViewModel
import com.findajob.jobamax.dashboard.home.training.KeynotesFragment
import com.findajob.jobamax.dashboard.home.training.masterclass.MasterClassFragment
import com.findajob.jobamax.dashboard.home.training.online.courses.OnlineCoursesListFragment
import com.findajob.jobamax.databinding.FragmentCoursesBinding
import com.findajob.jobamax.util.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class CoursesFragment : Fragment() {

    lateinit var binding: FragmentCoursesBinding
    lateinit var vpa: ViewPagerAdapter
    lateinit var vm: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_courses, container, false)
        setupViewPager()
        initObservers()
        initView()
        return binding.root
    }

    private fun initObservers() {
        binding.apply {
            viewPagerAdapter = vpa
            coursesVp.postDelayed({
                arguments?.getInt("courseId")?.let {
                    coursesVp.currentItem(it)
                }
            }, 100)
        }
    }

    private fun initView() {
        binding.apply {
            coursesCtl.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(binding.coursesVp))
            coursesVp.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.coursesCtl))
        }
    }

    private fun setupViewPager() {

        vpa = ViewPagerAdapter(childFragmentManager)
        vpa.addFragment(MasterClassFragment(), MasterClassFragment::class.java.simpleName)
        vpa.addFragment(KeynotesFragment(), KeynotesFragment::class.java.simpleName)

        vpa.addFragment(
            OnlineCoursesListFragment(),
            OnlineCoursesListFragment::class.java.simpleName
        )

        binding.apply {
            coursesCtl.addTab(coursesCtl.newTab().setText("Master Class"))
            coursesCtl.addTab(coursesCtl.newTab().setText("Keynotes"))
            coursesCtl.addTab(coursesCtl.newTab().setText("Online Courses"))
            coursesVp.offscreenPageLimit = 3
        }
    }
}