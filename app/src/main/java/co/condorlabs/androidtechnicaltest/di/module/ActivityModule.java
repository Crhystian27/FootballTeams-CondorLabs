package co.condorlabs.androidtechnicaltest.di.module;

import co.condorlabs.androidtechnicaltest.MainActivity;
import co.condorlabs.androidtechnicaltest.MainDetailActivity;
import co.condorlabs.androidtechnicaltest.SplashScreenActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = {MainFragmentModule.class})
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract SplashScreenActivity contributeSplashScreenActivity();

    @ContributesAndroidInjector
    abstract MainDetailActivity contributeMainDetailActivity();
}
