// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class DialogWorkExperienceBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatCheckBox cbOneOrTwo;

  @NonNull
  public final AppCompatCheckBox cbTwoOrTree;

  @NonNull
  public final AppCompatCheckBox cbUnderOne;

  @NonNull
  public final TextView tvCancel;

  protected DialogWorkExperienceBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatCheckBox cbOneOrTwo, AppCompatCheckBox cbTwoOrTree, AppCompatCheckBox cbUnderOne,
      TextView tvCancel) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cbOneOrTwo = cbOneOrTwo;
    this.cbTwoOrTree = cbTwoOrTree;
    this.cbUnderOne = cbUnderOne;
    this.tvCancel = tvCancel;
  }

  @NonNull
  public static DialogWorkExperienceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_work_experience, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DialogWorkExperienceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DialogWorkExperienceBinding>inflateInternal(inflater, R.layout.dialog_work_experience, root, attachToRoot, component);
  }

  @NonNull
  public static DialogWorkExperienceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_work_experience, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DialogWorkExperienceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DialogWorkExperienceBinding>inflateInternal(inflater, R.layout.dialog_work_experience, null, false, component);
  }

  public static DialogWorkExperienceBinding bind(@NonNull View view) {
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
  public static DialogWorkExperienceBinding bind(@NonNull View view, @Nullable Object component) {
    return (DialogWorkExperienceBinding)bind(component, view, R.layout.dialog_work_experience);
  }
}