package com.findajob.jobamax.jobseeker.profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerProfileFragmentDirections {
  private SeekerProfileFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToSeekerAboutMeFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_seekerAboutMeFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToSeekerEducationFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_seekerEducationFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToSeekerMySkillFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_seekerMySkillFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToVolunteeringAndActivitiesFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_volunteeringAndActivitiesFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToSeekerExperienceListFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_seekerExperienceListFragment);
  }
}
