package co.condorlabs.androidtechnicaltest.base;

import android.content.Context;

import androidx.multidex.MultiDex;

import co.condorlabs.androidtechnicaltest.di.component.ApplicationComponent;
import co.condorlabs.androidtechnicaltest.di.component.DaggerApplicationComponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    private static BaseApplication instance;
    private ApplicationComponent component;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        component = DaggerApplicationComponent.builder().application(this).build();
        component.inject(this);
        return component;
    }

    public static Context getAppContext() {
        return instance;
    }
}
