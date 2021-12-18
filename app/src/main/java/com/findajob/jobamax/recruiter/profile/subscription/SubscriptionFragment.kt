package com.findajob.jobamax.recruiter.profile.subscription

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.databinding.TabItemSubscriptionBinding

class SubscriptionFragment : BaseFragmentMain<TabItemSubscriptionBinding>() {

    private val subscriptionViewModel: SubscriptionViewModel by viewModels()

    override val layoutRes: Int
        get() = R.layout.tab_item_subscription

    override fun onCreated(savedInstance: Bundle?) {
    }

    override fun getViewModel(): BaseViewModel = subscriptionViewModel

    companion object {
        const val ARG_SUBSCRIPTION_TITLE = "argument subscription title"
    }
}