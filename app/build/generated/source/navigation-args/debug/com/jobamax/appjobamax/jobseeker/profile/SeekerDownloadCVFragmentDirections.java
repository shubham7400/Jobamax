package com.jobamax.appjobamax.jobseeker.profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class SeekerDownloadCVFragmentDirections {
  private SeekerDownloadCVFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerDownloadCVFragmentToModifyCVFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerDownloadCVFragment_to_modifyCVFragment);
  }

  @NonNull
  public static NavDirections actionSeekerDownloadCVFragmentToNavSeekerAccount() {
    return new ActionOnlyNavDirections(R.id.action_seekerDownloadCVFragment_to_nav_seeker_account);
  }
}
