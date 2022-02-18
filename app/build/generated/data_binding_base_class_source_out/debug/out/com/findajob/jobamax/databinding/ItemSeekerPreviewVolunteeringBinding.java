// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemSeekerPreviewVolunteeringBinding extends ViewDataBinding {
  @NonNull
  public final CardView cvImage;

  @NonNull
  public final ImageView ivCompany;

  @NonNull
  public final TextView tvCompanyName;

  @NonNull
  public final TextView tvDateDuration;

  @NonNull
  public final TextView tvJob;

  protected ItemSeekerPreviewVolunteeringBinding(Object _bindingComponent, View _root,
      int _localFieldCount, CardView cvImage, ImageView ivCompany, TextView tvCompanyName,
      TextView tvDateDuration, TextView tvJob) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cvImage = cvImage;
    this.ivCompany = ivCompany;
    this.tvCompanyName = tvCompanyName;
    this.tvDateDuration = tvDateDuration;
    this.tvJob = tvJob;
  }

  @NonNull
  public static ItemSeekerPreviewVolunteeringBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_seeker_preview_volunteering, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemSeekerPreviewVolunteeringBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemSeekerPreviewVolunteeringBinding>inflateInternal(inflater, R.layout.item_seeker_preview_volunteering, root, attachToRoot, component);
  }

  @NonNull
  public static ItemSeekerPreviewVolunteeringBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_seeker_preview_volunteering, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemSeekerPreviewVolunteeringBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemSeekerPreviewVolunteeringBinding>inflateInternal(inflater, R.layout.item_seeker_preview_volunteering, null, false, component);
  }

  public static ItemSeekerPreviewVolunteeringBinding bind(@NonNull View view) {
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
  public static ItemSeekerPreviewVolunteeringBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ItemSeekerPreviewVolunteeringBinding)bind(component, view, R.layout.item_seeker_preview_volunteering);
  }
}
