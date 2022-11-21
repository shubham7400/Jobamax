package com.jobamax.appjobamax.jobseeker.build_profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class ModifyProfileFragmentDirections {
  private ModifyProfileFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionModifyProfileFragmentToAddNewEducationFragment() {
    return new ActionOnlyNavDirections(R.id.action_modifyProfileFragment_to_addNewEducationFragment);
  }

  @NonNull
  public static NavDirections actionModifyProfileFragmentToAddNewExperienceFragment() {
    return new ActionOnlyNavDirections(R.id.action_modifyProfileFragment_to_addNewExperienceFragment);
  }

  @NonNull
  public static NavDirections actionModifyProfileFragmentToAddNewVolunteeringFragment() {
    return new ActionOnlyNavDirections(R.id.action_modifyProfileFragment_to_addNewVolunteeringFragment);
  }

  @NonNull
  public static NavDirections actionModifyProfileFragmentToProfilePreviewFragment() {
    return new ActionOnlyNavDirections(R.id.action_modifyProfileFragment_to_profilePreviewFragment);
  }

  @NonNull
  public static NavDirections actionModifyProfileFragmentToVideoDemoFragment() {
    return new ActionOnlyNavDirections(R.id.action_modifyProfileFragment_to_videoDemoFragment);
  }

  @NonNull
  public static NavDirections actionModifyProfileFragmentToAudioDemoFragment() {
    return new ActionOnlyNavDirections(R.id.action_modifyProfileFragment_to_audioDemoFragment);
  }

  @NonNull
  public static NavDirections actionModifyProfileFragmentToImportProfileFromLinkedIn() {
    return new ActionOnlyNavDirections(R.id.action_modifyProfileFragment_to_importProfileFromLinkedIn);
  }

  @NonNull
  public static NavDirections actionModifyProfileFragmentSelf() {
    return new ActionOnlyNavDirections(R.id.action_modifyProfileFragment_self);
  }
}
