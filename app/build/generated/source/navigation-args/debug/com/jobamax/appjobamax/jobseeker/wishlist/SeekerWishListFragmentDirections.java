package com.jobamax.appjobamax.jobseeker.wishlist;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class SeekerWishListFragmentDirections {
  private SeekerWishListFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerWishListFragmentToNavSeekerProfile() {
    return new ActionOnlyNavDirections(R.id.action_seekerWishListFragment_to_nav_seeker_profile);
  }
}
