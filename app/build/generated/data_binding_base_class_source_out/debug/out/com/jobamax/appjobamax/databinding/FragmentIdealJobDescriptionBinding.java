// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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

public abstract class FragmentIdealJobDescriptionBinding extends ViewDataBinding {
  @NonNull
  public final CircleImageView civUser;

  @NonNull
  public final EditText etIdealJobDescription;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final TextView tvTextSize;

  @NonNull
  public final TextView tvTitle;

  @Bindable
  protected JobSeeker mJobSeeker;

  protected FragmentIdealJobDescriptionBinding(Object _bindingComponent, View _root,
      int _localFieldCount, CircleImageView civUser, EditText etIdealJobDescription,
      ImageView ivBackButton, RelativeLayout relativeLayout, TextView tvTextSize,
      TextView tvTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.civUser = civUser;
    this.etIdealJobDescription = etIdealJobDescription;
    this.ivBackButton = ivBackButton;
    this.relativeLayout = relativeLayout;
    this.tvTextSize = tvTextSize;
    this.tvTitle = tvTitle;
  }

  public abstract void setJobSeeker(@Nullable JobSeeker jobSeeker);

  @Nullable
  public JobSeeker getJobSeeker() {
    return mJobSeeker;
  }

  @NonNull
  public static FragmentIdealJobDescriptionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_ideal_job_description, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentIdealJobDescriptionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentIdealJobDescriptionBinding>inflateInternal(inflater, R.layout.fragment_ideal_job_description, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentIdealJobDescriptionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_ideal_job_description, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentIdealJobDescriptionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentIdealJobDescriptionBinding>inflateInternal(inflater, R.layout.fragment_ideal_job_description, null, false, component);
  }

  public static FragmentIdealJobDescriptionBinding bind(@NonNull View view) {
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
  public static FragmentIdealJobDescriptionBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentIdealJobDescriptionBinding)bind(component, view, R.layout.fragment_ideal_job_description);
  }
}
