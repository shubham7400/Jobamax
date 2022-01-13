package com.findajob.jobamax.login.newloginflow;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class Confirm1SeekerFragmentDirections {
  private Confirm1SeekerFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionConfirm1SeekerFragmentToWelcomeAsSeekerFragment() {
    return new ActionOnlyNavDirections(R.id.action_confirm1SeekerFragment_to_welcomeAsSeekerFragment);
  }

  @NonNull
  public static NavDirections actionConfirm1SeekerFragmentToConfirm2SeekerFragment() {
    return new ActionOnlyNavDirections(R.id.action_confirm1SeekerFragment_to_confirm2SeekerFragment);
  }
}
