// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentTakeWorkExperienceBinding extends ViewDataBinding {
  @NonNull
  public final FragmentContainerView autocompleteFragment;

  @NonNull
  public final AppCompatButton btnContinue;

  @NonNull
  public final AppCompatCheckBox cbApprenticeship;

  @NonNull
  public final AppCompatCheckBox cbInternship;

  @NonNull
  public final AppCompatCheckBox cbPartTime;

  @NonNull
  public final AppCompatCheckBox cbPermanent;

  @NonNull
  public final LinearLayout constraintLayout14;

  @NonNull
  public final ConstraintLayout constraintLayout9;

  @NonNull
  public final ImageView imageView5;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final LinearLayout linearLayout20;

  @NonNull
  public final SeekBar sbEducation;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView tvSelectLocation;

  protected FragmentTakeWorkExperienceBinding(Object _bindingComponent, View _root,
      int _localFieldCount, FragmentContainerView autocompleteFragment, AppCompatButton btnContinue,
      AppCompatCheckBox cbApprenticeship, AppCompatCheckBox cbInternship,
      AppCompatCheckBox cbPartTime, AppCompatCheckBox cbPermanent, LinearLayout constraintLayout14,
      ConstraintLayout constraintLayout9, ImageView imageView5, ImageView ivBackButton,
      LinearLayout linearLayout20, SeekBar sbEducation, TextView textView12,
      TextView tvSelectLocation) {
    super(_bindingComponent, _root, _localFieldCount);
    this.autocompleteFragment = autocompleteFragment;
    this.btnContinue = btnContinue;
    this.cbApprenticeship = cbApprenticeship;
    this.cbInternship = cbInternship;
    this.cbPartTime = cbPartTime;
    this.cbPermanent = cbPermanent;
    this.constraintLayout14 = constraintLayout14;
    this.constraintLayout9 = constraintLayout9;
    this.imageView5 = imageView5;
    this.ivBackButton = ivBackButton;
    this.linearLayout20 = linearLayout20;
    this.sbEducation = sbEducation;
    this.textView12 = textView12;
    this.tvSelectLocation = tvSelectLocation;
  }

  @NonNull
  public static FragmentTakeWorkExperienceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_take_work_experience, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentTakeWorkExperienceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentTakeWorkExperienceBinding>inflateInternal(inflater, R.layout.fragment_take_work_experience, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentTakeWorkExperienceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_take_work_experience, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentTakeWorkExperienceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentTakeWorkExperienceBinding>inflateInternal(inflater, R.layout.fragment_take_work_experience, null, false, component);
  }

  public static FragmentTakeWorkExperienceBinding bind(@NonNull View view) {
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
  public static FragmentTakeWorkExperienceBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentTakeWorkExperienceBinding)bind(component, view, R.layout.fragment_take_work_experience);
  }
}