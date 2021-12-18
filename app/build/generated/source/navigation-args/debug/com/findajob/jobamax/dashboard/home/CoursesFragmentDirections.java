package com.findajob.jobamax.dashboard.home;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class CoursesFragmentDirections {
  private CoursesFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionCoursesFragmentToTrainingFragment() {
    return new ActionOnlyNavDirections(R.id.action_coursesFragment_to_trainingFragment);
  }
}
