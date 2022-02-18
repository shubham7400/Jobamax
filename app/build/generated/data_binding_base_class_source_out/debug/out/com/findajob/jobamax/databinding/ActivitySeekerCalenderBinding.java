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

public abstract class ActivitySeekerCalenderBinding extends ViewDataBinding {
  @NonNull
  public final FragmentContainerView calenderNavHostFragment;

  protected ActivitySeekerCalenderBinding(Object _bindingComponent, View _root,
      int _localFieldCount, FragmentContainerView calenderNavHostFragment) {
    super(_bindingComponent, _root, _localFieldCount);
    this.calenderNavHostFragment = calenderNavHostFragment;
  }

  @NonNull
  public static ActivitySeekerCalenderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_seeker_calender, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySeekerCalenderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySeekerCalenderBinding>inflateInternal(inflater, R.layout.activity_seeker_calender, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySeekerCalenderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_seeker_calender, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySeekerCalenderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySeekerCalenderBinding>inflateInternal(inflater, R.layout.activity_seeker_calender, null, false, component);
  }

  public static ActivitySeekerCalenderBinding bind(@NonNull View view) {
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
  public static ActivitySeekerCalenderBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySeekerCalenderBinding)bind(component, view, R.layout.activity_seeker_calender);
  }
}
