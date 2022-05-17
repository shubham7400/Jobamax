// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class DialogAddTrackingJobPhaseBinding extends ViewDataBinding {
  @NonNull
  public final Button btnSave;

  @NonNull
  public final ImageView ivDismiss;

  @NonNull
  public final Spinner spPhase;

  @NonNull
  public final TextView tvSelectDate;

  protected DialogAddTrackingJobPhaseBinding(Object _bindingComponent, View _root,
      int _localFieldCount, Button btnSave, ImageView ivDismiss, Spinner spPhase,
      TextView tvSelectDate) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSave = btnSave;
    this.ivDismiss = ivDismiss;
    this.spPhase = spPhase;
    this.tvSelectDate = tvSelectDate;
  }

  @NonNull
  public static DialogAddTrackingJobPhaseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_add_tracking_job_phase, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DialogAddTrackingJobPhaseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DialogAddTrackingJobPhaseBinding>inflateInternal(inflater, R.layout.dialog_add_tracking_job_phase, root, attachToRoot, component);
  }

  @NonNull
  public static DialogAddTrackingJobPhaseBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_add_tracking_job_phase, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DialogAddTrackingJobPhaseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DialogAddTrackingJobPhaseBinding>inflateInternal(inflater, R.layout.dialog_add_tracking_job_phase, null, false, component);
  }

  public static DialogAddTrackingJobPhaseBinding bind(@NonNull View view) {
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
  public static DialogAddTrackingJobPhaseBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (DialogAddTrackingJobPhaseBinding)bind(component, view, R.layout.dialog_add_tracking_job_phase);
  }
}
