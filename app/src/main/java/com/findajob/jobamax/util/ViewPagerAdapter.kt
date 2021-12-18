package com.findajob.jobamax.util

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class ViewPagerAdapter(manager: FragmentManager, private val fragmentBundle: Bundle? = null) :
    FragmentStatePagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        val fragment = fragmentList[position]
        fragment.arguments = this.fragmentBundle
        return fragment
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragment.arguments = fragmentBundle
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }

    fun clearFragments() {
        fragmentList.clear()
        fragmentTitleList.clear()
        notifyDataSetChanged()
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList[position]
    }

    fun getRegisteredFragment(position: Int): Fragment {
        return fragmentList[position]
    }

}