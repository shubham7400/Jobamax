package com.findajob.jobamax.dashboard.messages

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MessageTabFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragmentList = arrayListOf<Fragment>()
    private val fragmentTitleList = arrayListOf<String>()

    override fun getCount() = fragmentList.size

    override fun getItem(position: Int) = fragmentList[position]

    override fun getPageTitle(position: Int) = fragmentTitleList[position]

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }
}