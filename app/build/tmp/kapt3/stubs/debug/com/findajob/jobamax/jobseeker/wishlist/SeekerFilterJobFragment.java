package com.findajob.jobamax.jobseeker.wishlist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\u001e\u0010#\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u00020\u001dH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001d0\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u00060"}, d2 = {"Lcom/findajob/jobamax/jobseeker/wishlist/SeekerFilterJobFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "all", "", "getAll", "()I", "setAll", "(I)V", "archive", "getArchive", "setArchive", "binding", "Lcom/findajob/jobamax/databinding/FragmentSeekerFilterJobBinding;", "getBinding", "()Lcom/findajob/jobamax/databinding/FragmentSeekerFilterJobBinding;", "setBinding", "(Lcom/findajob/jobamax/databinding/FragmentSeekerFilterJobBinding;)V", "favorite", "getFavorite", "setFavorite", "filteredJob", "Lcom/findajob/jobamax/enums/SeekerWishlistJobFilter;", "getFilteredJob", "()Lcom/findajob/jobamax/enums/SeekerWishlistJobFilter;", "setFilteredJob", "(Lcom/findajob/jobamax/enums/SeekerWishlistJobFilter;)V", "onGoClickListener", "Lkotlin/Function1;", "", "getOnGoClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnGoClickListener", "(Lkotlin/jvm/functions/Function1;)V", "configureUi", "newInstance", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "setClickListeners", "app_debug"})
public final class SeekerFilterJobFragment extends androidx.fragment.app.DialogFragment {
    public com.findajob.jobamax.databinding.FragmentSeekerFilterJobBinding binding;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.findajob.jobamax.enums.SeekerWishlistJobFilter, kotlin.Unit> onGoClickListener;
    @org.jetbrains.annotations.NotNull()
    private com.findajob.jobamax.enums.SeekerWishlistJobFilter filteredJob = com.findajob.jobamax.enums.SeekerWishlistJobFilter.ALL;
    private int all = 0;
    private int favorite = 0;
    private int archive = 0;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerFilterJobFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.databinding.FragmentSeekerFilterJobBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.databinding.FragmentSeekerFilterJobBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.findajob.jobamax.enums.SeekerWishlistJobFilter, kotlin.Unit> getOnGoClickListener() {
        return null;
    }
    
    public final void setOnGoClickListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.findajob.jobamax.enums.SeekerWishlistJobFilter, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.enums.SeekerWishlistJobFilter getFilteredJob() {
        return null;
    }
    
    public final void setFilteredJob(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.enums.SeekerWishlistJobFilter p0) {
    }
    
    public final int getAll() {
        return 0;
    }
    
    public final void setAll(int p0) {
    }
    
    public final int getFavorite() {
        return 0;
    }
    
    public final void setFavorite(int p0) {
    }
    
    public final int getArchive() {
        return 0;
    }
    
    public final void setArchive(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void configureUi() {
    }
    
    private final void setClickListeners() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.wishlist.SeekerFilterJobFragment newInstance(int all, int favorite, int archive) {
        return null;
    }
}