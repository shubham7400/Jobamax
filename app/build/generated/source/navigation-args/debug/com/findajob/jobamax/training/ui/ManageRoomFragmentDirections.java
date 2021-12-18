package com.findajob.jobamax.training.ui;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class ManageRoomFragmentDirections {
  private ManageRoomFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionManageRoomToWelcome() {
    return new ActionOnlyNavDirections(R.id.action_manage_room_to_welcome);
  }
}
