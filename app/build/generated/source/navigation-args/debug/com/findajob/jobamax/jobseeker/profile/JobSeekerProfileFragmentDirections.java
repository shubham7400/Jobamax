package com.findajob.jobamax.jobseeker.profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class JobSeekerProfileFragmentDirections {
  private JobSeekerProfileFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionJobSeekerProfileFragmentToJobSeekerAccountFragment() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerProfileFragment_to_jobSeekerAccountFragment);
  }

  @NonNull
  public static NavDirections actionJobSeekerProfileFragmentToJobSearchFragment2() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerProfileFragment_to_jobSearchFragment2);
  }

  @NonNull
  public static NavDirections actionJobSeekerProfileFragmentToJobSeekerMediaFragment() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerProfileFragment_to_jobSeekerMediaFragment);
  }

  @NonNull
  public static NavDirections actionJobSeekerProfileFragmentToJobSeekerCvFragment() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerProfileFragment_to_jobSeekerCvFragment);
  }
}
