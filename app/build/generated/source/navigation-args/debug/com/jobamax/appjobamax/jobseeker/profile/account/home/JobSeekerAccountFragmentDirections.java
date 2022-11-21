package com.jobamax.appjobamax.jobseeker.profile.account.home;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class JobSeekerAccountFragmentDirections {
  private JobSeekerAccountFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionJobSeekerAccountFragmentToJobSeekerPersonalInformationFragment(
      ) {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerAccountFragment_to_jobSeekerPersonalInformationFragment);
  }

  @NonNull
  public static NavDirections actionJobSeekerAccountFragmentToJobSeekerManageReadReceiptsFragment(
      ) {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerAccountFragment_to_jobSeekerManageReadReceiptsFragment);
  }

  @NonNull
  public static NavDirections actionJobSeekerAccountFragmentToJobSeekerNewsletterFragment() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerAccountFragment_to_jobSeekerNewsletterFragment);
  }

  @NonNull
  public static NavDirections actionJobSeekerAccountFragmentToSeekerDeleteAccountFragment() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerAccountFragment_to_seekerDeleteAccountFragment);
  }

  @NonNull
  public static NavDirections actionJobSeekerAccountFragmentToSeekerChangePasswordFragment() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerAccountFragment_to_seekerChangePasswordFragment);
  }
}
