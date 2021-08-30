package co.condorlabs.androidtechnicaltest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import co.condorlabs.androidtechnicaltest.base.BaseActivity;
import co.condorlabs.androidtechnicaltest.ui.main.MainFragment;
import co.condorlabs.androidtechnicaltest.ui.main.MainViewModel;
import co.condorlabs.androidtechnicaltest.util.Constants;
import co.condorlabs.androidtechnicaltest.util.Utilities;

public class MainActivity extends BaseActivity {

    @Override
    protected FragmentActivity FragmentActivityId() {
        return MainActivity.this;
    }

    @Override
    protected int layoutRes() {
        return R.layout.main_activity;
    }

    @Override
    protected int toolbarId() {
        return R.id.toolbar_material;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getToolbar().setTitle(Constants.SPANISH);
        setSupportActionBar(false, true);
        Utilities.loadFragment(this, new MainFragment(), Constants.Spanish_La_Liga, "league",Constants.TAG_MAIN);
    }
}