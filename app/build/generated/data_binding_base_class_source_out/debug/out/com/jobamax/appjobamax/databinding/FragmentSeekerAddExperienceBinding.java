// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import androidx.recyclerview.widget.RecyclerView;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.model.JobSeeker;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSeekerAddExperienceBinding extends ViewDataBinding {
  @NonNull
  public final FragmentContainerView autocompleteFragment;

  @NonNull
  public final ConstraintLayout clMostParent;

  @NonNull
  public final EditText etCompanyName;

  @NonNull
  public final EditText etDescription;

  @NonNull
  public final EditText etJob;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final ImageView ivClearEndDate;

  @NonNull
  public final ImageView ivClearStartDate;

  @NonNull
  public final CircleImageView ivUserProfile;

  @NonNull
  public final LinearLayout linearLayout4;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final RelativeLayout relativeLayout4;

  @NonNull
  public final RecyclerView rvCompanySuggestions;

  @NonNull
  public final TextView textView139;

  @NonNull
  public final TextView textView13r49;

  @NonNull
  public final TextView textView13rdd49;

  @NonNull
  public final TextView textView16;

  @NonNull
  public final TextView textView19;

  @NonNull
  public final TextView textViewdd19;

  @NonNull
  public final TextView tvSelectEndDate;

  @NonNull
  public final TextView tvSelectLocation;

  @NonNull
  public final TextView tvSelectStartDate;

  @Bindable
  protected JobSeeker mJobSeeker;

  protected FragmentSeekerAddExperienceBinding(Object _bindingComponent, View _root,
      int _localFieldCount, FragmentContainerView autocompleteFragment,
      ConstraintLayout clMostParent, EditText etCompanyName, EditText etDescription, EditText etJob,
      ImageView ivBackButton, ImageView ivClearEndDate, ImageView ivClearStartDate,
      CircleImageView ivUserProfile, LinearLayout linearLayout4, RelativeLayout relativeLayout,
      RelativeLayout relativeLayout4, RecyclerView rvCompanySuggestions, TextView textView139,
      TextView textView13r49, TextView textView13rdd49, TextView textView16, TextView textView19,
      TextView textViewdd19, TextView tvSelectEndDate, TextView tvSelectLocation,
      TextView tvSelectStartDate) {
    super(_bindingComponent, _root, _localFieldCount);
    this.autocompleteFragment = autocompleteFragment;
    this.clMostParent = clMostParent;
    this.etCompanyName = etCompanyName;
    this.etDescription = etDescription;
    this.etJob = etJob;
    this.ivBackButton = ivBackButton;
    this.ivClearEndDate = ivClearEndDate;
    this.ivClearStartDate = ivClearStartDate;
    this.ivUserProfile = ivUserProfile;
    this.linearLayout4 = linearLayout4;
    this.relativeLayout = relativeLayout;
    this.relativeLayout4 = relativeLayout4;
    this.rvCompanySuggestions = rvCompanySuggestions;
    this.textView139 = textView139;
    this.textView13r49 = textView13r49;
    this.textView13rdd49 = textView13rdd49;
    this.textView16 = textView16;
    this.textView19 = textView19;
    this.textViewdd19 = textViewdd19;
    this.tvSelectEndDate = tvSelectEndDate;
    this.tvSelectLocation = tvSelectLocation;
    this.tvSelectStartDate = tvSelectStartDate;
  }

  public abstract void setJobSeeker(@Nullable JobSeeker jobSeeker);

  @Nullable
  public JobSeeker getJobSeeker() {
    return mJobSeeker;
  }

  @NonNull
  public static FragmentSeekerAddExperienceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_add_experience, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerAddExperienceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerAddExperienceBinding>inflateInternal(inflater, R.layout.fragment_seeker_add_experience, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSeekerAddExperienceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_add_experience, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerAddExperienceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerAddExperienceBinding>inflateInternal(inflater, R.layout.fragment_seeker_add_experience, null, false, component);
  }

  public static FragmentSeekerAddExperienceBinding bind(@NonNull View view) {
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
  public static FragmentSeekerAddExperienceBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentSeekerAddExperienceBinding)bind(component, view, R.layout.fragment_seeker_add_experience);
  }
}
