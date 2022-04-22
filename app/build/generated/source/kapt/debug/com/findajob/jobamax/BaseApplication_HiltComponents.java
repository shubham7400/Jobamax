package com.findajob.jobamax;

import com.findajob.jobamax.di.ViewModelModule;
import com.findajob.jobamax.jobseeker.calender.SeekerCalenderFragment_GeneratedInjector;
import com.findajob.jobamax.jobseeker.coaching.SeekerCoachingFragment_GeneratedInjector;
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeActivity_GeneratedInjector;
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel_HiltModules;
import com.findajob.jobamax.jobseeker.jobsearch.SeekerJobSearchActivity_GeneratedInjector;
import com.findajob.jobamax.jobseeker.jobsearch.SeekerJobsFragment_GeneratedInjector;
import com.findajob.jobamax.jobseeker.profile.SeekerAboutMeFragment_GeneratedInjector;
import com.findajob.jobamax.jobseeker.profile.SeekerAddVolunteeringFragment_GeneratedInjector;
import com.findajob.jobamax.jobseeker.profile.SeekerImportResumeFragment_GeneratedInjector;
import com.findajob.jobamax.jobseeker.profile.SeekerPreviewFragment_GeneratedInjector;
import com.findajob.jobamax.jobseeker.profile.SeekerProfileFragment_GeneratedInjector;
import com.findajob.jobamax.jobseeker.profile.SeekerVolunteeringListFragment_GeneratedInjector;
import com.findajob.jobamax.jobseeker.profile.account.home.JobSeekerAccountFragment_GeneratedInjector;
import com.findajob.jobamax.jobseeker.profile.account.newsletter.JobSeekerNewsletterFragment_GeneratedInjector;
import com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalInformationFragment_GeneratedInjector;
import com.findajob.jobamax.jobseeker.profile.account.pushNotification.JobSeekerPushNotificationFragment_GeneratedInjector;
import com.findajob.jobamax.jobseeker.profile.account.readReceipts.JobSeekerManageReadReceiptsFragment_GeneratedInjector;
import com.findajob.jobamax.jobseeker.track.newtrack.SeekerTrackingJobFragment_GeneratedInjector;
import com.findajob.jobamax.jobseeker.wishlist.SeekerWishListFragment_GeneratedInjector;
import com.findajob.jobamax.login.LoginActivity_GeneratedInjector;
import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_DefaultViewModelFactories_ActivityModule;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ViewModelModule;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.HiltWrapper_ActivityModule;
import dagger.hilt.android.scopes.ActivityRetainedScoped;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.android.scopes.FragmentScoped;
import dagger.hilt.android.scopes.ServiceScoped;
import dagger.hilt.android.scopes.ViewModelScoped;
import dagger.hilt.android.scopes.ViewScoped;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import dagger.hilt.migration.DisableInstallInCheck;
import javax.inject.Singleton;

public final class BaseApplication_HiltComponents {
  private BaseApplication_HiltComponents() {
  }

  @Module(
      subcomponents = ServiceC.class
  )
  @DisableInstallInCheck
  abstract interface ServiceCBuilderModule {
    @Binds
    ServiceComponentBuilder bind(ServiceC.Builder builder);
  }

  @Module(
      subcomponents = ActivityRetainedC.class
  )
  @DisableInstallInCheck
  abstract interface ActivityRetainedCBuilderModule {
    @Binds
    ActivityRetainedComponentBuilder bind(ActivityRetainedC.Builder builder);
  }

  @Module(
      subcomponents = ActivityC.class
  )
  @DisableInstallInCheck
  abstract interface ActivityCBuilderModule {
    @Binds
    ActivityComponentBuilder bind(ActivityC.Builder builder);
  }

  @Module(
      subcomponents = ViewModelC.class
  )
  @DisableInstallInCheck
  abstract interface ViewModelCBuilderModule {
    @Binds
    ViewModelComponentBuilder bind(ViewModelC.Builder builder);
  }

  @Module(
      subcomponents = ViewC.class
  )
  @DisableInstallInCheck
  abstract interface ViewCBuilderModule {
    @Binds
    ViewComponentBuilder bind(ViewC.Builder builder);
  }

