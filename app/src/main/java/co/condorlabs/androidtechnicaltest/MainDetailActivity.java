package co.condorlabs.androidtechnicaltest;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import co.condorlabs.androidtechnicaltest.adapter.ResultsAdapter;
import co.condorlabs.androidtechnicaltest.base.BaseActivity;
import co.condorlabs.androidtechnicaltest.data.entity.Result;
import co.condorlabs.androidtechnicaltest.data.entity.Team;
import co.condorlabs.androidtechnicaltest.ui.main.MainViewModel;
import co.condorlabs.androidtechnicaltest.util.Utilities;

public class MainDetailActivity extends BaseActivity {

    private static final String TAG = ":::DetailFragment";

    private boolean pressMenuItem = false;

    @Inject
    ViewModelProvider.Factory factory;
    MainViewModel viewModel;

    Team team;
    CoordinatorLayout coordinatorLayout;

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

        coordinatorLayout = findViewById(R.id.CoordinatorLayoutMainDetail);

        TextView detailTitle = findViewById(R.id.title);
        TextView detailDescription = findViewById(R.id.body);
        TextView detailWebsite = findViewById(R.id.webSite);

        ImageView detailBanner = findViewById(R.id.imageViewTeamBanner);
        ImageView detailBadge = findViewById(R.id.imageViewBadge);
        ImageView detailJersey = findViewById(R.id.imageViewTeamJersey);
        ImageView detailFacebook = findViewById(R.id.imageViewFacebook);
        ImageView detailInstagram = findViewById(R.id.imageViewInstagram);
        ImageView detailYouTube = findViewById(R.id.imageViewYouTube);
        ImageView detailTwitter = findViewById(R.id.imageViewTwitter);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            team = new Gson().fromJson(bundle.getString("detail"), Team.class);

            getToolbar().setTitle(team.getStrTeam());

            String subTitle = team.getStrCountry() + " - " + team.getIntFormedYear();
            detailTitle.setText(subTitle);
            detailDescription.setText(team.getStrDescriptionEN());
            detailWebsite.setText(team.getStrWebsite() != null ? team.getStrWebsite() : " - ");

            Utilities.loadGlide(this, team.getStrStadiumThumb(), detailBanner, R.drawable.ic_error);
            Utilities.loadGlide(this, team.getStrTeamBadge(), detailBadge, R.drawable.ic_error2);
            Utilities.loadGlide(this, team.getStrTeamJersey(), detailJersey, R.drawable.ic_error2);

            detailFacebook.setOnClickListener(facebook -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + team.getStrFacebook()))));

            detailInstagram.setOnClickListener(instagram -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + team.getStrInstagram()))));

            detailYouTube.setOnClickListener(youtube -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + team.getStrYoutube()))));

            detailTwitter.setOnClickListener(twitter -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + team.getStrTwitter()))));
        }else {
            Log.e(TAG,"Bundle Empty");
        }
    }

    public void loadResult(Team team, List<Result> list) {

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;

        String stringTitle = team.getStrTeam() + " Matches";

        Dialog dialog = new Dialog(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_result, coordinatorLayout, false);
        dialog.setContentView(view);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);

        RecyclerView recyclerDialog = view.findViewById(R.id.dialogRecyclerView);
        ImageView cancel = view.findViewById(R.id.dialog_cancel);
        TextView title = view.findViewById(R.id.title);

        recyclerDialog.setHasFixedSize(true);
        recyclerDialog.setLayoutManager(new LinearLayoutManager(this));
        recyclerDialog.setItemAnimator(new DefaultItemAnimator());

        ResultsAdapter adapter = new ResultsAdapter(list);
        recyclerDialog.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        cancel.setOnClickListener(v1 -> dialog.dismiss());
        title.setText(stringTitle);

        dialog.getWindow().setLayout((36 * width) / 40, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (!pressMenuItem) {
            if (item.getItemId() == R.id.events) {
                pressMenuItem = true;

                viewModel.getResultInternet(team.getIdTeam()).observe(this, response0 -> {
                    if (response0 != null) {
                        loadResult(team, response0.getResults());
                        try {
                            if (viewModel.saveResultDB(response0.getResults())) {
                                Log.e(TAG, "Saved Result");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        viewModel.getResultDB(team.getIdTeam()).observe(this, response1 -> {
                            if (response1 != null) {
                                loadResult(team, response1);
                            }
                        });
                    }

                });
                new Handler().postDelayed(() -> pressMenuItem = false, 400);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}