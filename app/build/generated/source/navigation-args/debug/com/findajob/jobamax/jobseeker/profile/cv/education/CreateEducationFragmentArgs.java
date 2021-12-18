package com.findajob.jobamax.jobseeker.profile.cv.education;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CreateEducationFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CreateEducationFragmentArgs() {
  }

  private CreateEducationFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CreateEducationFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CreateEducationFragmentArgs __result = new CreateEducationFragmentArgs();
    bundle.setClassLoader(CreateEducationFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("arg_education")) {
      String argEducation;
      argEducation = bundle.getString("arg_education");
      if (argEducation == null) {
        throw new IllegalArgumentException("Argument \"arg_education\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("arg_education", argEducation);
    } else {
      __result.arguments.put("arg_education", "");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getArgEducation() {
    return (String) arguments.get("arg_education");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    CreateEducationFragmentArgs that = (CreateEducationFragmentArgs) object;
    if (arguments.containsKey("arg_education") != that.arguments.containsKey("arg_education")) {
      return false;
    }
    if (getArgEducation() != null ? !getArgEducation().equals(that.getArgEducation()) : that.getArgEducation() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getArgEducation() != null ? getArgEducation().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CreateEducationFragmentArgs{"
        + "argEducation=" + getArgEducation()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(CreateEducationFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public CreateEducationFragmentArgs build() {
      CreateEducationFragmentArgs result = new CreateEducationFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setArgEducation(@NonNull String argEducation) {
      if (argEducation == null) {
        throw new IllegalArgumentException("Argument \"arg_education\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("arg_education", argEducation);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getArgEducation() {
      return (String) arguments.get("arg_education");
    }
  }
}
