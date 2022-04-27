package com.findajob.jobamax.login;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class ValuePrivacyFragmentDirections {
  private ValuePrivacyFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionValuePrivacyFragmentToKeepMePostedFragment() {
    return new ActionOnlyNavDirections(R.id.action_valuePrivacyFragment_to_keepMePostedFragment);
  }
}
