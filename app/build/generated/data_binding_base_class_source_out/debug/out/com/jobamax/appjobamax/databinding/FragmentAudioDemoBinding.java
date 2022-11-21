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
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentAudioDemoBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton btnGo;

  @NonNull
  public final ConstraintLayout clAudioPlayer;

  @NonNull
  public final ConstraintLayout constraintLayout16;

  @NonNull
  public final ImageView ivAudioPlayBtn;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final LinearLayout llAudio;

  @NonNull
  public final LinearLayout llVideo;

  @NonNull
  public final SeekBar sbAudio;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView tvAudioDuration;

  @NonNull
  public final TextView tvAudioDurationProgress;

  protected FragmentAudioDemoBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatButton btnGo, ConstraintLayout clAudioPlayer, ConstraintLayout constraintLayout16,
      ImageView ivAudioPlayBtn, ImageView ivBackButton, LinearLayout llAudio, LinearLayout llVideo,
      SeekBar sbAudio, TextView textView3, TextView tvAudioDuration,
      TextView tvAudioDurationProgress) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnGo = btnGo;
    this.clAudioPlayer = clAudioPlayer;
    this.constraintLayout16 = constraintLayout16;
    this.ivAudioPlayBtn = ivAudioPlayBtn;
    this.ivBackButton = ivBackButton;
    this.llAudio = llAudio;
    this.llVideo = llVideo;
    this.sbAudio = sbAudio;
    this.textView3 = textView3;
    this.tvAudioDuration = tvAudioDuration;
    this.tvAudioDurationProgress = tvAudioDurationProgress;
  }

  @NonNull
  public static FragmentAudioDemoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_audio_demo, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentAudioDemoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentAudioDemoBinding>inflateInternal(inflater, R.layout.fragment_audio_demo, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentAudioDemoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_audio_demo, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentAudioDemoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentAudioDemoBinding>inflateInternal(inflater, R.layout.fragment_audio_demo, null, false, component);
  }

  public static FragmentAudioDemoBinding bind(@NonNull View view) {
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
  public static FragmentAudioDemoBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentAudioDemoBinding)bind(component, view, R.layout.fragment_audio_demo);
  }
}