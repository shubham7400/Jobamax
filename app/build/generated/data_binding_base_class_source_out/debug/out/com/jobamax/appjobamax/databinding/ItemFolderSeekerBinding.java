// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.imageview.ShapeableImageView;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemFolderSeekerBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clParent;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final LinearLayout ll1;

  @NonNull
  public final ShapeableImageView sivSeeker;

  @NonNull
  public final TextView tvJobTitle;

  @NonNull
  public final TextView tvName;

  protected ItemFolderSeekerBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout clParent, LinearLayout linearLayout2, LinearLayout ll1,
      ShapeableImageView sivSeeker, TextView tvJobTitle, TextView tvName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clParent = clParent;
    this.linearLayout2 = linearLayout2;
    this.ll1 = ll1;
    this.sivSeeker = sivSeeker;
    this.tvJobTitle = tvJobTitle;
    this.tvName = tvName;
  }

  @NonNull
  public static ItemFolderSeekerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_folder_seeker, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemFolderSeekerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemFolderSeekerBinding>inflateInternal(inflater, R.layout.item_folder_seeker, root, attachToRoot, component);
  }

  @NonNull
  public static ItemFolderSeekerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_folder_seeker, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemFolderSeekerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemFolderSeekerBinding>inflateInternal(inflater, R.layout.item_folder_seeker, null, false, component);
  }

  public static ItemFolderSeekerBinding bind(@NonNull View view) {
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
  public static ItemFolderSeekerBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemFolderSeekerBinding)bind(component, view, R.layout.item_folder_seeker);
  }
}