package com.jobamax.appjobamax.jobseeker.jobsearch;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class SeekerJobSearchFilterCategoriesDialogFragmentDirections {
  private SeekerJobSearchFilterCategoriesDialogFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerJobSearchFilterCategoriesDialogFragmentToNavSeekerProfile(
      ) {
    return new ActionOnlyNavDirections(R.id.action_seekerJobSearchFilterCategoriesDialogFragment_to_nav_seeker_profile);
  }

  @NonNull
  public static NavDirections actionSeekerJobSearchFilterCategoriesDialogFragmentToSeekerJobsFilterFragment(
      ) {
    return new ActionOnlyNavDirections(R.id.action_seekerJobSearchFilterCategoriesDialogFragment_to_seekerJobsFilterFragment);
  }
}
