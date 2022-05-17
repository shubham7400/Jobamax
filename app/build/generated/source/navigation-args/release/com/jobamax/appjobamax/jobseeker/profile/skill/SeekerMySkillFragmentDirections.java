package com.jobamax.appjobamax.jobseeker.profile.skill;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class SeekerMySkillFragmentDirections {
  private SeekerMySkillFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerMySkillFragmentToSeekerProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerMySkillFragment_to_seekerProfileFragment);
  }
}
