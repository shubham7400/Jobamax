// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.model.JobSeeker;
import com.mobstac.circularimageprogress.CircularImageProgressView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentIdealJobAudioBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton btnRecord;

  @NonNull
  public final CircleImageView civUser;

  @NonNull
  public final ConstraintLayout clAudioPlayer;

  @NonNull
  public final ImageView ivAudioPlayBtn;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final ImageView ivRemoveAudio;

  @NonNull
  public final CircularImageProgressView pbAudioRecording;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final SeekBar sbAudio;

  @NonNull
  public final TextView tvAudioDuration;

  @NonNull
  public final TextView tvAudioDurationProgress;

  @NonNull
  public final TextView tvAudioTime;

  @NonNull
  public final TextView tvTitle;

  @Bindable
  protected JobSeeker mJobSeeker;

  protected FragmentIdealJobAudioBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatButton btnRecord, CircleImageView civUser, ConstraintLayout clAudioPlayer,
      ImageView ivAudioPlayBtn, ImageView ivBackButton, ImageView ivRemoveAudio,
      CircularImageProgressView pbAudioRecording, RelativeLayout relativeLayout, SeekBar sbAudio,
      TextView tvAudioDuration, TextView tvAudioDurationProgress, TextView tvAudioTime,
      TextView tvTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnRecord = btnRecord;
    this.civUser = civUser;
    this.clAudioPlayer = clAudioPlayer;
    this.ivAudioPlayBtn = ivAudioPlayBtn;
    this.ivBackButton = ivBackButton;
    this.ivRemoveAudio = ivRemoveAudio;
    this.pbAudioRecording = pbAudioRecording;
    this.relativeLayout = relativeLayout;
    this.sbAudio = sbAudio;
    this.tvAudioDuration = tvAudioDuration;
    this.tvAudioDurationProgress = tvAudioDurationProgress;
    this.tvAudioTime = tvAudioTime;
    this.tvTitle = tvTitle;
  }

  public abstract void setJobSeeker(@Nullable JobSeeker jobSeeker);

  @Nullable
  public JobSeeker getJobSeeker() {
    return mJobSeeker;
  }

  @NonNull
  public static FragmentIdealJobAudioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_ideal_job_audio, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentIdealJobAudioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentIdealJobAudioBinding>inflateInternal(inflater, R.layout.fragment_ideal_job_audio, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentIdealJobAudioBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_ideal_job_audio, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentIdealJobAudioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentIdealJobAudioBinding>inflateInternal(inflater, R.layout.fragment_ideal_job_audio, null, false, component);
  }

  public static FragmentIdealJobAudioBinding bind(@NonNull View view) {
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
  public static FragmentIdealJobAudioBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentIdealJobAudioBinding)bind(component, view, R.layout.fragment_ideal_job_audio);
  }
}