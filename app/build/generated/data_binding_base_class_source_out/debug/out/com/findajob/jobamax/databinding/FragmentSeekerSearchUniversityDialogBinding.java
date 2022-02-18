// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.findajob.jobamax.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSeekerSearchUniversityDialogBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton acbtnSearch;

  @NonNull
  public final EditText etSearchUniversity;

  @NonNull
  public final RecyclerView rvUniversities;

  protected FragmentSeekerSearchUniversityDialogBinding(Object _bindingComponent, View _root,
      int _localFieldCount, AppCompatButton acbtnSearch, EditText etSearchUniversity,
      RecyclerView rvUniversities) {
    super(_bindingComponent, _root, _localFieldCount);
    this.acbtnSearch = acbtnSearch;
    this.etSearchUniversity = etSearchUniversity;
    this.rvUniversities = rvUniversities;
  }

  @NonNull
  public static FragmentSeekerSearchUniversityDialogBinding inflate(
      @NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_search_university_dialog, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerSearchUniversityDialogBinding inflate(
      @NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerSearchUniversityDialogBinding>inflateInternal(inflater, R.layout.fragment_seeker_search_university_dialog, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSeekerSearchUniversityDialogBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_seeker_search_university_dialog, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSeekerSearchUniversityDialogBinding inflate(
      @NonNull LayoutInflater inflater, @Nullable Object component) {
    return ViewDataBinding.<FragmentSeekerSearchUniversityDialogBinding>inflateInternal(inflater, R.layout.fragment_seeker_search_university_dialog, null, false, component);
  }

  public static FragmentSeekerSearchUniversityDialogBinding bind(@NonNull View view) {
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
  public static FragmentSeekerSearchUniversityDialogBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentSeekerSearchUniversityDialogBinding)bind(component, view, R.layout.fragment_seeker_search_university_dialog);
  }
}