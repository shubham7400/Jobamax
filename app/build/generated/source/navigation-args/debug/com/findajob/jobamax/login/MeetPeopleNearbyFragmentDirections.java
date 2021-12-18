package com.findajob.jobamax.login;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class MeetPeopleNearbyFragmentDirections {
  private MeetPeopleNearbyFragmentDirections() {
  }

  @NonNull
  public static ActionMeetPeopleNearbyFragmentToLocationPermissionFragment actionMeetPeopleNearbyFragmentToLocationPermissionFragment(
      ) {
    return new ActionMeetPeopleNearbyFragmentToLocationPermissionFragment();
  }

  public static class ActionMeetPeopleNearbyFragmentToLocationPermissionFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionMeetPeopleNearbyFragmentToLocationPermissionFragment() {
    }

    @NonNull
    public ActionMeetPeopleNearbyFragmentToLocationPermissionFragment setArgAction(
        @NonNull String argAction) {
      if (argAction == null) {
        throw new IllegalArgumentException("Argument \"arg_action\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("arg_action", argAction);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("arg_action")) {
        String argAction = (String) arguments.get("arg_action");
        __result.putString("arg_action", argAction);
      } else {
        __result.putString("arg_action", "");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_meetPeopleNearbyFragment_to_locationPermissionFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getArgAction() {
      return (String) arguments.get("arg_action");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionMeetPeopleNearbyFragmentToLocationPermissionFragment that = (ActionMeetPeopleNearbyFragmentToLocationPermissionFragment) object;
      if (arguments.containsKey("arg_action") != that.arguments.containsKey("arg_action")) {
        return false;
      }
      if (getArgAction() != null ? !getArgAction().equals(that.getArgAction()) : that.getArgAction() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getArgAction() != null ? getArgAction().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionMeetPeopleNearbyFragmentToLocationPermissionFragment(actionId=" + getActionId() + "){"
          + "argAction=" + getArgAction()
          + "}";
    }
  }
}
