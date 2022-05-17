// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.model.JobSeeker;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSeekerJobsFilterBinding extends ViewDataBinding {
  @NonNull
  public final TextView aaaa;

  @NonNull
  public final AppCompatCheckBox accbApprenticeship;

  @NonNull
  public final AppCompatCheckBox accbInternship;

  @NonNull
  public final CheckBox accbLessThanOne;

  @NonNull
  public final CheckBox accbMoreThanTwo;

  @NonNull
  public final CheckBox accbOneToTwo;

  @NonNull
  public final AppCompatCheckBox accbPartTime;

  @NonNull
  public final AppCompatCheckBox accbPermanent;

  @NonNull
  public final FragmentContainerView autocompleteFragment;

  @NonNull
  public final TextView bbbb;

  @NonNull
  public final TextView cccc;

  @NonNull
  public final CircleImageView civUser;

  @NonNull
  public final EditText etCompanyName;

  @NonNull
  public final EditText etJobKeyword;

  @NonNull
  public final ImageView ivAddCategory;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final LinearLayout linearLayout6;

  @NonNull
  public final LinearLayout llAddCategory;

  @NonNull
  public final LinearLayout llIndustry;

  @NonNull
  public final LinearLayout lllll;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final RecyclerView rvJobTypes;

  @NonNull
  public final SeekBar sbDistance;

  @NonNull
  public final TextView textView29;

  @NonNull
  public final TextView textView2e9;

  @NonNull
  public final TextView textView30;

  @NonNull
  public final TextView tvDistance;

  @NonNull
  public final TextView tvJobTitleHint;

  @NonNull
  public final TextView tvSelectLocation;

  @Bindable
  protected JobSeeker mJobSeeker;

  protected FragmentSeekerJobsFilterBinding(Object _bindingComponent, View _root,
      int _localFieldCount, TextView aaaa, AppCompatCheckBox accbApprenticeship,
      AppCompatCheckBox accbInternship, CheckBox accbLessThanOne, CheckBox accbMoreThanTwo,
      CheckBox accbOneToTwo, AppCompatCheckBox accbPartTime, AppCompatCheckBox accbPermanent,
      FragmentContainerView autocompleteFragment, TextView bbbb, TextView cccc,
      CircleImageView civUser, EditText etCompanyName, EditText etJobKeyword,
      ImageView ivAddCategory, ImageView ivBackButton, LinearLayout linearLayout6,
      LinearLayout llAddCategory, LinearLayout llIndustry, LinearLayout lllll,
      RelativeLayout relativeLayout, RecyclerView rvJobTypes, SeekBar sbDistance,
      TextView textView29, TextView textView2e9, TextView textView30, TextView tvDistance,
      TextView tvJobTitleHint, TextView tvSelectLocation) {
    super(_bindingComponent, _root, _localFieldCount);
    this.aaaa = aaaa;
    this.accbApprenticeship = accbApprenticeship;
    this.accbInternship = accbInternship;
    this.accbLessThanOne = accbLessThanOne;
    this.accbMoreThanTwo = accbMoreThanTwo;
    this.accbOneToTwo = accbOneToTwo;
    this.accbPartTime = accbPartTime;
    this.accbPermanent = accbPermanent;
    this.autocompleteFragment = autocompleteFragment;
    this.bbbb = bbbb;
    this.cccc = cccc;
    this.civUser = civUser;
    this.etCompanyName = etCompanyName;
    this.etJobKeyword = etJobKeyword;
    this.ivAddCategory = ivAddCategory;
    this.ivBackButton = ivBackButton;
    this.linearLayout6 = linearLayout6;
    this.llAddCategory = llAddCategory;
    this.llIndustry = llIndustry;
    this.lllll = lllll;
    this.relativeLayout = relativeLayout;
    this.rvJobTypes = rvJobTypes;
    this.sbDistance = sbDistance;
    this.textView29 = textView29;
    this.textView2e9 = textView2e9;
    this.textView30 = textView30;
    this.tvDistance = tvDistance;
    this.tvJobTitleHint = tvJobTitleHint;
    this.tvSelectLocation = tvSelectLocation;
  }

  public abstract void setJobSeeker(@Nullable JobSeeker jobSeeker);

  @Nullable
  public JobSeeker getJobSeeker() {
    return mJobSeeker;
  }

  @NonNull
  public static FragmentSeekerJobsFilterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_jobs_filter, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerJobsFilterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerJobsFilterBinding>inflateInternal(inflater, R.layout.fragment_seeker_jobs_filter, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSeekerJobsFilterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_jobs_filter, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerJobsFilterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerJobsFilterBinding>inflateInternal(inflater, R.layout.fragment_seeker_jobs_filter, null, false, component);
  }

  public static FragmentSeekerJobsFilterBinding bind(@NonNull View view) {
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
  public static FragmentSeekerJobsFilterBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentSeekerJobsFilterBinding)bind(component, view, R.layout.fragment_seeker_jobs_filter);
  }
}
