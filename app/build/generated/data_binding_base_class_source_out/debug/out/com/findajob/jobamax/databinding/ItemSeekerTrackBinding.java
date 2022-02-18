// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemSeekerTrackBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton acbtnApply;

  @NonNull
  public final ConstraintLayout clParent;

  @NonNull
  public final CircleImageView ivCompany;

  @NonNull
  public final TextView tvCompanyName;

  @NonNull
  public final TextView tvProductName;

  protected ItemSeekerTrackBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatButton acbtnApply, ConstraintLayout clParent, CircleImageView ivCompany,
      TextView tvCompanyName, TextView tvProductName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.acbtnApply = acbtnApply;
    this.clParent = clParent;
    this.ivCompany = ivCompany;
    this.tvCompanyName = tvCompanyName;
    this.tvProductName = tvProductName;
  }

  @NonNull
  public static ItemSeekerTrackBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_seeker_track, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemSeekerTrackBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemSeekerTrackBinding>inflateInternal(inflater, R.layout.item_seeker_track, root, attachToRoot, component);
  }

  @NonNull
  public static ItemSeekerTrackBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_seeker_track, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemSeekerTrackBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemSeekerTrackBinding>inflateInternal(inflater, R.layout.item_seeker_track, null, false, component);
  }

  public static ItemSeekerTrackBinding bind(@NonNull View view) {
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
  public static ItemSeekerTrackBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemSeekerTrackBinding)bind(component, view, R.layout.item_seeker_track);
  }
}