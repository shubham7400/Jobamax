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
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.jobseeker.profile.account.password.JobSeekerPasswordInterface;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSeekerChangePasswordBinding extends ViewDataBinding {
  @NonNull
  public final EditText confirmNewPasswordField;

  @NonNull
  public final ConstraintLayout customToolbar;

  @NonNull
  public final AppCompatImageView imageView;

  @NonNull
  public final EditText newPasswordField;

  @NonNull
  public final Button submitButton;

  @Bindable
  protected JobSeekerPasswordInterface mHandler;

  protected FragmentSeekerChangePasswordBinding(Object _bindingComponent, View _root,
      int _localFieldCount, EditText confirmNewPasswordField, ConstraintLayout customToolbar,
      AppCompatImageView imageView, EditText newPasswordField, Button submitButton) {
    super(_bindingComponent, _root, _localFieldCount);
    this.confirmNewPasswordField = confirmNewPasswordField;
    this.customToolbar = customToolbar;
    this.imageView = imageView;
    this.newPasswordField = newPasswordField;
    this.submitButton = submitButton;
  }

  public abstract void setHandler(@Nullable JobSeekerPasswordInterface handler);

  @Nullable
  public JobSeekerPasswordInterface getHandler() {
    return mHandler;
  }

  @NonNull
  public static FragmentSeekerChangePasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_change_password, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerChangePasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerChangePasswordBinding>inflateInternal(inflater, R.layout.fragment_seeker_change_password, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSeekerChangePasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_change_password, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerChangePasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerChangePasswordBinding>inflateInternal(inflater, R.layout.fragment_seeker_change_password, null, false, component);
  }

  public static FragmentSeekerChangePasswordBinding bind(@NonNull View view) {
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
  public static FragmentSeekerChangePasswordBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentSeekerChangePasswordBinding)bind(component, view, R.layout.fragment_seeker_change_password);
  }
}