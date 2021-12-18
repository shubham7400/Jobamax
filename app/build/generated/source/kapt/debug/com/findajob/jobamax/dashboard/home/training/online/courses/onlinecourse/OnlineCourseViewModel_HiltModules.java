package com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.internal.lifecycle.HiltViewModelMap;
import dagger.hilt.codegen.OriginatingElement;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;
import java.lang.String;

@OriginatingElement(
    topLevelClass = OnlineCourseViewModel.class
)
public final class OnlineCourseViewModel_HiltModules {
  private OnlineCourseViewModel_HiltModules() {
  }

  @Module
  @InstallIn(ViewModelComponent.class)
  public abstract static class BindsModule {
    private BindsModule() {
    }

    @Binds
    @IntoMap
    @StringKey("com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.OnlineCourseViewModel")
    @HiltViewModelMap
    public abstract ViewModel binds(OnlineCourseViewModel vm);
  }

  @Module
  @InstallIn(ActivityRetainedComponent.class)
  public static final class KeyModule {
    private KeyModule() {
    }

    @Provides
    @IntoSet
    @HiltViewModelMap.KeySet
    public static String provide() {
      return "com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.OnlineCourseViewModel";
    }
  }
}
