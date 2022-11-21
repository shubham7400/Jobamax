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
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jobamax.appjobamax.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemProfileBioBinding extends ViewDataBinding {
  @NonNull
  public final CircleImageView circleImageView;

  @NonNull
  public final CardView clCircleImage;

  @NonNull
  public final ConstraintLayout clProfileIv;

  @NonNull
  public final ImageView ivCollage;

  @NonNull
  public final ImageView ivEducation;

  @NonNull
  public final ImageView ivJobPost;

  @NonNull
  public final ImageView ivLocationPoint;

  @NonNull
  public final ImageView ivSearch;

  @NonNull
  public final LinearLayout linearLayout10;

  @NonNull
  public final LinearLayout linearLayout11;

  @NonNull
  public final LinearLayout llEducation;

  @NonNull
  public final LinearLayout llInterestedIn;

  @NonNull
  public final LinearLayout llJobLocation;

  @NonNull
  public final LinearLayout llJobTitle;

  @NonNull
  public final LinearLayout llUniversity;

  @NonNull
  public final TextView tvBio;

  @NonNull
  public final TextView tvEducation;

  @NonNull
  public final TextView tvInterestedIn;

  @NonNull
  public final TextView tvJobLocation;

  @NonNull
  public final TextView tvJobName;

  @NonNull
  public final TextView tvUniversityName;

  @NonNull
  public final TextView tvUserName;

  protected ItemProfileBioBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CircleImageView circleImageView, CardView clCircleImage, ConstraintLayout clProfileIv,
      ImageView ivCollage, ImageView ivEducation, ImageView ivJobPost, ImageView ivLocationPoint,
      ImageView ivSearch, LinearLayout linearLayout10, LinearLayout linearLayout11,
      LinearLayout llEducation, LinearLayout llInterestedIn, LinearLayout llJobLocation,
      LinearLayout llJobTitle, LinearLayout llUniversity, TextView tvBio, TextView tvEducation,
      TextView tvInterestedIn, TextView tvJobLocation, TextView tvJobName,
      TextView tvUniversityName, TextView tvUserName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.circleImageView = circleImageView;
    this.clCircleImage = clCircleImage;
    this.clProfileIv = clProfileIv;
    this.ivCollage = ivCollage;
    this.ivEducation = ivEducation;
    this.ivJobPost = ivJobPost;
    this.ivLocationPoint = ivLocationPoint;
    this.ivSearch = ivSearch;
    this.linearLayout10 = linearLayout10;
    this.linearLayout11 = linearLayout11;
    this.llEducation = llEducation;
    this.llInterestedIn = llInterestedIn;
    this.llJobLocation = llJobLocation;
    this.llJobTitle = llJobTitle;
    this.llUniversity = llUniversity;
    this.tvBio = tvBio;
    this.tvEducation = tvEducation;
    this.tvInterestedIn = tvInterestedIn;
    this.tvJobLocation = tvJobLocation;
    this.tvJobName = tvJobName;
    this.tvUniversityName = tvUniversityName;
    this.tvUserName = tvUserName;
  }

  @NonNull
  public static ItemProfileBioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_profile_bio, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemProfileBioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemProfileBioBinding>inflateInternal(inflater, R.layout.item_profile_bio, root, attachToRoot, component);
  }

  @NonNull
  public static ItemProfileBioBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_profile_bio, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemProfileBioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemProfileBioBinding>inflateInternal(inflater, R.layout.item_profile_bio, null, false, component);
  }

  public static ItemProfileBioBinding bind(@NonNull View view) {
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
  public static ItemProfileBioBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemProfileBioBinding)bind(component, view, R.layout.item_profile_bio);
  }
}