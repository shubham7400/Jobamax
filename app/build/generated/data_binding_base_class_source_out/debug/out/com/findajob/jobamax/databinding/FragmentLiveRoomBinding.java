// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

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
import androidx.recyclerview.widget.RecyclerView;
import com.findajob.jobamax.R;
import com.findajob.jobamax.training.ui.LiveRoomInterface;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentLiveRoomBinding extends ViewDataBinding {
  @NonNull
  public final ImageView bottomActionEndCall;

  @NonNull
  public final ImageView joinRoom;

  @NonNull
  public final ConstraintLayout llCustomToolbar;

  @NonNull
  public final ImageView muteLocalSpeakerId;

  @NonNull
  public final ImageView raiseHand;

  @NonNull
  public final TextView roomName;

  @NonNull
  public final RecyclerView rvLocationList;

  @NonNull
  public final TextView title;

  @Bindable
  protected LiveRoomInterface mHandler;

  protected FragmentLiveRoomBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView bottomActionEndCall, ImageView joinRoom, ConstraintLayout llCustomToolbar,
      ImageView muteLocalSpeakerId, ImageView raiseHand, TextView roomName,
      RecyclerView rvLocationList, TextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomActionEndCall = bottomActionEndCall;
    this.joinRoom = joinRoom;
    this.llCustomToolbar = llCustomToolbar;
    this.muteLocalSpeakerId = muteLocalSpeakerId;
    this.raiseHand = raiseHand;
    this.roomName = roomName;
    this.rvLocationList = rvLocationList;
    this.title = title;
  }

  public abstract void setHandler(@Nullable LiveRoomInterface handler);

  @Nullable
  public LiveRoomInterface getHandler() {
    return mHandler;
  }

  @NonNull
  public static FragmentLiveRoomBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_live_room, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentLiveRoomBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentLiveRoomBinding>inflateInternal(inflater, R.layout.fragment_live_room, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentLiveRoomBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_live_room, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentLiveRoomBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentLiveRoomBinding>inflateInternal(inflater, R.layout.fragment_live_room, null, false, component);
  }

  public static FragmentLiveRoomBinding bind(@NonNull View view) {
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
  public static FragmentLiveRoomBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentLiveRoomBinding)bind(component, view, R.layout.fragment_live_room);
  }
}