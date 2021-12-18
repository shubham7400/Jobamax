package com.findajob.jobamax.recruiter.profile.account.home;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class RecruiterAccountFragmentDirections {
  private RecruiterAccountFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionRecruiterAccountFragmentToRecruiterPersonalInformationFragment(
      ) {
    return new ActionOnlyNavDirections(R.id.action_recruiterAccountFragment_to_recruiterPersonalInformationFragment);
  }

  @NonNull
  public static NavDirections actionRecruiterAccountFragmentToManageReadReceiptsFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterAccountFragment_to_manageReadReceiptsFragment);
  }

  @NonNull
  public static NavDirections actionRecruiterAccountFragmentToNewsletterFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterAccountFragment_to_newsletterFragment);
  }

  @NonNull
  public static NavDirections actionRecruiterAccountFragmentToRecruiterPushNotificationFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterAccountFragment_to_recruiterPushNotificationFragment);
  }

  @NonNull
  public static NavDirections actionRecruiterAccountFragmentToRecruiterPaymentMethodsFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterAccountFragment_to_recruiterPaymentMethodsFragment);
  }

  @NonNull
  public static NavDirections actionRecruiterAccountFragmentToRecruiterInvoicesFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterAccountFragment_to_recruiterInvoicesFragment);
  }

  @NonNull
  public static NavDirections actionRecruiterAccountFragmentToCompanyInformationFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterAccountFragment_to_companyInformationFragment);
  }

  @NonNull
  public static NavDirections actionRecruiterAccountFragmentToRecruiterSocialAccountFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterAccountFragment_to_recruiterSocialAccountFragment);
  }

  @NonNull
  public static NavDirections actionRecruiterAccountFragmentToRecruiterDeleteAccountFragment() {
    return new ActionOnlyNavDirections(R.id.action_recruiterAccountFragment_to_recruiterDeleteAccountFragment);
  }
}
