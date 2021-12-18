package com.findajob.jobamax.recruiter.profile.jobOffer.create;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class JobOfferDetailsFragmentDirections {
  private JobOfferDetailsFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionCreateJobOfferToViewJobOffer() {
    return new ActionOnlyNavDirections(R.id.action_create_job_offer_to_view_job_offer);
  }
}
