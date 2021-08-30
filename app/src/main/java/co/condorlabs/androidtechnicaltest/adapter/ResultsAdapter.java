package co.condorlabs.androidtechnicaltest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.condorlabs.androidtechnicaltest.R;
import co.condorlabs.androidtechnicaltest.data.entity.Result;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolder> {

    private final List<? extends Result> dtoList;

    public ResultsAdapter(List<? extends Result> dtoList) {
        this.dtoList = dtoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_result, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result result = dtoList.get(position);
        holder.param0.setText(result.getStrEvent());
        holder.param2.setText(result.getStrLeague());

    }

    @Override
    public int getItemCount() {
        return dtoList != null ? dtoList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView param0, param2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            param0 = itemView.findViewById(R.id.versusTeam);
            param2 = itemView.findViewById(R.id.leagueTeam);

        }
    }
}
