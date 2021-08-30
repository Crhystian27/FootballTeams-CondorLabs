package co.condorlabs.androidtechnicaltest.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import co.condorlabs.androidtechnicaltest.di.key.ViewModelKey;
import co.condorlabs.androidtechnicaltest.ui.main.MainViewModel;
import co.condorlabs.androidtechnicaltest.util.ViewModelFactory;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel viewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);



}
