package com.findajob.jobamax.jobseeker.track;

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

  @NonNull
  public static NavDirections actionSeekerTrackingJobFragmentToSeekerAddPersonalTrackJobFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerTrackingJobFragment_to_seekerAddPersonalTrackJobFragment);
  }

  @NonNull
  public static NavDirections actionSeekerTrackingJobFragmentToSeekerCalenderFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerTrackingJobFragment_to_seekerCalenderFragment);
  }

  @NonNull
  public static NavDirections actionSeekerTrackingJobFragmentToNavSeekerProfile() {
    return new ActionOnlyNavDirections(R.id.action_seekerTrackingJobFragment_to_nav_seeker_profile);
  }
}
