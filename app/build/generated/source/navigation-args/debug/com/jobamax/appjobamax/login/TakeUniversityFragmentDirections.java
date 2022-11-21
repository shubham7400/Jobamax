package com.jobamax.appjobamax.login;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class TakeUniversityFragmentDirections {
  private TakeUniversityFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionTakeUniversityFragmentToTakeWorkExperienceFragment() {
    return new ActionOnlyNavDirections(R.id.action_takeUniversityFragment_to_takeWorkExperienceFragment);
  }
}
