// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentRecruiterChangePasswordBinding extends ViewDataBinding {
  @NonNull
  public final Button btnSave;

  @NonNull
  public final ConstraintLayout customToolbar;

  @NonNull
  public final EditText etConfirmPassword;

  @NonNull
  public final EditText etCurrentPassword;

  @NonNull
  public final EditText etNewPassword;

  @NonNull
  public final AppCompatImageView ivBackButton;

  protected FragmentRecruiterChangePasswordBinding(Object _bindingComponent, View _root,
      int _localFieldCount, Button btnSave, ConstraintLayout customToolbar,
      EditText etConfirmPassword, EditText etCurrentPassword, EditText etNewPassword,
      AppCompatImageView ivBackButton) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSave = btnSave;
    this.customToolbar = customToolbar;
    this.etConfirmPassword = etConfirmPassword;
    this.etCurrentPassword = etCurrentPassword;
    this.etNewPassword = etNewPassword;
    this.ivBackButton = ivBackButton;
  }

  @NonNull
  public static FragmentRecruiterChangePasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_recruiter_change_password, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentRecruiterChangePasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentRecruiterChangePasswordBinding>inflateInternal(inflater, R.layout.fragment_recruiter_change_password, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentRecruiterChangePasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_recruiter_change_password, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentRecruiterChangePasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentRecruiterChangePasswordBinding>inflateInternal(inflater, R.layout.fragment_recruiter_change_password, null, false, component);
  }

  public static FragmentRecruiterChangePasswordBinding bind(@NonNull View view) {
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
  public static FragmentRecruiterChangePasswordBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentRecruiterChangePasswordBinding)bind(component, view, R.layout.fragment_recruiter_change_password);
  }
}