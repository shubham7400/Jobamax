package com.jobamax.appjobamax.jobseeker.build_profile;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.material.chip.ChipGroup;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentManualFilterBinding;
import com.jobamax.appjobamax.dialog.BasicDialog;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.JobSeeker;
import com.jobamax.appjobamax.model.ManualCriteria;
import com.pushwoosh.internal.platform.AndroidPlatformModule;
import java.util.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00105\u001a\u000206H\u0002J \u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u000206H\u0002J\u0010\u0010?\u001a\u0002062\u0006\u00109\u001a\u00020\u0011H\u0002J\b\u0010@\u001a\u000206H\u0002J\b\u0010A\u001a\u000206H\u0002J\b\u0010B\u001a\u000206H\u0002J$\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010J\u001a\u000206H\u0002J\b\u0010K\u001a\u000206H\u0002J\b\u0010L\u001a\u000206H\u0002J\u0018\u0010M\u001a\u0002062\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0002J\u0018\u0010R\u001a\u0002062\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010%\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\b&\u0010!\"\u0004\b\'\u0010#R\u001a\u0010(\u001a\u00020)X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001b\u0010.\u001a\u00020/8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006S"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/build_profile/ManualFilterFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "()V", "autocompleteFragment", "Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;", "getAutocompleteFragment", "()Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;", "setAutocompleteFragment", "(Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;)V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentManualFilterBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentManualFilterBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentManualFilterBinding;)V", "companies", "Ljava/util/ArrayList;", "", "companySize", "experience", "getExperience", "()Ljava/util/ArrayList;", "setExperience", "(Ljava/util/ArrayList;)V", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/jobamax/appjobamax/model/JobSeeker;", "setJobSeeker", "(Lcom/jobamax/appjobamax/model/JobSeeker;)V", "lat", "", "getLat", "()Ljava/lang/Double;", "setLat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "lng", "getLng", "setLng", "manualCriteria", "Lcom/jobamax/appjobamax/model/ManualCriteria;", "getManualCriteria", "()Lcom/jobamax/appjobamax/model/ManualCriteria;", "setManualCriteria", "(Lcom/jobamax/appjobamax/model/ManualCriteria;)V", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "workType", "configureUi", "", "createChip", "Landroid/view/View;", "tag", "isSelected", "", "cheapType", "", "createCompanySizeCheap", "createCompanyTags", "createExperienceCheap", "createWorkTypeCheap", "initializeJobSeeker", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setClickListeners", "setData", "setPlaceAutocompleteFragment", "showViewAnimation", "cgContractType", "Lcom/google/android/material/chip/ChipGroup;", "iv", "Landroid/widget/ImageView;", "viewHideAnimation", "app_debug"})
public final class ManualFilterFragment extends com.jobamax.appjobamax.base.BaseFragment {
    public com.jobamax.appjobamax.databinding.FragmentManualFilterBinding binding;
    public com.jobamax.appjobamax.model.JobSeeker jobSeeker;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.model.ManualCriteria manualCriteria;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> experience;
    private java.util.ArrayList<java.lang.String> workType;
    private java.util.ArrayList<java.lang.String> companySize;
    private java.util.ArrayList<java.lang.String> companies;
    public com.google.android.libraries.places.widget.AutocompleteSupportFragment autocompleteFragment;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Double lat;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Double lng;
    private java.util.HashMap _$_findViewCache;
    
    public ManualFilterFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentManualFilterBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentManualFilterBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    public final void setJobSeeker(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.JobSeeker p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.ManualCriteria getManualCriteria() {
        return null;
    }
    
    public final void setManualCriteria(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.ManualCriteria p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getExperience() {
        return null;
    }
    
    public final void setExperience(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.libraries.places.widget.AutocompleteSupportFragment getAutocompleteFragment() {
        return null;
    }
    
    public final void setAutocompleteFragment(@org.jetbrains.annotations.NotNull()
    com.google.android.libraries.places.widget.AutocompleteSupportFragment p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getLat() {
        return null;
    }
    
    public final void setLat(@org.jetbrains.annotations.Nullable()
    java.lang.Double p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getLng() {
        return null;
    }
    
    public final void setLng(@org.jetbrains.annotations.Nullable()
    java.lang.Double p0) {
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
    
    private final void setData() {
    }
    
    private final void createCompanySizeCheap() {
    }
    
    private final void createExperienceCheap() {
    }
    
    private final void createWorkTypeCheap() {
    }
    
    private final void initializeJobSeeker() {
    }
    
    private final android.view.View createChip(java.lang.String tag, boolean isSelected, int cheapType) {
        return null;
    }
    
    private final void setPlaceAutocompleteFragment() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void createCompanyTags(java.lang.String tag) {
    }
    
    private final void showViewAnimation(com.google.android.material.chip.ChipGroup cgContractType, android.widget.ImageView iv) {
    }
    
    private final void viewHideAnimation(com.google.android.material.chip.ChipGroup cgContractType, android.widget.ImageView iv) {
    }
}