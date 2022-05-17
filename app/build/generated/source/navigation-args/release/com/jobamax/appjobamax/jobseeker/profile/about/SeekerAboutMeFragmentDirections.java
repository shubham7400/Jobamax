package com.jobamax.appjobamax.jobseeker.profile.about;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class SeekerAboutMeFragmentDirections {
  private SeekerAboutMeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerAboutMeFragmentToSeekerSocialMediaIdsFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerAboutMeFragment_to_seekerSocialMediaIdsFragment);
  }

  @NonNull
  public static NavDirections actionSeekerAboutMeFragmentToSeekerAboutMeScannerFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerAboutMeFragment_to_seekerAboutMeScannerFragment);
  }
}
