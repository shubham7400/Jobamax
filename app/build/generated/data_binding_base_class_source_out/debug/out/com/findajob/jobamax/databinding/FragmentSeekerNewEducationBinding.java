// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.findajob.jobamax.R;
import com.findajob.jobamax.model.JobSeeker;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSeekerNewEducationBinding extends ViewDataBinding {
  @NonNull
  public final CheckBox cbCurrentStudent;

  @NonNull
  public final ConstraintLayout clEndDate;

  @NonNull
  public final ConstraintLayout clMostParent;

  @NonNull
  public final EditText etDescription;

  @NonNull
  public final EditText etGpa;

  @NonNull
  public final EditText etProgram;

  @NonNull
  public final EditText etSchool;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final CircleImageView ivUserProfile;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final RecyclerView rvUniversities;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView11;

  @NonNull
  public final TextView textView144;

  @NonNull
  public final TextView textView15;

  @NonNull
  public final TextView textView9;

  @NonNull
  public final TextView tvDescriptionTitle;

  @NonNull
  public final TextView tvEndDate;

  @NonNull
  public final TextView tvStartDate;

  @Bindable
  protected JobSeeker mJobSeeker;

  protected FragmentSeekerNewEducationBinding(Object _bindingComponent, View _root,
      int _localFieldCount, CheckBox cbCurrentStudent, ConstraintLayout clEndDate,
      ConstraintLayout clMostParent, EditText etDescription, EditText etGpa, EditText etProgram,
      EditText etSchool, ImageView ivBackButton, CircleImageView ivUserProfile,
      LinearLayout linearLayout, RelativeLayout relativeLayout, RecyclerView rvUniversities,
      TextView textView10, TextView textView11, TextView textView144, TextView textView15,
      TextView textView9, TextView tvDescriptionTitle, TextView tvEndDate, TextView tvStartDate) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cbCurrentStudent = cbCurrentStudent;
    this.clEndDate = clEndDate;
    this.clMostParent = clMostParent;
    this.etDescription = etDescription;
    this.etGpa = etGpa;
    this.etProgram = etProgram;
    this.etSchool = etSchool;
    this.ivBackButton = ivBackButton;
    this.ivUserProfile = ivUserProfile;
    this.linearLayout = linearLayout;
    this.relativeLayout = relativeLayout;
    this.rvUniversities = rvUniversities;
    this.textView10 = textView10;
    this.textView11 = textView11;
    this.textView144 = textView144;
    this.textView15 = textView15;
    this.textView9 = textView9;
    this.tvDescriptionTitle = tvDescriptionTitle;
    this.tvEndDate = tvEndDate;
    this.tvStartDate = tvStartDate;
  }

  public abstract void setJobSeeker(@Nullable JobSeeker jobSeeker);

  @Nullable
  public JobSeeker getJobSeeker() {
    return mJobSeeker;
  }

  @NonNull
  public static FragmentSeekerNewEducationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_new_education, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerNewEducationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerNewEducationBinding>inflateInternal(inflater, R.layout.fragment_seeker_new_education, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSeekerNewEducationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_new_education, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerNewEducationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerNewEducationBinding>inflateInternal(inflater, R.layout.fragment_seeker_new_education, null, false, component);
  }

  public static FragmentSeekerNewEducationBinding bind(@NonNull View view) {
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
  public static FragmentSeekerNewEducationBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentSeekerNewEducationBinding)bind(component, view, R.layout.fragment_seeker_new_education);
  }
}
