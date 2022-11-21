package com.jobamax.appjobamax.jobseeker.build_profile;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.ChipGroup;
import com.google.gson.Gson;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentFilterJobSearchTagBinding;
import com.jobamax.appjobamax.databinding.ItemJobCriteriaCategoryBinding;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity;
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.CriteriaCategory;
import com.jobamax.appjobamax.model.JobSeeker;
import com.jobamax.appjobamax.model.ManualCriteria;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B=\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0004j\b\u0012\u0004\u0012\u00020\n`\u0006\u00a2\u0006\u0002\u0010\u000bJ&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00132\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\b\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\"H\u0016J\u0018\u0010&\u001a\u00020\u00022\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\"H\u0016J\u0018\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u001e\u0010/\u001a\u00020 2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0004j\b\u0012\u0004\u0012\u00020\n`\u0006J\u0018\u00101\u001a\u00020 2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0004j\b\u0012\u0004\u0012\u00020\n`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u00063"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/build_profile/FilterJobSearchTagAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/jobamax/appjobamax/jobseeker/build_profile/FilterJobSearchTagAdapter$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/jobamax/appjobamax/model/CriteriaCategory;", "Lkotlin/collections/ArrayList;", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "jobSearchKeywords", "", "(Ljava/util/ArrayList;Landroidx/fragment/app/FragmentActivity;Ljava/util/ArrayList;)V", "getJobSearchKeywords", "()Ljava/util/ArrayList;", "setJobSearchKeywords", "(Ljava/util/ArrayList;)V", "getList", "onTagClick", "Lkotlin/Function1;", "", "getOnTagClick", "()Lkotlin/jvm/functions/Function1;", "setOnTagClick", "(Lkotlin/jvm/functions/Function1;)V", "getRequireActivity", "()Landroidx/fragment/app/FragmentActivity;", "createChip", "Landroid/view/View;", "tag", "isSelected", "onTagStateChange", "Lkotlin/Function0;", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "showViewAnimation", "cgContractType", "Lcom/google/android/material/chip/ChipGroup;", "iv", "Landroid/widget/ImageView;", "submitAddedTags", "tags", "viewHideAnimation", "ViewHolder", "app_debug"})
public final class FilterJobSearchTagAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.jobamax.appjobamax.jobseeker.build_profile.FilterJobSearchTagAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.jobamax.appjobamax.model.CriteriaCategory> list = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.fragment.app.FragmentActivity requireActivity = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> jobSearchKeywords;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.Boolean> onTagClick;
    
    public FilterJobSearchTagAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.model.CriteriaCategory> list, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity requireActivity, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> jobSearchKeywords) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.model.CriteriaCategory> getList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.fragment.app.FragmentActivity getRequireActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getJobSearchKeywords() {
        return null;
    }
    
    public final void setJobSearchKeywords(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, java.lang.Boolean> getOnTagClick() {
        return null;
    }
    
    public final void setOnTagClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.jobamax.appjobamax.jobseeker.build_profile.FilterJobSearchTagAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.jobseeker.build_profile.FilterJobSearchTagAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    private final android.view.View createChip(java.lang.String tag, boolean isSelected, kotlin.jvm.functions.Function0<kotlin.Unit> onTagStateChange) {
        return null;
    }
    
    private final void showViewAnimation(com.google.android.material.chip.ChipGroup cgContractType, android.widget.ImageView iv) {
    }
    
    private final void viewHideAnimation(com.google.android.material.chip.ChipGroup cgContractType, android.widget.ImageView iv) {
    }
    
    public final void submitAddedTags(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> tags) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/build_profile/FilterJobSearchTagAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/jobamax/appjobamax/databinding/ItemJobCriteriaCategoryBinding;", "(Lcom/jobamax/appjobamax/databinding/ItemJobCriteriaCategoryBinding;)V", "getBinding", "()Lcom/jobamax/appjobamax/databinding/ItemJobCriteriaCategoryBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.jobamax.appjobamax.databinding.ItemJobCriteriaCategoryBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.jobamax.appjobamax.databinding.ItemJobCriteriaCategoryBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jobamax.appjobamax.databinding.ItemJobCriteriaCategoryBinding getBinding() {
            return null;
        }
    }
}