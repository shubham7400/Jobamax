// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.model.JobSeeker;
import com.google.android.material.chip.ChipGroup;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSeekerProfileBinding extends ViewDataBinding {
  @NonNull
  public final ChipGroup cgIdealWorkspace;

  @NonNull
  public final ConstraintLayout clEducation;

  @NonNull
  public final ConstraintLayout clJobs;

  @NonNull
  public final ConstraintLayout clSkills;

  @NonNull
  public final ConstraintLayout clVolunteeringActivities;

  @NonNull
  public final ConstraintLayout constraintLayout3;

  @NonNull
  public final AutoCompleteTextView etIdealWorkspace;

  @NonNull
  public final ImageView imageView11;

  @NonNull
  public final ImageView ivAddIdealWorkspaceBtn;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final ImageView ivCalender;

  @NonNull
  public final ImageView ivCalendxer;

  @NonNull
  public final ImageView ivCalvender;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView73;

  @NonNull
  public final TextView textView76;

  @NonNull
  public final TextView textView77;

  @NonNull
  public final ImageView textView8;

  @NonNull
  public final ImageView textView83;

  @NonNull
  public final ImageView textView86;

  @NonNull
  public final ImageView textView88;

  @NonNull
  public final TextView tvAaa;

  @NonNull
  public final TextView tvAboutMeBtn;

  @NonNull
  public final TextView tvCalenderTitle;

  @NonNull
  public final TextView tvCalenderTitlef;

  @NonNull
  public final TextView tvCalenderTitlex;

  @NonNull
  public final TextView tvDdd;

  @NonNull
  public final TextView tvSeekerName;

  @Bindable
  protected JobSeeker mJobSeeker;

  protected FragmentSeekerProfileBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ChipGroup cgIdealWorkspace, ConstraintLayout clEducation, ConstraintLayout clJobs,
      ConstraintLayout clSkills, ConstraintLayout clVolunteeringActivities,
      ConstraintLayout constraintLayout3, AutoCompleteTextView etIdealWorkspace,
      ImageView imageView11, ImageView ivAddIdealWorkspaceBtn, ImageView ivBackButton,
      ImageView ivCalender, ImageView ivCalendxer, ImageView ivCalvender, TextView textView6,
      TextView textView7, TextView textView73, TextView textView76, TextView textView77,
      ImageView textView8, ImageView textView83, ImageView textView86, ImageView textView88,
      TextView tvAaa, TextView tvAboutMeBtn, TextView tvCalenderTitle, TextView tvCalenderTitlef,
      TextView tvCalenderTitlex, TextView tvDdd, TextView tvSeekerName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cgIdealWorkspace = cgIdealWorkspace;
    this.clEducation = clEducation;
    this.clJobs = clJobs;
    this.clSkills = clSkills;
    this.clVolunteeringActivities = clVolunteeringActivities;
    this.constraintLayout3 = constraintLayout3;
    this.etIdealWorkspace = etIdealWorkspace;
    this.imageView11 = imageView11;
    this.ivAddIdealWorkspaceBtn = ivAddIdealWorkspaceBtn;
    this.ivBackButton = ivBackButton;
    this.ivCalender = ivCalender;
    this.ivCalendxer = ivCalendxer;
    this.ivCalvender = ivCalvender;
    this.textView6 = textView6;
    this.textView7 = textView7;
    this.textView73 = textView73;
    this.textView76 = textView76;
    this.textView77 = textView77;
    this.textView8 = textView8;
    this.textView83 = textView83;
    this.textView86 = textView86;
    this.textView88 = textView88;
    this.tvAaa = tvAaa;
    this.tvAboutMeBtn = tvAboutMeBtn;
    this.tvCalenderTitle = tvCalenderTitle;
    this.tvCalenderTitlef = tvCalenderTitlef;
    this.tvCalenderTitlex = tvCalenderTitlex;
    this.tvDdd = tvDdd;
    this.tvSeekerName = tvSeekerName;
  }

  public abstract void setJobSeeker(@Nullable JobSeeker jobSeeker);

  @Nullable
  public JobSeeker getJobSeeker() {
    return mJobSeeker;
  }

  @NonNull
  public static FragmentSeekerProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_profile, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerProfileBinding>inflateInternal(inflater, R.layout.fragment_seeker_profile, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSeekerProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_profile, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerProfileBinding>inflateInternal(inflater, R.layout.fragment_seeker_profile, null, false, component);
  }

  public static FragmentSeekerProfileBinding bind(@NonNull View view) {
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
  public static FragmentSeekerProfileBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentSeekerProfileBinding)bind(component, view, R.layout.fragment_seeker_profile);
  }
}
