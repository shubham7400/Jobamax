package com.jobamax.appjobamax.login;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.gson.Gson;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.base.BaseFragment;
import com.jobamax.appjobamax.databinding.FragmentTakeWorkExperienceBinding;
import com.jobamax.appjobamax.enums.LoginType;
import com.jobamax.appjobamax.jobseeker.build_profile.BuildProfileActivity;
import com.jobamax.appjobamax.model.*;
import com.jobamax.appjobamax.preference.*;
import com.jobamax.appjobamax.util.*;
import com.parse.ParseGeoPoint;
import com.pushwoosh.Pushwoosh;
import com.pushwoosh.internal.platform.AndroidPlatformModule;
import java.util.*;
import kotlin.collections.ArrayList;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&H\u0002J$\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\"H\u0002J\b\u00100\u001a\u00020\"H\u0002J\b\u00101\u001a\u00020\"H\u0002J\b\u00102\u001a\u00020\"H\u0002J\u0016\u00103\u001a\u00020\"2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\"05H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u00066"}, d2 = {"Lcom/jobamax/appjobamax/login/TakeWorkExperienceFragment;", "Lcom/jobamax/appjobamax/base/BaseFragment;", "()V", "autocompleteFragment", "Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;", "getAutocompleteFragment", "()Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;", "setAutocompleteFragment", "(Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;)V", "binding", "Lcom/jobamax/appjobamax/databinding/FragmentTakeWorkExperienceBinding;", "getBinding", "()Lcom/jobamax/appjobamax/databinding/FragmentTakeWorkExperienceBinding;", "setBinding", "(Lcom/jobamax/appjobamax/databinding/FragmentTakeWorkExperienceBinding;)V", "lat", "", "getLat", "()Ljava/lang/Double;", "setLat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "lng", "getLng", "setLng", "locationListener", "Landroid/location/LocationListener;", "user", "Lcom/jobamax/appjobamax/model/UserTempInfo;", "getUser", "()Lcom/jobamax/appjobamax/model/UserTempInfo;", "setUser", "(Lcom/jobamax/appjobamax/model/UserTempInfo;)V", "configureUi", "", "getInterest", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setClickListener", "setContinueBtnState", "setPlaceAutocompleteFragment", "startListeningUserLocation", "storeUserInParse", "callback", "Lkotlin/Function0;", "app_debug"})
public final class TakeWorkExperienceFragment extends com.jobamax.appjobamax.base.BaseFragment {
    public com.jobamax.appjobamax.databinding.FragmentTakeWorkExperienceBinding binding;
    @org.jetbrains.annotations.Nullable()
    private com.jobamax.appjobamax.model.UserTempInfo user;
    public com.google.android.libraries.places.widget.AutocompleteSupportFragment autocompleteFragment;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Double lat;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Double lng;
    private final android.location.LocationListener locationListener = null;
    private java.util.HashMap _$_findViewCache;
    
    public TakeWorkExperienceFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jobamax.appjobamax.databinding.FragmentTakeWorkExperienceBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.jobamax.appjobamax.databinding.FragmentTakeWorkExperienceBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.jobamax.appjobamax.model.UserTempInfo getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.Nullable()
    com.jobamax.appjobamax.model.UserTempInfo p0) {
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
    
    private final void setClickListener() {
    }
    
    private final void setContinueBtnState() {
    }
    
    private final void setPlaceAutocompleteFragment() {
    }
    
    private final void storeUserInParse(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    private final java.util.ArrayList<java.lang.String> getInterest() {
        return null;
    }
    
    private final void startListeningUserLocation() {
    }
}