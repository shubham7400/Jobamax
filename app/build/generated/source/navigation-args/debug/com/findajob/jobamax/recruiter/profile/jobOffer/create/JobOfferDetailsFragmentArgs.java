package com.findajob.jobamax.recruiter.profile.jobOffer.create;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class JobOfferDetailsFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private JobOfferDetailsFragmentArgs() {
  }

  private JobOfferDetailsFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static JobOfferDetailsFragmentArgs fromBundle(@NonNull Bundle bundle) {
    JobOfferDetailsFragmentArgs __result = new JobOfferDetailsFragmentArgs();
    bundle.setClassLoader(JobOfferDetailsFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("arg_location")) {
      String argLocation;
      argLocation = bundle.getString("arg_location");
      if (argLocation == null) {
        throw new IllegalArgumentException("Argument \"arg_location\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("arg_location", argLocation);
    } else {
      __result.arguments.put("arg_location", "");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getArgLocation() {
    return (String) arguments.get("arg_location");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("arg_location")) {
      String argLocation = (String) arguments.get("arg_location");
      __result.putString("arg_location", argLocation);
    } else {
      __result.putString("arg_location", "");
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
    JobOfferDetailsFragmentArgs that = (JobOfferDetailsFragmentArgs) object;
    if (arguments.containsKey("arg_location") != that.arguments.containsKey("arg_location")) {
      return false;
    }
    if (getArgLocation() != null ? !getArgLocation().equals(that.getArgLocation()) : that.getArgLocation() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getArgLocation() != null ? getArgLocation().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "JobOfferDetailsFragmentArgs{"
        + "argLocation=" + getArgLocation()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(JobOfferDetailsFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public JobOfferDetailsFragmentArgs build() {
      JobOfferDetailsFragmentArgs result = new JobOfferDetailsFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setArgLocation(@NonNull String argLocation) {
      if (argLocation == null) {
        throw new IllegalArgumentException("Argument \"arg_location\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("arg_location", argLocation);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getArgLocation() {
      return (String) arguments.get("arg_location");
    }
  }
}
