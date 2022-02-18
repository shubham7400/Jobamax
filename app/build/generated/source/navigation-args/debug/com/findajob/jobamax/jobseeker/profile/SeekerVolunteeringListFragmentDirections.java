package com.findajob.jobamax.jobseeker.profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerVolunteeringListFragmentDirections {
  private SeekerVolunteeringListFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerVolunteeringListFragmentToSeekerAddVolunteeringFragment(
      ) {
    return new ActionOnlyNavDirections(R.id.action_seekerVolunteeringListFragment_to_seekerAddVolunteeringFragment);
  }
}
