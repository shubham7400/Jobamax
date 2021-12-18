package com.findajob.jobamax.recruiter.profile.account.company.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001.B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0016J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001fH\u0016J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u001fH\u0016J\u000e\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0007H\u0002J\u0018\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001fH\u0002R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR7\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006/"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/account/company/adapter/CompanySizeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/findajob/jobamax/recruiter/profile/account/company/adapter/CompanySizeAdapter$Holder;", "Lcom/findajob/jobamax/util/AutoUpdatableAdapter;", "()V", "clickListener", "Lkotlin/Function1;", "Lcom/findajob/jobamax/recruiter/profile/account/company/adapter/CompanySize;", "", "getClickListener$app_debug", "()Lkotlin/jvm/functions/Function1;", "setClickListener$app_debug", "(Lkotlin/jvm/functions/Function1;)V", "<set-?>", "", "collection", "getCollection$app_debug", "()Ljava/util/List;", "setCollection$app_debug", "(Ljava/util/List;)V", "collection$delegate", "Lkotlin/properties/ReadWriteProperty;", "context", "Landroid/content/Context;", "prevItem", "selectedItem", "getSelectedItem", "()Lcom/findajob/jobamax/recruiter/profile/account/company/adapter/CompanySize;", "setSelectedItem", "(Lcom/findajob/jobamax/recruiter/profile/account/company/adapter/CompanySize;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectedSize", "label", "", "updatePrevious", "companySize", "updateSelected", "Holder", "app_debug"})
public final class CompanySizeAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySizeAdapter.Holder> implements com.findajob.jobamax.util.AutoUpdatableAdapter {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty collection$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySize, kotlin.Unit> clickListener;
    private com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySize prevItem;
    @org.jetbrains.annotations.Nullable()
    private com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySize selectedItem;
    private android.content.Context context;
    
    public CompanySizeAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySize> getCollection$app_debug() {
        return null;
    }
    
    public final void setCollection$app_debug(@org.jetbrains.annotations.NotNull()
    java.util.List<com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySize> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySize, kotlin.Unit> getClickListener$app_debug() {
        return null;
    }
    
    public final void setClickListener$app_debug(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySize, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySizeAdapter.Holder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySize getSelectedItem() {
        return null;
    }
    
    public final void setSelectedItem(@org.jetbrains.annotations.Nullable()
    com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySize p0) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySizeAdapter.Holder holder, int position) {
    }
    
    public final void selectedSize(@org.jetbrains.annotations.NotNull()
    java.lang.String label) {
    }
    
    private final void updateSelected(com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySize companySize, int position) {
    }
    
    private final void updatePrevious(com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySize companySize) {
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
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/account/company/adapter/CompanySizeAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/findajob/jobamax/databinding/ItemCompanySizeBinding;", "(Lcom/findajob/jobamax/databinding/ItemCompanySizeBinding;)V", "getBinding", "()Lcom/findajob/jobamax/databinding/ItemCompanySizeBinding;", "Companion", "app_debug"})
    public static final class Holder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.findajob.jobamax.databinding.ItemCompanySizeBinding binding = null;
        @org.jetbrains.annotations.NotNull()
        public static final com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySizeAdapter.Holder.Companion Companion = null;
        
        public Holder(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.databinding.ItemCompanySizeBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.databinding.ItemCompanySizeBinding getBinding() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/recruiter/profile/account/company/adapter/CompanySizeAdapter$Holder$Companion;", "", "()V", "from", "Lcom/findajob/jobamax/recruiter/profile/account/company/adapter/CompanySizeAdapter$Holder;", "parent", "Landroid/view/ViewGroup;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySizeAdapter.Holder from(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent) {
                return null;
            }
        }
    }
}