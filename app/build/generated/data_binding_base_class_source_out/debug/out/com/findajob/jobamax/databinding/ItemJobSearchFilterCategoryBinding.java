// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemJobSearchFilterCategoryBinding extends ViewDataBinding {
  @NonNull
  public final CheckBox checkBox;

  @NonNull
  public final TextView tvText;

  protected ItemJobSearchFilterCategoryBinding(Object _bindingComponent, View _root,
      int _localFieldCount, CheckBox checkBox, TextView tvText) {
    super(_bindingComponent, _root, _localFieldCount);
    this.checkBox = checkBox;
    this.tvText = tvText;
  }

  @NonNull
  public static ItemJobSearchFilterCategoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_job_search_filter_category, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemJobSearchFilterCategoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemJobSearchFilterCategoryBinding>inflateInternal(inflater, R.layout.item_job_search_filter_category, root, attachToRoot, component);
  }

  @NonNull
  public static ItemJobSearchFilterCategoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_job_search_filter_category, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemJobSearchFilterCategoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemJobSearchFilterCategoryBinding>inflateInternal(inflater, R.layout.item_job_search_filter_category, null, false, component);
  }

  public static ItemJobSearchFilterCategoryBinding bind(@NonNull View view) {
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
  public static ItemJobSearchFilterCategoryBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ItemJobSearchFilterCategoryBinding)bind(component, view, R.layout.item_job_search_filter_category);
  }
}