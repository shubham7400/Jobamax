package com.findajob.jobamax.jobseeker.jobsearch;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerJobsFilterFragmentDirections {
  private SeekerJobsFilterFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerJobsFilterFragmentToNavSeekerProfile() {
    return new ActionOnlyNavDirections(R.id.action_seekerJobsFilterFragment_to_nav_seeker_profile);
  }
}
