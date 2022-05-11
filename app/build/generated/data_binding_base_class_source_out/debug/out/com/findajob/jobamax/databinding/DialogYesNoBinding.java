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

public abstract class DialogYesNoBinding extends ViewDataBinding {
  @NonNull
  public final TextView tvMessage;

  @NonNull
  public final TextView tvNoBtn;

  @NonNull
  public final TextView tvYesBtn;

  protected DialogYesNoBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView tvMessage, TextView tvNoBtn, TextView tvYesBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tvMessage = tvMessage;
    this.tvNoBtn = tvNoBtn;
    this.tvYesBtn = tvYesBtn;
  }

  @NonNull
  public static DialogYesNoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_yes_no, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DialogYesNoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DialogYesNoBinding>inflateInternal(inflater, R.layout.dialog_yes_no, root, attachToRoot, component);
  }

  @NonNull
  public static DialogYesNoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_yes_no, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DialogYesNoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DialogYesNoBinding>inflateInternal(inflater, R.layout.dialog_yes_no, null, false, component);
  }

  public static DialogYesNoBinding bind(@NonNull View view) {
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
  public static DialogYesNoBinding bind(@NonNull View view, @Nullable Object component) {
    return (DialogYesNoBinding)bind(component, view, R.layout.dialog_yes_no);
  }
}