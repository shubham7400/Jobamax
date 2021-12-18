package com.findajob.jobamax.jobseeker.profile.cv.experience;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CreateExperienceFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CreateExperienceFragmentArgs() {
  }

  private CreateExperienceFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CreateExperienceFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CreateExperienceFragmentArgs __result = new CreateExperienceFragmentArgs();
    bundle.setClassLoader(CreateExperienceFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("arg_experience")) {
      String argExperience;
      argExperience = bundle.getString("arg_experience");
      if (argExperience == null) {
        throw new IllegalArgumentException("Argument \"arg_experience\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("arg_experience", argExperience);
    } else {
      __result.arguments.put("arg_experience", "");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getArgExperience() {
    return (String) arguments.get("arg_experience");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    CreateExperienceFragmentArgs that = (CreateExperienceFragmentArgs) object;
    if (arguments.containsKey("arg_experience") != that.arguments.containsKey("arg_experience")) {
      return false;
    }
    if (getArgExperience() != null ? !getArgExperience().equals(that.getArgExperience()) : that.getArgExperience() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getArgExperience() != null ? getArgExperience().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CreateExperienceFragmentArgs{"
        + "argExperience=" + getArgExperience()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(CreateExperienceFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public CreateExperienceFragmentArgs build() {
      CreateExperienceFragmentArgs result = new CreateExperienceFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setArgExperience(@NonNull String argExperience) {
      if (argExperience == null) {
        throw new IllegalArgumentException("Argument \"arg_experience\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("arg_experience", argExperience);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getArgExperience() {
      return (String) arguments.get("arg_experience");
    }
  }
}
