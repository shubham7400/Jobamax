package com.findajob.jobamax.jobseeker.profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerMySkillFragmentDirections {
  private SeekerMySkillFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerMySkillFragmentToSeekerProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerMySkillFragment_to_seekerProfileFragment);
  }
}
