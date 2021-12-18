// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.dashboard.home.training.masterclass.model.MasterClass;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemMasterClassBinding extends ViewDataBinding {
  @NonNull
  public final CardView cdMasterClass;

  @Bindable
  protected MasterClass mItem;

  protected ItemMasterClassBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CardView cdMasterClass) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cdMasterClass = cdMasterClass;
  }

  public abstract void setItem(@Nullable MasterClass item);

  @Nullable
  public MasterClass getItem() {
    return mItem;
  }

  @NonNull
  public static ItemMasterClassBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_master_class, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemMasterClassBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemMasterClassBinding>inflateInternal(inflater, R.layout.item_master_class, root, attachToRoot, component);
  }

  @NonNull
  public static ItemMasterClassBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_master_class, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemMasterClassBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemMasterClassBinding>inflateInternal(inflater, R.layout.item_master_class, null, false, component);
  }

  public static ItemMasterClassBinding bind(@NonNull View view) {
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
  public static ItemMasterClassBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemMasterClassBinding)bind(component, view, R.layout.item_master_class);
  }
}
