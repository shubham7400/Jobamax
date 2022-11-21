package com.jobamax.appjobamax.login;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class LoginRegistrationOptionFragmentDirections {
  private LoginRegistrationOptionFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLoginRegistrationOptionFragmentToUserLoginFragment() {
    return new ActionOnlyNavDirections(R.id.action_loginRegistrationOptionFragment_to_userLoginFragment);
  }

  @NonNull
  public static NavDirections actionLoginRegistrationOptionFragmentToPrivacyPolicyFragment() {
    return new ActionOnlyNavDirections(R.id.action_loginRegistrationOptionFragment_to_privacyPolicyFragment);
  }

  @NonNull
  public static NavDirections actionLoginRegistrationOptionFragmentToTakeAgeFragment() {
    return new ActionOnlyNavDirections(R.id.action_loginRegistrationOptionFragment_to_takeAgeFragment);
  }
}
