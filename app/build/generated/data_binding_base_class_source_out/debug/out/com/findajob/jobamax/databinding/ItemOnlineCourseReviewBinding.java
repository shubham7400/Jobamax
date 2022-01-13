// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.dashboard.home.training.online.courses.model.review.Review;
import com.google.android.material.textview.MaterialTextView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemOnlineCourseReviewBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout itemHomeClBg;

  @NonNull
  public final CardView itemHomeCvBg;

  @NonNull
  public final TextView itemOnlineCourseRvNumber;

  @NonNull
  public final AppCompatRatingBar itemOnlineCoursesRvRating;

  @NonNull
  public final MaterialTextView itemOnlineCoursesTvTitle;

  @NonNull
  public final TextView onlineCourseReviewContent;

  @Bindable
  protected Review mItem;

  protected ItemOnlineCourseReviewBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout itemHomeClBg, CardView itemHomeCvBg,
      TextView itemOnlineCourseRvNumber, AppCompatRatingBar itemOnlineCoursesRvRating,
      MaterialTextView itemOnlineCoursesTvTitle, TextView onlineCourseReviewContent) {
    super(_bindingComponent, _root, _localFieldCount);
    this.itemHomeClBg = itemHomeClBg;
    this.itemHomeCvBg = itemHomeCvBg;
    this.itemOnlineCourseRvNumber = itemOnlineCourseRvNumber;
    this.itemOnlineCoursesRvRating = itemOnlineCoursesRvRating;
    this.itemOnlineCoursesTvTitle = itemOnlineCoursesTvTitle;
    this.onlineCourseReviewContent = onlineCourseReviewContent;
  }

  public abstract void setItem(@Nullable Review item);

  @Nullable
  public Review getItem() {
    return mItem;
  }

  @NonNull
  public static ItemOnlineCourseReviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_online_course_review, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemOnlineCourseReviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemOnlineCourseReviewBinding>inflateInternal(inflater, R.layout.item_online_course_review, root, attachToRoot, component);
  }

  @NonNull
  public static ItemOnlineCourseReviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_online_course_review, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemOnlineCourseReviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemOnlineCourseReviewBinding>inflateInternal(inflater, R.layout.item_online_course_review, null, false, component);
  }

  public static ItemOnlineCourseReviewBinding bind(@NonNull View view) {
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
  public static ItemOnlineCourseReviewBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemOnlineCourseReviewBinding)bind(component, view, R.layout.item_online_course_review);
  }
}