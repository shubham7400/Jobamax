package com.findajob.jobamax.recruiter.profile.subscription

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.findajob.jobamax.PaymentActivity
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.databinding.ActivityRecruiterSubscriptionBinding
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.recruiter.profile.subscription.adapter.SubscriptionDetailsAdapter
import com.findajob.jobamax.recruiter.profile.subscription.model.Subscription
import com.findajob.jobamax.util.ActivityResultHelper
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class RecruiterSubscriptionActivity : BaseActivityMain<ActivityRecruiterSubscriptionBinding>(),
    RecruiterSubscriptionInterface {

    val viewModel: SubscriptionViewModel by viewModels()
    private val subscriptionDetailsAdapter: SubscriptionDetailsAdapter by lazy {
        SubscriptionDetailsAdapter()
    }

    private val activityResultHelper = ActivityResultHelper(this)

    private val isFreeTrial: Boolean by lazy {
        intent.getBooleanExtra("isFreeTrial", false)
    }

    override val layoutRes: Int
        get() = R.layout.activity_recruiter_subscription

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreated(instance: Bundle?) {
        initBindingViews()
        initHandler()
        initRvSubscription()
        initDurationText()
        fetchSubscription()
        observeSubscriptionData()
    }

    private fun initDurationText() {
        setMonthly(true)
        with(binding) {
            tvMonthly.setOnClickListener {
                setMonthly(true)
            }
            tvAnnually.setOnClickListener {
                setMonthly(false)
            }
        }
    }

    private fun setMonthly(isMonthly: Boolean) {
        with(binding) {
            tvAnnually.isSelected = !isMonthly
            tvMonthly.isSelected = isMonthly

            subscriptionDetailsAdapter.isMonthly = isMonthly
            subscriptionDetailsAdapter.notifyItemRangeChanged(
                0,
                subscriptionDetailsAdapter.itemCount
            )
        }
    }

    private fun initBindingViews() {
    }


    private fun initHandler() {
        binding.handler = this
    }

    private fun initRvSubscription() {
        with(binding) {
            subscriptionDetailsAdapter.clickListener = { item, isMonthly ->
                goToPayment(item, isMonthly)
            }
            rvSubscriptionList.adapter = subscriptionDetailsAdapter
            TabLayoutMediator(tabSubscription, rvSubscriptionList) { _, pos ->
            }.attach()
            tabSubscription.addOnTabSelectedListener(tabListener)
        }
    }

    private fun goToPayment(item: Subscription, isMonthly: Boolean) {
        goToPaymentActivity(
            title = item.name,
            description = item.offer.joinToString(separator = "\n"),
            price = if (isMonthly) item.price else item.priceAnnually,
            selectedPlan = item.plan,
            isMonthly = isMonthly
        )
    }

    private val tabListener: TabLayout.OnTabSelectedListener =
        object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                refreshArrowState()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        }


    private fun refreshArrowState(
    ) {
        binding.apply {
            val pos = rvSubscriptionList.currentItem
            val totalItem = subscriptionDetailsAdapter.itemCount
            ivLeft.isEnabled = pos != 0
            ivRight.isEnabled = pos != totalItem - 1
        }
    }

    private fun fetchSubscription() {
        viewModel.fetchSubscription()
    }

    private fun observeSubscriptionData() {
        observe(viewModel.subscriptionData) { data ->
            data?.let {
                subscriptionDetailsAdapter.collection = it
            }
        }
    }

    override fun onLeftClicked() {
        with(binding.rvSubscriptionList) {
            currentItem = currentItem.minus(1)
        }
    }

    override fun onRightClicked() {
        with(binding.rvSubscriptionList) {
            currentItem = currentItem.plus(1)
        }
    }

    override fun onBackButtonClicked() {
        onBackPressed()
    }

    override fun onContinueClicked() {

    }

    private fun goToPaymentActivity(
        title: String,
        description: String,
        price: String,
        selectedPlan: String,
        isMonthly: Boolean,
    ) {
        val intent = Intent(this, PaymentActivity::class.java)
        intent.putExtra("title", title)
        intent.putExtra("description", description)
        intent.putExtra("price", price)
        intent.putExtra("plan", selectedPlan)
        intent.putExtra("isFreeTrial", isFreeTrial)
        intent.putExtra("isMonthly", isMonthly)

        activityResultHelper.launch(intent).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    onPaymentDone(result.data)
                }
            }
    }

    private fun onPaymentDone(data: Intent?) {
        setResult(Activity.RESULT_OK, data)
        finish()
    }

}

interface RecruiterSubscriptionInterface {
    fun onBackButtonClicked()
    fun onContinueClicked()
    fun onLeftClicked()
    fun onRightClicked()

}