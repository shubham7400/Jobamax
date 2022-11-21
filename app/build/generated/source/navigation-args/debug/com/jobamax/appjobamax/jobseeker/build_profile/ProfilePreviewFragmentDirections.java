package com.jobamax.appjobamax.jobseeker.build_profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class ProfilePreviewFragmentDirections {
  private ProfilePreviewFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionProfilePreviewFragmentToModifyProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_profilePreviewFragment_to_modifyProfileFragment);
  }

  @NonNull
  public static NavDirections actionProfilePreviewFragmentToVideoDemoFragment() {
    return new ActionOnlyNavDirections(R.id.action_profilePreviewFragment_to_videoDemoFragment);
  }

  @NonNull
  public static NavDirections actionProfilePreviewFragmentToAudioDemoFragment() {
    return new ActionOnlyNavDirections(R.id.action_profilePreviewFragment_to_audioDemoFragment);
  }
}
