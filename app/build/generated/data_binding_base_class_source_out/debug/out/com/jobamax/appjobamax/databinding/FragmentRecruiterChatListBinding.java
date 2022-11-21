// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.customview.CustomSpinner;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentRecruiterChatListBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout clSortBy;

  @NonNull
  public final ImageView ivSeekerFolder;

  @NonNull
  public final RecyclerView rvChatList;

  @NonNull
  public final CustomSpinner spQualifyingStep;

  @NonNull
  public final TextView tvCancelMoveToFolder;

  @NonNull
  public final TextView tvEditRole;

  @NonNull
  public final TextView tvMoveToFolder;

  @NonNull
  public final TextView tvPageTitle;

  @NonNull
  public final TextView tvSortBy;

  @NonNull
  public final View vDevider;

  protected FragmentRecruiterChatListBinding(Object _bindingComponent, View _root,
      int _localFieldCount, RelativeLayout clSortBy, ImageView ivSeekerFolder,
      RecyclerView rvChatList, CustomSpinner spQualifyingStep, TextView tvCancelMoveToFolder,
      TextView tvEditRole, TextView tvMoveToFolder, TextView tvPageTitle, TextView tvSortBy,
      View vDevider) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clSortBy = clSortBy;
    this.ivSeekerFolder = ivSeekerFolder;
    this.rvChatList = rvChatList;
    this.spQualifyingStep = spQualifyingStep;
    this.tvCancelMoveToFolder = tvCancelMoveToFolder;
    this.tvEditRole = tvEditRole;
    this.tvMoveToFolder = tvMoveToFolder;
    this.tvPageTitle = tvPageTitle;
    this.tvSortBy = tvSortBy;
    this.vDevider = vDevider;
  }

  @NonNull
  public static FragmentRecruiterChatListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_recruiter_chat_list, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentRecruiterChatListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentRecruiterChatListBinding>inflateInternal(inflater, R.layout.fragment_recruiter_chat_list, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentRecruiterChatListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_recruiter_chat_list, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentRecruiterChatListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentRecruiterChatListBinding>inflateInternal(inflater, R.layout.fragment_recruiter_chat_list, null, false, component);
  }

  public static FragmentRecruiterChatListBinding bind(@NonNull View view) {
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
  public static FragmentRecruiterChatListBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentRecruiterChatListBinding)bind(component, view, R.layout.fragment_recruiter_chat_list);
  }
}