package com.jobamax.appjobamax.jobseeker.profile.account.deleteAccount;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class SeekerDeleteAccountFragmentDirections {
  private SeekerDeleteAccountFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerDeleteAccountFragmentToSeekerDeleteAccountFinalFragment(
      ) {
    return new ActionOnlyNavDirections(R.id.action_seekerDeleteAccountFragment_to_seekerDeleteAccountFinalFragment);
  }
}
