// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSeekerFilterJobBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton btnGo;

  @NonNull
  public final CheckBox cbAll;

  @NonNull
  public final CheckBox cbArchive;

  @NonNull
  public final CheckBox cbFavorite;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final TextView textView24;

  protected FragmentSeekerFilterJobBinding(Object _bindingComponent, View _root,
      int _localFieldCount, AppCompatButton btnGo, CheckBox cbAll, CheckBox cbArchive,
      CheckBox cbFavorite, ImageView ivBackButton, RelativeLayout relativeLayout,
      TextView textView24) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnGo = btnGo;
    this.cbAll = cbAll;
    this.cbArchive = cbArchive;
    this.cbFavorite = cbFavorite;
    this.ivBackButton = ivBackButton;
    this.relativeLayout = relativeLayout;
    this.textView24 = textView24;
  }

  @NonNull
  public static FragmentSeekerFilterJobBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_filter_job, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerFilterJobBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerFilterJobBinding>inflateInternal(inflater, R.layout.fragment_seeker_filter_job, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSeekerFilterJobBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_filter_job, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerFilterJobBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerFilterJobBinding>inflateInternal(inflater, R.layout.fragment_seeker_filter_job, null, false, component);
  }

  public static FragmentSeekerFilterJobBinding bind(@NonNull View view) {
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
  public static FragmentSeekerFilterJobBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentSeekerFilterJobBinding)bind(component, view, R.layout.fragment_seeker_filter_job);
  }
}