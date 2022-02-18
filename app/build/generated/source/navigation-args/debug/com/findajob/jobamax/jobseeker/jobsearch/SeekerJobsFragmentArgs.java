package com.findajob.jobamax.jobseeker.jobsearch;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavArgs;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SeekerJobsFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SeekerJobsFragmentArgs() {
  }

  private SeekerJobsFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SeekerJobsFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SeekerJobsFragmentArgs __result = new SeekerJobsFragmentArgs();
    bundle.setClassLoader(SeekerJobsFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("jobSeekerId")) {
      String jobSeekerId;
      if (Parcelable.class.isAssignableFrom(String.class) || Serializable.class.isAssignableFrom(String.class)) {
        jobSeekerId = (String) bundle.get("jobSeekerId");
      } else {
        throw new UnsupportedOperationException(String.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("jobSeekerId", jobSeekerId);
    } else {
      throw new IllegalArgumentException("Required argument \"jobSeekerId\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("jobOfferId")) {
      String jobOfferId;
      if (Parcelable.class.isAssignableFrom(String.class) || Serializable.class.isAssignableFrom(String.class)) {
        jobOfferId = (String) bundle.get("jobOfferId");
      } else {
        throw new UnsupportedOperationException(String.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      __result.arguments.put("jobOfferId", jobOfferId);
    } else {
      throw new IllegalArgumentException("Required argument \"jobOfferId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getJobSeekerId() {
    return (String) arguments.get("jobSeekerId");
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getJobOfferId() {
    return (String) arguments.get("jobOfferId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("jobSeekerId")) {
      String jobSeekerId = (String) arguments.get("jobSeekerId");
      if (Parcelable.class.isAssignableFrom(String.class) || jobSeekerId == null) {
        __result.putParcelable("jobSeekerId", Parcelable.class.cast(jobSeekerId));
      } else if (Serializable.class.isAssignableFrom(String.class)) {
        __result.putSerializable("jobSeekerId", Serializable.class.cast(jobSeekerId));
      } else {
        throw new UnsupportedOperationException(String.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    if (arguments.containsKey("jobOfferId")) {
      String jobOfferId = (String) arguments.get("jobOfferId");
      if (Parcelable.class.isAssignableFrom(String.class) || jobOfferId == null) {
        __result.putParcelable("jobOfferId", Parcelable.class.cast(jobOfferId));
      } else if (Serializable.class.isAssignableFrom(String.class)) {
        __result.putSerializable("jobOfferId", Serializable.class.cast(jobOfferId));
      } else {
        throw new UnsupportedOperationException(String.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
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
    SeekerJobsFragmentArgs that = (SeekerJobsFragmentArgs) object;
    if (arguments.containsKey("jobSeekerId") != that.arguments.containsKey("jobSeekerId")) {
      return false;
    }
    if (getJobSeekerId() != null ? !getJobSeekerId().equals(that.getJobSeekerId()) : that.getJobSeekerId() != null) {
      return false;
    }
    if (arguments.containsKey("jobOfferId") != that.arguments.containsKey("jobOfferId")) {
      return false;
    }
    if (getJobOfferId() != null ? !getJobOfferId().equals(that.getJobOfferId()) : that.getJobOfferId() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getJobSeekerId() != null ? getJobSeekerId().hashCode() : 0);
    result = 31 * result + (getJobOfferId() != null ? getJobOfferId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SeekerJobsFragmentArgs{"
        + "jobSeekerId=" + getJobSeekerId()
        + ", jobOfferId=" + getJobOfferId()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(SeekerJobsFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@Nullable String jobSeekerId, @Nullable String jobOfferId) {
      this.arguments.put("jobSeekerId", jobSeekerId);
      this.arguments.put("jobOfferId", jobOfferId);
    }

    @NonNull
    public SeekerJobsFragmentArgs build() {
      SeekerJobsFragmentArgs result = new SeekerJobsFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setJobSeekerId(@Nullable String jobSeekerId) {
      this.arguments.put("jobSeekerId", jobSeekerId);
      return this;
    }

    @NonNull
    public Builder setJobOfferId(@Nullable String jobOfferId) {
      this.arguments.put("jobOfferId", jobOfferId);
      return this;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getJobSeekerId() {
      return (String) arguments.get("jobSeekerId");
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getJobOfferId() {
      return (String) arguments.get("jobOfferId");
    }
  }
}
