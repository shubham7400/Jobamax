// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentAddNewEducationBinding extends ViewDataBinding {
  @NonNull
  public final TextView btnEdit;

  @NonNull
  public final AppCompatCheckBox cbCurrentStudent;

  @NonNull
  public final ConstraintLayout constraintLayout16;

  @NonNull
  public final EditText etDescription;

  @NonNull
  public final EditText etProgram;

  @NonNull
  public final EditText etSchool;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final LinearLayout ll1;

  @NonNull
  public final LinearLayout ll2;

  @NonNull
  public final LinearLayout llEndDate;

  @NonNull
  public final LinearLayout llMostParent;

  @NonNull
  public final RecyclerView rvUniversities;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView tv1;

  @NonNull
  public final TextView tv2;

  @NonNull
  public final TextView tv7;

  @NonNull
  public final TextView tvDescription;

  @NonNull
  public final TextView tvEndDate;

  @NonNull
  public final TextView tvStartDate;

  @NonNull
  public final View view;

  protected FragmentAddNewEducationBinding(Object _bindingComponent, View _root,
      int _localFieldCount, TextView btnEdit, AppCompatCheckBox cbCurrentStudent,
      ConstraintLayout constraintLayout16, EditText etDescription, EditText etProgram,
      EditText etSchool, ImageView ivBackButton, LinearLayout ll1, LinearLayout ll2,
      LinearLayout llEndDate, LinearLayout llMostParent, RecyclerView rvUniversities,
      TextView textView3, TextView tv1, TextView tv2, TextView tv7, TextView tvDescription,
      TextView tvEndDate, TextView tvStartDate, View view) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnEdit = btnEdit;
    this.cbCurrentStudent = cbCurrentStudent;
    this.constraintLayout16 = constraintLayout16;
    this.etDescription = etDescription;
    this.etProgram = etProgram;
    this.etSchool = etSchool;
    this.ivBackButton = ivBackButton;
    this.ll1 = ll1;
    this.ll2 = ll2;
    this.llEndDate = llEndDate;
    this.llMostParent = llMostParent;
    this.rvUniversities = rvUniversities;
    this.textView3 = textView3;
    this.tv1 = tv1;
    this.tv2 = tv2;
    this.tv7 = tv7;
    this.tvDescription = tvDescription;
    this.tvEndDate = tvEndDate;
    this.tvStartDate = tvStartDate;
    this.view = view;
  }

  @NonNull
  public static FragmentAddNewEducationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_add_new_education, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentAddNewEducationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentAddNewEducationBinding>inflateInternal(inflater, R.layout.fragment_add_new_education, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentAddNewEducationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_add_new_education, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentAddNewEducationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentAddNewEducationBinding>inflateInternal(inflater, R.layout.fragment_add_new_education, null, false, component);
  }

  public static FragmentAddNewEducationBinding bind(@NonNull View view) {
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
  public static FragmentAddNewEducationBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentAddNewEducationBinding)bind(component, view, R.layout.fragment_add_new_education);
  }
}