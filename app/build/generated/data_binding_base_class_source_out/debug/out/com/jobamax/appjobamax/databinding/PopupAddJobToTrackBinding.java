// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class PopupAddJobToTrackBinding extends ViewDataBinding {
  @NonNull
  public final TextView tvMessage;

  protected PopupAddJobToTrackBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView tvMessage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tvMessage = tvMessage;
  }

  @NonNull
  public static PopupAddJobToTrackBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.popup_add_job_to_track, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static PopupAddJobToTrackBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<PopupAddJobToTrackBinding>inflateInternal(inflater, R.layout.popup_add_job_to_track, root, attachToRoot, component);
  }

  @NonNull
  public static PopupAddJobToTrackBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.popup_add_job_to_track, null, false, component)
   */
  @NonNull
  @Deprecated
  public static PopupAddJobToTrackBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<PopupAddJobToTrackBinding>inflateInternal(inflater, R.layout.popup_add_job_to_track, null, false, component);
  }

  public static PopupAddJobToTrackBinding bind(@NonNull View view) {
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
  public static PopupAddJobToTrackBinding bind(@NonNull View view, @Nullable Object component) {
    return (PopupAddJobToTrackBinding)bind(component, view, R.layout.popup_add_job_to_track);
  }
}
