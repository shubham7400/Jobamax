// Generated by Dagger (https://dagger.dev).
package com.findajob.jobamax.repo;

import android.app.Application;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LiveRoomRepo_Factory implements Factory<LiveRoomRepo> {
  private final Provider<Application> contextProvider;

  public LiveRoomRepo_Factory(Provider<Application> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public LiveRoomRepo get() {
    return newInstance(contextProvider.get());
  }

  public static LiveRoomRepo_Factory create(Provider<Application> contextProvider) {
    return new LiveRoomRepo_Factory(contextProvider);
  }

  public static LiveRoomRepo newInstance(Application context) {
    return new LiveRoomRepo(context);
  }
}
