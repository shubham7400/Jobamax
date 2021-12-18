// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.findajob.jobamax.R;
import com.findajob.jobamax.training.ui.EventCalendarHandler;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentEventCalendarBinding extends ViewDataBinding {
  @NonNull
  public final CalendarView cvCalendar;

  @NonNull
  public final ImageView ivAddButton;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final ConstraintLayout llCustomToolbar;

  @NonNull
  public final NestedScrollView nsvScroller;

  @NonNull
  public final RecyclerView rvTodayEvents;

  @NonNull
  public final RecyclerView rvUpcomingEvents;

  @NonNull
  public final TextView tvTodayEventsLabel;

  @NonNull
  public final TextView tvUpcomingEventsLabel;

  @Bindable
  protected EventCalendarHandler mHandler;

  protected FragmentEventCalendarBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CalendarView cvCalendar, ImageView ivAddButton, ImageView ivBackButton,
      ConstraintLayout llCustomToolbar, NestedScrollView nsvScroller, RecyclerView rvTodayEvents,
      RecyclerView rvUpcomingEvents, TextView tvTodayEventsLabel, TextView tvUpcomingEventsLabel) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cvCalendar = cvCalendar;
    this.ivAddButton = ivAddButton;
    this.ivBackButton = ivBackButton;
    this.llCustomToolbar = llCustomToolbar;
    this.nsvScroller = nsvScroller;
    this.rvTodayEvents = rvTodayEvents;
    this.rvUpcomingEvents = rvUpcomingEvents;
    this.tvTodayEventsLabel = tvTodayEventsLabel;
    this.tvUpcomingEventsLabel = tvUpcomingEventsLabel;
  }

  public abstract void setHandler(@Nullable EventCalendarHandler handler);

  @Nullable
  public EventCalendarHandler getHandler() {
    return mHandler;
  }

  @NonNull
  public static FragmentEventCalendarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_event_calendar, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentEventCalendarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentEventCalendarBinding>inflateInternal(inflater, R.layout.fragment_event_calendar, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentEventCalendarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_event_calendar, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentEventCalendarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentEventCalendarBinding>inflateInternal(inflater, R.layout.fragment_event_calendar, null, false, component);
  }

  public static FragmentEventCalendarBinding bind(@NonNull View view) {
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
  public static FragmentEventCalendarBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentEventCalendarBinding)bind(component, view, R.layout.fragment_event_calendar);
  }
}
