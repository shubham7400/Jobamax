// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentWelcomeAsSeekerBinding extends ViewDataBinding {
  @NonNull
  public final Button btnGotIt;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final TextView textView14;

  protected FragmentWelcomeAsSeekerBinding(Object _bindingComponent, View _root,
      int _localFieldCount, Button btnGotIt, ConstraintLayout constraintLayout,
      TextView textView14) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnGotIt = btnGotIt;
    this.constraintLayout = constraintLayout;
    this.textView14 = textView14;
  }

  @NonNull
  public static FragmentWelcomeAsSeekerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_welcome_as_seeker, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentWelcomeAsSeekerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentWelcomeAsSeekerBinding>inflateInternal(inflater, R.layout.fragment_welcome_as_seeker, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWelcomeAsSeekerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_welcome_as_seeker, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentWelcomeAsSeekerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentWelcomeAsSeekerBinding>inflateInternal(inflater, R.layout.fragment_welcome_as_seeker, null, false, component);
  }

  public static FragmentWelcomeAsSeekerBinding bind(@NonNull View view) {
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
  public static FragmentWelcomeAsSeekerBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentWelcomeAsSeekerBinding)bind(component, view, R.layout.fragment_welcome_as_seeker);
  }
}