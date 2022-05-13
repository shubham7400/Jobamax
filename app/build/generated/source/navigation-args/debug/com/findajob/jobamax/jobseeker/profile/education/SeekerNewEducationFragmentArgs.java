package com.findajob.jobamax.jobseeker.profile.education;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import com.findajob.jobamax.data.pojo.Education;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SeekerNewEducationFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SeekerNewEducationFragmentArgs() {
  }

  private SeekerNewEducationFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SeekerNewEducationFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SeekerNewEducationFragmentArgs __result = new SeekerNewEducationFragmentArgs();
    bundle.setClassLoader(SeekerNewEducationFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("education")) {
      Education education;
      if (Parcelable.class.isAssignableFrom(Education.class) || Serializable.class.isAssignableFrom(Education.class)) {
        education = (Education) bundle.get("education");
      } else {
        throw new UnsupportedOperationException(Education.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (education == null) {
        throw new IllegalArgumentException("Argument \"education\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("education", education);
    } else {
      throw new IllegalArgumentException("Required argument \"education\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Education getEducation() {
    return (Education) arguments.get("education");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    SeekerNewEducationFragmentArgs that = (SeekerNewEducationFragmentArgs) object;
    if (arguments.containsKey("education") != that.arguments.containsKey("education")) {
      return false;
    }
    if (getEducation() != null ? !getEducation().equals(that.getEducation()) : that.getEducation() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getEducation() != null ? getEducation().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SeekerNewEducationFragmentArgs{"
        + "education=" + getEducation()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(SeekerNewEducationFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull Education education) {
      if (education == null) {
        throw new IllegalArgumentException("Argument \"education\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("education", education);
    }

    @NonNull
    public SeekerNewEducationFragmentArgs build() {
      SeekerNewEducationFragmentArgs result = new SeekerNewEducationFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setEducation(@NonNull Education education) {
      if (education == null) {
        throw new IllegalArgumentException("Argument \"education\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("education", education);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Education getEducation() {
      return (Education) arguments.get("education");
    }
  }
}
