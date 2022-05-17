package com.jobamax.appjobamax.jobseeker.wishlist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u001d\u001a\u00020\nH\u0016J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\nH\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\nH\u0016J&\u0010%\u001a\u00020\u000f2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\'\u001a\u00020\u0015RC\u0010\b\u001a+\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u0007\u00a8\u0006)"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/wishlist/SeekerWishListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/jobamax/appjobamax/jobseeker/wishlist/SeekerWishListAdapter$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/WishlistedJob;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "clickListener", "Lkotlin/Function3;", "", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getClickListener", "()Lkotlin/jvm/functions/Function3;", "setClickListener", "(Lkotlin/jvm/functions/Function3;)V", "filter", "Lcom/jobamax/appjobamax/enums/SeekerWishlistJobFilter;", "getFilter", "()Lcom/jobamax/appjobamax/enums/SeekerWishlistJobFilter;", "setFilter", "(Lcom/jobamax/appjobamax/enums/SeekerWishlistJobFilter;)V", "getList", "()Ljava/util/ArrayList;", "setList", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "wishlistedJobs", "selectedFilter", "ViewHolder", "app_release"})
public final class SeekerWishListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.jobamax.appjobamax.jobseeker.wishlist.SeekerWishListAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.model.WishlistedJob> list;
    @org.jetbrains.annotations.NotNull()
    private com.jobamax.appjobamax.enums.SeekerWishlistJobFilter filter = com.jobamax.appjobamax.enums.SeekerWishlistJobFilter.ALL;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function3<? super com.jobamax.appjobamax.model.WishlistedJob, ? super java.lang.Integer, ? super android.view.View, kotlin.Unit> clickListener;
    
    public SeekerWishListAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.WishlistedJob> list) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.WishlistedJob> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.WishlistedJob> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.enums.SeekerWishlistJobFilter getFilter() {
        return null;
    }
    
    public final void setFilter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.enums.SeekerWishlistJobFilter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function3<com.jobamax.appjobamax.model.WishlistedJob, java.lang.Integer, android.view.View, kotlin.Unit> getClickListener() {
        return null;
    }
    
    public final void setClickListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super com.jobamax.appjobamax.model.WishlistedJob, ? super java.lang.Integer, ? super android.view.View, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.jobamax.appjobamax.jobseeker.wishlist.SeekerWishListAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.wishlist.SeekerWishListAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.WishlistedJob> wishlistedJobs, @org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.enums.SeekerWishlistJobFilter selectedFilter) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/wishlist/SeekerWishListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/jobamax/appjobamax/databinding/ItemWishlistJobBinding;", "(Lcom/jobamax/appjobamax/databinding/ItemWishlistJobBinding;)V", "getBinding", "()Lcom/jobamax/appjobamax/databinding/ItemWishlistJobBinding;", "app_release"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.jobamax.appjobamax.databinding.ItemWishlistJobBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.jobamax.appjobamax.databinding.ItemWishlistJobBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jobamax.appjobamax.databinding.ItemWishlistJobBinding getBinding() {
            return null;
        }
    }
}