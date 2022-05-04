package com.findajob.jobamax.jobseeker.jobsearch;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerJobsFilterFragmentDirections {
  private SeekerJobsFilterFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerJobsFilterFragmentToSeekerProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerJobsFilterFragment_to_seekerProfileFragment);
  }
}
