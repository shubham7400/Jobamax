// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.jobseeker.profile.cv.experience.CreateExperienceHandler;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentCreateExperienceBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton button;

  @NonNull
  public final CheckBox cbCurrentlyWorking;

  @NonNull
  public final ConstraintLayout clActionBar;

  @NonNull
  public final EditText companyField;

  @NonNull
  public final EditText expDescriptionField;

  @NonNull
  public final TextView experienceEndDateField;

  @NonNull
  public final TextView experienceStartDateField;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final EditText jobNameField;

  @NonNull
  public final TextView tvLocationField;

  @Bindable
  protected CreateExperienceHandler mHandler;

  protected FragmentCreateExperienceBinding(Object _bindingComponent, View _root,
      int _localFieldCount, AppCompatButton button, CheckBox cbCurrentlyWorking,
      ConstraintLayout clActionBar, EditText companyField, EditText expDescriptionField,
      TextView experienceEndDateField, TextView experienceStartDateField, ImageView ivBackButton,
      EditText jobNameField, TextView tvLocationField) {
    super(_bindingComponent, _root, _localFieldCount);
    this.button = button;
    this.cbCurrentlyWorking = cbCurrentlyWorking;
    this.clActionBar = clActionBar;
    this.companyField = companyField;
    this.expDescriptionField = expDescriptionField;
    this.experienceEndDateField = experienceEndDateField;
    this.experienceStartDateField = experienceStartDateField;
    this.ivBackButton = ivBackButton;
    this.jobNameField = jobNameField;
    this.tvLocationField = tvLocationField;
  }

  public abstract void setHandler(@Nullable CreateExperienceHandler handler);

  @Nullable
  public CreateExperienceHandler getHandler() {
    return mHandler;
  }

  @NonNull
  public static FragmentCreateExperienceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_create_experience, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentCreateExperienceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentCreateExperienceBinding>inflateInternal(inflater, R.layout.fragment_create_experience, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentCreateExperienceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_create_experience, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentCreateExperienceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentCreateExperienceBinding>inflateInternal(inflater, R.layout.fragment_create_experience, null, false, component);
  }

  public static FragmentCreateExperienceBinding bind(@NonNull View view) {
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
  public static FragmentCreateExperienceBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentCreateExperienceBinding)bind(component, view, R.layout.fragment_create_experience);
  }
}
