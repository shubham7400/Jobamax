package com.jobamax.appjobamax.recruiter.message;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class RecruiterChatListFragmentDirections {
  private RecruiterChatListFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionRecruiterChatListFragmentToRecruiterChatBoardFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterChatListFragment_to_recruiterChatBoardFragment);
  }
}
