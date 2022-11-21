// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.chip.ChipGroup;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemJobCriteriaCategoryBinding extends ViewDataBinding {
  @NonNull
  public final ChipGroup cgCategoryTags;

  @NonNull
  public final ConstraintLayout clCategory;

  @NonNull
  public final CardView cvSelectedCategoryTagHint;

  @NonNull
  public final ImageView ivArrow;

  @NonNull
  public final TextView tvCategoryTitle;

  protected ItemJobCriteriaCategoryBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ChipGroup cgCategoryTags, ConstraintLayout clCategory,
      CardView cvSelectedCategoryTagHint, ImageView ivArrow, TextView tvCategoryTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cgCategoryTags = cgCategoryTags;
    this.clCategory = clCategory;
    this.cvSelectedCategoryTagHint = cvSelectedCategoryTagHint;
    this.ivArrow = ivArrow;
    this.tvCategoryTitle = tvCategoryTitle;
  }

  @NonNull
  public static ItemJobCriteriaCategoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_job_criteria_category, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemJobCriteriaCategoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemJobCriteriaCategoryBinding>inflateInternal(inflater, R.layout.item_job_criteria_category, root, attachToRoot, component);
  }

  @NonNull
  public static ItemJobCriteriaCategoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_job_criteria_category, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemJobCriteriaCategoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemJobCriteriaCategoryBinding>inflateInternal(inflater, R.layout.item_job_criteria_category, null, false, component);
  }

  public static ItemJobCriteriaCategoryBinding bind(@NonNull View view) {
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
  public static ItemJobCriteriaCategoryBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ItemJobCriteriaCategoryBinding)bind(component, view, R.layout.item_job_criteria_category);
  }
}