// Generated by Dagger (https://dagger.dev).
package com.findajob.jobamax.jobseeker.profile.cv;

import android.app.Application;
import com.findajob.jobamax.repo.JobSeekerResumeRepo;
import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class JobSeekerResumeViewModel_Factory implements Factory<JobSeekerResumeViewModel> {
  private final Provider<Application> contextProvider;

  private final Provider<JobSeekerResumeRepo> jobSeekerResumeRepoProvider;

  private final Provider<Gson> gsonConverterProvider;

  public JobSeekerResumeViewModel_Factory(Provider<Application> contextProvider,
      Provider<JobSeekerResumeRepo> jobSeekerResumeRepoProvider,
      Provider<Gson> gsonConverterProvider) {
    this.contextProvider = contextProvider;
    this.jobSeekerResumeRepoProvider = jobSeekerResumeRepoProvider;
    this.gsonConverterProvider = gsonConverterProvider;
  }

  @Override
  public JobSeekerResumeViewModel get() {
    return newInstance(contextProvider.get(), jobSeekerResumeRepoProvider.get(), gsonConverterProvider.get());
  }

  public static JobSeekerResumeViewModel_Factory create(Provider<Application> contextProvider,
      Provider<JobSeekerResumeRepo> jobSeekerResumeRepoProvider,
      Provider<Gson> gsonConverterProvider) {
    return new JobSeekerResumeViewModel_Factory(contextProvider, jobSeekerResumeRepoProvider, gsonConverterProvider);
  }

  public static JobSeekerResumeViewModel newInstance(Application context,
      JobSeekerResumeRepo jobSeekerResumeRepo, Gson gsonConverter) {
    return new JobSeekerResumeViewModel(context, jobSeekerResumeRepo, gsonConverter);
  }
}