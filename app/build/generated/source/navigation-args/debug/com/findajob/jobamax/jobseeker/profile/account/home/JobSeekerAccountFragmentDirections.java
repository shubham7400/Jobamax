package com.findajob.jobamax.jobseeker.profile.account.home;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class JobSeekerAccountFragmentDirections {
  private JobSeekerAccountFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionJobSeekerAccountFragmentToJobSeekerPersonalInformationFragment(
      ) {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerAccountFragment_to_jobSeekerPersonalInformationFragment);
  }

  @NonNull
  public static NavDirections actionJobSeekerAccountFragmentToJobSeekerPushNotificationFragment() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerAccountFragment_to_jobSeekerPushNotificationFragment);
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
  public static NavDirections actionJobSeekerAccountFragmentToSeekerDeleteAccountFragment2() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerAccountFragment_to_seekerDeleteAccountFragment2);
  }

  @NonNull
  public static NavDirections actionJobSeekerAccountFragmentToSeekerChangePasswordFragment() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerAccountFragment_to_seekerChangePasswordFragment);
  }

  @NonNull
  public static NavDirections actionJobSeekerAccountFragmentToJobSeekerChangeLanguageFragment() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerAccountFragment_to_jobSeekerChangeLanguageFragment);
  }

  @NonNull
  public static NavDirections actionJobSeekerAccountFragmentToNavSeekerProfile() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerAccountFragment_to_nav_seeker_profile);
  }
}
