// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSearchBinding extends ViewDataBinding {
  @NonNull
  public final Guideline guidelineOne;

  @NonNull
  public final Guideline guidelineTwo;

  @NonNull
  public final ImageView profileIvTopBg;

  protected FragmentSearchBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Guideline guidelineOne, Guideline guidelineTwo, ImageView profileIvTopBg) {
    super(_bindingComponent, _root, _localFieldCount);
    this.guidelineOne = guidelineOne;
    this.guidelineTwo = guidelineTwo;
    this.profileIvTopBg = profileIvTopBg;
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_search, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSearchBinding>inflateInternal(inflater, R.layout.fragment_search, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_search, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSearchBinding>inflateInternal(inflater, R.layout.fragment_search, null, false, component);
  }

  public static FragmentSearchBinding bind(@NonNull View view) {
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
  public static FragmentSearchBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentSearchBinding)bind(component, view, R.layout.fragment_search);
  }
}