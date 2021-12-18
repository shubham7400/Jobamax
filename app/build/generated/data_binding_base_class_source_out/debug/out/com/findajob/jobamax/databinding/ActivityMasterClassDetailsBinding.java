// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.findajob.jobamax.R;
import com.findajob.jobamax.dashboard.home.training.masterclass.MasterClassDetailsInterface;
import com.findajob.jobamax.data.pojo.VideoDetails;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityMasterClassDetailsBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout appbar;

  @NonNull
  public final RecyclerView rvVideos;

  @NonNull
  public final AppCompatImageView video;

  @Bindable
  protected VideoDetails mItem;

  @Bindable
  protected MasterClassDetailsInterface mHandler;

  protected ActivityMasterClassDetailsBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout appbar, RecyclerView rvVideos,
      AppCompatImageView video) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appbar = appbar;
    this.rvVideos = rvVideos;
    this.video = video;
  }

  public abstract void setItem(@Nullable VideoDetails item);

  @Nullable
  public VideoDetails getItem() {
    return mItem;
  }

  public abstract void setHandler(@Nullable MasterClassDetailsInterface handler);

  @Nullable
  public MasterClassDetailsInterface getHandler() {
    return mHandler;
  }

  @NonNull
  public static ActivityMasterClassDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_master_class_details, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMasterClassDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMasterClassDetailsBinding>inflateInternal(inflater, R.layout.activity_master_class_details, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMasterClassDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_master_class_details, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMasterClassDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMasterClassDetailsBinding>inflateInternal(inflater, R.layout.activity_master_class_details, null, false, component);
  }

  public static ActivityMasterClassDetailsBinding bind(@NonNull View view) {
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
  public static ActivityMasterClassDetailsBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityMasterClassDetailsBinding)bind(component, view, R.layout.activity_master_class_details);
  }
}
