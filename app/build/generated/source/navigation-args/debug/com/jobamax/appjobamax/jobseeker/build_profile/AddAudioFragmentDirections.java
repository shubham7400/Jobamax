package com.jobamax.appjobamax.jobseeker.build_profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class AddAudioFragmentDirections {
  private AddAudioFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionAddAudioFragmentToAudioDemoFragment() {
    return new ActionOnlyNavDirections(R.id.action_addAudioFragment_to_audioDemoFragment);
  }

  @NonNull
  public static NavDirections actionAddAudioFragmentToPickAudioFragment() {
    return new ActionOnlyNavDirections(R.id.action_addAudioFragment_to_pickAudioFragment);
  }
}
