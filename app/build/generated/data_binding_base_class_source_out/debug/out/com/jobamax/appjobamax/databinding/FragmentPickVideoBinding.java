// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentPickVideoBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clVideo;

  @NonNull
  public final ConstraintLayout constraintLayout16;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final ImageView ivLoading;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final LinearLayout llLoading;

  @NonNull
  public final SeekBar sbAudio;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final View view;

  protected FragmentPickVideoBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout clVideo, ConstraintLayout constraintLayout16, ImageView ivBackButton,
      ImageView ivLoading, LinearLayout linearLayout, LinearLayout llLoading, SeekBar sbAudio,
      TextView textView3, View view) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clVideo = clVideo;
    this.constraintLayout16 = constraintLayout16;
    this.ivBackButton = ivBackButton;
    this.ivLoading = ivLoading;
    this.linearLayout = linearLayout;
    this.llLoading = llLoading;
    this.sbAudio = sbAudio;
    this.textView3 = textView3;
    this.view = view;
  }

  @NonNull
  public static FragmentPickVideoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_pick_video, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPickVideoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentPickVideoBinding>inflateInternal(inflater, R.layout.fragment_pick_video, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentPickVideoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_pick_video, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPickVideoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentPickVideoBinding>inflateInternal(inflater, R.layout.fragment_pick_video, null, false, component);
  }

  public static FragmentPickVideoBinding bind(@NonNull View view) {
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
  public static FragmentPickVideoBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentPickVideoBinding)bind(component, view, R.layout.fragment_pick_video);
  }
}