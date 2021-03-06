// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.model.JobSeeker;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSeekerAddPersonalTrackJobBinding extends ViewDataBinding {
  @NonNull
  public final Button btnSaveInfo;

  @NonNull
  public final EditText etCity;

  @NonNull
  public final EditText etCompanyName;

  @NonNull
  public final EditText etJobTitle;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final CircleImageView ivUserProfile;

  @NonNull
  public final RelativeLayout relativeLayout;

  @Bindable
  protected JobSeeker mJobSeeker;

  protected FragmentSeekerAddPersonalTrackJobBinding(Object _bindingComponent, View _root,
      int _localFieldCount, Button btnSaveInfo, EditText etCity, EditText etCompanyName,
      EditText etJobTitle, ImageView ivBackButton, CircleImageView ivUserProfile,
      RelativeLayout relativeLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSaveInfo = btnSaveInfo;
    this.etCity = etCity;
    this.etCompanyName = etCompanyName;
    this.etJobTitle = etJobTitle;
    this.ivBackButton = ivBackButton;
    this.ivUserProfile = ivUserProfile;
    this.relativeLayout = relativeLayout;
  }

  public abstract void setJobSeeker(@Nullable JobSeeker jobSeeker);

  @Nullable
  public JobSeeker getJobSeeker() {
    return mJobSeeker;
  }

  @NonNull
  public static FragmentSeekerAddPersonalTrackJobBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_add_personal_track_job, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerAddPersonalTrackJobBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerAddPersonalTrackJobBinding>inflateInternal(inflater, R.layout.fragment_seeker_add_personal_track_job, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSeekerAddPersonalTrackJobBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_add_personal_track_job, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerAddPersonalTrackJobBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerAddPersonalTrackJobBinding>inflateInternal(inflater, R.layout.fragment_seeker_add_personal_track_job, null, false, component);
  }

  public static FragmentSeekerAddPersonalTrackJobBinding bind(@NonNull View view) {
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
  public static FragmentSeekerAddPersonalTrackJobBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentSeekerAddPersonalTrackJobBinding)bind(component, view, R.layout.fragment_seeker_add_personal_track_job);
  }
}
