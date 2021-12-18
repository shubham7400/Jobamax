package com.findajob.jobamax.recruiter.profile.jobOffer.show;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class JobListingFragmentDirections {
  private JobListingFragmentDirections() {
  }

  @NonNull
  public static ActionShowAllJobOfferFragmentToCreateJobOfferFragment actionShowAllJobOfferFragmentToCreateJobOfferFragment(
      ) {
    return new ActionShowAllJobOfferFragmentToCreateJobOfferFragment();
  }

  @NonNull
  public static NavDirections actionShowAllJobOfferToViewJobOffer() {
    return new ActionOnlyNavDirections(R.id.action_show_all_job_offer_to_view_job_offer);
  }

  @NonNull
  public static NavDirections actionShowAllJobOfferToRecruiterPersonalInfo() {
    return new ActionOnlyNavDirections(R.id.action_show_all_job_offer_to_recruiter_personal_info);
  }

  @NonNull
  public static ActionShowAllJobOfferFragmentToCreateJobOfferFragment2 actionShowAllJobOfferFragmentToCreateJobOfferFragment2(
      ) {
    return new ActionShowAllJobOfferFragmentToCreateJobOfferFragment2();
  }

  public static class ActionShowAllJobOfferFragmentToCreateJobOfferFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionShowAllJobOfferFragmentToCreateJobOfferFragment() {
    }

    @NonNull
    public ActionShowAllJobOfferFragmentToCreateJobOfferFragment setArgLocation(
        @NonNull String argLocation) {
      if (argLocation == null) {
        throw new IllegalArgumentException("Argument \"arg_location\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("arg_location", argLocation);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_showAllJobOfferFragment_to_createJobOfferFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getArgLocation() {
      return (String) arguments.get("arg_location");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionShowAllJobOfferFragmentToCreateJobOfferFragment that = (ActionShowAllJobOfferFragmentToCreateJobOfferFragment) object;
      if (arguments.containsKey("arg_location") != that.arguments.containsKey("arg_location")) {
        return false;
      }
      if (getArgLocation() != null ? !getArgLocation().equals(that.getArgLocation()) : that.getArgLocation() != null) {
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
      result = 31 * result + (getArgLocation() != null ? getArgLocation().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionShowAllJobOfferFragmentToCreateJobOfferFragment(actionId=" + getActionId() + "){"
          + "argLocation=" + getArgLocation()
          + "}";
    }
  }

  public static class ActionShowAllJobOfferFragmentToCreateJobOfferFragment2 implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionShowAllJobOfferFragmentToCreateJobOfferFragment2() {
    }

    @NonNull
    public ActionShowAllJobOfferFragmentToCreateJobOfferFragment2 setArgLocation(
        @NonNull String argLocation) {
      if (argLocation == null) {
        throw new IllegalArgumentException("Argument \"arg_location\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("arg_location", argLocation);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_showAllJobOfferFragment_to_createJobOfferFragment2;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getArgLocation() {
      return (String) arguments.get("arg_location");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionShowAllJobOfferFragmentToCreateJobOfferFragment2 that = (ActionShowAllJobOfferFragmentToCreateJobOfferFragment2) object;
      if (arguments.containsKey("arg_location") != that.arguments.containsKey("arg_location")) {
        return false;
      }
      if (getArgLocation() != null ? !getArgLocation().equals(that.getArgLocation()) : that.getArgLocation() != null) {
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
      result = 31 * result + (getArgLocation() != null ? getArgLocation().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionShowAllJobOfferFragmentToCreateJobOfferFragment2(actionId=" + getActionId() + "){"
          + "argLocation=" + getArgLocation()
          + "}";
    }
  }
}
