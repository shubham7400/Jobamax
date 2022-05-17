package com.jobamax.appjobamax.login;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class KeepMePostedFragmentDirections {
  private KeepMePostedFragmentDirections() {
  }

  @NonNull
  public static ActionKeepMePostedFragmentToLocationPermissionFragment actionKeepMePostedFragmentToLocationPermissionFragment(
      ) {
    return new ActionKeepMePostedFragmentToLocationPermissionFragment();
  }

  public static class ActionKeepMePostedFragmentToLocationPermissionFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionKeepMePostedFragmentToLocationPermissionFragment() {
    }

    @NonNull
    public ActionKeepMePostedFragmentToLocationPermissionFragment setArgAction(
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
      return R.id.action_keepMePostedFragment_to_locationPermissionFragment;
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
      ActionKeepMePostedFragmentToLocationPermissionFragment that = (ActionKeepMePostedFragmentToLocationPermissionFragment) object;
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
      return "ActionKeepMePostedFragmentToLocationPermissionFragment(actionId=" + getActionId() + "){"
          + "argAction=" + getArgAction()
          + "}";
    }
  }
}
