package com.jobamax.appjobamax.login;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class PrivacyPolicyFragmentDirections {
  private PrivacyPolicyFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionPrivacyPolicyFragmentToTakeEmailFragment() {
    return new ActionOnlyNavDirections(R.id.action_privacyPolicyFragment_to_takeEmailFragment);
  }

  @NonNull
  public static NavDirections actionPrivacyPolicyFragmentToTakeAgeFragment() {
    return new ActionOnlyNavDirections(R.id.action_privacyPolicyFragment_to_takeAgeFragment);
  }
}
