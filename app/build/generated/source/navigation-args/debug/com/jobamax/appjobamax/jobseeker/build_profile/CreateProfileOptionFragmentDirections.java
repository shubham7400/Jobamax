package com.jobamax.appjobamax.jobseeker.build_profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class CreateProfileOptionFragmentDirections {
  private CreateProfileOptionFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionCreateProfileOptionFragmentToCreateCVFragment() {
    return new ActionOnlyNavDirections(R.id.action_createProfileOptionFragment_to_createCVFragment);
  }

  @NonNull
  public static NavDirections actionCreateProfileOptionFragmentToManualFilterFragment() {
    return new ActionOnlyNavDirections(R.id.action_createProfileOptionFragment_to_manualFilterFragment);
  }
}
