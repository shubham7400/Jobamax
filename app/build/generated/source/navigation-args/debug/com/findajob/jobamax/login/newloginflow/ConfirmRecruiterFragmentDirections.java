package com.findajob.jobamax.login.newloginflow;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class ConfirmRecruiterFragmentDirections {
  private ConfirmRecruiterFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionConfirmRecruiterFragmentToLoginFragment() {
    return new ActionOnlyNavDirections(R.id.action_confirmRecruiterFragment_to_loginFragment);
  }

  @NonNull
  public static NavDirections actionConfirmRecruiterFragmentToConfirm3SeekerFragment() {
    return new ActionOnlyNavDirections(R.id.action_confirmRecruiterFragment_to_confirm3SeekerFragment);
  }
}
