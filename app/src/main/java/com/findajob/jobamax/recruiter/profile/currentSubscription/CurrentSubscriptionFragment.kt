package com.findajob.jobamax.recruiter.profile.currentSubscription

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentRecruiterCurrentSubscriptionBinding
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.recruiter.profile.subscription.model.Subscription
import com.findajob.jobamax.util.setColor
import com.findajob.jobamax.util.setTypeFace
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrentSubscriptionFragment : BaseFragmentMain<FragmentRecruiterCurrentSubscriptionBinding>(),
    CurrentSubscriptionInterface {

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    lateinit var navController: NavController

    override fun onCreated(savedInstance: Bundle?) {
        initViews()
        initUi()
    }

    override fun getViewModel(): ViewModel = viewModel

    override val layoutRes: Int
        get() = R.layout.fragment_recruiter_current_subscription

    private fun initViews() {
        binding.lifecycleOwner = this
        navController = findNavController()
    }


    private fun initUi() {
        initCurrentSubscription()
        initHandler()
    }

    private fun initHandler() {
        binding.handler = this
    }

    private fun initCurrentSubscription() {
        val subscription =
            Gson().fromJson(arguments?.getString(Subscription.toString()), Subscription::class.java)
        subscription?.let {
            binding.apply {
                item = it
                subscriptionPrice = subscriptionPrice(it)
                offers = offersValue(it.offer)
            }
        }
    }

    private fun subscriptionPrice(subscription: Subscription): CharSequence {
        val price = subscription.price
        val month = getString(R.string.month)
        val spannableString = SpannableString("$price/$month")
        spannableString.setTypeFace(Typeface.BOLD, "$price/")
        return spannableString
    }


    private fun offersValue(offers: List<String>): CharSequence {
        val stringBuilder = SpannableStringBuilder()
        offers.forEach {
            val spannableString = SpannableString("• $it\n")
            spannableString.setColor(requireContext(), "•", R.color.blue_2)
            stringBuilder.append(spannableString)
        }
        return stringBuilder
    }

    override fun onBackButtonClicked() {
        requireActivity().onBackPressed()
    }

    override fun onUpgradeClick() {
    }

    override fun onScheduleADemoClicked() {
    }

}

