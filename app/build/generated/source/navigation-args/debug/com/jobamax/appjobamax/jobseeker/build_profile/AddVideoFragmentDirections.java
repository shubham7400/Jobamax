package com.jobamax.appjobamax.jobseeker.build_profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class AddVideoFragmentDirections {
  private AddVideoFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionAddVideoFragmentToPickVideoFragment() {
    return new ActionOnlyNavDirections(R.id.action_addVideoFragment_to_pickVideoFragment);
  }

  @NonNull
  public static NavDirections actionAddVideoFragmentToVideoDemoFragment() {
    return new ActionOnlyNavDirections(R.id.action_addVideoFragment_to_videoDemoFragment);
  }
}
