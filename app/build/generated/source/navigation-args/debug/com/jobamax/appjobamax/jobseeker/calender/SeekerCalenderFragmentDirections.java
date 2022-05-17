package com.jobamax.appjobamax.jobseeker.calender;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class SeekerCalenderFragmentDirections {
  private SeekerCalenderFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerCalenderFragmentToNavSeekerProfile() {
    return new ActionOnlyNavDirections(R.id.action_seekerCalenderFragment_to_nav_seeker_profile);
  }
}
