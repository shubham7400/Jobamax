package com.findajob.jobamax.training.ui;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class LiveRoomWelcomeFragmentDirections {
  private LiveRoomWelcomeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionWelcomeEventCalendar() {
    return new ActionOnlyNavDirections(R.id.action_welcome_event_calendar);
  }

  @NonNull
  public static NavDirections actionWelcomeToParticipants() {
    return new ActionOnlyNavDirections(R.id.action_welcome_to_participants);
  }

  @NonNull
  public static NavDirections actionWelcomeToRoom() {
    return new ActionOnlyNavDirections(R.id.action_welcome_to_room);
  }
}
