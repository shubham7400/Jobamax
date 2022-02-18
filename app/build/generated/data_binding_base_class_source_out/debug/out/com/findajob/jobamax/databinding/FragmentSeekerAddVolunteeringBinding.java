// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.findajob.jobamax.R;
import com.findajob.jobamax.model.JobSeeker;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSeekerAddVolunteeringBinding extends ViewDataBinding {
  @NonNull
  public final FragmentContainerView autocompleteFragment;

  @NonNull
  public final Button btnAddVolunteering;

  @NonNull
  public final CheckBox cbCurrentStudent;

  @NonNull
  public final ConstraintLayout clEndDate;

  @NonNull
  public final EditText etActivity;

  @NonNull
  public final EditText etDescription;

  @NonNull
  public final EditText etOrganisation;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final RelativeLayout relativeLayout4;

  @NonNull
  public final TextView textView139;

  @NonNull
  public final TextView textView144;

  @NonNull
  public final TextView textView15;

  @NonNull
  public final TextView textView16;

  @NonNull
  public final TextView textView19;

  @NonNull
  public final TextView textViewdd19;

  @NonNull
  public final TextView tvEndDate;

  @NonNull
  public final TextView tvSelectLocation;

  @NonNull
  public final TextView tvStartDate;

  @Bindable
  protected JobSeeker mJobSeeker;

  protected FragmentSeekerAddVolunteeringBinding(Object _bindingComponent, View _root,
      int _localFieldCount, FragmentContainerView autocompleteFragment, Button btnAddVolunteering,
      CheckBox cbCurrentStudent, ConstraintLayout clEndDate, EditText etActivity,
      EditText etDescription, EditText etOrganisation, ImageView ivBackButton,
      LinearLayout linearLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout4,
      TextView textView139, TextView textView144, TextView textView15, TextView textView16,
      TextView textView19, TextView textViewdd19, TextView tvEndDate, TextView tvSelectLocation,
      TextView tvStartDate) {
    super(_bindingComponent, _root, _localFieldCount);
    this.autocompleteFragment = autocompleteFragment;
    this.btnAddVolunteering = btnAddVolunteering;
    this.cbCurrentStudent = cbCurrentStudent;
    this.clEndDate = clEndDate;
    this.etActivity = etActivity;
    this.etDescription = etDescription;
    this.etOrganisation = etOrganisation;
    this.ivBackButton = ivBackButton;
    this.linearLayout = linearLayout;
    this.relativeLayout = relativeLayout;
    this.relativeLayout4 = relativeLayout4;
    this.textView139 = textView139;
    this.textView144 = textView144;
    this.textView15 = textView15;
    this.textView16 = textView16;
    this.textView19 = textView19;
    this.textViewdd19 = textViewdd19;
    this.tvEndDate = tvEndDate;
    this.tvSelectLocation = tvSelectLocation;
    this.tvStartDate = tvStartDate;
  }

  public abstract void setJobSeeker(@Nullable JobSeeker jobSeeker);

  @Nullable
  public JobSeeker getJobSeeker() {
    return mJobSeeker;
  }

  @NonNull
  public static FragmentSeekerAddVolunteeringBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_add_volunteering, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerAddVolunteeringBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerAddVolunteeringBinding>inflateInternal(inflater, R.layout.fragment_seeker_add_volunteering, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSeekerAddVolunteeringBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_add_volunteering, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerAddVolunteeringBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerAddVolunteeringBinding>inflateInternal(inflater, R.layout.fragment_seeker_add_volunteering, null, false, component);
  }

  public static FragmentSeekerAddVolunteeringBinding bind(@NonNull View view) {
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
  public static FragmentSeekerAddVolunteeringBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentSeekerAddVolunteeringBinding)bind(component, view, R.layout.fragment_seeker_add_volunteering);
  }
}
