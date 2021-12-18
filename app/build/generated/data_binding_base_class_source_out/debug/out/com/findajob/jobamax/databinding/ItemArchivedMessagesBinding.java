// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.daimajia.swipe.SwipeLayout;
import com.findajob.jobamax.R;
import com.findajob.jobamax.data.pojo.Message;
import com.parse.ParseUser;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemArchivedMessagesBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout bottomWraper;

  @NonNull
  public final LinearLayout bottomWrapper1;

  @NonNull
  public final ImageButton btnLocation;

  @NonNull
  public final ConstraintLayout clMessageBody;

  @NonNull
  public final CardView itemMessagesIvAvatar;

  @NonNull
  public final TextView itemMessagesIvMessage;

  @NonNull
  public final TextView itemMessagesIvName;

  @NonNull
  public final ImageView ivSeenIndicator;

  @NonNull
  public final ImageView ivUnarchive;

  @NonNull
  public final SwipeLayout slMessageSwipe;

  @NonNull
  public final View vHorizontalLine;

  @Bindable
  protected Message mItem;

  @Bindable
  protected ParseUser mParseUser;

  @Bindable
  protected String mRecieverName;

  protected ItemArchivedMessagesBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout bottomWraper, LinearLayout bottomWrapper1, ImageButton btnLocation,
      ConstraintLayout clMessageBody, CardView itemMessagesIvAvatar, TextView itemMessagesIvMessage,
      TextView itemMessagesIvName, ImageView ivSeenIndicator, ImageView ivUnarchive,
      SwipeLayout slMessageSwipe, View vHorizontalLine) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomWraper = bottomWraper;
    this.bottomWrapper1 = bottomWrapper1;
    this.btnLocation = btnLocation;
    this.clMessageBody = clMessageBody;
    this.itemMessagesIvAvatar = itemMessagesIvAvatar;
    this.itemMessagesIvMessage = itemMessagesIvMessage;
    this.itemMessagesIvName = itemMessagesIvName;
    this.ivSeenIndicator = ivSeenIndicator;
    this.ivUnarchive = ivUnarchive;
    this.slMessageSwipe = slMessageSwipe;
    this.vHorizontalLine = vHorizontalLine;
  }

  public abstract void setItem(@Nullable Message item);

  @Nullable
  public Message getItem() {
    return mItem;
  }

  public abstract void setParseUser(@Nullable ParseUser parseUser);

  @Nullable
  public ParseUser getParseUser() {
    return mParseUser;
  }

  public abstract void setRecieverName(@Nullable String recieverName);

  @Nullable
  public String getRecieverName() {
    return mRecieverName;
  }

  @NonNull
  public static ItemArchivedMessagesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_archived_messages, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemArchivedMessagesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemArchivedMessagesBinding>inflateInternal(inflater, R.layout.item_archived_messages, root, attachToRoot, component);
  }

  @NonNull
  public static ItemArchivedMessagesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_archived_messages, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemArchivedMessagesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemArchivedMessagesBinding>inflateInternal(inflater, R.layout.item_archived_messages, null, false, component);
  }

  public static ItemArchivedMessagesBinding bind(@NonNull View view) {
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
  public static ItemArchivedMessagesBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemArchivedMessagesBinding)bind(component, view, R.layout.item_archived_messages);
  }
}
