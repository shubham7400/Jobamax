package com.findajob.jobamax.jobseeker.profile.account;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\"\u0010\u0019\u001a\u00020\u00122\u0018\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0004\u0012\u00020\u00120\u0010H\u0002J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J$\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010+\u001a\u00020\u0012H\u0016J\b\u0010\u0007\u001a\u00020\u0012H\u0002J\b\u0010,\u001a\u00020\u0012H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006."}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/account/SeekerSearchUniversityDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "adapter", "Lcom/findajob/jobamax/jobseeker/profile/account/SeekerSearchUniversityAdapter;", "getAdapter", "()Lcom/findajob/jobamax/jobseeker/profile/account/SeekerSearchUniversityAdapter;", "setAdapter", "(Lcom/findajob/jobamax/jobseeker/profile/account/SeekerSearchUniversityAdapter;)V", "binding", "Lcom/findajob/jobamax/databinding/FragmentSeekerSearchUniversityDialogBinding;", "getBinding", "()Lcom/findajob/jobamax/databinding/FragmentSeekerSearchUniversityDialogBinding;", "setBinding", "(Lcom/findajob/jobamax/databinding/FragmentSeekerSearchUniversityDialogBinding;)V", "clickedItemListener", "Lkotlin/Function1;", "Lcom/findajob/jobamax/data/pojo/University;", "", "getClickedItemListener", "()Lkotlin/jvm/functions/Function1;", "setClickedItemListener", "(Lkotlin/jvm/functions/Function1;)V", "universities", "Ljava/util/ArrayList;", "getUniversities", "()Ljava/util/ArrayList;", "setUniversities", "(Ljava/util/ArrayList;)V", "configureUi", "result", "", "Lcom/parse/ParseObject;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "setClickListeners", "Companion", "app_debug"})
public final class SeekerSearchUniversityDialogFragment extends androidx.fragment.app.DialogFragment {
    public com.findajob.jobamax.databinding.FragmentSeekerSearchUniversityDialogBinding binding;
    public com.findajob.jobamax.jobseeker.profile.account.SeekerSearchUniversityAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.findajob.jobamax.data.pojo.University> universities;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super com.findajob.jobamax.data.pojo.University, kotlin.Unit> clickedItemListener;
    @org.jetbrains.annotations.NotNull()
    public static final com.findajob.jobamax.jobseeker.profile.account.SeekerSearchUniversityDialogFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public SeekerSearchUniversityDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.databinding.FragmentSeekerSearchUniversityDialogBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.databinding.FragmentSeekerSearchUniversityDialogBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.findajob.jobamax.jobseeker.profile.account.SeekerSearchUniversityAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.findajob.jobamax.jobseeker.profile.account.SeekerSearchUniversityAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.findajob.jobamax.data.pojo.University> getUniversities() {
        return null;
    }
    
    public final void setUniversities(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.findajob.jobamax.data.pojo.University> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.findajob.jobamax.data.pojo.University, kotlin.Unit> getClickedItemListener() {
        return null;
    }
    
    public final void setClickedItemListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.findajob.jobamax.data.pojo.University, kotlin.Unit> p0) {
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
    
    private final void setAdapter() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void getUniversities(kotlin.jvm.functions.Function1<? super java.util.List<? extends com.parse.ParseObject>, kotlin.Unit> result) {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/findajob/jobamax/jobseeker/profile/account/SeekerSearchUniversityDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/findajob/jobamax/jobseeker/profile/account/SeekerSearchUniversityDialogFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.findajob.jobamax.jobseeker.profile.account.SeekerSearchUniversityDialogFragment newInstance() {
            return null;
        }
    }
}