// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentPickAudioBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clAudioIntro;

  @NonNull
  public final ConstraintLayout constraintLayout16;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView tvAudioTime;

  protected FragmentPickAudioBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout clAudioIntro, ConstraintLayout constraintLayout16, ImageView ivBackButton,
      TextView textView3, TextView tvAudioTime) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clAudioIntro = clAudioIntro;
    this.constraintLayout16 = constraintLayout16;
    this.ivBackButton = ivBackButton;
    this.textView3 = textView3;
    this.tvAudioTime = tvAudioTime;
  }

  @NonNull
  public static FragmentPickAudioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_pick_audio, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPickAudioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentPickAudioBinding>inflateInternal(inflater, R.layout.fragment_pick_audio, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentPickAudioBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_pick_audio, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPickAudioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentPickAudioBinding>inflateInternal(inflater, R.layout.fragment_pick_audio, null, false, component);
  }

  public static FragmentPickAudioBinding bind(@NonNull View view) {
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
  public static FragmentPickAudioBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentPickAudioBinding)bind(component, view, R.layout.fragment_pick_audio);
  }
}