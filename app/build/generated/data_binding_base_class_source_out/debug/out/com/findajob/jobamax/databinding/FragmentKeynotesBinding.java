// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.findajob.jobamax.R;
import com.google.android.material.textview.MaterialTextView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentKeynotesBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatImageView keynotesIvBg;

  @NonNull
  public final RecyclerView keynotesRvMyList;

  @NonNull
  public final RecyclerView keynotesRvPastEvents;

  @NonNull
  public final RecyclerView keynotesRvUpcomingEvents;

  @NonNull
  public final MaterialTextView keynotesTvHeader;

  @NonNull
  public final MaterialTextView myListTvPastEvents;

  @NonNull
  public final MaterialTextView myListTvUpcomingEvents;

  protected FragmentKeynotesBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatImageView keynotesIvBg, RecyclerView keynotesRvMyList,
      RecyclerView keynotesRvPastEvents, RecyclerView keynotesRvUpcomingEvents,
      MaterialTextView keynotesTvHeader, MaterialTextView myListTvPastEvents,
      MaterialTextView myListTvUpcomingEvents) {
    super(_bindingComponent, _root, _localFieldCount);
    this.keynotesIvBg = keynotesIvBg;
    this.keynotesRvMyList = keynotesRvMyList;
    this.keynotesRvPastEvents = keynotesRvPastEvents;
    this.keynotesRvUpcomingEvents = keynotesRvUpcomingEvents;
    this.keynotesTvHeader = keynotesTvHeader;
    this.myListTvPastEvents = myListTvPastEvents;
    this.myListTvUpcomingEvents = myListTvUpcomingEvents;
  }

  @NonNull
  public static FragmentKeynotesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_keynotes, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentKeynotesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentKeynotesBinding>inflateInternal(inflater, R.layout.fragment_keynotes, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentKeynotesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_keynotes, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentKeynotesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentKeynotesBinding>inflateInternal(inflater, R.layout.fragment_keynotes, null, false, component);
  }

  public static FragmentKeynotesBinding bind(@NonNull View view) {
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
  public static FragmentKeynotesBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentKeynotesBinding)bind(component, view, R.layout.fragment_keynotes);
  }
}