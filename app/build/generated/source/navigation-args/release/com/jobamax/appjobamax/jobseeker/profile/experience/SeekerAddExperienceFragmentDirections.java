package com.jobamax.appjobamax.jobseeker.profile.experience;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class SeekerAddExperienceFragmentDirections {
  private SeekerAddExperienceFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerAddExperienceFragmentToSeekerProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerAddExperienceFragment_to_seekerProfileFragment);
  }
}
