package com.findajob.jobamax.jobseeker;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class JobSeekerHomeFragmentDirections {
  private JobSeekerHomeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionJobSeekerHomeFragmentToNavSeekerProfile() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerHomeFragment_to_nav_seeker_profile);
  }

  @NonNull
  public static NavDirections actionJobSeekerHomeFragmentToNavJobTracking() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerHomeFragment_to_nav_job_tracking);
  }

  @NonNull
  public static NavDirections actionJobSeekerHomeFragmentToNavSeekerWishlist() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerHomeFragment_to_nav_seeker_wishlist);
  }

  @NonNull
  public static NavDirections actionJobSeekerHomeFragmentToNavJobSearch() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerHomeFragment_to_nav_job_search);
  }

  @NonNull
  public static NavDirections actionJobSeekerHomeFragmentToNavSeekerAccount() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerHomeFragment_to_nav_seeker_account);
  }

  @NonNull
  public static NavDirections actionJobSeekerHomeFragmentToSeekerCalenderFragment() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerHomeFragment_to_seekerCalenderFragment);
  }

  @NonNull
  public static NavDirections actionJobSeekerHomeFragmentToSeekerCoachingFragment() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerHomeFragment_to_seekerCoachingFragment);
  }

  @NonNull
  public static NavDirections actionJobSeekerHomeFragmentToSeekerWishListFragment() {
    return new ActionOnlyNavDirections(R.id.action_jobSeekerHomeFragment_to_seekerWishListFragment);
  }
}
