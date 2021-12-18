package com.findajob.jobamax.dashboard.messages;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class ChatFragmentDirections {
  private ChatFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionChatFragmentToPreviewImageFragment() {
    return new ActionOnlyNavDirections(R.id.action_chatFragment_to_previewImageFragment);
  }
}
