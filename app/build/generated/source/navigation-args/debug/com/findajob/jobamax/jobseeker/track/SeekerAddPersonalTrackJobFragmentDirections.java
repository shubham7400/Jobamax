package com.findajob.jobamax.jobseeker.track;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerAddPersonalTrackJobFragmentDirections {
  private SeekerAddPersonalTrackJobFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerAddPersonalTrackJobFragmentToNavSeekerProfile() {
    return new ActionOnlyNavDirections(R.id.action_seekerAddPersonalTrackJobFragment_to_nav_seeker_profile);
  }
}
