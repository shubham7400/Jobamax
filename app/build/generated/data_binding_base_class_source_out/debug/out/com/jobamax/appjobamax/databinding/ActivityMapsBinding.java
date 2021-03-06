// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityMapsBinding extends ViewDataBinding {
  @NonNull
  public final FragmentContainerView map;

  protected ActivityMapsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      FragmentContainerView map) {
    super(_bindingComponent, _root, _localFieldCount);
    this.map = map;
  }

  @NonNull
  public static ActivityMapsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_maps, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMapsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMapsBinding>inflateInternal(inflater, R.layout.activity_maps, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMapsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_maps, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMapsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMapsBinding>inflateInternal(inflater, R.layout.activity_maps, null, false, component);
  }

  public static ActivityMapsBinding bind(@NonNull View view) {
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
  public static ActivityMapsBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMapsBinding)bind(component, view, R.layout.activity_maps);
  }
}
