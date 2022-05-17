package com.jobamax.appjobamax.jobseeker.profile.experience;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class SeekerExperienceListFragmentDirections {
  private SeekerExperienceListFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerExperienceListFragmentToSeekerAddExperienceFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerExperienceListFragment_to_seekerAddExperienceFragment);
  }
}
