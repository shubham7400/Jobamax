package com.jobamax.appjobamax.jobseeker.jobsearch;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class SeekerJobsFragmentDirections {
  private SeekerJobsFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerJobsFragmentToSeekerJobsFilterFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerJobsFragment_to_seekerJobsFilterFragment);
  }

  @NonNull
  public static NavDirections actionSeekerJobsFragmentToSeekerWishListFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerJobsFragment_to_seekerWishListFragment);
  }

  @NonNull
  public static NavDirections actionSeekerJobsFragmentToNavSeekerProfile() {
    return new ActionOnlyNavDirections(R.id.action_seekerJobsFragment_to_nav_seeker_profile);
  }
}
