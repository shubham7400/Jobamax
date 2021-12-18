package com.findajob.jobamax.recruiter.profile.subscription;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u0019\u001a\u00020\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bH\u0002J0\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010\'\u001a\u00020%2\u0006\u0010(\u001a\u00020%2\u0006\u0010\"\u001a\u00020\bH\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001dH\u0002J\b\u0010,\u001a\u00020\u001dH\u0002J\b\u0010-\u001a\u00020\u001dH\u0002J\b\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u00020\u001dH\u0016J\u0012\u00100\u001a\u00020\u001d2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020\u001dH\u0016J\u0012\u00104\u001a\u00020\u001d2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\b\u00107\u001a\u00020\u001dH\u0016J\b\u00108\u001a\u00020\u001dH\u0002J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\f\u001a\u00020\r8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006:"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/subscription/RecruiterSubscriptionActivity;", "Lcom/findajob/jobamax/base/BaseActivityMain;", "Lcom/findajob/jobamax/databinding/ActivityRecruiterSubscriptionBinding;", "Lcom/findajob/jobamax/recruiter/profile/subscription/RecruiterSubscriptionInterface;", "()V", "activityResultHelper", "Lcom/findajob/jobamax/util/ActivityResultHelper;", "isFreeTrial", "", "()Z", "isFreeTrial$delegate", "Lkotlin/Lazy;", "layoutRes", "", "getLayoutRes", "()I", "subscriptionDetailsAdapter", "Lcom/findajob/jobamax/recruiter/profile/subscription/adapter/SubscriptionDetailsAdapter;", "getSubscriptionDetailsAdapter", "()Lcom/findajob/jobamax/recruiter/profile/subscription/adapter/SubscriptionDetailsAdapter;", "subscriptionDetailsAdapter$delegate", "tabListener", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "viewModel", "Lcom/findajob/jobamax/recruiter/profile/subscription/SubscriptionViewModel;", "getViewModel", "()Lcom/findajob/jobamax/recruiter/profile/subscription/SubscriptionViewModel;", "viewModel$delegate", "fetchSubscription", "", "Lcom/findajob/jobamax/base/BaseViewModel;", "goToPayment", "item", "Lcom/findajob/jobamax/recruiter/profile/subscription/model/Subscription;", "isMonthly", "goToPaymentActivity", "title", "", "description", "price", "selectedPlan", "initBindingViews", "initDurationText", "initHandler", "initRvSubscription", "observeSubscriptionData", "onBackButtonClicked", "onContinueClicked", "onCreated", "instance", "Landroid/os/Bundle;", "onLeftClicked", "onPaymentDone", "data", "Landroid/content/Intent;", "onRightClicked", "refreshArrowState", "setMonthly", "app_debug"})
public final class RecruiterSubscriptionActivity extends com.findajob.jobamax.base.BaseActivityMain<com.findajob.jobamax.databinding.ActivityRecruiterSubscriptionBinding> implements com.findajob.jobamax.recruiter.profile.subscription.RecruiterSubscriptionInterface {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy subscriptionDetailsAdapter$delegate = null;
    private final com.findajob.jobamax.util.ActivityResultHelper activityResultHelper = null;
    private final kotlin.Lazy isFreeTrial$delegate = null;
    private final com.google.android.material.tabs.TabLayout.OnTabSelectedListener tabListener = null;
    private java.util.HashMap _$_findViewCache;
    
    public RecruiterSubscriptionActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.recruiter.profile.subscription.SubscriptionViewModel getViewModel() {
        return null;
    }
    
    private final com.findajob.jobamax.recruiter.profile.subscription.adapter.SubscriptionDetailsAdapter getSubscriptionDetailsAdapter() {
        return null;
    }
    
    private final boolean isFreeTrial() {
        return false;
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected com.findajob.jobamax.base.BaseViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle instance) {
    }
    
    private final void initDurationText() {
    }
    
    private final void setMonthly(boolean isMonthly) {
    }
    
    private final void initBindingViews() {
    }
    
    private final void initHandler() {
    }
    
    private final void initRvSubscription() {
    }
    
    private final void goToPayment(com.findajob.jobamax.recruiter.profile.subscription.model.Subscription item, boolean isMonthly) {
    }
    
    private final void refreshArrowState() {
    }
    
    private final void fetchSubscription() {
    }
    
    private final void observeSubscriptionData() {
    }
    
    @java.lang.Override()
    public void onLeftClicked() {
    }
    
    @java.lang.Override()
    public void onRightClicked() {
    }
    
    @java.lang.Override()
    public void onBackButtonClicked() {
    }
    
    @java.lang.Override()
    public void onContinueClicked() {
    }
    
    private final void goToPaymentActivity(java.lang.String title, java.lang.String description, java.lang.String price, java.lang.String selectedPlan, boolean isMonthly) {
    }
    
    private final void onPaymentDone(android.content.Intent data) {
    }
}