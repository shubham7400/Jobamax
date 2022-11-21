package com.jobamax.appjobamax.jobseeker.build_profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class CreateCVFragmentDirections {
  private CreateCVFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionCreateCVFragmentToImportProfileFromLinkedIn() {
    return new ActionOnlyNavDirections(R.id.action_createCVFragment_to_importProfileFromLinkedIn);
  }

  @NonNull
  public static NavDirections actionCreateCVFragmentToProfilePreviewFragment() {
    return new ActionOnlyNavDirections(R.id.action_createCVFragment_to_profilePreviewFragment);
  }
}
