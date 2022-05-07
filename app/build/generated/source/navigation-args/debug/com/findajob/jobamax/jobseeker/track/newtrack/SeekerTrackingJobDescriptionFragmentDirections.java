package com.findajob.jobamax.jobseeker.track.newtrack;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerTrackingJobDescriptionFragmentDirections {
  private SeekerTrackingJobDescriptionFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerTrackingJobDescriptionFragmentToNavSeekerProfile() {
    return new ActionOnlyNavDirections(R.id.action_seekerTrackingJobDescriptionFragment_to_nav_seeker_profile);
  }
}
