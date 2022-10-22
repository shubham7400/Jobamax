package com.jobamax.appjobamax.recruiter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.ActivityRecruiterHomeBinding
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.model.Recruiter
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.recruiter.home.RecruiterHomeFragment
import com.jobamax.appjobamax.recruiter.message.RecruiterChatListFragment
import com.jobamax.appjobamax.recruiter.profile.RecruiterProfileFragment
import com.jobamax.appjobamax.recruiter.search.RecruiterSearchFragment
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.parse.ParseObject
import com.parse.ParseQuery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecruiterHomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecruiterHomeBinding

    val viewModel: RecruiterHomeViewModel by viewModels()
    lateinit var recruiter: Recruiter

    var profileTab: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecruiterHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureUi()
    }

    private fun configureUi() {
        setClickListeners()
        setRecruiter()
        setUpViewPager()
        setData()
        setViewModelObserver()
    }



    private fun setClickListeners() {

    }

    private fun setViewModelObserver() {
        viewModel.isRecruiterUpdated.observe(this){
            if (it){
                recruiter = viewModel.recruiter
                setData()
            }
        }
    }


    private fun setUpViewPager() {
        binding.viewPager.adapter = RecruiterBottomNavigationPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->

        }.attach()

        binding.viewPager.isUserInputEnabled = false
        val view = layoutInflater.inflate(R.layout.tab_bottom_recruiter_navigation, null, false)
        val homeTab = view.findViewById<ImageView>(R.id.iv_home)
        val searchTab = view.findViewById<ImageView>(R.id.iv_search)
        val chatTab = view.findViewById<ImageView>(R.id.iv_chat)
        profileTab = view.findViewById(R.id.iv_profile)
        binding.tabLayout.getTabAt(0)?.customView = homeTab
        binding.tabLayout.getTabAt(1)?.customView = searchTab
        binding.tabLayout.getTabAt(2)?.customView = chatTab
        binding.tabLayout.getTabAt(3)?.customView = profileTab

        setTabSelection(homeTab, searchTab, chatTab, profileTab!!)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                setTabSelection(homeTab, searchTab, chatTab, profileTab!!)
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun setTabSelection(homeTab: ImageView, searchTab: ImageView, chatTab: ImageView, profileTab: ImageView) {
        when (binding.tabLayout.selectedTabPosition) {
            0 -> {
                homeTab.setColorFilter(resources.getColor(R.color.colorPrimary, null), android.graphics.PorterDuff.Mode.SRC_IN)
                searchTab.setColorFilter(resources.getColor(R.color.navi_blue, null), android.graphics.PorterDuff.Mode.SRC_IN)
                chatTab.setColorFilter(resources.getColor(R.color.navi_blue, null), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            1 -> {
                homeTab.setColorFilter(resources.getColor(R.color.navi_blue, null), android.graphics.PorterDuff.Mode.SRC_IN)
                searchTab.setColorFilter(resources.getColor(R.color.colorPrimary, null), android.graphics.PorterDuff.Mode.SRC_IN)
                chatTab.setColorFilter(resources.getColor(R.color.navi_blue, null), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            2 -> {
                homeTab.setColorFilter(resources.getColor(R.color.navi_blue, null), android.graphics.PorterDuff.Mode.SRC_IN)
                searchTab.setColorFilter(resources.getColor(R.color.navi_blue, null), android.graphics.PorterDuff.Mode.SRC_IN)
                chatTab.setColorFilter(resources.getColor(R.color.colorPrimary, null), android.graphics.PorterDuff.Mode.SRC_IN)
            }
            3 -> {
                homeTab.setColorFilter(resources.getColor(R.color.navi_blue, null), android.graphics.PorterDuff.Mode.SRC_IN)
                searchTab.setColorFilter(resources.getColor(R.color.navi_blue, null), android.graphics.PorterDuff.Mode.SRC_IN)
                chatTab.setColorFilter(resources.getColor(R.color.navi_blue, null), android.graphics.PorterDuff.Mode.SRC_IN)
            }
        }
    }

    private fun setRecruiter() {
        recruiter = viewModel.recruiter
        if (viewModel.recruiterObject == null) {
            getRecruiter {
                if (it) {
                    recruiter = viewModel.recruiter
                    setData()
                }
            }
        }
    }


    fun setData() {
        recruiter = viewModel.recruiter
        profileTab?.let { loadImageFromUrl(it, recruiter.profilePicUrl, R.drawable.ic_profile_navi_blue) }
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

class RecruiterBottomNavigationPagerAdapter(childFragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(childFragmentManager, lifecycle) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> {
                return RecruiterHomeFragment()
            }
            1 -> {
                return RecruiterSearchFragment()
            }
            2 -> {
                return RecruiterChatListFragment()
            }
            3 -> {
                return RecruiterProfileFragment()
            }
            else -> {
                return RecruiterHomeFragment()
            }
        }
    }

}