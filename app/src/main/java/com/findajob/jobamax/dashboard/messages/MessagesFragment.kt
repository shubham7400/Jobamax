package com.findajob.jobamax.dashboard.messages

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.databinding.FragmentMessagesBinding
import com.findajob.jobamax.preference.getRole
import com.findajob.jobamax.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MessagesFragment : BaseFragmentMain<FragmentMessagesBinding>() {

    lateinit var navController: NavController

    private val viewModel: MessagesViewModel by activityViewModels()

    override fun getViewModel(): BaseViewModel = viewModel


    override val layoutRes: Int
        get() = R.layout.fragment_messages

    override fun onCreated(savedInstance: Bundle?) {
        setUpNavigation()
        initObserver()
    }

    private fun setUpNavigation() {

        val tabFragmentAdapter = MessageTabFragmentAdapter(childFragmentManager).apply {
            if(requireActivity().getRole() == ROLE_RECRUITER)
                addFragment(RecruiterChatsFragment.newInstance(), RECRUITMENT_PAGE_LABEL)
            else
                addFragment(JobSeekerChatsFragment.newInstance(), JOB_HUNT_PAGE_LABEL)
            addFragment(NetworkingChatsFragment.newInstance(), NETWORKING_PAGE_LABEL)
            addFragment(ArchivedChatsFragment.newInstance(), ARCHIVED_PAGE_LABEL)
        }

        binding.apply {
            viewPager.offscreenPageLimit = tabFragmentAdapter.count
            viewPager.adapter = tabFragmentAdapter
            tab.setupWithViewPager(viewPager)
        }
//        navController = Navigation.findNavController(requireActivity(), R.id.fNavHost)
//        NavigationUI.setupWithNavController(binding.bnbBottomNavBar, navController)
    }

    private fun initObserver() {
        viewModel.apply {
        }

        binding.lifecycleOwner = this
    }


}
