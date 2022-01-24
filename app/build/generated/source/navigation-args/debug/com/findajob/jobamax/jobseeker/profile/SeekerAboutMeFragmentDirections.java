package com.findajob.jobamax.jobseeker.profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerAboutMeFragmentDirections {
  private SeekerAboutMeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerAboutMeFragmentToSeekerSocialMediaIdsFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerAboutMeFragment_to_seekerSocialMediaIdsFragment);
  }
}
