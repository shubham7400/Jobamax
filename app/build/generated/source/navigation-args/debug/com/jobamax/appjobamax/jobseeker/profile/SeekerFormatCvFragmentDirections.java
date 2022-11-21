package com.jobamax.appjobamax.jobseeker.profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class SeekerFormatCvFragmentDirections {
  private SeekerFormatCvFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerFormatCvFragmentToModifyCVFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerFormatCvFragment_to_modifyCVFragment);
  }

  @NonNull
  public static NavDirections actionSeekerFormatCvFragmentToNavSeekerAccount() {
    return new ActionOnlyNavDirections(R.id.action_seekerFormatCvFragment_to_nav_seeker_account);
  }
}
