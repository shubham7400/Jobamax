package com.findajob.jobamax.login.newloginflow;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class WelcomeAsSeekerFragmentDirections {
  private WelcomeAsSeekerFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionWelcomeAsSeekerFragmentToLoginFragment() {
    return new ActionOnlyNavDirections(R.id.action_welcomeAsSeekerFragment_to_loginFragment);
  }
}
