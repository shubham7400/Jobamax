package com.jobamax.appjobamax.login;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class UserLoginFragmentDirections {
  private UserLoginFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionUserLoginFragmentToForgetPasswordFragment() {
    return new ActionOnlyNavDirections(R.id.action_userLoginFragment_to_forgetPasswordFragment);
  }
}
