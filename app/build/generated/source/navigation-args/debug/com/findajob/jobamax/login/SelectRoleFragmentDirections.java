package com.findajob.jobamax.login;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SelectRoleFragmentDirections {
  private SelectRoleFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSelectRoleFragmentToJobSeekerLoginFragment() {
    return new ActionOnlyNavDirections(R.id.action_selectRoleFragment_to_jobSeekerLoginFragment);
  }
}
