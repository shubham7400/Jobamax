package com.findajob.jobamax.jobseeker.track.newtrack;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerTrackingJobDetailsFragmentDirections {
  private SeekerTrackingJobDetailsFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerTrackingJobDetailsFragmentToSeekerTrackingJobDescriptionFragment(
      ) {
    return new ActionOnlyNavDirections(R.id.action_seekerTrackingJobDetailsFragment_to_seekerTrackingJobDescriptionFragment);
  }

  @NonNull
  public static NavDirections actionSeekerTrackingJobDetailsFragmentToNavSeekerProfile() {
    return new ActionOnlyNavDirections(R.id.action_seekerTrackingJobDetailsFragment_to_nav_seeker_profile);
  }
}
