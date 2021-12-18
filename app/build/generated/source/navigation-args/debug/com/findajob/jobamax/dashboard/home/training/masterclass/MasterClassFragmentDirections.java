package com.findajob.jobamax.dashboard.home.training.masterclass;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.findajob.jobamax.R;

public class MasterClassFragmentDirections {
  private MasterClassFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionMasterClassFragmentToMasterClassDetailsFragment() {
    return new ActionOnlyNavDirections(R.id.action_masterClassFragment_to_masterClassDetailsFragment);
  }
}
