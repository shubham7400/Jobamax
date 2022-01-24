package com.findajob.jobamax.jobseeker.track.newtrack;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerTrackingJobFragmentDirections {
  private SeekerTrackingJobFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerTrackingJobFragmentToSeekerTrackingJobDetailsFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerTrackingJobFragment_to_seekerTrackingJobDetailsFragment);
  }
}
