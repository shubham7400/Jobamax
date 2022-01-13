// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.data.pojo.CurrentOnline;
import com.google.android.material.textview.MaterialTextView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemChatBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatImageView itemCurrentOnlineIvAvatar;

  @NonNull
  public final MaterialTextView itemCurrentOnlineIvName;

  @Bindable
  protected CurrentOnline mItem;

  protected ItemChatBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatImageView itemCurrentOnlineIvAvatar, MaterialTextView itemCurrentOnlineIvName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.itemCurrentOnlineIvAvatar = itemCurrentOnlineIvAvatar;
    this.itemCurrentOnlineIvName = itemCurrentOnlineIvName;
  }

  public abstract void setItem(@Nullable CurrentOnline item);

  @Nullable
  public CurrentOnline getItem() {
    return mItem;
  }

  @NonNull
  public static ItemChatBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_chat, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemChatBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemChatBinding>inflateInternal(inflater, R.layout.item_chat, root, attachToRoot, component);
  }

  @NonNull
  public static ItemChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_chat, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemChatBinding>inflateInternal(inflater, R.layout.item_chat, null, false, component);
  }

  public static ItemChatBinding bind(@NonNull View view) {
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
  public static ItemChatBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemChatBinding)bind(component, view, R.layout.item_chat);
  }
}