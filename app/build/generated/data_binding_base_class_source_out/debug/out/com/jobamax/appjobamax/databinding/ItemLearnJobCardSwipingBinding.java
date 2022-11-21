// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemLearnJobCardSwipingBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton btnSwipeAction;

  @NonNull
  public final ImageView iv1;

  @NonNull
  public final LinearLayout ll1;

  @NonNull
  public final LinearLayout llDesc;

  @NonNull
  public final TextView tv1;

  @NonNull
  public final TextView tv2;

  @NonNull
  public final TextView tv3;

  @NonNull
  public final TextView tvTitle;

  protected ItemLearnJobCardSwipingBinding(Object _bindingComponent, View _root,
      int _localFieldCount, AppCompatButton btnSwipeAction, ImageView iv1, LinearLayout ll1,
      LinearLayout llDesc, TextView tv1, TextView tv2, TextView tv3, TextView tvTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSwipeAction = btnSwipeAction;
    this.iv1 = iv1;
    this.ll1 = ll1;
    this.llDesc = llDesc;
    this.tv1 = tv1;
    this.tv2 = tv2;
    this.tv3 = tv3;
    this.tvTitle = tvTitle;
  }

  @NonNull
  public static ItemLearnJobCardSwipingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_learn_job_card_swiping, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemLearnJobCardSwipingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemLearnJobCardSwipingBinding>inflateInternal(inflater, R.layout.item_learn_job_card_swiping, root, attachToRoot, component);
  }

  @NonNull
  public static ItemLearnJobCardSwipingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_learn_job_card_swiping, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemLearnJobCardSwipingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemLearnJobCardSwipingBinding>inflateInternal(inflater, R.layout.item_learn_job_card_swiping, null, false, component);
  }

  public static ItemLearnJobCardSwipingBinding bind(@NonNull View view) {
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
  public static ItemLearnJobCardSwipingBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ItemLearnJobCardSwipingBinding)bind(component, view, R.layout.item_learn_job_card_swiping);
  }
}