package com.findajob.jobamax.recruiter.profile.subscription;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\'\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/subscription/SubscriptionViewModel;", "Lcom/findajob/jobamax/base/BaseViewModel;", "()V", "_subscriptionData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/findajob/jobamax/recruiter/profile/subscription/model/Subscription;", "get_subscriptionData", "()Landroidx/lifecycle/MutableLiveData;", "_subscriptionData$delegate", "Lkotlin/Lazy;", "subscriptionData", "Landroidx/lifecycle/LiveData;", "getSubscriptionData", "()Landroidx/lifecycle/LiveData;", "fetchSubscription", "", "app_debug"})
public final class SubscriptionViewModel extends com.findajob.jobamax.base.BaseViewModel {
    private final kotlin.Lazy _subscriptionData$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.findajob.jobamax.recruiter.profile.subscription.model.Subscription>> subscriptionData = null;
    
    @javax.inject.Inject()
    public SubscriptionViewModel() {
        super();
    }
    
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.findajob.jobamax.recruiter.profile.subscription.model.Subscription>> get_subscriptionData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.findajob.jobamax.recruiter.profile.subscription.model.Subscription>> getSubscriptionData() {
        return null;
    }
    
    public final void fetchSubscription() {
    }
}