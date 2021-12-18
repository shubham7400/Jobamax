package com.findajob.jobamax.dashboard.messages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001&B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bH\u0016J\u0014\u0010$\u001a\u00020\b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00070\u00070\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\'"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/NewPeopleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/findajob/jobamax/dashboard/messages/NewPeopleAdapter$NewPeopleViewHolder;", "Landroid/widget/Filterable;", "()V", "clickListener", "Lkotlin/Function1;", "Lcom/findajob/jobamax/data/pojo/NewPeople;", "", "getClickListener$app_debug", "()Lkotlin/jvm/functions/Function1;", "setClickListener$app_debug", "(Lkotlin/jvm/functions/Function1;)V", "diffCallBack", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "filterCollection", "", "getFilterCollection$app_debug", "()Ljava/util/List;", "setFilterCollection$app_debug", "(Ljava/util/List;)V", "getFilter", "Landroid/widget/Filter;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "people", "NewPeopleViewHolder", "app_debug"})
public final class NewPeopleAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.findajob.jobamax.dashboard.messages.NewPeopleAdapter.NewPeopleViewHolder> implements android.widget.Filterable {
    private final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.findajob.jobamax.data.pojo.NewPeople> diffCallBack = null;
    private final androidx.recyclerview.widget.AsyncListDiffer<com.findajob.jobamax.data.pojo.NewPeople> differ = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.findajob.jobamax.data.pojo.NewPeople> filterCollection;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.findajob.jobamax.data.pojo.NewPeople, kotlin.Unit> clickListener;
    
    @javax.inject.Inject()
    public NewPeopleAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.findajob.jobamax.data.pojo.NewPeople> getFilterCollection$app_debug() {
        return null;
    }
    
    public final void setFilterCollection$app_debug(@org.jetbrains.annotations.NotNull()
    java.util.List<com.findajob.jobamax.data.pojo.NewPeople> p0) {
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.findajob.jobamax.data.pojo.NewPeople> people) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.findajob.jobamax.data.pojo.NewPeople, kotlin.Unit> getClickListener$app_debug() {
        return null;
    }
    
    public final void setClickListener$app_debug(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.findajob.jobamax.data.pojo.NewPeople, kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.findajob.jobamax.dashboard.messages.NewPeopleAdapter.NewPeopleViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.dashboard.messages.NewPeopleAdapter.NewPeopleViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.widget.Filter getFilter() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/NewPeopleAdapter$NewPeopleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/findajob/jobamax/databinding/ListItemNewPeopleBinding;", "(Lcom/findajob/jobamax/databinding/ListItemNewPeopleBinding;)V", "getBinding", "()Lcom/findajob/jobamax/databinding/ListItemNewPeopleBinding;", "Companion", "app_debug"})
    public static final class NewPeopleViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.findajob.jobamax.databinding.ListItemNewPeopleBinding binding = null;
        @org.jetbrains.annotations.NotNull()
        public static final com.findajob.jobamax.dashboard.messages.NewPeopleAdapter.NewPeopleViewHolder.Companion Companion = null;
        
        public NewPeopleViewHolder(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.databinding.ListItemNewPeopleBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.databinding.ListItemNewPeopleBinding getBinding() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/findajob/jobamax/dashboard/messages/NewPeopleAdapter$NewPeopleViewHolder$Companion;", "", "()V", "from", "Lcom/findajob/jobamax/dashboard/messages/NewPeopleAdapter$NewPeopleViewHolder;", "parent", "Landroid/view/ViewGroup;", "layout", "", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.findajob.jobamax.dashboard.messages.NewPeopleAdapter.NewPeopleViewHolder from(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent, int layout) {
                return null;
            }
        }
    }
}