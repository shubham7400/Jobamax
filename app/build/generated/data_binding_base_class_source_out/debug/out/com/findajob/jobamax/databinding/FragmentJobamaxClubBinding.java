// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import com.google.android.material.textview.MaterialTextView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentJobamaxClubBinding extends ViewDataBinding {
  @NonNull
  public final MaterialTextView homeTvHeader;

  @NonNull
  public final AppCompatImageView imageBg;

  @NonNull
  public final MaterialTextView itemCompanyIvCourseName;

  @NonNull
  public final ConstraintLayout itemHomeClBg;

  @NonNull
  public final AppCompatImageView itemImage;

  @NonNull
  public final CardView itemMasterClass;

  @NonNull
  public final ConstraintLayout itemNetworking;

  @NonNull
  public final CardView itemOnlineCourses;

  protected FragmentJobamaxClubBinding(Object _bindingComponent, View _root, int _localFieldCount,
      MaterialTextView homeTvHeader, AppCompatImageView imageBg,
      MaterialTextView itemCompanyIvCourseName, ConstraintLayout itemHomeClBg,
      AppCompatImageView itemImage, CardView itemMasterClass, ConstraintLayout itemNetworking,
      CardView itemOnlineCourses) {
    super(_bindingComponent, _root, _localFieldCount);
    this.homeTvHeader = homeTvHeader;
    this.imageBg = imageBg;
    this.itemCompanyIvCourseName = itemCompanyIvCourseName;
    this.itemHomeClBg = itemHomeClBg;
    this.itemImage = itemImage;
    this.itemMasterClass = itemMasterClass;
    this.itemNetworking = itemNetworking;
    this.itemOnlineCourses = itemOnlineCourses;
  }

  @NonNull
  public static FragmentJobamaxClubBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_jobamax_club, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentJobamaxClubBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentJobamaxClubBinding>inflateInternal(inflater, R.layout.fragment_jobamax_club, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentJobamaxClubBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_jobamax_club, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentJobamaxClubBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentJobamaxClubBinding>inflateInternal(inflater, R.layout.fragment_jobamax_club, null, false, component);
  }

  public static FragmentJobamaxClubBinding bind(@NonNull View view) {
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
  public static FragmentJobamaxClubBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentJobamaxClubBinding)bind(component, view, R.layout.fragment_jobamax_club);
  }
}