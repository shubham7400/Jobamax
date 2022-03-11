package com.findajob.jobamax.recruiter.profile.subscription.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0016J\u0016\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000fH\u0002J\u0018\u0010\'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010#\u001a\u00020!H\u0016J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020!H\u0016J\u0010\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\u0007H\u0002R,\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR7\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u00060"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/subscription/adapter/SubscriptionDetailsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/findajob/jobamax/recruiter/profile/subscription/adapter/SubscriptionDetailsAdapter$Holder;", "Lcom/findajob/jobamax/util/AutoUpdatableAdapter;", "()V", "clickListener", "Lkotlin/Function2;", "Lcom/findajob/jobamax/recruiter/profile/subscription/model/Subscription;", "", "", "getClickListener$app_debug", "()Lkotlin/jvm/functions/Function2;", "setClickListener$app_debug", "(Lkotlin/jvm/functions/Function2;)V", "<set-?>", "", "collection", "getCollection$app_debug", "()Ljava/util/List;", "setCollection$app_debug", "(Ljava/util/List;)V", "collection$delegate", "Lkotlin/properties/ReadWriteProperty;", "context", "Landroid/content/Context;", "isMonthly", "()Z", "setMonthly", "(Z)V", "buttonLabel", "", "plan", "getItemCount", "", "getItemViewType", "position", "offersValue", "", "offers", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "subscriptionPrice", "subscription", "Holder", "app_debug"})
public final class SubscriptionDetailsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.findajob.jobamax.recruiter.profile.subscription.adapter.SubscriptionDetailsAdapter.Holder> implements com.findajob.jobamax.util.AutoUpdatableAdapter {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty collection$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function2<? super com.findajob.jobamax.recruiter.profile.subscription.model.Subscription, ? super java.lang.Boolean, kotlin.Unit> clickListener;
    private boolean isMonthly = true;
    private android.content.Context context;
    
    public SubscriptionDetailsAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.findajob.jobamax.recruiter.profile.subscription.model.Subscription> getCollection$app_debug() {
        return null;
    }
    
    public final void setCollection$app_debug(@org.jetbrains.annotations.NotNull()
    java.util.List<com.findajob.jobamax.recruiter.profile.subscription.model.Subscription> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<com.findajob.jobamax.recruiter.profile.subscription.model.Subscription, java.lang.Boolean, kotlin.Unit> getClickListener$app_debug() {
        return null;
    }
    
    public final void setClickListener$app_debug(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.findajob.jobamax.recruiter.profile.subscription.model.Subscription, ? super java.lang.Boolean, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.findajob.jobamax.recruiter.profile.subscription.adapter.SubscriptionDetailsAdapter.Holder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    public final boolean isMonthly() {
        return false;
    }
    
    public final void setMonthly(boolean p0) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.recruiter.profile.subscription.adapter.SubscriptionDetailsAdapter.Holder holder, int position) {
    }
    
    private final java.lang.CharSequence subscriptionPrice(com.findajob.jobamax.recruiter.profile.subscription.model.Subscription subscription) {
        return null;
    }
    
    private final java.lang.String buttonLabel(java.lang.String plan) {
        return null;
    }
    
    private final java.lang.CharSequence offersValue(java.util.List<java.lang.String> offers) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    public <T extends java.lang.Object>void autoNotify(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.Adapter<?> $this$autoNotify, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> old, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> p2_54480, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super T, ? super T, java.lang.Boolean> compare) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/subscription/adapter/SubscriptionDetailsAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/findajob/jobamax/databinding/ItemSubscriptionDetailsBinding;", "(Lcom/findajob/jobamax/databinding/ItemSubscriptionDetailsBinding;)V", "getBinding", "()Lcom/findajob/jobamax/databinding/ItemSubscriptionDetailsBinding;", "Companion", "app_debug"})
    public static final class Holder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.findajob.jobamax.databinding.ItemSubscriptionDetailsBinding binding = null;
        @org.jetbrains.annotations.NotNull()
        public static final com.findajob.jobamax.recruiter.profile.subscription.adapter.SubscriptionDetailsAdapter.Holder.Companion Companion = null;
        
        public Holder(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.databinding.ItemSubscriptionDetailsBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.databinding.ItemSubscriptionDetailsBinding getBinding() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/subscription/adapter/SubscriptionDetailsAdapter$Holder$Companion;", "", "()V", "from", "Lcom/findajob/jobamax/recruiter/profile/subscription/adapter/SubscriptionDetailsAdapter$Holder;", "parent", "Landroid/view/ViewGroup;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.findajob.jobamax.recruiter.profile.subscription.adapter.SubscriptionDetailsAdapter.Holder from(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent) {
                return null;
            }
        }
    }
}