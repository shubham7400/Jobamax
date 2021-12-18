package com.findajob.jobamax.recruiter.profile.subscription

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.recruiter.profile.subscription.model.Subscription
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SubscriptionViewModel @Inject constructor() : BaseViewModel() {


    private val _subscriptionData: MutableLiveData<List<Subscription>> by lazy {
        MutableLiveData()
    }

    val subscriptionData: LiveData<List<Subscription>> = _subscriptionData

    fun fetchSubscription() {
        _subscriptionData.value = Subscription.generateMockData()
    }
}