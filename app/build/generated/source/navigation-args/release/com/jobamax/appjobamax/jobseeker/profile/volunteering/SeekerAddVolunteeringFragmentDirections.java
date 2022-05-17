package com.jobamax.appjobamax.jobseeker.profile.volunteering;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class SeekerAddVolunteeringFragmentDirections {
  private SeekerAddVolunteeringFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerAddVolunteeringFragmentToSeekerProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerAddVolunteeringFragment_to_seekerProfileFragment);
  }
}