  @Module(
      subcomponents = FragmentC.class
  )
  @DisableInstallInCheck
  abstract interface FragmentCBuilderModule {
    @Binds
    FragmentComponentBuilder bind(FragmentC.Builder builder);
  }

  @Module(
      subcomponents = ViewWithFragmentC.class
  )
  @DisableInstallInCheck
  abstract interface ViewWithFragmentCBuilderModule {
    @Binds
    ViewWithFragmentComponentBuilder bind(ViewWithFragmentC.Builder builder);
  }

  @Component(
      modules = {
          ApplicationContextModule.class,
          ActivityRetainedCBuilderModule.class,
          ServiceCBuilderModule.class,
          HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule.class
      }
  )
  @Singleton
  public abstract static class SingletonC implements BaseApplication_GeneratedInjector,
      FragmentGetContextFix.FragmentGetContextFixEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint,
      ServiceComponentManager.ServiceComponentBuilderEntryPoint,
      SingletonComponent,
      GeneratedComponent {
  }

  @Subcomponent
  @ServiceScoped
  public abstract static class ServiceC implements ServiceComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ServiceComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          ActivityCBuilderModule.class,
          ViewModelCBuilderModule.class,
          HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class,
          JobSeekerHomeViewModel_HiltModules.KeyModule.class
      }
  )
  @ActivityRetainedScoped
  public abstract static class ActivityRetainedC implements ActivityRetainedComponent,
      ActivityComponentManager.ActivityComponentBuilderEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityRetainedComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          FragmentCBuilderModule.class,
          ViewCBuilderModule.class,
          HiltWrapper_ActivityModule.class,
          HiltWrapper_DefaultViewModelFactories_ActivityModule.class
      }
  )
  @ActivityScoped
  public abstract static class ActivityC implements MainActivity_GeneratedInjector,
      SplashActivity_GeneratedInjector,
      JobSeekerHomeActivity_GeneratedInjector,
      SeekerJobSearchActivity_GeneratedInjector,
      LoginActivity_GeneratedInjector,
      ActivityComponent,
      DefaultViewModelFactories.ActivityEntryPoint,
      HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint,
      FragmentComponentManager.FragmentComponentBuilderEntryPoint,
      ViewComponentManager.ViewComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          HiltWrapper_HiltViewModelFactory_ViewModelModule.class,
          JobSeekerHomeViewModel_HiltModules.BindsModule.class,
          ViewModelModule.class
      }
  )
  @ViewModelScoped
  public abstract static class ViewModelC implements ViewModelComponent,
      HiltViewModelFactory.ViewModelFactoriesEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewModelComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewC implements ViewComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewComponentBuilder {
    }
  }

  @Subcomponent(
      modules = ViewWithFragmentCBuilderModule.class
  )
  @FragmentScoped
  public abstract static class FragmentC implements SeekerCalenderFragment_GeneratedInjector,
      SeekerCoachingFragment_GeneratedInjector,
      SeekerJobsFragment_GeneratedInjector,
      SeekerAboutMeFragment_GeneratedInjector,
      SeekerAddVolunteeringFragment_GeneratedInjector,
      SeekerImportResumeFragment_GeneratedInjector,
      SeekerPreviewFragment_GeneratedInjector,
      SeekerProfileFragment_GeneratedInjector,
      SeekerVolunteeringListFragment_GeneratedInjector,
      JobSeekerAccountFragment_GeneratedInjector,
      JobSeekerNewsletterFragment_GeneratedInjector,
      JobSeekerPersonalInformationFragment_GeneratedInjector,
      JobSeekerPushNotificationFragment_GeneratedInjector,
      JobSeekerManageReadReceiptsFragment_GeneratedInjector,
      SeekerTrackingJobFragment_GeneratedInjector,
      SeekerWishListFragment_GeneratedInjector,
      FragmentComponent,
      DefaultViewModelFactories.FragmentEntryPoint,
      ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends FragmentComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewWithFragmentC implements ViewWithFragmentComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewWithFragmentComponentBuilder {
    }
  }
}
