package com.jobamax.appjobamax.jobseeker.coaching;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class SeekerCoachingFragmentDirections {
  private SeekerCoachingFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerCoachingFragmentToNavSeekerProfile() {
    return new ActionOnlyNavDirections(R.id.action_seekerCoachingFragment_to_nav_seeker_profile);
  }
}
