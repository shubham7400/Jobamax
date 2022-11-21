package com.jobamax.appjobamax.login;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class UserRoleFragmentDirections {
  private UserRoleFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionUserRoleFragmentToLoginRegistrationOptionFragment() {
    return new ActionOnlyNavDirections(R.id.action_userRoleFragment_to_loginRegistrationOptionFragment);
  }

  @NonNull
  public static NavDirections actionUserRoleFragmentToUserLoginFragment() {
    return new ActionOnlyNavDirections(R.id.action_userRoleFragment_to_userLoginFragment);
  }
}
