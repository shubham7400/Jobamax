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
import com.findajob.jobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class DialogConfirmationBinding extends ViewDataBinding {
  @NonNull
  public final Button btnNegative;

  @NonNull
  public final Button btnPositive;

  @NonNull
  public final ImageView ivLogo;

  @NonNull
  public final TextView tvNotificationBody;

  protected DialogConfirmationBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button btnNegative, Button btnPositive, ImageView ivLogo, TextView tvNotificationBody) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnNegative = btnNegative;
    this.btnPositive = btnPositive;
    this.ivLogo = ivLogo;
    this.tvNotificationBody = tvNotificationBody;
  }

  @NonNull
  public static DialogConfirmationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_confirmation, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DialogConfirmationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DialogConfirmationBinding>inflateInternal(inflater, R.layout.dialog_confirmation, root, attachToRoot, component);
  }

  @NonNull
  public static DialogConfirmationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_confirmation, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DialogConfirmationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DialogConfirmationBinding>inflateInternal(inflater, R.layout.dialog_confirmation, null, false, component);
  }

  public static DialogConfirmationBinding bind(@NonNull View view) {
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
  public static DialogConfirmationBinding bind(@NonNull View view, @Nullable Object component) {
    return (DialogConfirmationBinding)bind(component, view, R.layout.dialog_confirmation);
  }
}
