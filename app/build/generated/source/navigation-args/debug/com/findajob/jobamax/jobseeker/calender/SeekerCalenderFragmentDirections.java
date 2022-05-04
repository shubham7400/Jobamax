package com.findajob.jobamax.jobseeker.calender;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerCalenderFragmentDirections {
  private SeekerCalenderFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerCalenderFragmentToSeekerProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerCalenderFragment_to_seekerProfileFragment);
  }
}
