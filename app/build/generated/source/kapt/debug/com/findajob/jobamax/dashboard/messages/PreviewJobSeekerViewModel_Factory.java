// Generated by Dagger (https://dagger.dev).
package com.findajob.jobamax.dashboard.messages;

import com.findajob.jobamax.repo.MessageRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PreviewJobSeekerViewModel_Factory implements Factory<PreviewJobSeekerViewModel> {
  private final Provider<MessageRepository> repoProvider;

  public PreviewJobSeekerViewModel_Factory(Provider<MessageRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public PreviewJobSeekerViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static PreviewJobSeekerViewModel_Factory create(Provider<MessageRepository> repoProvider) {
    return new PreviewJobSeekerViewModel_Factory(repoProvider);
  }

  public static PreviewJobSeekerViewModel newInstance(MessageRepository repo) {
    return new PreviewJobSeekerViewModel(repo);
  }
}
