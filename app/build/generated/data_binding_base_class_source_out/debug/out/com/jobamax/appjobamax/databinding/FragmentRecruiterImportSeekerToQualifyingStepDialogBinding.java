// Generated by data binding compiler. Do not edit!
package com.jobamax.appjobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jobamax.appjobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentRecruiterImportSeekerToQualifyingStepDialogBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton btnImport;

  @NonNull
  public final ConstraintLayout clPageTitle;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final RecyclerView rvFolderSeeker;

  @NonNull
  public final View view4;

  protected FragmentRecruiterImportSeekerToQualifyingStepDialogBinding(Object _bindingComponent,
      View _root, int _localFieldCount, AppCompatButton btnImport, ConstraintLayout clPageTitle,
      ImageView ivBackButton, RecyclerView rvFolderSeeker, View view4) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnImport = btnImport;
    this.clPageTitle = clPageTitle;
    this.ivBackButton = ivBackButton;
    this.rvFolderSeeker = rvFolderSeeker;
    this.view4 = view4;
  }

  @NonNull
  public static FragmentRecruiterImportSeekerToQualifyingStepDialogBinding inflate(
      @NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_recruiter_import_seeker_to_qualifying_step_dialog, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentRecruiterImportSeekerToQualifyingStepDialogBinding inflate(
      @NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentRecruiterImportSeekerToQualifyingStepDialogBinding>inflateInternal(inflater, R.layout.fragment_recruiter_import_seeker_to_qualifying_step_dialog, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentRecruiterImportSeekerToQualifyingStepDialogBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_recruiter_import_seeker_to_qualifying_step_dialog, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentRecruiterImportSeekerToQualifyingStepDialogBinding inflate(
      @NonNull LayoutInflater inflater, @Nullable Object component) {
    return ViewDataBinding.<FragmentRecruiterImportSeekerToQualifyingStepDialogBinding>inflateInternal(inflater, R.layout.fragment_recruiter_import_seeker_to_qualifying_step_dialog, null, false, component);
  }

  public static FragmentRecruiterImportSeekerToQualifyingStepDialogBinding bind(
      @NonNull View view) {
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
  public static FragmentRecruiterImportSeekerToQualifyingStepDialogBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentRecruiterImportSeekerToQualifyingStepDialogBinding)bind(component, view, R.layout.fragment_recruiter_import_seeker_to_qualifying_step_dialog);
  }
}