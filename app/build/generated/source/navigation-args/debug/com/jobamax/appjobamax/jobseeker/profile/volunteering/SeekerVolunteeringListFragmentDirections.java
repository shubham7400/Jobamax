package com.jobamax.appjobamax.jobseeker.profile.volunteering;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class SeekerVolunteeringListFragmentDirections {
  private SeekerVolunteeringListFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerVolunteeringListFragmentToSeekerAddVolunteeringFragment(
      ) {
    return new ActionOnlyNavDirections(R.id.action_seekerVolunteeringListFragment_to_seekerAddVolunteeringFragment);
  }
}
