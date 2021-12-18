// Generated by data binding compiler. Do not edit!
package com.findajob.jobamax.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.findajob.jobamax.R;
import com.findajob.jobamax.recruiter.profile.jobOffer.show.ShowAllJobOfferController;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentJobListingBinding extends ViewDataBinding {
  @NonNull
  public final AppBarLayout ablAppBar;

  @NonNull
  public final AppCompatButton btnAddJobOffer;

  @NonNull
  public final AppCompatButton btnArchivedJobOffers;

  @NonNull
  public final CardView cvMainBody;

  @NonNull
  public final ImageView ivAddJobButton;

  @NonNull
  public final ImageView ivArchivedJobOffer;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final TextView noOffersLabel;

  @NonNull
  public final RecyclerView rvActiveJobOffers;

  @NonNull
  public final TextView tvJobOfferLabel;

  @NonNull
  public final View vHorizontalLine;

  @Bindable
  protected ShowAllJobOfferController mHandler;

  protected FragmentJobListingBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppBarLayout ablAppBar, AppCompatButton btnAddJobOffer, AppCompatButton btnArchivedJobOffers,
      CardView cvMainBody, ImageView ivAddJobButton, ImageView ivArchivedJobOffer,
      ImageView ivBackButton, TextView noOffersLabel, RecyclerView rvActiveJobOffers,
      TextView tvJobOfferLabel, View vHorizontalLine) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ablAppBar = ablAppBar;
    this.btnAddJobOffer = btnAddJobOffer;
    this.btnArchivedJobOffers = btnArchivedJobOffers;
    this.cvMainBody = cvMainBody;
    this.ivAddJobButton = ivAddJobButton;
    this.ivArchivedJobOffer = ivArchivedJobOffer;
    this.ivBackButton = ivBackButton;
    this.noOffersLabel = noOffersLabel;
    this.rvActiveJobOffers = rvActiveJobOffers;
    this.tvJobOfferLabel = tvJobOfferLabel;
    this.vHorizontalLine = vHorizontalLine;
  }

  public abstract void setHandler(@Nullable ShowAllJobOfferController handler);

  @Nullable
  public ShowAllJobOfferController getHandler() {
    return mHandler;
  }

  @NonNull
  public static FragmentJobListingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_job_listing, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentJobListingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentJobListingBinding>inflateInternal(inflater, R.layout.fragment_job_listing, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentJobListingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_job_listing, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentJobListingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentJobListingBinding>inflateInternal(inflater, R.layout.fragment_job_listing, null, false, component);
  }

  public static FragmentJobListingBinding bind(@NonNull View view) {
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
  public static FragmentJobListingBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentJobListingBinding)bind(component, view, R.layout.fragment_job_listing);
  }
}
