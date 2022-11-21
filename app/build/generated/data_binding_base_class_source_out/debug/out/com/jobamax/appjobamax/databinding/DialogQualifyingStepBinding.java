// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.customview.CustomSpinner;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class DialogQualifyingStepBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton btnSort;

  @NonNull
  public final ImageView ivClose;

  @NonNull
  public final CustomSpinner spQualifyingStep;

  @NonNull
  public final TextView tvTitle;

  protected DialogQualifyingStepBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatButton btnSort, ImageView ivClose, CustomSpinner spQualifyingStep,
      TextView tvTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSort = btnSort;
    this.ivClose = ivClose;
    this.spQualifyingStep = spQualifyingStep;
    this.tvTitle = tvTitle;
  }

  @NonNull
  public static DialogQualifyingStepBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_qualifying_step, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DialogQualifyingStepBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DialogQualifyingStepBinding>inflateInternal(inflater, R.layout.dialog_qualifying_step, root, attachToRoot, component);
  }

  @NonNull
  public static DialogQualifyingStepBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_qualifying_step, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DialogQualifyingStepBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DialogQualifyingStepBinding>inflateInternal(inflater, R.layout.dialog_qualifying_step, null, false, component);
  }

  public static DialogQualifyingStepBinding bind(@NonNull View view) {
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
  public static DialogQualifyingStepBinding bind(@NonNull View view, @Nullable Object component) {
    return (DialogQualifyingStepBinding)bind(component, view, R.layout.dialog_qualifying_step);
  }
}