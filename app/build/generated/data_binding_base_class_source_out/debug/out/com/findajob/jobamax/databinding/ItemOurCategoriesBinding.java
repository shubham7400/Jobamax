// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.findajob.jobamax.R;
import com.findajob.jobamax.data.pojo.Category;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemOurCategoriesBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rv;

  @NonNull
  public final AppCompatTextView tvLabel;

  @Bindable
  protected Category mItem;

  protected ItemOurCategoriesBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RecyclerView rv, AppCompatTextView tvLabel) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rv = rv;
    this.tvLabel = tvLabel;
  }

  public abstract void setItem(@Nullable Category item);

  @Nullable
  public Category getItem() {
    return mItem;
  }

  @NonNull
  public static ItemOurCategoriesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_our_categories, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemOurCategoriesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemOurCategoriesBinding>inflateInternal(inflater, R.layout.item_our_categories, root, attachToRoot, component);
  }

  @NonNull
  public static ItemOurCategoriesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_our_categories, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemOurCategoriesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemOurCategoriesBinding>inflateInternal(inflater, R.layout.item_our_categories, null, false, component);
  }

  public static ItemOurCategoriesBinding bind(@NonNull View view) {
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
  public static ItemOurCategoriesBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemOurCategoriesBinding)bind(component, view, R.layout.item_our_categories);
  }
}
