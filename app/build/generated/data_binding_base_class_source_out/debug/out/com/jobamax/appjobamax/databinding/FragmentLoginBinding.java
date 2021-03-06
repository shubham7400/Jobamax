// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.login.LoginInterface;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentLoginBinding extends ViewDataBinding {
  @NonNull
  public final EditText emailField;

  @NonNull
  public final LinearLayout footerLayout;

  @NonNull
  public final ImageView jobamaxImage;

  @NonNull
  public final ImageView loginImage;

  @NonNull
  public final LinearLayout loginLayout;

  @NonNull
  public final EditText passwordField;

  @NonNull
  public final ImageView showPasswordButton;

  @NonNull
  public final LinearLayout socialMediaLayout;

  @Bindable
  protected LoginInterface mHandler;

  protected FragmentLoginBinding(Object _bindingComponent, View _root, int _localFieldCount,
      EditText emailField, LinearLayout footerLayout, ImageView jobamaxImage, ImageView loginImage,
      LinearLayout loginLayout, EditText passwordField, ImageView showPasswordButton,
      LinearLayout socialMediaLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.emailField = emailField;
    this.footerLayout = footerLayout;
    this.jobamaxImage = jobamaxImage;
    this.loginImage = loginImage;
    this.loginLayout = loginLayout;
    this.passwordField = passwordField;
    this.showPasswordButton = showPasswordButton;
    this.socialMediaLayout = socialMediaLayout;
  }

  public abstract void setHandler(@Nullable LoginInterface handler);

  @Nullable
  public LoginInterface getHandler() {
    return mHandler;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_login, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentLoginBinding>inflateInternal(inflater, R.layout.fragment_login, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_login, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentLoginBinding>inflateInternal(inflater, R.layout.fragment_login, null, false, component);
  }

  public static FragmentLoginBinding bind(@NonNull View view) {
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
  public static FragmentLoginBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentLoginBinding)bind(component, view, R.layout.fragment_login);
  }
}
