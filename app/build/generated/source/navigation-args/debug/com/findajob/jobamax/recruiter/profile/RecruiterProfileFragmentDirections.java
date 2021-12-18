package com.findajob.jobamax.recruiter.profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class RecruiterProfileFragmentDirections {
  private RecruiterProfileFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionRecruiterProfileFragmentToShowAllJobOfferFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterProfileFragment_to_showAllJobOfferFragment);
  }

  @NonNull
  public static NavDirections actionRecruiterProfileFragmentToRecruiterAccountFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterProfileFragment_to_recruiterAccountFragment);
  }

  @NonNull
  public static NavDirections actionRecruiterProfileFragmentToRecruiterMediaFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterProfileFragment_to_recruiterMediaFragment);
  }

  @NonNull
  public static NavDirections actionRecruiterAccountFragmentToCompanyInformationFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterAccountFragment_to_companyInformationFragment);
  }

  @NonNull
  public static NavDirections actionRecruiterProfileFragmentToRecruiterCurrentSubscriptionFragment(
      ) {
    return new ActionOnlyNavDirections(R.id.action_recruiterProfileFragment_to_recruiterCurrentSubscriptionFragment);
  }
}
