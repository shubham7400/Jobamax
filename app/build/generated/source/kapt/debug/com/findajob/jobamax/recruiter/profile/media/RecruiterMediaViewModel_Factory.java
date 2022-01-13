// Generated by Dagger (https://dagger.dev).
package com.findajob.jobamax.recruiter.profile.media;

import android.app.Application;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RecruiterMediaViewModel_Factory implements Factory<RecruiterMediaViewModel> {
  private final Provider<Application> contextProvider;

  public RecruiterMediaViewModel_Factory(Provider<Application> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public RecruiterMediaViewModel get() {
    return newInstance(contextProvider.get());
  }

  public static RecruiterMediaViewModel_Factory create(Provider<Application> contextProvider) {
    return new RecruiterMediaViewModel_Factory(contextProvider);
  }

  public static RecruiterMediaViewModel newInstance(Application context) {
    return new RecruiterMediaViewModel(context);
  }
}