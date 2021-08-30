package co.condorlabs.androidtechnicaltest;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import javax.inject.Inject;

import co.condorlabs.androidtechnicaltest.base.BaseActivity;
import co.condorlabs.androidtechnicaltest.ui.main.MainViewModel;
import co.condorlabs.androidtechnicaltest.util.Constants;
import co.condorlabs.androidtechnicaltest.util.Utilities;

public class SplashScreenActivity extends BaseActivity {

    private static final String TAG = ":::Splash";

    @Inject
    ViewModelProvider.Factory factory;
    MainViewModel viewModel;


    @Override
    protected int layoutRes() {
        return R.layout.activity_splash_screen;
    }

    @Override
    protected int toolbarId() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(getViewModelStore(), factory).get(MainViewModel.class);
        Utilities.hideSystemUI(this);

        viewModel.getTeamInternet(Constants.Spanish_La_Liga).observe(this, teamResponse -> {
            if (teamResponse != null) {

                try {
                    if (viewModel.saveTeamDB(teamResponse.getTeams())) {
                        Log.e(TAG, "Saved Team");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                Log.e(TAG,"Data cannot be obtained");
            }
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }, 2000);
        });
    }
}