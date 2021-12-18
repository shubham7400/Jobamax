package com.findajob.jobamax.recruiter.profile.jobOffer.location;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class LocationPermissionFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private LocationPermissionFragmentArgs() {
  }

  private LocationPermissionFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static LocationPermissionFragmentArgs fromBundle(@NonNull Bundle bundle) {
    LocationPermissionFragmentArgs __result = new LocationPermissionFragmentArgs();
    bundle.setClassLoader(LocationPermissionFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("arg_action")) {
      String argAction;
      argAction = bundle.getString("arg_action");
      if (argAction == null) {
        throw new IllegalArgumentException("Argument \"arg_action\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("arg_action", argAction);
    } else {
      __result.arguments.put("arg_action", "");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getArgAction() {
    return (String) arguments.get("arg_action");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    LocationPermissionFragmentArgs that = (LocationPermissionFragmentArgs) object;
    if (arguments.containsKey("arg_action") != that.arguments.containsKey("arg_action")) {
      return false;
    }
    if (getArgAction() != null ? !getArgAction().equals(that.getArgAction()) : that.getArgAction() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getArgAction() != null ? getArgAction().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "LocationPermissionFragmentArgs{"
        + "argAction=" + getArgAction()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(LocationPermissionFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public LocationPermissionFragmentArgs build() {
      LocationPermissionFragmentArgs result = new LocationPermissionFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setArgAction(@NonNull String argAction) {
      if (argAction == null) {
        throw new IllegalArgumentException("Argument \"arg_action\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("arg_action", argAction);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getArgAction() {
      return (String) arguments.get("arg_action");
    }
  }
}
