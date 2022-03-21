package com.findajob.jobamax.jobseeker.wishlist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\'B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\tH\u0016J\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\tH\u0016J\u001e\u0010$\u001a\u00020\u000e2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010&\u001a\u00020\u0014RC\u0010\u0007\u001a+\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u0006\u00a8\u0006("}, d2 = {"Lcom/findajob/jobamax/jobseeker/wishlist/SeekerWishListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/findajob/jobamax/jobseeker/wishlist/SeekerWishListAdapter$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/findajob/jobamax/model/WishlistedJob;", "(Ljava/util/ArrayList;)V", "clickListener", "Lkotlin/Function3;", "", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getClickListener", "()Lkotlin/jvm/functions/Function3;", "setClickListener", "(Lkotlin/jvm/functions/Function3;)V", "filter", "Lcom/findajob/jobamax/enums/SeekerWishlistJobFilter;", "getFilter", "()Lcom/findajob/jobamax/enums/SeekerWishlistJobFilter;", "setFilter", "(Lcom/findajob/jobamax/enums/SeekerWishlistJobFilter;)V", "getList", "()Ljava/util/ArrayList;", "setList", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "wishlistedJobs", "f", "ViewHolder", "app_debug"})
public final class SeekerWishListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.findajob.jobamax.jobseeker.wishlist.SeekerWishListAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.findajob.jobamax.model.WishlistedJob> list;
    @org.jetbrains.annotations.NotNull()
    private com.findajob.jobamax.enums.SeekerWishlistJobFilter filter = com.findajob.jobamax.enums.SeekerWishlistJobFilter.ALL;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function3<? super com.findajob.jobamax.model.WishlistedJob, ? super java.lang.Integer, ? super android.view.View, kotlin.Unit> clickListener;
    
    public SeekerWishListAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.model.WishlistedJob> list) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.findajob.jobamax.model.WishlistedJob> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.model.WishlistedJob> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.enums.SeekerWishlistJobFilter getFilter() {
        return null;
    }
    
    public final void setFilter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.enums.SeekerWishlistJobFilter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function3<com.findajob.jobamax.model.WishlistedJob, java.lang.Integer, android.view.View, kotlin.Unit> getClickListener() {
        return null;
    }
    
    public final void setClickListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super com.findajob.jobamax.model.WishlistedJob, ? super java.lang.Integer, ? super android.view.View, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.findajob.jobamax.jobseeker.wishlist.SeekerWishListAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.wishlist.SeekerWishListAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.model.WishlistedJob> wishlistedJobs, @org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.enums.SeekerWishlistJobFilter f) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/findajob/jobamax/jobseeker/wishlist/SeekerWishListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/findajob/jobamax/databinding/ItemWishlistJobBinding;", "(Lcom/findajob/jobamax/databinding/ItemWishlistJobBinding;)V", "getBinding", "()Lcom/findajob/jobamax/databinding/ItemWishlistJobBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.findajob.jobamax.databinding.ItemWishlistJobBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.findajob.jobamax.databinding.ItemWishlistJobBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.databinding.ItemWishlistJobBinding getBinding() {
            return null;
        }
    }
}