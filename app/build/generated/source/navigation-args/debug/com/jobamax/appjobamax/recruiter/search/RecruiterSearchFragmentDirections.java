package com.jobamax.appjobamax.recruiter.search;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class RecruiterSearchFragmentDirections {
  private RecruiterSearchFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionRecruiterSearchFragmentToRecruiterJobSourcingFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterSearchFragment_to_recruiterJobSourcingFragment);
  }
}
