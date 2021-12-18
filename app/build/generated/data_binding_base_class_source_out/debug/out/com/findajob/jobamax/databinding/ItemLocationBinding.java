// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemLocationBinding extends ViewDataBinding {
  @NonNull
  public final TextView cityLabel;

  @NonNull
  public final View vHorizontalLine;

  protected ItemLocationBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView cityLabel, View vHorizontalLine) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cityLabel = cityLabel;
    this.vHorizontalLine = vHorizontalLine;
  }

  @NonNull
  public static ItemLocationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_location, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemLocationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemLocationBinding>inflateInternal(inflater, R.layout.item_location, root, attachToRoot, component);
  }

  @NonNull
  public static ItemLocationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_location, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemLocationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemLocationBinding>inflateInternal(inflater, R.layout.item_location, null, false, component);
  }

  public static ItemLocationBinding bind(@NonNull View view) {
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
  public static ItemLocationBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemLocationBinding)bind(component, view, R.layout.item_location);
  }
}
