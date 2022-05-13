package com.findajob.jobamax.jobseeker.profile.education;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerNewEducationFragmentDirections {
  private SeekerNewEducationFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerNewEducationFragmentToSeekerProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerNewEducationFragment_to_seekerProfileFragment);
  }
}
