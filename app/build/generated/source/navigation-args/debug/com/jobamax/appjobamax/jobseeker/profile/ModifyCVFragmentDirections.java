package com.jobamax.appjobamax.jobseeker.profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.jobamax.appjobamax.R;

public class ModifyCVFragmentDirections {
  private ModifyCVFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionModifyCVFragmentToAddNewEducationFragment() {
    return new ActionOnlyNavDirections(R.id.action_modifyCVFragment_to_addNewEducationFragment);
  }

  @NonNull
  public static NavDirections actionModifyCVFragmentToAddNewExperienceFragment() {
    return new ActionOnlyNavDirections(R.id.action_modifyCVFragment_to_addNewExperienceFragment);
  }

  @NonNull
  public static NavDirections actionModifyCVFragmentToAddNewVolunteeringFragment() {
    return new ActionOnlyNavDirections(R.id.action_modifyCVFragment_to_addNewVolunteeringFragment);
  }

  @NonNull
  public static NavDirections actionModifyCVFragmentToVideoDemoFragment() {
    return new ActionOnlyNavDirections(R.id.action_modifyCVFragment_to_videoDemoFragment);
  }

  @NonNull
  public static NavDirections actionModifyCVFragmentToAudioDemoFragment() {
    return new ActionOnlyNavDirections(R.id.action_modifyCVFragment_to_audioDemoFragment);
  }

  @NonNull
  public static NavDirections actionModifyCVFragmentToImportProfileFromLinkedIn() {
    return new ActionOnlyNavDirections(R.id.action_modifyCVFragment_to_importProfileFromLinkedIn);
  }

  @NonNull
  public static NavDirections actionModifyCVFragmentToSeekerFormatCvFragment() {
    return new ActionOnlyNavDirections(R.id.action_modifyCVFragment_to_seekerFormatCvFragment);
  }

  @NonNull
  public static NavDirections actionModifyCVFragmentToNavSeekerAccount() {
    return new ActionOnlyNavDirections(R.id.action_modifyCVFragment_to_nav_seeker_account);
  }
}
