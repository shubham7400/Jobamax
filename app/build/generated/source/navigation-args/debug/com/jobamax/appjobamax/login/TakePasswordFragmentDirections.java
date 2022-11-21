package com.jobamax.appjobamax.login;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class TakePasswordFragmentDirections {
  private TakePasswordFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionTakePasswordFragmentToTakeNameFragment() {
    return new ActionOnlyNavDirections(R.id.action_takePasswordFragment_to_takeNameFragment);
  }
}
