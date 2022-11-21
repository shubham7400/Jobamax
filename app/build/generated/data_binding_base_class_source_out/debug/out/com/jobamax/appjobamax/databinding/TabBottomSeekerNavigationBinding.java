// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class TabBottomSeekerNavigationBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivChat;

  @NonNull
  public final ImageView ivFavorite;

  @NonNull
  public final ImageView ivHome;

  @NonNull
  public final CircleImageView ivProfile;

  @NonNull
  public final LinearLayout llChat;

  @NonNull
  public final LinearLayout llFavorite;

  @NonNull
  public final LinearLayout llHome;

  @NonNull
  public final LinearLayout llProfile;

  protected TabBottomSeekerNavigationBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView ivChat, ImageView ivFavorite, ImageView ivHome,
      CircleImageView ivProfile, LinearLayout llChat, LinearLayout llFavorite, LinearLayout llHome,
      LinearLayout llProfile) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivChat = ivChat;
    this.ivFavorite = ivFavorite;
    this.ivHome = ivHome;
    this.ivProfile = ivProfile;
    this.llChat = llChat;
    this.llFavorite = llFavorite;
    this.llHome = llHome;
    this.llProfile = llProfile;
  }

  @NonNull
  public static TabBottomSeekerNavigationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.tab_bottom_seeker_navigation, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static TabBottomSeekerNavigationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<TabBottomSeekerNavigationBinding>inflateInternal(inflater, R.layout.tab_bottom_seeker_navigation, root, attachToRoot, component);
  }

  @NonNull
  public static TabBottomSeekerNavigationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.tab_bottom_seeker_navigation, null, false, component)
   */
  @NonNull
  @Deprecated
  public static TabBottomSeekerNavigationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<TabBottomSeekerNavigationBinding>inflateInternal(inflater, R.layout.tab_bottom_seeker_navigation, null, false, component);
  }

  public static TabBottomSeekerNavigationBinding bind(@NonNull View view) {
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
  public static TabBottomSeekerNavigationBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (TabBottomSeekerNavigationBinding)bind(component, view, R.layout.tab_bottom_seeker_navigation);
  }
}