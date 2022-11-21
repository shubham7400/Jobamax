package com.jobamax.appjobamax.jobseeker.chat;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class SeekerChatListFragmentDirections {
  private SeekerChatListFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerChatListFragmentToSeekerChatBoardFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerChatListFragment_to_seekerChatBoardFragment);
  }
}
