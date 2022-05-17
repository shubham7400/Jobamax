package com.jobamax.appjobamax.jobseeker.jobsearch;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SeekerJobsFilterFragmentDirections {
  private SeekerJobsFilterFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerJobsFilterFragmentToNavSeekerProfile() {
    return new ActionOnlyNavDirections(R.id.action_seekerJobsFilterFragment_to_nav_seeker_profile);
  }

  @NonNull
  public static NavDirections actionSeekerJobsFilterFragmentToSeekerJobSearchFilterCategoriesDialogFragment(
      ) {
    return new ActionOnlyNavDirections(R.id.action_seekerJobsFilterFragment_to_seekerJobSearchFilterCategoriesDialogFragment);
  }

  @NonNull
  public static ActionSeekerJobsFilterFragmentToSeekerJobsFragment actionSeekerJobsFilterFragmentToSeekerJobsFragment(
      @Nullable String jobSeekerId, @Nullable String jobOfferId) {
    return new ActionSeekerJobsFilterFragmentToSeekerJobsFragment(jobSeekerId, jobOfferId);
  }

  public static class ActionSeekerJobsFilterFragmentToSeekerJobsFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionSeekerJobsFilterFragmentToSeekerJobsFragment(@Nullable String jobSeekerId,
        @Nullable String jobOfferId) {
      this.arguments.put("jobSeekerId", jobSeekerId);
      this.arguments.put("jobOfferId", jobOfferId);
    }

    @NonNull
    public ActionSeekerJobsFilterFragmentToSeekerJobsFragment setJobSeekerId(
        @Nullable String jobSeekerId) {
      this.arguments.put("jobSeekerId", jobSeekerId);
      return this;
    }

    @NonNull
    public ActionSeekerJobsFilterFragmentToSeekerJobsFragment setJobOfferId(
        @Nullable String jobOfferId) {
      this.arguments.put("jobOfferId", jobOfferId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_seekerJobsFilterFragment_to_seekerJobsFragment;
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

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionSeekerJobsFilterFragmentToSeekerJobsFragment that = (ActionSeekerJobsFilterFragmentToSeekerJobsFragment) object;
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
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getJobSeekerId() != null ? getJobSeekerId().hashCode() : 0);
      result = 31 * result + (getJobOfferId() != null ? getJobOfferId().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionSeekerJobsFilterFragmentToSeekerJobsFragment(actionId=" + getActionId() + "){"
          + "jobSeekerId=" + getJobSeekerId()
          + ", jobOfferId=" + getJobOfferId()
          + "}";
    }
  }
}
