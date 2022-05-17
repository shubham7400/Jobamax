package com.jobamax.appjobamax.jobseeker.wishlist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J.\u0010&\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001aJ\u0012\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J$\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u00101\u001a\u00020\u001bH\u0016J\b\u00102\u001a\u00020\u001bH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u00063"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/wishlist/SeekerFilterJobFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "all", "", "getAll", "()I", "setAll", "(I)V", "archive", "getArchive", "setArchive", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentSeekerFilterJobBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentSeekerFilterJobBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentSeekerFilterJobBinding;)V", "favorite", "getFavorite", "setFavorite", "inProgress", "getInProgress", "setInProgress", "onGoClickListener", "Lkotlin/Function1;", "Lcom/jobamax/appjobamax/enums/SeekerWishlistJobFilter;", "", "getOnGoClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnGoClickListener", "(Lkotlin/jvm/functions/Function1;)V", "selectedFilter", "getSelectedFilter", "()Lcom/jobamax/appjobamax/enums/SeekerWishlistJobFilter;", "setSelectedFilter", "(Lcom/jobamax/appjobamax/enums/SeekerWishlistJobFilter;)V", "configureUi", "newInstance", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "setClickListeners", "app_debug"})
public final class SeekerFilterJobFragment extends androidx.fragment.app.DialogFragment {
    public com.jobamax.appjobamax.databinding.FragmentSeekerFilterJobBinding binding;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.enums.SeekerWishlistJobFilter, kotlin.Unit> onGoClickListener;
    @org.jetbrains.annotations.NotNull()
    private com.jobamax.appjobamax.enums.SeekerWishlistJobFilter selectedFilter = com.jobamax.appjobamax.enums.SeekerWishlistJobFilter.ALL;
    private int all = 0;
    private int favorite = 0;
    private int archive = 0;
    private int inProgress = 0;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerFilterJobFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentSeekerFilterJobBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentSeekerFilterJobBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.jobamax.appjobamax.enums.SeekerWishlistJobFilter, kotlin.Unit> getOnGoClickListener() {
        return null;
    }
    
    public final void setOnGoClickListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jobamax.appjobamax.enums.SeekerWishlistJobFilter, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.enums.SeekerWishlistJobFilter getSelectedFilter() {
        return null;
    }
    
    public final void setSelectedFilter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.enums.SeekerWishlistJobFilter p0) {
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
    
    public final int getInProgress() {
        return 0;
    }
    
    public final void setInProgress(int p0) {
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
    public final com.jobamax.appjobamax.jobseeker.wishlist.SeekerFilterJobFragment newInstance(int all, int favorite, int archive, int inProgress, @org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.enums.SeekerWishlistJobFilter selectedFilter) {
        return null;
    }
}