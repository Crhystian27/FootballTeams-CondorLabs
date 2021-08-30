package co.condorlabs.androidtechnicaltest;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import javax.inject.Inject;

import co.condorlabs.androidtechnicaltest.base.BaseActivity;
import co.condorlabs.androidtechnicaltest.data.entity.Team;
import co.condorlabs.androidtechnicaltest.ui.main.MainViewModel;
import co.condorlabs.androidtechnicaltest.util.Utilities;

public class MainDetailActivity extends BaseActivity {

    private static final String TAG = ":::DetailFragment";

    @Inject
    ViewModelProvider.Factory factory;
    MainViewModel viewModel;

    private TextView detailTitle, detailDescription, detailWebsite;
    private ImageView detailBadge, detailJersey, detailBanner, detailFacebook, detailYouTube, detailInstagram, detailTwitter;


    @Override
    protected FragmentActivity FragmentActivityId() {
        return MainDetailActivity.this;
    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_main_detail;
    }

    @Override
    protected int toolbarId() {
        return R.id.toolbar_material;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(getViewModelStore(), factory).get(MainViewModel.class);

        setSupportActionBar(false, false);

        detailTitle = findViewById(R.id.title);
        detailDescription = findViewById(R.id.body);
        detailWebsite = findViewById(R.id.webSite);

        detailBanner = findViewById(R.id.imageViewTeamBanner);
        detailBadge = findViewById(R.id.imageViewBadge);
        detailJersey = findViewById(R.id.imageViewTeamJersey);
        detailFacebook = findViewById(R.id.imageViewFacebook);
        detailInstagram = findViewById(R.id.imageViewInstagram);
        detailYouTube = findViewById(R.id.imageViewYouTube);
        detailTwitter = findViewById(R.id.imageViewTwitter);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Team team = new Gson().fromJson(bundle.getString("detail"), Team.class);

            getToolbar().setTitle(team.getStrTeam());


            String subTitle = team.getStrCountry() + " - " + team.getIntFormedYear();
            detailTitle.setText(subTitle);
            detailDescription.setText(team.getStrDescriptionEN());
            detailWebsite.setText(team.getStrWebsite() != null ? team.getStrWebsite() : " - ");

            Utilities.loadGlide(this, team.getStrStadiumThumb(), detailBanner, R.drawable.ic_error);
            Utilities.loadGlide(this, team.getStrTeamBadge(), detailBadge, R.drawable.ic_error2);
            Utilities.loadGlide(this, team.getStrTeamJersey(), detailJersey, R.drawable.ic_error2);

            detailFacebook.setOnClickListener(facebook -> {
                Intent intentFacebook = new Intent(Intent.ACTION_VIEW);
                intentFacebook.setData(Uri.parse(team.getStrFacebook()));
                startActivity(intentFacebook);
            });

            detailInstagram.setOnClickListener(instagram -> {
                Intent intentInstagram = new Intent(Intent.ACTION_VIEW);
                intentInstagram.setData(Uri.parse(team.getStrInstagram()));
                startActivity(intentInstagram);
            });

            detailYouTube.setOnClickListener(youtube -> {
                Intent intentYoutube = new Intent(Intent.ACTION_VIEW);
                intentYoutube.setData(Uri.parse(team.getStrYoutube()));
                startActivity(intentYoutube);
            });

            detailTwitter.setOnClickListener(twitter -> {
                Intent intentTwitter = new Intent(Intent.ACTION_VIEW);
                intentTwitter.setData(Uri.parse(team.getStrTwitter()));
                startActivity(intentTwitter);
            });


        }

    }
}