// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class DialogAddLinkedinBinding extends ViewDataBinding {
  @NonNull
  public final Button btnNegative;

  @NonNull
  public final Button btnPositive;

  @NonNull
  public final EditText etLinkedin;

  @NonNull
  public final ImageView ivLogo;

  @NonNull
  public final LinearLayout llLinkedin;

  @NonNull
  public final TextView tvBody;

  protected DialogAddLinkedinBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button btnNegative, Button btnPositive, EditText etLinkedin, ImageView ivLogo,
      LinearLayout llLinkedin, TextView tvBody) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnNegative = btnNegative;
    this.btnPositive = btnPositive;
    this.etLinkedin = etLinkedin;
    this.ivLogo = ivLogo;
    this.llLinkedin = llLinkedin;
    this.tvBody = tvBody;
  }

  @NonNull
  public static DialogAddLinkedinBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_add_linkedin, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DialogAddLinkedinBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DialogAddLinkedinBinding>inflateInternal(inflater, R.layout.dialog_add_linkedin, root, attachToRoot, component);
  }

  @NonNull
  public static DialogAddLinkedinBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_add_linkedin, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DialogAddLinkedinBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DialogAddLinkedinBinding>inflateInternal(inflater, R.layout.dialog_add_linkedin, null, false, component);
  }

  public static DialogAddLinkedinBinding bind(@NonNull View view) {
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
  public static DialogAddLinkedinBinding bind(@NonNull View view, @Nullable Object component) {
    return (DialogAddLinkedinBinding)bind(component, view, R.layout.dialog_add_linkedin);
  }
}
