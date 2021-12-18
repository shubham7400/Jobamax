package com.findajob.jobamax.recruiter.profile.jobOffer.location;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class LocationPermissionFragmentDirections {
  private LocationPermissionFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLocationPermissionFragmentToMeetPeopleNearbyFragment() {
    return new ActionOnlyNavDirections(R.id.action_locationPermissionFragment_to_meetPeopleNearbyFragment);
  }
}
