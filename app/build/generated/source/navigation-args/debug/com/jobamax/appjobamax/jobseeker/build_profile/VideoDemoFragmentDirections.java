package com.jobamax.appjobamax.jobseeker.build_profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class VideoDemoFragmentDirections {
  private VideoDemoFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionVideoDemoFragmentToAudioDemoFragment() {
    return new ActionOnlyNavDirections(R.id.action_videoDemoFragment_to_audioDemoFragment);
  }

  @NonNull
  public static NavDirections actionVideoDemoFragmentToPickVideoFragment() {
    return new ActionOnlyNavDirections(R.id.action_videoDemoFragment_to_pickVideoFragment);
  }

  @NonNull
  public static NavDirections actionVideoDemoFragmentToAddVideoFragment() {
    return new ActionOnlyNavDirections(R.id.action_videoDemoFragment_to_addVideoFragment);
  }
}
