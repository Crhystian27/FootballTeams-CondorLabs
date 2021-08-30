package co.condorlabs.androidtechnicaltest.rest;

import java.util.List;

import co.condorlabs.androidtechnicaltest.data.dto.ResultResponse;
import co.condorlabs.androidtechnicaltest.data.dto.TeamResponse;
import co.condorlabs.androidtechnicaltest.data.entity.Result;
import co.condorlabs.androidtechnicaltest.data.entity.Team;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api/v1/json/1/lookup_all_teams.php")
    Single<TeamResponse> getTeams(@Query("id") String idLeague);

    @GET("api/v1/json/1/eventslast.php")
    Single<ResultResponse> getResults(@Query("id") String idTeam);
}
