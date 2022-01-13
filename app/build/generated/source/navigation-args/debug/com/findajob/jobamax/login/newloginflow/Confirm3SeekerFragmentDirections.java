package com.findajob.jobamax.login.newloginflow;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class Confirm3SeekerFragmentDirections {
  private Confirm3SeekerFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionConfirm3SeekerFragmentToLoginFragment() {
    return new ActionOnlyNavDirections(R.id.action_confirm3SeekerFragment_to_loginFragment);
  }

  @NonNull
  public static NavDirections actionConfirm3SeekerFragmentToNoReactionFragment() {
    return new ActionOnlyNavDirections(R.id.action_confirm3SeekerFragment_to_noReactionFragment);
  }
}
