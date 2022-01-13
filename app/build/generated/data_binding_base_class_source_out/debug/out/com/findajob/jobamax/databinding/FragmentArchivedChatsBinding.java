// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.findajob.jobamax.R;
import com.github.loadingview.LoadingView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentArchivedChatsBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivBackGround;

  @NonNull
  public final LoadingView loading;

  @NonNull
  public final SearchView messageSearchView;

  @NonNull
  public final RecyclerView messagesRvMessages;

  @NonNull
  public final TextView tvMessagingLabel;

  protected FragmentArchivedChatsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView ivBackGround, LoadingView loading, SearchView messageSearchView,
      RecyclerView messagesRvMessages, TextView tvMessagingLabel) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivBackGround = ivBackGround;
    this.loading = loading;
    this.messageSearchView = messageSearchView;
    this.messagesRvMessages = messagesRvMessages;
    this.tvMessagingLabel = tvMessagingLabel;
  }

  @NonNull
  public static FragmentArchivedChatsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_archived_chats, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentArchivedChatsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentArchivedChatsBinding>inflateInternal(inflater, R.layout.fragment_archived_chats, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentArchivedChatsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_archived_chats, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentArchivedChatsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentArchivedChatsBinding>inflateInternal(inflater, R.layout.fragment_archived_chats, null, false, component);
  }

  public static FragmentArchivedChatsBinding bind(@NonNull View view) {
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
  public static FragmentArchivedChatsBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentArchivedChatsBinding)bind(component, view, R.layout.fragment_archived_chats);
  }
}