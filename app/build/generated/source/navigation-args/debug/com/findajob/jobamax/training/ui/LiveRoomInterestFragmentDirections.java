package com.findajob.jobamax.training.ui;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class LiveRoomInterestFragmentDirections {
  private LiveRoomInterestFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionInterestToWelcome() {
    return new ActionOnlyNavDirections(R.id.action_interest_to_welcome);
  }

  @NonNull
  public static NavDirections actionLiveRoomInterestFragmentToManageRoomFragment() {
    return new ActionOnlyNavDirections(R.id.action_liveRoomInterestFragment_to_manageRoomFragment);
  }
}
