package com.findajob.jobamax.recruiter.track;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class PlayVideoFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private PlayVideoFragmentArgs() {
  }

  private PlayVideoFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static PlayVideoFragmentArgs fromBundle(@NonNull Bundle bundle) {
    PlayVideoFragmentArgs __result = new PlayVideoFragmentArgs();
    bundle.setClassLoader(PlayVideoFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("arg_video_url")) {
      String argVideoUrl;
      argVideoUrl = bundle.getString("arg_video_url");
      if (argVideoUrl == null) {
        throw new IllegalArgumentException("Argument \"arg_video_url\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("arg_video_url", argVideoUrl);
    } else {
      __result.arguments.put("arg_video_url", "");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getArgVideoUrl() {
    return (String) arguments.get("arg_video_url");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    PlayVideoFragmentArgs that = (PlayVideoFragmentArgs) object;
    if (arguments.containsKey("arg_video_url") != that.arguments.containsKey("arg_video_url")) {
      return false;
    }
    if (getArgVideoUrl() != null ? !getArgVideoUrl().equals(that.getArgVideoUrl()) : that.getArgVideoUrl() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getArgVideoUrl() != null ? getArgVideoUrl().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "PlayVideoFragmentArgs{"
        + "argVideoUrl=" + getArgVideoUrl()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(PlayVideoFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public PlayVideoFragmentArgs build() {
      PlayVideoFragmentArgs result = new PlayVideoFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setArgVideoUrl(@NonNull String argVideoUrl) {
      if (argVideoUrl == null) {
        throw new IllegalArgumentException("Argument \"arg_video_url\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("arg_video_url", argVideoUrl);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getArgVideoUrl() {
      return (String) arguments.get("arg_video_url");
    }
  }
}
