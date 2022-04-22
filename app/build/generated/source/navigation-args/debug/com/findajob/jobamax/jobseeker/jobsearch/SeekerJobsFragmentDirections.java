package com.findajob.jobamax.jobseeker.jobsearch;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerJobsFragmentDirections {
  private SeekerJobsFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerJobsFragmentToSeekerJobsFilterFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerJobsFragment_to_seekerJobsFilterFragment);
  }

  @NonNull
  public static NavDirections actionSeekerJobsFragmentToSeekerWishListFragment2() {
    return new ActionOnlyNavDirections(R.id.action_seekerJobsFragment_to_seekerWishListFragment2);
  }

  @NonNull
  public static NavDirections actionSeekerJobsFragmentToSeekerAboutMeFragment2() {
    return new ActionOnlyNavDirections(R.id.action_seekerJobsFragment_to_seekerAboutMeFragment2);
  }
}
