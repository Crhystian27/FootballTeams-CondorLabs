package co.condorlabs.androidtechnicaltest;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
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


    private boolean pressMenuItem = false;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (!pressMenuItem) {
            if (item.getItemId() == R.id.SPANISH) {
                pressMenuItem = true;
                getToolbar().setTitle(Constants.SPANISH);
                Utilities.loadFragment(this, new MainFragment(), Constants.Spanish_La_Liga, "league", Constants.TAG_MAIN);
                new Handler().postDelayed(() -> pressMenuItem = false, 400);
            } else if (item.getItemId() == R.id.ENGLISH) {
                pressMenuItem = true;
                getToolbar().setTitle(Constants.ENGLISH);
                Utilities.loadFragment(this, new MainFragment(), Constants.English_Premier_League, "league", Constants.TAG_MAIN);
                new Handler().postDelayed(() -> pressMenuItem = false, 400);
            } else if (item.getItemId() == R.id.ITALIAN) {
                pressMenuItem = true;
                getToolbar().setTitle(Constants.ITALIAN);
                Utilities.loadFragment(this, new MainFragment(), Constants.Italian_Serie_A, "league", Constants.TAG_MAIN);
                new Handler().postDelayed(() -> pressMenuItem = false, 400);
            } else if (item.getItemId() == R.id.FRENCH) {
                pressMenuItem = true;
                getToolbar().setTitle(Constants.FRENCH);
                Utilities.loadFragment(this, new MainFragment(), Constants.French_Ligue_1, "league", Constants.TAG_MAIN);
                new Handler().postDelayed(() -> pressMenuItem = false, 400);
            } else if (item.getItemId() == R.id.GERMAN) {
                pressMenuItem = true;
                getToolbar().setTitle(Constants.GERMAN);
                Utilities.loadFragment(this, new MainFragment(), Constants.German_Bundesliga, "league", Constants.TAG_MAIN);
                new Handler().postDelayed(() -> pressMenuItem = false, 400);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}