package com.findajob.jobamax.recruiter.track;

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

public class RecruiterRecruitFragmentDirections {
  private RecruiterRecruitFragmentDirections() {
  }

  @NonNull
  public static ActionRecruiterTrackFragmentToPlayVideoFragment actionRecruiterTrackFragmentToPlayVideoFragment(
      ) {
    return new ActionRecruiterTrackFragmentToPlayVideoFragment();
  }

  @NonNull
  public static ActionRecruiterRecruitFragmentToCreateJobOfferFragment actionRecruiterRecruitFragmentToCreateJobOfferFragment(
      ) {
    return new ActionRecruiterRecruitFragmentToCreateJobOfferFragment();
  }

  public static class ActionRecruiterTrackFragmentToPlayVideoFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionRecruiterTrackFragmentToPlayVideoFragment() {
    }

    @NonNull
    public ActionRecruiterTrackFragmentToPlayVideoFragment setArgVideoUrl(
        @NonNull String argVideoUrl) {
      if (argVideoUrl == null) {
        throw new IllegalArgumentException("Argument \"arg_video_url\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("arg_video_url", argVideoUrl);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("arg_video_url")) {
        String argVideoUrl = (String) arguments.get("arg_video_url");
        __result.putString("arg_video_url", argVideoUrl);
      } else {
        __result.putString("arg_video_url", "");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_recruiterTrackFragment_to_playVideoFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getArgVideoUrl() {
      return (String) arguments.get("arg_video_url");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionRecruiterTrackFragmentToPlayVideoFragment that = (ActionRecruiterTrackFragmentToPlayVideoFragment) object;
      if (arguments.containsKey("arg_video_url") != that.arguments.containsKey("arg_video_url")) {
        return false;
      }
      if (getArgVideoUrl() != null ? !getArgVideoUrl().equals(that.getArgVideoUrl()) : that.getArgVideoUrl() != null) {
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
      result = 31 * result + (getArgVideoUrl() != null ? getArgVideoUrl().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionRecruiterTrackFragmentToPlayVideoFragment(actionId=" + getActionId() + "){"
          + "argVideoUrl=" + getArgVideoUrl()
          + "}";
    }
  }

  public static class ActionRecruiterRecruitFragmentToCreateJobOfferFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionRecruiterRecruitFragmentToCreateJobOfferFragment() {
    }

    @NonNull
    public ActionRecruiterRecruitFragmentToCreateJobOfferFragment setArgLocation(
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
      return R.id.action_recruiterRecruitFragment_to_createJobOfferFragment;
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
      ActionRecruiterRecruitFragmentToCreateJobOfferFragment that = (ActionRecruiterRecruitFragmentToCreateJobOfferFragment) object;
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
      return "ActionRecruiterRecruitFragmentToCreateJobOfferFragment(actionId=" + getActionId() + "){"
          + "argLocation=" + getArgLocation()
          + "}";
    }
  }
}
