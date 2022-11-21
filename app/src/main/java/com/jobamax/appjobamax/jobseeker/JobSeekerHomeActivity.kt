package com.jobamax.appjobamax.jobseeker

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseActivity
import com.jobamax.appjobamax.databinding.ActivityJobSeekerHomeBinding
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.jobseeker.chat.SeekerChatListFragment
import com.jobamax.appjobamax.jobseeker.profile.SeekerProfileFragment
import com.jobamax.appjobamax.jobseeker.search.SeekerSearchJobFragment
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.jobseeker.wishlist.SeekerWishlistFragment
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.preference.getDeepLink
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.preference.setDeepLink
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.parse.ParseObject
import com.parse.ParseQuery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobSeekerHomeActivity : BaseActivity() {
    val binding: ActivityJobSeekerHomeBinding by lazy { ActivityJobSeekerHomeBinding.inflate(layoutInflater) }

    val viewModel: SeekerHomeViewModel by viewModels()

    lateinit var jobSeeker: JobSeeker

    var profileTab: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        configureUi()
    }



    private fun configureUi() {
        setClickListeners()
        setJobSeeker()
        setUpViewPager()
        setData()
        setViewModelObserver()
    }



    private fun setViewModelObserver() {
         viewModel.isJobSeekerUpdated.observe(this){
             if (it){
                 jobSeeker = viewModel.jobSeeker
                 setData()
             }
         }
    }

    private fun setJobSeeker() {
        jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null) {
            getJobSeeker {
                if (it) {
                    jobSeeker = viewModel.jobSeeker
                    setData()
                }
            }
        }
    }

    fun setData() {
        jobSeeker = viewModel.jobSeeker
        profileTab?.let { loadImageFromUrl(it, jobSeeker.profilePicUrl, R.drawable.ic_profile_navi_blue) }
    }

    fun getJobSeeker(callback : (Boolean) -> Unit) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, getUserId())
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
                    viewModel.jobSeekerObject = parseObject
                    viewModel.isJobSeekerUpdated.value = true
                    callback(true)
                }
            }
        }
    }

    private fun setUpViewPager() {
        binding.viewPager.adapter = SeekerBottomNavigationPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->

        }.attach()

        binding.viewPager.isUserInputEnabled = false
        val view = layoutInflater.inflate(R.layout.tab_bottom_seeker_navigation, null, false)
        val homeTab = view.findViewById<ImageView>(R.id.iv_home)
        val favoriteTab = view.findViewById<ImageView>(R.id.iv_favorite)
        val chatTab = view.findViewById<ImageView>(R.id.iv_chat)
        profileTab = view.findViewById<ImageView>(R.id.iv_profile)
        binding.tabLayout.getTabAt(0)?.customView = homeTab
        binding.tabLayout.getTabAt(1)?.customView = favoriteTab
        binding.tabLayout.getTabAt(2)?.customView = chatTab
        binding.tabLayout.getTabAt(3)?.customView = profileTab

        setTabSelection(homeTab, favoriteTab, chatTab, profileTab!!)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                setTabSelection(homeTab, favoriteTab, chatTab, profileTab!!)
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        when(getDeepLink()){
            "jobamax://wishlist" -> { binding.tabLayout.getTabAt(1)?.select() }
            "jobamax://jobSearch" -> { binding.tabLayout.getTabAt(0)?.select() }
            "jobamax://jobseekerProfile" -> { binding.tabLayout.getTabAt(3)?.select() }
            "jobamax://chat" -> { binding.tabLayout.getTabAt(2)?.select() }
            else -> {  binding.tabLayout.getTabAt(0)?.select() }
        }
        setDeepLink("")
    }

    private fun setTabSelection(homeTab: ImageView, favoriteTab: ImageView, chatTab: ImageView, profileTab: ImageView) {
        when (binding.tabLayout.selectedTabPosition) {
            0 -> {
                homeTab.setImageDrawable(resources.getDrawable(R.drawable.ic_search_select, null))
                favoriteTab.setImageDrawable(resources.getDrawable(R.drawable.ic_like_unselect, null))
                chatTab.setImageDrawable(resources.getDrawable(R.drawable.ic_chat_unselect, null))
            }
            1 -> {
                homeTab.setImageDrawable(resources.getDrawable(R.drawable.ic_search_unselect, null))
                favoriteTab.setImageDrawable(resources.getDrawable(R.drawable.ic_like_select, null))
                chatTab.setImageDrawable(resources.getDrawable(R.drawable.ic_chat_unselect, null))
            }
            2 -> {
                homeTab.setImageDrawable(resources.getDrawable(R.drawable.ic_search_unselect, null))
                favoriteTab.setImageDrawable(resources.getDrawable(R.drawable.ic_like_unselect, null))
                chatTab.setImageDrawable(resources.getDrawable(R.drawable.ic_chat_select, null))
            }
            3 -> {
                homeTab.setImageDrawable(resources.getDrawable(R.drawable.ic_search_unselect, null))
                favoriteTab.setImageDrawable(resources.getDrawable(R.drawable.ic_like_unselect, null))
                chatTab.setImageDrawable(resources.getDrawable(R.drawable.ic_chat_unselect, null))
            }
        }
    }

    private fun setClickListeners() {

    }
}

class SeekerBottomNavigationPagerAdapter(childFragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(childFragmentManager, lifecycle) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> {
                return SeekerSearchJobFragment()
            }
            1 -> {
                return SeekerWishlistFragment()
            }
            2 -> {
                return SeekerChatListFragment()
            }
            3 -> {
                return SeekerProfileFragment()
            }
            else -> {
                return SeekerSearchJobFragment()
            }
        }
    }

}