// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.model.JobSeeker;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentIdealJobVideoBinding extends ViewDataBinding {
  @NonNull
  public final CircleImageView civUser;

  @NonNull
  public final ImageView ivAddVideo;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final CardView ivImage;

  @NonNull
  public final ImageView ivRemoveVideo;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final ImageView roundedImageView;

  @NonNull
  public final ConstraintLayout rvVideo;

  @NonNull
  public final TextView textView259;

  @Bindable
  protected JobSeeker mJobSeeker;

  protected FragmentIdealJobVideoBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CircleImageView civUser, ImageView ivAddVideo, ImageView ivBackButton, CardView ivImage,
      ImageView ivRemoveVideo, RelativeLayout relativeLayout, ImageView roundedImageView,
      ConstraintLayout rvVideo, TextView textView259) {
    super(_bindingComponent, _root, _localFieldCount);
    this.civUser = civUser;
    this.ivAddVideo = ivAddVideo;
    this.ivBackButton = ivBackButton;
    this.ivImage = ivImage;
    this.ivRemoveVideo = ivRemoveVideo;
    this.relativeLayout = relativeLayout;
    this.roundedImageView = roundedImageView;
    this.rvVideo = rvVideo;
    this.textView259 = textView259;
  }

  public abstract void setJobSeeker(@Nullable JobSeeker jobSeeker);

  @Nullable
  public JobSeeker getJobSeeker() {
    return mJobSeeker;
  }

  @NonNull
  public static FragmentIdealJobVideoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_ideal_job_video, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentIdealJobVideoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentIdealJobVideoBinding>inflateInternal(inflater, R.layout.fragment_ideal_job_video, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentIdealJobVideoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_ideal_job_video, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentIdealJobVideoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentIdealJobVideoBinding>inflateInternal(inflater, R.layout.fragment_ideal_job_video, null, false, component);
  }

  public static FragmentIdealJobVideoBinding bind(@NonNull View view) {
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
  public static FragmentIdealJobVideoBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentIdealJobVideoBinding)bind(component, view, R.layout.fragment_ideal_job_video);
  }
}
