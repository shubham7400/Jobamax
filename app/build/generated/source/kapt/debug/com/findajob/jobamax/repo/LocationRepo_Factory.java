// Generated by Dagger (https://dagger.dev).
package com.findajob.jobamax.repo;

import com.findajob.jobamax.data.remote.GoogleApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LocationRepo_Factory implements Factory<LocationRepo> {
  private final Provider<GoogleApiService> apiProvider;

  public LocationRepo_Factory(Provider<GoogleApiService> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public LocationRepo get() {
    return newInstance(apiProvider.get());
  }

  public static LocationRepo_Factory create(Provider<GoogleApiService> apiProvider) {
    return new LocationRepo_Factory(apiProvider);
  }

  public static LocationRepo newInstance(GoogleApiService api) {
    return new LocationRepo(api);
  }
}