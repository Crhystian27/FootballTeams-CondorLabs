package co.condorlabs.androidtechnicaltest.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import co.condorlabs.androidtechnicaltest.MainDetailActivity;
import co.condorlabs.androidtechnicaltest.R;
import co.condorlabs.androidtechnicaltest.data.entity.Team;
import co.condorlabs.androidtechnicaltest.util.Utilities;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> implements Filterable {

    private final AppCompatActivity activity;
    private final List<? extends Team> dtoList;
    private List<? extends Team> filteredList;

    public TeamsAdapter(AppCompatActivity activity, List<? extends Team> dtoList) {
        this.activity = activity;
        this.dtoList = dtoList;
        this.filteredList = dtoList;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String searchString = charSequence.toString();
                if (searchString.isEmpty()) {
                    filteredList = dtoList; //RestoreList
                } else {
                    List<Team> resultList = new ArrayList<>();
                    for (Team team : dtoList) {
                        if (team.getStrTeam().toLowerCase().toLowerCase().contains(searchString.toLowerCase())) {
                            resultList.add(team);
                        }
                    }
                    filteredList = resultList;
                }
                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredList = (List<? extends Team>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_team, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Team team = filteredList.get(position);
        holder.param0.setText(team.getStrTeam());
        holder.param1.setText(team.getStrStadiumLocation());
        holder.param2.setText(team.getStrStadium());

        Utilities.loadGlide(activity, team.getStrStadiumThumb(), holder.imgStadium, R.drawable.ic_error);
        Utilities.loadGlide(activity, team.getStrTeamBadge(), holder.imgTeamBadge, R.drawable.ic_error2);

        holder.imgTeamBadge.setOnClickListener(v -> {

            Intent intent = new Intent(activity, MainDetailActivity.class);
            intent.putExtra("detail",new Gson().toJson(team));
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return filteredList != null ? filteredList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView param0, param1, param2;
        private final ImageView imgStadium, imgTeamBadge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            param0 = itemView.findViewById(R.id.param0);
            param1 = itemView.findViewById(R.id.param1);
            param2 = itemView.findViewById(R.id.param2);
            imgStadium = itemView.findViewById(R.id.imageViewStadium);
            imgTeamBadge = itemView.findViewById(R.id.imageViewTeamBadge);
        }
    }
}
