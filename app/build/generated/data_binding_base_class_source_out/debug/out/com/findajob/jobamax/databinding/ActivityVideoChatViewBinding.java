// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.dashboard.messages.ChatHandler;
import com.findajob.jobamax.dashboard.messages.ChatViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityVideoChatViewBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout activityVideoChatView;

  @NonNull
  public final ImageView ivToggleVideo;

  @NonNull
  public final FrameLayout localVideoViewContainer;

  @NonNull
  public final FrameLayout remoteVideoViewContainer;

  @NonNull
  public final TextView tvReceiverName;

  @Bindable
  protected ChatHandler mHandler;

  @Bindable
  protected String mProfilePictureUrl;

  @Bindable
  protected ChatViewModel mVm;

  protected ActivityVideoChatViewBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RelativeLayout activityVideoChatView, ImageView ivToggleVideo,
      FrameLayout localVideoViewContainer, FrameLayout remoteVideoViewContainer,
      TextView tvReceiverName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.activityVideoChatView = activityVideoChatView;
    this.ivToggleVideo = ivToggleVideo;
    this.localVideoViewContainer = localVideoViewContainer;
    this.remoteVideoViewContainer = remoteVideoViewContainer;
    this.tvReceiverName = tvReceiverName;
  }

  public abstract void setHandler(@Nullable ChatHandler handler);

  @Nullable
  public ChatHandler getHandler() {
    return mHandler;
  }

  public abstract void setProfilePictureUrl(@Nullable String profilePictureUrl);

  @Nullable
  public String getProfilePictureUrl() {
    return mProfilePictureUrl;
  }

  public abstract void setVm(@Nullable ChatViewModel vm);

  @Nullable
  public ChatViewModel getVm() {
    return mVm;
  }

  @NonNull
  public static ActivityVideoChatViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_video_chat_view, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityVideoChatViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityVideoChatViewBinding>inflateInternal(inflater, R.layout.activity_video_chat_view, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityVideoChatViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_video_chat_view, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityVideoChatViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityVideoChatViewBinding>inflateInternal(inflater, R.layout.activity_video_chat_view, null, false, component);
  }

  public static ActivityVideoChatViewBinding bind(@NonNull View view) {
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
  public static ActivityVideoChatViewBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityVideoChatViewBinding)bind(component, view, R.layout.activity_video_chat_view);
  }
}
