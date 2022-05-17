// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.model.JobSeeker;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSeekerEducationBinding extends ViewDataBinding {
  @NonNull
  public final Button btnAddEducation;

  @NonNull
  public final Button btnGoToProfile;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final CircleImageView ivUserProfile;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final RecyclerView rvEducationList;

  @Bindable
  protected JobSeeker mJobSeeker;

  protected FragmentSeekerEducationBinding(Object _bindingComponent, View _root,
      int _localFieldCount, Button btnAddEducation, Button btnGoToProfile, ImageView ivBackButton,
      CircleImageView ivUserProfile, RelativeLayout relativeLayout, RecyclerView rvEducationList) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnAddEducation = btnAddEducation;
    this.btnGoToProfile = btnGoToProfile;
    this.ivBackButton = ivBackButton;
    this.ivUserProfile = ivUserProfile;
    this.relativeLayout = relativeLayout;
    this.rvEducationList = rvEducationList;
  }

  public abstract void setJobSeeker(@Nullable JobSeeker jobSeeker);

  @Nullable
  public JobSeeker getJobSeeker() {
    return mJobSeeker;
  }

  @NonNull
  public static FragmentSeekerEducationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_education, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerEducationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerEducationBinding>inflateInternal(inflater, R.layout.fragment_seeker_education, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSeekerEducationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_education, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerEducationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerEducationBinding>inflateInternal(inflater, R.layout.fragment_seeker_education, null, false, component);
  }

  public static FragmentSeekerEducationBinding bind(@NonNull View view) {
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
  public static FragmentSeekerEducationBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentSeekerEducationBinding)bind(component, view, R.layout.fragment_seeker_education);
  }
}
