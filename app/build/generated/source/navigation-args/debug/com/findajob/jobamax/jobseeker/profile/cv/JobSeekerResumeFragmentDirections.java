package com.findajob.jobamax.jobseeker.profile.cv;

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

public class JobSeekerResumeFragmentDirections {
  private JobSeekerResumeFragmentDirections() {
  }

  @NonNull
  public static ActionJobSeekerCvFragmentToCreateEducationFragment actionJobSeekerCvFragmentToCreateEducationFragment(
      ) {
    return new ActionJobSeekerCvFragmentToCreateEducationFragment();
  }

  @NonNull
  public static ActionJobSeekerCvFragmentToCreateExperienceFragment2 actionJobSeekerCvFragmentToCreateExperienceFragment2(
      ) {
    return new ActionJobSeekerCvFragmentToCreateExperienceFragment2();
  }

  public static class ActionJobSeekerCvFragmentToCreateEducationFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionJobSeekerCvFragmentToCreateEducationFragment() {
    }

    @NonNull
    public ActionJobSeekerCvFragmentToCreateEducationFragment setArgEducation(
        @NonNull String argEducation) {
      if (argEducation == null) {
        throw new IllegalArgumentException("Argument \"arg_education\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("arg_education", argEducation);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("arg_education")) {
        String argEducation = (String) arguments.get("arg_education");
        __result.putString("arg_education", argEducation);
      } else {
        __result.putString("arg_education", "");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_jobSeekerCvFragment_to_createEducationFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getArgEducation() {
      return (String) arguments.get("arg_education");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionJobSeekerCvFragmentToCreateEducationFragment that = (ActionJobSeekerCvFragmentToCreateEducationFragment) object;
      if (arguments.containsKey("arg_education") != that.arguments.containsKey("arg_education")) {
        return false;
      }
      if (getArgEducation() != null ? !getArgEducation().equals(that.getArgEducation()) : that.getArgEducation() != null) {
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
      result = 31 * result + (getArgEducation() != null ? getArgEducation().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionJobSeekerCvFragmentToCreateEducationFragment(actionId=" + getActionId() + "){"
          + "argEducation=" + getArgEducation()
          + "}";
    }
  }

  public static class ActionJobSeekerCvFragmentToCreateExperienceFragment2 implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionJobSeekerCvFragmentToCreateExperienceFragment2() {
    }

    @NonNull
    public ActionJobSeekerCvFragmentToCreateExperienceFragment2 setArgExperience(
        @NonNull String argExperience) {
      if (argExperience == null) {
        throw new IllegalArgumentException("Argument \"arg_experience\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("arg_experience", argExperience);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("arg_experience")) {
        String argExperience = (String) arguments.get("arg_experience");
        __result.putString("arg_experience", argExperience);
      } else {
        __result.putString("arg_experience", "");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_jobSeekerCvFragment_to_createExperienceFragment2;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getArgExperience() {
      return (String) arguments.get("arg_experience");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionJobSeekerCvFragmentToCreateExperienceFragment2 that = (ActionJobSeekerCvFragmentToCreateExperienceFragment2) object;
      if (arguments.containsKey("arg_experience") != that.arguments.containsKey("arg_experience")) {
        return false;
      }
      if (getArgExperience() != null ? !getArgExperience().equals(that.getArgExperience()) : that.getArgExperience() != null) {
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
      result = 31 * result + (getArgExperience() != null ? getArgExperience().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionJobSeekerCvFragmentToCreateExperienceFragment2(actionId=" + getActionId() + "){"
          + "argExperience=" + getArgExperience()
          + "}";
    }
  }
}
