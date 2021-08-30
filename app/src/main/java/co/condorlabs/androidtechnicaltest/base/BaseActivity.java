package co.condorlabs.androidtechnicaltest.base;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import java.util.Objects;

import co.condorlabs.androidtechnicaltest.R;
import co.condorlabs.androidtechnicaltest.ui.main.MainFragment;
import co.condorlabs.androidtechnicaltest.ui.main.MainViewModel;
import co.condorlabs.androidtechnicaltest.util.Constants;
import co.condorlabs.androidtechnicaltest.util.Utilities;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    private Toolbar toolbar;

    private final int SPANISH = 0;
    private final int ENGLISH = 1;
    private final int ITALIAN = 2;
    private final int FRENCH = 3;
    private final int GERMAN = 4;


    @LayoutRes
    protected abstract int layoutRes();

    protected abstract int toolbarId();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes());
        setToolbar(null);
    }

    public void setToolbar(@Nullable Toolbar toolbar) {
        if (toolbar == null) {
            this.toolbar = findViewById(toolbarId());
        }
        if (this.toolbar != null) {
            setSupportActionBar(this.toolbar);
        }
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    /**
     * Set Support ActionBar
     *
     * @param displayHome  si es true indica que regresa un nivel en la UI
     * @param showIconHome muestra el icono en el toolbar
     */
    public void setSupportActionBar(boolean displayHome, boolean showIconHome) {
        if (toolbar != null) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(displayHome);
            getSupportActionBar().setDisplayShowHomeEnabled(showIconHome);
        }
    }

    /*@Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if (toolbar.getMenu().findItem(SPANISH) == null) {
            toolbar.getMenu().add(0, SPANISH, Menu.CATEGORY_ALTERNATIVE, Constants.SPANISH).setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        }
        if (toolbar.getMenu().findItem(ENGLISH) == null) {
            toolbar.getMenu().add(0, ENGLISH, Menu.CATEGORY_ALTERNATIVE, Constants.ENGLISH).setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        }
        if (toolbar.getMenu().findItem(ITALIAN) == null) {
            toolbar.getMenu().add(0, ITALIAN, Menu.CATEGORY_ALTERNATIVE, Constants.ITALIAN).setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        }
        if (toolbar.getMenu().findItem(FRENCH) == null) {
            toolbar.getMenu().add(0, FRENCH, Menu.CATEGORY_ALTERNATIVE, Constants.FRENCH).setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        }
        if (toolbar.getMenu().findItem(GERMAN) == null) {
            toolbar.getMenu().add(0, GERMAN, Menu.CATEGORY_ALTERNATIVE, Constants.GERMAN).setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
        }

        return super.onPrepareOptionsMenu(menu);
    }*/

    //private boolean pressMenuItem = false;

    /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (!pressMenuItem) {
            if (item.getItemId() == SPANISH) {
                pressMenuItem = true;
                getToolbar().setTitle(Constants.SPANISH);
                Utilities.loadFragment(FragmentActivityId(), new MainFragment(), Constants.Spanish_La_Liga, "league", Constants.TAG_MAIN);
                new Handler().postDelayed(() -> pressMenuItem = false, 400);
            } else if (item.getItemId() == ENGLISH) {
                pressMenuItem = true;
                getToolbar().setTitle(Constants.ENGLISH);
                Utilities.loadFragment(FragmentActivityId(), new MainFragment(), Constants.English_Premier_League, "league", Constants.TAG_MAIN);
                new Handler().postDelayed(() -> pressMenuItem = false, 400);
            } else if (item.getItemId() == ITALIAN) {
                pressMenuItem = true;
                getToolbar().setTitle(Constants.ITALIAN);
                Utilities.loadFragment(FragmentActivityId(), new MainFragment(), Constants.Italian_Serie_A, "league", Constants.TAG_MAIN);
                new Handler().postDelayed(() -> pressMenuItem = false, 400);
            } else if (item.getItemId() == FRENCH) {
                pressMenuItem = true;
                getToolbar().setTitle(Constants.FRENCH);
                Utilities.loadFragment(FragmentActivityId(), new MainFragment(), Constants.French_Ligue_1, "league", Constants.TAG_MAIN);
                new Handler().postDelayed(() -> pressMenuItem = false, 400);
            } else if (item.getItemId() == GERMAN) {
                pressMenuItem = true;
                getToolbar().setTitle(Constants.GERMAN);
                Utilities.loadFragment(FragmentActivityId(), new MainFragment(), Constants.German_Bundesliga, "league", Constants.TAG_MAIN);
                new Handler().postDelayed(() -> pressMenuItem = false, 400);
            }
        }
        return super.onOptionsItemSelected(item);
    } */

    @Override
    protected void onResume() {
        super.onResume();

        //InternetConnection.getAirPlaneMode();
        //InternetConnection.getConnection();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
