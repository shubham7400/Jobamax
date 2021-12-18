package com.findajob.jobamax.recruiter.profile.account.deleteAccount;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class RecruiterDeleteAccountFragmentDirections {
  private RecruiterDeleteAccountFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionRecruiterDeleteAccountFragmentToRecruiterDeleteAccountFinalFragment(
      ) {
    return new ActionOnlyNavDirections(R.id.action_recruiterDeleteAccountFragment_to_recruiterDeleteAccountFinalFragment);
  }
}
