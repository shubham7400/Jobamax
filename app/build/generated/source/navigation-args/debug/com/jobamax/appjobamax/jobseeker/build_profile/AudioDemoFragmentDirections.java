package com.jobamax.appjobamax.jobseeker.build_profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class AudioDemoFragmentDirections {
  private AudioDemoFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionAudioDemoFragmentToVideoDemoFragment() {
    return new ActionOnlyNavDirections(R.id.action_audioDemoFragment_to_videoDemoFragment);
  }

  @NonNull
  public static NavDirections actionAudioDemoFragmentToPickAudioFragment() {
    return new ActionOnlyNavDirections(R.id.action_audioDemoFragment_to_pickAudioFragment);
  }

  @NonNull
  public static NavDirections actionAudioDemoFragmentToAddAudioFragment() {
    return new ActionOnlyNavDirections(R.id.action_audioDemoFragment_to_addAudioFragment);
  }
}
