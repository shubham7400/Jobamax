package com.jobamax.appjobamax.jobseeker.build_profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class ManualFilterMainFragmentDirections {
  private ManualFilterMainFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionManualFilterMainFragmentToFilterJobSearchTagFragment() {
    return new ActionOnlyNavDirections(R.id.action_manualFilterMainFragment_to_filterJobSearchTagFragment);
  }

  @NonNull
  public static NavDirections actionManualFilterMainFragmentToModifyCVFragment() {
    return new ActionOnlyNavDirections(R.id.action_manualFilterMainFragment_to_modifyCVFragment);
  }
}