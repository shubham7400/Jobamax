// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.findajob.jobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class DialogRequirementsOldBinding extends ViewDataBinding {
  @NonNull
  public final Button btnSkip;

  @NonNull
  public final Button btnSubmit;

  @NonNull
  public final ImageView ivLogo;

  @NonNull
  public final RecyclerView rvCheckItem;

  @NonNull
  public final TextView tvTitle;

  protected DialogRequirementsOldBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button btnSkip, Button btnSubmit, ImageView ivLogo, RecyclerView rvCheckItem,
      TextView tvTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSkip = btnSkip;
    this.btnSubmit = btnSubmit;
    this.ivLogo = ivLogo;
    this.rvCheckItem = rvCheckItem;
    this.tvTitle = tvTitle;
  }

  @NonNull
  public static DialogRequirementsOldBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_requirements_old, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DialogRequirementsOldBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DialogRequirementsOldBinding>inflateInternal(inflater, R.layout.dialog_requirements_old, root, attachToRoot, component);
  }

  @NonNull
  public static DialogRequirementsOldBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_requirements_old, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DialogRequirementsOldBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DialogRequirementsOldBinding>inflateInternal(inflater, R.layout.dialog_requirements_old, null, false, component);
  }

  public static DialogRequirementsOldBinding bind(@NonNull View view) {
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
  public static DialogRequirementsOldBinding bind(@NonNull View view, @Nullable Object component) {
    return (DialogRequirementsOldBinding)bind(component, view, R.layout.dialog_requirements_old);
  }
}
