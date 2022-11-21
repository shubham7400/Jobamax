package com.jobamax.appjobamax.jobseeker.build_profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class ImportProfileFromLinkedInDirections {
  private ImportProfileFromLinkedInDirections() {
  }

  @NonNull
  public static NavDirections actionImportProfileFromLinkedInToProfilePreviewFragment() {
    return new ActionOnlyNavDirections(R.id.action_importProfileFromLinkedIn_to_profilePreviewFragment);
  }
}
