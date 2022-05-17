// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemLinkBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final TextView tvLink;

  protected ItemLinkBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView imageView2, TextView tvLink) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageView2 = imageView2;
    this.tvLink = tvLink;
  }

  @NonNull
  public static ItemLinkBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_link, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemLinkBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemLinkBinding>inflateInternal(inflater, R.layout.item_link, root, attachToRoot, component);
  }

  @NonNull
  public static ItemLinkBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_link, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemLinkBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemLinkBinding>inflateInternal(inflater, R.layout.item_link, null, false, component);
  }

  public static ItemLinkBinding bind(@NonNull View view) {
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
  public static ItemLinkBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemLinkBinding)bind(component, view, R.layout.item_link);
  }
}
