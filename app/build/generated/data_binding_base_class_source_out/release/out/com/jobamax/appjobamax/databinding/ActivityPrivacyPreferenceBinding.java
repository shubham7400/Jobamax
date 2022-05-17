// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityPrivacyPreferenceBinding extends ViewDataBinding {
  @NonNull
  public final SwitchCompat allowAdvertisingSwitch;

  @NonNull
  public final Button allowButton;

  @NonNull
  public final AppBarLayout appBar;

  @NonNull
  public final LinearLayout footerLayout;

  @NonNull
  public final SwitchCompat marketingPermissionSwitch;

  @NonNull
  public final Button refuseButton;

  @NonNull
  public final SwitchCompat socialMediaSwitch;

  @NonNull
  public final SwitchCompat strictNecessaryPermissionSwitch;

  @NonNull
  public final Toolbar toolbar;

  protected ActivityPrivacyPreferenceBinding(Object _bindingComponent, View _root,
      int _localFieldCount, SwitchCompat allowAdvertisingSwitch, Button allowButton,
      AppBarLayout appBar, LinearLayout footerLayout, SwitchCompat marketingPermissionSwitch,
      Button refuseButton, SwitchCompat socialMediaSwitch,
      SwitchCompat strictNecessaryPermissionSwitch, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.allowAdvertisingSwitch = allowAdvertisingSwitch;
    this.allowButton = allowButton;
    this.appBar = appBar;
    this.footerLayout = footerLayout;
    this.marketingPermissionSwitch = marketingPermissionSwitch;
    this.refuseButton = refuseButton;
    this.socialMediaSwitch = socialMediaSwitch;
    this.strictNecessaryPermissionSwitch = strictNecessaryPermissionSwitch;
    this.toolbar = toolbar;
  }

  @NonNull
  public static ActivityPrivacyPreferenceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_privacy_preference, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPrivacyPreferenceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityPrivacyPreferenceBinding>inflateInternal(inflater, R.layout.activity_privacy_preference, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityPrivacyPreferenceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_privacy_preference, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPrivacyPreferenceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityPrivacyPreferenceBinding>inflateInternal(inflater, R.layout.activity_privacy_preference, null, false, component);
  }

  public static ActivityPrivacyPreferenceBinding bind(@NonNull View view) {
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
  public static ActivityPrivacyPreferenceBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityPrivacyPreferenceBinding)bind(component, view, R.layout.activity_privacy_preference);
  }
}