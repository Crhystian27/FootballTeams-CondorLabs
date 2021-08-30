package co.condorlabs.androidtechnicaltest.util;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import co.condorlabs.androidtechnicaltest.R;
import co.condorlabs.androidtechnicaltest.data.entity.Team;

public class Utilities {

    public static void loadGlide(AppCompatActivity activity, String url, ImageView imageView, int drawable) {

        Glide.with(activity.getApplicationContext())
                .applyDefaultRequestOptions(RequestOptions.placeholderOf(activity.getDrawable(drawable)).error(activity.getDrawable(drawable)))
                .load(url).into(imageView);
        

    }

    public static void loadFragment(FragmentActivity fragmentActivity, Fragment fragment, String value, String key, String TAG) {
        FragmentTransaction transaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString(key, value);
        fragment.setArguments(bundle);
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_out, android.R.anim.fade_in);
        transaction.replace(R.id.main_host_fragment, fragment);
        transaction.addToBackStack(TAG);
        transaction.commit();
    }

    public static void hideSystemUI(FragmentActivity fragmentActivity) {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = fragmentActivity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
        );
    }
}
