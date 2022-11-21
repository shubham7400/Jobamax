// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityRecruiterHomeBinding extends ViewDataBinding {
  @NonNull
  public final TabLayout tabLayout;

  @NonNull
  public final View vDevider;

  @NonNull
  public final ViewPager2 viewPager;

  protected ActivityRecruiterHomeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TabLayout tabLayout, View vDevider, ViewPager2 viewPager) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tabLayout = tabLayout;
    this.vDevider = vDevider;
    this.viewPager = viewPager;
  }

  @NonNull
  public static ActivityRecruiterHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_recruiter_home, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityRecruiterHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityRecruiterHomeBinding>inflateInternal(inflater, R.layout.activity_recruiter_home, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityRecruiterHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_recruiter_home, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityRecruiterHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityRecruiterHomeBinding>inflateInternal(inflater, R.layout.activity_recruiter_home, null, false, component);
  }

  public static ActivityRecruiterHomeBinding bind(@NonNull View view) {
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
  public static ActivityRecruiterHomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityRecruiterHomeBinding)bind(component, view, R.layout.activity_recruiter_home);
  }
}