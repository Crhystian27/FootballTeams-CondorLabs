package co.condorlabs.androidtechnicaltest.di.module;

import co.condorlabs.androidtechnicaltest.ui.main.MainFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentModule {

    @ContributesAndroidInjector
    abstract MainFragment contributeMainFragment();


}
