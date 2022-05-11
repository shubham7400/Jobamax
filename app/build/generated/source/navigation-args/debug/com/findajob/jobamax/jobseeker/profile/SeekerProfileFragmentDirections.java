package com.findajob.jobamax.jobseeker.profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class SeekerProfileFragmentDirections {
  private SeekerProfileFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToSeekerAboutMeFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_seekerAboutMeFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToSeekerEducationFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_seekerEducationFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToSeekerMySkillFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_seekerMySkillFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToSeekerInterestFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_seekerInterestFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToSeekerExperienceListFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_seekerExperienceListFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToSeekerPreviewFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_seekerPreviewFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToSeekerImportResumeFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_seekerImportResumeFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToSeekerVolunteeringListFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_seekerVolunteeringListFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToIdealJobAudioFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_idealJobAudioFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToIdealJobImagesFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_idealJobImagesFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToIdealJobDescriptionFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_idealJobDescriptionFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToIdealJobVideoFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_idealJobVideoFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentSelf() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_self);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToPortfolioVideoFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_portfolioVideoFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToPortfolioDescriptionFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_portfolioDescriptionFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToPortfolioImageFragment() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_portfolioImageFragment);
  }

  @NonNull
  public static NavDirections actionSeekerProfileFragmentToNavJobSearch() {
    return new ActionOnlyNavDirections(R.id.action_seekerProfileFragment_to_nav_job_search);
  }
}
