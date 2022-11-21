package com.jobamax.appjobamax.login;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class TakeNameFragmentDirections {
  private TakeNameFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionTakeNameFragmentToTakeAgeFragment() {
    return new ActionOnlyNavDirections(R.id.action_takeNameFragment_to_takeAgeFragment);
  }
}
