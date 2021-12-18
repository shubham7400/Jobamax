package com.findajob.jobamax;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0005H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\"\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0012\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/findajob/jobamax/PaymentActivity;", "Lcom/findajob/jobamax/base/BaseActivityMain;", "Lcom/findajob/jobamax/databinding/ActivityPaymentBinding;", "()V", "hasSavedCard", "", "isFreeTrial", "isMonthly", "layoutRes", "", "getLayoutRes", "()I", "paymentIntentClientSecret", "", "plan", "price", "stripe", "Lcom/stripe/android/Stripe;", "displayAlert", "", "title", "intent", "Lcom/stripe/android/model/PaymentIntent;", "success", "getViewModel", "Landroidx/lifecycle/ViewModel;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreated", "instance", "Landroid/os/Bundle;", "startCheckout", "app_debug"})
public final class PaymentActivity extends com.findajob.jobamax.base.BaseActivityMain<com.findajob.jobamax.databinding.ActivityPaymentBinding> {
    private java.lang.String paymentIntentClientSecret;
    private com.stripe.android.Stripe stripe;
    private java.lang.String plan;
    private boolean isFreeTrial = false;
    private boolean isMonthly = true;
    private boolean hasSavedCard = false;
    private java.lang.String price = "";
    private java.util.HashMap _$_findViewCache;
    
    public PaymentActivity() {
        super();
    }
    
    @java.lang.Override()
    protected int getLayoutRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected androidx.lifecycle.ViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle instance) {
    }
    
    private final void displayAlert(java.lang.String title, com.stripe.android.model.PaymentIntent intent, boolean success) {
    }
    
    private final void startCheckout() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
}