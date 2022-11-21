package com.jobamax.appjobamax.jobseeker.build_profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class PickAudioFragmentDirections {
  private PickAudioFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionPickAudioFragmentToAddAudioFragment() {
    return new ActionOnlyNavDirections(R.id.action_pickAudioFragment_to_addAudioFragment);
  }
}
