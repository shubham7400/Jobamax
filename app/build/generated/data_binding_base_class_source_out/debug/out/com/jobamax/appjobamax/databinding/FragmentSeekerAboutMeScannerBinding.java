// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSeekerAboutMeScannerBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final RelativeLayout relativeLayout;

  protected FragmentSeekerAboutMeScannerBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView imageView3, ImageView ivBackButton,
      RelativeLayout relativeLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageView3 = imageView3;
    this.ivBackButton = ivBackButton;
    this.relativeLayout = relativeLayout;
  }

  @NonNull
  public static FragmentSeekerAboutMeScannerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_about_me_scanner, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerAboutMeScannerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerAboutMeScannerBinding>inflateInternal(inflater, R.layout.fragment_seeker_about_me_scanner, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSeekerAboutMeScannerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_about_me_scanner, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerAboutMeScannerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerAboutMeScannerBinding>inflateInternal(inflater, R.layout.fragment_seeker_about_me_scanner, null, false, component);
  }

  public static FragmentSeekerAboutMeScannerBinding bind(@NonNull View view) {
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
  public static FragmentSeekerAboutMeScannerBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentSeekerAboutMeScannerBinding)bind(component, view, R.layout.fragment_seeker_about_me_scanner);
  }
}
