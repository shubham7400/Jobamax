// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.jobseeker.profile.account.pushNotification.JobSeekerPushNotificationInterface;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentJobSeekerPushNotificationBinding extends ViewDataBinding {
  @NonNull
  public final AppBarLayout appBar;

  @NonNull
  public final AppCompatImageView imageView;

  @NonNull
  public final SwitchCompat messageCheck;

  @NonNull
  public final SwitchCompat newMatchesFlag;

  @NonNull
  public final AppCompatTextView tvToolbarTitle;

  @Bindable
  protected JobSeekerPushNotificationInterface mHandler;

  protected FragmentJobSeekerPushNotificationBinding(Object _bindingComponent, View _root,
      int _localFieldCount, AppBarLayout appBar, AppCompatImageView imageView,
      SwitchCompat messageCheck, SwitchCompat newMatchesFlag, AppCompatTextView tvToolbarTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appBar = appBar;
    this.imageView = imageView;
    this.messageCheck = messageCheck;
    this.newMatchesFlag = newMatchesFlag;
    this.tvToolbarTitle = tvToolbarTitle;
  }

  public abstract void setHandler(@Nullable JobSeekerPushNotificationInterface handler);

  @Nullable
  public JobSeekerPushNotificationInterface getHandler() {
    return mHandler;
  }

  @NonNull
  public static FragmentJobSeekerPushNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_job_seeker_push_notification, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentJobSeekerPushNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentJobSeekerPushNotificationBinding>inflateInternal(inflater, R.layout.fragment_job_seeker_push_notification, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentJobSeekerPushNotificationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_job_seeker_push_notification, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentJobSeekerPushNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentJobSeekerPushNotificationBinding>inflateInternal(inflater, R.layout.fragment_job_seeker_push_notification, null, false, component);
  }

  public static FragmentJobSeekerPushNotificationBinding bind(@NonNull View view) {
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
  public static FragmentJobSeekerPushNotificationBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentJobSeekerPushNotificationBinding)bind(component, view, R.layout.fragment_job_seeker_push_notification);
  }
}
