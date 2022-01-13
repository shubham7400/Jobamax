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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.dashboard.home.training.online.courses.model.VisibleInstructor;
import com.google.android.material.textview.MaterialTextView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemOnlineCourseInstructorBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageView5;

  @NonNull
  public final ConstraintLayout itemHomeClBg;

  @NonNull
  public final CardView itemInstructorCvBg;

  @NonNull
  public final TextView onlineCourseInstructorJobTitle;

  @NonNull
  public final MaterialTextView onlineCoursesInstructorName;

  @Bindable
  protected VisibleInstructor mItem;

  protected ItemOnlineCourseInstructorBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView imageView5, ConstraintLayout itemHomeClBg,
      CardView itemInstructorCvBg, TextView onlineCourseInstructorJobTitle,
      MaterialTextView onlineCoursesInstructorName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageView5 = imageView5;
    this.itemHomeClBg = itemHomeClBg;
    this.itemInstructorCvBg = itemInstructorCvBg;
    this.onlineCourseInstructorJobTitle = onlineCourseInstructorJobTitle;
    this.onlineCoursesInstructorName = onlineCoursesInstructorName;
  }

  public abstract void setItem(@Nullable VisibleInstructor item);

  @Nullable
  public VisibleInstructor getItem() {
    return mItem;
  }

  @NonNull
  public static ItemOnlineCourseInstructorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_online_course_instructor, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemOnlineCourseInstructorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemOnlineCourseInstructorBinding>inflateInternal(inflater, R.layout.item_online_course_instructor, root, attachToRoot, component);
  }

  @NonNull
  public static ItemOnlineCourseInstructorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_online_course_instructor, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemOnlineCourseInstructorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemOnlineCourseInstructorBinding>inflateInternal(inflater, R.layout.item_online_course_instructor, null, false, component);
  }

  public static ItemOnlineCourseInstructorBinding bind(@NonNull View view) {
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
  public static ItemOnlineCourseInstructorBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ItemOnlineCourseInstructorBinding)bind(component, view, R.layout.item_online_course_instructor);
  }
}