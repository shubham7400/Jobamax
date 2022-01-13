package com.findajob.jobamax.login.newloginflow;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SplashFragmentDirections {
  private SplashFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSplashFragmentToNewLoginSelectRoleFragment() {
    return new ActionOnlyNavDirections(R.id.action_splashFragment_to_newLoginSelectRoleFragment);
  }
}
