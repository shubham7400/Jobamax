package com.jobamax.appjobamax.jobseeker.search;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.databinding.FragmentPersonalizeFilterDialogBinding;
import com.jobamax.appjobamax.enums.ParseTableFields;
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity;
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel;
import com.jobamax.appjobamax.model.JobSeeker;
import com.parse.ParseGeoPoint;
import com.pushwoosh.internal.platform.AndroidPlatformModule;
import java.util.*;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010+\u001a\u00020,H\u0002J$\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020,H\u0016J\b\u00106\u001a\u00020,H\u0002J\b\u00107\u001a\u00020,H\u0002J\b\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020,H\u0002J\b\u0010;\u001a\u00020,H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010!\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001b\u0010%\u001a\u00020&8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b\'\u0010(\u00a8\u0006<"}, d2 = {"Lcom/jobamax/appjobamax/jobseeker/search/PersonalizeFilterDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "autocompleteFragment", "Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;", "getAutocompleteFragment", "()Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;", "setAutocompleteFragment", "(Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;)V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentPersonalizeFilterDialogBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentPersonalizeFilterDialogBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentPersonalizeFilterDialogBinding;)V", "city", "", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "jobSeeker", "Lcom/jobamax/appjobamax/model/JobSeeker;", "getJobSeeker", "()Lcom/jobamax/appjobamax/model/JobSeeker;", "setJobSeeker", "(Lcom/jobamax/appjobamax/model/JobSeeker;)V", "lat", "", "getLat", "()Ljava/lang/Double;", "setLat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "lng", "getLng", "setLng", "viewModel", "Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "getViewModel", "()Lcom/jobamax/appjobamax/jobseeker/view_model/SeekerHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "configureUi", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "saveDataToParse", "setClickListeners", "setContinueBtnState", "", "setData", "setPlaceAutocompleteFragment", "app_debug"})
public final class PersonalizeFilterDialogFragment extends androidx.fragment.app.DialogFragment {
    public com.jobamax.appjobamax.databinding.FragmentPersonalizeFilterDialogBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public com.jobamax.appjobamax.model.JobSeeker jobSeeker;
    public com.google.android.libraries.places.widget.AutocompleteSupportFragment autocompleteFragment;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Double lat;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Double lng;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String city = "";
    private java.util.HashMap _$_findViewCache;
    
    public PersonalizeFilterDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentPersonalizeFilterDialogBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentPersonalizeFilterDialogBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.model.JobSeeker getJobSeeker() {
        return null;
    }
    
    public final void setJobSeeker(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.model.JobSeeker p0) {
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
    public final java.lang.String getCity() {
        return null;
    }
    
    public final void setCity(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    private final void setPlaceAutocompleteFragment() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    private final void setClickListeners() {
    }
    
    private final void saveDataToParse() {
    }
    
    private final boolean setContinueBtnState() {
        return false;
    }
}