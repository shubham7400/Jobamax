// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.findajob.jobamax.R;
import com.findajob.jobamax.jobseeker.profile.account.social.JobSeekerSocialAccountModel;
import com.findajob.jobamax.jobseeker.profile.account.social.SocialAccountInterface;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentJobSeekerSocialLinksBinding extends ViewDataBinding {
  @NonNull
  public final ImageView btnEdit;

  @NonNull
  public final Button btnSave;

  @NonNull
  public final EditText etFacebook;

  @NonNull
  public final EditText etInstagram;

  @NonNull
  public final EditText etLinkedin;

  @NonNull
  public final EditText etTwitter;

  @Bindable
  protected JobSeekerSocialAccountModel mJobSeeker;

  @Bindable
  protected SocialAccountInterface mHandler;

  protected FragmentJobSeekerSocialLinksBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView btnEdit, Button btnSave, EditText etFacebook,
      EditText etInstagram, EditText etLinkedin, EditText etTwitter) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnEdit = btnEdit;
    this.btnSave = btnSave;
    this.etFacebook = etFacebook;
    this.etInstagram = etInstagram;
    this.etLinkedin = etLinkedin;
    this.etTwitter = etTwitter;
  }

  public abstract void setJobSeeker(@Nullable JobSeekerSocialAccountModel jobSeeker);

  @Nullable
  public JobSeekerSocialAccountModel getJobSeeker() {
    return mJobSeeker;
  }

  public abstract void setHandler(@Nullable SocialAccountInterface handler);

  @Nullable
  public SocialAccountInterface getHandler() {
    return mHandler;
  }

  @NonNull
  public static FragmentJobSeekerSocialLinksBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_job_seeker_social_links, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentJobSeekerSocialLinksBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentJobSeekerSocialLinksBinding>inflateInternal(inflater, R.layout.fragment_job_seeker_social_links, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentJobSeekerSocialLinksBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_job_seeker_social_links, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentJobSeekerSocialLinksBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentJobSeekerSocialLinksBinding>inflateInternal(inflater, R.layout.fragment_job_seeker_social_links, null, false, component);
  }

  public static FragmentJobSeekerSocialLinksBinding bind(@NonNull View view) {
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
  public static FragmentJobSeekerSocialLinksBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentJobSeekerSocialLinksBinding)bind(component, view, R.layout.fragment_job_seeker_social_links);
  }
}
