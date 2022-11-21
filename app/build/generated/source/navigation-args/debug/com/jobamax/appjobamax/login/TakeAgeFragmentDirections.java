package com.jobamax.appjobamax.login;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class TakeAgeFragmentDirections {
  private TakeAgeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionTakeAgeFragmentToTakeUniversityFragment() {
    return new ActionOnlyNavDirections(R.id.action_takeAgeFragment_to_takeUniversityFragment);
  }
}
