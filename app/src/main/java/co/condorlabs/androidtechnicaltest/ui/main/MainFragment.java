package co.condorlabs.androidtechnicaltest.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import co.condorlabs.androidtechnicaltest.R;
import co.condorlabs.androidtechnicaltest.adapter.TeamsAdapter;
import co.condorlabs.androidtechnicaltest.base.BaseFragment;
import co.condorlabs.androidtechnicaltest.data.entity.Team;

public class MainFragment extends BaseFragment {

    private static final String TAG = ":::MainFragment";

    @Inject
    ViewModelProvider.Factory factory;
    MainViewModel viewModel;


    @Override
    protected int layoutRes() {
        return R.layout.main_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(getViewModelStore(), factory).get(MainViewModel.class);


        Bundle bundle = getArguments();
        if (bundle != null) {
            viewModel.getTeamInternet(bundle.getString("league")).observe(getViewLifecycleOwner(), response0 -> {
                if (response0 != null) {
                    loadRecyclerView(view, response0.getTeams());
                    try {
                        if (viewModel.saveTeamDB(response0.getTeams())) {
                            Log.e(TAG, "Saved Team");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    viewModel.getTeamDB(bundle.getString("league")).observe(getViewLifecycleOwner(), response1 -> {
                        if (response1 != null) {
                            loadRecyclerView(view, response1);
                        }
                    });
                }
            });
        }
    }

    private void loadRecyclerView(View view, List<Team> list) {
        RecyclerView recyclerView = view.findViewById(R.id.teamRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        TeamsAdapter adapter = new TeamsAdapter(activity, list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}