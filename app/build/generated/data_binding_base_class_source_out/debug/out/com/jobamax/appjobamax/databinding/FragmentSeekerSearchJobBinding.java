// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jobamax.appjobamax.R;
import com.yuyakaido.android.cardstackview.CardStackView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSeekerSearchJobBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout btnCriteria;

  @NonNull
  public final AppCompatButton btnJobMatch;

  @NonNull
  public final ConstraintLayout constraintLayout18;

  @NonNull
  public final CardStackView csvJob;

  @NonNull
  public final FloatingActionButton fabRefuse;

  @NonNull
  public final FloatingActionButton fabRewind;

  @NonNull
  public final FloatingActionButton fabShare;

  @NonNull
  public final FloatingActionButton fabWishlist;

  @NonNull
  public final ImageView imageView14;

  @NonNull
  public final ItemSeekerJobCardBinding lJob;

  @NonNull
  public final LinearLayout linearLayout21;

  @NonNull
  public final LinearLayout llFloatingBtn;

  @NonNull
  public final LinearLayout llParent;

  @NonNull
  public final SwitchCompat scManualPersonalize;

  @NonNull
  public final TextView tvManualSwitch;

  @NonNull
  public final TextView tvPersonalizeSwitch;

  protected FragmentSeekerSearchJobBinding(Object _bindingComponent, View _root,
      int _localFieldCount, LinearLayout btnCriteria, AppCompatButton btnJobMatch,
      ConstraintLayout constraintLayout18, CardStackView csvJob, FloatingActionButton fabRefuse,
      FloatingActionButton fabRewind, FloatingActionButton fabShare,
      FloatingActionButton fabWishlist, ImageView imageView14, ItemSeekerJobCardBinding lJob,
      LinearLayout linearLayout21, LinearLayout llFloatingBtn, LinearLayout llParent,
      SwitchCompat scManualPersonalize, TextView tvManualSwitch, TextView tvPersonalizeSwitch) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnCriteria = btnCriteria;
    this.btnJobMatch = btnJobMatch;
    this.constraintLayout18 = constraintLayout18;
    this.csvJob = csvJob;
    this.fabRefuse = fabRefuse;
    this.fabRewind = fabRewind;
    this.fabShare = fabShare;
    this.fabWishlist = fabWishlist;
    this.imageView14 = imageView14;
    this.lJob = lJob;
    this.linearLayout21 = linearLayout21;
    this.llFloatingBtn = llFloatingBtn;
    this.llParent = llParent;
    this.scManualPersonalize = scManualPersonalize;
    this.tvManualSwitch = tvManualSwitch;
    this.tvPersonalizeSwitch = tvPersonalizeSwitch;
  }

  @NonNull
  public static FragmentSeekerSearchJobBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_search_job, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerSearchJobBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerSearchJobBinding>inflateInternal(inflater, R.layout.fragment_seeker_search_job, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSeekerSearchJobBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_search_job, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerSearchJobBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerSearchJobBinding>inflateInternal(inflater, R.layout.fragment_seeker_search_job, null, false, component);
  }

  public static FragmentSeekerSearchJobBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentSeekerSearchJobBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentSeekerSearchJobBinding)bind(component, view, R.layout.fragment_seeker_search_job);
  }
}