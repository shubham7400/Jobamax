package com.findajob.jobamax.jobseeker.profile.about;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerSocialMediaIdsFragmentDirections {
  private SeekerSocialMediaIdsFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerSocialMediaIdsFragmentToSeekerProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerSocialMediaIdsFragment_to_seekerProfileFragment);
  }
}
