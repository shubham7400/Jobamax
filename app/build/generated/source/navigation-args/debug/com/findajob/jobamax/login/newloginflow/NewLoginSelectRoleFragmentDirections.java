package com.findajob.jobamax.login.newloginflow;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class NewLoginSelectRoleFragmentDirections {
  private NewLoginSelectRoleFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionNewLoginSelectRoleFragmentToConfirm1SeekerFragment() {
    return new ActionOnlyNavDirections(R.id.action_newLoginSelectRoleFragment_to_confirm1SeekerFragment);
  }

  @NonNull
  public static NavDirections actionNewLoginSelectRoleFragmentToConfirmRecruiterFragment() {
    return new ActionOnlyNavDirections(R.id.action_newLoginSelectRoleFragment_to_confirmRecruiterFragment);
  }
}
