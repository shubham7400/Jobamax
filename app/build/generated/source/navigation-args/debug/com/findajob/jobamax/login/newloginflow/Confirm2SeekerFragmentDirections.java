package com.findajob.jobamax.login.newloginflow;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class Confirm2SeekerFragmentDirections {
  private Confirm2SeekerFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionConfirm2SeekerFragmentToWelcomeAsSeekerFragment() {
    return new ActionOnlyNavDirections(R.id.action_confirm2SeekerFragment_to_welcomeAsSeekerFragment);
  }

  @NonNull
  public static NavDirections actionConfirm2SeekerFragmentToNoReactionDropEmailFragment() {
    return new ActionOnlyNavDirections(R.id.action_confirm2SeekerFragment_to_noReactionDropEmailFragment);
  }
}
