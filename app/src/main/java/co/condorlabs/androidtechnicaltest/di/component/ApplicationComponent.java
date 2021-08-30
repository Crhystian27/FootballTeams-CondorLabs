package co.condorlabs.androidtechnicaltest.di.component;


import android.app.Application;

import javax.inject.Singleton;

import co.condorlabs.androidtechnicaltest.base.BaseApplication;
import co.condorlabs.androidtechnicaltest.di.module.ActivityModule;
import co.condorlabs.androidtechnicaltest.di.module.ApplicationModule;
import co.condorlabs.androidtechnicaltest.di.module.DBModule;
import co.condorlabs.androidtechnicaltest.di.module.MainFragmentModule;
import co.condorlabs.androidtechnicaltest.di.module.ViewModelModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

@Singleton
@Component(modules = {
        DBModule.class,
        ActivityModule.class,
        MainFragmentModule.class,
        ViewModelModule.class,
        AndroidSupportInjectionModule.class,
        ApplicationModule.class})

public interface ApplicationComponent extends AndroidInjector<DaggerApplication>  {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }

}
