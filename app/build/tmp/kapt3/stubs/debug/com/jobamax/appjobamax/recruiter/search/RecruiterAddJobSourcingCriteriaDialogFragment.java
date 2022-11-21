package com.jobamax.appjobamax.recruiter.search;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.material.chip.ChipGroup;
import com.google.gson.Gson;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.FragmentRecruiterAddJobSourcingCriteriaBinding;
import com.jobamax.appjobamax.dialog.BasicDialog;
import com.jobamax.appjobamax.enums.ParseCloudFunction;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.model.Recruiter;
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity;
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel;
import com.jobamax.appjobamax.recruiter.dialog.DialogWorkExperience;
import com.jobamax.appjobamax.recruiter.dialog.DialogWorkType2;
import com.jobamax.appjobamax.recruiter.model.SourcingCriteria;
import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.pushwoosh.internal.platform.AndroidPlatformModule;
import org.json.JSONArray;
import java.util.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 l2\u00020\u0001:\u0001lB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010I\u001a\u00020JH\u0002J\b\u0010K\u001a\u00020JH\u0002J\b\u0010L\u001a\u00020JH\u0002J\b\u0010M\u001a\u00020JH\u0002J\u001c\u0010M\u001a\u00020J2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020P0OH\u0002J\b\u0010Q\u001a\u00020JH\u0002J\b\u0010R\u001a\u00020JH\u0002J\b\u0010S\u001a\u00020JH\u0002J\u0018\u0010T\u001a\u00020J2\u0006\u0010U\u001a\u00020$2\u0006\u0010V\u001a\u00020WH\u0002J\b\u0010X\u001a\u00020JH\u0002J\b\u0010Y\u001a\u00020JH\u0002J\u0012\u0010Z\u001a\u00020J2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J$\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010b2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\b\u0010c\u001a\u00020JH\u0016J\b\u0010d\u001a\u00020JH\u0002J\b\u0010e\u001a\u00020JH\u0002J\b\u0010f\u001a\u00020JH\u0002J\b\u0010g\u001a\u00020JH\u0002J\b\u0010h\u001a\u00020JH\u0002J\u001c\u0010i\u001a\u00020J2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020P0OH\u0002J\u0010\u0010j\u001a\u00020J2\u0006\u0010k\u001a\u00020*H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010/\u001a\b\u0012\u0004\u0012\u00020$00X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R \u00105\u001a\b\u0012\u0004\u0012\u00020*00X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u000e\u00108\u001a\u00020*X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020*X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010&\"\u0004\b<\u0010(R\u001a\u0010=\u001a\u00020>X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001b\u0010C\u001a\u00020D8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bE\u0010F\u00a8\u0006m"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/search/RecruiterAddJobSourcingCriteriaDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "autocompleteFragment", "Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;", "getAutocompleteFragment", "()Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;", "setAutocompleteFragment", "(Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;)V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentRecruiterAddJobSourcingCriteriaBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentRecruiterAddJobSourcingCriteriaBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentRecruiterAddJobSourcingCriteriaBinding;)V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "lat", "", "getLat", "()Ljava/lang/Double;", "setLat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "lng", "getLng", "setLng", "recruiter", "Lcom/jobamax/appjobamax/model/Recruiter;", "getRecruiter", "()Lcom/jobamax/appjobamax/model/Recruiter;", "setRecruiter", "(Lcom/jobamax/appjobamax/model/Recruiter;)V", "selectedCity", "", "getSelectedCity", "()Ljava/lang/String;", "setSelectedCity", "(Ljava/lang/String;)V", "selectedSourcingCriteria", "Lcom/jobamax/appjobamax/recruiter/model/SourcingCriteria;", "getSelectedSourcingCriteria", "()Lcom/jobamax/appjobamax/recruiter/model/SourcingCriteria;", "setSelectedSourcingCriteria", "(Lcom/jobamax/appjobamax/recruiter/model/SourcingCriteria;)V", "selectedWorkTypes", "Ljava/util/ArrayList;", "getSelectedWorkTypes", "()Ljava/util/ArrayList;", "setSelectedWorkTypes", "(Ljava/util/ArrayList;)V", "sourcingCriteriaList", "getSourcingCriteriaList", "setSourcingCriteriaList", "sourcingCriteriaListAddMoreObject", "sourcingCriteriaListTitleObject", "sourcingId", "getSourcingId", "setSourcingId", "spinnerAdapter", "Lcom/jobamax/appjobamax/recruiter/search/SourcingCriteriaSpinnerAdapter;", "getSpinnerAdapter", "()Lcom/jobamax/appjobamax/recruiter/search/SourcingCriteriaSpinnerAdapter;", "setSpinnerAdapter", "(Lcom/jobamax/appjobamax/recruiter/search/SourcingCriteriaSpinnerAdapter;)V", "viewModel", "Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/recruiter/RecruiterHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addCompanyTags", "", "addJobTitleTags", "addSkillTags", "addSourcingCriteria", "request", "Ljava/util/HashMap;", "", "addUniversityTags", "clearAllFields", "configureUi", "createChip", "tag", "tagGroup", "Lcom/google/android/material/chip/ChipGroup;", "getSourcingCriteria", "initializeRecruiter", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "setClickListeners", "setData", "setObserver", "setPlaceAutocompleteFragment", "updateJobCriteriaList", "updateSourcingCriteria", "updateUi", "sourcingCriteria", "Companion", "app_debug"})
public final class RecruiterAddJobSourcingCriteriaDialogFragment extends androidx.fragment.app.DialogFragment {
    public com.jobamax.appjobamax.databinding.FragmentRecruiterAddJobSourcingCriteriaBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.model.Recruiter recruiter;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String sourcingId = "";
    public com.google.android.libraries.places.widget.AutocompleteSupportFragment autocompleteFragment;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.recruiter.model.SourcingCriteria selectedSourcingCriteria;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedCity = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> selectedWorkTypes;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Double lat;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Double lng;
    public com.jobamax.appjobamax.recruiter.search.SourcingCriteriaSpinnerAdapter spinnerAdapter;
    private final com.jobamax.appjobamax.recruiter.model.SourcingCriteria sourcingCriteriaListTitleObject = null;
    private final com.jobamax.appjobamax.recruiter.model.SourcingCriteria sourcingCriteriaListAddMoreObject = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.SourcingCriteria> sourcingCriteriaList;
    @org.jetbrains.annotations.NotNull()
    public static final com.jobamax.appjobamax.recruiter.search.RecruiterAddJobSourcingCriteriaDialogFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public RecruiterAddJobSourcingCriteriaDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentRecruiterAddJobSourcingCriteriaBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentRecruiterAddJobSourcingCriteriaBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.Recruiter getRecruiter() {
        return null;
    }
    
