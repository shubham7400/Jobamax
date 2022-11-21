// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.google.android.material.chip.ChipGroup;
import com.jobamax.appjobamax.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentPersonalizeFilterBinding extends ViewDataBinding {
  @NonNull
  public final FragmentContainerView autocompleteFragment;

  @NonNull
  public final AppCompatButton btnModifyCv;

  @NonNull
  public final AppCompatButton btnSave;

  @NonNull
  public final ChipGroup cgContractType;

  @NonNull
  public final ChipGroup cgWorkExperience;

  @NonNull
  public final CircleImageView circleImageView;

  @NonNull
  public final ConstraintLayout clCircleImage;

  @NonNull
  public final ConstraintLayout clExperience;

  @NonNull
  public final ConstraintLayout clWorkType;

  @NonNull
  public final ImageView ivArrowExp;

  @NonNull
  public final ImageView ivArrowWork;

  @NonNull
  public final TextView tvJobLocation;

  protected FragmentPersonalizeFilterBinding(Object _bindingComponent, View _root,
      int _localFieldCount, FragmentContainerView autocompleteFragment, AppCompatButton btnModifyCv,
      AppCompatButton btnSave, ChipGroup cgContractType, ChipGroup cgWorkExperience,
      CircleImageView circleImageView, ConstraintLayout clCircleImage,
      ConstraintLayout clExperience, ConstraintLayout clWorkType, ImageView ivArrowExp,
      ImageView ivArrowWork, TextView tvJobLocation) {
    super(_bindingComponent, _root, _localFieldCount);
    this.autocompleteFragment = autocompleteFragment;
    this.btnModifyCv = btnModifyCv;
    this.btnSave = btnSave;
    this.cgContractType = cgContractType;
    this.cgWorkExperience = cgWorkExperience;
    this.circleImageView = circleImageView;
    this.clCircleImage = clCircleImage;
    this.clExperience = clExperience;
    this.clWorkType = clWorkType;
    this.ivArrowExp = ivArrowExp;
    this.ivArrowWork = ivArrowWork;
    this.tvJobLocation = tvJobLocation;
  }

  @NonNull
  public static FragmentPersonalizeFilterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_personalize_filter, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPersonalizeFilterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentPersonalizeFilterBinding>inflateInternal(inflater, R.layout.fragment_personalize_filter, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentPersonalizeFilterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_personalize_filter, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPersonalizeFilterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentPersonalizeFilterBinding>inflateInternal(inflater, R.layout.fragment_personalize_filter, null, false, component);
  }

  public static FragmentPersonalizeFilterBinding bind(@NonNull View view) {
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
  public static FragmentPersonalizeFilterBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentPersonalizeFilterBinding)bind(component, view, R.layout.fragment_personalize_filter);
  }
}