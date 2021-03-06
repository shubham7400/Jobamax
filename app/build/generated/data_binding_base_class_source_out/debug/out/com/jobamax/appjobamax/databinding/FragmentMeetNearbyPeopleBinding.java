// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.login.MeetPeopleNearbyInterface;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentMeetNearbyPeopleBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageView7;

  @NonNull
  public final ConstraintLayout linearLayout3;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @Bindable
  protected MeetPeopleNearbyInterface mHandler;

  protected FragmentMeetNearbyPeopleBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView imageView7, ConstraintLayout linearLayout3,
      TextView textView3, TextView textView4) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageView7 = imageView7;
    this.linearLayout3 = linearLayout3;
    this.textView3 = textView3;
    this.textView4 = textView4;
  }

  public abstract void setHandler(@Nullable MeetPeopleNearbyInterface handler);

  @Nullable
  public MeetPeopleNearbyInterface getHandler() {
    return mHandler;
  }

  @NonNull
  public static FragmentMeetNearbyPeopleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_meet_nearby_people, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMeetNearbyPeopleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentMeetNearbyPeopleBinding>inflateInternal(inflater, R.layout.fragment_meet_nearby_people, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMeetNearbyPeopleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_meet_nearby_people, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMeetNearbyPeopleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentMeetNearbyPeopleBinding>inflateInternal(inflater, R.layout.fragment_meet_nearby_people, null, false, component);
  }

  public static FragmentMeetNearbyPeopleBinding bind(@NonNull View view) {
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
  public static FragmentMeetNearbyPeopleBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentMeetNearbyPeopleBinding)bind(component, view, R.layout.fragment_meet_nearby_people);
  }
}
