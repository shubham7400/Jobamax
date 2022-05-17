package com.jobamax.appjobamax.jobseeker.profile.education;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;
import com.jobamax.appjobamax.data.pojo.Education;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SeekerEducationFragmentDirections {
  private SeekerEducationFragmentDirections() {
  }

  @NonNull
  public static ActionSeekerEducationFragmentToSeekerNewEducationFragment actionSeekerEducationFragmentToSeekerNewEducationFragment(
      @NonNull Education education) {
    return new ActionSeekerEducationFragmentToSeekerNewEducationFragment(education);
  }

  @NonNull
  public static NavDirections actionSeekerEducationFragmentToSeekerProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerEducationFragment_to_seekerProfileFragment);
  }

  public static class ActionSeekerEducationFragmentToSeekerNewEducationFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionSeekerEducationFragmentToSeekerNewEducationFragment(
        @NonNull Education education) {
      if (education == null) {
        throw new IllegalArgumentException("Argument \"education\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("education", education);
    }

    @NonNull
    public ActionSeekerEducationFragmentToSeekerNewEducationFragment setEducation(
        @NonNull Education education) {
      if (education == null) {
        throw new IllegalArgumentException("Argument \"education\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("education", education);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("education")) {
        Education education = (Education) arguments.get("education");
        if (Parcelable.class.isAssignableFrom(Education.class) || education == null) {
          __result.putParcelable("education", Parcelable.class.cast(education));
        } else if (Serializable.class.isAssignableFrom(Education.class)) {
          __result.putSerializable("education", Serializable.class.cast(education));
        } else {
          throw new UnsupportedOperationException(Education.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_seekerEducationFragment_to_seekerNewEducationFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Education getEducation() {
      return (Education) arguments.get("education");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionSeekerEducationFragmentToSeekerNewEducationFragment that = (ActionSeekerEducationFragmentToSeekerNewEducationFragment) object;
      if (arguments.containsKey("education") != that.arguments.containsKey("education")) {
        return false;
      }
      if (getEducation() != null ? !getEducation().equals(that.getEducation()) : that.getEducation() != null) {
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
      result = 31 * result + (getEducation() != null ? getEducation().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionSeekerEducationFragmentToSeekerNewEducationFragment(actionId=" + getActionId() + "){"
          + "education=" + getEducation()
          + "}";
    }
  }
}
