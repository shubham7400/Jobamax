package com.jobamax.appjobamax.recruiter.profile.setting;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class RecruiterSettingFragmentDirections {
  private RecruiterSettingFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionRecruiterSettingFragmentToRecruiterPersonalInfoFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterSettingFragment_to_recruiterPersonalInfoFragment);
  }

  @NonNull
  public static NavDirections actionRecruiterSettingFragmentToRecruiterChangePasswordFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterSettingFragment_to_recruiterChangePasswordFragment);
  }

  @NonNull
  public static NavDirections actionRecruiterSettingFragmentToRecruiterNewsLatterFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterSettingFragment_to_recruiterNewsLatterFragment);
  }
}
