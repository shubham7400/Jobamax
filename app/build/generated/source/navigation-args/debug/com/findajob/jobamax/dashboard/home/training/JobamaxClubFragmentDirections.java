package com.findajob.jobamax.dashboard.home.training;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class JobamaxClubFragmentDirections {
  private JobamaxClubFragmentDirections() {
  }

  @NonNull
  public static NavDirections trainingFragmentToCoursesFragment() {
    return new ActionOnlyNavDirections(R.id.trainingFragment_to_coursesFragment);
  }

  @NonNull
  public static NavDirections actionTrainingFragmentToOnlineCoursesListFragment() {
    return new ActionOnlyNavDirections(R.id.action_trainingFragment_to_onlineCoursesListFragment);
  }
}
