// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.model.JobSeeker;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSeekerSocialMediaIdsBinding extends ViewDataBinding {
  @NonNull
  public final Button btnSave;

  @NonNull
  public final EditText etInstagramLink;

  @NonNull
  public final EditText etLinkedinLink;

  @NonNull
  public final EditText etTiktokLink;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final ImageView ivInsta;

  @NonNull
  public final ImageView ivLinkedin;

  @NonNull
  public final ImageView ivTiktok;

  @NonNull
  public final CircleImageView ivUserProfile;

  @NonNull
  public final LinearLayout llSocialMediaLink;

  @NonNull
  public final RelativeLayout relativeLayout;

  @Bindable
  protected JobSeeker mJobSeeker;

  protected FragmentSeekerSocialMediaIdsBinding(Object _bindingComponent, View _root,
      int _localFieldCount, Button btnSave, EditText etInstagramLink, EditText etLinkedinLink,
      EditText etTiktokLink, ImageView ivBackButton, ImageView ivInsta, ImageView ivLinkedin,
      ImageView ivTiktok, CircleImageView ivUserProfile, LinearLayout llSocialMediaLink,
      RelativeLayout relativeLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnSave = btnSave;
    this.etInstagramLink = etInstagramLink;
    this.etLinkedinLink = etLinkedinLink;
    this.etTiktokLink = etTiktokLink;
    this.ivBackButton = ivBackButton;
    this.ivInsta = ivInsta;
    this.ivLinkedin = ivLinkedin;
    this.ivTiktok = ivTiktok;
    this.ivUserProfile = ivUserProfile;
    this.llSocialMediaLink = llSocialMediaLink;
    this.relativeLayout = relativeLayout;
  }

  public abstract void setJobSeeker(@Nullable JobSeeker jobSeeker);

  @Nullable
  public JobSeeker getJobSeeker() {
    return mJobSeeker;
  }

  @NonNull
  public static FragmentSeekerSocialMediaIdsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_social_media_ids, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerSocialMediaIdsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerSocialMediaIdsBinding>inflateInternal(inflater, R.layout.fragment_seeker_social_media_ids, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSeekerSocialMediaIdsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_social_media_ids, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerSocialMediaIdsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerSocialMediaIdsBinding>inflateInternal(inflater, R.layout.fragment_seeker_social_media_ids, null, false, component);
  }

  public static FragmentSeekerSocialMediaIdsBinding bind(@NonNull View view) {
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
  public static FragmentSeekerSocialMediaIdsBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentSeekerSocialMediaIdsBinding)bind(component, view, R.layout.fragment_seeker_social_media_ids);
  }
}
