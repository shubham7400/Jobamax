package com.jobamax.appjobamax.jobseeker.build_profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class PickVideoFragmentDirections {
  private PickVideoFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionPickVideoFragmentToAddVideoFragment() {
    return new ActionOnlyNavDirections(R.id.action_pickVideoFragment_to_addVideoFragment);
  }
}
