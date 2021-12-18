package com.findajob.jobamax.jobseeker.track;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class JobSeekerApplyFragmentDirections {
  private JobSeekerApplyFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionJobSeekerApplyFragmentToJobSearchFragment2() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerApplyFragment_to_jobSearchFragment2);
  }

  @NonNull
  public static NavDirections actionJobSeekerApplyFragmentToJobOfferCardInfoFragment() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerApplyFragment_to_jobOfferCardInfoFragment);
  }
}
