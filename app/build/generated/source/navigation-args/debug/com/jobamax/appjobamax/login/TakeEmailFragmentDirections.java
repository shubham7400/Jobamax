package com.jobamax.appjobamax.login;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class TakeEmailFragmentDirections {
  private TakeEmailFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionTakeEmailFragmentToTakePasswordFragment() {
    return new ActionOnlyNavDirections(R.id.action_takeEmailFragment_to_takePasswordFragment);
  }
}
