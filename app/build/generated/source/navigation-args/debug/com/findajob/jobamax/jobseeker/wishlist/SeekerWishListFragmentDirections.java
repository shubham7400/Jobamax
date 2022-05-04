package com.findajob.jobamax.jobseeker.wishlist;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerWishListFragmentDirections {
  private SeekerWishListFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerWishListFragmentToSeekerProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerWishListFragment_to_seekerProfileFragment);
  }
}
