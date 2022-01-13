// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.dashboard.home.training.masterclass.model.Guest;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemMasterClassSessionGuestBinding extends ViewDataBinding {
  @NonNull
  public final CircleImageView circleImageView;

  @NonNull
  public final ConstraintLayout clGuest;

  @NonNull
  public final TextView tvGuestName;

  @Bindable
  protected Guest mItem;

  protected ItemMasterClassSessionGuestBinding(Object _bindingComponent, View _root,
      int _localFieldCount, CircleImageView circleImageView, ConstraintLayout clGuest,
      TextView tvGuestName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.circleImageView = circleImageView;
    this.clGuest = clGuest;
    this.tvGuestName = tvGuestName;
  }

  public abstract void setItem(@Nullable Guest item);

  @Nullable
  public Guest getItem() {
    return mItem;
  }

  @NonNull
  public static ItemMasterClassSessionGuestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_master_class_session_guest, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemMasterClassSessionGuestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemMasterClassSessionGuestBinding>inflateInternal(inflater, R.layout.item_master_class_session_guest, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMasterClassSessionGuestBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_master_class_session_guest, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemMasterClassSessionGuestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemMasterClassSessionGuestBinding>inflateInternal(inflater, R.layout.item_master_class_session_guest, null, false, component);
  }

  public static ItemMasterClassSessionGuestBinding bind(@NonNull View view) {
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
  public static ItemMasterClassSessionGuestBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ItemMasterClassSessionGuestBinding)bind(component, view, R.layout.item_master_class_session_guest);
  }
}