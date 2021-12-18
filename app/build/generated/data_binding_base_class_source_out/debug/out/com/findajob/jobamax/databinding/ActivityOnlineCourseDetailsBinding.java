// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.util.NonSwipeableViewPager;
import com.findajob.jobamax.util.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityOnlineCourseDetailsBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout appbar;

  @NonNull
  public final AppCompatImageView backBtn;

  @NonNull
  public final CoordinatorLayout coordinate;

  @NonNull
  public final AppCompatButton enrollForTv;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final View innerLine;

  @NonNull
  public final TextView itemOnlineCoursesNumberofRating;

  @NonNull
  public final AppCompatRatingBar itemOnlineCoursesRvRating;

  @NonNull
  public final TextView itemOnlineCoursesTvPercentage;

  @NonNull
  public final TextView itemOnlineCoursesTvRating;

  @NonNull
  public final AppCompatImageView ivBackground;

  @NonNull
  public final AppCompatImageView ivBanner;

  @NonNull
  public final TabLayout onlineCourseCtl;

  @NonNull
  public final AppCompatImageView onlineCourseInstructorProfileImage;

  @NonNull
  public final TextView onlineCourseInstructorProfileName;

  @NonNull
  public final AppCompatTextView onlineCourseTitle;

  @NonNull
  public final NonSwipeableViewPager vpa;

  @Bindable
  protected ViewPagerAdapter mViewPagerAdapter;

  protected ActivityOnlineCourseDetailsBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ConstraintLayout appbar, AppCompatImageView backBtn,
      CoordinatorLayout coordinate, AppCompatButton enrollForTv, ImageView imageView,
      View innerLine, TextView itemOnlineCoursesNumberofRating,
      AppCompatRatingBar itemOnlineCoursesRvRating, TextView itemOnlineCoursesTvPercentage,
      TextView itemOnlineCoursesTvRating, AppCompatImageView ivBackground,
      AppCompatImageView ivBanner, TabLayout onlineCourseCtl,
      AppCompatImageView onlineCourseInstructorProfileImage,
      TextView onlineCourseInstructorProfileName, AppCompatTextView onlineCourseTitle,
      NonSwipeableViewPager vpa) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appbar = appbar;
    this.backBtn = backBtn;
    this.coordinate = coordinate;
    this.enrollForTv = enrollForTv;
    this.imageView = imageView;
    this.innerLine = innerLine;
    this.itemOnlineCoursesNumberofRating = itemOnlineCoursesNumberofRating;
    this.itemOnlineCoursesRvRating = itemOnlineCoursesRvRating;
    this.itemOnlineCoursesTvPercentage = itemOnlineCoursesTvPercentage;
    this.itemOnlineCoursesTvRating = itemOnlineCoursesTvRating;
    this.ivBackground = ivBackground;
    this.ivBanner = ivBanner;
    this.onlineCourseCtl = onlineCourseCtl;
    this.onlineCourseInstructorProfileImage = onlineCourseInstructorProfileImage;
    this.onlineCourseInstructorProfileName = onlineCourseInstructorProfileName;
    this.onlineCourseTitle = onlineCourseTitle;
    this.vpa = vpa;
  }

  public abstract void setViewPagerAdapter(@Nullable ViewPagerAdapter viewPagerAdapter);

  @Nullable
  public ViewPagerAdapter getViewPagerAdapter() {
    return mViewPagerAdapter;
  }

  @NonNull
  public static ActivityOnlineCourseDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_online_course_details, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityOnlineCourseDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityOnlineCourseDetailsBinding>inflateInternal(inflater, R.layout.activity_online_course_details, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityOnlineCourseDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_online_course_details, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityOnlineCourseDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityOnlineCourseDetailsBinding>inflateInternal(inflater, R.layout.activity_online_course_details, null, false, component);
  }

  public static ActivityOnlineCourseDetailsBinding bind(@NonNull View view) {
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
  public static ActivityOnlineCourseDetailsBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityOnlineCourseDetailsBinding)bind(component, view, R.layout.activity_online_course_details);
  }
}
