// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.findajob.jobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityJobSeekerAccountBinding extends ViewDataBinding {
  @NonNull
  public final FragmentContainerView loginNavHostFragment;

  protected ActivityJobSeekerAccountBinding(Object _bindingComponent, View _root,
      int _localFieldCount, FragmentContainerView loginNavHostFragment) {
    super(_bindingComponent, _root, _localFieldCount);
    this.loginNavHostFragment = loginNavHostFragment;
  }

  @NonNull
  public static ActivityJobSeekerAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_job_seeker_account, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityJobSeekerAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityJobSeekerAccountBinding>inflateInternal(inflater, R.layout.activity_job_seeker_account, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityJobSeekerAccountBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_job_seeker_account, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityJobSeekerAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityJobSeekerAccountBinding>inflateInternal(inflater, R.layout.activity_job_seeker_account, null, false, component);
  }

  public static ActivityJobSeekerAccountBinding bind(@NonNull View view) {
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
  public static ActivityJobSeekerAccountBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityJobSeekerAccountBinding)bind(component, view, R.layout.activity_job_seeker_account);
  }
}
