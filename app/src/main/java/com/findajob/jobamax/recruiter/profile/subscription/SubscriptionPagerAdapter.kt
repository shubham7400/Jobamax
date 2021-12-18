package com.findajob.jobamax.recruiter.profile.subscription

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.findajob.jobamax.util.RECRUITER_ENTERPRISE_PLAN
import com.findajob.jobamax.util.RECRUITER_PREMIUM_PLAN
import com.findajob.jobamax.util.RECRUITER_STANDARD_PLAN
import com.findajob.jobamax.util.RECRUITER_STARTER_PLAN

class SubscriptionPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int = subscriptions.size

    override fun getItem(position: Int): Fragment {
        val fragment = SubscriptionFragment()
        fragment.arguments = Bundle().apply {
            putString(SubscriptionFragment.ARG_SUBSCRIPTION_TITLE, subscriptions[position])
        }
        return fragment
    }

    companion object {
        val subscriptions = listOf(
            RECRUITER_STANDARD_PLAN,
            RECRUITER_PREMIUM_PLAN,
            RECRUITER_STARTER_PLAN,
            RECRUITER_ENTERPRISE_PLAN,
        )

    }
}