    public final void setRecruiter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.Recruiter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson getGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSourcingId() {
        return null;
    }
    
    public final void setSourcingId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.libraries.places.widget.AutocompleteSupportFragment getAutocompleteFragment() {
        return null;
    }
    
    public final void setAutocompleteFragment(@org.jetbrains.annotations.NotNull()
    com.google.android.libraries.places.widget.AutocompleteSupportFragment p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.recruiter.model.SourcingCriteria getSelectedSourcingCriteria() {
        return null;
    }
    
    public final void setSelectedSourcingCriteria(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.recruiter.model.SourcingCriteria p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSelectedCity() {
        return null;
    }
    
    public final void setSelectedCity(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getSelectedWorkTypes() {
        return null;
    }
    
    public final void setSelectedWorkTypes(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
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
    public final com.jobamax.appjobamax.recruiter.search.SourcingCriteriaSpinnerAdapter getSpinnerAdapter() {
        return null;
    }
    
    public final void setSpinnerAdapter(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.recruiter.search.SourcingCriteriaSpinnerAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.SourcingCriteria> getSourcingCriteriaList() {
        return null;
    }
    
    public final void setSourcingCriteriaList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.jobamax.appjobamax.recruiter.model.SourcingCriteria> p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    private final void configureUi() {
    }
    
    private final void clearAllFields() {
    }
    
    private final void setPlaceAutocompleteFragment() {
    }
    
    private final void updateUi(com.jobamax.appjobamax.recruiter.model.SourcingCriteria sourcingCriteria) {
    }
    
    private final void getSourcingCriteria() {
    }
    
    private final void initializeRecruiter() {
    }
    
    private final void setData() {
    }
    
    private final void setObserver() {
    }
    
    private final void updateJobCriteriaList() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void addSourcingCriteria() {
    }
    
    private final void updateSourcingCriteria(java.util.HashMap<java.lang.String, java.lang.Object> request) {
    }
    
    private final void addSourcingCriteria(java.util.HashMap<java.lang.String, java.lang.Object> request) {
    }
    
    private final void addCompanyTags() {
    }
    
    private final void addSkillTags() {
    }
    
    private final void addUniversityTags() {
    }
    
    private final void addJobTitleTags() {
    }
    
    private final void createChip(java.lang.String tag, com.google.android.material.chip.ChipGroup tagGroup) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/jobamax/appjobamax/recruiter/search/RecruiterAddJobSourcingCriteriaDialogFragment$Companion;", "", "()V", "getInstance", "Lcom/jobamax/appjobamax/recruiter/search/RecruiterAddJobSourcingCriteriaDialogFragment;", "sourcingId", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.jobamax.appjobamax.recruiter.search.RecruiterAddJobSourcingCriteriaDialogFragment getInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String sourcingId) {
            return null;
        }
    }
}