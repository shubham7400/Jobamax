package com.findajob.jobamax.jobseeker.profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerProfileFragmentDirections {
  private SeekerProfileFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToSeekerPreviewFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_seekerPreviewFragment);
  }
}
