// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import com.google.android.material.chip.ChipGroup;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSeekerVolunteeringAndActivitiesBinding extends ViewDataBinding {
  @NonNull
  public final ChipGroup cgActivities;

  @NonNull
  public final ChipGroup cgVolunteering;

  @NonNull
  public final CircleImageView civUser;

  @NonNull
  public final AutoCompleteTextView etActivities;

  @NonNull
  public final AutoCompleteTextView etVolunteering;

  @NonNull
  public final ImageView ivActivities;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final ImageView ivVolunteering;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final TextView tvActivities;

  @NonNull
  public final TextView tvVolunteering;

  protected FragmentSeekerVolunteeringAndActivitiesBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ChipGroup cgActivities, ChipGroup cgVolunteering,
      CircleImageView civUser, AutoCompleteTextView etActivities,
      AutoCompleteTextView etVolunteering, ImageView ivActivities, ImageView ivBackButton,
      ImageView ivVolunteering, RelativeLayout relativeLayout, TextView tvActivities,
      TextView tvVolunteering) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cgActivities = cgActivities;
    this.cgVolunteering = cgVolunteering;
    this.civUser = civUser;
    this.etActivities = etActivities;
    this.etVolunteering = etVolunteering;
    this.ivActivities = ivActivities;
    this.ivBackButton = ivBackButton;
    this.ivVolunteering = ivVolunteering;
    this.relativeLayout = relativeLayout;
    this.tvActivities = tvActivities;
    this.tvVolunteering = tvVolunteering;
  }

  @NonNull
  public static FragmentSeekerVolunteeringAndActivitiesBinding inflate(
      @NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_volunteering_and_activities, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerVolunteeringAndActivitiesBinding inflate(
      @NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerVolunteeringAndActivitiesBinding>inflateInternal(inflater, R.layout.fragment_seeker_volunteering_and_activities, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSeekerVolunteeringAndActivitiesBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_volunteering_and_activities, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerVolunteeringAndActivitiesBinding inflate(
      @NonNull LayoutInflater inflater, @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerVolunteeringAndActivitiesBinding>inflateInternal(inflater, R.layout.fragment_seeker_volunteering_and_activities, null, false, component);
  }

  public static FragmentSeekerVolunteeringAndActivitiesBinding bind(@NonNull View view) {
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
  public static FragmentSeekerVolunteeringAndActivitiesBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentSeekerVolunteeringAndActivitiesBinding)bind(component, view, R.layout.fragment_seeker_volunteering_and_activities);
  }
}
