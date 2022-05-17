// Generated by Dagger (https://dagger.dev).
package com.jobamax.appjobamax.di;

import android.app.Application;
import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ViewModelModule_ProvideContextFactory implements Factory<Context> {
  private final Provider<Application> contextProvider;

  public ViewModelModule_ProvideContextFactory(Provider<Application> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public Context get() {
    return provideContext(contextProvider.get());
  }

  public static ViewModelModule_ProvideContextFactory create(
      Provider<Application> contextProvider) {
    return new ViewModelModule_ProvideContextFactory(contextProvider);
  }

  public static Context provideContext(Application context) {
    return Preconditions.checkNotNullFromProvides(ViewModelModule.INSTANCE.provideContext(context));
  }
}
