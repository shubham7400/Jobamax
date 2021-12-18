// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.findajob.jobamax.R;
import com.findajob.jobamax.jobseeker.profile.JobSeekerProfileInterface;
import com.google.android.material.tabs.TabLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentJobSeekerProfileBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout headerLayout;

  @NonNull
  public final AppCompatImageView profilePicIcon;

  @NonNull
  public final TabLayout tl;

  @NonNull
  public final TextView userNameLabel;

  @NonNull
  public final ViewPager2 vp;

  @Bindable
  protected JobSeekerProfileInterface mHandler;

  protected FragmentJobSeekerProfileBinding(Object _bindingComponent, View _root,
      int _localFieldCount, LinearLayout headerLayout, AppCompatImageView profilePicIcon,
      TabLayout tl, TextView userNameLabel, ViewPager2 vp) {
    super(_bindingComponent, _root, _localFieldCount);
    this.headerLayout = headerLayout;
    this.profilePicIcon = profilePicIcon;
    this.tl = tl;
    this.userNameLabel = userNameLabel;
    this.vp = vp;
  }

  public abstract void setHandler(@Nullable JobSeekerProfileInterface handler);

  @Nullable
  public JobSeekerProfileInterface getHandler() {
    return mHandler;
  }

  @NonNull
  public static FragmentJobSeekerProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_job_seeker_profile, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentJobSeekerProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentJobSeekerProfileBinding>inflateInternal(inflater, R.layout.fragment_job_seeker_profile, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentJobSeekerProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_job_seeker_profile, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentJobSeekerProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentJobSeekerProfileBinding>inflateInternal(inflater, R.layout.fragment_job_seeker_profile, null, false, component);
  }

  public static FragmentJobSeekerProfileBinding bind(@NonNull View view) {
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
  public static FragmentJobSeekerProfileBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentJobSeekerProfileBinding)bind(component, view, R.layout.fragment_job_seeker_profile);
  }
}
